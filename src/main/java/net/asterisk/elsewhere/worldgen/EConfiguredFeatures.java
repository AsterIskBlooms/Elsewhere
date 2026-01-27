package net.asterisk.elsewhere.worldgen;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.registry.EBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class EConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> TAUTWOOD = resourceKey("tautwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_TAUTWOOD = resourceKey("mega_tautwood");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Tautwood Tree
        register(context, TAUTWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.TAUTWOOD_LOG),
                new StraightTrunkPlacer(8, 11, 6),

                BlockStateProvider.simple(EBlocks.TAUTWOOD_LEAVES),
                new MegaJungleFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 2),

                new TwoLayersFeatureSize(1, 0,2))

                .build()
        );
        register(context, MEGA_TAUTWOOD, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.TAUTWOOD_LOG),
                new MegaJungleTrunkPlacer(13, 18, 9),

                BlockStateProvider.simple(EBlocks.TAUTWOOD_LEAVES),
                new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),

                new TwoLayersFeatureSize(1, 0,2))

                .build()
        );


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature,
                                                                                          FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
