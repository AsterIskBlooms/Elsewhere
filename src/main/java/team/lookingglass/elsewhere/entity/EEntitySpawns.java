package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
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

import java.util.List;

public class EEntitySpawns {
    public static void initialize() {
        List<ResourceKey<Biome>> frostbiteBiomes = List.of(
                Biomes.SNOWY_PLAINS, Biomes.SNOWY_SLOPES, Biomes.SNOWY_TAIGA,
                Biomes.FROZEN_RIVER, Biomes.FROZEN_PEAKS,
                Biomes.GROVE, Biomes.ICE_SPIKES
        );

        BiomeModifications.create(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frozen_monster_spawns"))
                .add(ModificationPhase.REMOVALS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().removeSpawnsOfEntityType(EntityType.ZOMBIE))
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
                .add(ModificationPhase.ADDITIONS, ctx -> frostbiteBiomes.contains(ctx.getBiomeKey()),
                        spawn -> spawn.getMobSpawnSettings().addSpawn(MobCategory.MONSTER,
                                new MobSpawnSettings.SpawnerData(EEntities.FROSTBITE, 4, 4), 75))
        ;
    }
}
