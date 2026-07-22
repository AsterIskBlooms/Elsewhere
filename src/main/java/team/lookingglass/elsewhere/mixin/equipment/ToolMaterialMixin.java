package team.lookingglass.elsewhere.mixin.equipment;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToolMaterial.class)
public abstract class ToolMaterialMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void patchMaterials(CallbackInfo ci) {
        mutate(ToolMaterial.STONE, 64, 2.0F, -1.0F, 7);
        mutate(ToolMaterial.COPPER, 122, 3.0F, 0.0F, 12);
        mutate(ToolMaterial.IRON, 350, 6.0F, 2.0F, 9);
        mutate(ToolMaterial.GOLD, 120, 12.0F, 2.0F, 22);
    }

    @Unique
    private static void mutate(ToolMaterial mat,
                               int durability, float speed, float attackDamageBonus, int enchantmentValue) {
        mat.durability = durability;
        mat.speed = speed;
        mat.attackDamageBonus = attackDamageBonus;
        mat.enchantmentValue = enchantmentValue;
    }
}
