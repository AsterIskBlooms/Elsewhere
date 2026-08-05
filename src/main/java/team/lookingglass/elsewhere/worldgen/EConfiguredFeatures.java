package team.lookingglass.elsewhere.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Fluids;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.tags.EBlockTags;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.blocktypes.PebbleBlock;
import team.lookingglass.elsewhere.worldgen.features.ArchFeature;
import team.lookingglass.elsewhere.worldgen.features.LargeBlobFeature;
import team.lookingglass.elsewhere.worldgen.features.config.BlockColumnClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.ExposedDoubleDiskConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.BlockPatchConfiguration;
import team.lookingglass.elsewhere.worldgen.features.config.TidePoolConfiguration;
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = registerKey("oak_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEDAR_TREE = registerKey("cedar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CEDAR_TREE_LEAF_LITTER = registerKey("cedar_tree_leaf_litter");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_CEDAR_LEAF_LITTER = registerKey("tall_cedar_leaf_litter");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_CEDAR_TREE = registerKey("fallen_cedar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CEDAR_AND_OAK_LEAF_LITTER = registerKey("trees_cedar_and_oak_leaf_litter");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE = registerKey("mahogany_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_KEY = registerKey("red_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_KEY = registerKey("orange_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_KEY = registerKey("yellow_poplar_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOM_POPLAR_KEY = registerKey("random_poplar_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SHRUB_PATCH_KEY = registerKey("red_shrub_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_CACTUS = registerKey("tall_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_CACTUS = registerKey("short_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_PATCH = registerKey("coarse_dirt_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AZALEA_SHRUB_KEY = registerKey("azalea_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_ROCK = registerKey("sandstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SANDSTONE_ROCK = registerKey("red_sandstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SANDSTONE_ROCK = registerKey("pink_sandstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_SANDSTONE_ROCKS = registerKey("lush_sandstone_rocks");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUSTY_MOSS_VEGETATION = registerKey("rusty_moss_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUSTY_MOSS_PATCH_KEY = registerKey("rusty_moss_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUSTY_MOSS_PATCH_BONEMEAL = registerKey("rusty_moss_patch_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHSTONE_ROCK_KEY = registerKey("beachstone_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKWEED_BASALT_PATCH_KEY = registerKey("rockweed_basalt_patch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TIDEPOOL_KEY = registerKey("tidepool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONY_TIDEPOOL_KEY = registerKey("stony_tidepool");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_KELP = registerKey("short_kelp");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_KELP = registerKey("medium_kelp");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_KELP = registerKey("tall_kelp");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOM_SHORT_KELP = registerKey("random_short_kelp");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHSTONE_ARCH_KEY = registerKey("beachstone_arch");


    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
        PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));
        BeehiveDecorator beehive = new BeehiveDecorator(0.002F);

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
                                        .add(EBlocks.SHORT_RED_GRASS.defaultBlockState(), 18)
                                        .add(EBlocks.TALL_RED_GRASS.defaultBlockState(), 2)
                                        .add(EBlocks.RED_SHRUB.defaultBlockState(), 1)
                                        .build()
                        ),
                        EBlockTags.TUNDRA_RED_GRASS, 3, 1, 5, 2));

        registerFeature(context, TUNDRA_GREEN_VEGETATION_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(Blocks.SHORT_GRASS.defaultBlockState(), 10)
                                        .add(Blocks.TALL_GRASS.defaultBlockState(), 1)
                                        .add(Blocks.BUSH.defaultBlockState(), 2)
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
                15  // vein size
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
                new GiantTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(Blocks.ACACIA_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1), ConstantInt.of(4),
                        0.25F, 0.75F, 0.40F, 0.35F),
                new TwoLayersFeatureSize(5, 4, 7)
        ).build());

        registerFeature(context, RED_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new ForkingTrunkPlacer(4, 2, 3),
                BlockStateProvider.simple(EBlocks.RED_POPLAR_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(6),
                        0.25F, 0.75F, 0.22F, 0.08F),
                new TwoLayersFeatureSize(2, 0, 3)
        ).build());
        registerFeature(context, ORANGE_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new ForkingTrunkPlacer(4, 2, 3),
                BlockStateProvider.simple(EBlocks.ORANGE_POPLAR_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(6),
                        0.25F, 0.75F, 0.22F, 0.08F),
                new TwoLayersFeatureSize(2, 0, 3)
        ).build());
        registerFeature(context, YELLOW_POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.POPLAR_LOG),
                new ForkingTrunkPlacer(4, 2, 3),
                BlockStateProvider.simple(EBlocks.YELLOW_POPLAR_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), ConstantInt.of(6),
                        0.25F, 0.75F, 0.22F, 0.08F),
                new TwoLayersFeatureSize(2, 0, 3)
        ).build());

        registerFeature(context, RANDOM_POPLAR_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        List.of(
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(RED_POPLAR_KEY)), 0.33F),
                                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(YELLOW_POPLAR_KEY)), 0.33F)
                        ),
                        PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(ORANGE_POPLAR_KEY))
                )
        );

        registerFeature(context, RED_SHRUB_PATCH_KEY, EFeatures.BLOCK_PATCH,
                new BlockPatchConfiguration(
                        BlockStateProvider.simple(EBlocks.RED_SHRUB.defaultBlockState()),
                        BlockTags.DIRT, 2, 1, 2, 2));

        registerFeature(context, SHORT_CACTUS, Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(
                        List.of(BlockColumnConfiguration.layer(BiasedToBottomInt.of(1, 2), BlockStateProvider.simple(Blocks.CACTUS)),
                                BlockColumnConfiguration.layer(new WeightedListInt(WeightedList.<IntProvider>builder()
                                                .add(ConstantInt.of(0), 3).add(ConstantInt.of(1), 2).build()),
                                        BlockStateProvider.simple(Blocks.CACTUS_FLOWER))),
                        Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, false)
        );
        registerFeature(context, TALL_CACTUS, Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(
                        List.of(BlockColumnConfiguration.layer(UniformInt.of(4, 6), BlockStateProvider.simple(Blocks.CACTUS)),
                                BlockColumnConfiguration.layer(new WeightedListInt(WeightedList.<IntProvider>builder()
                                                .add(ConstantInt.of(0), 3).add(ConstantInt.of(1), 2).build()),
                                        BlockStateProvider.simple(Blocks.CACTUS_FLOWER))),
                        Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, false)
        );

        registerFeature(context, SANDSTONE_ROCK, EFeatures.LARGE_BLOCK_BLOB,
                new LargeBlobFeature.LargeBlobConfiguration(Blocks.SANDSTONE.defaultBlockState(), BlockPredicate.matchesTag(BlockTags.SAND), UniformInt.of(3, 5)));
        registerFeature(context, RED_SANDSTONE_ROCK, EFeatures.LARGE_BLOCK_BLOB,
                new LargeBlobFeature.LargeBlobConfiguration(Blocks.RED_SANDSTONE.defaultBlockState(), BlockPredicate.matchesTag(BlockTags.SAND), UniformInt.of(3, 5)));
        registerFeature(context, PINK_SANDSTONE_ROCK, EFeatures.LARGE_BLOCK_BLOB,
                new LargeBlobFeature.LargeBlobConfiguration(EBlocks.PINK_SANDSTONE.defaultBlockState(), BlockPredicate.matchesTag(BlockTags.SAND), UniformInt.of(3, 5)));
        registerFeature(context, LUSH_SANDSTONE_ROCKS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SANDSTONE_ROCK)), 0.5F),
                new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(PINK_SANDSTONE_ROCK)), 0.5F)),
                PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SANDSTONE_ROCK))));

        registerFeature(context, COARSE_DIRT_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
                EBlockTags.SOIL, BlockStateProvider.simple(Blocks.COARSE_DIRT),
                PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(VegetationFeatures.GRASS)), CaveSurface.FLOOR,
                ConstantInt.of(1), 0.4F, 5, 0.25F, UniformInt.of(2, 4), 0.75F)
        );

        registerFeature(context, AZALEA_SHRUB_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.AZALEA_LOG),
                new StraightTrunkPlacer(1, 0, 0),
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(Blocks.AZALEA_LEAVES.defaultBlockState(), 4)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)
                        .build()),
                new BushFoliagePlacer(UniformInt.of(1, 2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(0, 0, 2)
        ).build());

        registerFeature(context, OAK_SHRUB, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(1, 0, 0),
                BlockStateProvider.simple(Blocks.OAK_LEAVES),
                new BushFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(0, 0, 2)
        ).build());

        registerFeature(context, CEDAR_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.CEDAR_LOG),
                new StraightTrunkPlacer(6, 1, 1),
                BlockStateProvider.simple(EBlocks.CEDAR_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(3)),
                new TwoLayersFeatureSize(2, 0, 1)
        ).decorators(List.of(beehive)).build());
        registerFeature(context, CEDAR_TREE_LEAF_LITTER, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.CEDAR_LOG),
                new StraightTrunkPlacer(6, 1, 1),
                BlockStateProvider.simple(EBlocks.CEDAR_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(3)),
                new TwoLayersFeatureSize(2, 0, 1)
        ).decorators(List.of(sparseLeafLitter, thickLeafLitter, beehive)).build());
        registerFeature(context, TALL_CEDAR_LEAF_LITTER, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EBlocks.CEDAR_LOG),
                new StraightTrunkPlacer(10, 2, 1),
                BlockStateProvider.simple(EBlocks.CEDAR_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(4)),
                new TwoLayersFeatureSize(5, 0, 2)
        ).decorators(List.of(sparseLeafLitter, thickLeafLitter, beehive)).build());
        registerFeature(context, FALLEN_CEDAR_TREE, Feature.FALLEN_TREE, createFallenTrees(EBlocks.CEDAR_LOG, 5, 8)
                .stumpDecorators(ImmutableList.of(TrunkVineDecorator.INSTANCE)).build());

        registerFeature(context, TREES_CEDAR_AND_OAK_LEAF_LITTER, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(CEDAR_TREE_LEAF_LITTER)), 0.2F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TALL_CEDAR_LEAF_LITTER)), 0.035F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(FALLEN_CEDAR_TREE)), 0.005F),

                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_BEES_0002_LEAF_LITTER), 0.15F),
                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.FANCY_OAK_BEES_0002_LEAF_LITTER), 0.025F),
                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.FALLEN_OAK_TREE), 0.005F)
                ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(CEDAR_TREE_LEAF_LITTER))));

        registerFeature(context, MAHOGANY_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                new ForkingTrunkPlacer(7, 2, 3),
                BlockStateProvider.simple(Blocks.AZALEA_LEAVES),
                new AcaciaFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(0)),
                new TwoLayersFeatureSize(6, 0, 4)
        ).build());

        registerFeature(context, RUSTY_MOSS_VEGETATION, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(new WeightedStateProvider(
                        WeightedList.<BlockState>builder()
                                .add(EBlocks.RUSTY_MOSS_CARPET.defaultBlockState(), 15)
                                .add(Blocks.SHORT_GRASS.defaultBlockState(), 15)
                                .add(EBlocks.RED_SHRUB.defaultBlockState(), 5)
                        )));
        registerFeature(context, RUSTY_MOSS_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.simple(EBlocks.RUSTY_MOSS_BLOCK),
                        PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(RUSTY_MOSS_VEGETATION)),
                        CaveSurface.FLOOR, ConstantInt.of(1),
                        0.0F, 5, 0.5F,
                        UniformInt.of(4, 7), 0.3F
                ));
        registerFeature(context, RUSTY_MOSS_PATCH_BONEMEAL, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.simple(EBlocks.RUSTY_MOSS_BLOCK),
                        PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(RUSTY_MOSS_VEGETATION)),
                        CaveSurface.FLOOR, ConstantInt.of(1),
                        0.0F, 5, 0.6F,
                        UniformInt.of(1, 2), 0.75F
                ));

        registerFeature(context, BEACHSTONE_ROCK_KEY, EFeatures.BLOCK_COLUMN_CLUSTER,
                new BlockColumnClusterConfiguration(
                        List.of(BlockColumnConfiguration.layer(UniformInt.of(2, 4), BlockStateProvider.simple(EBlocks.BEACHSTONE.defaultBlockState()))),
                        Direction.UP,
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        true,
                        UniformInt.of(2, 3),
                        UniformInt.of(2, 3),
                        UniformInt.of(-1, 2),
                        UniformInt.of(3, 4)
                )
        );

        registerFeature(context, ROCKWEED_BASALT_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        EBlockTags.NATURAL_STONE_BLOCKS,
                        BlockStateProvider.simple(EBlocks.ROCKWEED_BASALT),
                        PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(VegetationFeatures.DRY_GRASS)),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.4F,
                        5,
                        0.25F,
                        UniformInt.of(2, 3),
                        0.75F
                )
        );

        registerFeature(context, TIDEPOOL_KEY, EFeatures.TIDEPOOL,
                new TidePoolConfiguration(
                        UniformInt.of(2, 3), UniformInt.of(2, 4), UniformInt.of(1, 4),
                        UniformInt.of(1, 3), UniformInt.of(6, 8), ConstantInt.of(1),
                        UniformInt.of(1, 2), ConstantInt.of(1), 0.65F,
                        ConstantInt.of(6), UniformInt.of(5, 7),
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(Blocks.SMOOTH_BASALT.defaultBlockState(), 1)
                                .add(EBlocks.ROCKWEED_BASALT.defaultBlockState(), 1)
                                .build()),
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(Blocks.BASALT.defaultBlockState(), 4)
                                .add(Blocks.SMOOTH_BASALT.defaultBlockState(), 1)
                                .add(EBlocks.ROCKWEED_BASALT.defaultBlockState(), 2)
                                .build()),
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(PebbleBlock.FACING, Direction.NORTH), 8)
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(PebbleBlock.FACING, Direction.EAST), 8)
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(PebbleBlock.FACING, Direction.WEST), 8)
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(PebbleBlock.FACING, Direction.SOUTH), 8)
                                .add(Blocks.SEA_PICKLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(SeaPickleBlock.PICKLES, 1), 5)
                                .add(Blocks.SEA_PICKLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(SeaPickleBlock.PICKLES, 2), 5)
                                .add(Blocks.SEA_PICKLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(SeaPickleBlock.PICKLES, 3), 3)
                                .add(Blocks.SEA_PICKLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
                                        .setValue(SeaPickleBlock.PICKLES, 4), 1)
                                .build()),
                        0.05F, 0.35F, 0.35F
                )
        );
        registerFeature(context, STONY_TIDEPOOL_KEY, EFeatures.TIDEPOOL,
                new TidePoolConfiguration(
                        UniformInt.of(2, 3), UniformInt.of(4, 6), UniformInt.of(1, 4),
                        UniformInt.of(1, 3), UniformInt.of(6, 8), ConstantInt.of(1),
                        UniformInt.of(1, 2), ConstantInt.of(1), 0.65F,
                        ConstantInt.of(6), UniformInt.of(5, 7),
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(Blocks.GRAVEL.defaultBlockState(), 2)
                                .add(Blocks.TUFF.defaultBlockState(), 1)
                                .add(Blocks.SMOOTH_BASALT.defaultBlockState(), 1)
                                .build()),
                        BlockStateProvider.simple(Blocks.BASALT.defaultBlockState()),
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true).setValue(PebbleBlock.FACING, Direction.NORTH))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true).setValue(PebbleBlock.FACING, Direction.EAST))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true).setValue(PebbleBlock.FACING, Direction.WEST))
                                .add(EBlocks.PEBBLE.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true).setValue(PebbleBlock.FACING, Direction.SOUTH))
                                .build()),
                        0.05F, 0.45F, 0.35F
                )
        );

        registerFeature(context, SHORT_KELP, Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(List.of(
                        BlockColumnConfiguration.layer(UniformInt.of(0, 3), BlockStateProvider.simple(Blocks.KELP_PLANT.defaultBlockState())),
                        BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(Blocks.KELP.defaultBlockState().setValue(KelpBlock.AGE, 25)))),
                        Direction.UP, BlockPredicate.matchesFluids(Fluids.WATER), false)
        );
        registerFeature(context, MEDIUM_KELP, Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(List.of(
                        BlockColumnConfiguration.layer(UniformInt.of(5, 9), BlockStateProvider.simple(Blocks.KELP_PLANT.defaultBlockState())),
                        BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(Blocks.KELP.defaultBlockState().setValue(KelpBlock.AGE, 25)))),
                        Direction.UP, BlockPredicate.matchesFluids(Fluids.WATER), false)
        );
        registerFeature(context, TALL_KELP, Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(List.of(
                        BlockColumnConfiguration.layer(UniformInt.of(13, 22), BlockStateProvider.simple(Blocks.KELP_PLANT.defaultBlockState())),
                        BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(Blocks.KELP.defaultBlockState().setValue(KelpBlock.AGE, 25)))),
                        Direction.UP, BlockPredicate.matchesFluids(Fluids.WATER), false)
        );

        registerFeature(context, RANDOM_SHORT_KELP, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SHORT_KELP)), 0.6F),
                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(MEDIUM_KELP)), 0.4F)
                ), PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(SHORT_KELP))));

        registerFeature(context, BEACHSTONE_ARCH_KEY, EFeatures.ARCH,
                new ArchFeature.ArchConfiguration(
                        BlockStateProvider.simple(EBlocks.BEACHSTONE.defaultBlockState()),
                        UniformInt.of(5, 7), UniformInt.of(9, 11), ConstantInt.of(2))
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

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenTrees(final Block logBlock, final int minLength, final int maxLength) {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder(BlockStateProvider.simple(logBlock), UniformInt.of(minLength, maxLength))
                .logDecorators(ImmutableList.of(new AttachedToLogsDecorator(0.1F,
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(Blocks.RED_MUSHROOM.defaultBlockState(), 2)
                                .add(Blocks.BROWN_MUSHROOM.defaultBlockState(), 1)),
                        List.of(Direction.UP)))
        );
    }
}
