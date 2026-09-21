package team.lookingglass.elsewhere.entity.mob.monster;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.util.PossessionAccess;
import team.lookingglass.elsewhere.registry.ESounds;
import team.lookingglass.elsewhere.registry.tags.EEntityTags;

public class Soul extends Monster {
    private static final Identifier POSSESSION_SPEED_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "possession_speed");
    private static final Identifier POSSESSION_DAMAGE_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "possession_damage");
    private static final Identifier POSSESSION_ARMOR_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "possession_armor");

    private @Nullable EntityReference<LivingEntity> possessing;

    public Soul(final EntityType<? extends Soul> type, final Level level) {
        super(type, level);
        this.moveControl = new SoulMoveControl(this);
        this.xpReward = 11;
    }

    public void tick() {
        this.noPhysics = true;
        super.tick();
        this.noPhysics = false;
        this.setNoGravity(true);

        LivingEntity host = this.getPossessing();
        if (host != null) {
            if (!host.isAlive()) {
                this.unpossess(host);
            } else {
                this.setPos(host.getX(), host.getY(), host.getZ());
            }
        }
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FindPossessTargetGoal());
        this.goalSelector.addGoal(2, new SoulRandomMoveGoal());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0);
    }

    @Override
    public boolean ignoreExplosion(final Explosion explosion) {
        return true;
    }

    public @Nullable LivingEntity getPossessing() {
        return EntityReference.get(this.possessing, this.level(), LivingEntity.class);
    }

    public boolean isPossessing() {
        return this.possessing != null;
    }

    private void possess(final LivingEntity target) {
        this.possessing = EntityReference.of(target);
        this.setInvisible(true);
        this.setPos(target.getX(), target.getY(), target.getZ());

        ((PossessionAccess)target).elsewhere$setPossessed(true);

        AttributeInstance speed = target.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            speed.addOrUpdateTransientModifier(new AttributeModifier(POSSESSION_SPEED_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }
        AttributeInstance damage = target.getAttribute(Attributes.ATTACK_DAMAGE);
        if (damage != null) {
            damage.addOrUpdateTransientModifier(new AttributeModifier(POSSESSION_DAMAGE_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }
        AttributeInstance armor = target.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.addOrUpdateTransientModifier(new AttributeModifier(POSSESSION_ARMOR_ID, 8.0, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    private void unpossess(final LivingEntity host) {
        this.possessing = null;
        this.setInvisible(false);

        ((PossessionAccess)host).elsewhere$setPossessed(false);

        AttributeInstance speed = host.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            speed.removeModifier(POSSESSION_SPEED_ID);
        }
        AttributeInstance damage = host.getAttribute(Attributes.ATTACK_DAMAGE);
        if (damage != null) {
            damage.removeModifier(POSSESSION_DAMAGE_ID);
        }
        AttributeInstance armor = host.getAttribute(Attributes.ARMOR);
        if (armor != null) {
            armor.removeModifier(POSSESSION_ARMOR_ID);
        }
    }

    @Override protected SoundEvent getAmbientSound() { return SoundEvents.SOUL_ESCAPE.value(); }
    @Override protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.SOUL_ESCAPE.value(); }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.SOUL_ESCAPE.value(); }

    private class SoulMoveControl extends MoveControl {
        public SoulMoveControl(final Soul soul) {
            super(soul);
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO) {
                Vec3 delta = new Vec3(this.wantedX - Soul.this.getX(), this.wantedY - Soul.this.getY(), this.wantedZ - Soul.this.getZ());
                double deltaLength = delta.length();
                if (deltaLength < Soul.this.getBoundingBox().getSize()) {
                    this.operation = Operation.WAIT;
                    Soul.this.setDeltaMovement(Soul.this.getDeltaMovement().scale(0.5F));
                } else {
                Soul.this.setDeltaMovement(Soul.this.getDeltaMovement().add(delta.scale(this.speedModifier * 0.05 / deltaLength)));

                Vec3 movement = Soul.this.getDeltaMovement();
                float targetYaw = -((float)Mth.atan2(movement.x, movement.z)) * (180F / (float)Math.PI);

                Soul.this.setYRot(Mth.rotLerp(0.35F, Soul.this.getYRot(), targetYaw));
                Soul.this.yBodyRot = Soul.this.getYRot();
                }
            }
        }
    }

    private class FindPossessTargetGoal extends Goal {
        private static final double SEARCH_RADIUS = 16.0;
        private static final double POSSESS_RANGE_SQ = 1.0;

        private @Nullable LivingEntity target;

        public FindPossessTargetGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (Soul.this.isPossessing()) {
                return false;
            }
            if (this.target != null) {
                return true;
            }
            if (Soul.this.random.nextInt(reducedTickDelay(20)) != 0) {
                return false;
            }

            List<LivingEntity> candidates = Soul.this.level().getEntitiesOfClass(
                    LivingEntity.class,
                    Soul.this.getBoundingBox().inflate(SEARCH_RADIUS),
                    entity -> BuiltInRegistries.ENTITY_TYPE.wrapAsHolder(entity.getType()).is(EEntityTags.POSSESSABLE)
                            && !((PossessionAccess) entity).elsewhere$isPossessed()
            );

            this.target = null;
            double bestDistSq = SEARCH_RADIUS * SEARCH_RADIUS;
            for (LivingEntity candidate : candidates) {
                double distSq = Soul.this.distanceToSqr(candidate);
                if (distSq <= bestDistSq) {
                    bestDistSq = distSq;
                    this.target = candidate;
                }
            }
            return this.target != null;
        }

        public boolean canContinueToUse() {
            return this.target != null && this.target.isAlive() && !Soul.this.isPossessing();
        }

        public void start() {
            this.updateWantedPosition();
        }

        public void stop() {
            this.target = null;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.target == null) {
                return;
            }
            if (((PossessionAccess) this.target).elsewhere$isPossessed()) {
                this.target = null;
                return;
            }
            this.updateWantedPosition();
            if (Soul.this.distanceToSqr(this.target) <= POSSESS_RANGE_SQ) {
                Soul.this.possess(this.target);
                this.target = null;
            }
        }

        private void updateWantedPosition() {
            assert this.target != null;
            Soul.this.moveControl.setWantedPosition(this.target.getX(), this.target.getY(), this.target.getZ(), 1.0);
        }
    }

    private class SoulRandomMoveGoal extends Goal {
        public SoulRandomMoveGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return !Soul.this.isPossessing() && !Soul.this.getMoveControl().hasWanted() && Soul.this.random.nextInt(reducedTickDelay(7)) == 0;
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void tick() {
            RandomSource random = Soul.this.random;
            for (int attempts = 0; attempts < 3; ++attempts) {
                double x = Soul.this.getX() + (random.nextDouble() - 0.5) * 14.0;
                double y = Soul.this.getY() + (random.nextDouble() - 0.5) * 10.0;
                double z = Soul.this.getZ() + (random.nextDouble() - 0.5) * 14.0;
                if (Soul.this.level().noCollision(new AABB(x - 0.15, y - 0.15, z - 0.15, x + 0.15, y + 0.15, z + 0.15))) {
                    Soul.this.moveControl.setWantedPosition(x, y, z, 0.25);
                    break;
                }
            }
        }
    }
}
