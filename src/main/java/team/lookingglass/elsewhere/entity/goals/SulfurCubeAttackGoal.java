package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;
import team.lookingglass.elsewhere.entity.mob.SulfurCube;

import java.util.EnumSet;

public class SulfurCubeAttackGoal extends Goal {
    private final SulfurCube cube;
    private int tiredTimer;

    public SulfurCubeAttackGoal(SulfurCube cube) {
        this.cube = cube;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK));
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
        if (cube.getMoveControl() instanceof Slime.SlimeMoveControl moveControl) {
            moveControl.setDirection(cube.getYRot(), true);
        }
    }
}
