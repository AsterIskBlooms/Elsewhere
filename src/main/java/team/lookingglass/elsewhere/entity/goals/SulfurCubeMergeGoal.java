package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.phys.Vec3;
import team.lookingglass.elsewhere.entity.mob.SulfurCube;

import java.util.EnumSet;

public class SulfurCubeMergeGoal extends Goal {
    private final SulfurCube cube;
    private SulfurCube partner;

    public SulfurCubeMergeGoal(SulfurCube cube) {
        this.cube = cube;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
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
        if (cube.getMoveControl() instanceof Slime.SlimeMoveControl moveControl) {
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