package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlockTags;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.*;
import team.lookingglass.elsewhere.worldgen.features.config.ExposedDoubleDiskConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.BlockPatchConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeClusterFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeBlockSet;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeConfiguration;

@SuppressWarnings("deprecation")
public class EFeatures {

    public static final Feature<ExposedDoubleDiskConfiguration> EXPOSED_DOUBLE_DISK =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "exposed_double_disk"),
                    new ExposedDoubleDiskFeature(ExposedDoubleDiskConfiguration.CODEC));

    public static final Feature<BlockPatchConfiguration> BLOCK_PATCH = Registry.register(
            BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath("elsewhere", "flower_patch"),
            new BlockPatchFeature());

    public static final Feature<NoneFeatureConfiguration> AMETHYST_NODE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "amethyst_node"),
                    new AmethystNodeFeature());

    // Frigid Caves
    public static final SpikeBlockSet ICICLE_BLOCKS = new SpikeBlockSet(
            Blocks.PACKED_ICE,
            EBlocks.ICICLE,
            EBlockTags.ICICLE_REPLACEABLE
    );

    public static final Feature<SpikeConfiguration> ICICLE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle"),
                    new SpikeFeature(SpikeConfiguration.CODEC, ICICLE_BLOCKS));

    public static final Feature<SpikeClusterConfiguration> ICICLE_CLUSTER =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_cluster"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, ICICLE_BLOCKS));

    // Sulfur Caves
    public static final SpikeBlockSet SULFUR_SPIKE_BLOCKS = new SpikeBlockSet(
            EBlocks.SULFUR,
            EBlocks.SULFUR_SPIKE,
            EBlockTags.SULFUR_SPIKE_REPLACEABLE
    );

    public static final Feature<SpikeConfiguration> SULFUR_SPIKE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike"),
                    new SpikeFeature(SpikeConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    public static final Feature<SpikeClusterConfiguration> SULFUR_SPIKE_CLUSTER =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_cluster"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    public static final Feature<LakeFeature.Configuration> SULFUR_POOL =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_pool"),
                    new SulfurPoolFeature());

    public static void initialize() {}
}