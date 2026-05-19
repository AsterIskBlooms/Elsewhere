package team.lookingglass.elsewhere.worldgen.features;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.material.Fluids;
import team.lookingglass.elsewhere.registry.EBlocks;

@SuppressWarnings("deprecation")
public class SulfurPoolFeature extends Feature<LakeFeature.Configuration> {

    public SulfurPoolFeature() {
        super(LakeFeature.Configuration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<LakeFeature.Configuration> context) {
        // first place the lake using vanilla lake feature
        boolean placed = Feature.LAKE.place(context);
        if (!placed) return false;

        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        // scan for water blocks and place potent sulfur below them
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = -4; y <= 4; y++) {
                    BlockPos pos = origin.offset(x, y, z);
                    if (level.getFluidState(pos).is(Fluids.WATER)) {
                        BlockPos below = pos.below();
                        if (level.getBlockState(below).is(EBlocks.SULFUR) && random.nextFloat() < 0.15F) {
                            level.setBlock(below, EBlocks.POTENT_SULFUR.defaultBlockState(), 3);
                            level.updateNeighborsAt(below, EBlocks.POTENT_SULFUR);
                            if (level.getBlockState(below).is(EBlocks.POTENT_SULFUR) && random.nextFloat() < 0.02F) {
                                BlockPos magmaPos = below.below();
                                if (!level.getBlockState(magmaPos).isAir()) {
                                    level.setBlock(magmaPos, Blocks.MAGMA_BLOCK.defaultBlockState(), 3);
                                    level.updateNeighborsAt(below, EBlocks.POTENT_SULFUR);
                                }
                            }
                            level.scheduleTick(below, EBlocks.POTENT_SULFUR, 5);
                        }
                    }
                }
            }
        }

        return true;
    }
}
