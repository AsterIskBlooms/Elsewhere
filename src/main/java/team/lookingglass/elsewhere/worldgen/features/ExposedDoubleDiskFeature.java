package team.lookingglass.elsewhere.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import team.lookingglass.elsewhere.worldgen.features.config.ExposedDoubleDiskConfiguration;

public class ExposedDoubleDiskFeature extends Feature<ExposedDoubleDiskConfiguration> {
    public ExposedDoubleDiskFeature(Codec<ExposedDoubleDiskConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ExposedDoubleDiskConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        ExposedDoubleDiskConfiguration config = context.config();

        int radius = config.radius().sample(random);
        boolean placedAny = false;

        placedAny |= placeDisk(level, origin, random, config.firstState(), config.firstTarget(), radius, config.firstHalfHeight());
        placedAny |= placeDisk(level, origin, random, config.secondState(), config.secondTarget(), radius, config.secondHalfHeight());
        placedAny |= clearPlants(level, origin, random, radius, config.firstHalfHeight() + 1);

        return placedAny;
    }

    private boolean placeDisk(WorldGenLevel level, BlockPos origin, RandomSource random,
                              BlockStateProvider stateProvider, BlockPredicate target,
                              int radius, int halfHeight) {
        boolean placedAny = false;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z > radius * radius) continue;
                for (int y = -halfHeight; y <= halfHeight; y++) {
                    mutable.setWithOffset(origin, x, y, z);
                    if (target.test(level, mutable)) {
                        level.setBlock(mutable, stateProvider.getState(level, random, mutable), 3);
                        placedAny = true;
                    }
                }
            }
        }
        return placedAny;
    }

    private boolean clearPlants(WorldGenLevel level, BlockPos origin, RandomSource random, int radius, int halfHeight) {
        boolean clearedAny = false;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z > radius * radius) continue;
                for (int y = -halfHeight; y <= halfHeight; y++) {
                    mutable.setWithOffset(origin, x, y, z);
                    BlockState state = level.getBlockState(mutable);
                    if (state.is(BlockTags.REPLACEABLE) || state.getBlock() instanceof BushBlock) {
                        level.setBlock(mutable, Blocks.AIR.defaultBlockState(), 3);
                        clearedAny = true;
                    }
                }
            }
        }
        return clearedAny;
    }
}