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

public interface SylverTier {
    // Sylver
    int BASE_DURABILITY = 22;
    ResourceKey<EquipmentAsset> SYLVER_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sylver"));
    TagKey<Item> REPAIRS_SYLVER_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_sylver_armor"));
    ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 7,
                    ArmorType.LEGGINGS, 5,
                    ArmorType.BOOTS, 3
            ),
            18,
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0F,
            0.0F,
            REPAIRS_SYLVER_ARMOR,
            SYLVER_ARMOR_MATERIAL_KEY
    );
    ToolMaterial SYLVER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            820,
            9.0F,
            2.5F,
            22,
            REPAIRS_SYLVER_ARMOR
        );
}
