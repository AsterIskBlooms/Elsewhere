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
        mutate(ToolMaterial.STONE, 64, 2.5F, 0.0F, 7);
        mutate(ToolMaterial.COPPER, 185, 4.0F, 1.0F, 12);
        mutate(ToolMaterial.IRON, 640, 7.0F, 2.0F, 9);
        mutate(ToolMaterial.GOLD, 215, 12.0F, 2.0F, 22);
        mutate(ToolMaterial.DIAMOND, 1280, 8.0F, 3.0F, 18);
        mutate(ToolMaterial.NETHERITE, 2500, 9.0F, 4.0F, 13);
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
