package team.lookingglass.elsewhere.entity.mob.monster;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
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
import team.lookingglass.elsewhere.entity.goals.RaiseShieldGoal;
import team.lookingglass.elsewhere.registry.EItems;

public class Vanguard extends Monster {
    private int attackCooldownTicks;

    public Vanguard(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(EItems.VANGUARD_MASK));
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        setCanPickUpLoot(false);
        for (EquipmentSlot slot : EquipmentSlot.values()) { setDropChance(slot, 0.0F); }
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RaiseShieldGoal<>(this, Vanguard::isAttackCoolingDown));
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
                .add(Attributes.ENTITY_INTERACTION_RANGE, 15.0)
                ;
    }

    public boolean isAttackCoolingDown() { return attackCooldownTicks > 0; }
    public void setAttackCooldownTicks(int ticks) { attackCooldownTicks = ticks; }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && tickCount % 5 == 0) {
            updateControlFlags();
        }
        if (attackCooldownTicks > 0) {
            attackCooldownTicks--;
        }
    }

    public static boolean checkVanguardSpawnRules(EntityType<Vanguard> type, ServerLevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        return pos.getY() < 48 && checkMonsterSpawnRules(type, level, spawnType, pos, random);
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.IRON_GOLEM_DAMAGE; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.IRON_GOLEM_DAMAGE; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.IRON_GOLEM_DEATH; }

    @Override
    public boolean canFreeze() { return false; }

    public static class VanguardAttackGoal extends MeleeAttackGoal {
        private final Vanguard vanguard;

        public VanguardAttackGoal(Vanguard vanguard, double speed, boolean follow) {
            super(vanguard, speed, follow);
            this.vanguard = vanguard;
        }

        @Override
        protected int getAttackInterval() {
            return 40;
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