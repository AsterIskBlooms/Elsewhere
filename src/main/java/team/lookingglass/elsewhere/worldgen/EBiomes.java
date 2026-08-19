package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.EEntities;

public interface  EBiomes {

    static void bootstrap(BootstrapContext<Biome> context) {
        context.register(OUTBACK, createOutback(context));
        context.register(LUSH_DESERT, createLushDesert(context));
        context.register(TUNDRA, createTundra(context));
        context.register(DAPPLED_FOREST, createDappledForest(context));
        context.register(SHRUBLAND, createShrubland(context));
        context.register(STEPPE, createSteppe(context));
        context.register(CEDAR_FOREST, createCedarForest(context));
        context.register(GLASS_DESERT, createGlassDesert(context));


        context.register(TIDEPOOLS, createTidepools(context));
        context.register(COLD_BEACH, createColdBeach(context));
        context.register(FROZEN_BEACH, createFrozenBeach(context));

        context.register(WARM_RIVER, createWarmRiver(context));
        context.register(LUKEWARM_RIVER, createLukewarmRiver(context));
        context.register(COLD_RIVER, createColdRiver(context));

        context.register(CAVES, createDefaultCaves(context));

        context.register(CRYSTAL_CAVERNS, createCrystalCaverns(context));
        context.register(SULFUR_CAVES, createSulfurCaves(context));
        context.register(ARID_CAVES, createAridCaves(context));
        context.register(FRIGID_CAVES, createFrigidCaves(context));
        context.register(VOLCANIC_DEPTHS, createVolcanicDepths(context));
        context.register(PALE_GROTTO, createPaleGrotto(context));


        // Veilroot Biomes
        context.register(ROTTEN_GROVE, rottenGrove(context));
        context.register(SWEEPING_SANDS, sweepingSands(context));
        context.register(FROSTED_CRAG, frostedCrag(context));
        context.register(FROSTED_JUNGLE, frostedJungle(context));
        context.register(BROUSH_FOREST, broushForest(context));
        context.register(VEILED_FOREST, veiledForest(context));
        context.register(BROOD_CANYON, broodCanyon(context));
    }

