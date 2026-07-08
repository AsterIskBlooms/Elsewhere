package team.lookingglass.elsewhere.entity.hostile;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import team.lookingglass.elsewhere.registry.ESounds;

public class Frostbite extends Zombie {
    public Frostbite(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(ServerLevel level, Entity target) {
        boolean result = super.doHurtTarget(level, target);
        if (result && target instanceof LivingEntity living) {
            living.setTicksFrozen(Math.min(living.getTicksFrozen() + 200, 400));
        }
        return result;
    }

    public static boolean checkFrostbiteSpawnRules(EntityType<Frostbite> type, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        BlockPos checkSkyPos = pos;

        do {
            checkSkyPos = checkSkyPos.above();
        } while (level.getBlockState(checkSkyPos).is(Blocks.POWDER_SNOW));

        return Monster.checkMonsterSpawnRules(type, level, spawnReason, pos, random) && (EntitySpawnReason.isSpawner(spawnReason) || level.canSeeSky(checkSkyPos.below()));
    }

    @Override
    protected boolean convertsInWater() { return false; }

    @Override
    protected SoundEvent getAmbientSound() { return ESounds.FROSTBITE_IDLE; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return ESounds.FROSTBITE_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return ESounds.FROSTBITE_DEATH; }

    @Override
    protected boolean isSunSensitive() { return true; }

    @Override
    public boolean canFreeze() { return false; }
}