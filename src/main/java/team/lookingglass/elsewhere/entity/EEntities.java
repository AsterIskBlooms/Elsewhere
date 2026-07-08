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
import net.minecraft.world.level.levelgen.Heightmap;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.hostile.Frostbite;

public interface EEntities {
    ResourceKey<EntityType<?>> FROSTBITE_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "frostbite"));

    EntityType<Frostbite> FROSTBITE = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            FROSTBITE_KEY,
            EntityType.Builder.of(Frostbite::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
                    .build(FROSTBITE_KEY)
    );

    static void initialize() {
        FabricDefaultAttributeRegistry.register(EEntities.FROSTBITE, Frostbite.createAttributes().build());
        SpawnPlacements.register(EEntities.FROSTBITE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Frostbite::checkFrostbiteSpawnRules);
    }
}
