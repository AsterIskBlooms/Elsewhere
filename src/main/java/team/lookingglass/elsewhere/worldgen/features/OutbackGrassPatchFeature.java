package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class OutbackGrassPatchFeature extends Feature<NoneFeatureConfiguration> {

    public OutbackGrassPatchFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int radius = 6 + random.nextInt(4);
        int placed = 0;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                double distanceSq = (x * x + z * z) / (double) (radius * radius);

                if (distanceSq > 1.2) continue;

                BlockPos groundPos = level.getHeightmapPos(
                        Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        origin.offset(x, 0, z)
                ).below();

                BlockState groundState = level.getBlockState(groundPos);

                if (groundState.is(BlockTags.SAND) || groundState.is(BlockTags.DIRT)) {

                    if (random.nextFloat() > distanceSq * 0.8) {
                        level.setBlock(groundPos, Blocks.GRASS_BLOCK.defaultBlockState(), 3);
                        placed++;
                    }
                }
            }
        }

        return placed > 0;
    }
}