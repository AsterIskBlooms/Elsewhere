package team.lookingglass.elsewhere.registry.blocktypes;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CaveRootBlock extends VegetationBlock implements BonemealableBlock {
    public static final MapCodec<net.minecraft.world.level.block.BushBlock> CODEC = simpleCodec(net.minecraft.world.level.block.BushBlock::new);
    private static final VoxelShape SHAPE = Block.column(14.0, 0.0, 4.0);

    public MapCodec<net.minecraft.world.level.block.BushBlock> codec() {
        return CODEC;
    }

    public CaveRootBlock(final BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(final BlockState state, final BlockGetter level, final BlockPos pos) {
        return state.isSolidRender();
    }

    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return SHAPE;
    }

    public boolean isValidBonemealTarget(final LevelReader level, final BlockPos pos, final BlockState state) {
        return BonemealableBlock.hasSpreadableNeighbourPos(level, pos, state);
    }

    public boolean isBonemealSuccess(final Level level, final RandomSource random, final BlockPos pos, final BlockState state) {
        return true;
    }

    public void performBonemeal(final ServerLevel level, final RandomSource random, final BlockPos pos, final BlockState state) {
        BonemealableBlock.findSpreadableNeighbourPos(level, pos, state).ifPresent((blockPos) -> level.setBlockAndUpdate(blockPos, this.defaultBlockState()));
    }
}
