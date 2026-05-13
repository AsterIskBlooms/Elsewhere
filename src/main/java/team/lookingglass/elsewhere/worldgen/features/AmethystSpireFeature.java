package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class AmethystSpireFeature extends Feature<NoneFeatureConfiguration> {

    public AmethystSpireFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        boolean fromCeiling = random.nextBoolean();
        int height = 1 + random.nextInt(5);
        BlockPos base = null;

        if (fromCeiling) {
            for (int i = 0; i < 32; i++) {
                BlockPos check = origin.above(i);
                if (!level.getBlockState(check).isAir() && level.getBlockState(check.below()).isAir()) {
                    base = check;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 32; i++) {
                BlockPos check = origin.below(i);
                if (!level.getBlockState(check).isAir() && level.getBlockState(check.above()).isAir()) {
                    base = check;
                    break;
                }
            }
        }

        if (base == null) return false;

        int bottomThird = (height / 4) - 1;
        int middleThird = (height / 2) - 1;

        for (int i = -1; i < height; i++) {
            BlockPos pos = fromCeiling ? base.below(i + 1) : base.above(i + 1);

            // allow placing in solid blocks for the buried base block
            if (i == -1) {
                if (level.getBlockState(pos).isAir()) continue; // skip if somehow air
                level.setBlock(pos, Blocks.AMETHYST_BLOCK.defaultBlockState(), 2);
                continue;
            }

            if (!level.getBlockState(pos).isAir()) continue;

            boolean isTip = i == height - 1;

            level.setBlock(pos, isTip
                    ? Blocks.BUDDING_AMETHYST.defaultBlockState()
                    : Blocks.AMETHYST_BLOCK.defaultBlockState(), 2);

            // determine section for floor spires
            // for ceiling spires invert the section index

            if (i < bottomThird) {
                // 3x3 square
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 && z == 0) continue;
                        BlockPos sidePos = pos.offset(x, 0, z);
                        if (level.getBlockState(sidePos).isAir()) {
                            level.setBlock(sidePos, random.nextFloat() < 0.15f
                                    ? Blocks.BUDDING_AMETHYST.defaultBlockState()
                                    : Blocks.AMETHYST_BLOCK.defaultBlockState(), 2);
                        }
                    }
                }
            } else if (i < middleThird) {
                // cross
                for (int offset = -1; offset <= 1; offset++) {
                    if (offset == 0) continue;
                    for (BlockPos sidePos : new BlockPos[]{
                            pos.offset(offset, 0, 0),
                            pos.offset(0, 0, offset)
                    }) {
                        if (level.getBlockState(sidePos).isAir()) {
                            level.setBlock(sidePos, random.nextFloat() < 0.15f
                                    ? Blocks.BUDDING_AMETHYST.defaultBlockState()
                                    : Blocks.AMETHYST_BLOCK.defaultBlockState(), 2);
                        }
                    }
                }
            }
            // top third — 1x1 pillar, no extra blocks
        }

        // clusters at tip
        BlockPos tip = fromCeiling ? base.below(height) : base.above(height);
        for (Direction dir : Direction.values()) {
            if (random.nextFloat() < 0.6f) {
                BlockPos clusterPos = tip.relative(dir);
                if (level.getBlockState(clusterPos).isAir()) {
                    level.setBlock(clusterPos, Blocks.AMETHYST_CLUSTER.defaultBlockState()
                            .setValue(AmethystClusterBlock.FACING, dir), 2);
                }
            }
        }

        return true;
    }
}
