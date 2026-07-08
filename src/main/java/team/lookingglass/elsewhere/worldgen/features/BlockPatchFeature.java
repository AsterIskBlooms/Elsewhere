package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import team.lookingglass.elsewhere.worldgen.features.config.BlockPatchConfiguration;

public class BlockPatchFeature extends Feature<BlockPatchConfiguration> {

    public BlockPatchFeature() {
        super(BlockPatchConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<BlockPatchConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        BlockPatchConfiguration config = context.config();

        int radius = config.baseRadius() + random.nextInt(config.radiusVariance() + 1);
        int count = config.baseCount() + random.nextInt(config.countVariance() + 1);
        int placed = 0;

        for (int i = 0; i < count * 3; i++) {
            int x = origin.getX() + random.nextInt(radius * 2 + 1) - radius;
            int z = origin.getZ() + random.nextInt(radius * 2 + 1) - radius;
            BlockPos surface = level.getHeightmapPos(
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    new BlockPos(x, origin.getY(), z)
            );
            BlockPos below = surface.below();

            if (level.getBlockState(below).is(config.validGround())) {
                BlockState state = config.toPlace().getState(level, random, surface);

                if (state.getBlock() instanceof DoublePlantBlock) {
                    if (level.getBlockState(surface).isAir() && level.isEmptyBlock(surface.above())) {
                        DoublePlantBlock.placeAt(level, state, surface, 2);
                        placed++;
                        if (placed >= count) break;
                    }
                } else if (level.getBlockState(surface).isAir()) {
                    level.setBlock(surface, state, 2);
                    placed++;
                    if (placed >= count) break;
                }
            }
        }

        return placed > 0;
    }
}