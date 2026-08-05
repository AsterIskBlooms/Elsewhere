package team.lookingglass.elsewhere.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ArchFeature extends Feature<ArchFeature.ArchConfiguration> {

    public ArchFeature(Codec<ArchConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ArchConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        ArchConfiguration config = context.config();

        int height = config.height.sample(random);
        int width = config.width.sample(random);
        int thickness = config.thickness.sample(random);
        double halfWidth = width / 2.0;

        for (int dx = -width / 2; dx <= width / 2; ++dx) {
            double normalized = dx / halfWidth;
            if (normalized < -1.0 || normalized > 1.0) continue;

            int curveY = (int) Math.round(height * Math.sqrt(1.0 - normalized * normalized));

            for (int t = 0; t < thickness; ++t) {
                int y = curveY - t;
                if (y < 0) break;

                BlockPos pos = origin.offset(dx, y, 0);
                level.setBlock(pos, config.stateProvider.getState(level, random, pos), 3);
            }
        }

        return true;
    }

    public record ArchConfiguration(BlockStateProvider stateProvider, IntProvider height, IntProvider width, IntProvider thickness) implements FeatureConfiguration {
        public static final Codec<ArchConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(
                BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(ArchConfiguration::stateProvider),
                IntProviders.CODEC.fieldOf("height").forGetter(ArchConfiguration::height),
                IntProviders.CODEC.fieldOf("width").forGetter(ArchConfiguration::width),
                IntProviders.CODEC.fieldOf("thickness").forGetter(ArchConfiguration::thickness)
        ).apply(i, ArchConfiguration::new));
    }
}
