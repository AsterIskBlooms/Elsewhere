package team.lookingglass.elsewhere.registry.blocktypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SpikeBlock extends PointedDripstoneBlock {

    private final Block baseBlock;
    private final double damage;
    private final SoundEvent landSound;

    public SpikeBlock(Block baseBlock, double damage, SoundEvent landSound, Properties properties) {
        super(properties);
        this.baseBlock = baseBlock;
        this.damage = damage;
        this.landSound = landSound;
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

    private Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axisDirection,
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
            ticks.scheduleTick(pos, this, tipDirection == Direction.DOWN ? 2 : 1);
            return state;
        }

        boolean mergeOpposingTips = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
        return state.setValue(THICKNESS, calculateThickness(level, pos, tipDirection, mergeOpposingTips));
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
        entity.causeFallDamage(fallDistance + damage, 1.0F, level.damageSources().stalagmite());
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canSurvive(state, level, pos)) {
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
                entity.setHurtsEntities(0.5F * height, 20);
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
}