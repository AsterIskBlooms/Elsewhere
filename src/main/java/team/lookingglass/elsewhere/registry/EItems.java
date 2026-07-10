package team.lookingglass.elsewhere.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.material.Fluids;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.registry.equipment.AttributeArmorItem;
import team.lookingglass.elsewhere.registry.equipment.EMaterials;
import team.lookingglass.elsewhere.registry.uuid.ArmorAttributes;

import java.util.function.Function;

public interface EItems {

    Item DIAMOND_SHARD = register("diamond_shard", Item::new, new Item.Properties());
    Item EMERALD_SHARD = register("emerald_shard", Item::new, new Item.Properties());

    Item RAW_TIN = register("raw_tin", Item::new, new Item.Properties());
    Item TIN_INGOT = register("tin_ingot", Item::new, new Item.Properties());
    Item TIN_NUGGET = register("tin_nugget", Item::new, new Item.Properties());

    Item BRONZE_INGOT = register("bronze_ingot", Item::new, new Item.Properties());
    Item BRONZE_NUGGET = register("bronze_nugget", Item::new, new Item.Properties());
    Item BRONZE_HELMET = register("bronze_helmet", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(EMaterials.BRONZE_DURABILITY))
    );
    Item BRONZE_CHESTPLATE = register("bronze_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(EMaterials.BRONZE_DURABILITY))
    );
    Item BRONZE_LEGGINGS = register("bronze_leggings", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(EMaterials.BRONZE_DURABILITY))
    );
    Item BRONZE_BOOTS = register("bronze_boots", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(EMaterials.BRONZE_DURABILITY))
    );
    Item BRONZE_SWORD = register("bronze_sword", Item::new, new Item.Properties()
            .sword(EMaterials.BRONZE_TOOL, 3.0F, -2.4F)
    );
    Item BRONZE_AXE = register("bronze_axe", Item::new, new Item.Properties()
            .axe(EMaterials.BRONZE_TOOL, 7.0F, -3.0F)
    );
    Item BRONZE_SPEAR = register("bronze_spear", Item::new, new Item.Properties()
            .spear(EMaterials.BRONZE_TOOL,
                    1.05F, 1.075F, 0.5F, 3.0F, 10.0F, 6.5F, 5.1F, 10.0F, 4.6F)
    );
    Item BRONZE_PICKAXE = register("bronze_pickaxe", Item::new, new Item.Properties()
            .pickaxe(EMaterials.BRONZE_TOOL, 1.0F, -2.8F)
    );
    Item BRONZE_SHOVEL = register("bronze_shovel", Item::new, new Item.Properties()
            .shovel(EMaterials.BRONZE_TOOL, 1.5F, -3.0F)
    );
    Item BRONZE_HOE = register("bronze_hoe", Item::new, new Item.Properties()
            .hoe(EMaterials.BRONZE_TOOL, -3.0F, 0.0F)
    );

    Item RAW_SILVER = register("raw_silver", Item::new, new Item.Properties());
    Item SILVER_INGOT = register("silver_ingot", Item::new, new Item.Properties());
    Item SILVER_NUGGET = register("silver_nugget", Item::new, new Item.Properties());

    Item SOULSTEEL_INGOT = register("soulsteel_ingot", Item::new, new Item.Properties());
    Item SOULSTEEL_NUGGET = register("soulsteel_nugget", Item::new, new Item.Properties()
    );
    Item SOULSTEEL_HELMET = register("soulsteel_helmet", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
            EMaterials.SOULSTEEL_ARMOR, ArmorType.HELMET, EquipmentSlotGroup.HEAD,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_HELMET_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE)
    );
    Item SOULSTEEL_CHESTPLATE = register("soulsteel_chestplate", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
            EMaterials.SOULSTEEL_ARMOR, ArmorType.CHESTPLATE, EquipmentSlotGroup.CHEST,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_CHESTPLATE_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE)
    );
    Item SOULSTEEL_LEGGINGS = register("soulsteel_leggings", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
                    EMaterials.SOULSTEEL_ARMOR, ArmorType.LEGGINGS, EquipmentSlotGroup.LEGS,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_LEGGINGS_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE)
    );
    Item SOULSTEEL_BOOTS = register("soulsteel_boots", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
                    EMaterials.SOULSTEEL_ARMOR, ArmorType.BOOTS, EquipmentSlotGroup.FEET,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_BOOTS_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE)
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

    Item FROSTBITE_SPAWN_EGG = register("frostbite_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.FROSTBITE));
    Item PERCH_SPAWN_EGG = register("perch_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.PERCH));

    Item RAW_PERCH = register("raw_perch", Item::new, new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5F).build()));
    Item COOKED_PERCH = register("cooked_perch", Item::new, new Item.Properties().food((new FoodProperties.Builder()).nutrition(5).saturationModifier(8.8F).build()));

    Item PERCH_BUCKET = register("perch_bucket", p -> new MobBucketItem(EEntities.PERCH, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, p), new Item.Properties());


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