package team.lookingglass.elsewhere.worldgen.features.utils;

import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import team.lookingglass.elsewhere.datagen.BlockTagProvider;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.blocktypes.SulfurSpikeBlock;

public class SulfurUtils {
    public SulfurUtils() {
    }

    protected static double getSulfurHeight(double xzDistanceFromCenter, final double dripstoneRadius, final double scale, final double bluntness) {
        if (xzDistanceFromCenter < bluntness) {
            xzDistanceFromCenter = bluntness;
        }

        double cutoff = 0.384;
        double r = xzDistanceFromCenter / dripstoneRadius * 0.384;
        double part1 = (double)0.75F * Math.pow(r, 1.3333333333333333);
        double part2 = Math.pow(r, 0.6666666666666666);
        double part3 = 0.3333333333333333 * Math.log(r);
        double heightRelativeToMaxRadius = scale * (part1 - part2 - part3);
        heightRelativeToMaxRadius = Math.max(heightRelativeToMaxRadius, (double)0.0F);
        return heightRelativeToMaxRadius / 0.384 * dripstoneRadius;
    }

    protected static boolean isCircleMostlyEmbeddedInStone(final WorldGenLevel level, final BlockPos center, final int xzRadius) {
        if (isEmptyOrWaterOrLava(level, center)) {
            return false;
        } else {
            float arcLength = 6.0F;
            float angleIncrement = 6.0F / (float)xzRadius;

            for(float angle = 0.0F; angle < ((float)Math.PI * 2F); angle += angleIncrement) {
                int dx = (int)(Mth.cos((double)angle) * (float)xzRadius);
                int dz = (int)(Mth.sin((double)angle) * (float)xzRadius);
                if (isEmptyOrWaterOrLava(level, center.offset(dx, 0, dz))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isEmptyOrWater(final LevelAccessor level, final BlockPos pos) {
        return level.isStateAtPosition(pos, SulfurUtils::isEmptyOrWater);
    }

    protected static boolean isEmptyOrWaterOrLava(final LevelAccessor level, final BlockPos pos) {
        return level.isStateAtPosition(pos, SulfurUtils::isEmptyOrWaterOrLava);
    }

    protected static void buildBaseToTipColumn(final Direction direction, final int totalLength, final boolean mergedTip, final Consumer<BlockState> consumer) {
        if (totalLength >= 3) {
            consumer.accept(createSulfurSpike(direction, DripstoneThickness.BASE));

            for(int i = 0; i < totalLength - 3; ++i) {
                consumer.accept(createSulfurSpike(direction, DripstoneThickness.MIDDLE));
            }
        }

        if (totalLength >= 2) {
            consumer.accept(createSulfurSpike(direction, DripstoneThickness.FRUSTUM));
        }

        if (totalLength >= 1) {
            consumer.accept(createSulfurSpike(direction, mergedTip ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
        }

    }

    public static void growSulfurSpike(final LevelAccessor level, final BlockPos startPos, final Direction tipDirection, final int height, final boolean mergedTip) {
        if (isSulfurBase(level.getBlockState(startPos.relative(tipDirection.getOpposite())))) {
            BlockPos.MutableBlockPos pos = startPos.mutable();
            buildBaseToTipColumn(tipDirection, height, mergedTip, (state) -> {
                if (state.is(EBlocks.SULFUR_SPIKE)) {
                    state = (BlockState)state.setValue(SulfurSpikeBlock.WATERLOGGED, level.isWaterAt(pos));
                }

                level.setBlock(pos, state, 2);
                pos.move(tipDirection);
            });
        }
    }

    public static boolean placeSulfurBlockIfPossible(final LevelAccessor level, final BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.is(BlockTagProvider.SULFUR_SPIKE_REPLACEABLE)) {
            level.setBlock(pos, EBlocks.SULFUR.defaultBlockState(), 2);
            return true;
        } else {
            return false;
        }
    }

    private static BlockState createSulfurSpike(final Direction direction, final DripstoneThickness thickness) {
        return (BlockState)((BlockState)EBlocks.SULFUR_SPIKE.defaultBlockState().setValue(SulfurSpikeBlock.TIP_DIRECTION, direction)).setValue(SulfurSpikeBlock.THICKNESS, thickness);
    }

    public static boolean isSulfurBaseOrLava(final BlockState state) {
        return isSulfurBase(state) || state.is(Blocks.LAVA);
    }

    public static boolean isSulfurBase(final BlockState state) {
        return state.is(EBlocks.SULFUR) || state.is(BlockTagProvider.SULFUR_SPIKE_REPLACEABLE);
    }

    public static boolean isEmptyOrWater(final BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }

    public static boolean isNeitherEmptyNorWater(final BlockState state) {
        return !state.isAir() && !state.is(Blocks.WATER);
    }

    public static boolean isEmptyOrWaterOrLava(final BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) || state.is(Blocks.LAVA);
    }
}

