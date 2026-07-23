package team.lookingglass.elsewhere.mixin.equipment.toolstats;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Items.class)
public class SwordPickReconfig {
    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;pickaxe(Lnet/minecraft/world/item/ToolMaterial;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static void modifyPickaxeArgs(Args args) {
        ToolMaterial material = args.get(0);
        if (material == ToolMaterial.WOOD) {
            args.set(1, (Float) args.get(1) - 1.0F);
        }
    }

    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;sword(Lnet/minecraft/world/item/ToolMaterial;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static void modifySwordArgs(Args args) {
        ToolMaterial material = args.get(0);
        if (material == ToolMaterial.WOOD) {
            args.set(1, (Float) args.get(1) - 1.0F);
        }
    }
}
