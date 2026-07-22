package team.lookingglass.elsewhere.datagen.loot;

import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import team.lookingglass.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import team.lookingglass.elsewhere.registry.EItems;

import java.util.concurrent.CompletableFuture;

public class BlockLootTableProvider extends FabricBlockLootSubProvider {
    public BlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }



    @Override
    public void generate() {
        // Copper & Coal Ore Changes
        add(Blocks.COPPER_ORE, createOreDrop(Blocks.COPPER_ORE, Items.RAW_COPPER));
        add(Blocks.DEEPSLATE_COPPER_ORE, createOreDrop(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER));

        // Shale Ores
        add(EBlocks.SHALE_COAL_ORE, createOreDrop(EBlocks.SHALE_COAL_ORE, Items.COAL));
        add(EBlocks.SHALE_COPPER_ORE, createOreDrop(EBlocks.SHALE_COPPER_ORE, Items.RAW_COPPER));
        add(EBlocks.SHALE_IRON_ORE, createOreDrop(EBlocks.SHALE_IRON_ORE, Items.RAW_IRON));
        add(EBlocks.SHALE_GOLD_ORE, createOreDrop(EBlocks.SHALE_GOLD_ORE, Items.RAW_GOLD));
        add(EBlocks.SHALE_REDSTONE_ORE, createMultipleOreDrops(EBlocks.SHALE_REDSTONE_ORE, Items.REDSTONE, 4.0F, 5.0F));
        add(EBlocks.SHALE_DIAMOND_ORE, createOreDrop(EBlocks.SHALE_DIAMOND_ORE, Items.DIAMOND));
        add(EBlocks.SHALE_LAPIS_ORE, createMultipleOreDrops(EBlocks.SHALE_LAPIS_ORE, Items.LAPIS_LAZULI, 4.0F, 9.0F));
        add(EBlocks.SHALE_EMERALD_ORE, createOreDrop(EBlocks.SHALE_EMERALD_ORE, Items.EMERALD));

        // Cinnabar Ores
        add(EBlocks.CINNABAR_COAL_ORE, createOreDrop(EBlocks.CINNABAR_COAL_ORE, Items.COAL));
        add(EBlocks.CINNABAR_COPPER_ORE, createOreDrop(EBlocks.CINNABAR_COPPER_ORE, Items.RAW_COPPER));
        add(EBlocks.CINNABAR_IRON_ORE, createOreDrop(EBlocks.CINNABAR_IRON_ORE, Items.RAW_IRON));
        add(EBlocks.CINNABAR_GOLD_ORE, createOreDrop(EBlocks.CINNABAR_GOLD_ORE, Items.RAW_GOLD));
        add(EBlocks.CINNABAR_REDSTONE_ORE, createMultipleOreDrops(EBlocks.CINNABAR_REDSTONE_ORE, Items.REDSTONE, 4.0F, 5.0F));
        add(EBlocks.CINNABAR_DIAMOND_ORE, createOreDrop(EBlocks.CINNABAR_DIAMOND_ORE, Items.DIAMOND));
        add(EBlocks.CINNABAR_LAPIS_ORE, createMultipleOreDrops(EBlocks.CINNABAR_LAPIS_ORE, Items.LAPIS_LAZULI, 4.0F, 9.0F));
        add(EBlocks.CINNABAR_EMERALD_ORE, createOreDrop(EBlocks.CINNABAR_EMERALD_ORE, Items.EMERALD));

        // Tin
        add(EBlocks.TIN_ORE, createOreDrop(EBlocks.TIN_ORE, EItems.RAW_TIN));
        add(EBlocks.SHALE_TIN_ORE, createOreDrop(EBlocks.SHALE_TIN_ORE, EItems.RAW_TIN));
        add(EBlocks.DEEPSLATE_TIN_ORE, createOreDrop(EBlocks.DEEPSLATE_TIN_ORE, EItems.RAW_TIN));
        add(EBlocks.CINNABAR_TIN_ORE, createOreDrop(EBlocks.CINNABAR_TIN_ORE, EItems.RAW_TIN));

        // Silver
        add(EBlocks.SILVER_ORE, createOreDrop(EBlocks.SILVER_ORE, EItems.RAW_SILVER));
        add(EBlocks.SHALE_SILVER_ORE, createOreDrop(EBlocks.SHALE_SILVER_ORE, EItems.RAW_SILVER));
        add(EBlocks.DEEPSLATE_SILVER_ORE, createOreDrop(EBlocks.DEEPSLATE_SILVER_ORE, EItems.RAW_SILVER));
        add(EBlocks.CINNABAR_SILVER_ORE, createOreDrop(EBlocks.CINNABAR_SILVER_ORE, EItems.RAW_SILVER));

        dropSelf(EBlocks.RAW_TIN_BLOCK);
        dropSelf(EBlocks.TIN_BLOCK);
        dropSelf(EBlocks.BRONZE_BLOCK);
        dropSelf(EBlocks.SILVER_BLOCK);
        dropSelf(EBlocks.RAW_SILVER_BLOCK);
        dropSelf(EBlocks.SOULSTEEL_BLOCK);

        // Stones
        dropSelf(EBlocks.QUARTZ_BRICK_STAIRS);
        add(EBlocks.QUARTZ_BRICK_SLAB, createSlabItemTable(EBlocks.QUARTZ_BRICK_SLAB));

        dropSelf(EBlocks.AMETHYST_STAIRS);
        add(EBlocks.AMETHYST_SLAB, createSlabItemTable(EBlocks.AMETHYST_SLAB));
        dropSelf(EBlocks.AMETHYST_BRICKS);
        dropSelf(EBlocks.AMETHYST_BRICK_STAIRS);
        add(EBlocks.AMETHYST_BRICK_SLAB, createSlabItemTable(EBlocks.AMETHYST_BRICK_SLAB));
        dropSelf(EBlocks.AMETHYST_PILLAR);
        dropSelf(EBlocks.CHISELED_AMETHYST);

        dropSelf(EBlocks.OBSIDIAN_STAIRS);
        add(EBlocks.OBSIDIAN_SLAB, createSlabItemTable(EBlocks.OBSIDIAN_SLAB));
        dropSelf(EBlocks.OBSIDIAN_BRICKS);
        dropSelf(EBlocks.OBSIDIAN_BRICK_STAIRS);
        add(EBlocks.OBSIDIAN_BRICK_SLAB, createSlabItemTable(EBlocks.OBSIDIAN_BRICK_SLAB));
        dropSelf(EBlocks.OBSIDIAN_PILLAR);
        dropSelf(EBlocks.CHISELED_OBSIDIAN);

        dropSelf(EBlocks.STONE_WALL);
        dropSelf(EBlocks.SMOOTH_STONE_STAIRS);
        dropSelf(EBlocks.SMOOTH_STONE_WALL);
        dropSelf(EBlocks.POLISHED_STONE);
        dropSelf(EBlocks.POLISHED_STONE_STAIRS);
        add(EBlocks.POLISHED_STONE_SLAB, createSlabItemTable(EBlocks.POLISHED_STONE_SLAB));
        dropSelf(EBlocks.STONE_TILES);
        dropSelf(EBlocks.STONE_TILE_STAIRS);
        add(EBlocks.STONE_TILE_SLAB, createSlabItemTable(EBlocks.STONE_TILE_SLAB));
        dropSelf(EBlocks.STONE_TILE_WALL);
        dropSelf(EBlocks.MOSSY_STONE_TILES);
        dropSelf(EBlocks.MOSSY_STONE_TILE_STAIRS);
        add(EBlocks.MOSSY_STONE_TILE_SLAB, createSlabItemTable(EBlocks.MOSSY_STONE_TILE_SLAB));
        dropSelf(EBlocks.MOSSY_STONE_TILE_WALL);
        dropSelf(EBlocks.CHISELED_STONE);
        dropSelf(EBlocks.STONE_PILLAR);

        dropSelf(EBlocks.DEEPSLATE_STAIRS);
        dropSelf(EBlocks.DEEPSLATE_SLAB);
        dropSelf(EBlocks.DEEPSLATE_WALL);
        dropSelf(EBlocks.CHISELED_DEEPSLATE_BRICKS);
        dropSelf(EBlocks.DEEPSLATE_PILLAR);

        dropSelf(EBlocks.SMOOTH_TUFF);
        dropSelf(EBlocks.SMOOTH_TUFF_STAIRS);
        add(EBlocks.SMOOTH_TUFF_SLAB, createSlabItemTable(EBlocks.SMOOTH_TUFF_SLAB));
        dropSelf(EBlocks.SMOOTH_TUFF_WALL);
        dropSelf(EBlocks.TUFF_PILLAR);

        dropSelf(EBlocks.SMOOTH_BLACKSTONE);
        dropSelf(EBlocks.SMOOTH_BLACKSTONE_STAIRS);
        add(EBlocks.SMOOTH_BLACKSTONE_SLAB, createSlabItemTable(EBlocks.SMOOTH_BLACKSTONE_SLAB));
        dropSelf(EBlocks.SMOOTH_BLACKSTONE_WALL);
        dropSelf(EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);
        dropSelf(EBlocks.POLISHED_BLACKSTONE_PILLAR);

        dropSelf(EBlocks.SMOOTH_ANDESITE);
        dropSelf(EBlocks.SMOOTH_ANDESITE_STAIRS);
        add(EBlocks.SMOOTH_ANDESITE_SLAB, createSlabItemTable(EBlocks.SMOOTH_ANDESITE_SLAB));
        dropSelf(EBlocks.SMOOTH_ANDESITE_WALL);
        dropSelf(EBlocks.POLISHED_ANDESITE_WALL);
        dropSelf(EBlocks.ANDESITE_BRICKS);
        dropSelf(EBlocks.ANDESITE_BRICK_STAIRS);
        add(EBlocks.ANDESITE_BRICK_SLAB, createSlabItemTable(EBlocks.ANDESITE_BRICK_SLAB));
        dropSelf(EBlocks.ANDESITE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_ANDESITE);
        dropSelf(EBlocks.CHISELED_ANDESITE_BRICKS);
        dropSelf(EBlocks.ANDESITE_PILLAR);

        dropSelf(EBlocks.SMOOTH_GRANITE);
        dropSelf(EBlocks.SMOOTH_GRANITE_STAIRS);
        add(EBlocks.SMOOTH_GRANITE_SLAB, createSlabItemTable(EBlocks.SMOOTH_GRANITE_SLAB));
        dropSelf(EBlocks.SMOOTH_GRANITE_WALL);
        dropSelf(EBlocks.POLISHED_GRANITE_WALL);
        dropSelf(EBlocks.GRANITE_BRICKS);
        dropSelf(EBlocks.GRANITE_BRICK_STAIRS);
        add(EBlocks.GRANITE_BRICK_SLAB, createSlabItemTable(EBlocks.GRANITE_BRICK_SLAB));
        dropSelf(EBlocks.GRANITE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_GRANITE);
        dropSelf(EBlocks.CHISELED_GRANITE_BRICKS);
        dropSelf(EBlocks.GRANITE_PILLAR);

        dropSelf(EBlocks.SMOOTH_DIORITE);
        dropSelf(EBlocks.SMOOTH_DIORITE_STAIRS);
        add(EBlocks.SMOOTH_DIORITE_SLAB, createSlabItemTable(EBlocks.SMOOTH_DIORITE_SLAB));
        dropSelf(EBlocks.SMOOTH_DIORITE_WALL);
        dropSelf(EBlocks.POLISHED_DIORITE_WALL);
        dropSelf(EBlocks.DIORITE_BRICKS);
        dropSelf(EBlocks.DIORITE_BRICK_STAIRS);
        add(EBlocks.DIORITE_BRICK_SLAB, createSlabItemTable(EBlocks.DIORITE_BRICK_SLAB));
        dropSelf(EBlocks.DIORITE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_DIORITE);
        dropSelf(EBlocks.CHISELED_DIORITE_BRICKS);
        dropSelf(EBlocks.DIORITE_PILLAR);

        dropSelf(EBlocks.CALCITE_STAIRS);
        add(EBlocks.CALCITE_SLAB, createSlabItemTable(EBlocks.CALCITE_SLAB));
        dropSelf(EBlocks.CALCITE_WALL);
        dropSelf(EBlocks.SMOOTH_CALCITE);
        dropSelf(EBlocks.SMOOTH_CALCITE_STAIRS);
        add(EBlocks.SMOOTH_CALCITE_SLAB, createSlabItemTable(EBlocks.SMOOTH_CALCITE_SLAB));
        dropSelf(EBlocks.SMOOTH_CALCITE_WALL);
        dropSelf(EBlocks.POLISHED_CALCITE);
        dropSelf(EBlocks.POLISHED_CALCITE_STAIRS);
        add(EBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(EBlocks.POLISHED_CALCITE_SLAB));
        dropSelf(EBlocks.POLISHED_CALCITE_WALL);
        dropSelf(EBlocks.CALCITE_BRICKS);
        dropSelf(EBlocks.CALCITE_BRICK_STAIRS);
        add(EBlocks.CALCITE_BRICK_SLAB, createSlabItemTable(EBlocks.CALCITE_BRICK_SLAB));
        dropSelf(EBlocks.CALCITE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_CALCITE);
        dropSelf(EBlocks.CHISELED_CALCITE_BRICKS);
        dropSelf(EBlocks.CALCITE_PILLAR);

        dropSelf(EBlocks.DRIPSTONE_STAIRS);
        add(EBlocks.DRIPSTONE_SLAB, createSlabItemTable(EBlocks.DRIPSTONE_SLAB));
        dropSelf(EBlocks.DRIPSTONE_WALL);
        dropSelf(EBlocks.SMOOTH_DRIPSTONE);
        dropSelf(EBlocks.SMOOTH_DRIPSTONE_STAIRS);
        add(EBlocks.SMOOTH_DRIPSTONE_SLAB, createSlabItemTable(EBlocks.SMOOTH_DRIPSTONE_SLAB));
        dropSelf(EBlocks.SMOOTH_DRIPSTONE_WALL);
        dropSelf(EBlocks.POLISHED_DRIPSTONE);
        dropSelf(EBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(EBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(EBlocks.POLISHED_DRIPSTONE_SLAB));
        dropSelf(EBlocks.POLISHED_DRIPSTONE_WALL);
        dropSelf(EBlocks.DRIPSTONE_BRICKS);
        dropSelf(EBlocks.DRIPSTONE_BRICK_STAIRS);
        add(EBlocks.DRIPSTONE_BRICK_SLAB, createSlabItemTable(EBlocks.DRIPSTONE_BRICK_SLAB));
        dropSelf(EBlocks.DRIPSTONE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_DRIPSTONE);
        dropSelf(EBlocks.CHISELED_DRIPSTONE_BRICKS);
        dropSelf(EBlocks.DRIPSTONE_PILLAR);

        dropSelf(EBlocks.POLISHED_SANDSTONE);
        dropSelf(EBlocks.POLISHED_SANDSTONE_STAIRS);
        add(EBlocks.POLISHED_SANDSTONE_SLAB, createSlabItemTable(EBlocks.POLISHED_SANDSTONE_SLAB));
        dropSelf(EBlocks.POLISHED_SANDSTONE_WALL);
        dropSelf(EBlocks.POLISHED_RED_SANDSTONE);
        dropSelf(EBlocks.POLISHED_RED_SANDSTONE_STAIRS);
        add(EBlocks.POLISHED_RED_SANDSTONE_SLAB, createSlabItemTable(EBlocks.POLISHED_RED_SANDSTONE_SLAB));
        dropSelf(EBlocks.POLISHED_RED_SANDSTONE_WALL);
        dropSelf(EBlocks.SANDSTONE_BRICKS);
        dropSelf(EBlocks.SANDSTONE_BRICK_STAIRS);
        add(EBlocks.SANDSTONE_BRICK_SLAB, createSlabItemTable(EBlocks.SANDSTONE_BRICK_SLAB));
        dropSelf(EBlocks.SANDSTONE_BRICK_WALL);
        dropSelf(EBlocks.RED_SANDSTONE_BRICKS);
        dropSelf(EBlocks.RED_SANDSTONE_BRICK_STAIRS);
        add(EBlocks.RED_SANDSTONE_BRICK_SLAB, createSlabItemTable(EBlocks.RED_SANDSTONE_BRICK_SLAB));
        dropSelf(EBlocks.RED_SANDSTONE_BRICK_WALL);
        dropSelf(EBlocks.CUT_RED_SANDSTONE_WALL);
        dropSelf(EBlocks.CUT_RED_SANDSTONE_WALL);
        dropSelf(EBlocks.CUT_SANDSTONE_STAIRS);
        dropSelf(EBlocks.CUT_RED_SANDSTONE_STAIRS);
        dropSelf(EBlocks.CUT_SANDSTONE_WALL);
        dropSelf(EBlocks.CUT_RED_SANDSTONE_WALL);

        dropSelf(EBlocks.SMOOTH_PRISMARINE);
        dropSelf(EBlocks.SMOOTH_PRISMARINE_STAIRS);
        add(EBlocks.SMOOTH_PRISMARINE_SLAB, createSlabItemTable(EBlocks.SMOOTH_PRISMARINE_SLAB));
        dropSelf(EBlocks.SMOOTH_PRISMARINE_WALL);
        dropSelf(EBlocks.POLISHED_PRISMARINE);
        dropSelf(EBlocks.POLISHED_PRISMARINE_STAIRS);
        add(EBlocks.POLISHED_PRISMARINE_SLAB, createSlabItemTable(EBlocks.POLISHED_PRISMARINE_SLAB));
        dropSelf(EBlocks.POLISHED_PRISMARINE_WALL);
        dropSelf(EBlocks.PRISMARINE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_PRISMARINE);
        dropSelf(EBlocks.CHISELED_PRISMARINE_BRICKS);
        dropSelf(EBlocks.PRISMARINE_PILLAR);

        dropSelf(EBlocks.DARK_PRISMARINE_WALL);
        dropSelf(EBlocks.SMOOTH_DARK_PRISMARINE);
        dropSelf(EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS);
        add(EBlocks.SMOOTH_DARK_PRISMARINE_SLAB, createSlabItemTable(EBlocks.SMOOTH_DARK_PRISMARINE_SLAB));
        dropSelf(EBlocks.SMOOTH_DARK_PRISMARINE_WALL);
        dropSelf(EBlocks.POLISHED_DARK_PRISMARINE);
        dropSelf(EBlocks.POLISHED_DARK_PRISMARINE_STAIRS);
        add(EBlocks.POLISHED_DARK_PRISMARINE_SLAB, createSlabItemTable(EBlocks.POLISHED_DARK_PRISMARINE_SLAB));
        dropSelf(EBlocks.POLISHED_DARK_PRISMARINE_WALL);
        dropSelf(EBlocks.DARK_PRISMARINE_BRICKS);
        dropSelf(EBlocks.DARK_PRISMARINE_BRICK_STAIRS);
        add(EBlocks.DARK_PRISMARINE_BRICK_SLAB, createSlabItemTable(EBlocks.DARK_PRISMARINE_BRICK_SLAB));
        dropSelf(EBlocks.DARK_PRISMARINE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_DARK_PRISMARINE);
        dropSelf(EBlocks.CHISELED_DARK_PRISMARINE_BRICKS);
        dropSelf(EBlocks.DARK_PRISMARINE_PILLAR);

        add(EBlocks.BASALT_SLAB, createSlabItemTable(EBlocks.BASALT_SLAB));
        dropSelf(EBlocks.SMOOTH_BASALT_STAIRS);
        add(EBlocks.SMOOTH_BASALT_SLAB, createSlabItemTable(EBlocks.SMOOTH_BASALT_SLAB));
        dropSelf(EBlocks.SMOOTH_BASALT_WALL);
        add(EBlocks.POLISHED_BASALT_SLAB, createSlabItemTable(EBlocks.POLISHED_BASALT_SLAB));
        dropSelf(EBlocks.BASALT_BRICKS);
        dropSelf(EBlocks.BASALT_BRICK_STAIRS);
        add(EBlocks.BASALT_BRICK_SLAB, createSlabItemTable(EBlocks.BASALT_BRICK_SLAB));
        dropSelf(EBlocks.BASALT_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_BASALT);
        dropSelf(EBlocks.CHISELED_BASALT_BRICKS);

        dropSelf(EBlocks.END_STONE_STAIRS);
        add(EBlocks.END_STONE_SLAB, createSlabItemTable(EBlocks.END_STONE_SLAB));
        dropSelf(EBlocks.END_STONE_WALL);
        dropSelf(EBlocks.SMOOTH_END_STONE);
        dropSelf(EBlocks.SMOOTH_END_STONE_STAIRS);
        add(EBlocks.SMOOTH_END_STONE_SLAB, createSlabItemTable(EBlocks.SMOOTH_END_STONE_SLAB));
        dropSelf(EBlocks.SMOOTH_END_STONE_WALL);
        dropSelf(EBlocks.POLISHED_END_STONE);
        dropSelf(EBlocks.POLISHED_END_STONE_STAIRS);
        add(EBlocks.POLISHED_END_STONE_SLAB, createSlabItemTable(EBlocks.POLISHED_END_STONE_SLAB));
        dropSelf(EBlocks.POLISHED_END_STONE_WALL);
        dropSelf(EBlocks.CHISELED_END_STONE);
        dropSelf(EBlocks.CHISELED_END_STONE_BRICKS);
        dropSelf(EBlocks.END_STONE_PILLAR);

        dropSelf(EBlocks.SODALITE);
        dropSelf(EBlocks.SODALITE_STAIRS);
        add(EBlocks.SODALITE_SLAB, createSlabItemTable(EBlocks.SODALITE_SLAB));
        dropSelf(EBlocks.SODALITE_WALL);
        dropSelf(EBlocks.SMOOTH_SODALITE);
        dropSelf(EBlocks.SMOOTH_SODALITE_STAIRS);
        add(EBlocks.SMOOTH_SODALITE_SLAB, createSlabItemTable(EBlocks.SMOOTH_SODALITE_SLAB));
        dropSelf(EBlocks.SMOOTH_SODALITE_WALL);
        dropSelf(EBlocks.POLISHED_SODALITE);
        dropSelf(EBlocks.POLISHED_SODALITE_STAIRS);
        add(EBlocks.POLISHED_SODALITE_SLAB, createSlabItemTable(EBlocks.POLISHED_SODALITE_SLAB));
        dropSelf(EBlocks.POLISHED_SODALITE_WALL);
        dropSelf(EBlocks.SODALITE_BRICKS);
        dropSelf(EBlocks.SODALITE_BRICK_STAIRS);
        add(EBlocks.SODALITE_BRICK_SLAB, createSlabItemTable(EBlocks.SODALITE_BRICK_SLAB));
        dropSelf(EBlocks.SODALITE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_SODALITE);
        dropSelf(EBlocks.CHISELED_SODALITE_BRICKS);
        dropSelf(EBlocks.SODALITE_PILLAR);

        add(EBlocks.SHALE, createSingleItemTableWithSilkTouch(EBlocks.SHALE, EBlocks.COBBLESHALE));
        dropSelf(EBlocks.SHALE_STAIRS);
        add(EBlocks.SHALE_SLAB, createSlabItemTable(EBlocks.SHALE_SLAB));
        dropSelf(EBlocks.SHALE_WALL);
        dropSelf(EBlocks.SMOOTH_SHALE);
        dropSelf(EBlocks.SMOOTH_SHALE_STAIRS);
        add(EBlocks.SMOOTH_SHALE_SLAB, createSlabItemTable(EBlocks.SMOOTH_SHALE_SLAB));
        dropSelf(EBlocks.SMOOTH_SHALE_WALL);
        dropSelf(EBlocks.POLISHED_SHALE);
        dropSelf(EBlocks.POLISHED_SHALE_STAIRS);
        add(EBlocks.POLISHED_SHALE_SLAB, createSlabItemTable(EBlocks.POLISHED_SHALE_SLAB));
        dropSelf(EBlocks.POLISHED_SHALE_WALL);
        dropSelf(EBlocks.SHALE_BRICKS);
        dropSelf(EBlocks.SHALE_BRICK_STAIRS);
        add(EBlocks.SHALE_BRICK_SLAB, createSlabItemTable(EBlocks.SHALE_BRICK_SLAB));
        dropSelf(EBlocks.SHALE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_SHALE);
        dropSelf(EBlocks.CHISELED_SHALE_BRICKS);
        dropSelf(EBlocks.SHALE_PILLAR);
        dropSelf(EBlocks.COBBLESHALE);
        dropSelf(EBlocks.COBBLESHALE_STAIRS);
        add(EBlocks.COBBLESHALE_SLAB, createSlabItemTable(EBlocks.COBBLESHALE_SLAB));
        dropSelf(EBlocks.COBBLESHALE_WALL);
        dropSelf(EBlocks.SHALE_TILES);
        dropSelf(EBlocks.SHALE_TILE_STAIRS);
        add(EBlocks.SHALE_TILE_SLAB, createSlabItemTable(EBlocks.SHALE_TILE_SLAB));
        dropSelf(EBlocks.SHALE_TILE_WALL);

        dropSelf(EBlocks.SULFUR);
        dropSelf(EBlocks.SULFUR_STAIRS);
        add(EBlocks.SULFUR_SLAB, createSlabItemTable(EBlocks.SULFUR_SLAB));
        dropSelf(EBlocks.SULFUR_WALL);
        dropSelf(EBlocks.SMOOTH_SULFUR);
        dropSelf(EBlocks.SMOOTH_SULFUR_STAIRS);
        add(EBlocks.SMOOTH_SULFUR_SLAB, createSlabItemTable(EBlocks.SMOOTH_SULFUR_SLAB));
        dropSelf(EBlocks.SMOOTH_SULFUR_WALL);
        dropSelf(EBlocks.POLISHED_SULFUR);
        dropSelf(EBlocks.POLISHED_SULFUR_STAIRS);
        add(EBlocks.POLISHED_SULFUR_SLAB, createSlabItemTable(EBlocks.POLISHED_SULFUR_SLAB));
        dropSelf(EBlocks.POLISHED_SULFUR_WALL);
        dropSelf(EBlocks.SULFUR_BRICKS);
        dropSelf(EBlocks.SULFUR_BRICK_STAIRS);
        add(EBlocks.SULFUR_BRICK_SLAB, createSlabItemTable(EBlocks.SULFUR_BRICK_SLAB));
        dropSelf(EBlocks.SULFUR_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_SULFUR);
        dropSelf(EBlocks.CHISELED_SULFUR_BRICKS);
        dropSelf(EBlocks.SULFUR_PILLAR);

        dropSelf(EBlocks.SULFUR_SPIKE);
        dropSelf(EBlocks.POTENT_SULFUR);

        dropSelf(EBlocks.CINNABAR);
        dropSelf(EBlocks.CINNABAR_STAIRS);
        add(EBlocks.CINNABAR_SLAB, createSlabItemTable(EBlocks.CINNABAR_SLAB));
        dropSelf(EBlocks.CINNABAR_WALL);
        dropSelf(EBlocks.SMOOTH_CINNABAR);
        dropSelf(EBlocks.SMOOTH_CINNABAR_STAIRS);
        add(EBlocks.SMOOTH_CINNABAR_SLAB, createSlabItemTable(EBlocks.SMOOTH_CINNABAR_SLAB));
        dropSelf(EBlocks.SMOOTH_CINNABAR_WALL);
        dropSelf(EBlocks.POLISHED_CINNABAR);
        dropSelf(EBlocks.POLISHED_CINNABAR_STAIRS);
        add(EBlocks.POLISHED_CINNABAR_SLAB, createSlabItemTable(EBlocks.POLISHED_CINNABAR_SLAB));
        dropSelf(EBlocks.POLISHED_CINNABAR_WALL);
        dropSelf(EBlocks.CINNABAR_BRICKS);
        dropSelf(EBlocks.CINNABAR_BRICK_STAIRS);
        add(EBlocks.CINNABAR_BRICK_SLAB, createSlabItemTable(EBlocks.CINNABAR_BRICK_SLAB));
        dropSelf(EBlocks.CINNABAR_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_CINNABAR);
        dropSelf(EBlocks.CHISELED_CINNABAR_BRICKS);
        dropSelf(EBlocks.CINNABAR_PILLAR);

        dropSelf(EBlocks.NETHERRACK_STAIRS);
        add(EBlocks.NETHERRACK_SLAB, createSlabItemTable(EBlocks.NETHERRACK_SLAB));
        dropSelf(EBlocks.NETHERRACK_WALL);
        dropSelf(EBlocks.SMOOTH_NETHERRACK);
        dropSelf(EBlocks.SMOOTH_NETHERRACK_STAIRS);
        add(EBlocks.SMOOTH_NETHERRACK_SLAB, createSlabItemTable(EBlocks.SMOOTH_NETHERRACK_SLAB));
        dropSelf(EBlocks.SMOOTH_NETHERRACK_WALL);
        dropSelf(EBlocks.POLISHED_NETHERRACK);
        dropSelf(EBlocks.POLISHED_NETHERRACK_STAIRS);
        add(EBlocks.POLISHED_NETHERRACK_SLAB, createSlabItemTable(EBlocks.POLISHED_NETHERRACK_SLAB));
        dropSelf(EBlocks.POLISHED_NETHERRACK_WALL);
        dropSelf(EBlocks.NETHERRACK_BRICKS);
        dropSelf(EBlocks.NETHERRACK_BRICK_STAIRS);
        add(EBlocks.NETHERRACK_BRICK_SLAB, createSlabItemTable(EBlocks.NETHERRACK_BRICK_SLAB));
        dropSelf(EBlocks.NETHERRACK_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_NETHERRACK);
        dropSelf(EBlocks.CHISELED_NETHERRACK_BRICKS);
        dropSelf(EBlocks.NETHERRACK_PILLAR);

        dropSelf(EBlocks.ORPIMENT);
        dropSelf(EBlocks.ORPIMENT_STAIRS);
        add(EBlocks.ORPIMENT_SLAB, createSlabItemTable(EBlocks.ORPIMENT_SLAB));
        dropSelf(EBlocks.ORPIMENT_WALL);
        dropSelf(EBlocks.SMOOTH_ORPIMENT);
        dropSelf(EBlocks.SMOOTH_ORPIMENT_STAIRS);
        add(EBlocks.SMOOTH_ORPIMENT_SLAB, createSlabItemTable(EBlocks.SMOOTH_ORPIMENT_SLAB));
        dropSelf(EBlocks.SMOOTH_ORPIMENT_WALL);
        dropSelf(EBlocks.POLISHED_ORPIMENT);
        dropSelf(EBlocks.POLISHED_ORPIMENT_STAIRS);
        add(EBlocks.POLISHED_ORPIMENT_SLAB, createSlabItemTable(EBlocks.POLISHED_ORPIMENT_SLAB));
        dropSelf(EBlocks.POLISHED_ORPIMENT_WALL);
        dropSelf(EBlocks.ORPIMENT_BRICKS);
        dropSelf(EBlocks.ORPIMENT_BRICK_STAIRS);
        add(EBlocks.ORPIMENT_BRICK_SLAB, createSlabItemTable(EBlocks.ORPIMENT_BRICK_SLAB));
        dropSelf(EBlocks.ORPIMENT_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_ORPIMENT);
        dropSelf(EBlocks.CHISELED_ORPIMENT_BRICKS);
        dropSelf(EBlocks.ORPIMENT_PILLAR);

        dropSelf(EBlocks.SOUL_SANDSTONE);
        dropSelf(EBlocks.SOUL_SANDSTONE_STAIRS);
        add(EBlocks.SOUL_SANDSTONE_SLAB, createSlabItemTable(EBlocks.SOUL_SANDSTONE_SLAB));
        dropSelf(EBlocks.SOUL_SANDSTONE_WALL);
        dropSelf(EBlocks.SMOOTH_SOUL_SANDSTONE);
        dropSelf(EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
        add(EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, createSlabItemTable(EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB));
        dropSelf(EBlocks.SMOOTH_SOUL_SANDSTONE_WALL);
        dropSelf(EBlocks.CUT_SOUL_SANDSTONE);
        dropSelf(EBlocks.CUT_SOUL_SANDSTONE_STAIRS);
        add(EBlocks.CUT_SOUL_SANDSTONE_SLAB, createSlabItemTable(EBlocks.CUT_SOUL_SANDSTONE_SLAB));
        dropSelf(EBlocks.CUT_SOUL_SANDSTONE_WALL);
        dropSelf(EBlocks.POLISHED_SOUL_SANDSTONE);
        dropSelf(EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS);
        add(EBlocks.POLISHED_SOUL_SANDSTONE_SLAB, createSlabItemTable(EBlocks.POLISHED_SOUL_SANDSTONE_SLAB));
        dropSelf(EBlocks.POLISHED_SOUL_SANDSTONE_WALL);
        dropSelf(EBlocks.SOUL_SANDSTONE_BRICKS);
        dropSelf(EBlocks.SOUL_SANDSTONE_BRICK_STAIRS);
        add(EBlocks.SOUL_SANDSTONE_BRICK_SLAB, createSlabItemTable(EBlocks.SOUL_SANDSTONE_BRICK_SLAB));
        dropSelf(EBlocks.SOUL_SANDSTONE_BRICK_WALL);
        dropSelf(EBlocks.CHISELED_SOUL_SANDSTONE);

        dropSelf(EBlocks.CHISELED_PURPUR);

        add(EBlocks.ICICLE, createSilkTouchOnlyTable(EBlocks.ICICLE));

        dropSelf(EBlocks.PACKED_MUD_STAIRS);
        add(EBlocks.PACKED_MUD_SLAB, createSlabItemTable(EBlocks.PACKED_MUD_SLAB));
        dropSelf(EBlocks.PACKED_MUD_WALL);
        dropSelf(EBlocks.CHISELED_MUD_BRICKS);
        dropSelf(EBlocks.MUD_BRICK_PILLAR);

        dropSelf(EBlocks.ARID_DIRT);
        add(EBlocks.ARID_GRASS_BLOCK, createSingleItemTableWithSilkTouch(EBlocks.ARID_GRASS_BLOCK, EBlocks.ARID_DIRT));

        add(EBlocks.RED_GRASS_BLOCK, createSingleItemTableWithSilkTouch(EBlocks.RED_GRASS_BLOCK, Blocks.DIRT));
        add(EBlocks.SHORT_RED_GRASS, createShearsOrSilkTouchOnlyDrop(EBlocks.SHORT_RED_GRASS));
        add(EBlocks.TALL_RED_GRASS, createDoublePlantShearsOrSilkTouchDrop(EBlocks.TALL_RED_GRASS));
        add(EBlocks.RED_SHRUB, createShearsOrSilkTouchOnlyDrop(EBlocks.RED_SHRUB));

        dropSelf(EBlocks.POPLAR_LOG);
        dropSelf(EBlocks.STRIPPED_POPLAR_LOG);
        dropSelf(EBlocks.POPLAR_WOOD);
        dropSelf(EBlocks.STRIPPED_POPLAR_WOOD);
        dropSelf(EBlocks.POPLAR_PLANKS);
        dropSelf(EBlocks.POPLAR_MOSAIC);
        dropSelf(EBlocks.POPLAR_BOARDS);
        dropSelf(EBlocks.POPLAR_TRIM);
        dropSelf(EBlocks.POPLAR_STAIRS);
        dropSelf(EBlocks.POPLAR_MOSAIC_STAIRS);
        dropSelf(EBlocks.POPLAR_FENCE);
        dropSelf(EBlocks.POPLAR_FENCE_GATE);
        add(EBlocks.POPLAR_SLAB, createSlabItemTable(EBlocks.POPLAR_SLAB));
        add(EBlocks.POPLAR_MOSAIC_SLAB, createSlabItemTable(EBlocks.POPLAR_MOSAIC_SLAB));
        add(EBlocks.POPLAR_DOOR, createDoorTable(EBlocks.POPLAR_DOOR));
        dropSelf(EBlocks.POPLAR_TRAPDOOR);
        dropSelf(EBlocks.POPLAR_PRESSURE_PLATE);
        dropSelf(EBlocks.POPLAR_BUTTON);
        dropOther(EBlocks.POPLAR_SIGN, EItems.POPLAR_SIGN);
        dropOther(EBlocks.POPLAR_WALL_SIGN, EItems.POPLAR_SIGN);
        dropOther(EBlocks.POPLAR_HANGING_SIGN, EItems.POPLAR_HANGING_SIGN);
        dropOther(EBlocks.POPLAR_WALL_HANGING_SIGN, EItems.POPLAR_HANGING_SIGN);

        add(EBlocks.RED_POPLAR_LEAVES, createLeavesDrops(EBlocks.RED_POPLAR_LEAVES, EBlocks.POPLAR_SAPLING, 0.05F));
        add(EBlocks.ORANGE_POPLAR_LEAVES, createLeavesDrops(EBlocks.ORANGE_POPLAR_LEAVES, EBlocks.POPLAR_SAPLING, 0.05F));
        add(EBlocks.YELLOW_POPLAR_LEAVES, createLeavesDrops(EBlocks.YELLOW_POPLAR_LEAVES, EBlocks.POPLAR_SAPLING, 0.05F));

        dropSelf(EBlocks.RUSTY_MOSS_BLOCK);
        dropSelf(EBlocks.RUSTY_MOSS_CARPET);

        dropSelf(EBlocks.AZALEA_LOG);
        dropSelf(EBlocks.STRIPPED_AZALEA_LOG);
        dropSelf(EBlocks.AZALEA_WOOD);
        dropSelf(EBlocks.STRIPPED_AZALEA_WOOD);
        dropSelf(EBlocks.AZALEA_PLANKS);
        dropSelf(EBlocks.AZALEA_MOSAIC);
        dropSelf(EBlocks.AZALEA_BOARDS);
        dropSelf(EBlocks.AZALEA_TRIM);
        dropSelf(EBlocks.AZALEA_STAIRS);
        dropSelf(EBlocks.AZALEA_MOSAIC_STAIRS);
        dropSelf(EBlocks.AZALEA_FENCE);
        dropSelf(EBlocks.AZALEA_FENCE_GATE);
        add(EBlocks.AZALEA_SLAB, createSlabItemTable(EBlocks.AZALEA_SLAB));
        add(EBlocks.AZALEA_MOSAIC_SLAB, createSlabItemTable(EBlocks.AZALEA_MOSAIC_SLAB));
        add(EBlocks.AZALEA_DOOR, createDoorTable(EBlocks.AZALEA_DOOR));
        dropSelf(EBlocks.AZALEA_TRAPDOOR);
        dropSelf(EBlocks.AZALEA_PRESSURE_PLATE);
        dropSelf(EBlocks.AZALEA_BUTTON);
        dropOther(EBlocks.AZALEA_SIGN, EItems.AZALEA_SIGN);
        dropOther(EBlocks.AZALEA_WALL_SIGN, EItems.AZALEA_SIGN);
        dropOther(EBlocks.AZALEA_HANGING_SIGN, EItems.AZALEA_HANGING_SIGN);
        dropOther(EBlocks.AZALEA_WALL_HANGING_SIGN, EItems.AZALEA_HANGING_SIGN);

        dropSelf(EBlocks.LATERITE);

        add(EBlocks.BEJEWELED_CALCITE, createMultipleOreDrops(EBlocks.BEJEWELED_CALCITE, EItems.EMERALD_SHARD, 3, 5));

        dropSelf(EBlocks.PEBBLE);

        dropSelf(EBlocks.BLUEBONNET);
        add(EBlocks.POTTED_BLUEBONNET, createPotFlowerItemTable(EBlocks.BLUEBONNET));

        dropSelf(EBlocks.RED_HIBISCUS);
        add(EBlocks.POTTED_RED_HIBISCUS, createPotFlowerItemTable(EBlocks.RED_HIBISCUS));
        dropSelf(EBlocks.ORANGE_HIBISCUS);
        add(EBlocks.POTTED_ORANGE_HIBISCUS, createPotFlowerItemTable(EBlocks.ORANGE_HIBISCUS));
        dropSelf(EBlocks.YELLOW_HIBISCUS);
        add(EBlocks.POTTED_YELLOW_HIBISCUS, createPotFlowerItemTable(EBlocks.YELLOW_HIBISCUS));
        dropSelf(EBlocks.BLUE_HIBISCUS);
        add(EBlocks.POTTED_BLUE_HIBISCUS, createPotFlowerItemTable(EBlocks.BLUE_HIBISCUS));
        dropSelf(EBlocks.PURPLE_HIBISCUS);
        add(EBlocks.POTTED_PURPLE_HIBISCUS, createPotFlowerItemTable(EBlocks.PURPLE_HIBISCUS));
        dropSelf(EBlocks.PINK_HIBISCUS);
        add(EBlocks.POTTED_PINK_HIBISCUS, createPotFlowerItemTable(EBlocks.PINK_HIBISCUS));
        dropSelf(EBlocks.WHITE_HIBISCUS);
        add(EBlocks.POTTED_WHITE_HIBISCUS, createPotFlowerItemTable(EBlocks.WHITE_HIBISCUS));

        dropSelf(EBlocks.OAK_MOSAIC);
        dropSelf(EBlocks.OAK_MOSAIC_STAIRS);
        add(EBlocks.OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.OAK_BOARDS);
        dropSelf(EBlocks.OAK_TRIM);
        dropSelf(EBlocks.DARK_OAK_MOSAIC);
        dropSelf(EBlocks.DARK_OAK_MOSAIC_STAIRS);
        add(EBlocks.DARK_OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.DARK_OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.DARK_OAK_BOARDS);
        dropSelf(EBlocks.DARK_OAK_TRIM);
        dropSelf(EBlocks.PALE_OAK_MOSAIC);
        dropSelf(EBlocks.PALE_OAK_MOSAIC_STAIRS);
        add(EBlocks.PALE_OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.PALE_OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.PALE_OAK_BOARDS);
        dropSelf(EBlocks.PALE_OAK_TRIM);
        dropSelf(EBlocks.BIRCH_MOSAIC);
        dropSelf(EBlocks.BIRCH_MOSAIC_STAIRS);
        add(EBlocks.BIRCH_MOSAIC_SLAB, createSlabItemTable(EBlocks.BIRCH_MOSAIC_SLAB));
        dropSelf(EBlocks.BIRCH_BOARDS);
        dropSelf(EBlocks.BIRCH_TRIM);
        dropSelf(EBlocks.SPRUCE_MOSAIC);
        dropSelf(EBlocks.SPRUCE_MOSAIC_STAIRS);
        add(EBlocks.SPRUCE_MOSAIC_SLAB, createSlabItemTable(EBlocks.SPRUCE_MOSAIC_SLAB));
        dropSelf(EBlocks.SPRUCE_BOARDS);
        dropSelf(EBlocks.SPRUCE_TRIM);
        dropSelf(EBlocks.JUNGLE_MOSAIC);
        dropSelf(EBlocks.JUNGLE_MOSAIC_STAIRS);
        add(EBlocks.JUNGLE_MOSAIC_SLAB, createSlabItemTable(EBlocks.JUNGLE_MOSAIC_SLAB));
        dropSelf(EBlocks.JUNGLE_BOARDS);
        dropSelf(EBlocks.JUNGLE_TRIM);
        dropSelf(EBlocks.ACACIA_MOSAIC);
        dropSelf(EBlocks.ACACIA_MOSAIC_STAIRS);
        add(EBlocks.ACACIA_MOSAIC_SLAB, createSlabItemTable(EBlocks.ACACIA_MOSAIC_SLAB));
        dropSelf(EBlocks.ACACIA_BOARDS);
        dropSelf(EBlocks.ACACIA_TRIM);
        dropSelf(EBlocks.CHERRY_MOSAIC);
        dropSelf(EBlocks.CHERRY_MOSAIC_STAIRS);
        add(EBlocks.CHERRY_MOSAIC_SLAB, createSlabItemTable(EBlocks.CHERRY_MOSAIC_SLAB));
        dropSelf(EBlocks.CHERRY_BOARDS);
        dropSelf(EBlocks.CHERRY_TRIM);
        dropSelf(EBlocks.MANGROVE_MOSAIC);
        dropSelf(EBlocks.MANGROVE_MOSAIC_STAIRS);
        add(EBlocks.MANGROVE_MOSAIC_SLAB, createSlabItemTable(EBlocks.MANGROVE_MOSAIC_SLAB));
        dropSelf(EBlocks.MANGROVE_BOARDS);
        dropSelf(EBlocks.MANGROVE_TRIM);
        dropSelf(EBlocks.CRIMSON_MOSAIC);
        dropSelf(EBlocks.CRIMSON_MOSAIC_STAIRS);
        add(EBlocks.CRIMSON_MOSAIC_SLAB, createSlabItemTable(EBlocks.CRIMSON_MOSAIC_SLAB));
        dropSelf(EBlocks.CRIMSON_BOARDS);
        dropSelf(EBlocks.CRIMSON_TRIM);
        dropSelf(EBlocks.WARPED_MOSAIC);
        dropSelf(EBlocks.WARPED_MOSAIC_STAIRS);
        add(EBlocks.WARPED_MOSAIC_SLAB, createSlabItemTable(EBlocks.WARPED_MOSAIC_SLAB));
        dropSelf(EBlocks.WARPED_BOARDS);
        dropSelf(EBlocks.WARPED_TRIM);

        dropSelf(EBlocks.BAMBOO_STEM);
        dropSelf(EBlocks.STRIPPED_BAMBOO_STEM);
        dropSelf(EBlocks.BAMBOO_BOARDS);
        dropSelf(EBlocks.BAMBOO_TRIM);

        dropSelf(EBlocks.WHITE_WOOL_STAIRS);
        add(EBlocks.WHITE_WOOL_SLAB, createSlabItemTable(EBlocks.WHITE_WOOL_SLAB));
        dropSelf(EBlocks.LIGHT_GRAY_WOOL_STAIRS);
        add(EBlocks.LIGHT_GRAY_WOOL_SLAB, createSlabItemTable(EBlocks.LIGHT_GRAY_WOOL_SLAB));
        dropSelf(EBlocks.GRAY_WOOL_STAIRS);
        add(EBlocks.GRAY_WOOL_SLAB, createSlabItemTable(EBlocks.GRAY_WOOL_SLAB));
        dropSelf(EBlocks.BLACK_WOOL_STAIRS);
        add(EBlocks.BLACK_WOOL_SLAB, createSlabItemTable(EBlocks.BLACK_WOOL_SLAB));
        dropSelf(EBlocks.BROWN_WOOL_STAIRS);
        add(EBlocks.BROWN_WOOL_SLAB, createSlabItemTable(EBlocks.BROWN_WOOL_SLAB));
        dropSelf(EBlocks.RED_WOOL_STAIRS);
        add(EBlocks.RED_WOOL_SLAB, createSlabItemTable(EBlocks.RED_WOOL_SLAB));
        dropSelf(EBlocks.ORANGE_WOOL_STAIRS);
        add(EBlocks.ORANGE_WOOL_SLAB, createSlabItemTable(EBlocks.ORANGE_WOOL_SLAB));
        dropSelf(EBlocks.YELLOW_WOOL_STAIRS);
        add(EBlocks.YELLOW_WOOL_SLAB, createSlabItemTable(EBlocks.YELLOW_WOOL_SLAB));
        dropSelf(EBlocks.LIME_WOOL_STAIRS);
        add(EBlocks.LIME_WOOL_SLAB, createSlabItemTable(EBlocks.LIME_WOOL_SLAB));
        dropSelf(EBlocks.GREEN_WOOL_STAIRS);
        add(EBlocks.GREEN_WOOL_SLAB, createSlabItemTable(EBlocks.GREEN_WOOL_SLAB));
        dropSelf(EBlocks.CYAN_WOOL_STAIRS);
        add(EBlocks.CYAN_WOOL_SLAB, createSlabItemTable(EBlocks.CYAN_WOOL_SLAB));
        dropSelf(EBlocks.LIGHT_BLUE_WOOL_STAIRS);
        add(EBlocks.LIGHT_BLUE_WOOL_SLAB, createSlabItemTable(EBlocks.LIGHT_BLUE_WOOL_SLAB));
        dropSelf(EBlocks.BLUE_WOOL_STAIRS);
        add(EBlocks.BLUE_WOOL_SLAB, createSlabItemTable(EBlocks.BLUE_WOOL_SLAB));
        dropSelf(EBlocks.PURPLE_WOOL_STAIRS);
        add(EBlocks.PURPLE_WOOL_SLAB, createSlabItemTable(EBlocks.PURPLE_WOOL_SLAB));
        dropSelf(EBlocks.MAGENTA_WOOL_STAIRS);
        add(EBlocks.MAGENTA_WOOL_SLAB, createSlabItemTable(EBlocks.MAGENTA_WOOL_SLAB));
        dropSelf(EBlocks.PINK_WOOL_STAIRS);
        add(EBlocks.PINK_WOOL_SLAB, createSlabItemTable(EBlocks.PINK_WOOL_SLAB));

        dropSelf(EBlocks.TERRACOTTA_STAIRS);
        add(EBlocks.TERRACOTTA_SLAB, createSlabItemTable(EBlocks.TERRACOTTA_SLAB));
        dropSelf(EBlocks.WHITE_TERRACOTTA_STAIRS);
        add(EBlocks.WHITE_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.WHITE_TERRACOTTA_SLAB));
        dropSelf(EBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        add(EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB));
        dropSelf(EBlocks.GRAY_TERRACOTTA_STAIRS);
        add(EBlocks.GRAY_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.GRAY_TERRACOTTA_SLAB));
        dropSelf(EBlocks.BLACK_TERRACOTTA_STAIRS);
        add(EBlocks.BLACK_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.BLACK_TERRACOTTA_SLAB));
        dropSelf(EBlocks.BROWN_TERRACOTTA_STAIRS);
        add(EBlocks.BROWN_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.BROWN_TERRACOTTA_SLAB));
        dropSelf(EBlocks.RED_TERRACOTTA_STAIRS);
        add(EBlocks.RED_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.RED_TERRACOTTA_SLAB));
        dropSelf(EBlocks.ORANGE_TERRACOTTA_STAIRS);
        add(EBlocks.ORANGE_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.ORANGE_TERRACOTTA_SLAB));
        dropSelf(EBlocks.YELLOW_TERRACOTTA_STAIRS);
        add(EBlocks.YELLOW_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.YELLOW_TERRACOTTA_SLAB));
        dropSelf(EBlocks.LIME_TERRACOTTA_STAIRS);
        add(EBlocks.LIME_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.LIME_TERRACOTTA_SLAB));
        dropSelf(EBlocks.GREEN_TERRACOTTA_STAIRS);
        add(EBlocks.GREEN_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.GREEN_TERRACOTTA_SLAB));
        dropSelf(EBlocks.CYAN_TERRACOTTA_STAIRS);
        add(EBlocks.CYAN_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.CYAN_TERRACOTTA_SLAB));
        dropSelf(EBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        add(EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB));
        dropSelf(EBlocks.BLUE_TERRACOTTA_STAIRS);
        add(EBlocks.BLUE_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.BLUE_TERRACOTTA_SLAB));
        dropSelf(EBlocks.PURPLE_TERRACOTTA_STAIRS);
        add(EBlocks.PURPLE_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.PURPLE_TERRACOTTA_SLAB));
        dropSelf(EBlocks.MAGENTA_TERRACOTTA_STAIRS);
        add(EBlocks.MAGENTA_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.MAGENTA_TERRACOTTA_SLAB));
        dropSelf(EBlocks.PINK_TERRACOTTA_STAIRS);
        add(EBlocks.PINK_TERRACOTTA_SLAB, createSlabItemTable(EBlocks.PINK_TERRACOTTA_SLAB));

        dropSelf(EBlocks.WHITE_CONCRETE_STAIRS);
        add(EBlocks.WHITE_CONCRETE_SLAB, createSlabItemTable(EBlocks.WHITE_CONCRETE_SLAB));
        dropSelf(EBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        add(EBlocks.LIGHT_GRAY_CONCRETE_SLAB, createSlabItemTable(EBlocks.LIGHT_GRAY_CONCRETE_SLAB));
        dropSelf(EBlocks.GRAY_CONCRETE_STAIRS);
        add(EBlocks.GRAY_CONCRETE_SLAB, createSlabItemTable(EBlocks.GRAY_CONCRETE_SLAB));
        dropSelf(EBlocks.BLACK_CONCRETE_STAIRS);
        add(EBlocks.BLACK_CONCRETE_SLAB, createSlabItemTable(EBlocks.BLACK_CONCRETE_SLAB));
        dropSelf(EBlocks.BROWN_CONCRETE_STAIRS);
        add(EBlocks.BROWN_CONCRETE_SLAB, createSlabItemTable(EBlocks.BROWN_CONCRETE_SLAB));
        dropSelf(EBlocks.RED_CONCRETE_STAIRS);
        add(EBlocks.RED_CONCRETE_SLAB, createSlabItemTable(EBlocks.RED_CONCRETE_SLAB));
        dropSelf(EBlocks.ORANGE_CONCRETE_STAIRS);
        add(EBlocks.ORANGE_CONCRETE_SLAB, createSlabItemTable(EBlocks.ORANGE_CONCRETE_SLAB));
        dropSelf(EBlocks.YELLOW_CONCRETE_STAIRS);
        add(EBlocks.YELLOW_CONCRETE_SLAB, createSlabItemTable(EBlocks.YELLOW_CONCRETE_SLAB));
        dropSelf(EBlocks.LIME_CONCRETE_STAIRS);
        add(EBlocks.LIME_CONCRETE_SLAB, createSlabItemTable(EBlocks.LIME_CONCRETE_SLAB));
        dropSelf(EBlocks.GREEN_CONCRETE_STAIRS);
        add(EBlocks.GREEN_CONCRETE_SLAB, createSlabItemTable(EBlocks.GREEN_CONCRETE_SLAB));
        dropSelf(EBlocks.CYAN_CONCRETE_STAIRS);
        add(EBlocks.CYAN_CONCRETE_SLAB, createSlabItemTable(EBlocks.CYAN_CONCRETE_SLAB));
        dropSelf(EBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        add(EBlocks.LIGHT_BLUE_CONCRETE_SLAB, createSlabItemTable(EBlocks.LIGHT_BLUE_CONCRETE_SLAB));
        dropSelf(EBlocks.BLUE_CONCRETE_STAIRS);
        add(EBlocks.BLUE_CONCRETE_SLAB, createSlabItemTable(EBlocks.BLUE_CONCRETE_SLAB));
        dropSelf(EBlocks.PURPLE_CONCRETE_STAIRS);
        add(EBlocks.PURPLE_CONCRETE_SLAB, createSlabItemTable(EBlocks.PURPLE_CONCRETE_SLAB));
        dropSelf(EBlocks.MAGENTA_CONCRETE_STAIRS);
        add(EBlocks.MAGENTA_CONCRETE_SLAB, createSlabItemTable(EBlocks.MAGENTA_CONCRETE_SLAB));
        dropSelf(EBlocks.PINK_CONCRETE_STAIRS);
        add(EBlocks.PINK_CONCRETE_SLAB, createSlabItemTable(EBlocks.PINK_CONCRETE_SLAB));

    }

    // Secondary Ore Method
    public LootTable.Builder createMultipleOreDrops(final Block block, final Item drop, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder createDoublePlantShearsOrSilkTouchDrop(final Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(this.hasShearsOrSilkTouch()).add(LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))));
    }

}
