package team.lookingglass.elsewhere.dimension.portal;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;
import team.lookingglass.elsewhere.dimension.EDimensions;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.util.EPoiTypes;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class VeilrootPortalBlock extends Block implements Portal {
    public static final MapCodec<VeilrootPortalBlock> CODEC = simpleCodec(VeilrootPortalBlock::new);
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final BooleanProperty FADING = BooleanProperty.create("fading");
    private static final Map<Direction.Axis, VoxelShape> SHAPES =
            Shapes.rotateHorizontalAxis(Block.column(4.0, 16.0, 0.0, 16.0));

    public VeilrootPortalBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AXIS, Direction.Axis.X)
                .setValue(FADING, false));
    }

    @Override
    public MapCodec<VeilrootPortalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(AXIS));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity,
                                InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (entity.canUsePortal(false)) {
            entity.setAsInsidePortal(this, pos);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        Direction.Axis updateAxis = directionToNeighbour.getAxis();
        Direction.Axis portalAxis = state.getValue(AXIS);
        boolean wrongAxis = updateAxis != portalAxis && updateAxis.isHorizontal();
        if (!wrongAxis && !neighbourState.is(this) && level instanceof LevelAccessor accessor) {
            VeilrootPortalShape.recheckRow(accessor, pos, portalAxis);
        }
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        // waterfall-style particles — direction/spread tuned once you pick a look
        if (random.nextInt(100) == 0) {
            level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + 1.0; // spawn from top, fall down like a waterfall
        double z = pos.getZ() + random.nextDouble();
        level.addParticle(ParticleTypes.PORTAL, x, y, z, 0.0, -0.3, 0.0);
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, FADING);
    }

    @Override
    public @Nullable TeleportTransition getPortalDestination(ServerLevel currentLevel, Entity entity, BlockPos portalEntryPos) {
        ResourceKey<Level> newDimension = currentLevel.dimension() == EDimensions.VEILROOT
                ? Level.OVERWORLD
                : EDimensions.VEILROOT;
        ServerLevel newLevel = currentLevel.getServer().getLevel(newDimension);
        if (newLevel == null) return null;

        double scale = DimensionType.getTeleportationScale(currentLevel.dimensionType(), newLevel.dimensionType());
        BlockPos approximateExitPos = BlockPos.containing(
                entity.getX() * scale, entity.getY(), entity.getZ() * scale);

        Direction.Axis sourceAxis = currentLevel.getBlockState(portalEntryPos).getOptionalValue(AXIS).orElse(Direction.Axis.X);

        BlockPos exitPortalPos = findOrCreateExitPortal(newLevel, approximateExitPos, sourceAxis);
        if (exitPortalPos == null) return null;

        Vec3 targetPos = Vec3.atBottomCenterOf(exitPortalPos).add(0, 1, 0);
        return new TeleportTransition(newLevel, targetPos, Vec3.ZERO, entity.getYRot(), entity.getXRot(),
                Relative.union(Set.of()), TeleportTransition.PLAY_PORTAL_SOUND);
    }

    private @Nullable BlockPos findOrCreateExitPortal(ServerLevel level, BlockPos near, Direction.Axis axis) {
        BlockPos existing = findExistingPortal(level, near);
        if (existing != null) return existing;
        return generateExitStructure(level, near, axis);
    }

    private BlockPos generateExitStructure(ServerLevel level, BlockPos near, Direction.Axis axis) {
        level.getChunk(near.getX() >> 4, near.getZ() >> 4, net.minecraft.world.level.chunk.status.ChunkStatus.FULL);

        Direction rightDir = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        int width = 2;
        int height = 3;

        int surfaceY = findSafeSurfaceY(level, near.getX(), near.getZ());
        BlockPos bottomLeft = new BlockPos(near.getX(), surfaceY, near.getZ());

        // bottom lapis row
        for (int w = 0; w < width; w++) {
            level.setBlock(bottomLeft.relative(rightDir, w), Blocks.LAPIS_BLOCK.defaultBlockState(), 3);
        }
        // top lapis row
        for (int w = 0; w < width; w++) {
            level.setBlock(bottomLeft.above(height + 1).relative(rightDir, w), Blocks.LAPIS_BLOCK.defaultBlockState(), 3);
        }
        // portal fill
        BlockState portalState = EBlocks.VEILROOT_PORTAL.defaultBlockState()
                .setValue(AXIS, axis).setValue(FADING, false);
        for (int w = 0; w < width; w++) {
            for (int h = 1; h <= height; h++) {
                level.setBlock(bottomLeft.above(h).relative(rightDir, w), portalState, 18);
            }
        }

        return bottomLeft.above(1);
    }

    @SuppressWarnings("deprecation")
    private int findSafeSurfaceY(ServerLevel level, int x, int z) {
        int top = level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING, x, z);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, top, z);
        while (pos.getY() > level.getMinY()) {
            BlockState state = level.getBlockState(pos);
            if (!state.is(Blocks.BEDROCK) && state.isSolid()) {
                return pos.getY() + 1;
            }
            pos.move(Direction.DOWN);
        }
        return level.getMinY() + 1;
    }

    private static final int SEARCH_RADIUS = 16;

    private @Nullable BlockPos findExistingPortal(ServerLevel level, BlockPos near) {
        PoiManager poiManager = level.getPoiManager();
        poiManager.ensureLoadedAndValid(level, near, SEARCH_RADIUS);
        return poiManager.getInSquare(
                        type -> type.is(EPoiTypes.VEILROOT_PORTAL),
                        near, SEARCH_RADIUS, PoiManager.Occupancy.ANY)
                .map(PoiRecord::getPos)
                .min(Comparator.comparingDouble(pos -> pos.distSqr(near)))
                .orElse(null);
    }

    @Override
    public int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return entity instanceof Player ? 40 : 0;
    }

    @Override
    public Portal.Transition getLocalTransition() {
        return Portal.Transition.CONFUSION;
    }
}