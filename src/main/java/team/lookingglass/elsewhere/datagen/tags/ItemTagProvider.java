package team.lookingglass.elsewhere.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.tags.EItemTags;
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

        // Wood
        valueLookupBuilder(EItemTags.POPLAR_LOGS).add(
                EBlocks.POPLAR_LOG.asItem(), EBlocks.STRIPPED_POPLAR_LOG.asItem(),
                EBlocks.POPLAR_WOOD.asItem(), EBlocks.STRIPPED_POPLAR_WOOD.asItem()
        );
        valueLookupBuilder(EItemTags.AZALEA_LOGS).add(
                EBlocks.AZALEA_LOG.asItem(), EBlocks.STRIPPED_AZALEA_LOG.asItem(),
                EBlocks.AZALEA_WOOD.asItem(), EBlocks.STRIPPED_AZALEA_WOOD.asItem()
        );
        valueLookupBuilder(ItemTags.LOGS).add(
                EBlocks.POPLAR_LOG.asItem(), EBlocks.STRIPPED_POPLAR_LOG.asItem(),
                EBlocks.POPLAR_WOOD.asItem(), EBlocks.STRIPPED_POPLAR_WOOD.asItem(),
                EBlocks.AZALEA_LOG.asItem(), EBlocks.STRIPPED_AZALEA_LOG.asItem(),
                EBlocks.AZALEA_WOOD.asItem(), EBlocks.STRIPPED_AZALEA_WOOD.asItem()
        );
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN).add(
                EBlocks.POPLAR_LOG.asItem(), EBlocks.STRIPPED_POPLAR_LOG.asItem(),
                EBlocks.POPLAR_WOOD.asItem(), EBlocks.STRIPPED_POPLAR_WOOD.asItem(),
                EBlocks.AZALEA_LOG.asItem(), EBlocks.STRIPPED_AZALEA_LOG.asItem(),
                EBlocks.AZALEA_WOOD.asItem(), EBlocks.STRIPPED_AZALEA_WOOD.asItem()
        );
        valueLookupBuilder(ItemTags.PLANKS).add(EBlocks.POPLAR_PLANKS.asItem(), EBlocks.AZALEA_PLANKS.asItem());
        valueLookupBuilder(ItemTags.WOODEN_STAIRS).add(EBlocks.POPLAR_STAIRS.asItem(), EBlocks.AZALEA_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WOODEN_SLABS).add(EBlocks.POPLAR_SLAB.asItem(), EBlocks.AZALEA_SLAB.asItem());
        valueLookupBuilder(ItemTags.WOODEN_FENCES).add(EBlocks.POPLAR_FENCE.asItem(), EBlocks.AZALEA_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES).add(EBlocks.POPLAR_FENCE_GATE.asItem(), EBlocks.AZALEA_FENCE_GATE.asItem());
        valueLookupBuilder(ItemTags.WOODEN_DOORS).add(EBlocks.POPLAR_DOOR.asItem(), EBlocks.AZALEA_DOOR.asItem());
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(EBlocks.POPLAR_TRAPDOOR.asItem(), EBlocks.AZALEA_TRAPDOOR.asItem());
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(EBlocks.POPLAR_PRESSURE_PLATE.asItem(), EBlocks.AZALEA_PRESSURE_PLATE.asItem());
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS).add(EBlocks.POPLAR_BUTTON.asItem(), EBlocks.AZALEA_BUTTON.asItem());
        valueLookupBuilder(ItemTags.SIGNS).add(EBlocks.POPLAR_SIGN.asItem(), EBlocks.AZALEA_SIGN.asItem());
        valueLookupBuilder(ItemTags.HANGING_SIGNS).add(EBlocks.POPLAR_HANGING_SIGN.asItem(), EBlocks.AZALEA_HANGING_SIGN.asItem());
        valueLookupBuilder(ItemTags.BOATS).add(EItems.POPLAR_BOAT, EItems.AZALEA_BOAT);

        // Sand
        valueLookupBuilder(ItemTags.SAND).add(EBlocks.PINK_SAND.asItem());

        // Stone
        valueLookupBuilder(ItemTags.STONE_CRAFTING_MATERIALS).add(EBlocks.COBBLESHALE.asItem());
        valueLookupBuilder(ItemTags.STONE_TOOL_MATERIALS).add(EBlocks.COBBLESHALE.asItem());

        // Bronze
        valueLookupBuilder(EItemTags.BRONZE_TOOLS).add(
                EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR,
                EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_HOE
        );
        valueLookupBuilder(EItemTags.BRONZE_EQUIPMENT).add(
                EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS
        );
        valueLookupBuilder(EItemTags.COPPER_MATERIALS).add(Items.RAW_COPPER).add(Items.COPPER_INGOT);
        valueLookupBuilder(EItemTags.TIN_MATERIALS).add(EItems.RAW_TIN).add(EItems.TIN_INGOT);

        // Soulsteel
        valueLookupBuilder(EItemTags.SOULSTEEL_TOOLS).add(
                EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR,
                EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_HOE
        );
        valueLookupBuilder(EItemTags.SOULSTEEL_EQUIPMENT).add(
                EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
        );

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


        // Trim Tags
        valueLookupBuilder(ItemTags.TRIM_MATERIALS).add(
                EItems.TIN_INGOT, EItems.BRONZE_INGOT, EItems.SILVER_INGOT, EItems.SOULSTEEL_INGOT
        );
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(
                EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,
                EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
        );

















    }

}