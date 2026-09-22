package team.lookingglass.elsewhere.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.material.Fluids;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.registry.equipment.*;
import team.lookingglass.elsewhere.registry.equipment.items.ConfigurableShieldItem;
import team.lookingglass.elsewhere.registry.equipment.items.SoulsteelAxeItem;
import team.lookingglass.elsewhere.registry.equipment.items.SoulsteelItem;
import team.lookingglass.elsewhere.registry.sets.EDiscs;

import java.util.List;
import java.util.Optional;
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

    Item BRONZE_ALLOY = register("bronze_alloy", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.BRONZE));
    Item BRONZE_UPGRADE_SMITHING_TEMPLATE = register("bronze_upgrade_smithing_template", p -> new SmithingTemplateItem(
            Component.translatable("item.elsewhere.smithing_template.bronze_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.elsewhere.smithing_template.bronze_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.elsewhere.smithing_template.bronze_upgrade.base_slot_description"),
            Component.translatable("item.elsewhere.smithing_template.bronze_upgrade.additions_slot_description"),
            SmithingTemplateItem.createNetheriteUpgradeIconList(), SmithingTemplateItem.createNetheriteUpgradeMaterialList(), p),
            new Item.Properties().rarity(Rarity.UNCOMMON)
    );
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
    Item BRONZE_AXE = register("bronze_axe", p -> new AxeItem(
            EMaterials.BRONZE_TOOL, 5.0F, -3.0F, p), new Item.Properties()
    );
    Item BRONZE_SPEAR = register("bronze_spear", Item::new, new Item.Properties()
            .spear(EMaterials.BRONZE_TOOL,
                    1.0F, 1.013F, 0.6F,
                    2.8F, 10.5F,
                    6.63F, 5.1F,
                    10.63F, 4.6F
            ));
    Item BRONZE_PICKAXE = register("bronze_pickaxe", Item::new, new Item.Properties()
            .pickaxe(EMaterials.BRONZE_TOOL, 1.0F, -2.8F)
    );
    Item BRONZE_SHOVEL = register("bronze_shovel", p -> new ShovelItem(
            EMaterials.BRONZE_TOOL, 1.5F, -3.0F, p), new Item.Properties()
    );
    Item BRONZE_HOE = register("bronze_hoe", p -> new HoeItem(
            EMaterials.BRONZE_TOOL, -2.5F, -1.0F, p), new Item.Properties()
    );

    Item RAW_SILVER = register("raw_silver", Item::new, new Item.Properties());
    Item SILVER_INGOT = register("silver_ingot", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.SILVER));
    Item SILVER_NUGGET = register("silver_nugget", Item::new, new Item.Properties());

    Item SOULSTEEL_ALLOY = register("soulsteel_alloy", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.SOULSTEEL));
    Item SOULSTEEL_UPGRADE_SMITHING_TEMPLATE = register("soulsteel_upgrade_smithing_template", p -> new SmithingTemplateItem(
                    Component.translatable("item.elsewhere.smithing_template.soulsteel_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.elsewhere.smithing_template.soulsteel_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.elsewhere.smithing_template.soulsteel_upgrade.base_slot_description"),
                    Component.translatable("item.elsewhere.smithing_template.soulsteel_upgrade.additions_slot_description"),
                    SmithingTemplateItem.createNetheriteUpgradeIconList(), SmithingTemplateItem.createNetheriteUpgradeMaterialList(), p),
            new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    Item SOULSTEEL_HELMET = register("soulsteel_helmet", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.HELMET)
    );
    Item SOULSTEEL_CHESTPLATE = register("soulsteel_chestplate", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.CHESTPLATE)
    );
    Item SOULSTEEL_LEGGINGS = register("soulsteel_leggings", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.LEGGINGS)
    );
    Item SOULSTEEL_BOOTS = register("soulsteel_boots", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.SOULSTEEL_ARMOR, ArmorType.BOOTS)
    );
    Item SOULSTEEL_SWORD = register("soulsteel_sword", SoulsteelItem::new, new AttributeProperties()
            .attribute(EAttributes.LIFESTEAL, new AttributeModifier(AttributeIDs.SOULSTEEL_LIFESTEAL_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
            .sword(EMaterials.SOULSTEEL_TOOL, 3.0F, -2.4F)
    );
    Item SOULSTEEL_AXE = register("soulsteel_axe", p -> new SoulsteelAxeItem(
            EMaterials.SOULSTEEL_TOOL, 5.0F, -3.0F, p), new AttributeProperties()
            .attribute(EAttributes.LIFESTEAL, new AttributeModifier(AttributeIDs.SOULSTEEL_LIFESTEAL_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
            .attribute(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(AttributeIDs.SOULSTEEL_REACH_ID, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
    );
    Item SOULSTEEL_SPEAR = register("soulsteel_spear", SoulsteelItem::new, new AttributeProperties()
            .attribute(EAttributes.LIFESTEAL, new AttributeModifier(AttributeIDs.SOULSTEEL_LIFESTEAL_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
            .spear(EMaterials.SOULSTEEL_TOOL,
                    1.05F, 1.075F, 0.5F,
                    3.0F, 10.0F,
                    6.5F, 5.1F,
                    10.0F, 4.6F
            ));
    Item SOULSTEEL_PICKAXE = register("soulsteel_pickaxe", SoulsteelItem::new, new AttributeProperties()
            .attribute(EAttributes.LIFESTEAL, new AttributeModifier(AttributeIDs.SOULSTEEL_LIFESTEAL_ID, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
            .attribute(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(AttributeIDs.SOULSTEEL_REACH_ID, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
            .pickaxe(EMaterials.SOULSTEEL_TOOL, 1.0F, -2.8F)
    );
    Item SOULSTEEL_SHOVEL = register("soulsteel_shovel", p -> new ShovelItem(
            EMaterials.SOULSTEEL_TOOL, 1.5F, -3.0F, p), new AttributeProperties()
            .attribute(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(AttributeIDs.SOULSTEEL_REACH_ID, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
    );
    Item SOULSTEEL_HOE = register("soulsteel_hoe", p -> new HoeItem(
            EMaterials.SOULSTEEL_TOOL, -3.0F, 0.0F, p), new AttributeProperties()
            .attribute(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(AttributeIDs.SOULSTEEL_REACH_ID, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                    EquipmentSlotGroup.MAINHAND)
    );

    Item ELECTRUM_ALLOY = register("electrum_alloy", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.ELECTRUM));
    Item ELECTRUM_UPGRADE_SMITHING_TEMPLATE = register("electrum_upgrade_smithing_template", p -> new SmithingTemplateItem(
                    Component.translatable("item.elsewhere.smithing_template.electrum_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.elsewhere.smithing_template.electrum_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.elsewhere.smithing_template.electrum_upgrade.base_slot_description"),
                    Component.translatable("item.elsewhere.smithing_template.electrum_upgrade.additions_slot_description"),
                    SmithingTemplateItem.createNetheriteUpgradeIconList(), SmithingTemplateItem.createNetheriteUpgradeMaterialList(), p),
            new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    Item ELECTRUM_HELMET = register("electrum_helmet", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.ELECTRUM_ARMOR, ArmorType.HELMET)
            .attribute(Attributes.MOVEMENT_SPEED, new AttributeModifier(AttributeIDs.ELECTRUM_HELMET_SPEED_ID, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.HEAD)
    );
    Item ELECTRUM_CHESTPLATE = register("electrum_chestplate", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.ELECTRUM_ARMOR, ArmorType.CHESTPLATE)
            .attribute(Attributes.MOVEMENT_SPEED, new AttributeModifier(AttributeIDs.ELECTRUM_CHESTPLATE_SPEED_ID, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.CHEST)
    );
    Item ELECTRUM_LEGGINGS = register("electrum_leggings", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.ELECTRUM_ARMOR, ArmorType.LEGGINGS)
            .attribute(Attributes.MOVEMENT_SPEED, new AttributeModifier(AttributeIDs.ELECTRUM_LEGGINGS_SPEED_ID, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.LEGS)
    );
    Item ELECTRUM_BOOTS = register("electrum_boots", Item::new, new AttributeProperties()
            .humanoidArmor(EMaterials.ELECTRUM_ARMOR, ArmorType.BOOTS)
            .attribute(Attributes.MOVEMENT_SPEED, new AttributeModifier(AttributeIDs.ELECTRUM_BOOTS_SPEED_ID, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    EquipmentSlotGroup.FEET)
    );
    Item ELECTRUM_SWORD = register("electrum_sword", Item::new, new AttributeProperties()
            .sword(EMaterials.ELECTRUM_TOOL, 3.0F, -2.1F)
    );
    Item ELECTRUM_AXE = register("electrum_axe", p -> new AxeItem(
            EMaterials.ELECTRUM_TOOL, 5.0F, -2.9F, p), new AttributeProperties()
    );
    Item ELECTRUM_SPEAR = register("electrum_spear", Item::new, new AttributeProperties()
            .spear(EMaterials.ELECTRUM_TOOL,
                    0.9F, 1.075F, 0.45F,
                    4.0F, 10.0F,
                    7.5F, 5.1F,
                    14.0F, 4.6F
            ));
    Item ELECTRUM_PICKAXE = register("electrum_pickaxe", Item::new, new AttributeProperties()
            .pickaxe(EMaterials.ELECTRUM_TOOL, 1.0F, -2.5F)
    );
    Item ELECTRUM_SHOVEL = register("electrum_shovel", p -> new ShovelItem(
            EMaterials.ELECTRUM_TOOL, 1.5F, -2.0F, p), new AttributeProperties()
    );
    Item ELECTRUM_HOE = register("electrum_hoe", p -> new HoeItem(
            EMaterials.ELECTRUM_TOOL, -3.0F, 1.0F, p), new AttributeProperties()
    );

    Item URANIUM = register("uranium", Item::new, new Item.Properties().trimMaterial(ETrimMaterials.URANIUM));
    Item URANIUM_SHARD = register("uranium_shard", Item::new, new Item.Properties());

    Item REINFORCED_SHIELD = register("reinforced_shield", p -> new ConfigurableShieldItem(p, 70, 160, 15.0F), new Item.Properties()
            .durability(672)
            .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
            .repairable(ItemTags.DIAMOND_TOOL_MATERIALS).equippableUnswappable(EquipmentSlot.OFFHAND)
            .delayedComponent(DataComponents.BLOCKS_ATTACKS, context -> new BlocksAttacks(
                    0.0F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)))
            .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK)
    );

    Item QUICK_SHIELD = register("quick_shield", p -> new ConfigurableShieldItem(p, 15, 50, 8.0F), new Item.Properties()
            .durability(434)
            .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
            .repairable(ItemTags.WOODEN_TOOL_MATERIALS).equippableUnswappable(EquipmentSlot.OFFHAND)
            .delayedComponent(DataComponents.BLOCKS_ATTACKS, (context) -> new BlocksAttacks(
                    0.0F, 1.0F,
                    List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)),
                    new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F),
                    Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)),
                    Optional.of(SoundEvents.SHIELD_BLOCK),
                    Optional.of(SoundEvents.SHIELD_BREAK)))
            .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK)
    );

    Item FROSTBITE_SPAWN_EGG = register("frostbite_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.FROSTBITE));
    Item WEREWOLF_SPAWN_EGG = register("werewolf_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.WEREWOLF));
    Item VANGUARD_SPAWN_EGG = register("vanguard_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.VANGUARD));
    Item SULFUR_CUBE_SPAWN_EGG = register("sulfur_cube_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.SULFUR_CUBE));
    Item SUBSLIME_SPAWN_EGG = register("subslime_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.SUBSLIME));
    Item SWEEPER_SPAWN_EGG = register("sweeper_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.SWEEPER));
    Item MUD_GOLEM_SPAWN_EGG = register("mud_golem_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.MUD_GOLEM));
    Item SOUL_SPAWN_EGG = register("soul_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.SOUL));
    Item TROLL_SPAWN_EGG = register("troll_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(EEntities.TROLL));

    Item VANGUARD_MASK = register("vanguard_mask", Item::new, new Item.Properties()
            .humanoidArmor(EMaterials.VANGUARD_MASK, ArmorType.HELMET)
            .component(DataComponents.ATTRIBUTE_MODIFIERS,
                    ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(
                            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard_mask_night_vision"),
                                            0.0, AttributeModifier.Operation.ADD_VALUE),
                                    EquipmentSlotGroup.HEAD, ItemAttributeModifiers.Display.override(
                                            Component.translatable("item.elsewhere.vanguard_mask.night_vision").withStyle(ChatFormatting.BLUE)))
                            .build()
            )
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



    Item MUSIC_DISC_FOX = register("music_disc_fox", Item::new, new Item.Properties().jukeboxPlayable(EDiscs.FOX).rarity(Rarity.UNCOMMON));

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