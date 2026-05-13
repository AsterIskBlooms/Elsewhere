package team.lookingglass.elsewhere.worldgen.features.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.FloatProviders;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record SulfurSpikeClusterConfiguration(int floorToCeilingSearchRange, IntProvider height, IntProvider radius,
                                              int maxStalagmiteStalactiteHeightDiff, int heightDeviation,
                                              IntProvider dripstoneBlockLayerThickness, FloatProvider density,
                                              FloatProvider wetness, float chanceOfSulfurColumnAtMaxDistanceFromCenter,
                                              int maxDistanceFromEdgeAffectingChanceOfSulfurColumn,
                                              int maxDistanceFromCenterAffectingHeightBias) implements FeatureConfiguration {
    public static final Codec<SulfurSpikeClusterConfiguration> CODEC = RecordCodecBuilder.create((i) -> i.group(Codec.intRange(1, 512).fieldOf("floor_to_ceiling_search_range").forGetter((c) -> c.floorToCeilingSearchRange), IntProviders.codec(1, 128).fieldOf("height").forGetter((c) -> c.height), IntProviders.codec(1, 128).fieldOf("radius").forGetter((c) -> c.radius), Codec.intRange(0, 64).fieldOf("max_stalagmite_stalactite_height_diff").forGetter((c) -> c.maxStalagmiteStalactiteHeightDiff), Codec.intRange(1, 64).fieldOf("height_deviation").forGetter((c) -> c.heightDeviation), IntProviders.codec(0, 128).fieldOf("dripstone_block_layer_thickness").forGetter((c) -> c.dripstoneBlockLayerThickness), FloatProviders.codec(0.0F, 2.0F).fieldOf("density").forGetter((c) -> c.density), FloatProviders.codec(0.0F, 2.0F).fieldOf("wetness").forGetter((c) -> c.wetness), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_dripstone_column_at_max_distance_from_center").forGetter((c) -> c.chanceOfSulfurColumnAtMaxDistanceFromCenter), Codec.intRange(1, 64).fieldOf("max_distance_from_edge_affecting_chance_of_dripstone_column").forGetter((c) -> c.maxDistanceFromEdgeAffectingChanceOfSulfurColumn), Codec.intRange(1, 64).fieldOf("max_distance_from_center_affecting_height_bias").forGetter((c) -> c.maxDistanceFromCenterAffectingHeightBias)).apply(i, SulfurSpikeClusterConfiguration::new));
}
