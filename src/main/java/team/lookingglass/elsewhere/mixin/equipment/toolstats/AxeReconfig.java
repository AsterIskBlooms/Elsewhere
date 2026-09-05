package team.lookingglass.elsewhere.mixin.equipment.toolstats;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.HashMap;
import java.util.Map;

@Mixin(AxeItem.class)
public class AxeReconfig {
    @ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;axe(Lnet/minecraft/world/item/ToolMaterial;FF)Lnet/minecraft/world/item/Item$Properties;"))
    private static void modifyArgs(Args args) {
        ToolMaterial material = args.get(0);
        if (material == ToolMaterial.WOOD) { args.set(1, 5.0F); args.set(2, -3.2F); }
        else if (material == ToolMaterial.STONE) { args.set(1, 6.0F); args.set(2, -3.2F); }
        else if (material == ToolMaterial.COPPER) { args.set(1, 6.0F); args.set(2, -3.2F); }
        else if (material == ToolMaterial.IRON) { args.set(1, 6.0F); args.set(2, -3.1F); }
        else if (material == ToolMaterial.GOLD) { args.set(1, 6.0F); args.set(2, -3.0F); }
        else if (material == ToolMaterial.DIAMOND) { args.set(1, 5.0F); args.set(2, -3.0F); }
        else if (material == ToolMaterial.NETHERITE) { args.set(1, 5.0F); args.set(2, -3.0F); }
    }

    // Axe Strippables Widener
    @Mutable
    @Shadow
    @Final
    public static Map<Block, Block> STRIPPABLES;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void elsewhere$makeStrippablesMutable(CallbackInfo ci) {
        STRIPPABLES = new HashMap<>(STRIPPABLES);
    }
}
