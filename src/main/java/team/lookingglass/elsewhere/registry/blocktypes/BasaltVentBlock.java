package team.lookingglass.elsewhere.registry.blocktypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class BasaltVentBlock extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    private static final int COLUMN_HEIGHT = 6;

    public BasaltVentBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(ACTIVE, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(ACTIVE, !isSubmerged(ctx.getLevel(), ctx.getClickedPos()));
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (direction == Direction.UP) tickAccess.scheduleTick(pos, this, 5);
        return state;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        boolean submerged = isSubmerged(level, pos);
        if (submerged == state.getValue(ACTIVE)) {
            level.setBlock(pos, state.setValue(ACTIVE, !submerged), Block.UPDATE_ALL);
        }
    }

    private static boolean isSubmerged(LevelReader level, BlockPos pos) {
        return level.getFluidState(pos.above()).is(FluidTags.WATER);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(ACTIVE)) spawnSmoke(level, pos, random);
        else spawnBubbles(level, pos, random);
    }

    private static void spawnSmoke(Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(8) != 0) return;
        double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
        double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
        level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, pos.getY() + 1.0, z, 0.0, 0.07, 0.0);
    }

    private static void spawnBubbles(Level level, BlockPos pos, RandomSource random) {
        for (int i = 0; i < 3; i++) {
            if (random.nextInt(2) != 0) continue;
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + 1.0 + random.nextDouble() * COLUMN_HEIGHT;
            double z = pos.getZ() + random.nextDouble();
            level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, x, y, z, 0.0, 0.04, 0.0);
        }
    }
}