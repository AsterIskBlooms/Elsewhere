package net.asterisk.elsewhere.registry.tiers;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public interface XyloiteTier {
    // Xyloite
    int BASE_DURABILITY = 15;
    ResourceKey<EquipmentAsset> XYLOITE_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "xyloite"));
    TagKey<Item> REPAIRS_XYLOITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_xyloite_armor"));
    ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 2,
                    ArmorType.CHESTPLATE, 6,
                    ArmorType.LEGGINGS, 5,
                    ArmorType.BOOTS, 2
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_XYLOITE_ARMOR,
            XYLOITE_ARMOR_MATERIAL_KEY
    );
    ToolMaterial XYLOITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            455,
            6.0F,
            1.5F,
            16,
            REPAIRS_XYLOITE_ARMOR
    );
}
