package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import team.lookingglass.elsewhere.entity.mob.Vanguard;

public class VanguardAttackGoal extends MeleeAttackGoal {
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
