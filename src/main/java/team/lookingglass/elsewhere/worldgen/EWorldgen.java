package team.lookingglass.elsewhere.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import team.lookingglass.elsewhere.mixin.world.NoiseGeneratorSettingsAccessor;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.worldgen.noise.ENoise;
import team.lookingglass.elsewhere.worldgen.noise.NoiseCondition3D;

import java.util.List;

public class EWorldgen {

    public static void initialize() {
        // Rocky outcrop biomes
        List<ResourceKey<Biome>> outcropBiomes = List.of(
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW,
                Biomes.SAVANNA, Biomes.WINDSWEPT_SAVANNA,
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.WINDSWEPT_FOREST,
                Biomes.BIRCH_FOREST, Biomes.GROVE, Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA
        );
        List<ResourceKey<Biome>> forestRockBiomes = List.of(
                Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.DARK_FOREST,
                Biomes.BIRCH_FOREST, Biomes.GROVE, Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE,
                Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA
        );
        List<ResourceKey<Biome>> meadowRockBiomes = List.of(
                Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW,
                Biomes.SPARSE_JUNGLE
        );

        // Basic Features
        BiomeModifications.addFeature(
                ctx -> ctx.hasTag(BiomeTags.IS_OVERWORLD) && !ctx.hasTag(BiomeTags.IS_OCEAN),
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.PEBBLE
        );
        BiomeModifications.addFeature(
                ctx -> outcropBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.ROCKY_OUTCROP
        );
        BiomeModifications.addFeature(
                ctx -> forestRockBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.FOREST_ROCK_SPARSE
        );
        BiomeModifications.addFeature(
                ctx -> meadowRockBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.MEADOW_ROCK
        );

        // Hibiscus
        List<ResourceKey<Biome>> hibiscusBiomes = List.of(
                Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE
        );

        BiomeModifications.addFeature(
                ctx -> hibiscusBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.HIBISCUS_JUNGLE
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.SPARSE_JUNGLE,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                EPlacedFeatures.HIBISCUS_SPARSE_JUNGLE
        );

        // Bluebonnets
        List<ResourceKey<Biome>> bluebonnetBiomes = List.of(
                Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_FOREST
        );
        BiomeModifications.addFeature(
                ctx -> bluebonnetBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.BLUEBONNET
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.WINDSWEPT_SAVANNA,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.BLUEBONNET_DENSE
        );

        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DESERT,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_ROCKS
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DESERT,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_DIRT_PATCH
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DESERT,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_SHORT_CACTUS
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DESERT,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_TALL_CACTUS
        );

        List<ResourceKey<Biome>> beaches = List.of(
                Biomes.BEACH, Biomes.SNOWY_BEACH
        );
        BiomeModifications.addFeature(
                ctx -> beaches.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DENSE_DRY_GRASS
        );
        BiomeModifications.addFeature(
                ctx -> beaches.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.BEACHSTONE_ROCKS
        );

