package net.asterisk.elsewhere.mesa.enchanting;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;

public final class NEScroll {

    private final List<ResourceKey<Enchantment>> enchantmentsToUnlock;
    private final NEType tier;
    private final int pixieDustCost;
    private final TagKey<Item> compatibleItems;

    public NEScroll(
            String scrollName,
            Identifier scrollTexture,
            List<ResourceKey<Enchantment>> enchantmentsToUnlock,
            NEType tier,
            int pixieDustCost,
            TagKey<Item> compatibleItems
    ) {
        this.enchantmentsToUnlock = enchantmentsToUnlock;
        this.tier = tier;
        this.pixieDustCost = pixieDustCost;
        this.compatibleItems = compatibleItems;
    }

    public List<ResourceKey<Enchantment>> getUnlockingEnchantments() {
        return enchantmentsToUnlock;
    }

    public NEType getTier() {
        return tier;
    }

    public int getPixieDustCost() {
        return pixieDustCost;
    }

    public boolean isCompatible(ItemStack stack) {
        return stack.is(compatibleItems);
    }
}
