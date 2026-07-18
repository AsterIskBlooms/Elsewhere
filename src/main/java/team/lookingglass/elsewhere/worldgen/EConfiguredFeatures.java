package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.tags.EBlockTags;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.blocktypes.PebbleBlock;
import team.lookingglass.elsewhere.worldgen.features.config.ExposedDoubleDiskConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.BlockPatchConfiguration;
import team.lookingglass.elsewhere.worldgen.features.placers.PoplarFoliagePlacer;
import team.lookingglass.elsewhere.worldgen.features.placers.PoplarTrunkPlacer;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeConfiguration;

import java.util.List;

public class EConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKY_OUTCROP_KEY = registerKey("rocky_outcrop");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBONNET_KEY = registerKey("bluebonnet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBONNET_DENSE_KEY = registerKey("bluebonnet_dense");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HIBISCUS_KEY = registerKey("hibiscus");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNDRA_RED_VEGETATION_KEY = registerKey("tundra_red_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNDRA_GREEN_VEGETATION_KEY = registerKey("tundra_green_grass_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_NODE_KEY = registerKey("amethyst_node");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_KEY = registerKey("icicle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_CLUSTER_KEY = registerKey("icicle_cluster");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_SPIKE_KEY = registerKey("sulfur_spike");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_SPIKE_CLUSTER_KEY = registerKey("sulfur_spike_cluster");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_POOL_KEY = registerKey("sulfur_pool");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEJEWELED_CALCITE_KEY = registerKey("bejeweled_calcite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_SMALL_KEY = registerKey("silver_ore_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_LARGE_KEY = registerKey("tin_ore_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_SMALL_KEY = registerKey("tin_ore_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PEBBLE_KEY = registerKey("pebble");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_ACACIA_KEY = registerKey("mega_acacia_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_KEY = registerKey("red_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_KEY = registerKey("orange_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_KEY = registerKey("yellow_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOM_POPLAR_KEY = registerKey("random_poplar_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SHRUB_PATCH_KEY = registerKey("red_shrub_patch");


    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        registerFeature(context, ROCKY_OUTCROP_KEY, EFeatures.EXPOSED_DOUBLE_DISK,
                new ExposedDoubleDiskConfiguration(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockPredicate.matchesBlocks(Blocks.GRAVEL, Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, EBlocks.ARID_DIRT),
                        1,

                        BlockStateProvider.simple(Blocks.STONE),
                        BlockPredicate.matchesBlocks(Blocks.STONE, Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, EBlocks.ARID_DIRT),
                        3,

                        UniformInt.of(4, 8)
                )
        );

        registerFeature(context, BLUEBONNET_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(EBlocks.BLUEBONNET.defaultBlockState(), 1)
                                        .build()
                        ),
                        BlockTags.DIRT, 3, 1, 6, 3));

        registerFeature(context, BLUEBONNET_DENSE_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(EBlocks.BLUEBONNET.defaultBlockState(), 1)
                                        .build()
                        ),
                        BlockTags.DIRT, 4, 1, 12, 6));

        registerFeature(context, HIBISCUS_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(EBlocks.RED_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.ORANGE_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.YELLOW_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.BLUE_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.PURPLE_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.PINK_HIBISCUS.defaultBlockState(), 1)
                                        .add(EBlocks.WHITE_HIBISCUS.defaultBlockState(), 1)
                                        .build()
                        ),
                        BlockTags.DIRT, 6, 3, 7, 5));

        registerFeature(context, TUNDRA_RED_VEGETATION_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(EBlocks.SHORT_RED_GRASS.defaultBlockState(), 8)
                                        .add(EBlocks.TALL_RED_GRASS.defaultBlockState(), 3)
                                        .add(EBlocks.RED_SHRUB.defaultBlockState(), 1)
                                        .build()
                        ),
                        EBlockTags.TUNDRA_RED_GRASS, 3, 1, 5, 2));

        registerFeature(context, TUNDRA_GREEN_VEGETATION_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(Blocks.SHORT_GRASS.defaultBlockState(), 8)
                                        .add(Blocks.TALL_GRASS.defaultBlockState(), 3)
                                        .add(Blocks.BUSH.defaultBlockState(), 1)
                                        .add(Blocks.FERN.defaultBlockState(), 1)
                                        .build()
                        ),
                        EBlockTags.TUNDRA_GREEN_GRASS, 3, 1, 5, 2));

        registerFeature(context, AMETHYST_NODE_KEY, EFeatures.AMETHYST_NODE, NoneFeatureConfiguration.INSTANCE);

        registerFeature(context, ICICLE_KEY, EFeatures.ICICLE,
                new SpikeConfiguration(0.2F, 0.7F, 0.5F, 0.5F));

        registerFeature(context, ICICLE_CLUSTER_KEY, EFeatures.ICICLE_CLUSTER,
                new SpikeClusterConfiguration(12, UniformInt.of(1, 7), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4),
                        UniformFloat.of(0.3F, 0.7F), ConstantFloat.ZERO, 0.1F, 3, 8));

        registerFeature(context, SULFUR_SPIKE_KEY, EFeatures.SULFUR_SPIKE,
                new SpikeConfiguration(0.2F, 0.7F, 0.5F, 0.5F));

        registerFeature(context, SULFUR_SPIKE_CLUSTER_KEY, EFeatures.SULFUR_SPIKE_CLUSTER,
                new SpikeClusterConfiguration(12, UniformInt.of(1, 7), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4),
                        UniformFloat.of(0.3F, 0.7F), ConstantFloat.ZERO, 0.1F, 3, 8));

        registerFeature(context, SULFUR_POOL_KEY, EFeatures.SULFUR_POOL,
                new LakeFeature.Configuration(
                        BlockStateProvider.simple(Blocks.WATER.defaultBlockState()),
                        BlockStateProvider.simple(EBlocks.SULFUR.defaultBlockState())
                )
        );

        registerFeature(context, BEJEWELED_CALCITE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CALCITE_ORE_REPLACEABLES), EBlocks.BEJEWELED_CALCITE.defaultBlockState())
                ),
                3  // vein size
        ));

        registerFeature(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CINNABAR_ORE_REPLACEABLES), EBlocks.CINNABAR_SILVER_ORE.defaultBlockState())
                ),
                3  // vein size
        ));
        registerFeature(context, SILVER_ORE_SMALL_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_SILVER_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CINNABAR_ORE_REPLACEABLES), EBlocks.CINNABAR_SILVER_ORE.defaultBlockState())
                ),
                1  // vein size
        ));

        registerFeature(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CINNABAR_ORE_REPLACEABLES), EBlocks.CINNABAR_TIN_ORE.defaultBlockState())
                ),
                6  // vein size
        ));
        registerFeature(context, TIN_ORE_LARGE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CINNABAR_ORE_REPLACEABLES), EBlocks.CINNABAR_TIN_ORE.defaultBlockState())
                ),
                12  // vein size
        ));
        registerFeature(context, TIN_ORE_SMALL_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EBlocks.TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.SHALE_ORE_REPLACEABLES), EBlocks.SHALE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EBlocks.DEEPSLATE_TIN_ORE.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(EBlockTags.CINNABAR_ORE_REPLACEABLES), EBlocks.CINNABAR_TIN_ORE.defaultBlockState())
                ),
                4  // vein size
        ));

        registerFeature(context, PEBBLE_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(new WeightedStateProvider(
                        WeightedList.<BlockState>builder()
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(PebbleBlock.FACING, Direction.NORTH))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(PebbleBlock.FACING, Direction.EAST))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(PebbleBlock.FACING, Direction.SOUTH))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(PebbleBlock.FACING, Direction.WEST))
                                .build()
                )));

        registerFeature(context, MEGA_ACACIA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.ACACIA_LOG),
                new MegaJungleTrunkPlacer(5, 2, 0),
                BlockStateProvider.simple(Blocks.ACACIA_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 1),
                new TwoLayersFeatureSize(7, 2, 5)
        ).build());

        registerFeature(context, RED_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new PoplarTrunkPlacer(7, 4, 0, ConstantInt.of(4), UniformInt.of(1, 4)),
                BlockStateProvider.simple(EBlocks.RED_POPLAR_LEAVES),
                new PoplarFoliagePlacer(
                        new WeightedListInt(WeightedList.<IntProvider>builder()
                                .add(ConstantInt.of(5), 5)
                                .add(ConstantInt.of(6), 5)
                                .add(ConstantInt.of(7), 1)
                                .add(ConstantInt.of(8), 1)
                                .build()),
                        ConstantInt.of(0), UniformInt.of(5, 6), 0.15F
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
        registerFeature(context, ORANGE_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new PoplarTrunkPlacer(7, 4, 0, ConstantInt.of(4), UniformInt.of(1, 4)),
                BlockStateProvider.simple(EBlocks.ORANGE_POPLAR_LEAVES),
                new PoplarFoliagePlacer(
                        new WeightedListInt(WeightedList.<IntProvider>builder()
                                .add(ConstantInt.of(5), 5)
                                .add(ConstantInt.of(6), 5)
                                .add(ConstantInt.of(7), 1)
                                .add(ConstantInt.of(8), 1)
                                .build()),
                        ConstantInt.of(0), UniformInt.of(5, 6), 0.15F
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
        registerFeature(context, YELLOW_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new PoplarTrunkPlacer(7, 4, 0, ConstantInt.of(4), UniformInt.of(1, 4)),
                BlockStateProvider.simple(EBlocks.YELLOW_POPLAR_LEAVES),
                new PoplarFoliagePlacer(
                        new WeightedListInt(WeightedList.<IntProvider>builder()
                                .add(ConstantInt.of(5), 5)
                                .add(ConstantInt.of(6), 5)
                                .add(ConstantInt.of(7), 1)
                                .add(ConstantInt.of(8), 1)
                                .build()),
                        ConstantInt.of(0), UniformInt.of(5, 6), 0.15F
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        registerFeature(context, RED_SHRUB_PATCH_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        BlockStateProvider.simple(EBlocks.RED_SHRUB),
                        BlockTags.DIRT, 3, 1, 4, 2));

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        registerFeature(context, RANDOM_POPLAR_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        List.of(
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(RED_POPLAR_KEY)), 0.33F),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(YELLOW_POPLAR_KEY)), 0.33F)
                        ),
                        PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(ORANGE_POPLAR_KEY))
                )
        );

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
