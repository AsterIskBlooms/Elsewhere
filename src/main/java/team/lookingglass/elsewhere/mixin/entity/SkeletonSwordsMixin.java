package team.lookingglass.elsewhere.mixin.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeleton.class)
public abstract class SkeletonSwordsMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At("HEAD"), cancellable = true)
    private void elsewhere$maybeGiveMeleeWeapon(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if ((Object) this instanceof Skeleton) {
            if (random.nextFloat() < 0.2F) {
                ((Mob) (Object) this).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
                ci.cancel();
            }
        }
    }
}