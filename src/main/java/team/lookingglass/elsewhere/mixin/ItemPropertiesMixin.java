package team.lookingglass.elsewhere.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.Properties.class)
public class ItemPropertiesMixin {

    @Inject(method = "humanoidArmor", at = @At("HEAD"), cancellable = true)
    private void modifyArmorDurability(ArmorMaterial material, ArmorType type,
                                       CallbackInfoReturnable<Item.Properties> cir) {
        int newMultiplier;
        if (material == ArmorMaterials.COPPER)           newMultiplier = 15;
        else if (material == ArmorMaterials.IRON)        newMultiplier = 25;
        else if (material == ArmorMaterials.CHAINMAIL)   newMultiplier = 75;
        else if (material == ArmorMaterials.GOLD)        newMultiplier = 20;
        else if (material == ArmorMaterials.LEATHER)     newMultiplier = 25;
        else if (material == ArmorMaterials.TURTLE_SCUTE) newMultiplier = 75;
        else if (material == ArmorMaterials.DIAMOND)     newMultiplier = 75;
        else if (material == ArmorMaterials.NETHERITE)   newMultiplier = 125;
        else return; // unknown material, leave as vanilla

        Item.Properties self = (Item.Properties)(Object) this;
        cir.setReturnValue(self.durability(type.getDurability(newMultiplier))
                .attributes(material.createAttributes(type))
                .enchantable(material.enchantmentValue())
                .component(DataComponents.EQUIPPABLE, Equippable.builder(type.getSlot())
                        .setEquipSound(material.equipSound())
                        .setAsset(material.assetId())
                        .build())
                .repairable(material.repairIngredient()));
    }
}
