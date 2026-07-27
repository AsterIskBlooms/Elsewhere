package team.lookingglass.elsewhere.registry.trim;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import team.lookingglass.elsewhere.Elsewhere;

import java.util.Map;

public class ETrimMaterials {
    public static final ResourceKey<TrimMaterial> TIN = createKey("tin");
    public static final ResourceKey<TrimMaterial> BRONZE = createKey("bronze");
    public static final ResourceKey<TrimMaterial> SILVER = createKey("silver");
    public static final ResourceKey<TrimMaterial> SOULSTEEL = createKey("soulsteel");

    private static ResourceKey<TrimMaterial> createKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    public static void bootstrap(BootstrapContext<TrimMaterial> ctx) {
        register(ctx, TIN, "tin",
                coloredName("tin", 0xDBDBC0));
        register(ctx, BRONZE, "bronze", "bronze_darker", EEquipmentAssets.BRONZE,
                coloredName("bronze", 0xC4864A));
        register(ctx, SILVER, "silver",
                coloredName("silver", 0xDEF6EE));
        register(ctx, SOULSTEEL, "soulsteel", "soulsteel_darker", EEquipmentAssets.SOULSTEEL,
                coloredName("soulsteel", 0x758894));
    }

    private static Component coloredName(String path, int rgb) {
        return Component.translatable("trim_material.elsewhere." + path)
                .withStyle(style -> style.withColor(TextColor.fromRgb(rgb)));
    }
    private static void register(BootstrapContext<TrimMaterial> ctx, ResourceKey<TrimMaterial> key,
                                 String baseName, Component description) {
        ctx.register(key, new TrimMaterial(MaterialAssetGroup.create(baseName), description));
    }
    private static void register(BootstrapContext<TrimMaterial> ctx, ResourceKey<TrimMaterial> key,
                                 String baseName, String darkerName, ResourceKey<EquipmentAsset> darkerFor,
                                 Component description) {
        MaterialAssetGroup assets = MaterialAssetGroup.create(baseName, Map.of(darkerFor, darkerName));
        ctx.register(key, new TrimMaterial(assets, description));
    }

}
