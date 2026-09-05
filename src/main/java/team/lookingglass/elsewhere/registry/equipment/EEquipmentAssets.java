package team.lookingglass.elsewhere.registry.equipment;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import team.lookingglass.elsewhere.Elsewhere;

public class EEquipmentAssets {
    public static final ResourceKey<EquipmentAsset> BRONZE = createKey("bronze");
    public static final ResourceKey<EquipmentAsset> SOULSTEEL = createKey("soulsteel");

    private static ResourceKey<EquipmentAsset> createKey(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    public static void bootstrap(BootstrapContext<EquipmentAsset> ctx) {
        ctx.register(BRONZE, new EquipmentAsset());
        ctx.register(SOULSTEEL, new EquipmentAsset());
    }
}