package team.lookingglass.elsewhere.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.entity.goals.SulfurCubeAttackGoal;
import team.lookingglass.elsewhere.entity.goals.SulfurCubeFleeGoal;
import team.lookingglass.elsewhere.entity.goals.SulfurCubeMergeGoal;

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
        goalSelector.addGoal(5, new SlimeKeepOnJumpingGoal(this));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    public boolean isSmall() { return getSize() == 1; }
    public boolean isLarge() { return getSize() == 2; }
    public boolean canMerge() { return (isSmall() || isLarge()) && mergeCooldown <= 0; }
    public void startMergeCooldown() { mergeCooldown = MERGE_COOLDOWN_TICKS; }

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
    protected boolean isDealsDamage() { return isLarge(); }

    @Override
    public void setSize(int size, boolean updateHealth) {
        super.setSize(Mth.clamp(size, 1, MAX_SULFUR_SIZE), updateHealth);
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
        if (!canMerge()) { return null; }
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
        if (level().isClientSide()) { return; }
        int newSize = getSize() + other.getSize();
        SulfurCube merged = EEntities.SULFUR_CUBE.create(level(), EntitySpawnReason.TRIGGERED);
        if (merged == null) { return; }
        merged.setSize(Math.min(newSize, MAX_SULFUR_SIZE), true);
        merged.snapTo(
                (getX() + other.getX()) / 2.0D, getY(),
                (getZ() + other.getZ()) / 2.0D, getYRot(),
                0.0F
        );
        level().addFreshEntity(merged);
        startMergeCooldown();
        other.startMergeCooldown();
        discard();
        other.discard();
    }
}
