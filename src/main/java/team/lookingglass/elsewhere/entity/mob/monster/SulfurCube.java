package team.lookingglass.elsewhere.entity.mob.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.registry.ESounds;
import team.lookingglass.elsewhere.registry.render.EParticles;

import java.util.EnumSet;
import java.util.List;

public class SulfurCube extends Slime {
    public static final int MAX_SULFUR_SIZE = 2;
    public static final double MERGE_SEARCH_RADIUS = 16.0D;
    public static final int MERGE_COOLDOWN_TICKS = 60;
    private int mergeCooldown = MERGE_COOLDOWN_TICKS;

    public SulfurCube(EntityType<? extends Slime> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new SulfurCubeMergeGoal(this));
        goalSelector.addGoal(2, new SulfurCubeFleeGoal(this));
        goalSelector.addGoal(3, new SulfurCubeAttackGoal(this));
        goalSelector.addGoal(4, new SlimeRandomDirectionGoal(this));
        goalSelector.addGoal(5, new SlimeKeepOnJumpingGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0)
                .add(Attributes.MOVEMENT_SPEED, 0.7)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0.0);
    }

    @Override
    protected float getJumpPower() {
        return this.getJumpPower(1.5F);
    }

    public boolean isSmall() {
        return getSize() == 1;
    }

    public boolean isLarge() {
        return getSize() == 2;
    }

    public boolean canMerge() {
        return isSmall() && mergeCooldown <= 0;
    }

    public void startMergeCooldown() {
        mergeCooldown = MERGE_COOLDOWN_TICKS;
    }

    @Override
    public void tick() {
        super.tick();
        if (mergeCooldown > 0) {
            mergeCooldown--;
        }
    }

    public static boolean checkSulfurCubeSpawnRules(EntityType<SulfurCube> type, ServerLevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        return checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    @Override
    protected boolean isDealsDamage() {
        return isLarge();
    }

    @Override
    protected void dealDamage(final LivingEntity target) {
        Level var3 = level();
        if (var3 instanceof ServerLevel level) {
            if (isAlive() && isWithinMeleeAttackRange(target) && hasLineOfSight(target)) {
                DamageSource damageSource = damageSources().mobAttack(this);
                if (target.hurtServer(level, damageSource, getAttackDamage())) {
                    playSound(ESounds.SULFUR_CUBE_ATTACK, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
                    EnchantmentHelper.doPostAttackEffects(level, target, damageSource);
                    target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), this);
                }
            }
        }
    }

    @Override
    public void setSize(int size, boolean updateHealth) {
        int actualSize = Mth.clamp(size, 1, MAX_SULFUR_SIZE);
        super.setSize(actualSize, updateHealth);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(actualSize == 1 ? 8.0 : 16.0);
        if (updateHealth) {
            this.setHealth(this.getMaxHealth());
        }
    }

    @Override
    protected void addAdditionalSaveData(@NonNull ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("MergeCooldown", mergeCooldown);
    }

    @Override
    protected void readAdditionalSaveData(@NonNull ValueInput input) {
        super.readAdditionalSaveData(input);
        mergeCooldown = input.getIntOr("MergeCooldown", 0);
    }

    @Nullable
    public SulfurCube findMergePartner() {
        if (!canMerge()) {
            return null;
        }
        List<SulfurCube> cubes = level().getEntitiesOfClass(
                SulfurCube.class, getBoundingBox().inflate(MERGE_SEARCH_RADIUS),
                cube -> cube != this && cube.canMerge()
        );
        return cubes.isEmpty() ? null : cubes.getFirst();
    }

    @Override
    public void remove(@NonNull RemovalReason reason) {
        if (!level().isClientSide() && isDeadOrDying() && getSize() > 1) {
            int newSize = getSize() / 2;
            for (int i = 0; i < 2; i++) {
                SulfurCube child = EEntities.SULFUR_CUBE.create(level(), EntitySpawnReason.TRIGGERED);
                if (child != null) {
                    child.setSize(newSize, true);
                    child.snapTo(getX() + (i == 0 ? -0.5 : 0.5), getY() + 0.5, getZ(), random.nextFloat() * 360.0F, 0.0F);
                    level().addFreshEntity(child);
                }
            }
            setSize(1, false);
        }
        super.remove(reason);
    }

    public void mergeWith(SulfurCube other) {
        if (level().isClientSide()) {
            return;
        }
        int newSize = getSize() + other.getSize();
        SulfurCube merged = EEntities.SULFUR_CUBE.create(level(), EntitySpawnReason.TRIGGERED);
        if (merged == null) { return; }
        merged.setSize(Math.min(newSize, MAX_SULFUR_SIZE), true);
        playSound(ESounds.SULFUR_CUBE_ABSORB, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
        merged.snapTo(
                (getX() + other.getX()) / 2.0, getY(),
                (getZ() + other.getZ()) / 2.0, getYRot(),
                0.0F
        );
        level().addFreshEntity(merged);
        startMergeCooldown();
        other.startMergeCooldown();
        discard();
        other.discard();
    }

    @Override
    protected ParticleOptions getParticleType() {
        return EParticles.SULFUR_CUBE_PARTICLE;
    }

    @Override
    protected SoundEvent getHurtSound(final DamageSource source) {
        return isTiny() ? ESounds.SMALL_SULFUR_CUBE_HURT : ESounds.SULFUR_CUBE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return isTiny() ? ESounds.SMALL_SULFUR_CUBE_DEATH : ESounds.SULFUR_CUBE_DEATH;
    }

    @Override
    protected SoundEvent getJumpSound() {
        return isTiny() ? ESounds.SMALL_SULFUR_CUBE_JUMP : ESounds.SULFUR_CUBE_JUMP;
    }

    @Override
    protected SoundEvent getSquishSound() {
        return isTiny() ? ESounds.SMALL_SULFUR_CUBE_SQUISH : ESounds.SULFUR_CUBE_SQUISH;
    }

    public static class SulfurCubeAttackGoal extends Goal {
        private final SulfurCube cube;
        private int tiredTimer;

        public SulfurCubeAttackGoal(SulfurCube cube) {
            this.cube = cube;
            this.setFlags(EnumSet.of(Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = cube.getTarget();
            if (target == null) { return false; }
            return cube.isLarge() && cube.canAttack(target);
        }

        @Override
        public void start() {
            this.tiredTimer = reducedTickDelay(300);
            super.start();
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = cube.getTarget();
            return target != null && cube.isLarge() && cube.canAttack(target) && --this.tiredTimer > 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() { return true; }

        @Override
        public void tick() {
            LivingEntity target = cube.getTarget();
            if (target != null) {
                cube.lookAt(target, 10.0F, 10.0F);
            }
            if (cube.getMoveControl() instanceof SlimeMoveControl moveControl) {
                moveControl.setDirection(cube.getYRot(), true);
            }
        }
    }

    public static class SulfurCubeFleeGoal extends Goal {

        private final SulfurCube cube;
        private Player target;


        public SulfurCubeFleeGoal(SulfurCube cube) {
            this.cube = cube;

            this.setFlags(EnumSet.of(
                    Flag.MOVE
            ));
        }


        @Override
        public boolean canUse() {
            if (!cube.isSmall()) { return false; }
            if (cube.findMergePartner() != null) { return false; }

            target = cube.level().getNearestPlayer(cube, 12.0D);
            return target != null;
        }


        @Override
        public boolean canContinueToUse() {
            return target != null
                    && target.isAlive() && cube.isSmall()
                    && cube.findMergePartner() == null
                    && cube.distanceTo(target) < 16.0D;
        }


        @Override
        public void stop() {
            target = null;
            cube.getNavigation().stop();
        }


        @Override
        public void tick() {
            if (target == null) { return; }

            Vec3 away = cube.position().subtract(target.position()).normalize();
            double fleeX = cube.getX() + away.x * 8.0D;
            double fleeZ = cube.getZ() + away.z * 8.0D;

            cube.getNavigation().moveTo(fleeX, cube.getY(), fleeZ, 1.25D);
        }
    }

    public static class SulfurCubeMergeGoal extends Goal {
        private final SulfurCube cube;
        private SulfurCube partner;

        public SulfurCubeMergeGoal(SulfurCube cube) {
            this.cube = cube;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (!cube.isSmall()) { return false; }
            partner = cube.findMergePartner();
            return partner != null;
        }

        @Override
        public boolean canContinueToUse() {
            return partner != null && partner.isAlive() && cube.isSmall() && partner.isSmall();
        }

        @Override
        public void stop() {
            partner = null;
        }

        @Override
        public void tick() {
            if (partner == null || !partner.isAlive()) { return; }

            cube.lookAt(partner, 10.0F, 10.0F);
            if (cube.getMoveControl() instanceof SlimeMoveControl moveControl) {
                Vec3 toPartner = partner.position().subtract(cube.position());
                float yRot = (float) (Mth.atan2(toPartner.z, toPartner.x) * (180.0 / Math.PI)) - 90.0F;
                moveControl.setDirection(yRot, true);
                moveControl.setWantedMovement(1.0);
            }

            if (cube.getBoundingBox().inflate(0.5D).intersects(partner.getBoundingBox())) {
                cube.mergeWith(partner);
                partner = null;
            }
        }
    }
}