package team.lookingglass.elsewhere.registry.equipment;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class SoulsteelItem extends Item {
    public SoulsteelItem(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float baseDamage = getBaseAttackDamage(stack);
        attacker.heal(baseDamage * 0.5F);
        super.hurtEnemy(stack, target, attacker);
    }

    @SuppressWarnings("deprecation")
    private static float getBaseAttackDamage(ItemStack stack) {
        ItemAttributeModifiers modifiers = stack.get(DataComponents.ATTRIBUTE_MODIFIERS);
        if (modifiers == null) return 0.0F;

        float total = 0.0F;
        for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
            if (entry.attribute().is(Attributes.ATTACK_DAMAGE)
                    && entry.modifier().operation() == AttributeModifier.Operation.ADD_VALUE) {
                total += (float) entry.modifier().amount();
            }
        }
        return total;
    }
}
