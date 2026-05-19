package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class AmethystNodeFeature extends Feature<NoneFeatureConfiguration> {

    public AmethystNodeFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        boolean placedAny = false;
        int clusterCount = 2 + random.nextInt(3);

        for (int c = 0; c < clusterCount; c++) {
            BlockPos clusterOrigin = origin.offset(
                    random.nextIntBetweenInclusive(-6, 6),
                    random.nextIntBetweenInclusive(-3, 3),
                    random.nextIntBetweenInclusive(-6, 6)
            );

            int radius = 2 + random.nextInt(4);

            for (int x = -radius; x <= radius; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        if (x * x + z * z > radius * radius) continue;
                        BlockPos pos = clusterOrigin.offset(x, y, z);
                        if (!level.getBlockState(pos).is(BlockTags.BASE_STONE_OVERWORLD)) continue;
                        boolean budding = random.nextFloat() < 0.45F;
                        level.setBlock(pos,
                                budding ? Blocks.BUDDING_AMETHYST.defaultBlockState()
                                        : Blocks.AMETHYST_BLOCK.defaultBlockState(), 2);
                        placedAny = true;
                    }
                }
            }

            for (int x = -radius; x <= radius; x++) {
                for (int y = -2; y <= 2; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        BlockPos pos = clusterOrigin.offset(x, y, z);
                        if (!level.getBlockState(pos).is(Blocks.BUDDING_AMETHYST)) continue;
                        for (Direction dir : Direction.values()) {
                            if (random.nextFloat() > 0.7F) continue;
                            BlockPos face = pos.relative(dir);
                            var faceState = level.getBlockState(face);
                            if (faceState.isAir() || faceState.is(Blocks.WATER)) {
                                level.setBlock(face, randomBudStage(random, dir,
                                        faceState.is(Blocks.WATER)), 2);
                            }
                        }
                    }
                }
            }
        }

        return placedAny;
    }

    private BlockState randomBudStage(RandomSource random, Direction dir, boolean waterlogged) {
        float roll = random.nextFloat();
        BlockState state;
        if (roll < 0.3F) {
            state = Blocks.SMALL_AMETHYST_BUD.defaultBlockState();
        } else if (roll < 0.55F) {
            state = Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState();
        } else if (roll < 0.85F) {
            state = Blocks.LARGE_AMETHYST_BUD.defaultBlockState();
        } else {
            state = Blocks.AMETHYST_CLUSTER.defaultBlockState();
        }
        return state
                .setValue(AmethystClusterBlock.FACING, dir)
                .setValue(AmethystClusterBlock.WATERLOGGED, waterlogged);
    }
}