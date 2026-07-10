package team.lookingglass.elsewhere.mixin.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ConversionParams;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.entity.mob.Frostbite;

@Mixin(Zombie.class)
public abstract class ZombieConversionMixin {

    @Unique
    private static final EntityDataAccessor<Boolean> DATA_FROSTBITE_CONVERSION_ID = SynchedEntityData.defineId(Zombie.class, EntityDataSerializers.BOOLEAN);

    @Unique private int inPowderSnowTime;
    @Unique private int frostbiteConversionTime;

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void addFrostbiteConversionData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(DATA_FROSTBITE_CONVERSION_ID, false);
    }

    @Unique
    public boolean isFrostbiteConverting() {
        return ((Zombie) (Object) this).getEntityData().get(DATA_FROSTBITE_CONVERSION_ID);
    }

    @Unique
    public void setFrostbiteConverting(boolean converting) {
        ((Zombie) (Object) this).getEntityData().set(DATA_FROSTBITE_CONVERSION_ID, converting);
    }

    @Unique
    public boolean canFreeze() {
        return false;
    }

    @Inject(method = "convertsInWater", at = @At("HEAD"), cancellable = true)
    private void preventWaterConversionWhileFreezing(CallbackInfoReturnable<Boolean> cir) {
        if (this.isFrostbiteConverting()) cir.setReturnValue(false);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tickPowderSnowConversion(CallbackInfo ci) {
        Zombie self = (Zombie) (Object) this;
        if (self instanceof Frostbite) return;
        if (!(self.level() instanceof ServerLevel) || !self.isAlive() || self.isNoAi()) return;
        if (self.isInPowderSnow) {
            if (this.isFrostbiteConverting()) {
                --this.frostbiteConversionTime;
                if (this.frostbiteConversionTime < 0) {
                    this.doFrostbiteConversion((ServerLevel) self.level());
                }
            } else {
                ++this.inPowderSnowTime;
                if (this.inPowderSnowTime >= 140) {
                    this.startFrostbiteConversion(300);
                }
            }
        } else {
            this.inPowderSnowTime = -1;
            this.setFrostbiteConverting(false);
        }
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void saveFrostbiteConversion(ValueOutput output, CallbackInfo ci) {
        output.putInt("FrostbiteConversionTime", this.isFrostbiteConverting() ? this.frostbiteConversionTime : -1);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void loadFrostbiteConversion(ValueInput input, CallbackInfo ci) {
        int conversionTime = input.getIntOr("FrostbiteConversionTime", -1);
        if (conversionTime != -1) {
            this.startFrostbiteConversion(conversionTime);
        } else {
            this.setFrostbiteConverting(false);
        }
    }

    @Unique
    private void startFrostbiteConversion(int time) {
        this.frostbiteConversionTime = time;
        this.setFrostbiteConverting(true);
    }

    @Unique
    private void doFrostbiteConversion(ServerLevel level) {
        Zombie self = (Zombie) (Object) this;
        this.setFrostbiteConverting(false);
        self.convertTo(EEntities.FROSTBITE, ConversionParams.single(self, true, true), (frostbite) -> {
            if (!self.isSilent()) {
                level.levelEvent(null, 1048, self.blockPosition(), 0);
            }
        });
    }
}
