package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EItems;
import net.asterisk.elsewhere.registry.tiers.XyloiteTier;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        // Tool Materials
        valueLookupBuilder(XyloiteTier.REPAIRS_XYLOITE_ARMOR)
                .add(EItems.XYLOITE_INGOT)
                .add(EItems.XYLOITE_NUGGET)
        ;

        // General Tool Tags
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                // Xyloite
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.XYLOITE_PICKAXE)
                .add(EItems.XYLOITE_SHOVEL)
                .add(EItems.XYLOITE_HOE)
                .add(EItems.XYLOITE_HELMET)
                .add(EItems.XYLOITE_CHESTPLATE)
                .add(EItems.XYLOITE_LEGGINGS)
                .add(EItems.XYLOITE_BOOTS)
                // Sylver
                .add(EItems.SYLVER_SWORD)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_SPEAR)
                .add(EItems.SYLVER_PICKAXE)
                .add(EItems.SYLVER_SHOVEL)
                .add(EItems.SYLVER_HOE)
                .add(EItems.SYLVER_HELMET)
                .add(EItems.SYLVER_CHESTPLATE)
                .add(EItems.SYLVER_LEGGINGS)
                .add(EItems.SYLVER_BOOTS)
        ;

        // Weapon Tags
        valueLookupBuilder(ItemTags.MELEE_WEAPON_ENCHANTABLE)
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.SYLVER_SWORD)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_SPEAR)
        ;
        valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.SYLVER_SWORD)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_SPEAR)
        ;
        valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.SYLVER_SWORD)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_SPEAR)
        ;

        // Specific Tool Tags
        valueLookupBuilder(ItemTags.SWEEPING_ENCHANTABLE)
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.SYLVER_SWORD)
        ;
        valueLookupBuilder(ItemTags.LUNGE_ENCHANTABLE)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.SYLVER_SPEAR)
        ;
        valueLookupBuilder(ItemTags.SWORDS)
                .add(EItems.XYLOITE_SWORD)
                .add(EItems.SYLVER_SWORD)
        ;
        valueLookupBuilder(ItemTags.AXES)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.SYLVER_AXE)
        ;
        valueLookupBuilder(ItemTags.SPEARS)
                .add(EItems.XYLOITE_SPEAR)
                .add(EItems.SYLVER_SPEAR)
        ;
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(EItems.XYLOITE_PICKAXE)
                .add(EItems.SYLVER_PICKAXE)
        ;
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(EItems.XYLOITE_SHOVEL)
                .add(EItems.SYLVER_SHOVEL)
        ;
        valueLookupBuilder(ItemTags.HOES)
                .add(EItems.XYLOITE_HOE)
                .add(EItems.SYLVER_HOE)
        ;

        // Mining Tool Tags
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_PICKAXE)
                .add(EItems.XYLOITE_SHOVEL)
                .add(EItems.XYLOITE_HOE)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_PICKAXE)
                .add(EItems.SYLVER_SHOVEL)
                .add(EItems.SYLVER_HOE)
        ;
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_PICKAXE)
                .add(EItems.XYLOITE_SHOVEL)
                .add(EItems.XYLOITE_HOE)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_PICKAXE)
                .add(EItems.SYLVER_SHOVEL)
                .add(EItems.SYLVER_HOE)
        ;
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(EItems.XYLOITE_AXE)
                .add(EItems.XYLOITE_PICKAXE)
                .add(EItems.XYLOITE_SHOVEL)
                .add(EItems.XYLOITE_HOE)
                .add(EItems.SYLVER_AXE)
                .add(EItems.SYLVER_PICKAXE)
                .add(EItems.SYLVER_SHOVEL)
                .add(EItems.SYLVER_HOE)
        ;

        // Armor-specific Tags
        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(EItems.XYLOITE_HELMET)
                .add(EItems.XYLOITE_CHESTPLATE)
                .add(EItems.XYLOITE_LEGGINGS)
                .add(EItems.XYLOITE_BOOTS)
                .add(EItems.SYLVER_HELMET)
                .add(EItems.SYLVER_CHESTPLATE)
                .add(EItems.SYLVER_LEGGINGS)
                .add(EItems.SYLVER_BOOTS)
        ;
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(EItems.XYLOITE_HELMET)
                .add(EItems.SYLVER_HELMET)
        ;
        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(EItems.XYLOITE_HELMET)
                .add(EItems.SYLVER_HELMET)
        ;
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(EItems.XYLOITE_CHESTPLATE)
                .add(EItems.SYLVER_CHESTPLATE)
        ;
        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(EItems.XYLOITE_CHESTPLATE)
                .add(EItems.SYLVER_CHESTPLATE)
        ;
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(EItems.XYLOITE_LEGGINGS)
                .add(EItems.SYLVER_LEGGINGS)
        ;
        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(EItems.XYLOITE_LEGGINGS)
                .add(EItems.SYLVER_LEGGINGS)
        ;
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(EItems.XYLOITE_BOOTS)
                .add(EItems.SYLVER_BOOTS)
        ;
        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(EItems.XYLOITE_BOOTS)
                .add(EItems.SYLVER_BOOTS)
        ;


















    }

}