package team.lookingglass.elsewhere.worldgen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record ExposedDoubleDiskConfiguration(
        BlockStateProvider firstState, BlockPredicate firstTarget, int firstHalfHeight,
        BlockStateProvider secondState, BlockPredicate secondTarget, int secondHalfHeight,
        IntProvider radius
) implements FeatureConfiguration {
    public static final Codec<ExposedDoubleDiskConfiguration> CODEC = RecordCodecBuilder.create(i -> i.group(
            BlockStateProvider.CODEC.fieldOf("first_state").forGetter(ExposedDoubleDiskConfiguration::firstState),
            BlockPredicate.CODEC.fieldOf("first_target").forGetter(ExposedDoubleDiskConfiguration::firstTarget),
            Codec.intRange(0, 4).fieldOf("first_half_height").forGetter(ExposedDoubleDiskConfiguration::firstHalfHeight),
            BlockStateProvider.CODEC.fieldOf("second_state").forGetter(ExposedDoubleDiskConfiguration::secondState),
            BlockPredicate.CODEC.fieldOf("second_target").forGetter(ExposedDoubleDiskConfiguration::secondTarget),
            Codec.intRange(0, 4).fieldOf("second_half_height").forGetter(ExposedDoubleDiskConfiguration::secondHalfHeight),
            IntProviders.codec(0, 8).fieldOf("radius").forGetter(ExposedDoubleDiskConfiguration::radius)
    ).apply(i, ExposedDoubleDiskConfiguration::new));
}