    ResourceKey<Biome> OUTBACK = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "outback"));
    ResourceKey<Biome> LUSH_DESERT = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "lush_desert"));
    ResourceKey<Biome> TUNDRA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tundra"));
    ResourceKey<Biome> DAPPLED_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "dappled_forest"));
    ResourceKey<Biome> SHRUBLAND = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "shrubland"));
    ResourceKey<Biome> STEPPE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "steppe"));
    ResourceKey<Biome> CEDAR_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar_forest"));
    ResourceKey<Biome> GLASS_DESERT = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "glass_desert"));

    ResourceKey<Biome> TIDEPOOLS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tidepools"));
    ResourceKey<Biome> COLD_BEACH = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cold_beach"));
    ResourceKey<Biome> FROZEN_BEACH = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frozen_beach"));

    ResourceKey<Biome> WARM_RIVER = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "warm_river"));
    ResourceKey<Biome> LUKEWARM_RIVER = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "lukewarm_river"));
    ResourceKey<Biome> COLD_RIVER = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cold_river"));

    ResourceKey<Biome> CAVES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "caves"));
    ResourceKey<Biome> CRYSTAL_CAVERNS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "crystal_caverns"));
    ResourceKey<Biome> SULFUR_CAVES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_caves"));
    ResourceKey<Biome> ARID_CAVES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "arid_caves"));
    ResourceKey<Biome> FRIGID_CAVES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frigid_caves"));
    ResourceKey<Biome> VOLCANIC_DEPTHS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "volcanic_depths"));
    ResourceKey<Biome> PALE_GROTTO = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "pale_grotto"));



    ResourceKey<Biome> ROTTEN_GROVE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "rotten_grove"));
    ResourceKey<Biome> SWEEPING_SANDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sweeping_sands"));
    ResourceKey<Biome> FROSTED_CRAG = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frosted_crag"));
    ResourceKey<Biome> FROSTED_JUNGLE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frosted_jungle"));
    ResourceKey<Biome> BROUSH_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "broush_forest"));
    ResourceKey<Biome> VEILED_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veiled_forest"));
    ResourceKey<Biome> BROOD_CANYON = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "brood_canyon"));


    private static Biome createOutback(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
        BiomeDefaultFeatures.addSavannaGrass(genBuilder);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(genBuilder);
        BiomeDefaultFeatures.addDesertVegetation(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.OUTBACK_ROCKS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.OUTBACK_ACACIA);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_SHORT_CACTUS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .grassColorOverride(0xD6A44D)
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DESERT))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createLushDesert(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_BUSH);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_BADLANDS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DRY_GRASS_BADLANDS);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DRY_GRASS_DESERT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        BiomeDefaultFeatures.addDesertExtraDecoration(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.LUSH_DESERT_ROCKS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.LUSH_SHORT_CACTUS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.LUSH_TALL_CACTUS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.AZALEA_SHRUB);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.LUSH_DIRT_PATCH);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DENSE_DRY_GRASS);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.4F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DESERT))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createGlassDesert(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(3.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x666951)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DESERT))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x2D3012)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createTundra(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 80, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_HORSE, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        spawnBuilder.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 1, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 2));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addFrozenSprings(genBuilder);
        BiomeDefaultFeatures.addWaterTrees(genBuilder);
        BiomeDefaultFeatures.addNearWaterVegetation(genBuilder);
        BiomeDefaultFeatures.addRareBerryBushes(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.TUNDRA_GREEN_VEGETATION_PATCH);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.TUNDRA_RED_VEGETATION_PATCH);
        genBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.FOREST_ROCK_SPARSE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.1F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createDappledForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 3));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addBirchForestFlowers(genBuilder);
        BiomeDefaultFeatures.addForestGrass(genBuilder);
        BiomeDefaultFeatures.addLeafLitterPatch(genBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(genBuilder, true);

        genBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.FOREST_ROCK_SPARSE);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DAPPLED_FOREST_TREES);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.RUSTY_MOSS_PATCH);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.6F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .grassColorOverride(0xE0A928)
                        .foliageColorOverride(0xE6C949)
                        .dryFoliageColorOverride(0xD9800D)
                        .waterColor(0x375154)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0xCCD8E2)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createShrubland(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 3, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 2, 6));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 2, 4));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DESERT_SHORT_CACTUS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.OAK_SHRUBS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.CEDAR_TREES_SPARSE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(1.8F)
                .downfall(0.15F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45ADF2)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041633)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createSteppe(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 3, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 2, 6));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 2, 4));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
        BiomeDefaultFeatures.addSavannaGrass(genBuilder);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.STEPPE_GRASS);
        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.STEPPE_PILLARS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(2.0F)
                .downfall(0.05F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .grassColorOverride(0xD6A44D)
                        .waterColor(0x45ADF2)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_BADLANDS))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041633)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createCedarForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 6, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 1, 2));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);
        BiomeDefaultFeatures.addForestGrass(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_PUMPKIN);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.CEDAR_FOREST_TREES);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(1.8F)
                .downfall(0.25F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45ADF2)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FOREST))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041633)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createTidepools(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 2, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.FROG, 2, 3));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.BEACHSTONE_ROCKS);
        genBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.EXTRA_BEACHSTONE_ROCKS);
        genBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, EPlacedFeatures.ROCKWEED_BASALT_PATCH);

        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.DENSE_DRY_GRASS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.TIDEPOOL);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(1.0F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x537C94)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createColdBeach(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 2, 5));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.6F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createFrozenBeach(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 80, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 2, 5));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.1F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3938C9)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createWarmRiver(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 4));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 1, new MobSpawnSettings.SpawnerData(EEntities.PERCH, 3, 5));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_SAND);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DESERT))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createLukewarmRiver(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 4));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 1, new MobSpawnSettings.SpawnerData(EEntities.PERCH, 3, 5));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_SAND);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(1.5F)
                .downfall(0.7F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45ADF2)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041633)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createColdRiver(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 4));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 1, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 1, 5));


        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FOREST))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createDefaultCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);
        BiomeDefaultFeatures.addInfestedStone(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.CAVE_WEEDS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.CAVE_ROOTS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.8F)
                .downfall(0.4F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createCrystalCaverns(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.AMETHYST_NODE);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPlacedFeatures.CAVE_WEEDS);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.0F)
                .downfall(1.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x6B38C9)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x140533)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createSulfurCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.AMBIENT, 10, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EEntities.SULFUR_CUBE, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 90, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 85, new MobSpawnSettings.SpawnerData(EntityType.CAVE_SPIDER, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EntityType.BOGGED, 4, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addFossilDecoration(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.SULFUR_POOL);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.SULFUR_SPIKE);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.SULFUR_SPIKE_CLUSTER);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.4F)
                .downfall(0.4F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x34BF89)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x8CB831)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x17543C)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, -20F)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createAridCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.monsters(spawnBuilder, 19, 1, 0, 50, false);
        spawnBuilder.addSpawn(MobCategory.MONSTER, 80, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_DESERT))
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xFFE991)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, -20F)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createFrigidCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addFossilDecoration(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.ICICLE);
        genBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, EPlacedFeatures.ICICLE_CLUSTER);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.0F)
                .downfall(0.3F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3938C9)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createVolcanicDepths(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.monsters(spawnBuilder, 19, 1, 0, 50, false);
        spawnBuilder.addSpawn(MobCategory.MONSTER, 80, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(3.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_BADLANDS))
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xFF7300)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, -20F)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createPaleGrotto(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 1, 4));
        spawnBuilder.addSpawn(MobCategory.AMBIENT, 1, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(3.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_BIOME_STONY_PEAKS))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0xB9B9B9)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x817770)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, -20F)
                .setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }




    private static Biome rottenGrove(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 1, 3));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.ICE_PATCH);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.7F).downfall(0.75F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x1fcc8a)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x5a8241)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x5a8241)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x074a29)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome sweepingSands(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 1, 3));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.DISK_SAND);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F).downfall(0.15F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x596343)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x989e5d)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x989e5d)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x35401d)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome frostedCrag(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 35, new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 2, 4));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.DISK_SAND);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.1F).downfall(0.1F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x53c2a8)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x8ed6e6)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x8ed6e6)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x1b5447)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome frostedJungle(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 35, new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 2, 4));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.DISK_SAND);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.1F).downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x53c2a8)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x8ee6cc)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x8ee6cc)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x1b5447)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome broushForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.FROG, 2, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.BOGGED, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.SKELETON_HORSE, 1, 1));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EPlacedFeatures.BROUSH_TREES);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.4F).downfall(0.9F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x66d998)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x487d27)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x487d27)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x2c704a)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome veiledForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.FROG, 2, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.SPRING_WATER);
        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, VegetationPlacements.DARK_FOREST_VEGETATION);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.2F).downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x604987)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x5e405a)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x5e405a)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x1e1233)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }

    private static Biome broodCanyon(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        spawnBuilder.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityType.FROG, 2, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1));

        genBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.2F).downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x828749)
                        .build())
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(SoundEvents.MUSIC_END))
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x52323c)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x52323c)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x402b12)
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(genBuilder.build()).build();
    }




    // Global features --- Don't use this, this is just for reference... -w-"
     static void globalOverworldGeneration(BiomeGenerationSettings.Builder genBuilder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(genBuilder);

        BiomeDefaultFeatures.addDefaultCrystalFormations(genBuilder);
        BiomeDefaultFeatures.addDripstone(genBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(genBuilder);
        BiomeDefaultFeatures.addIcebergs(genBuilder);

        BiomeDefaultFeatures.addFossilDecoration(genBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(genBuilder);

        BiomeDefaultFeatures.addDesertExtraDecoration(genBuilder);
        BiomeDefaultFeatures.addBlueIce(genBuilder);

        BiomeDefaultFeatures.addDefaultUndergroundVariety(genBuilder);
        BiomeDefaultFeatures.addDefaultOres(genBuilder);
        BiomeDefaultFeatures.addLushCavesSpecialOres(genBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(genBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(genBuilder);
        BiomeDefaultFeatures.addMangroveSwampDisks(genBuilder);

        BiomeDefaultFeatures.addDripstone(genBuilder);
        BiomeDefaultFeatures.addSculk(genBuilder);
        BiomeDefaultFeatures.addInfestedStone(genBuilder);
        BiomeDefaultFeatures.addNetherDefaultOres(genBuilder);
        BiomeDefaultFeatures.addAncientDebris(genBuilder);

        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
        BiomeDefaultFeatures.addFrozenSprings(genBuilder);

        BiomeDefaultFeatures.addTaigaTrees(genBuilder);
        BiomeDefaultFeatures.addGroveTrees(genBuilder);
        BiomeDefaultFeatures.addWaterTrees(genBuilder);
        BiomeDefaultFeatures.addBirchTrees(genBuilder);
        BiomeDefaultFeatures.addOtherBirchTrees(genBuilder);
        BiomeDefaultFeatures.addTallBirchTrees(genBuilder);
        BiomeDefaultFeatures.addSavannaTrees(genBuilder);
        BiomeDefaultFeatures.addShatteredSavannaTrees(genBuilder);
        BiomeDefaultFeatures.addMountainTrees(genBuilder);
        BiomeDefaultFeatures.addMountainForestTrees(genBuilder);
        BiomeDefaultFeatures.addJungleTrees(genBuilder);
        BiomeDefaultFeatures.addSparseJungleTrees(genBuilder);
        BiomeDefaultFeatures.addBadlandsTrees(genBuilder);
        BiomeDefaultFeatures.addSnowyTrees(genBuilder);
        BiomeDefaultFeatures.addPlainVegetation(genBuilder);
        BiomeDefaultFeatures.addSwampVegetation(genBuilder);
        BiomeDefaultFeatures.addMangroveSwampVegetation(genBuilder);
        BiomeDefaultFeatures.addCherryGroveVegetation(genBuilder);
        BiomeDefaultFeatures.addMeadowVegetation(genBuilder);

        BiomeDefaultFeatures.addBushes(genBuilder);
        BiomeDefaultFeatures.addFerns(genBuilder);
        BiomeDefaultFeatures.addLightBambooVegetation(genBuilder);
        BiomeDefaultFeatures.addBambooVegetation(genBuilder);
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(genBuilder);
        BiomeDefaultFeatures.addLeafLitterPatch(genBuilder);
        BiomeDefaultFeatures.addJungleVines(genBuilder);
        BiomeDefaultFeatures.addRareBerryBushes(genBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(genBuilder);

        BiomeDefaultFeatures.addJungleGrass(genBuilder);
        BiomeDefaultFeatures.addSavannaGrass(genBuilder);
        BiomeDefaultFeatures.addShatteredSavannaGrass(genBuilder);
        BiomeDefaultFeatures.addBadlandGrass(genBuilder);
        BiomeDefaultFeatures.addForestGrass(genBuilder);
        BiomeDefaultFeatures.addDesertVegetation(genBuilder);
        BiomeDefaultFeatures.addGiantTaigaVegetation(genBuilder);
        BiomeDefaultFeatures.addDefaultGrass(genBuilder);
        BiomeDefaultFeatures.addTaigaGrass(genBuilder);
        BiomeDefaultFeatures.addPlainGrass(genBuilder);

        BiomeDefaultFeatures.addForestFlowers(genBuilder);
        BiomeDefaultFeatures.addBirchForestFlowers(genBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(genBuilder);
        BiomeDefaultFeatures.addWarmFlowers(genBuilder);

        BiomeDefaultFeatures.addSavannaExtraGrass(genBuilder);

        BiomeDefaultFeatures.addMushroomFieldVegetation(genBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(genBuilder);

        BiomeDefaultFeatures.addColdOceanExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addLukeWarmKelp(genBuilder);
        BiomeDefaultFeatures.addJungleMelons(genBuilder);
        BiomeDefaultFeatures.addSparseJungleMelons(genBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(genBuilder, true);
        BiomeDefaultFeatures.addNearWaterVegetation(genBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addMangroveSwampExtraVegetation(genBuilder);

        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);
    }
}