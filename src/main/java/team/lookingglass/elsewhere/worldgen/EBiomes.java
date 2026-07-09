package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.EEntities;

public class EBiomes {

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(OUTBACK, createOutback(context));
        context.register(TUNDRA, createTundra(context));
        context.register(DAPPLED_FOREST, createDappledForest(context));

        context.register(WARM_RIVER, createWarmRiver(context));
        context.register(LUKEWARM_RIVER, createLukewarmRiver(context));
        context.register(COLD_RIVER, createColdRiver(context));

        context.register(CRYSTAL_CAVERNS, createCrystalCaverns(context));
        context.register(SULFUR_CAVES, createSulfurCaves(context));
        context.register(ARID_CAVES, createAridCaves(context));
        context.register(FRIGID_CAVES, createFrigidCaves(context));
    }

    public static final ResourceKey<Biome> OUTBACK = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "outback"));
    public static final ResourceKey<Biome> TUNDRA = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tundra"));
    public static final ResourceKey<Biome> DAPPLED_FOREST = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "dappled_forest"));

    public static final ResourceKey<Biome> WARM_RIVER = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "warm_river"));
    public static final ResourceKey<Biome> LUKEWARM_RIVER = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "lukewarm_river"));
    public static final ResourceKey<Biome> COLD_RIVER = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cold_river"));

    public static final ResourceKey<Biome> CRYSTAL_CAVERNS = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "crystal_caverns"));
    public static final ResourceKey<Biome> SULFUR_CAVES = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_caves"));
    public static final ResourceKey<Biome> ARID_CAVES = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "arid_caves"));
    public static final ResourceKey<Biome> FRIGID_CAVES = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frigid_caves"));

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
        BiomeDefaultFeatures.addDesertExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createTundra(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 1, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 4, 6));
        spawnBuilder.addSpawn(MobCategory.AMBIENT, 1, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));

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

        spawnBuilder.addSpawn(MobCategory.CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 3));
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

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createDappledForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
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
        BiomeDefaultFeatures.addDefaultSprings(genBuilder);
//        BiomeDefaultFeatures.addBushes(genBuilder);
//        BiomeDefaultFeatures.addFerns(genBuilder);
        BiomeDefaultFeatures.addForestGrass(genBuilder);
        BiomeDefaultFeatures.addLeafLitterPatch(genBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(genBuilder, false);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.6F)
                .downfall(0.6F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .grassColorOverride(0xDF9C27)
                        .foliageColorOverride(0xE68E30)
                        .dryFoliageColorOverride(0x8C3A04)
                        .waterColor(0x375154)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0xE68E30)
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
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041F33)
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
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.5F)
                .downfall(1.2F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45ADF2)
                        .build())
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
        BiomeDefaultFeatures.addDefaultSoftDisks(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.5F)
                .downfall(1.2F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createCrystalCaverns(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
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

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.0F)
                .downfall(2.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x6B38C9)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x140533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createSulfurCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.AMBIENT, 10, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 90, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 85, new MobSpawnSettings.SpawnerData(EntityType.CAVE_SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 75, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));

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

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.8F)
                .downfall(0.4F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x34BF89)
                        .build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x8CB831)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x17543C)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0.1F)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0.6F)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createAridCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));

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
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x45ADF2)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x041633)
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

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3938C9)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }



    // Global features --- Don't use this, this is just for reference... -w-"
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder genBuilder) {
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