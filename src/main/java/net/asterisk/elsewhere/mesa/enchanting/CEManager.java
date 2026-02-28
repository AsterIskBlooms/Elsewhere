package net.asterisk.elsewhere.mesa.enchanting;

import net.asterisk.elsewhere.registry.EEnchantments;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.asterisk.elsewhere.Elsewhere.MODID;

public class CEManager {

    private static final ArrayList<NEScroll> scrolls = new ArrayList<>();

    public static void initialize() {
        scrolls.addAll(Arrays.asList(scrollsList));
    }

    public static ArrayList<NEScroll> getScrolls() {
        return scrolls;
    }

    private static final NEScroll[] scrollsList = new NEScroll[]{
            new NEScroll(
                    "Sharpness Placeholder",
                    Identifier.fromNamespaceAndPath(MODID, "textures/item/scroll_placeholder.png"),
                    createEnchantmentSet(
                            EEnchantments.SHARPNESS
                    ),
                    NEType.MAJOR,
                    1,
                    ItemTags.SWORDS
            ),
            new NEScroll(
                    "Protection Placeholder",
                    Identifier.fromNamespaceAndPath(MODID, "textures/item/scroll_placeholder.png"),
                    createEnchantmentSet(
                            EEnchantments.PROTECTION
                    ),
                    NEType.MAJOR,
                    1,
                    ItemTags.ARMOR_ENCHANTABLE
            )
    };

    @SafeVarargs
    public static List<ResourceKey<Enchantment>> createEnchantmentSet(ResourceKey<Enchantment>... enchantments) {
        return List.of(enchantments);
    }
}