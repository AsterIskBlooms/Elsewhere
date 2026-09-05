package team.lookingglass.elsewhere.mixin.equipment.toolstats;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(HoeItem.class)
public class HoeReconfig {
    @ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;hoe(Lnet/minecraft/world/item/ToolMaterial;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static void modifyArgs(Args args) {
        ToolMaterial material = args.get(0);
        if (material == ToolMaterial.WOOD) { args.set(1, 0.0F); args.set(2, -3.0F); }
        else if (material == ToolMaterial.STONE) { args.set(1, 0.0F); args.set(2, -3.0F); }
        else if (material == ToolMaterial.COPPER) { args.set(1, -1.0F); args.set(2, -2.0F); }
        else if (material == ToolMaterial.GOLD) { args.set(1, -2.0F); args.set(2, -1.0F); }
    }
}