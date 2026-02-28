package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.registry.tiers.SylverTier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Function;

public interface EItems {


    // Sylver Items
     Item RAW_SYLVER = register("raw_sylver", Item::new, new Item.Properties());
     Item SYLVER_INGOT = register("sylver_ingot", Item::new, new Item.Properties());
     Item SYLVER_NUGGET = register("sylver_nugget", Item::new, new Item.Properties());
     Item SYLVER_SWORD = register("sylver_sword", Item::new,
            new Item.Properties().sword(
                    SylverTier.SYLVER_TOOL_MATERIAL, 3.0F, -2.4F
            )
    );
     Item SYLVER_AXE = register("sylver_axe", Item::new,
            new Item.Properties().axe(
                    SylverTier.SYLVER_TOOL_MATERIAL, 1.5F, -3.0F
            )
    );
     Item SYLVER_SPEAR = register("sylver_spear", Item::new,
            new Item.Properties().spear(
                    SylverTier.SYLVER_TOOL_MATERIAL,
                    0.85F, 0.82F, 0.65F, 4.0F, 9.0F, 8.25F, 5.1F, 12.5F, 4.6F
            )
    );
     Item SYLVER_PICKAXE = register("sylver_pickaxe", Item::new,
            new Item.Properties().pickaxe(
                    SylverTier.SYLVER_TOOL_MATERIAL, 1.0F, -2.8F
            )
    );
     Item SYLVER_SHOVEL = register("sylver_shovel", Item::new,
            new Item.Properties().shovel(
                    SylverTier.SYLVER_TOOL_MATERIAL, 5.0F, -3.0F
            )
    );
     Item SYLVER_HOE = register("sylver_hoe", Item::new,
            new Item.Properties().hoe(
                    SylverTier.SYLVER_TOOL_MATERIAL, -3.0F, 0.0F
            )
    );
     Item SYLVER_HELMET = register("sylver_helmet", Item::new,
            new Item.Properties().humanoidArmor(SylverTier.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(SylverTier.BASE_DURABILITY))
    );
     Item SYLVER_CHESTPLATE = register("sylver_chestplate", Item::new,
            new Item.Properties().humanoidArmor(SylverTier.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(SylverTier.BASE_DURABILITY))
    );
     Item SYLVER_LEGGINGS = register("sylver_leggings", Item::new,
            new Item.Properties().humanoidArmor(SylverTier.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(SylverTier.BASE_DURABILITY))
    );
     Item SYLVER_BOOTS = register("sylver_boots", Item::new,
            new Item.Properties().humanoidArmor(SylverTier.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(SylverTier.BASE_DURABILITY))
    );






    // Method
    static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));

        // Create the item instance
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    private static Item registerSign(final String name, Block signBlock, Block wallSignBlock) {
        return register(name, p -> new SignItem(signBlock, wallSignBlock, p), new Item.Properties());
    }

    private static Item registerHangingSign(final String name, Block hangingSignBlock, Block wallHangingSignBlock) {
        return register(name, p -> new SignItem(hangingSignBlock, wallHangingSignBlock, p), new Item.Properties());
    }

    // Initialize
    static void initialize() {}
}
