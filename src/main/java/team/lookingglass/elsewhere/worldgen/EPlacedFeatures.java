package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.features.placement.SeaLevelFilter;

import java.util.List;

public class EPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FOREST_ROCK_SPARSE = registerKey("forest_rock_sparse");
    public static final ResourceKey<PlacedFeature> MEADOW_ROCK = registerKey("meadow_rock");

    public static final ResourceKey<PlacedFeature> BLUEBONNET = registerKey("bluebonnet");
    public static final ResourceKey<PlacedFeature> BLUEBONNET_DENSE = registerKey("bluebonnet_dense");

    public static final ResourceKey<PlacedFeature> HIBISCUS_JUNGLE = registerKey("hibiscus_jungle");
    public static final ResourceKey<PlacedFeature> HIBISCUS_SPARSE_JUNGLE = registerKey("hibiscus_sparse_jungle");

    public static final ResourceKey<PlacedFeature> OUTBACK_ACACIA = registerKey("outback_acacia");
    public static final ResourceKey<PlacedFeature> OAK_SHRUBS = registerKey("oak_shrubs");
    public static final ResourceKey<PlacedFeature> JUNGLE_SHRUBS = registerKey("jungle_shrubs");
    public static final ResourceKey<PlacedFeature> CEDAR_FOREST_TREES = registerKey("cedar_forest_trees");
    public static final ResourceKey<PlacedFeature> CEDAR_TREES_SPARSE = registerKey("cedar_trees_sparse");

    public static final ResourceKey<PlacedFeature> WINDSWEPT_MAHOGANY = registerKey("windswept_mahogany");
    public static final ResourceKey<PlacedFeature> WINDSWEPT_SHRUB = registerKey("windswept_shrub");
    public static final ResourceKey<PlacedFeature> JUNGLE_TREES = registerKey("jungle_trees");
    public static final ResourceKey<PlacedFeature> SPARSE_JUNGLE_TREES = registerKey("sparse_jungle_trees");
    public static final ResourceKey<PlacedFeature> BAMBOO_JUNGLE_TREES = registerKey("bamboo_jungle_trees");

    public static final ResourceKey<PlacedFeature> FLOWER_FOREST_TREES = registerKey("flower_forest_trees");
    public static final ResourceKey<PlacedFeature> FLOWER_FOREST_WILDFLOWERS = registerKey("flower_forest_wildflowers");
    public static final ResourceKey<PlacedFeature> CHERRY_GROVE_BAMBOO = registerKey("cherry_grove_bamboo");
    public static final ResourceKey<PlacedFeature> SPARSE_CHERRY = registerKey("sparse_cherry");

    public static final ResourceKey<PlacedFeature> BIRCH_TREES = registerKey("birch_trees");
    public static final ResourceKey<PlacedFeature> OLD_GROWTH_BIRCH_TREES = registerKey("old_growth_birch_trees");

    public static final ResourceKey<PlacedFeature> TUNDRA_RED_VEGETATION_PATCH = registerKey("tundra_red_vegetation_patch");
    public static final ResourceKey<PlacedFeature> TUNDRA_GREEN_VEGETATION_PATCH = registerKey("tundra_green_vegetation_patch");

    public static final ResourceKey<PlacedFeature> AMETHYST_NODE = registerKey("amethyst_node");

    public static final ResourceKey<PlacedFeature> ICICLE = registerKey("icicle");
    public static final ResourceKey<PlacedFeature> ICICLE_CLUSTER = registerKey("icicle_cluster");

    public static final ResourceKey<PlacedFeature> SULFUR_SPIKE = registerKey("sulfur_spike");
    public static final ResourceKey<PlacedFeature> SULFUR_SPIKE_CLUSTER = registerKey("sulfur_spike_cluster");

    public static final ResourceKey<PlacedFeature> SULFUR_POOL = registerKey("sulfur_pool");

    public static final ResourceKey<PlacedFeature> BEJEWELED_CALCITE = registerKey("bejeweled_calcite");

    public static final ResourceKey<PlacedFeature> SILVER_ORE = registerKey("silver_ore");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_SMALL = registerKey("silver_ore_small");

    public static final ResourceKey<PlacedFeature> TIN_ORE = registerKey("tin_ore");
    public static final ResourceKey<PlacedFeature> TIN_ORE_LARGE = registerKey("tin_ore_large");
    public static final ResourceKey<PlacedFeature> TIN_ORE_SMALL = registerKey("tin_ore_small");

    public static final ResourceKey<PlacedFeature> PEBBLE = registerKey("pebble");

    public static final ResourceKey<PlacedFeature> DAPPLED_FOREST_TREES = registerKey("dappled_forest_trees");
    public static final ResourceKey<PlacedFeature> RUSTY_MOSS_PATCH = registerKey("rusty_moss_patch");

    public static final ResourceKey<PlacedFeature> MOSSY_MUD_PATCH = registerKey("mossy_mud_patch");

    public static final ResourceKey<PlacedFeature> LUSH_SHORT_CACTUS = registerKey("lush_short_cactus");
    public static final ResourceKey<PlacedFeature> LUSH_TALL_CACTUS = registerKey("lush_tall_cactus");
    public static final ResourceKey<PlacedFeature> DESERT_SHORT_CACTUS = registerKey("desert_short_cactus");
    public static final ResourceKey<PlacedFeature> DESERT_TALL_CACTUS = registerKey("desert_tall_cactus");
    public static final ResourceKey<PlacedFeature> AZALEA_SHRUB = registerKey("azalea_shrub");
    public static final ResourceKey<PlacedFeature> DENSE_DRY_GRASS = registerKey("dense_dry_grass");
    public static final ResourceKey<PlacedFeature> LUSH_DIRT_PATCH = registerKey("lush_dirt_patch");
    public static final ResourceKey<PlacedFeature> DESERT_DIRT_PATCH = registerKey("desert_dirt_patch");

    public static final ResourceKey<PlacedFeature> DESERT_ROCKS = registerKey("desert_rocks");
    public static final ResourceKey<PlacedFeature> LUSH_DESERT_ROCKS = registerKey("lush_desert_rocks");
    public static final ResourceKey<PlacedFeature> OUTBACK_ROCKS = registerKey("outback_rocks");

    public static final ResourceKey<PlacedFeature> BEACHSTONE_ROCKS = registerKey("beachstone_rocks");
    public static final ResourceKey<PlacedFeature> EXTRA_BEACHSTONE_ROCKS = registerKey("extra_beachstone_rocks");
    public static final ResourceKey<PlacedFeature> BEACHSTONE_ARCH = registerKey("beachstone_arch");

    public static final ResourceKey<PlacedFeature> ROCKWEED_BASALT_PATCH = registerKey("rockweed_basalt_patch");

    public static final ResourceKey<PlacedFeature> TIDEPOOL = registerKey("tidepool");
    public static final ResourceKey<PlacedFeature> STONY_TIDEPOOL = registerKey("stony_tidepool");

    public static final ResourceKey<PlacedFeature> SEAGRASS_EXTRA = registerKey("seagrass_extra");
    public static final ResourceKey<PlacedFeature> SEAGRASS_MID_EXTRA = registerKey("seagrass_mid_extra");
    public static final ResourceKey<PlacedFeature> KELP_CLUSTER = registerKey("kelp_cluster");

    public static final ResourceKey<PlacedFeature> CAVE_WEEDS = registerKey("cave_weeds");
    public static final ResourceKey<PlacedFeature> CAVE_ROOTS = registerKey("cave_roots");

    public static final ResourceKey<PlacedFeature> SWAMP_CATTAILS = registerKey("swamp_cattails");
    public static final ResourceKey<PlacedFeature> MANGROVE_CATTAILS = registerKey("mangrove_cattails");

    public static final ResourceKey<PlacedFeature> STEPPE_GRASS = registerKey("steppe_grass");
    public static final ResourceKey<PlacedFeature> STEPPE_PILLARS = registerKey("steppe_pillars");

    public static final ResourceKey<PlacedFeature> SWAMP_GRASS = registerKey("swamp_grass");

    public static final ResourceKey<PlacedFeature> BROUSH_TREES = registerKey("broush_trees");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configured = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, FOREST_ROCK_SPARSE,
                configured.getOrThrow(MiscOverworldFeatures.FOREST_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, MEADOW_ROCK,
                configured.getOrThrow(MiscOverworldFeatures.FOREST_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(36),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        // Hibiscus
        PlacementUtils.register(context, HIBISCUS_JUNGLE,
                configured.getOrThrow(EConfiguredFeatures.HIBISCUS_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, HIBISCUS_SPARSE_JUNGLE,
                configured.getOrThrow(EConfiguredFeatures.HIBISCUS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));


        // Bluebonnets :3
        PlacementUtils.register(context, BLUEBONNET,
                configured.getOrThrow(EConfiguredFeatures.BLUEBONNET_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(6),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, BLUEBONNET_DENSE,
                configured.getOrThrow(EConfiguredFeatures.BLUEBONNET_DENSE_KEY),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, TUNDRA_RED_VEGETATION_PATCH,
                configured.getOrThrow(EConfiguredFeatures.TUNDRA_RED_VEGETATION_KEY),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, TUNDRA_GREEN_VEGETATION_PATCH,
                configured.getOrThrow(EConfiguredFeatures.TUNDRA_GREEN_VEGETATION_KEY),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));

        // Amethyst Spires
        PlacementUtils.register(context, AMETHYST_NODE,
                configured.getOrThrow(EConfiguredFeatures.AMETHYST_NODE_KEY),
                List.of(
                        CountPlacement.of(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));

        // Frigid Caves
        PlacementUtils.register(context, ICICLE,
                configured.getOrThrow(EConfiguredFeatures.ICICLE_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, ICICLE_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.ICICLE_CLUSTER_KEY),
                List.of(
                        CountPlacement.of(64),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));

        // Sulfur Caves
        PlacementUtils.register(context, SULFUR_SPIKE,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, SULFUR_SPIKE_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_CLUSTER_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, SULFUR_POOL,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_POOL_KEY),
                List.of(
                        CountPlacement.of(316),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BlockPredicateFilter.forPredicate(BlockPredicate.solid()),
                        EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, 32),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(EBlocks.SULFUR)),
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, BEJEWELED_CALCITE,
                configured.getOrThrow(EConfiguredFeatures.BEJEWELED_CALCITE_KEY),
                List.of(
                        CountPlacement.of(464),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-24),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, SILVER_ORE,
                configured.getOrThrow(EConfiguredFeatures.SILVER_ORE_KEY),
                List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                TrapezoidHeight.of(
                                        VerticalAnchor.absolute(-24),
                                        VerticalAnchor.absolute(24),
                                        24
                                )
                        ),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, SILVER_ORE_SMALL,
                configured.getOrThrow(EConfiguredFeatures.SILVER_ORE_SMALL_KEY),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-48),
                                VerticalAnchor.absolute(52)
                        ),
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, TIN_ORE,
                configured.getOrThrow(EConfiguredFeatures.TIN_ORE_KEY),
                List.of(
                        CountPlacement.of(18),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                TrapezoidHeight.of(
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(72),
                                        30
                                )
                        ),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, TIN_ORE_LARGE,
                configured.getOrThrow(EConfiguredFeatures.TIN_ORE_LARGE_KEY),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(-80),
                                VerticalAnchor.absolute(-30)
                        ),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, TIN_ORE_SMALL,
                configured.getOrThrow(EConfiguredFeatures.TIN_ORE_SMALL_KEY),
                List.of(
                        CountPlacement.of(24),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(68),
                                VerticalAnchor.absolute(180)
                        ),
                        BiomeFilter.biome()
                ));


        PlacementUtils.register(context, PEBBLE,
                configured.getOrThrow(EConfiguredFeatures.PEBBLE_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(EBlocks.PEBBLE.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, OUTBACK_ACACIA,
                configured.getOrThrow(EConfiguredFeatures.MEGA_ACACIA_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(Blocks.ACACIA_SAPLING.defaultBlockState(), Vec3i.ZERO.below(0))),
                        BiomeFilter.biome()
                ));


        PlacementUtils.register(context, DAPPLED_FOREST_TREES,
                configured.getOrThrow(EConfiguredFeatures.DAPPLED_FOREST_TREES),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1F, 1), EBlocks.POPLAR_SAPLING));

        PlacementUtils.register(context, RUSTY_MOSS_PATCH,
                configured.getOrThrow(EConfiguredFeatures.RUSTY_MOSS_PATCH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, MOSSY_MUD_PATCH,
                configured.getOrThrow(EConfiguredFeatures.MOSSY_MUD_PATCH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, LUSH_DIRT_PATCH,
                configured.getOrThrow(EConfiguredFeatures.COARSE_DIRT_PATCH),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, DESERT_DIRT_PATCH,
                configured.getOrThrow(EConfiguredFeatures.COARSE_DIRT_PATCH),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, LUSH_DESERT_ROCKS,
                configured.getOrThrow(EConfiguredFeatures.LUSH_SANDSTONE_ROCKS),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, DESERT_ROCKS,
                configured.getOrThrow(EConfiguredFeatures.SANDSTONE_ROCK),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, OUTBACK_ROCKS,
                configured.getOrThrow(EConfiguredFeatures.RED_SANDSTONE_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, LUSH_SHORT_CACTUS,
                configured.getOrThrow(EConfiguredFeatures.SHORT_CACTUS),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, LUSH_TALL_CACTUS,
                configured.getOrThrow(EConfiguredFeatures.TALL_CACTUS),
                List.of(
                        RarityFilter.onAverageOnceEvery(6),
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, DESERT_SHORT_CACTUS,
                configured.getOrThrow(EConfiguredFeatures.SHORT_CACTUS),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, DESERT_TALL_CACTUS,
                configured.getOrThrow(EConfiguredFeatures.TALL_CACTUS),
                List.of(
                        RarityFilter.onAverageOnceEvery(7),
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, AZALEA_SHRUB,
                configured.getOrThrow(EConfiguredFeatures.AZALEA_SHRUB_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, OAK_SHRUBS,
                configured.getOrThrow(EConfiguredFeatures.OAK_SHRUB),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, JUNGLE_SHRUBS,
                configured.getOrThrow(EConfiguredFeatures.JUNGLE_SHRUB),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.JUNGLE_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, CEDAR_FOREST_TREES,
                configured.getOrThrow(EConfiguredFeatures.TREES_CEDAR_AND_OAK_LEAF_LITTER),
                List.of(
                        CountPlacement.of(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(EBlocks.CEDAR_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, CEDAR_TREES_SPARSE,
                configured.getOrThrow(EConfiguredFeatures.CEDAR_TREE),
                List.of(
                        RarityFilter.onAverageOnceEvery(5),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(EBlocks.CEDAR_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, WINDSWEPT_MAHOGANY,
                configured.getOrThrow(EConfiguredFeatures.MAHOGANY_TREE),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(EBlocks.MAHOGANY_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, WINDSWEPT_SHRUB,
                configured.getOrThrow(EConfiguredFeatures.JUNGLE_SHRUB),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.JUNGLE_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, JUNGLE_TREES,
                configured.getOrThrow(EConfiguredFeatures.JUNGLE_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1), Blocks.JUNGLE_SAPLING)
        );
        PlacementUtils.register(context, SPARSE_JUNGLE_TREES,
                configured.getOrThrow(EConfiguredFeatures.SPARSE_JUNGLE_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1), Blocks.JUNGLE_SAPLING)
        );
        PlacementUtils.register(context, BAMBOO_JUNGLE_TREES,
                configured.getOrThrow(EConfiguredFeatures.BAMBOO_JUNGLE_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(30, 0.1F, 1), Blocks.JUNGLE_SAPLING)
        );

        PlacementUtils.register(context, FLOWER_FOREST_TREES,
                configured.getOrThrow(EConfiguredFeatures.FLOWER_FOREST_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1F, 1), Blocks.OAK_SAPLING)
        );
        PlacementUtils.register(context, FLOWER_FOREST_WILDFLOWERS,
                configured.getOrThrow(EConfiguredFeatures.SPARSE_FOREST_FLOWERS),
                List.of(
                        CountPlacement.of(63),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.WILDFLOWERS.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, CHERRY_GROVE_BAMBOO,
                configured.getOrThrow(VegetationFeatures.BAMBOO_NO_PODZOL),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.BAMBOO.defaultBlockState(), BlockPos.ZERO)))
                ));
        PlacementUtils.register(context, SPARSE_CHERRY,
                configured.getOrThrow(TreeFeatures.CHERRY_BEES_005),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1), Blocks.CHERRY_SAPLING)
        );

        PlacementUtils.register(context, BIRCH_TREES,
                configured.getOrThrow(EConfiguredFeatures.OLD_GROWTH_BIRCH_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING)
        );
        PlacementUtils.register(context, OLD_GROWTH_BIRCH_TREES,
                configured.getOrThrow(EConfiguredFeatures.OLD_GROWTH_BIRCH_TREES_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING)
        );

        PlacementUtils.register(context, DENSE_DRY_GRASS,
                configured.getOrThrow(VegetationFeatures.DRY_GRASS),
                List.of(
                        CountPlacement.of(18),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.SHORT_DRY_GRASS.defaultBlockState(), BlockPos.ZERO)))
                ));

        PlacementUtils.register(context, BEACHSTONE_ROCKS,
                configured.getOrThrow(EConfiguredFeatures.BEACHSTONE_ROCK_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.SHORT_GRASS.defaultBlockState(), Vec3i.ZERO)))
                ));
        PlacementUtils.register(context, EXTRA_BEACHSTONE_ROCKS,
                configured.getOrThrow(EConfiguredFeatures.BEACHSTONE_ROCK_KEY),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.SHORT_GRASS.defaultBlockState(), Vec3i.ZERO)))
                ));

        PlacementUtils.register(context, ROCKWEED_BASALT_PATCH,
                configured.getOrThrow(EConfiguredFeatures.ROCKWEED_BASALT_PATCH_KEY),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, TIDEPOOL,
                configured.getOrThrow(EConfiguredFeatures.TIDEPOOL_KEY),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, 32),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.SAND)),
                        SeaLevelFilter.of(-1, 0)
                ));

        PlacementUtils.register(context, STONY_TIDEPOOL,
                configured.getOrThrow(EConfiguredFeatures.STONY_TIDEPOOL_KEY),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, 32),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.GRAVEL)),
                        SeaLevelFilter.of(-1, 0)
                ));

        PlacementUtils.register(context, SEAGRASS_EXTRA,
                configured.getOrThrow(AquaticFeatures.SEAGRASS_SHORT),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, SEAGRASS_MID_EXTRA,
                configured.getOrThrow(AquaticFeatures.SEAGRASS_MID),
                List.of(
                        CountPlacement.of(8),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, KELP_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.RANDOM_SHORT_KELP),
                List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, BEACHSTONE_ARCH,
                configured.getOrThrow(EConfiguredFeatures.BEACHSTONE_ARCH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(5),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, CAVE_WEEDS,
                configured.getOrThrow(EConfiguredFeatures.CAVE_WEEDS_KEY),
                List.of(
                        CountPlacement.of(40),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.bottom(),
                                VerticalAnchor.absolute(60)
                        ),
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(EBlocks.CAVE_WEED.defaultBlockState(), Vec3i.ZERO)))
                ));
        PlacementUtils.register(context, CAVE_ROOTS,
                configured.getOrThrow(EConfiguredFeatures.CAVE_ROOTED_DIRT),
                List.of(
                        CountPlacement.of(15),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(
                                Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12
                        ),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                        BiomeFilter.biome()
                ));


        PlacementUtils.register(context, SWAMP_CATTAILS,
                configured.getOrThrow(EConfiguredFeatures.CATTAILS),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                        SurfaceWaterDepthFilter.forMaxDepth(1),
                        SeaLevelFilter.of(-3, -1),
                        BiomeFilter.biome()
                ));
        PlacementUtils.register(context, MANGROVE_CATTAILS,
                configured.getOrThrow(EConfiguredFeatures.CATTAILS),
                List.of(
                        CountPlacement.of(5),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                        SurfaceWaterDepthFilter.forMaxDepth(1),
                        SeaLevelFilter.of(-3, -1),
                        BiomeFilter.biome()
                ));

        PlacementUtils.register(context, STEPPE_GRASS,
                configured.getOrThrow(VegetationFeatures.TALL_GRASS),
                List.of(
                        CountPlacement.of(28),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.TALL_GRASS.defaultBlockState(), Vec3i.ZERO)))
                ));
        PlacementUtils.register(context, STEPPE_PILLARS,
                configured.getOrThrow(EConfiguredFeatures.LIMESTONE_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(9),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.SHORT_GRASS.defaultBlockState(), Vec3i.ZERO)))
                ));

        PlacementUtils.register(context, SWAMP_GRASS,
                configured.getOrThrow(VegetationFeatures.GRASS_JUNGLE),
                List.of(
                        CountPlacement.of(232),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(Blocks.SHORT_GRASS.defaultBlockState(), Vec3i.ZERO)))
                ));






        PlacementUtils.register(context, BROUSH_TREES,
                configured.getOrThrow(EConfiguredFeatures.MAHOGANY_TREE),
                List.of(
                        CountPlacement.of(55),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.wouldSurvive(EBlocks.MAHOGANY_SAPLING.defaultBlockState(), BlockPos.ZERO)))
                ));


    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }
}
