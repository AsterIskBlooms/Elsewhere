package team.lookingglass.elsewhere.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import team.lookingglass.elsewhere.datagen.BlockTagProvider;
import team.lookingglass.elsewhere.mixin.NoiseGeneratorSettingsAccessor;
import team.lookingglass.elsewhere.mixin.OreConfigurationAccessor;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EWorldgen {

    public static void initialize() {
        // Rocky outcrop biomes
        List<ResourceKey<Biome>> outcropBiomes = List.of(
                Biomes.PLAINS,
                Biomes.MEADOW,
                Biomes.FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST
        );

        BiomeModifications.addFeature(
                ctx -> outcropBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.RAW_GENERATION,
                EPlacedFeatures.ROCKY_OUTCROP
        );

        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.OUTBACK,
                GenerationStep.Decoration.LOCAL_MODIFICATIONS,
                EPlacedFeatures.OUTBACK_GRASS_PATCH
        );

        // Bluebonnet biomes
        List<ResourceKey<Biome>> bluebonnetBiomes = List.of(
                Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_HILLS,
                Biomes.WINDSWEPT_GRAVELLY_HILLS,
                Biomes.WINDSWEPT_FOREST
        );

        BiomeModifications.addFeature(
                ctx -> bluebonnetBiomes.contains(ctx.getBiomeKey()),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                EPlacedFeatures.BLUEBONNET
        );

        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == Biomes.WINDSWEPT_SAVANNA,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                EPlacedFeatures.BLUEBONNET_DENSE
        );

        // Amethyst Spires
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.CRYSTAL_CAVERNS,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.AMETHYST_NODE
        );

        // Frigid Caves
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.FRIGID_CAVES,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.ICICLE
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.FRIGID_CAVES,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.ICICLE_CLUSTER
        );

        // Sulfur Caves
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.SULFUR_CAVES,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.SULFUR_SPIKE
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.SULFUR_CAVES,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.SULFUR_SPIKE_CLUSTER
        );
        BiomeModifications.addFeature(
                ctx -> ctx.getBiomeKey() == EBiomes.SULFUR_CAVES,
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                EPlacedFeatures.SULFUR_POOL
        );

        // Silver Ores
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                EPlacedFeatures.SILVER_ORE
        );





        DynamicRegistrySetupCallback.EVENT.register(registryView -> {
            registryView.registerEntryAdded(Registries.NOISE_SETTINGS, (rawId, id, object) -> {

                if (!id.equals(Identifier.withDefaultNamespace("overworld"))) return;

                // Shale fades in between 32 and 24, fades out between -8 and -16
                SurfaceRules.RuleSource shaleRule = SurfaceRules.ifTrue(
                        SurfaceRules.not(
                                SurfaceRules.verticalGradient("elsewhere:shale_bottom",
                                        VerticalAnchor.absolute(-32),
                                        VerticalAnchor.absolute(-24))
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.verticalGradient("elsewhere:shale_top",
                                        VerticalAnchor.absolute(16),
                                        VerticalAnchor.absolute(24)),
                                SurfaceRules.state(EBlocks.SHALE.defaultBlockState())
                        )
                );

                // make sure bedrock generates you fat fuck
                SurfaceRules.RuleSource bedrockFloorCheck = SurfaceRules.ifTrue(
                        SurfaceRules.not(
                                SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(0), 0)
                        ),
                        SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
                );

                // Deepslate fades in between -8 and -16
                SurfaceRules.RuleSource deepslateRule = SurfaceRules.ifTrue(
                        SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(5), 0),
                        SurfaceRules.ifTrue(
                                SurfaceRules.verticalGradient("minecraft:deepslate",
                                        VerticalAnchor.absolute(-32),
                                        VerticalAnchor.absolute(-24)),
                                SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                        )
                );

                SurfaceRules.RuleSource outbackRules = SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EBiomes.OUTBACK),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.ON_FLOOR,
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition(Noises.BADLANDS_SURFACE, -1.0, 0.0),
                                                SurfaceRules.state(Blocks.RED_SAND.defaultBlockState())
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(EBlocks.ARID_DIRT.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.yBlockCheck(VerticalAnchor.absolute(20), 0),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.UNDER_FLOOR,
                                                SurfaceRules.state(Blocks.RED_SANDSTONE.defaultBlockState())
                                        )
                                )
                        )
                );

                SurfaceRules.RuleSource crystalCavernRules = SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EBiomes.CRYSTAL_CAVERNS),
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
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0, 0.2),
                                        SurfaceRules.state(Blocks.CALCITE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2, 0.4),
                                        SurfaceRules.state(Blocks.SMOOTH_BASALT.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4),
                                        SurfaceRules.state(Blocks.CALCITE.defaultBlockState()))
                        )
                );

                SurfaceRules.RuleSource sulfurCaveRules = SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EBiomes.SULFUR_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.1F),
                                        SurfaceRules.state(EBlocks.CINNABAR.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0F, 0.325F),
                                        SurfaceRules.state(EBlocks.SULFUR.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.325F, 0.4F),
                                        SurfaceRules.state(EBlocks.ORPIMENT.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4F),
                                        SurfaceRules.state(EBlocks.CINNABAR.defaultBlockState()))
                        )
                );

                SurfaceRules.RuleSource aridCaveRules = SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EBiomes.ARID_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.1F),
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.0F, 0.2F),
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2F, 0.5F),
                                        SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.5F),
                                        SurfaceRules.state(Blocks.SAND.defaultBlockState()))
                        )
                );

                SurfaceRules.RuleSource frigidCaveRules = SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EBiomes.FRIGID_CAVES),
                        SurfaceRules.sequence(
                                // Cave Bands
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, -0.4F, -0.2F),
                                        SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.1F, 0.2F),
                                        SurfaceRules.state(Blocks.BLUE_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.2F, 0.4F),
                                        SurfaceRules.state(Blocks.PACKED_ICE.defaultBlockState())),
                                SurfaceRules.ifTrue(NoiseCondition3D.of(ENoise.CAVE_GRADIENT_3D, 0.4F, 0.65F),
                                        SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))
                        )
                );

                ((NoiseGeneratorSettingsAccessor)(Object) object).setSurfaceRule(
                        SurfaceRules.sequence(outbackRules, crystalCavernRules, sulfurCaveRules, aridCaveRules, frigidCaveRules,
                                bedrockFloorCheck, deepslateRule, shaleRule, object.surfaceRule())
                );
            });

            registryView.registerEntryAdded(Registries.CONFIGURED_FEATURE, (_, _, object) -> {
                if (!(object.feature() == Feature.ORE)) return;
                if (!(object.config() instanceof OreConfiguration config)) return;

                List<OreConfiguration.TargetBlockState> targets = new ArrayList<>(config.targetStates);

                // Identify blocks
                Optional<Block> matchedBlock = targets.stream()
                        .map(t -> t.state.getBlock())
                        .filter(b -> b == Blocks.IRON_ORE || b == Blocks.GOLD_ORE
                                || b == Blocks.DIAMOND_ORE || b == Blocks.LAPIS_ORE
                                || b == Blocks.COPPER_ORE || b == Blocks.COAL_ORE
                                || b == Blocks.EMERALD_ORE || b == Blocks.REDSTONE_ORE)
                        .findFirst();

                if (matchedBlock.isEmpty()) return;
                Block vanillaOre = matchedBlock.get();

                BlockState shaleState = null;
                BlockState cinnabarState = null;

                if (vanillaOre == Blocks.IRON_ORE) {
                    shaleState = EBlocks.SHALE_IRON_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_IRON_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.GOLD_ORE) {
                    shaleState = EBlocks.SHALE_GOLD_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_GOLD_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.DIAMOND_ORE) {
                    shaleState = EBlocks.SHALE_DIAMOND_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_DIAMOND_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.LAPIS_ORE) {
                    shaleState = EBlocks.SHALE_LAPIS_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_LAPIS_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.COPPER_ORE) {
                    shaleState = EBlocks.SHALE_COPPER_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_COPPER_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.COAL_ORE) {
                    shaleState = EBlocks.SHALE_COAL_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_COAL_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.EMERALD_ORE) {
                    shaleState = EBlocks.SHALE_EMERALD_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_EMERALD_ORE.defaultBlockState();
                } else if (vanillaOre == Blocks.REDSTONE_ORE) {
                    shaleState = EBlocks.SHALE_REDSTONE_ORE.defaultBlockState();
                    cinnabarState = EBlocks.CINNABAR_REDSTONE_ORE.defaultBlockState();
                }

                // Add ore targets
                if (shaleState != null) {
                    targets.add(OreConfiguration.target(
                            new TagMatchTest(BlockTagProvider.SHALE_ORE_REPLACEABLES),
                            shaleState
                    ));
                }
                if (cinnabarState != null) {
                    targets.addFirst(OreConfiguration.target(
                            new TagMatchTest(BlockTagProvider.CINNABAR_ORE_REPLACEABLES),
                            cinnabarState
                    ));
                }

                ((OreConfigurationAccessor)(Object) config).setTargetStates(List.copyOf(targets));
            });
        });
    }
}