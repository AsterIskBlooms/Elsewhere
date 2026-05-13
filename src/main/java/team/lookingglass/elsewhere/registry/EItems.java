package team.lookingglass.elsewhere.registry;

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