        // Calcite Ores
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.BEJEWELED_CALCITE
        );

        // Silver Ores
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.SILVER_ORE
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.SILVER_ORE_SMALL
        );

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.TIN_ORE
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.TIN_ORE_LARGE
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, EPlacedFeatures.TIN_ORE_SMALL
        );


        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.LUKEWARM_OCEAN,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.SEAGRASS_EXTRA
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.LUKEWARM_OCEAN,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.SEAGRASS_MID_EXTRA
        );

        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DEEP_LUKEWARM_OCEAN,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.SEAGRASS_EXTRA
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DEEP_LUKEWARM_OCEAN,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.SEAGRASS_MID_EXTRA
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.DEEP_LUKEWARM_OCEAN,
                GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.KELP_CLUSTER
        );





        DynamicRegistrySetupCallback.EVENT.register(registryView -> {
            registryView.registerEntryAdded(Registries.NOISE_SETTINGS, (rawId, id, object) -> {

                if (!id.equals(Identifier.withDefaultNamespace("overworld"))) return;

                SurfaceRules.RuleSource stoneCliffsRule = SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.steep(),
                                SurfaceRules.state(Blocks.STONE.defaultBlockState())
                        )
                );
                SurfaceRules.RuleSource sandstoneCliffsRule = SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.steep(),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
                                )
                        )
                );
                SurfaceRules.RuleSource sandstoneRedCliffsRule = SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.steep(),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                            SurfaceRules.state(Blocks.RED_SAND.defaultBlockState())),
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState()))
                                )
                        )
                );
                SurfaceRules.RuleSource sandstonePinkCliffsRule = SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.steep(),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.state(EBlocks.PINK_SAND.defaultBlockState())),
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(EBlocks.PINK_SANDSTONE.defaultBlockState()))
                                )
                        )
                );


                SurfaceRules.RuleSource biomeCliffRules = SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(
                                        Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.SNOWY_PLAINS,
                                        Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.DARK_FOREST, Biomes.CHERRY_GROVE,
                                        Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.GROVE,
                                        Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA,
                                        EBiomes.DAPPLED_FOREST,
                                        Biomes.SWAMP, Biomes.MANGROVE_SWAMP,
                                        Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE,
                                        Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_SAVANNA,
                                        Biomes.STONY_SHORE, Biomes.BEACH, Biomes.SNOWY_BEACH,
                                        Biomes.ICE_SPIKES
                                ),
                                stoneCliffsRule
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(
                                        Biomes.DESERT
                                ),
                                sandstoneCliffsRule
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(
                                        EBiomes.OUTBACK
                                ),
                                sandstoneRedCliffsRule
                        )
                );

                SurfaceRules.RuleSource shaleRule = SurfaceRules.ifTrue(
                        SurfaceRules.not(
                                SurfaceRules.verticalGradient("elsewhere:shale_bottom",
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(0))
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.verticalGradient("elsewhere:shale_top",
                                        VerticalAnchor.absolute(32),
                                        VerticalAnchor.absolute(40)),
                                SurfaceRules.state(EBlocks.SHALE.defaultBlockState())
                        )
                );

                SurfaceRules.RuleSource deepslateRule = SurfaceRules.ifTrue(
                        SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(5), 0),
                        SurfaceRules.ifTrue(
                                SurfaceRules.verticalGradient("elsewhere:deepslate",
                                        VerticalAnchor.absolute(0),
                                        VerticalAnchor.absolute(8)),
                                SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                        )
                );

                SurfaceRules.RuleSource overworldChanges = prelimAndWaterCheck(SurfaceRules.sequence(
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(Biomes.DESERT),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.2),
                                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.2),
                                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState())))
                                )),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -1.0, 0.0),
                                                        SurfaceRules.state(EBlocks.ARID_GRASS_BLOCK.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -1.0, 0.0),
                                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState())))
                                )),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(Biomes.OLD_GROWTH_BIRCH_FOREST),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(Blocks.PODZOL.defaultBlockState())))
                                )),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState())))
                                )),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(Biomes.SPARSE_JUNGLE),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.5, 1.0),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.5, 1.0),
                                                        SurfaceRules.state(EBlocks.LATERITE.defaultBlockState())))
                                ))
                        ));

                SurfaceRules.RuleSource outbackRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.OUTBACK),
                        prelimAndWaterCheck(
                                SurfaceRules.sequence(
                                        // On Floor
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.state(EBlocks.ARID_GRASS_BLOCK.defaultBlockState())),

                                        // Under Floor
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(Blocks.RED_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState())),

                                        // Deep Under Floor
                                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.GRANITE.defaultBlockState()))
                                )));

                SurfaceRules.RuleSource shrublandRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.SHRUBLAND),
                        prelimAndWaterCheck(
                                SurfaceRules.sequence(
                                        // On Floor
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(EBlocks.ARID_GRASS_BLOCK.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(EBlocks.ARID_GRASS_BLOCK.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState())),

                                        // Under Floor
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.3),
                                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.3, 1.0),
                                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.DIRT.defaultBlockState())),

                                        // Deep Under Floor
                                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.STONE.defaultBlockState()))
                                )));

                SurfaceRules.RuleSource lushDesertRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.LUSH_DESERT),
                        prelimAndWaterCheck(
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -0.5, 0.0), sandstonePinkCliffsRule),
                                        sandstoneCliffsRule,
                                        // On Floor
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -0.5, 0.0),
                                                        SurfaceRules.state(EBlocks.PINK_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -0.5, 0.0),
                                                        SurfaceRules.state(EBlocks.PINK_SAND.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.SAND.defaultBlockState())),

                                        // Under Floor
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -0.5, 0.0),
                                                        SurfaceRules.state(EBlocks.PINK_SANDSTONE.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
                                )));

                SurfaceRules.RuleSource tundraRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.TUNDRA),
                        prelimAndWaterCheck(
                                SurfaceRules.sequence(
                                        stoneCliffsRule,
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.2, 1.0),
                                                        SurfaceRules.state(EBlocks.RED_GRASS_BLOCK.defaultBlockState()))),
                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.2),
                                                        SurfaceRules.state(EBlocks.RED_GRASS_BLOCK.defaultBlockState())))
                                )));

                SurfaceRules.RuleSource tidepoolRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.TIDEPOOLS),
                        SurfaceRules.sequence(
                                sandstoneCliffsRule,
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.35),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -0.05, 0.05),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.35, 1.0),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),

                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -1.0, -0.35),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, -0.05, 0.05),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.35, 1.0),
                                                SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),

                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
                        ));

                SurfaceRules.RuleSource coldBeachRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.COLD_BEACH),
                        SurfaceRules.sequence(
                                stoneCliffsRule,
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.GRAVEL.defaultBlockState())),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.GRAVEL.defaultBlockState()))
                        ));

                SurfaceRules.RuleSource frozenBeachRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.FROZEN_BEACH),
                        SurfaceRules.sequence(
                                stoneCliffsRule,
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState()))
                        ));

                SurfaceRules.RuleSource riverRules = SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.WARM_RIVER),
                                        SurfaceRules.sequence(prelimAndWaterCheck(SurfaceRules.sequence(stoneCliffsRule,
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.RED_SAND.defaultBlockState()))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState()))))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.LUKEWARM_RIVER),
                                        SurfaceRules.sequence(prelimAndWaterCheck(SurfaceRules.sequence(stoneCliffsRule,
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState())),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.DIRT.defaultBlockState())))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.RIVER),
                                        SurfaceRules.sequence(prelimAndWaterCheck(SurfaceRules.sequence(stoneCliffsRule,
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.DIRT.defaultBlockState()))))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.COLD_RIVER),
                                        SurfaceRules.sequence(prelimAndWaterCheck(SurfaceRules.sequence(
                                                stoneCliffsRule,
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.GRAVEL.defaultBlockState())),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.STONE.defaultBlockState())))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.GRAVEL.defaultBlockState()))))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_RIVER),
                                        SurfaceRules.sequence(prelimAndWaterCheck(SurfaceRules.sequence(stoneCliffsRule,
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.GRAVEL.defaultBlockState())),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.STONE.defaultBlockState())))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                                SurfaceRules.state(Blocks.MUD.defaultBlockState()))),
                                                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.waterBlockCheck(0, 0)),
                                                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                                SurfaceRules.state(Blocks.STONE.defaultBlockState())))))
                        );

                SurfaceRules.RuleSource crystalCavernRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.CRYSTAL_CAVERNS),
                        SurfaceRules.sequence(
                                // Sodalite Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.25, -0.2),
                                        SurfaceRules.state(EBlocks.SODALITE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0, 0.05),
                                        SurfaceRules.state(EBlocks.SODALITE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.25, 0.3),
                                        SurfaceRules.state(EBlocks.SODALITE.defaultBlockState())),

                                // Basalt & Calcite Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.2, -0.1),
                                        SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.1, 0.2),
                                        SurfaceRules.state(Blocks.CALCITE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2, 0.4),
                                        SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4),
                                        SurfaceRules.state(Blocks.CALCITE.defaultBlockState())),

                                // Surface Stone
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState())))
                        ));

                SurfaceRules.RuleSource sulfurCaveRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.SULFUR_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.1F),
                                        SurfaceRules.state(EBlocks.CINNABAR.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0F, 0.325F),
                                        SurfaceRules.state(EBlocks.SULFUR.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.325F, 0.4F),
                                        SurfaceRules.state(EBlocks.ORPIMENT.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4F),
                                        SurfaceRules.state(EBlocks.CINNABAR.defaultBlockState())),

                                // Surface Stone
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState())))
                        ));

                SurfaceRules.RuleSource aridCaveRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.ARID_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.1F),
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0F, 0.2F),
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2F, 0.5F),
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.5F),
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),

                                // Surface Stone
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState())))
                        ));

                SurfaceRules.RuleSource frigidCaveRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.FRIGID_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.2F),
                                        SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.1F, 0.2F),
                                        SurfaceRules.state(Blocks.BLUE_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2F, 0.4F),
                                        SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4F, 0.65F),
                                        SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState())),

                                // Surface Stone
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.STONE.defaultBlockState())))
                        ));

                SurfaceRules.RuleSource volcanicDepthsRules = SurfaceRules.ifTrue(SurfaceRules.isBiome(EBiomes.VOLCANIC_DEPTHS),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.5F, -0.2F),
                                        SurfaceRules.state(Blocks.BLACKSTONE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0F, 0.2F),
                                        SurfaceRules.state(Blocks.TUFF.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.3F),
                                        SurfaceRules.state(Blocks.BLACKSTONE.defaultBlockState()))
                        ));

                SurfaceRules.RuleSource oceanRules = SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.LUKEWARM_OCEAN), SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.PATCH, -0.5F, 0.2F),
                                        SurfaceRules.state(EBlocks.SEAGRASS_SAND.defaultBlockState()))),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),

                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState()))
                                ))
                );

                ((NoiseGeneratorSettingsAccessor)(Object) object).setSurfaceRule(
                        SurfaceRules.sequence(biomeCliffRules, overworldChanges,
                                riverRules, oceanRules,
                                outbackRules, lushDesertRules, tundraRules,
                                tidepoolRules,
                                coldBeachRules, frozenBeachRules,
                                crystalCavernRules, sulfurCaveRules,
                                aridCaveRules, frigidCaveRules,
                                volcanicDepthsRules,
                                deepslateRule, shaleRule, object.surfaceRule()
                        ));
            });
        });

    }

    private static SurfaceRules.RuleSource prelimAndWaterCheck(SurfaceRules.RuleSource inner) {
        return SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), inner));
    }
}