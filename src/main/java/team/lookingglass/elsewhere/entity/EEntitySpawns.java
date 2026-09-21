package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.tags.EBiomeTags;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.List;

public class EEntitySpawns {
    public static void initialize() {
        List<ResourceKey<Biome>> frostbiteBiomes = List.of(
                Biomes.SNOWY_PLAINS, Biomes.SNOWY_SLOPES, Biomes.SNOWY_TAIGA,
                Biomes.FROZEN_RIVER, Biomes.FROZEN_PEAKS,
                Biomes.GROVE, Biomes.ICE_SPIKES
        );
        List<ResourceKey<Biome>> boggedBiomes = List.of(
                Biomes.SWAMP, Biomes.MANGROVE_SWAMP,
                Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE
        );

        // PARTIALLY CUT FOR 1.0
        BiomeModifications.create(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frozen_monster_spawns"))
//                .add(ModificationPhase.REMOVALS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
//                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.ZOMBIE))
                .add(ModificationPhase.REMOVALS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.SKELETON))
                .add(ModificationPhase.REMOVALS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.STRAY))

                .add(ModificationPhase.ADDITIONS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4), 20))
                .add(ModificationPhase.ADDITIONS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4), 20))
                .add(ModificationPhase.ADDITIONS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EntityType.STRAY, 4, 4), 80))
//                .add(ModificationPhase.ADDITIONS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
//                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
//                                new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 4, 4), 75))
        ;

        BiomeModifications.create(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bogged_spawns"))
                .add(ModificationPhase.REMOVALS, ctx -> boggedBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.SKELETON))
                .add(ModificationPhase.REMOVALS, ctx -> boggedBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.BOGGED))

                .add(ModificationPhase.ADDITIONS, ctx -> boggedBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4), 30))
                .add(ModificationPhase.ADDITIONS, ctx -> boggedBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EntityType.BOGGED, 4, 4), 70))
        ;

        List<ResourceKey<Biome>> mudGolemSurfaceBiomes = List.of(
                Biomes.SWAMP, Biomes.MANGROVE_SWAMP
        );

        // CUT FOR 1.0
//        BiomeModifications.addSpawn(ctx -> ctx.hasTag(BiomeTags.IS_OVERWORLD),
//                MobCategory.MONSTER, EEntities.WEREWOLF, 35, 1, 1);
        BiomeModifications.addSpawn(ctx -> mudGolemSurfaceBiomes.contains(ctx.getBiomeKey()),
                MobCategory.MONSTER, EEntities.MUD_GOLEM, 65, 1, 2);

        BiomeModifications.addSpawn(ctx -> ctx.getBiomeKey() == Biomes.SOUL_SAND_VALLEY,
                MobCategory.MONSTER, EEntities.SOUL, 15, 2, 4);

        BiomeModifications.addSpawn(ctx -> ctx.getBiomeKey() == Biomes.RIVER,
                MobCategory.WATER_AMBIENT, EEntities.PERCH, 1, 3, 5);
        BiomeModifications.addSpawn(ctx -> ctx.getBiomeKey() == Biomes.SWAMP,
                MobCategory.WATER_AMBIENT, EEntities.PERCH, 2, 3, 5);
        BiomeModifications.addSpawn(ctx -> ctx.getBiomeKey() == Biomes.MANGROVE_SWAMP,
                MobCategory.WATER_AMBIENT, EEntities.PERCH, 2, 3, 5);
    }
}
