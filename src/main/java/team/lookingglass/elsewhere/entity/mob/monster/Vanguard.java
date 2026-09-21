package team.lookingglass.elsewhere.entity.mob.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.goals.RaiseShieldGoal;
import team.lookingglass.elsewhere.registry.EItems;
import team.lookingglass.elsewhere.registry.util.shield.ShieldCooldownAccess;

import java.util.Objects;

public class Vanguard extends Monster {
    private static final Identifier ENRAGE_SPEED_MODIFIER = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "enrage_speed");
    private static final int ENRAGE_DURATION_TICKS = 100;
    private int attackCooldownTicks;
    private boolean previousShieldDisabled;
    private int enragedTicks;

    public Vanguard(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(EItems.VANGUARD_MASK));
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        setCanPickUpLoot(false);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            setDropChance(slot, 0.0F);
        }
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RaiseShieldGoal<>(this, mob -> mob.isAttackCoolingDown() && !mob.isShieldDisabled()));
        goalSelector.addGoal(2, new VanguardAttackGoal(this, 1.0, false));
        goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.6));
        goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 15.0);
    }

    public boolean isAttackCoolingDown() {
        return attackCooldownTicks > 0;
    }

    public void setAttackCooldownTicks(int ticks) {
        attackCooldownTicks = ticks;
    }

    public boolean isShieldDisabled() {
        return ((ShieldCooldownAccess)this).elsewhere$isShieldDisabled();
    }

    public boolean isEnraged() {
        return enragedTicks > 0;
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide() && tickCount % 5 == 0) {
            updateControlFlags();
        }

        if (attackCooldownTicks > 0) {
            attackCooldownTicks--;
        }

        if (!level().isClientSide()) {
            boolean shieldDisabled = isShieldDisabled();

            if (!previousShieldDisabled && shieldDisabled) {
                triggerEnrage();
            }
            previousShieldDisabled = shieldDisabled;
        }

        if (enragedTicks > 0) {
            enragedTicks--;
            if (enragedTicks == 0) {
                Objects.requireNonNull(getAttribute(Attributes.MOVEMENT_SPEED))
                        .removeModifier(ENRAGE_SPEED_MODIFIER);
            }
        }
    }

    private void triggerEnrage() {
        enragedTicks = ENRAGE_DURATION_TICKS;
        Objects.requireNonNull(getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(ENRAGE_SPEED_MODIFIER);
        Objects.requireNonNull(getAttribute(Attributes.MOVEMENT_SPEED))
                .addTransientModifier(new AttributeModifier(ENRAGE_SPEED_MODIFIER, 1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        playSound(SoundEvents.SHIELD_BLOCK.value(), 1.0F, 0.8F + random.nextFloat() * 0.4F);
        playSound(SoundEvents.SHIELD_BREAK.value(), 0.8F, 0.8F + random.nextFloat() * 0.4F);
    }

    public static boolean checkVanguardSpawnRules(
            EntityType<Vanguard> type,
            ServerLevelAccessor level,
            EntitySpawnReason spawnType,
            BlockPos pos,
            RandomSource random
    ) {
        return pos.getY() < 48 && checkMonsterSpawnRules(type, level, spawnType, pos, random);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.IRON_GOLEM_DAMAGE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.IRON_GOLEM_DAMAGE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    public static class VanguardAttackGoal extends MeleeAttackGoal {
        private final Vanguard vanguard;

        public VanguardAttackGoal(Vanguard vanguard, double speed, boolean follow) {
            super(vanguard, speed, follow);
            this.vanguard = vanguard;
        }

        @Override
        protected int getAttackInterval() {
            return vanguard.isEnraged() ? 20 : 40;
        }

        @Override
        protected void resetAttackCooldown() {
            super.resetAttackCooldown();
            vanguard.setAttackCooldownTicks(
                    30 + vanguard.getRandom().nextInt(31)
            );
        }

        @Override
        public void tick() {
            super.tick();
        }
    }
}