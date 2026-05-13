package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FlowerPatchFeature extends Feature<NoneFeatureConfiguration> {

    private final Block flower;
    private final int baseRadius;
    private final int radiusVariance;
    private final int baseCount;
    private final int countVariance;

    public FlowerPatchFeature(Block flower, int baseRadius, int radiusVariance, int baseCount, int countVariance) {
        super(NoneFeatureConfiguration.CODEC);
        this.flower = flower;
        this.baseRadius = baseRadius;
        this.radiusVariance = radiusVariance;
        this.baseCount = baseCount;
        this.countVariance = countVariance;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int radius = baseRadius + random.nextInt(radiusVariance + 1);
        int count = baseCount + random.nextInt(countVariance + 1);
        int placed = 0;

        for (int i = 0; i < count * 3; i++) {
            int x = origin.getX() + random.nextInt(radius * 2 + 1) - radius;
            int z = origin.getZ() + random.nextInt(radius * 2 + 1) - radius;
            BlockPos surface = level.getHeightmapPos(
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    new BlockPos(x, origin.getY(), z)
            );
            BlockPos below = surface.below();

            if (level.getBlockState(below).is(BlockTags.DIRT)
                    || level.getBlockState(below).is(Blocks.GRASS_BLOCK)) {
                if (level.getBlockState(surface).isAir()) {
                    level.setBlock(surface, flower.defaultBlockState(), 2);
                    placed++;
                    if (placed >= count) break;
                }
            }
        }

        return placed > 0;
    }
}
