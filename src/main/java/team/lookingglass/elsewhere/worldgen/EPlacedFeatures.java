package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.List;

public class EPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ROCKY_OUTCROP = registerKey("rocky_outcrop");

    public static final ResourceKey<PlacedFeature> FOREST_ROCK_SPARSE = registerKey("forest_rock_sparse");
    public static final ResourceKey<PlacedFeature> MEADOW_ROCK = registerKey("meadow_rock");

    public static final ResourceKey<PlacedFeature> BLUEBONNET = registerKey("bluebonnet");
    public static final ResourceKey<PlacedFeature> BLUEBONNET_DENSE = registerKey("bluebonnet_dense");

    public static final ResourceKey<PlacedFeature> HIBISCUS_JUNGLE = registerKey("hibiscus_jungle");
    public static final ResourceKey<PlacedFeature> HIBISCUS_SPARSE_JUNGLE = registerKey("hibiscus_sparse_jungle");

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

    public static final ResourceKey<PlacedFeature> RED_SHRUB_PATCH = registerKey("red_shrub_patch");

    public static final ResourceKey<PlacedFeature> EXTRA_LUSH_CACTUS = registerKey("extra_lush_cactus");

    public static final ResourceKey<PlacedFeature> AZALEA_SHRUB = registerKey("azalea_shrub");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configured = context.lookup(Registries.CONFIGURED_FEATURE);

        registerPlaced(context, ROCKY_OUTCROP,
                configured.getOrThrow(EConfiguredFeatures.ROCKY_OUTCROP_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(108),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        registerPlaced(context, FOREST_ROCK_SPARSE,
                configured.getOrThrow(MiscOverworldFeatures.FOREST_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        registerPlaced(context, MEADOW_ROCK,
                configured.getOrThrow(MiscOverworldFeatures.FOREST_ROCK),
                List.of(
                        RarityFilter.onAverageOnceEvery(36),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        // Hibiscus
        registerPlaced(context, HIBISCUS_JUNGLE,
                configured.getOrThrow(EConfiguredFeatures.HIBISCUS_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        registerPlaced(context, HIBISCUS_SPARSE_JUNGLE,
                configured.getOrThrow(EConfiguredFeatures.HIBISCUS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));


        // Bluebonnets :3
        registerPlaced(context, BLUEBONNET,
                configured.getOrThrow(EConfiguredFeatures.BLUEBONNET_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(6),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));
        registerPlaced(context, BLUEBONNET_DENSE,
                configured.getOrThrow(EConfiguredFeatures.BLUEBONNET_DENSE_KEY),
                List.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        registerPlaced(context, TUNDRA_RED_VEGETATION_PATCH,
                configured.getOrThrow(EConfiguredFeatures.TUNDRA_RED_VEGETATION_KEY),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));
        registerPlaced(context, TUNDRA_GREEN_VEGETATION_PATCH,
                configured.getOrThrow(EConfiguredFeatures.TUNDRA_GREEN_VEGETATION_KEY),
                List.of(
                        CountPlacement.of(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));

        // Amethyst Spires
        registerPlaced(context, AMETHYST_NODE,
                configured.getOrThrow(EConfiguredFeatures.AMETHYST_NODE_KEY),
                List.of(
                        CountPlacement.of(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));

        // Frigid Caves
        registerPlaced(context, ICICLE,
                configured.getOrThrow(EConfiguredFeatures.ICICLE_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                ));
        registerPlaced(context, ICICLE_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.ICICLE_CLUSTER_KEY),
                List.of(
                        CountPlacement.of(64),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));

        // Sulfur Caves
        registerPlaced(context, SULFUR_SPIKE,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                ));
        registerPlaced(context, SULFUR_SPIKE_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_CLUSTER_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                ));
        registerPlaced(context, SULFUR_POOL,
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

        registerPlaced(context, BEJEWELED_CALCITE,
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

        registerPlaced(context, SILVER_ORE,
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
        registerPlaced(context, SILVER_ORE_SMALL,
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

        registerPlaced(context, TIN_ORE,
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
        registerPlaced(context, TIN_ORE_LARGE,
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
        registerPlaced(context, TIN_ORE_SMALL,
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


        registerPlaced(context, PEBBLE,
                configured.getOrThrow(EConfiguredFeatures.PEBBLE_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));


        registerPlaced(context, DAPPLED_FOREST_TREES,
                configured.getOrThrow(EConfiguredFeatures.RANDOM_POPLAR_KEY),
                List.of(
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(EBlocks.POPLAR_SAPLING.defaultBlockState(), Vec3i.ZERO.below(0))),
                        BiomeFilter.biome()
                ));

        registerPlaced(context, RED_SHRUB_PATCH,
                configured.getOrThrow(EConfiguredFeatures.RED_SHRUB_PATCH_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(EBlocks.RED_SHRUB.defaultBlockState(), BlockPos.ZERO)))
                ));

        registerPlaced(context, EXTRA_LUSH_CACTUS,
                configured.getOrThrow(EConfiguredFeatures.LUSH_DESERT_CACTUS),
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.wouldSurvive(Blocks.CACTUS.defaultBlockState(), BlockPos.ZERO)))
                ));

        registerPlaced(context, AZALEA_SHRUB,
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


    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    private static void registerPlaced(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
