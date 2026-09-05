package team.lookingglass.elsewhere.mixin.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Slime;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lookingglass.elsewhere.entity.mob.monster.Subslime;

@Mixin(Slime.class)
public abstract class SubslimeDeathMixin {
    @Inject(method = "remove", at = @At("HEAD"), cancellable = true)
    private void elsewhere$preventSubslimeSplitting(Entity.RemovalReason reason, CallbackInfo ci) {
        if ((Object) this instanceof Subslime subslime) {
            subslime.setRemoved(reason);
            ci.cancel();
        }
    }
}