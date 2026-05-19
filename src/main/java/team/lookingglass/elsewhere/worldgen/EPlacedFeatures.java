package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.List;

public class EPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ROCKY_OUTCROP = registerKey("rocky_outcrop");

    public static final ResourceKey<PlacedFeature> OUTBACK_GRASS_PATCH = registerKey("outback_grass_patch");

    public static final ResourceKey<PlacedFeature> BLUEBONNET = registerKey("bluebonnet");
    public static final ResourceKey<PlacedFeature> BLUEBONNET_DENSE = registerKey("bluebonnet_dense");

    public static final ResourceKey<PlacedFeature> AMETHYST_NODE = registerKey("amethyst_node");

    public static final ResourceKey<PlacedFeature> SULFUR_SPIKE = registerKey("sulfur_spike");
    public static final ResourceKey<PlacedFeature> SULFUR_SPIKE_CLUSTER = registerKey("sulfur_spike_cluster");

    public static final ResourceKey<PlacedFeature> SULFUR_POOL = registerKey("sulfur_pool");

    public static final ResourceKey<PlacedFeature> SILVER_ORE = registerKey("silver_ore");


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

        registerPlaced(context, OUTBACK_GRASS_PATCH,
                configured.getOrThrow(EConfiguredFeatures.OUTBACK_GRASS_PATCH_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(6),
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
                )
        );

        registerPlaced(context, BLUEBONNET_DENSE,
                configured.getOrThrow(EConfiguredFeatures.BLUEBONNET_DENSE_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        // Amethyst Spires
        registerPlaced(context, AMETHYST_NODE,
                configured.getOrThrow(EConfiguredFeatures.AMETHYST_NODE_KEY),
                List.of(
                        CountPlacement.of(24),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                )
        );

        // Sulfur Spikes
        registerPlaced(context, SULFUR_SPIKE,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                        BiomeFilter.biome()
                )
        );

        registerPlaced(context, SULFUR_SPIKE_CLUSTER,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_SPIKE_CLUSTER_KEY),
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        BiomeFilter.biome()
                )
        );

        registerPlaced(context,
                SULFUR_POOL,
                configured.getOrThrow(EConfiguredFeatures.SULFUR_POOL_KEY),
                List.of(
                    CountPlacement.of(256),
                    InSquarePlacement.spread(),
                    PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                    BlockPredicateFilter.forPredicate(BlockPredicate.solid()),
                    EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.ONLY_IN_AIR_PREDICATE, 32),
                    RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                    BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(EBlocks.SULFUR)),
                    BiomeFilter.biome()
                )
        );



        registerPlaced(context, SILVER_ORE,
                configured.getOrThrow(EConfiguredFeatures.SILVER_ORE_KEY),
                List.of(
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(12)
                        ),
                        BiomeFilter.biome()
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
