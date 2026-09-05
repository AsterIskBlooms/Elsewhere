package team.lookingglass.elsewhere.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.lookingglass.elsewhere.Elsewhere;

public interface EItemTags {
    TagKey<Item> REPAIRS_BRONZE_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_bronze_armor"));
    TagKey<Item> REPAIRS_SILVER_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_silver_armor"));
    TagKey<Item> REPAIRS_SOULSTEEL_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_soulsteel_armor"));

    TagKey<Item> REPAIRS_VANGUARD_MASK = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_vanguard_mask"));

    TagKey<Item> POPLAR_LOGS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_logs"));
    TagKey<Item> AZALEA_LOGS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "azalea_logs"));
    TagKey<Item> CEDAR_LOGS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar_logs"));
    TagKey<Item> MAHOGANY_LOGS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mahogany_logs"));

    TagKey<Item> BRONZE_TOOLS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bronze_tools"));
    TagKey<Item> BRONZE_EQUIPMENT = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bronze_equipment"));
    TagKey<Item> SOULSTEEL_TOOLS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_tools"));
    TagKey<Item> SOULSTEEL_EQUIPMENT = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_equipment"));

    static void initialize() {}
}
