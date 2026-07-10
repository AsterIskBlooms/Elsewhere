package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.levelgen.Heightmap;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.Frostbite;
import team.lookingglass.elsewhere.entity.mob.Perch;

public interface EEntities {
    ResourceKey<EntityType<?>> FROSTBITE_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frostbite"));
    ResourceKey<EntityType<?>> PERCH_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "perch"));

    EntityType<Frostbite> FROSTBITE = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            FROSTBITE_KEY,
            EntityType.Builder.of(Frostbite::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
                    .build(FROSTBITE_KEY)
    );

    EntityType<Perch> PERCH = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            PERCH_KEY,
            EntityType.Builder.of(Perch::new, MobCategory.WATER_AMBIENT)
                    .sized(0.4F, 0.4F)
                    .build(PERCH_KEY)
    );

    static void initialize() {
        FabricDefaultAttributeRegistry.register(FROSTBITE, Frostbite.createAttributes().build());
        SpawnPlacements.register(FROSTBITE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Frostbite::checkFrostbiteSpawnRules);

        FabricDefaultAttributeRegistry.register(PERCH, Perch.createAttributes().build());
        SpawnPlacements.register(PERCH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Perch::checkMobSpawnRules);
    }
}
