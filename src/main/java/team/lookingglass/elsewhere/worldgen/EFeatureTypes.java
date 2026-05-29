package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.datagen.BlockTagProvider;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.*;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeClusterFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeBlockSet;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeConfiguration;

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

    public static final Feature<NoneFeatureConfiguration> AMETHYST_NODE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "amethyst_node"),
                    new AmethystNodeFeature());

    // Frigid Caves
    public static final SpikeBlockSet ICICLE_BLOCKS = new SpikeBlockSet(
            Blocks.PACKED_ICE,
            EBlocks.ICICLE,
            BlockTagProvider.ICICLE_REPLACEABLE
    );

    public static final Feature<SpikeConfiguration> ICICLE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_feature"),
                    new SpikeFeature(SpikeConfiguration.CODEC, ICICLE_BLOCKS));

    public static final Feature<SpikeClusterConfiguration> ICICLE_CLUSTER_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_cluster_feature"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, ICICLE_BLOCKS));

    // Sulfur Caves
    public static final SpikeBlockSet SULFUR_SPIKE_BLOCKS = new SpikeBlockSet(
            EBlocks.SULFUR,
            EBlocks.SULFUR_SPIKE,
            BlockTagProvider.SULFUR_SPIKE_REPLACEABLE
    );

    public static final Feature<SpikeConfiguration> SULFUR_SPIKE_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike"),
                    new SpikeFeature(SpikeConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    public static final Feature<SpikeClusterConfiguration> SULFUR_SPIKE_CLUSTER_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_cluster"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    public static final Feature<LakeFeature.Configuration> SULFUR_POOL_FEATURE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_pool"),
                    new SulfurPoolFeature());

    public static void initialize() {}
}