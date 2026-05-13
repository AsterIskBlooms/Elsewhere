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

public class RockyOutcropFeature extends Feature<NoneFeatureConfiguration> {

    public RockyOutcropFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        // sink down to surface
        while (origin.getY() > level.getMinY() + 3 && !level.getBlockState(origin.below()).is(BlockTags.DIRT)
                && !level.getBlockState(origin.below()).is(Blocks.GRASS_BLOCK)
                && !level.getBlockState(origin.below()).is(BlockTags.SAND)
                && !level.getBlockState(origin.below()).is(Blocks.GRAVEL)
                && !level.getBlockState(origin.below()).is(Blocks.STONE)) {
            origin = origin.below();
        }

        if (origin.getY() <= level.getMinY() + 3) return false;

        int blobCount = 4 + random.nextInt(2);
        BlockPos blobOrigin = origin;

        for (int c = 0; c < blobCount; c++) {
            int xr = 2 + random.nextInt(4);
            int zr = 2 + random.nextInt(4);
            int depth = 3 + random.nextInt(3);

            for (int x = -xr; x <= xr; x++) {
                for (int z = -zr; z <= zr; z++) {
                    double dx = (double) x / xr;
                    double dz = (double) z / zr;
                    if (dx * dx + dz * dz > 1.2) continue;

                    // sample heightmap at this specific x/z
                    BlockPos columnSurface = level.getHeightmapPos(
                            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                            blobOrigin.offset(x, 0, z)
                    );

                    // place downward from surface
                    for (int y = 0; y <= depth; y++) {
                        BlockPos placePos = columnSurface.below(y);
                        BlockState existing = level.getBlockState(placePos);
                        if (existing.is(BlockTags.DIRT) || existing.is(Blocks.GRASS_BLOCK)
                                || existing.is(Blocks.SAND) || existing.is(Blocks.GRAVEL)
                                || existing.is(Blocks.STONE)) {
                            level.setBlock(placePos, Blocks.STONE.defaultBlockState(), 3);
                        }
                    }

                    // clean surface above
                    BlockPos surfaceBlock = columnSurface.below();
                    if (level.getBlockState(surfaceBlock).is(Blocks.STONE)) {
                        BlockState onTop = level.getBlockState(columnSurface);
                        if (onTop.is(BlockTags.REPLACEABLE)) {
                            level.removeBlock(columnSurface, false);
                        }
                    }
                }
            }

            blobOrigin = blobOrigin.offset(
                    -1 + random.nextInt(3),
                    0,
                    -1 + random.nextInt(3)
            );
        }

        return true;
    }
}