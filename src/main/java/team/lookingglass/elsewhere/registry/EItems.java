package team.lookingglass.elsewhere.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.material.Fluids;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.registry.equipment.AttributeArmorItem;
import team.lookingglass.elsewhere.registry.equipment.EMaterials;
import team.lookingglass.elsewhere.registry.equipment.ArmorAttributes;
import team.lookingglass.elsewhere.registry.trim.ETrimMaterials;

import java.util.List;
import java.util.function.Function;

public interface EItems {

    Item POPLAR_SIGN = register("poplar_sign",
            p -> new SignItem(EBlocks.POPLAR_SIGN, EBlocks.POPLAR_WALL_SIGN, p), new Item.Properties().stacksTo(16));
    Item POPLAR_HANGING_SIGN = register("poplar_hanging_sign",
            p -> new HangingSignItem(EBlocks.POPLAR_HANGING_SIGN, EBlocks.POPLAR_WALL_HANGING_SIGN, p), new Item.Properties().stacksTo(16));
    Item POPLAR_BOAT = register("poplar_boat",
            p -> new BoatItem(EEntities.POPLAR_BOAT, p), new Item.Properties().stacksTo(1));
    Item POPLAR_CHEST_BOAT = register("poplar_chest_boat",
            p -> new BoatItem(EEntities.POPLAR_CHEST_BOAT, p), new Item.Properties().stacksTo(1));

    Item AZALEA_SIGN = register("azalea_sign",
            p -> new SignItem(EBlocks.AZALEA_SIGN, EBlocks.AZALEA_WALL_SIGN, p), new Item.Properties().stacksTo(16));
    Item AZALEA_HANGING_SIGN = register("azalea_hanging_sign",
            p -> new HangingSignItem(EBlocks.AZALEA_HANGING_SIGN, EBlocks.AZALEA_WALL_HANGING_SIGN, p), new Item.Properties().stacksTo(16));
    Item AZALEA_BOAT = register("azalea_boat",
            p -> new BoatItem(EEntities.AZALEA_BOAT, p), new Item.Properties().stacksTo(1));
    Item AZALEA_CHEST_BOAT = register("azalea_chest_boat",
            p -> new BoatItem(EEntities.AZALEA_CHEST_BOAT, p), new Item.Properties().stacksTo(1));

    Item CEDAR_SIGN = register("cedar_sign",
            p -> new SignItem(EBlocks.CEDAR_SIGN, EBlocks.CEDAR_WALL_SIGN, p), new Item.Properties().stacksTo(16));
    Item CEDAR_HANGING_SIGN = register("cedar_hanging_sign",
            p -> new HangingSignItem(EBlocks.CEDAR_HANGING_SIGN, EBlocks.CEDAR_WALL_HANGING_SIGN, p), new Item.Properties().stacksTo(16));
    Item CEDAR_BOAT = register("cedar_boat",
            p -> new BoatItem(EEntities.CEDAR_BOAT, p), new Item.Properties().stacksTo(1));
    Item CEDAR_CHEST_BOAT = register("cedar_chest_boat",
            p -> new BoatItem(EEntities.CEDAR_CHEST_BOAT, p), new Item.Properties().stacksTo(1));

    Item MAHOGANY_SIGN = register("mahogany_sign",
            p -> new SignItem(EBlocks.MAHOGANY_SIGN, EBlocks.MAHOGANY_WALL_SIGN, p), new Item.Properties().stacksTo(16));
    Item MAHOGANY_HANGING_SIGN = register("mahogany_hanging_sign",
            p -> new HangingSignItem(EBlocks.MAHOGANY_HANGING_SIGN, EBlocks.MAHOGANY_WALL_HANGING_SIGN, p), new Item.Properties().stacksTo(16));
    Item MAHOGANY_BOAT = register("mahogany_boat",
            p -> new BoatItem(EEntities.MAHOGANY_BOAT, p), new Item.Properties().stacksTo(1));
    Item MAHOGANY_CHEST_BOAT = register("mahogany_chest_boat",
            p -> new BoatItem(EEntities.MAHOGANY_CHEST_BOAT, p), new Item.Properties().stacksTo(1));

    Item DIAMOND_NUGGET = register("diamond_nugget", Item::new, new Item.Properties());
    Item EMERALD_NUGGET = register("emerald_nugget", Item::new, new Item.Properties());

