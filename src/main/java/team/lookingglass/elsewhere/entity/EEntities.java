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
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.levelgen.Heightmap;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.Frostbite;
import team.lookingglass.elsewhere.entity.mob.Perch;
import team.lookingglass.elsewhere.registry.EItems;

import java.util.function.Supplier;

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


    // Boats
    ResourceKey<EntityType<?>> POPLAR_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_boat"));
    ResourceKey<EntityType<?>> POPLAR_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_chest_boat"));
    ResourceKey<EntityType<?>> AZALEA_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "azalea_boat"));
    ResourceKey<EntityType<?>> AZALEA_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "azalea_chest_boat"));
    ResourceKey<EntityType<?>> CEDAR_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar_boat"));
    ResourceKey<EntityType<?>> CEDAR_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar_chest_boat"));

    EntityType<Boat> POPLAR_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, POPLAR_BOAT_KEY, EntityType.Builder.of(boatFactory(() -> EItems.POPLAR_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(POPLAR_BOAT_KEY));
    EntityType<ChestBoat> POPLAR_CHEST_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, POPLAR_CHEST_BOAT_KEY, EntityType.Builder.of(chestBoatFactory(() -> EItems.POPLAR_CHEST_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(POPLAR_CHEST_BOAT_KEY));

    EntityType<Boat> AZALEA_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, AZALEA_BOAT_KEY, EntityType.Builder.of(boatFactory(() -> EItems.AZALEA_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(AZALEA_BOAT_KEY));
    EntityType<ChestBoat> AZALEA_CHEST_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, AZALEA_CHEST_BOAT_KEY, EntityType.Builder.of(chestBoatFactory(() -> EItems.AZALEA_CHEST_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(AZALEA_CHEST_BOAT_KEY));

    EntityType<Boat> CEDAR_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, CEDAR_BOAT_KEY, EntityType.Builder.of(boatFactory(() -> EItems.CEDAR_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(CEDAR_BOAT_KEY));
    EntityType<ChestBoat> CEDAR_CHEST_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE, CEDAR_CHEST_BOAT_KEY, EntityType.Builder.of(chestBoatFactory(() -> EItems.CEDAR_CHEST_BOAT), MobCategory.MISC)
            .noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(CEDAR_CHEST_BOAT_KEY));

    static void initialize() {
        FabricDefaultAttributeRegistry.register(FROSTBITE, Frostbite.createAttributes().build());
        SpawnPlacements.register(FROSTBITE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Frostbite::checkFrostbiteSpawnRules);

        FabricDefaultAttributeRegistry.register(PERCH, Perch.createAttributes().build());
        SpawnPlacements.register(PERCH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Perch::checkMobSpawnRules);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(final Supplier<Item> boatItem) {
        return (entityType, level) -> new Boat(entityType, level, boatItem);
    }
    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(final Supplier<Item> boatItem) {
        return (entityType, level) -> new ChestBoat(entityType, level, boatItem);
    }
}
