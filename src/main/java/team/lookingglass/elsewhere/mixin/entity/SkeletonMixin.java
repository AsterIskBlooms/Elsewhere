package team.lookingglass.elsewhere.mixin.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.skeleton.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.lookingglass.elsewhere.registry.EItems;

@Mixin(AbstractSkeleton.class)
public abstract class SkeletonMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At("HEAD"), cancellable = true)
    private void elsewhere$maybeGiveMeleeWeapon(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if ((Object) this instanceof Skeleton) {
            if (random.nextFloat() < 0.2F) {
                ((Mob) (Object) this).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
                ci.cancel();
            }
        }
        if ((Object) this instanceof Stray) {
            if (random.nextFloat() < 0.2F) {
                ((Mob) (Object) this).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
                ci.cancel();
            }
        }
        if ((Object) this instanceof Bogged) {
            if (random.nextFloat() < 0.2F) {
                ((Mob) (Object) this).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
                ci.cancel();
            }
        }
        if ((Object) this instanceof Parched) {
            if (random.nextFloat() < 0.2F) {
                ((Mob) (Object) this).setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
                ci.cancel();
            }
        }
    }
    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void elsewhere$reduceSkeletonHealth(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        if ((Object) this instanceof Skeleton) {
            ((Mob) (Object) this).getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
        }
        if ((Object) this instanceof Stray) {
            ((Mob) (Object) this).getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
            ((Mob) (Object) this).getAttribute(Attributes.ARMOR).setBaseValue(4);
        }
        if ((Object) this instanceof Bogged) {
            ((Mob) (Object) this).getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
        }
        if ((Object) this instanceof Parched) {
            ((Mob) (Object) this).getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
        }
    }
}