package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.MultiplyValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EEnchantments {
    public static final ResourceKey<Enchantment> SHARPNESS = resourceKey("sharpness");
    public static final ResourceKey<Enchantment> PROTECTION = resourceKey("protection");

    public static void bootstrap(final BootstrapContext<Enchantment> context) {
        HolderGetter<DamageType> damageTypes = context.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> enchantments = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        HolderGetter<EntityType<?>> entityTypes = context.lookup(Registries.ENTITY_TYPE);
        register(
                context,
                SHARPNESS,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        items.getOrThrow(ItemTags.SWORDS),
                                        10,
                                        1,
                                        Enchantment.constantCost(1),
                                        Enchantment.constantCost(1),
                                        0,
                                        EquipmentSlotGroup.MAINHAND
                                )
                        )
                        .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                        .withEffect(EnchantmentEffectComponents.DAMAGE, new MultiplyValue(LevelBasedValue.constant(1.5F)))
        );
        register(
                context,
                PROTECTION,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                        10,
                                        1,
                                        Enchantment.constantCost(1),
                                        Enchantment.constantCost(1),
                                        0,
                                        EquipmentSlotGroup.ARMOR
                                )
                        )
                        .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE))
                        .withEffect(EnchantmentEffectComponents.ARMOR_EFFECTIVENESS, new MultiplyValue(LevelBasedValue.constant(1.1F)))
        );
    }

    public static ResourceKey<Enchantment> resourceKey(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    private static void register(final BootstrapContext<Enchantment> context, final ResourceKey<Enchantment> key, final Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    public static void initialize() {}
}
