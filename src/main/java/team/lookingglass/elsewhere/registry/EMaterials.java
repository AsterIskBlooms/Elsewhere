package team.lookingglass.elsewhere.registry;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.datagen.BlockTagProvider;
import team.lookingglass.elsewhere.datagen.ItemTagProvider;

import java.util.Map;

public interface EMaterials {

    ResourceKey<EquipmentAsset> SILVER_ARMOR_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "silver"));
    int SILVER_DURABILITY = 15;
    ToolMaterial SILVER_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            950,
            7F,
            2F,
            18,
            ItemTagProvider.REPAIRS_SILVER_ARMOR
    );
    ArmorMaterial SILVER_ARMOR = new ArmorMaterial(
            SILVER_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 7,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 2
            ),
            18,
            SoundEvents.ARMOR_EQUIP_GOLD,
            1F,
            0.0F,
            ItemTagProvider.REPAIRS_SILVER_ARMOR,
            SILVER_ARMOR_KEY
    );

    ResourceKey<EquipmentAsset> SOULSTEEL_ARMOR_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel"));
    int SOULSTEEL_DURABILITY = 33;
    ToolMaterial SOULSTEEL_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            2400,
            12F,
            3F,
            16,
            ItemTagProvider.REPAIRS_SOULSTEEL_ARMOR
    );
    ArmorMaterial SOULSTEEL_ARMOR = new ArmorMaterial(
            SOULSTEEL_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            16,
            SoundEvents.ARMOR_EQUIP_GOLD,
            4F,
            0.05F,
            ItemTagProvider.REPAIRS_SOULSTEEL_ARMOR,
            SOULSTEEL_ARMOR_KEY
    );
}