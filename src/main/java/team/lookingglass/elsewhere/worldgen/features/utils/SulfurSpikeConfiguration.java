package team.lookingglass.elsewhere.worldgen.features.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SulfurSpikeConfiguration(float chanceOfTallerSulfur, float chanceOfDirectionalSpread,
                                       float chanceOfSpreadRadius2,
                                       float chanceOfSpreadRadius3) implements FeatureConfiguration {
    public static final Codec<SulfurSpikeConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_taller_dripstone").orElse(0.2F).forGetter((c) -> c.chanceOfTallerSulfur), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_directional_spread").orElse(0.7F).forGetter((c) -> c.chanceOfDirectionalSpread), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius2").orElse(0.5F).forGetter((c) -> c.chanceOfSpreadRadius2), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius3").orElse(0.5F).forGetter((c) -> c.chanceOfSpreadRadius3)).apply(i, SulfurSpikeConfiguration::new));
}
