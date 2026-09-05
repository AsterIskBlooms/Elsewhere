package team.lookingglass.elsewhere.registry.blocktypes;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SpikeBlock extends PointedDripstoneBlock {

    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
    private static final int DELAY_BEFORE_FALLING = 2;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02F;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12F;
    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
    private static final float WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.17578125F;
    private static final float LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.05859375F;
    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE = 0.6D;
    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778F;
    private static final int MAX_GROWTH_LENGTH = 7;
    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.column(4.0F, 0.0F, 16.0F);

    private final Block baseBlock;
    private final double damage;
    private final SoundEvent landSound;
    private final boolean allowsLavaFarming;
    private final float stalagmiteGrowthChance;

    public SpikeBlock(Block baseBlock, double damage, SoundEvent landSound, boolean allowsLavaFarming, float stalagmiteGrowthChance, Properties properties) {
        super(properties);
        this.baseBlock = baseBlock;
        this.damage = damage;
        this.landSound = landSound;
        this.allowsLavaFarming = allowsLavaFarming;
        this.stalagmiteGrowthChance = stalagmiteGrowthChance;
    }

    private boolean isSpike(BlockState state) {
        return state.getBlock() instanceof SpikeBlock;
    }

    private boolean isSpikeWithDirection(BlockState state, Direction direction) {
        return isSpike(state) && state.getValue(BlockStateProperties.VERTICAL_DIRECTION) == direction;
    }

    private static boolean isTip(BlockState state, boolean includeMergedTip) {
        if (!(state.getBlock() instanceof SpikeBlock)) return false;
        DripstoneThickness thickness = state.getValue(BlockStateProperties.DRIPSTONE_THICKNESS);
        return thickness == DripstoneThickness.TIP || (includeMergedTip && thickness == DripstoneThickness.TIP_MERGE);
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axisDirection,
                                                        BiPredicate<BlockPos, BlockState> continuePredicate, Predicate<BlockState> stopPredicate, int maxSearchLength) {
        Direction direction = Direction.get(axisDirection, Direction.Axis.Y);
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        for (int i = 1; i < maxSearchLength; ++i) {
            mutableBlockPos.move(direction);
            BlockState blockState = level.getBlockState(mutableBlockPos);

            if (stopPredicate.test(blockState)) return Optional.of(mutableBlockPos.immutable());
            if (level.isOutsideBuildHeight(mutableBlockPos.getY()) || !continuePredicate.test(mutableBlockPos, blockState))
                return Optional.empty();
        }

        return Optional.empty();
    }

    private Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState state, int maxSearchLength) {
        Direction direction = state.getValue(BlockStateProperties.VERTICAL_DIRECTION);
        BiPredicate<BlockPos, BlockState> predicate = (p, s) -> isSpikeWithDirection(s, direction);
        return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), predicate, s -> !isSpike(s), maxSearchLength);
    }

    private @Nullable BlockPos findTip(BlockState state, LevelAccessor level, BlockPos pos, int maxSearchLength, boolean includeMergedTip) {
        if (isTip(state, includeMergedTip)) return pos;

        Direction direction = state.getValue(BlockStateProperties.VERTICAL_DIRECTION);
        BiPredicate<BlockPos, BlockState> predicate = (p, s) -> isSpikeWithDirection(s, direction);
        return findBlockVertical(level, pos, direction.getAxisDirection(), predicate, s -> isTip(s, includeMergedTip), maxSearchLength).orElse(null);
    }

    private boolean canGrow(BlockState rootState, BlockState aboveState) {
        FluidState fluidState = aboveState.getFluidState();
        return rootState.is(baseBlock) && fluidState.is(Fluids.WATER) && fluidState.isSource();
    }

    private boolean canPlaceAtWithDirection(LevelReader level, BlockPos pos, Direction direction) {
        BlockPos neighborPos = pos.relative(direction.getOpposite());
        BlockState neighborState = level.getBlockState(neighborPos);
        return neighborState.isFaceSturdy(level, neighborPos, direction) || isSpikeWithDirection(neighborState, direction);
    }

    private DripstoneThickness calculateThickness(LevelReader level, BlockPos pos, Direction dir, boolean merge) {
        Direction opposite = dir.getOpposite();
        BlockState inFront = level.getBlockState(pos.relative(dir));

        if (isSpikeWithDirection(inFront, opposite)) {
            return !merge && inFront.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isSpikeWithDirection(inFront, dir)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness inFrontThick = inFront.getValue(THICKNESS);

            if (inFrontThick != DripstoneThickness.TIP && inFrontThick != DripstoneThickness.TIP_MERGE) {
                BlockState behind = level.getBlockState(pos.relative(opposite));
                return !isSpikeWithDirection(behind, dir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    private Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction defaultDir) {
        if (isValidPlacement(level, pos, defaultDir)) return defaultDir;
        if (isValidPlacement(level, pos, defaultDir.getOpposite())) return defaultDir.getOpposite();
        return null;
    }

    public boolean isValidPlacement(LevelReader level, BlockPos pos, Direction tipDirection) {
        BlockPos supportPos = pos.relative(tipDirection.getOpposite());
        BlockState supportState = level.getBlockState(supportPos);
        if (supportState.isFaceSturdy(level, supportPos, tipDirection)) return true;
        return supportState.getBlock() instanceof SpikeBlock && supportState.getValue(TIP_DIRECTION) == tipDirection;
    }

    private boolean isStalactite(BlockState state) {
        return isSpikeWithDirection(state, Direction.DOWN);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return isValidPlacement(level, pos, state.getValue(TIP_DIRECTION));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (directionToNeighbour != Direction.UP && directionToNeighbour != Direction.DOWN) return state;

        Direction tipDirection = state.getValue(TIP_DIRECTION);
        if (tipDirection == Direction.DOWN && ticks.getBlockTicks().hasScheduledTick(pos, this)) return state;

        if (directionToNeighbour == tipDirection.getOpposite() && !this.canSurvive(state, level, pos)) {
            ticks.scheduleTick(pos, this, tipDirection == Direction.DOWN ? DELAY_BEFORE_FALLING : 1);
            return state;
        }

        boolean mergeOpposingTips = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
        return state.setValue(THICKNESS, calculateThickness(level, pos, tipDirection, mergeOpposingTips));
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult blockHit, Projectile projectile) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            BlockPos blockPos = blockHit.getBlockPos();

            if (projectile.mayInteract(serverLevel, blockPos)
                    && projectile.mayBreak(serverLevel)
                    && projectile instanceof ThrownTrident
                    && projectile.getDeltaMovement().length() > MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE) {
                level.destroyBlock(blockPos, true);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction defaultDir = context.getNearestLookingVerticalDirection().getOpposite();

        Direction tipDir = calculateTipDirection(level, pos, defaultDir);
        if (tipDir == null) return null;

        boolean merge = !context.isSecondaryUseActive();

        return this.defaultBlockState()
                .setValue(TIP_DIRECTION, tipDir)
                .setValue(THICKNESS, calculateThickness(level, pos, tipDir, merge))
                .setValue(WATERLOGGED, level.getFluidState(pos).is(Fluids.WATER));
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
            entity.causeFallDamage(fallDistance + 2.5F, (float)damage, level.damageSources().stalagmite());
        } else {
            super.fallOn(level, state, pos, entity, fallDistance);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (!canDrip(state)) return;

        float randomValue = random.nextFloat();

        if (!(randomValue > DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE)) {
            getFluidAbove(level, pos, state)
                    .filter(info -> (info.fluid == Fluids.LAVA && allowsLavaFarming)
                            || (info.fluid != Fluids.LAVA && randomValue < DRIP_PROBABILITY_PER_ANIMATE_TICK))
                    .ifPresent(info -> spawnDripParticle(level, pos, state, info.fluid, info.pos()));
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        maybeTransferFluid(state, level, pos, random.nextFloat(), this);

        if (random.nextFloat() < GROWTH_PROBABILITY_PER_RANDOM_TICK && isStalactiteStartPos(state, level, pos)) {
            growStalactiteOrStalagmiteIfPossible(state, level, pos, random);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canSurvive(state, level, pos)) {
            if (isStalactite(state)) spawnFallingStalactite(state, level, pos);
            else level.destroyBlock(pos, true);
        } else {
            super.tick(state, level, pos, random);
        }
    }

    private void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (BlockState currentState = state; isStalactite(currentState); currentState = level.getBlockState(mutablePos)) {
            FallingBlockEntity entity = FallingBlockEntity.fall(level, mutablePos, currentState);

            if (isTip(currentState, true)) {
                int height = Math.max(1 + pos.getY() - mutablePos.getY(), 6);
                entity.setHurtsEntities(0.5F * height * (float)damage, 20);
                break;
            }

            mutablePos.move(Direction.DOWN);
        }
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity entity) {
        if (!entity.isSilent()) {
            level.playSound(null, pos, landSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    public static boolean canDrip(BlockState state) {
        return state.getBlock() instanceof SpikeBlock
                && state.getValue(TIP_DIRECTION) == Direction.DOWN
                && state.getValue(THICKNESS) == DripstoneThickness.TIP
                && !state.getValue(WATERLOGGED);
    }

    private static boolean isUnmergedTipWithDirection(BlockState state, Direction direction) {
        return isTip(state, false) && state.getValue(TIP_DIRECTION) == direction;
    }

    private static boolean canTipGrow(BlockState tipState, ServerLevel level, BlockPos tipPos) {
        Direction growDirection = tipState.getValue(TIP_DIRECTION);
        BlockPos growPos = tipPos.relative(growDirection);
        BlockState stateAtGrowPos = level.getBlockState(growPos);

        if (!stateAtGrowPos.getFluidState().isEmpty()) return false;

        return stateAtGrowPos.isAir() || isUnmergedTipWithDirection(stateAtGrowPos, growDirection.getOpposite());
    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState stalactiteStartState, ServerLevel level,
                                                            BlockPos stalactiteStartPos, RandomSource random) {
        SpikeBlock spike = (SpikeBlock)stalactiteStartState.getBlock();

        BlockState rootState = level.getBlockState(stalactiteStartPos.above(1));
        BlockState stateAbove = level.getBlockState(stalactiteStartPos.above(2));

        if (!spike.canGrow(rootState, stateAbove)) return;

        BlockPos stalactiteTipPos = spike.findTip(stalactiteStartState, level, stalactiteStartPos, MAX_GROWTH_LENGTH, false);
        if (stalactiteTipPos == null) return;

        BlockState stalactiteTipState = level.getBlockState(stalactiteTipPos);
        if (!canDrip(stalactiteTipState) || !canTipGrow(stalactiteTipState, level, stalactiteTipPos)) return;

        if (random.nextFloat() < spike.stalagmiteGrowthChance) {
            growStalagmiteBelow(level, stalactiteTipPos, spike);
        } else {
            grow(level, stalactiteTipPos, Direction.DOWN, spike);
        }
    }

    private static void growStalagmiteBelow(ServerLevel level, BlockPos posAboveStalagmite, SpikeBlock spike) {
        BlockPos.MutableBlockPos pos = posAboveStalagmite.mutable();

        for (int i = 0; i < MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING; ++i) {
            pos.move(Direction.DOWN);
            BlockState state = level.getBlockState(pos);

            if (!state.getFluidState().isEmpty()) return;

            if (isUnmergedTipWithDirection(state, Direction.UP) && canTipGrow(state, level, pos)) {
                grow(level, pos, Direction.UP, spike);
                return;
            }

            if (spike.isValidPlacement(level, pos, Direction.UP) && !level.isWaterAt(pos.below())) {
                grow(level, pos.below(), Direction.UP, spike);
                return;
            }

            if (!canDripThrough(level, pos, state)) return;
        }
    }

    private static void grow(ServerLevel level, BlockPos growFromPos, Direction growToDirection, SpikeBlock spike) {
        BlockPos targetPos = growFromPos.relative(growToDirection);
        BlockState existingStateAtTargetPos = level.getBlockState(targetPos);

        if (isUnmergedTipWithDirection(existingStateAtTargetPos, growToDirection.getOpposite())) {
            createMergedTips(existingStateAtTargetPos, level, targetPos, spike);
        } else if (existingStateAtTargetPos.isAir() || existingStateAtTargetPos.is(Blocks.WATER)) {
            createDripstone(level, targetPos, growToDirection, DripstoneThickness.TIP, spike);
        }
    }

    private static void createDripstone(LevelAccessor level, BlockPos pos, Direction direction, DripstoneThickness thickness, SpikeBlock spike) {
        BlockState state = spike.defaultBlockState()
                .setValue(TIP_DIRECTION, direction)
                .setValue(THICKNESS, thickness)
                .setValue(WATERLOGGED, level.getFluidState(pos).is(Fluids.WATER));

        level.setBlock(pos, state, 3);
    }

    private static void createMergedTips(BlockState tipState, LevelAccessor level, BlockPos tipPos, SpikeBlock spike) {
        BlockPos stalactitePos;
        BlockPos stalagmitePos;

        if (tipState.getValue(TIP_DIRECTION) == Direction.UP) {
            stalagmitePos = tipPos;
            stalactitePos = tipPos.above();
        } else {
            stalactitePos = tipPos;
            stalagmitePos = tipPos.below();
        }

        createDripstone((ServerLevel)level, stalactitePos, Direction.DOWN, DripstoneThickness.TIP_MERGE, spike);
        createDripstone((ServerLevel)level, stalagmitePos, Direction.UP, DripstoneThickness.TIP_MERGE, spike);
    }

    private static void maybeTransferFluid(BlockState state, ServerLevel level, BlockPos pos, float randomValue, SpikeBlock spike) {
        if (randomValue > WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK) return;

        if (!isStalactiteStartPos(state, level, pos)) return;

        Optional<FluidInfo> fluidInfo = getFluidAbove(level, pos, state);
        if (fluidInfo.isEmpty()) return;

        Fluid fluid = fluidInfo.get().fluid;
        float transferProbability;

        if (fluid == Fluids.WATER) {
            transferProbability = WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK;
        } else if (fluid == Fluids.LAVA && spike.allowsLavaFarming) {
            transferProbability = LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK;
        } else {
            return;
        }

        if (randomValue >= transferProbability) return;

        BlockPos stalactiteTipPos = spike.findTip(state, level, pos, MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE, false);
        if (stalactiteTipPos == null) return;

        if (fluidInfo.get().sourceState().is(Blocks.MUD) && fluid == Fluids.WATER) {
            BlockState newState = Blocks.CLAY.defaultBlockState();
            level.setBlockAndUpdate(fluidInfo.get().pos(), newState);
            Block.pushEntitiesUp(fluidInfo.get().sourceState(), newState, level, fluidInfo.get().pos());
            level.gameEvent(GameEvent.BLOCK_CHANGE, fluidInfo.get().pos(), GameEvent.Context.of(newState));
            level.levelEvent(1504, stalactiteTipPos, 0);
            return;
        }

        BlockPos cauldronPos = spike.findFillableCauldronBelowStalactiteTip(level, stalactiteTipPos, fluid);
        if (cauldronPos == null) return;

        level.levelEvent(1504, stalactiteTipPos, 0);

        int fallDistance = stalactiteTipPos.getY() - cauldronPos.getY();
        int delay = 50 + fallDistance;

        BlockState cauldronState = level.getBlockState(cauldronPos);
        level.scheduleTick(cauldronPos, cauldronState.getBlock(), delay);
    }

    private static Optional<FluidInfo> getFluidAbove(Level level, BlockPos spikePos, BlockState spikeState) {
        SpikeBlock spike = (SpikeBlock)spikeState.getBlock();

        if (!spike.isStalactite(spikeState)) return Optional.empty();

        return spike.findRootBlock(level, spikePos, spikeState, MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE).map(rootPos -> {
            BlockPos abovePos = rootPos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            Fluid fluid;
            if (aboveState.is(Blocks.MUD) && !(Boolean)level.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, abovePos)) {
                fluid = Fluids.WATER;
            } else {
                fluid = level.getFluidState(abovePos).getType();
            }

            return new FluidInfo(abovePos, fluid, aboveState);
        });
    }

    private boolean canFillCauldron(Fluid fluid) {
        return fluid == Fluids.WATER || fluid == Fluids.LAVA && allowsLavaFarming;
    }

    private BlockPos findFillableCauldronBelowStalactiteTip(Level level, BlockPos tipPos, Fluid fluid) {
        if (!canFillCauldron(fluid)) return null;

        Predicate<BlockState> cauldronPredicate = state ->
                state.getBlock() instanceof AbstractCauldronBlock
                        && ((AbstractCauldronBlock)state.getBlock()).canReceiveStalactiteDrip(fluid);

        BiPredicate<BlockPos, BlockState> pathPredicate = (p, s) -> canDripThrough(level, p, s);

        return findBlockVertical(level, tipPos, Direction.DOWN.getAxisDirection(), pathPredicate,
                cauldronPredicate, MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON).orElse(null);
    }

    private static boolean isStalactiteStartPos(BlockState state, LevelReader level, BlockPos pos) {
        return state.getBlock() instanceof SpikeBlock
                && state.getValue(TIP_DIRECTION) == Direction.DOWN
                && !level.getBlockState(pos.above()).getBlock().equals(state.getBlock());
    }

    private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
        if (state.isAir()) return true;
        if (state.isSolidRender()) return false;
        if (!state.getFluidState().isEmpty()) return false;

        VoxelShape collisionShape = state.getCollisionShape(level, pos);
        return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, collisionShape, BooleanOp.AND);
    }

    private static ParticleOptions getDripParticle(Level level, Fluid fluidAbove, BlockPos posAbove) {
        if (fluidAbove.isSame(Fluids.EMPTY)) {
            return level.environmentAttributes().getValue(EnvironmentAttributes.DEFAULT_DRIPSTONE_PARTICLE, posAbove);
        }

        return fluidAbove.isSame(Fluids.LAVA)
                ? ParticleTypes.DRIPPING_DRIPSTONE_LAVA
                : ParticleTypes.DRIPPING_DRIPSTONE_WATER;
    }

    public static void spawnDripParticle(Level level, BlockPos stalactiteTipPos, BlockState stalactiteTipState,
                                          Fluid fluidAbove, BlockPos posAbove) {
        Vec3 offset = stalactiteTipState.getOffset(stalactiteTipPos);

        double x = stalactiteTipPos.getX() + 0.5D + offset.x;
        double y = stalactiteTipPos.getY() + 0.25D;
        double z = stalactiteTipPos.getZ() + 0.5D + offset.z;

        ParticleOptions dripParticle = getDripParticle(level, fluidAbove, posAbove);
        level.addParticle(dripParticle, x, y, z, 0.0D, 0.0D, 0.0D);
    }

    public static @Nullable BlockPos findStalactiteTipAboveCauldron(Level level, BlockPos cauldronPos) {
        BiPredicate<BlockPos, BlockState> pathPredicate = (pos, state) -> canDripThrough(level, pos, state);
        return findBlockVertical(level, cauldronPos, Direction.UP.getAxisDirection(), pathPredicate,
                state -> state.getBlock() instanceof SpikeBlock && canDrip(state), 11)
                .orElse(null);
    }

    public static Fluid getCauldronFillFluidType(ServerLevel level, BlockPos stalactitePos, SpikeBlock spike) {
        return getFluidAboveStalactite(level, stalactitePos, level.getBlockState(stalactitePos))
                .map(fluidSource -> fluidSource.fluid)
                .filter(fluid -> fluid == Fluids.WATER || fluid == Fluids.LAVA && spike.allowsLavaFarming)
                .orElse(Fluids.EMPTY);
    }

    public static Optional<PointedDripstoneBlock.FluidInfo> getFluidAboveStalactite(final Level level, final BlockPos stalactitePos, final BlockState stalactiteState) {
        if (!(stalactiteState.getBlock() instanceof SpikeBlock spike) || !spike.isStalactite(stalactiteState)) {
            return Optional.empty();
        }
        return spike.findRootBlock(level, stalactitePos, stalactiteState, 11).map(rootPos -> {
            BlockPos abovePos = rootPos.above();
            BlockState aboveState = level.getBlockState(abovePos);
            Fluid fluid;
            if (aboveState.is(Blocks.MUD)
                    && !(Boolean)level.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, abovePos)) {
                fluid = Fluids.WATER;
            } else {
                fluid = level.getFluidState(abovePos).getType();
            }
            return new PointedDripstoneBlock.FluidInfo(abovePos, fluid, aboveState);
        });
    }
}