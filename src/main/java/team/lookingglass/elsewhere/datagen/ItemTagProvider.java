package team.lookingglass.elsewhere.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EItemTags;
import team.lookingglass.elsewhere.registry.EItems;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }



    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        // Food
        valueLookupBuilder(ItemTags.CAT_FOOD).add(EItems.RAW_PERCH);
        valueLookupBuilder(ItemTags.OCELOT_FOOD).add(EItems.RAW_PERCH);
        valueLookupBuilder(ItemTags.WOLF_FOOD).add(EItems.RAW_PERCH, EItems.COOKED_PERCH);
        valueLookupBuilder(ItemTags.MEAT).add(EItems.RAW_PERCH, EItems.COOKED_PERCH);


        // Repair tags
        valueLookupBuilder(EItemTags.REPAIRS_BRONZE_ARMOR).add(EItems.BRONZE_INGOT);
        valueLookupBuilder(EItemTags.REPAIRS_SILVER_ARMOR).add(EItems.SILVER_INGOT);
        valueLookupBuilder(EItemTags.REPAIRS_SOULSTEEL_ARMOR).add(EItems.SOULSTEEL_INGOT);

        // Tool type tags
        valueLookupBuilder(ItemTags.SWORDS).add(EItems.BRONZE_SWORD, EItems.SOULSTEEL_SWORD);
        valueLookupBuilder(ItemTags.AXES).add(EItems.BRONZE_AXE, EItems.SOULSTEEL_AXE);
        valueLookupBuilder(ItemTags.SPEARS).add(EItems.BRONZE_SPEAR, EItems.SOULSTEEL_SPEAR);
        valueLookupBuilder(ItemTags.PICKAXES).add(EItems.BRONZE_PICKAXE, EItems.SOULSTEEL_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(EItems.BRONZE_SHOVEL, EItems.SOULSTEEL_SHOVEL);
        valueLookupBuilder(ItemTags.HOES).add(EItems.BRONZE_HOE, EItems.SOULSTEEL_HOE);

        // Armor type tags
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(EItems.BRONZE_HELMET, EItems.SOULSTEEL_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(EItems.BRONZE_CHESTPLATE, EItems.SOULSTEEL_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(EItems.BRONZE_LEGGINGS, EItems.SOULSTEEL_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(EItems.BRONZE_BOOTS, EItems.SOULSTEEL_BOOTS);

        // Enchanting tags
        valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR,
                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR
                );
        valueLookupBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(
                        EItems.BRONZE_SWORD, EItems.BRONZE_SPEAR,
                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_SPEAR
                );
        valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR,
                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR
                );
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(
                        EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_AXE, EItems.BRONZE_HOE,
                        EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_HOE
                );
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(
                        EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_AXE, EItems.BRONZE_HOE,
                        EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_HOE
                );
        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
                );
        valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
                );
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR, EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_HOE,
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,
                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR, EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_HOE,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
                );
        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR, EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_HOE,
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,
                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR, EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_HOE,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
                );

















    }

}