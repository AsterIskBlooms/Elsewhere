package team.lookingglass.elsewhere.worldgen.features.spike.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SpikeConfiguration(
        float chanceOfTallerSpike,
        float chanceOfDirectionalSpread,
        float chanceOfSpreadRadius2,
        float chanceOfSpreadRadius3
) implements FeatureConfiguration {
    public static final Codec<SpikeConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_taller_spike").orElse(0.2F).forGetter(SpikeConfiguration::chanceOfTallerSpike),
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_directional_spread").orElse(0.7F).forGetter(SpikeConfiguration::chanceOfDirectionalSpread),
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius2").orElse(0.5F).forGetter(SpikeConfiguration::chanceOfSpreadRadius2),
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius3").orElse(0.5F).forGetter(SpikeConfiguration::chanceOfSpreadRadius3)
    ).apply(i, SpikeConfiguration::new));
}