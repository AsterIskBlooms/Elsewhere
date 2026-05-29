package team.lookingglass.elsewhere.worldgen.features.spike.utils;

import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import team.lookingglass.elsewhere.registry.blocktypes.SpikeBlock;

public final class SpikeHelper {

    private SpikeHelper() {}

    public static boolean isEmptyOrWater(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }

    public static boolean isNeitherEmptyNorWater(BlockState state) {
        return !state.isAir() && !state.is(Blocks.WATER);
    }

    public static boolean isEmptyOrWaterOrLava(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) || state.is(Blocks.LAVA);
    }

    public static boolean isEmptyOrWater(LevelAccessor level, BlockPos pos) {
        return level.isStateAtPosition(pos, SpikeHelper::isEmptyOrWater);
    }

    public static boolean isSpikeBase(BlockState state, SpikeBlockSet blocks) {
        return state.is(blocks.baseBlock()) || state.is(blocks.replaceableTag());
    }

    public static boolean isSpikeBaseOrLava(BlockState state, SpikeBlockSet blocks) {
        return isSpikeBase(state, blocks) || state.is(Blocks.LAVA);
    }

    public static boolean placeBaseBlockIfPossible(LevelAccessor level, SpikeBlockSet blocks, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.is(blocks.replaceableTag())) {
            level.setBlock(pos, blocks.defaultBaseState(), 2);
            return true;
        }
        return false;
    }

    public static void growSpike(LevelAccessor level, SpikeBlockSet blocks,
                                 BlockPos startPos, Direction tipDirection,
                                 int height, boolean mergedTip) {
        if (!isSpikeBase(level.getBlockState(startPos.relative(tipDirection.getOpposite())), blocks)) return;
        BlockPos.MutableBlockPos pos = startPos.mutable();
        buildBaseToTipColumn(tipDirection, height, mergedTip, (state) -> {
            if (state.is(blocks.spikeBlock())) {
                state = state.setValue(SpikeBlock.WATERLOGGED, level.isWaterAt(pos));
            }
            level.setBlock(pos, state, 2);
            pos.move(tipDirection);
        }, blocks);
    }

    private static void buildBaseToTipColumn(Direction direction, int totalLength,
                                             boolean mergedTip, Consumer<BlockState> consumer,
                                             SpikeBlockSet blocks) {
        if (totalLength >= 3) {
            consumer.accept(blocks.createSpikeState(direction, DripstoneThickness.BASE));
            for (int i = 0; i < totalLength - 3; i++)
                consumer.accept(blocks.createSpikeState(direction, DripstoneThickness.MIDDLE));
        }
        if (totalLength >= 2)
            consumer.accept(blocks.createSpikeState(direction, DripstoneThickness.FRUSTUM));
        if (totalLength >= 1)
            consumer.accept(blocks.createSpikeState(direction, mergedTip ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
    }
}