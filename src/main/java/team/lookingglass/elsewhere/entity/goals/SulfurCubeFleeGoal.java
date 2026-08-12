package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import team.lookingglass.elsewhere.entity.mob.SulfurCube;

import java.util.EnumSet;

public class SulfurCubeFleeGoal extends Goal {

    private final SulfurCube cube;
    private Player target;


    public SulfurCubeFleeGoal(SulfurCube cube) {
        this.cube = cube;

        this.setFlags(EnumSet.of(
                Goal.Flag.MOVE
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