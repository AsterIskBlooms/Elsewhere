package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.*;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurSpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurSpikeConfiguration;

@SuppressWarnings("deprecation")
public class EFeatureTypes {

    public static final Feature<NoneFeatureConfiguration> ROCKY_OUTCROP_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "rocky_outcrop"),
                    new RockyOutcropFeature());

    public static final Feature<NoneFeatureConfiguration> OUTBACK_GRASS_PATCH_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "outback_grass_patch"),
                    new OutbackGrassPatchFeature());

    public static final Feature<NoneFeatureConfiguration> BLUEBONNET_PATCH_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bluebonnet_patch"),
                    new FlowerPatchFeature(EBlocks.BLUEBONNET, 3, 1, 6, 3));

    public static final Feature<NoneFeatureConfiguration> BLUEBONNET_DENSE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bluebonnet_dense"),
                    new FlowerPatchFeature(EBlocks.BLUEBONNET, 7, 3, 28, 12));

    public static final Feature<NoneFeatureConfiguration> AMETHYST_SPIRE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "amethyst_spire"),
                    new AmethystSpireFeature());

    public static final Feature<SulfurSpikeConfiguration> SULFUR_SPIKE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike"),
                    new SulfurSpikeFeature(SulfurSpikeConfiguration.CODEC));

    public static final Feature<SulfurSpikeClusterConfiguration> SULFUR_SPIKE_CLUSTER_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_cluster"),
                    new SulfurSpikeClusterFeature(SulfurSpikeClusterConfiguration.CODEC));

    public static final Feature<LakeFeature.Configuration> SULFUR_POOL_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_pool"),
                    new SulfurPoolFeature());

    public static void initialize() {}
}