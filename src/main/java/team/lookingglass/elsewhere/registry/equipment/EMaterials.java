package team.lookingglass.elsewhere.registry.equipment;

import com.google.common.collect.Maps;
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
import team.lookingglass.elsewhere.registry.tags.EBlockTags;
import team.lookingglass.elsewhere.registry.tags.EItemTags;

import java.util.Map;

public interface EMaterials {

    ResourceKey<EquipmentAsset> BRONZE_ARMOR_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bronze"));
    int BRONZE_DURABILITY = 23;

    ToolMaterial BRONZE_TOOL = new ToolMaterial(
            EBlockTags.INCORRECT_FOR_BRONZE_TOOL,
            365,
            6F,
            1F,
            18,
            EItemTags.REPAIRS_BRONZE_ARMOR
    );
    ArmorMaterial BRONZE_ARMOR = new ArmorMaterial(
            BRONZE_DURABILITY,
            makeDefense(3, 5, 4, 2, 12),
            15,
            SoundEvents.ARMOR_EQUIP_GOLD,
            0F,
            0.0F,
            EItemTags.REPAIRS_BRONZE_ARMOR,
            BRONZE_ARMOR_KEY
    );

    ResourceKey<EquipmentAsset> SOULSTEEL_ARMOR_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel"));
    int SOULSTEEL_DURABILITY = 33;

    ToolMaterial SOULSTEEL_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1920,
            10F,
            3F,
            16,
            EItemTags.REPAIRS_SOULSTEEL_ARMOR
    );
    ArmorMaterial SOULSTEEL_ARMOR = new ArmorMaterial(
            SOULSTEEL_DURABILITY,
            makeDefense(4, 7, 6, 3, 20),
            16,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            2F,
            0.00F,
            EItemTags.REPAIRS_SOULSTEEL_ARMOR,
            SOULSTEEL_ARMOR_KEY
    );

    private static Map<ArmorType, Integer> makeDefense( int helm, int chest, int legs, int boots, int body) {
        return Maps.newEnumMap(Map.of(
                ArmorType.BOOTS, boots,
                ArmorType.LEGGINGS, legs,
                ArmorType.CHESTPLATE, chest,
                ArmorType.HELMET, helm,
                ArmorType.BODY, body));
    }
}