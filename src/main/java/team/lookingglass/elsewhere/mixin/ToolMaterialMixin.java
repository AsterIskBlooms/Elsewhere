package team.lookingglass.elsewhere.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {

    @Inject(method = "applyCommonProperties", at = @At("HEAD"), cancellable = true)
    private void modifyDurability(Item.Properties properties, CallbackInfoReturnable<Item.Properties> cir) {
        ToolMaterial self = (ToolMaterial)(Object) this;
        int newDurability;
        if (self == ToolMaterial.WOOD)           newDurability = 80;
        else if (self == ToolMaterial.STONE)     newDurability = 160;
        else if (self == ToolMaterial.COPPER)    newDurability = 350;
        else if (self == ToolMaterial.IRON)      newDurability = 600;
        else if (self == ToolMaterial.GOLD)      newDurability = 450;
        else if (self == ToolMaterial.DIAMOND)   newDurability = 1800;
        else if (self == ToolMaterial.NETHERITE) newDurability = 4000;
        else return;

        cir.setReturnValue(properties
                .durability(newDurability)
                .repairable(self.repairItems())
                .enchantable(self.enchantmentValue()));
    }
}
