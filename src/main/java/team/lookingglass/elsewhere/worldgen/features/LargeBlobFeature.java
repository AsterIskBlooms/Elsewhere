package team.lookingglass.elsewhere.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class LargeBlobFeature extends Feature<LargeBlobFeature.LargeBlobConfiguration> {
    public LargeBlobFeature(final Codec<LargeBlobConfiguration> codec) {super(codec);}

    @Override
    public boolean place(final FeaturePlaceContext<LargeBlobConfiguration> context) {
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        LargeBlobConfiguration config = context.config();

        while (origin.getY() > level.getMinY() + 3 && !config.canPlaceOn().test(level, origin.below())) {
            origin = origin.below();
        }

        if (origin.getY() <= level.getMinY() + 3) {
            return false;
        }

        for (int c = 0; c < 3; c++) {
            int xr = random.nextInt(config.radius().sample(RandomSource.create()));
            int yr = random.nextInt(config.radius().sample(RandomSource.create()));
            int zr = random.nextInt(config.radius().sample(RandomSource.create()));
            float tr = (xr + yr + zr) * 0.333F + 0.5F;

            for (BlockPos blockPos : BlockPos.betweenClosed(origin.offset(-xr, -yr, -zr), origin.offset(xr, yr, zr))) {
                if (blockPos.distSqr(origin) <= tr * tr) {
                    level.setBlock(blockPos, config.state(), 3);
                }
            }

            origin = origin.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
        }

        return true;
    }

    public record LargeBlobConfiguration(BlockState state, BlockPredicate canPlaceOn, IntProvider radius) implements FeatureConfiguration {
        public static final Codec<LargeBlobConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(
                BlockState.CODEC.fieldOf("state").forGetter(LargeBlobConfiguration::state),
                BlockPredicate.CODEC.fieldOf("can_place_on").forGetter(LargeBlobConfiguration::canPlaceOn),
                IntProviders.CODEC.fieldOf("radius").forGetter(LargeBlobConfiguration::radius)
                ).apply(i, LargeBlobConfiguration::new));
    }
}