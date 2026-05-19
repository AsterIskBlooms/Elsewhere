package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.datagen.BlockTagProvider;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurSpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurSpikeConfiguration;

import java.util.List;

public class EConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKY_OUTCROP_KEY = registerKey("rocky_outcrop");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OUTBACK_GRASS_PATCH_KEY = registerKey("outback_grass_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBONNET_KEY = registerKey("bluebonnet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBONNET_DENSE_KEY = registerKey("bluebonnet_dense");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_NODE_KEY = registerKey("amethyst_node");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_SPIKE_KEY = registerKey("sulfur_spike");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_SPIKE_CLUSTER_KEY = registerKey("sulfur_spike_cluster");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_POOL_KEY = registerKey("sulfur_pool");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");



    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        registerFeature(context, ROCKY_OUTCROP_KEY, EFeatureTypes.ROCKY_OUTCROP_FEATURE, NoneFeatureConfiguration.INSTANCE);

        registerFeature(context, OUTBACK_GRASS_PATCH_KEY, EFeatureTypes.OUTBACK_GRASS_PATCH_FEATURE, NoneFeatureConfiguration.INSTANCE);

        registerFeature(context, BLUEBONNET_KEY, EFeatureTypes.BLUEBONNET_PATCH_FEATURE, NoneFeatureConfiguration.INSTANCE);
        registerFeature(context, BLUEBONNET_DENSE_KEY, EFeatureTypes.BLUEBONNET_DENSE_FEATURE, NoneFeatureConfiguration.INSTANCE);

        registerFeature(context, AMETHYST_NODE_KEY, EFeatureTypes.AMETHYST_NODE_FEATURE, NoneFeatureConfiguration.INSTANCE);

        registerFeature(context, SULFUR_SPIKE_KEY, EFeatureTypes.SULFUR_SPIKE_FEATURE,
                new SulfurSpikeConfiguration(0.2F, 0.7F, 0.5F, 0.5F));

        registerFeature(context, SULFUR_SPIKE_CLUSTER_KEY, EFeatureTypes.SULFUR_SPIKE_CLUSTER_FEATURE,
                new SulfurSpikeClusterConfiguration(12, UniformInt.of(1, 7), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4),
                        UniformFloat.of(0.3F, 0.7F), ConstantFloat.ZERO, 0.1F, 3, 8));

        registerFeature(context, SULFUR_POOL_KEY, EFeatureTypes.SULFUR_POOL_FEATURE,
                new LakeFeature.Configuration(
                        BlockStateProvider.simple(Blocks.WATER.defaultBlockState()),
                        BlockStateProvider.simple(EBlocks.SULFUR.defaultBlockState())
                )
        );

        registerFeature(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTagProvider.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState())
                ),
                8  // vein size
        ));



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerFeature(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