    Item RAW_TIN = register("raw_tin", Item::new, new Item.Properties());
    Item TIN_INGOT = register("tin_ingot", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.TIN));
    Item TIN_NUGGET = register("tin_nugget", Item::new, new Item.Properties());

    Item BRONZE_MIX = register("bronze_mix", Item::new, new Item.Properties());
    Item BRONZE_INGOT = register("bronze_ingot", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.BRONZE));
    Item BRONZE_NUGGET = register("bronze_nugget", Item::new, new Item.Properties());
    Item BRONZE_HELMET = register("bronze_helmet", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.HELMET)
    );
    Item BRONZE_CHESTPLATE = register("bronze_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.CHESTPLATE)
    );
    Item BRONZE_LEGGINGS = register("bronze_leggings", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.LEGGINGS)
    );
    Item BRONZE_BOOTS = register("bronze_boots", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.BRONZE_ARMOR, ArmorType.BOOTS)
    );
    Item BRONZE_SWORD = register("bronze_sword", Item::new, new Item.Properties()
            .sword(EMaterials.BRONZE_TOOL, 3.0F, -2.4F)
    );
    Item BRONZE_AXE = register("bronze_axe", Item::new, new Item.Properties()
            .axe(EMaterials.BRONZE_TOOL, 7.0F, -3.1F)
    );
    Item BRONZE_SPEAR = register("bronze_spear", Item::new, new Item.Properties()
            .spear(EMaterials.BRONZE_TOOL,
                    0.9F, 0.87F, 0.65F,
                    3.3F, 11.5F,
                    7.5F, 5.1F,
                    11.9F, 4.6F
            ));
    Item BRONZE_PICKAXE = register("bronze_pickaxe", Item::new, new Item.Properties()
            .pickaxe(EMaterials.BRONZE_TOOL, 1.0F, -2.8F)
    );
    Item BRONZE_SHOVEL = register("bronze_shovel", Item::new, new Item.Properties()
            .shovel(EMaterials.BRONZE_TOOL, 1.5F, -3.0F)
    );
    Item BRONZE_HOE = register("bronze_hoe", Item::new, new Item.Properties()
            .hoe(EMaterials.BRONZE_TOOL, -1.0F, -1.0F)
    );

    Item RAW_SILVER = register("raw_silver", Item::new, new Item.Properties());
    Item SILVER_INGOT = register("silver_ingot", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.SILVER));
    Item SILVER_NUGGET = register("silver_nugget", Item::new, new Item.Properties());

    Item NETHERITE_MIX = register("netherite_mix", Item::new, new Item.Properties().fireResistant());
    Item SOULSTEEL_MIX = register("soulsteel_mix", Item::new, new Item.Properties().fireResistant());

    Item SOULSTEEL_INGOT = register("soulsteel_ingot", Item::new, new Item.Properties().fireResistant().trimMaterial(ETrimMaterials.SOULSTEEL));
    Item SOULSTEEL_HELMET = register("soulsteel_helmet", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
            EMaterials.SOULSTEEL_ARMOR, ArmorType.HELMET, EquipmentSlotGroup.HEAD,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_HELMET_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE).fireResistant()
    );
    Item SOULSTEEL_CHESTPLATE = register("soulsteel_chestplate", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
            EMaterials.SOULSTEEL_ARMOR, ArmorType.CHESTPLATE, EquipmentSlotGroup.CHEST,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_CHESTPLATE_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE).fireResistant()
    );
    Item SOULSTEEL_LEGGINGS = register("soulsteel_leggings", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
                    EMaterials.SOULSTEEL_ARMOR, ArmorType.LEGGINGS, EquipmentSlotGroup.LEGS,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_LEGGINGS_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE).fireResistant()
    );
    Item SOULSTEEL_BOOTS = register("soulsteel_boots", AttributeArmorItem::new, AttributeArmorItem.createArmorProperties(
                    EMaterials.SOULSTEEL_ARMOR, ArmorType.BOOTS, EquipmentSlotGroup.FEET,
            Attributes.MAX_HEALTH, ArmorAttributes.SOULSTEEL_BOOTS_HEALTH_ID, 2, AttributeModifier.Operation.ADD_VALUE).fireResistant()
    );
    Item SOULSTEEL_SWORD = register("soulsteel_sword", Item::new, new Item.Properties().fireResistant()
            .sword(EMaterials.SOULSTEEL_TOOL, 3.0F, -2.4F)
    );
    Item SOULSTEEL_AXE = register("soulsteel_axe", Item::new, new Item.Properties().fireResistant()
            .axe(EMaterials.SOULSTEEL_TOOL, 5.0F, -3.0F)
    );
    Item SOULSTEEL_SPEAR = register("soulsteel_spear", Item::new, new Item.Properties().fireResistant()
            .spear(EMaterials.SOULSTEEL_TOOL,
                    1.10F, 1.14F, 0.45F,
                    2.6F, 9.5F, 6.0F,
                    5.1F, 9.4F, 4.6F
            ));
    Item SOULSTEEL_PICKAXE = register("soulsteel_pickaxe", Item::new, new Item.Properties().fireResistant()
            .pickaxe(EMaterials.SOULSTEEL_TOOL, 1.0F, -2.8F)
    );
    Item SOULSTEEL_SHOVEL = register("soulsteel_shovel", Item::new, new Item.Properties().fireResistant()
            .shovel(EMaterials.SOULSTEEL_TOOL, 1.5F, -3.0F)
    );
    Item SOULSTEEL_HOE = register("soulsteel_hoe", Item::new, new Item.Properties().fireResistant()
            .hoe(EMaterials.SOULSTEEL_TOOL, -4.0F, 0.0F)
    );

    Item FROSTBITE_SPAWN_EGG = register("frostbite_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.FROSTBITE));
    Item WEREWOLF_SPAWN_EGG = register("werewolf_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.WEREWOLF));
    Item VANGUARD_SPAWN_EGG = register("vanguard_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.VANGUARD));
    Item SULFUR_CUBE_SPAWN_EGG = register("sulfur_cube_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.SULFUR_CUBE));

    Item VANGUARD_MASK = register("vanguard_mask", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.VANGUARD_MASK, ArmorType.HELMET)
    );

    Item PERCH_SPAWN_EGG = register("perch_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.PERCH));

    Item RAW_PERCH = register("raw_perch", Item::new, new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.25F).build()));
    Item COOKED_PERCH = register("cooked_perch", Item::new, new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.75F).build()));
    Item SHINING_PERCH = register("shining_perch", Item::new, new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.25F).alwaysEdible().build(), Consumables.defaultFood()
                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 45 * 20,1), 1.0F))
                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 90 * 20,0), 1.0F))
                    .build()));

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