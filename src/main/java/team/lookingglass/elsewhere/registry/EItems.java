package team.lookingglass.elsewhere.registry;

import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public interface EItems {


    Item RAW_SILVER = register("raw_silver", Item::new, new Item.Properties()
    );
    Item SILVER_INGOT = register("silver_ingot", Item::new, new Item.Properties()
    );
    Item SILVER_NUGGET = register("silver_nugget", Item::new, new Item.Properties()
    );
    Item SILVER_HELMET = register("silver_helmet", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SILVER_ARMOR, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(EMaterials.SILVER_DURABILITY))
    );
    Item SILVER_CHESTPLATE = register("silver_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SILVER_ARMOR, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(EMaterials.SILVER_DURABILITY))
    );
    Item SILVER_LEGGINGS = register("silver_leggings", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SILVER_ARMOR, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(EMaterials.SILVER_DURABILITY))
    );
    Item SILVER_BOOTS = register("silver_boots", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SILVER_ARMOR, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(EMaterials.SILVER_DURABILITY))
    );
    Item SILVER_SWORD = register("silver_sword", Item::new, new Item.Properties()
            .sword(EMaterials.SILVER_TOOL, 3.0F, -2.4F)
    );
    Item SILVER_AXE = register("silver_axe", Item::new, new Item.Properties()
            .axe(EMaterials.SILVER_TOOL, 5.0F, -3.0F)
    );
    Item SILVER_SPEAR = register("silver_spear", Item::new, new Item.Properties()
            .spear(EMaterials.SILVER_TOOL,
                    1.05F, 1.075F, 0.5F, 3.0F, 10.0F, 6.5F, 5.1F, 10.0F, 4.6F)
    );
    Item SILVER_PICKAXE = register("silver_pickaxe", Item::new, new Item.Properties()
            .pickaxe(EMaterials.SILVER_TOOL, 1.0F, -2.8F)
    );
    Item SILVER_SHOVEL = register("silver_shovel", Item::new, new Item.Properties()
            .shovel(EMaterials.SILVER_TOOL, 1.5F, -3.0F)
    );
    Item SILVER_HOE = register("silver_hoe", Item::new, new Item.Properties()
            .hoe(EMaterials.SILVER_TOOL, -3.0F, 0.0F)
    );



    Item SOULSTEEL_INGOT = register("soulsteel_ingot", Item::new, new Item.Properties()
    );
    Item SOULSTEEL_NUGGET = register("soulsteel_nugget", Item::new, new Item.Properties()
    );
    Item SOULSTEEL_HELMET = register("soulsteel_helmet", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(EMaterials.SOULSTEEL_DURABILITY))
    );
    Item SOULSTEEL_CHESTPLATE = register("soulsteel_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(EMaterials.SOULSTEEL_DURABILITY))
    );
    Item SOULSTEEL_LEGGINGS = register("soulsteel_leggings", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(EMaterials.SOULSTEEL_DURABILITY))
    );
    Item SOULSTEEL_BOOTS = register("soulsteel_boots", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(EMaterials.SOULSTEEL_DURABILITY))
    );
    Item SOULSTEEL_SWORD = register("soulsteel_sword", Item::new, new Item.Properties()
            .sword(EMaterials.SOULSTEEL_TOOL, 3.0F, -2.4F)
    );
    Item SOULSTEEL_AXE = register("soulsteel_axe", Item::new, new Item.Properties()
            .axe(EMaterials.SOULSTEEL_TOOL, 5.0F, -3.0F)
    );
    Item SOULSTEEL_SPEAR = register("soulsteel_spear", Item::new, new Item.Properties()
            .spear(EMaterials.SOULSTEEL_TOOL,
                    1.15F, 1.2F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)
    );
    Item SOULSTEEL_PICKAXE = register("soulsteel_pickaxe", Item::new, new Item.Properties()
            .pickaxe(EMaterials.SOULSTEEL_TOOL, 1.0F, -2.8F)
    );
    Item SOULSTEEL_SHOVEL = register("soulsteel_shovel", Item::new, new Item.Properties()
            .shovel(EMaterials.SOULSTEEL_TOOL, 1.5F, -3.0F)
    );
    Item SOULSTEEL_HOE = register("soulsteel_hoe", Item::new, new Item.Properties()
            .hoe(EMaterials.SOULSTEEL_TOOL, -3.0F, 0.0F)
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

    // Initialize
    static void initialize() {}
}
