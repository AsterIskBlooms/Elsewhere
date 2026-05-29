package team.lookingglass.elsewhere.worldgen.features.spike.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.FloatProviders;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SpikeClusterConfiguration(
        int floorToCeilingSearchRange,
        IntProvider height,
        IntProvider radius,
        int maxStalagmiteStalactiteHeightDiff,
        int heightDeviation,
        IntProvider dripstoneBlockLayerThickness,
        FloatProvider density,
        FloatProvider wetness,
        float chanceOfColumnAtMaxDistanceFromCenter,
        int maxDistanceFromEdgeAffectingChanceOfColumn,
        int maxDistanceFromCenterAffectingHeightBias
) implements FeatureConfiguration {
    public static final Codec<SpikeClusterConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(
            Codec.intRange(1, 512).fieldOf("floor_to_ceiling_search_range").forGetter(SpikeClusterConfiguration::floorToCeilingSearchRange),
            IntProviders.codec(1, 128).fieldOf("height").forGetter(SpikeClusterConfiguration::height),
            IntProviders.codec(1, 128).fieldOf("radius").forGetter(SpikeClusterConfiguration::radius),
            Codec.intRange(0, 64).fieldOf("max_stalagmite_stalactite_height_diff").forGetter(SpikeClusterConfiguration::maxStalagmiteStalactiteHeightDiff),
            Codec.intRange(1, 64).fieldOf("height_deviation").forGetter(SpikeClusterConfiguration::heightDeviation),
            IntProviders.codec(0, 128).fieldOf("dripstone_block_layer_thickness").forGetter(SpikeClusterConfiguration::dripstoneBlockLayerThickness),
            FloatProviders.codec(0.0F, 2.0F).fieldOf("density").forGetter(SpikeClusterConfiguration::density),
            FloatProviders.codec(0.0F, 2.0F).fieldOf("wetness").forGetter(SpikeClusterConfiguration::wetness),
            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_column_at_max_distance_from_center").forGetter(SpikeClusterConfiguration::chanceOfColumnAtMaxDistanceFromCenter),
            Codec.intRange(1, 64).fieldOf("max_distance_from_edge_affecting_chance_of_column").forGetter(SpikeClusterConfiguration::maxDistanceFromEdgeAffectingChanceOfColumn),
            Codec.intRange(1, 64).fieldOf("max_distance_from_center_affecting_height_bias").forGetter(SpikeClusterConfiguration::maxDistanceFromCenterAffectingHeightBias)
    ).apply(i, SpikeClusterConfiguration::new));
}