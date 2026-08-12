package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.tags.EBlockTags;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.*;
import team.lookingglass.elsewhere.worldgen.features.config.BlockColumnClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.ExposedDoubleDiskConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.BlockPatchConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.TidePoolConfiguration;
import team.lookingglass.elsewhere.worldgen.features.placers.PoplarFoliagePlacer;
import team.lookingglass.elsewhere.worldgen.features.placers.PoplarTrunkPlacer;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeClusterFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.SpikeFeature;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeBlockSet;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeConfiguration;

@SuppressWarnings("deprecation")
public interface EFeatures {

    Feature<BlockPatchConfiguration> BLOCK_PATCH = Registry.register(
            BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block_patch"),
            new BlockPatchFeature());

    Feature<BlockColumnClusterConfiguration> BLOCK_COLUMN_CLUSTER = Registry.register(
            BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "block_column_cluster"),
            new BlockColumnClusterFeature(BlockColumnClusterConfiguration.CODEC));

    Feature<LargeBlobFeature.LargeBlobConfiguration> LARGE_BLOCK_BLOB = Registry.register(
            BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "large_block_blob"),
            new LargeBlobFeature(LargeBlobFeature.LargeBlobConfiguration.CODEC));

    Feature<TidePoolConfiguration> TIDEPOOL = Registry.register(
            BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tidepool"),
            new TidePoolFeature(TidePoolConfiguration.CODEC));

    Feature<NoneFeatureConfiguration> AMETHYST_NODE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "amethyst_node"),
                    new AmethystNodeFeature());

    // Frigid Caves
    SpikeBlockSet ICICLE_BLOCKS = new SpikeBlockSet(
            Blocks.PACKED_ICE,
            EBlocks.ICICLE,
            EBlockTags.ICICLE_REPLACEABLE
    );

    Feature<SpikeConfiguration> ICICLE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle"),
                    new SpikeFeature(SpikeConfiguration.CODEC, ICICLE_BLOCKS));

    Feature<SpikeClusterConfiguration> ICICLE_CLUSTER =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_cluster"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, ICICLE_BLOCKS));

    // Sulfur Caves
    SpikeBlockSet SULFUR_SPIKE_BLOCKS = new SpikeBlockSet(
            EBlocks.SULFUR,
            EBlocks.SULFUR_SPIKE,
            EBlockTags.SULFUR_SPIKE_REPLACEABLE
    );

    Feature<SpikeConfiguration> SULFUR_SPIKE =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike"),
                    new SpikeFeature(SpikeConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    Feature<SpikeClusterConfiguration> SULFUR_SPIKE_CLUSTER =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_cluster"),
                    new SpikeClusterFeature(SpikeClusterConfiguration.CODEC, SULFUR_SPIKE_BLOCKS));

    Feature<LakeFeature.Configuration> SULFUR_POOL =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_pool"),
                    new SulfurPoolFeature());

    // Poplar Forest
    TrunkPlacerType<PoplarTrunkPlacer> POPLAR_TRUNK_PLACER =
            Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_trunk_placer"),
                    new TrunkPlacerType<>(PoplarTrunkPlacer.CODEC));

    FoliagePlacerType<PoplarFoliagePlacer> POPLAR_FOLIAGE_PLACER =
            Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_foliage_placer"),
                    new FoliagePlacerType<>(PoplarFoliagePlacer.CODEC));

    Feature<ArchFeature.ArchConfiguration> ARCH =
            Registry.register(BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "arch"),
                    new ArchFeature(ArchFeature.ArchConfiguration.CODEC));

    static void initialize() {}
}