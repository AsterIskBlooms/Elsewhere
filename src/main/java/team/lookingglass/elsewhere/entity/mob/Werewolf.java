package team.lookingglass.elsewhere.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.sounds.SoundEvent;
import team.lookingglass.elsewhere.entity.goals.WerewolfAttackGoal;
import team.lookingglass.elsewhere.registry.ESounds;

public class Werewolf extends Monster {
    public Werewolf(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    private static final double IDLE_SPEED = 0.20F;
    private static final double ATTACKING_SPEED = 0.35F;
    private static final double CHARGING_SPEED = 0.50F;
    private static final int CHARGE_COOLDOWN = 200;
    private static final float ATTACK_DAMAGE = 4.0F;
    private static final float CHARGE_DAMAGE = 15.0F;
    private static final int CHARGE_WINDUP = 40;
    private int chargeCooldown = 0;
    private boolean charging = false;
    private boolean chargedAttack = false;
    private int chargeWindupTicks = 0;
    private boolean preparingCharge = false;


    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(2, new WerewolfAttackGoal(this, ATTACKING_SPEED, CHARGING_SPEED));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0F)
                .add(Attributes.MOVEMENT_SPEED, IDLE_SPEED)
                .add(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE)
                .add(Attributes.ARMOR, 10.0F)
                .add(Attributes.FOLLOW_RANGE, 48.0)
                ;
    }

    public boolean isPreparingCharge() { return preparingCharge; }
    public boolean isCharging() { return charging; }
    public boolean canCharge() { return chargeCooldown <= 0; }

    public void startCharge() {
        if (canCharge()) {
            preparingCharge = true;
            chargeWindupTicks = CHARGE_WINDUP;
            playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 0.5F);
        }
    }

    public void endCharge() {
        charging = false;
        chargeCooldown = CHARGE_COOLDOWN;
    }

    public void performChargeDamage(ServerLevel level, LivingEntity target) {
        target.hurtServer(level, damageSources().mobAttack(this), CHARGE_DAMAGE);
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        boolean result = super.doHurtTarget(level, target);
        if (result && chargedAttack && target instanceof LivingEntity living) {
            performChargeDamage(level, living);
            chargedAttack = false;
            endCharge();
        }
        return result;
    }

    public static boolean checkWerewolfSpawnRules(EntityType<Werewolf> type, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return checkMonsterSpawnRules(type, level, spawnReason, pos, random);
    }

    @Override
    public void tick() {
        super.tick();
        if (chargeCooldown > 0) { chargeCooldown--; }

        if (preparingCharge) {
            chargeWindupTicks--;
            getNavigation().stop();
            if (chargeWindupTicks <= 0) {
                preparingCharge = false;
                charging = true;
                chargedAttack = true;
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENDER_DRAGON_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.ENDER_DRAGON_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENDER_DRAGON_AMBIENT; }

    @Override
    public boolean canFreeze() { return false; }
}