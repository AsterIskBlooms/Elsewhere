package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ShieldItem;

import java.util.EnumSet;
import java.util.function.Predicate;

public class RaiseShieldGoal<T extends Mob> extends Goal {

    private final T mob;
    private final Predicate<T> shouldBlock;

    public RaiseShieldGoal(T mob, Predicate<T> shouldBlock) {
        this.mob = mob;
        this.shouldBlock = shouldBlock;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = mob.getTarget();

        return target != null
                && target.isAlive()
                && mob.hasLineOfSight(target)
                && mob.getOffhandItem().getItem() instanceof ShieldItem
                && shouldBlock.test(mob);
    }

    @Override
    public boolean canContinueToUse() {
        return canUse();
    }

    @Override
    public void start() {
        mob.startUsingItem(InteractionHand.OFF_HAND);
    }

    @Override
    public void stop() {
        mob.stopUsingItem();
    }

    @Override
    public void tick() {
        if (shouldBlock.test(mob)) {
            if (!mob.isUsingItem()) {
                mob.startUsingItem(InteractionHand.OFF_HAND);
            }
        } else if (mob.isUsingItem()) {
            mob.stopUsingItem();
        }

        LivingEntity target = mob.getTarget();
        if (target != null) {
            mob.getLookControl().setLookAt(target);
        }
    }
}