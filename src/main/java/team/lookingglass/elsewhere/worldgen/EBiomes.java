package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.EEntityType;

public class EBiomes {

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(OUTBACK, createOutback(context));
        context.register(CRYSTAL_CAVERNS, createCrystalCaverns(context));
        context.register(SULFUR_CAVES, createSulfurCaves(context));
        context.register(ARID_CAVES, createAridCaves(context));
        context.register(FRIGID_CAVES, createFrigidCaves(context));
    }

    public static final ResourceKey<Biome> OUTBACK = ResourceKey.create(
            Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "outback"));

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

        spawnBuilder.addSpawn(MobCategory.CREATURE, 30, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 1, 2));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 16, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 24, new MobSpawnSettings.SpawnerData(EntityType.COW, 2, 3));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 8, new MobSpawnSettings.SpawnerData(EntityType.CAMEL, 1, 2));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 80, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.CAMEL_HUSK, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(genBuilder);
        BiomeDefaultFeatures.addSavannaGrass(genBuilder);
        BiomeDefaultFeatures.addSavannaTrees(genBuilder);
        BiomeDefaultFeatures.addDesertVegetation(genBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);

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

    private static Biome createCrystalCaverns(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.0F)
                .downfall(2.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x43D5EE)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, -16506061)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createSulfurCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 95, new MobSpawnSettings.SpawnerData(EntityType.CAVE_SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 60, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 60, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(1.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x34BF89)
                        .build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, -7555023)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, -14267102)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0.2F)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 0.75F)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createAridCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.PARCHED, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(genBuilder);
        BiomeDefaultFeatures.addDesertVegetation(genBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(genBuilder);
        BiomeDefaultFeatures.addExtraGold(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3F76E4)
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }

    private static Biome createFrigidCaves(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.caveSpawns(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));

        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(genBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3D57D6)
                        .build())
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, -16448205)
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }



    // Global features
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}