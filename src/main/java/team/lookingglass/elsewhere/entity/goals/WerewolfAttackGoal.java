package team.lookingglass.elsewhere.entity.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import team.lookingglass.elsewhere.entity.mob.Werewolf;

public class WerewolfAttackGoal extends MeleeAttackGoal {
    private final Werewolf werewolf;
    private final double attackSpeed;
    private final double chargeSpeed;

    public WerewolfAttackGoal(Werewolf werewolf, double attackSpeed, double chargeSpeed) {
        super(werewolf, 1.0, false);
        this.werewolf = werewolf;
        this.attackSpeed = attackSpeed;
        this.chargeSpeed = chargeSpeed;
    }

    @Override
    public void tick() {
        LivingEntity target = werewolf.getTarget();

        if (target != null) {
            if (!werewolf.isPreparingCharge()
                    && !werewolf.isCharging()
                    && werewolf.canCharge()
                    && werewolf.distanceTo(target) > 8.0) {

                werewolf.startCharge();
            }
            if (werewolf.isCharging()) {
                werewolf.getAttribute(Attributes.MOVEMENT_SPEED)
                        .setBaseValue(chargeSpeed);
            }
            else {
                werewolf.getAttribute(Attributes.MOVEMENT_SPEED)
                        .setBaseValue(attackSpeed);
            }
        }
        super.tick();
    }
}
