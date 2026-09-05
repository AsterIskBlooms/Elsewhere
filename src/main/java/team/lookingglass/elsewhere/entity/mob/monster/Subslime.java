package team.lookingglass.elsewhere.entity.mob.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import team.lookingglass.elsewhere.registry.ESounds;
import team.lookingglass.elsewhere.registry.render.EParticles;

import java.util.EnumSet;
import java.util.Objects;

public class Subslime extends Slime {
    private static final EntityDataAccessor<Integer> ATTACK_ANIMATION_TICKS = SynchedEntityData.defineId(Subslime.class, EntityDataSerializers.INT);
    private static final double MAX_HEALTH = 20.0D;
    private static final double MOVEMENT_SPEED = 0.5D;
    private static final double ATTACK_DAMAGE = 6.0D;
    private static final int ATTACK_ANIMATION_LENGTH = 10;
    private double attackMomentumX;
    private double attackMomentumZ;

    public Subslime(EntityType<? extends Slime> type, Level level) {
        super(type, level);
        setSize(2, false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACK_ANIMATION_TICKS, 0);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
        SpawnGroupData data = super.finalizeSpawn(level, difficulty, spawnReason, groupData);
        setSize(2, true);
        return data;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new SubslimeAttackGoal(this));
        goalSelector.addGoal(2, new SlimeRandomDirectionGoal(this));
        goalSelector.addGoal(3, new SlimeKeepOnJumpingGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 1.0)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0.5);
    }

    @Override
    public void setSize(int size, boolean updateHealth) {
        super.setSize(2, false);
        Objects.requireNonNull(getAttribute(Attributes.MAX_HEALTH)).setBaseValue(MAX_HEALTH);
        Objects.requireNonNull(getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(MOVEMENT_SPEED);
        Objects.requireNonNull(getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(ATTACK_DAMAGE);
        if (updateHealth) { setHealth(getMaxHealth()); }
    }

    @Override
    protected float getJumpPower() {
        return getJumpPower(1.15F);
    }

    @Override
    public void jumpFromGround() {
        LivingEntity target = getTarget();

        if (target != null) {
            Vec3 direction = target.position()
                    .add(target.getDeltaMovement().scale(4.0D))
                    .subtract(position());

            direction = new Vec3(direction.x, 0.0D, direction.z);

            if (direction.lengthSqr() > 1.0E-7D) {
                direction = direction.normalize();

                double speed = attackAnimationTicks() > 0 ? 1.4D : 0.8D;
                double jumpPower = attackAnimationTicks() > 0 ? 0.45D : getJumpPower();

                setDeltaMovement(direction.x * speed, jumpPower, direction.z * speed);
                needsSync = true;
                return;
            }
        }

        super.jumpFromGround();
    }

    public void startAttackAnimation() {
        entityData.set(ATTACK_ANIMATION_TICKS, ATTACK_ANIMATION_LENGTH);
    }

    public float getAttackAnimationProgress(float partialTicks) {
        return Mth.clamp((entityData.get(ATTACK_ANIMATION_TICKS) - partialTicks) / (float) ATTACK_ANIMATION_LENGTH, 0.0F, 1.0F);
    }

    private int attackAnimationTicks() {
        return entityData.get(ATTACK_ANIMATION_TICKS);
    }

    @Override
    public void tick() {
        super.tick();
        int attackTicks = entityData.get(ATTACK_ANIMATION_TICKS);
        if (attackTicks > 0) {
            entityData.set(ATTACK_ANIMATION_TICKS, attackTicks - 1);
            maintainAttackMomentum();
        }
    }

    private void maintainAttackMomentum() {
        Vec3 motion = getDeltaMovement();
        setDeltaMovement(attackMomentumX, motion.y, attackMomentumZ);
        needsSync = true;
    }

    private void performAttackLunge(LivingEntity target) {
        Vec3 direction = target.position().subtract(position());
        direction = new Vec3(direction.x, 0.0D, direction.z);

        if (direction.lengthSqr() < 1.0E-7D) {
            return;
        }
        direction = direction.normalize();

        attackMomentumX = direction.x * 0.35D;
        attackMomentumZ = direction.z * 0.35D;

        setDeltaMovement(direction.x * 1.4D, 0.55D, direction.z * 1.4D);
        startAttackAnimation();
        needsSync = true;
    }

    @Override
    protected boolean isDealsDamage() {
        return true;
    }

    @Override
    protected void dealDamage(LivingEntity target) {
        Level currentLevel = level();

        if (currentLevel instanceof ServerLevel level) {
            if (isAlive() && isWithinMeleeAttackRange(target) && hasLineOfSight(target)) {
                DamageSource damageSource = damageSources().mobAttack(this);
                if (target.hurtServer(level, damageSource, getAttackDamage())) {
                    playSound(ESounds.SULFUR_CUBE_ATTACK, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
                    EnchantmentHelper.doPostAttackEffects(level, target, damageSource);
                }
            }
        }
    }

    @Override
    protected ParticleOptions getParticleType() {
        return EParticles.SUBSLIME_PARTICLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ESounds.SULFUR_CUBE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ESounds.SULFUR_CUBE_DEATH;
    }

    @Override
    protected SoundEvent getJumpSound() {
        return ESounds.SULFUR_CUBE_JUMP;
    }

    @Override
    protected SoundEvent getSquishSound() {
        return ESounds.SULFUR_CUBE_SQUISH;
    }

    public static boolean checkSubslimeSpawnRules(EntityType<Subslime> type, ServerLevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        return pos.getY() < 0 && checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    public static class SubslimeAttackGoal extends Goal {
        private final Subslime cube;
        private int cooldown;

        public SubslimeAttackGoal(Subslime cube) {
            this.cube = cube;
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = cube.getTarget();

            if (target == null || !cube.canAttack(target)) {
                return false;
            }

            return cube.distanceToSqr(target) <= 144.0D;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = cube.getTarget();

            return target != null
                    && cube.canAttack(target)
                    && cube.distanceToSqr(target) <= 144.0D;
        }

        @Override
        public void start() {
            cooldown = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity target = cube.getTarget();

            if (target == null) { return; }
            cube.lookAt(target, 10.0F, 10.0F);

            if (cube.getMoveControl() instanceof Slime.SlimeMoveControl slimeMoveControl) {
                slimeMoveControl.setDirection(cube.getYRot(), true);
            }

            if (cooldown > 0) {
                cooldown--;
                return;
            }

            if (!cube.onGround()) { return; }
            cube.performAttackLunge(target);
            cooldown = 30;
        }
    }
}