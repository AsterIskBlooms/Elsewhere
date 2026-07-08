package team.lookingglass.elsewhere.registry.equipment;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;

public class AttributeArmorItem extends Item {
    public AttributeArmorItem(Properties properties) {
        super(properties);
    }

    public static Item.Properties createArmorProperties(ArmorMaterial material, ArmorType type, EquipmentSlotGroup equipSlot,
                                                        Holder<Attribute> modifier,  Identifier healthId, double amount, AttributeModifier.Operation operation) {
        ItemAttributeModifiers baseAttributes = material.createAttributes(type);
        ItemAttributeModifiers combinedAttributes = baseAttributes
                .withModifierAdded(modifier, new AttributeModifier(healthId, amount, operation), equipSlot);
        return new Item.Properties()
                .durability(type.getDurability(material.durability()))
                .attributes(combinedAttributes)
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot())
                        .setEquipSound(material.equipSound())
                        .setAsset(material.assetId())
                        .build())
                .repairable(material.repairIngredient());
    }
}
