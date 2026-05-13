package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.type.SulfurCube;

public class EEntityType {
    public static final EntityType<SulfurCube> SULFUR_CUBE = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube"),
            EntityType.Builder.of(SulfurCube::new, MobCategory.MONSTER)
                    .sized(1.2F, 1.2F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube")))
    );

    public static void initialize () {
        FabricDefaultAttributeRegistry.register(EEntityType.SULFUR_CUBE, SulfurCube.createLivingAttributes());
    }
}