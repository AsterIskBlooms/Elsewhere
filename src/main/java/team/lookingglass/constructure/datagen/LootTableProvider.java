package team.lookingglass.constructure.datagen;

import team.lookingglass.constructure.registry.CBlocks;
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

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootSubProvider {
    public LootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }



    @Override
    public void generate() {
        // Copper Ore Changes
        add(Blocks.COPPER_ORE, createMultipleOreDrops(Blocks.COPPER_ORE, Items.RAW_COPPER, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_COPPER_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 2.0F, 5.0F));

        // Deepslate Buff
        add(Blocks.DEEPSLATE_IRON_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 2.0F, 3.0F));
        add(Blocks.DEEPSLATE_GOLD_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_REDSTONE_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 5.0F, 7.0F));
        add(Blocks.DEEPSLATE_DIAMOND_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_LAPIS_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 6.0F, 11.0F));
        add(Blocks.DEEPSLATE_EMERALD_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 1.0F, 2.0F));

        // Shale Ores
        add(CBlocks.SHALE_COPPER_ORE, createMultipleOreDrops(CBlocks.SHALE_COPPER_ORE, Items.RAW_COPPER, 2.0F, 3.0F));
        add(CBlocks.SHALE_IRON_ORE, createMultipleOreDrops(CBlocks.SHALE_IRON_ORE, Items.RAW_IRON, 1.0F, 2.0F));
        add(CBlocks.SHALE_GOLD_ORE, createMultipleOreDrops(CBlocks.SHALE_GOLD_ORE, Items.RAW_GOLD, 1.0F, 2.0F));
        add(CBlocks.SHALE_REDSTONE_ORE, createMultipleOreDrops(CBlocks.SHALE_REDSTONE_ORE, Items.REDSTONE, 4.0F, 6.0F));
        add(CBlocks.SHALE_DIAMOND_ORE, createOreDrop(CBlocks.SHALE_DIAMOND_ORE, Items.DIAMOND));
        add(CBlocks.SHALE_LAPIS_ORE, createMultipleOreDrops(CBlocks.SHALE_LAPIS_ORE, Items.LAPIS_LAZULI, 4.0F, 9.0F));
        add(CBlocks.SHALE_EMERALD_ORE, createMultipleOreDrops(CBlocks.SHALE_EMERALD_ORE, Items.EMERALD, 1.0F, 2.0F));


        add(CBlocks.SHALE_COAL_ORE, createMultipleOreDrops(CBlocks.SHALE_COAL_ORE, Items.COAL, 1.0F, 2.0F));


        // Quartz Brick Fill
        dropSelf(CBlocks.QUARTZ_BRICK_STAIRS);
        add(CBlocks.QUARTZ_BRICK_SLAB, createSlabItemTable(CBlocks.QUARTZ_BRICK_SLAB));

        // Amethyst-Obsidian Set
        dropSelf(CBlocks.AMETHYST_STAIRS);
        add(CBlocks.AMETHYST_SLAB, createSlabItemTable(CBlocks.AMETHYST_SLAB));
        dropSelf(CBlocks.AMETHYST_BRICKS);
        dropSelf(CBlocks.AMETHYST_BRICK_STAIRS);
        add(CBlocks.AMETHYST_BRICK_SLAB, createSlabItemTable(CBlocks.AMETHYST_BRICK_SLAB));
        dropSelf(CBlocks.AMETHYST_PILLAR);
        dropSelf(CBlocks.CHISELED_AMETHYST);

        dropSelf(CBlocks.OBSIDIAN_STAIRS);
        add(CBlocks.OBSIDIAN_SLAB, createSlabItemTable(CBlocks.OBSIDIAN_SLAB));
        dropSelf(CBlocks.OBSIDIAN_BRICKS);
        dropSelf(CBlocks.OBSIDIAN_BRICK_STAIRS);
        add(CBlocks.OBSIDIAN_BRICK_SLAB, createSlabItemTable(CBlocks.OBSIDIAN_BRICK_SLAB));
        dropSelf(CBlocks.OBSIDIAN_PILLAR);
        dropSelf(CBlocks.CHISELED_OBSIDIAN);

        dropSelf(CBlocks.STONE_WALL);
        dropSelf(CBlocks.SMOOTH_STONE_STAIRS);
        dropSelf(CBlocks.SMOOTH_STONE_WALL);
        dropSelf(CBlocks.POLISHED_STONE);
        dropSelf(CBlocks.POLISHED_STONE_STAIRS);
        add(CBlocks.POLISHED_STONE_SLAB, createSlabItemTable(CBlocks.POLISHED_STONE_SLAB));
        dropSelf(CBlocks.STONE_TILES);
        dropSelf(CBlocks.STONE_TILE_STAIRS);
        add(CBlocks.STONE_TILE_SLAB, createSlabItemTable(CBlocks.STONE_TILE_SLAB));
        dropSelf(CBlocks.STONE_TILE_WALL);
        dropSelf(CBlocks.MOSSY_STONE_TILES);
        dropSelf(CBlocks.MOSSY_STONE_TILE_STAIRS);
        add(CBlocks.MOSSY_STONE_TILE_SLAB, createSlabItemTable(CBlocks.MOSSY_STONE_TILE_SLAB));
        dropSelf(CBlocks.MOSSY_STONE_TILE_WALL);
        dropSelf(CBlocks.CHISELED_STONE);
        dropSelf(CBlocks.STONE_PILLAR);

        dropSelf(CBlocks.DEEPSLATE_STAIRS);
        dropSelf(CBlocks.DEEPSLATE_SLAB);
        dropSelf(CBlocks.DEEPSLATE_WALL);
        dropSelf(CBlocks.CHISELED_DEEPSLATE_BRICKS);
        dropSelf(CBlocks.DEEPSLATE_PILLAR);

        dropSelf(CBlocks.SMOOTH_TUFF);
        dropSelf(CBlocks.SMOOTH_TUFF_STAIRS);
        add(CBlocks.SMOOTH_TUFF_SLAB, createSlabItemTable(CBlocks.SMOOTH_TUFF_SLAB));
        dropSelf(CBlocks.SMOOTH_TUFF_WALL);
        dropSelf(CBlocks.TUFF_PILLAR);

        dropSelf(CBlocks.SMOOTH_BLACKSTONE);
        dropSelf(CBlocks.SMOOTH_BLACKSTONE_STAIRS);
        add(CBlocks.SMOOTH_BLACKSTONE_SLAB, createSlabItemTable(CBlocks.SMOOTH_BLACKSTONE_SLAB));
        dropSelf(CBlocks.SMOOTH_BLACKSTONE_WALL);
        dropSelf(CBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);
        dropSelf(CBlocks.POLISHED_BLACKSTONE_PILLAR);

        dropSelf(CBlocks.SMOOTH_ANDESITE);
        dropSelf(CBlocks.SMOOTH_ANDESITE_STAIRS);
        add(CBlocks.SMOOTH_ANDESITE_SLAB, createSlabItemTable(CBlocks.SMOOTH_ANDESITE_SLAB));
        dropSelf(CBlocks.SMOOTH_ANDESITE_WALL);
        dropSelf(CBlocks.POLISHED_ANDESITE_WALL);
        dropSelf(CBlocks.ANDESITE_BRICKS);
        dropSelf(CBlocks.ANDESITE_BRICK_STAIRS);
        add(CBlocks.ANDESITE_BRICK_SLAB, createSlabItemTable(CBlocks.ANDESITE_BRICK_SLAB));
        dropSelf(CBlocks.ANDESITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_ANDESITE);
        dropSelf(CBlocks.CHISELED_ANDESITE_BRICKS);
        dropSelf(CBlocks.ANDESITE_PILLAR);

        dropSelf(CBlocks.SMOOTH_GRANITE);
        dropSelf(CBlocks.SMOOTH_GRANITE_STAIRS);
        add(CBlocks.SMOOTH_GRANITE_SLAB, createSlabItemTable(CBlocks.SMOOTH_GRANITE_SLAB));
        dropSelf(CBlocks.SMOOTH_GRANITE_WALL);
        dropSelf(CBlocks.POLISHED_GRANITE_WALL);
        dropSelf(CBlocks.GRANITE_BRICKS);
        dropSelf(CBlocks.GRANITE_BRICK_STAIRS);
        add(CBlocks.GRANITE_BRICK_SLAB, createSlabItemTable(CBlocks.GRANITE_BRICK_SLAB));
        dropSelf(CBlocks.GRANITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_GRANITE);
        dropSelf(CBlocks.CHISELED_GRANITE_BRICKS);
        dropSelf(CBlocks.GRANITE_PILLAR);

        dropSelf(CBlocks.SMOOTH_DIORITE);
        dropSelf(CBlocks.SMOOTH_DIORITE_STAIRS);
        add(CBlocks.SMOOTH_DIORITE_SLAB, createSlabItemTable(CBlocks.SMOOTH_DIORITE_SLAB));
        dropSelf(CBlocks.SMOOTH_DIORITE_WALL);
        dropSelf(CBlocks.POLISHED_DIORITE_WALL);
        dropSelf(CBlocks.DIORITE_BRICKS);
        dropSelf(CBlocks.DIORITE_BRICK_STAIRS);
        add(CBlocks.DIORITE_BRICK_SLAB, createSlabItemTable(CBlocks.DIORITE_BRICK_SLAB));
        dropSelf(CBlocks.DIORITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_DIORITE);
        dropSelf(CBlocks.CHISELED_DIORITE_BRICKS);
        dropSelf(CBlocks.DIORITE_PILLAR);

        dropSelf(CBlocks.CALCITE_STAIRS);
        add(CBlocks.CALCITE_SLAB, createSlabItemTable(CBlocks.CALCITE_SLAB));
        dropSelf(CBlocks.CALCITE_WALL);
        dropSelf(CBlocks.SMOOTH_CALCITE);
        dropSelf(CBlocks.SMOOTH_CALCITE_STAIRS);
        add(CBlocks.SMOOTH_CALCITE_SLAB, createSlabItemTable(CBlocks.SMOOTH_CALCITE_SLAB));
        dropSelf(CBlocks.SMOOTH_CALCITE_WALL);
        dropSelf(CBlocks.POLISHED_CALCITE);
        dropSelf(CBlocks.POLISHED_CALCITE_STAIRS);
        add(CBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(CBlocks.POLISHED_CALCITE_SLAB));
        dropSelf(CBlocks.POLISHED_CALCITE_WALL);
        dropSelf(CBlocks.CALCITE_BRICKS);
        dropSelf(CBlocks.CALCITE_BRICK_STAIRS);
        add(CBlocks.CALCITE_BRICK_SLAB, createSlabItemTable(CBlocks.CALCITE_BRICK_SLAB));
        dropSelf(CBlocks.CALCITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_CALCITE);
        dropSelf(CBlocks.CHISELED_CALCITE_BRICKS);
        dropSelf(CBlocks.CALCITE_PILLAR);

        dropSelf(CBlocks.DRIPSTONE_STAIRS);
        add(CBlocks.DRIPSTONE_SLAB, createSlabItemTable(CBlocks.DRIPSTONE_SLAB));
        dropSelf(CBlocks.DRIPSTONE_WALL);
        dropSelf(CBlocks.SMOOTH_DRIPSTONE);
        dropSelf(CBlocks.SMOOTH_DRIPSTONE_STAIRS);
        add(CBlocks.SMOOTH_DRIPSTONE_SLAB, createSlabItemTable(CBlocks.SMOOTH_DRIPSTONE_SLAB));
        dropSelf(CBlocks.SMOOTH_DRIPSTONE_WALL);
        dropSelf(CBlocks.POLISHED_DRIPSTONE);
        dropSelf(CBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(CBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(CBlocks.POLISHED_DRIPSTONE_SLAB));
        dropSelf(CBlocks.POLISHED_DRIPSTONE_WALL);
        dropSelf(CBlocks.DRIPSTONE_BRICKS);
        dropSelf(CBlocks.DRIPSTONE_BRICK_STAIRS);
        add(CBlocks.DRIPSTONE_BRICK_SLAB, createSlabItemTable(CBlocks.DRIPSTONE_BRICK_SLAB));
        dropSelf(CBlocks.DRIPSTONE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_DRIPSTONE);
        dropSelf(CBlocks.CHISELED_DRIPSTONE_BRICKS);
        dropSelf(CBlocks.DRIPSTONE_PILLAR);

        dropSelf(CBlocks.POLISHED_SANDSTONE);
        dropSelf(CBlocks.POLISHED_SANDSTONE_STAIRS);
        add(CBlocks.POLISHED_SANDSTONE_SLAB, createSlabItemTable(CBlocks.POLISHED_SANDSTONE_SLAB));
        dropSelf(CBlocks.POLISHED_SANDSTONE_WALL);
        dropSelf(CBlocks.POLISHED_RED_SANDSTONE);
        dropSelf(CBlocks.POLISHED_RED_SANDSTONE_STAIRS);
        add(CBlocks.POLISHED_RED_SANDSTONE_SLAB, createSlabItemTable(CBlocks.POLISHED_RED_SANDSTONE_SLAB));
        dropSelf(CBlocks.POLISHED_RED_SANDSTONE_WALL);
        dropSelf(CBlocks.SANDSTONE_BRICKS);
        dropSelf(CBlocks.SANDSTONE_BRICK_STAIRS);
        add(CBlocks.SANDSTONE_BRICK_SLAB, createSlabItemTable(CBlocks.SANDSTONE_BRICK_SLAB));
        dropSelf(CBlocks.SANDSTONE_BRICK_WALL);
        dropSelf(CBlocks.RED_SANDSTONE_BRICKS);
        dropSelf(CBlocks.RED_SANDSTONE_BRICK_STAIRS);
        add(CBlocks.RED_SANDSTONE_BRICK_SLAB, createSlabItemTable(CBlocks.RED_SANDSTONE_BRICK_SLAB));
        dropSelf(CBlocks.RED_SANDSTONE_BRICK_WALL);
        dropSelf(CBlocks.CUT_RED_SANDSTONE_WALL);
        dropSelf(CBlocks.CUT_RED_SANDSTONE_WALL);
        dropSelf(CBlocks.CUT_SANDSTONE_STAIRS);
        dropSelf(CBlocks.CUT_RED_SANDSTONE_STAIRS);
        dropSelf(CBlocks.CUT_SANDSTONE_WALL);
        dropSelf(CBlocks.CUT_RED_SANDSTONE_WALL);

        dropSelf(CBlocks.SMOOTH_PRISMARINE);
        dropSelf(CBlocks.SMOOTH_PRISMARINE_STAIRS);
        add(CBlocks.SMOOTH_PRISMARINE_SLAB, createSlabItemTable(CBlocks.SMOOTH_PRISMARINE_SLAB));
        dropSelf(CBlocks.SMOOTH_PRISMARINE_WALL);
        dropSelf(CBlocks.POLISHED_PRISMARINE);
        dropSelf(CBlocks.POLISHED_PRISMARINE_STAIRS);
        add(CBlocks.POLISHED_PRISMARINE_SLAB, createSlabItemTable(CBlocks.POLISHED_PRISMARINE_SLAB));
        dropSelf(CBlocks.POLISHED_PRISMARINE_WALL);
        dropSelf(CBlocks.PRISMARINE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_PRISMARINE);
        dropSelf(CBlocks.CHISELED_PRISMARINE_BRICKS);
        dropSelf(CBlocks.PRISMARINE_PILLAR);

        dropSelf(CBlocks.DARK_PRISMARINE_WALL);
        dropSelf(CBlocks.SMOOTH_DARK_PRISMARINE);
        dropSelf(CBlocks.SMOOTH_DARK_PRISMARINE_STAIRS);
        add(CBlocks.SMOOTH_DARK_PRISMARINE_SLAB, createSlabItemTable(CBlocks.SMOOTH_DARK_PRISMARINE_SLAB));
        dropSelf(CBlocks.SMOOTH_DARK_PRISMARINE_WALL);
        dropSelf(CBlocks.POLISHED_DARK_PRISMARINE);
        dropSelf(CBlocks.POLISHED_DARK_PRISMARINE_STAIRS);
        add(CBlocks.POLISHED_DARK_PRISMARINE_SLAB, createSlabItemTable(CBlocks.POLISHED_DARK_PRISMARINE_SLAB));
        dropSelf(CBlocks.POLISHED_DARK_PRISMARINE_WALL);
        dropSelf(CBlocks.DARK_PRISMARINE_BRICKS);
        dropSelf(CBlocks.DARK_PRISMARINE_BRICK_STAIRS);
        add(CBlocks.DARK_PRISMARINE_BRICK_SLAB, createSlabItemTable(CBlocks.DARK_PRISMARINE_BRICK_SLAB));
        dropSelf(CBlocks.DARK_PRISMARINE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_DARK_PRISMARINE);
        dropSelf(CBlocks.CHISELED_DARK_PRISMARINE_BRICKS);
        dropSelf(CBlocks.DARK_PRISMARINE_PILLAR);

        dropSelf(CBlocks.BASALT_STAIRS);
        add(CBlocks.BASALT_SLAB, createSlabItemTable(CBlocks.BASALT_SLAB));
        dropSelf(CBlocks.BASALT_WALL);
        dropSelf(CBlocks.SMOOTH_BASALT_STAIRS);
        add(CBlocks.SMOOTH_BASALT_SLAB, createSlabItemTable(CBlocks.SMOOTH_BASALT_SLAB));
        dropSelf(CBlocks.SMOOTH_BASALT_WALL);
        dropSelf(CBlocks.POLISHED_BASALT_STAIRS);
        add(CBlocks.POLISHED_BASALT_SLAB, createSlabItemTable(CBlocks.POLISHED_BASALT_SLAB));
        dropSelf(CBlocks.POLISHED_BASALT_WALL);
        dropSelf(CBlocks.BASALT_BRICKS);
        dropSelf(CBlocks.BASALT_BRICK_STAIRS);
        add(CBlocks.BASALT_BRICK_SLAB, createSlabItemTable(CBlocks.BASALT_BRICK_SLAB));
        dropSelf(CBlocks.BASALT_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_BASALT);
        dropSelf(CBlocks.CHISELED_BASALT_BRICKS);
        dropSelf(CBlocks.BASALT_PILLAR);

        dropSelf(CBlocks.END_STONE_STAIRS);
        add(CBlocks.END_STONE_SLAB, createSlabItemTable(CBlocks.END_STONE_SLAB));
        dropSelf(CBlocks.END_STONE_WALL);
        dropSelf(CBlocks.SMOOTH_END_STONE);
        dropSelf(CBlocks.SMOOTH_END_STONE_STAIRS);
        add(CBlocks.SMOOTH_END_STONE_SLAB, createSlabItemTable(CBlocks.SMOOTH_END_STONE_SLAB));
        dropSelf(CBlocks.SMOOTH_END_STONE_WALL);
        dropSelf(CBlocks.POLISHED_END_STONE);
        dropSelf(CBlocks.POLISHED_END_STONE_STAIRS);
        add(CBlocks.POLISHED_END_STONE_SLAB, createSlabItemTable(CBlocks.POLISHED_END_STONE_SLAB));
        dropSelf(CBlocks.POLISHED_END_STONE_WALL);
        dropSelf(CBlocks.CHISELED_END_STONE);
        dropSelf(CBlocks.CHISELED_END_STONE_BRICKS);
        dropSelf(CBlocks.END_STONE_PILLAR);

        dropSelf(CBlocks.SODALITE);
        dropSelf(CBlocks.SODALITE_STAIRS);
        add(CBlocks.SODALITE_SLAB, createSlabItemTable(CBlocks.SODALITE_SLAB));
        dropSelf(CBlocks.SODALITE_WALL);
        dropSelf(CBlocks.SMOOTH_SODALITE);
        dropSelf(CBlocks.SMOOTH_SODALITE_STAIRS);
        add(CBlocks.SMOOTH_SODALITE_SLAB, createSlabItemTable(CBlocks.SMOOTH_SODALITE_SLAB));
        dropSelf(CBlocks.SMOOTH_SODALITE_WALL);
        dropSelf(CBlocks.POLISHED_SODALITE);
        dropSelf(CBlocks.POLISHED_SODALITE_STAIRS);
        add(CBlocks.POLISHED_SODALITE_SLAB, createSlabItemTable(CBlocks.POLISHED_SODALITE_SLAB));
        dropSelf(CBlocks.POLISHED_SODALITE_WALL);
        dropSelf(CBlocks.SODALITE_BRICKS);
        dropSelf(CBlocks.SODALITE_BRICK_STAIRS);
        add(CBlocks.SODALITE_BRICK_SLAB, createSlabItemTable(CBlocks.SODALITE_BRICK_SLAB));
        dropSelf(CBlocks.SODALITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_SODALITE);
        dropSelf(CBlocks.CHISELED_SODALITE_BRICKS);
        dropSelf(CBlocks.SODALITE_PILLAR);

        add(CBlocks.SHALE, createSingleItemTableWithSilkTouch(CBlocks.SHALE, CBlocks.COBBLESHALE));
        dropSelf(CBlocks.SHALE_STAIRS);
        add(CBlocks.SHALE_SLAB, createSlabItemTable(CBlocks.SHALE_SLAB));
        dropSelf(CBlocks.SHALE_WALL);
        dropSelf(CBlocks.SMOOTH_SHALE);
        dropSelf(CBlocks.SMOOTH_SHALE_STAIRS);
        add(CBlocks.SMOOTH_SHALE_SLAB, createSlabItemTable(CBlocks.SMOOTH_SHALE_SLAB));
        dropSelf(CBlocks.SMOOTH_SHALE_WALL);
        dropSelf(CBlocks.POLISHED_SHALE);
        dropSelf(CBlocks.POLISHED_SHALE_STAIRS);
        add(CBlocks.POLISHED_SHALE_SLAB, createSlabItemTable(CBlocks.POLISHED_SHALE_SLAB));
        dropSelf(CBlocks.POLISHED_SHALE_WALL);
        dropSelf(CBlocks.SHALE_BRICKS);
        dropSelf(CBlocks.SHALE_BRICK_STAIRS);
        add(CBlocks.SHALE_BRICK_SLAB, createSlabItemTable(CBlocks.SHALE_BRICK_SLAB));
        dropSelf(CBlocks.SHALE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_SHALE);
        dropSelf(CBlocks.CHISELED_SHALE_BRICKS);
        dropSelf(CBlocks.SHALE_PILLAR);
        dropSelf(CBlocks.COBBLESHALE);
        dropSelf(CBlocks.COBBLESHALE_STAIRS);
        add(CBlocks.COBBLESHALE_SLAB, createSlabItemTable(CBlocks.COBBLESHALE_SLAB));
        dropSelf(CBlocks.COBBLESHALE_WALL);
        dropSelf(CBlocks.SHALE_TILES);
        dropSelf(CBlocks.SHALE_TILE_STAIRS);
        add(CBlocks.SHALE_TILE_SLAB, createSlabItemTable(CBlocks.SHALE_TILE_SLAB));
        dropSelf(CBlocks.SHALE_TILE_WALL);

        dropSelf(CBlocks.CHISELED_PURPUR);

        dropSelf(CBlocks.OAK_MOSAIC);
        dropSelf(CBlocks.OAK_MOSAIC_STAIRS);
        add(CBlocks.OAK_MOSAIC_SLAB, createSlabItemTable(CBlocks.OAK_MOSAIC_SLAB));
        dropSelf(CBlocks.DARK_OAK_MOSAIC);
        dropSelf(CBlocks.DARK_OAK_MOSAIC_STAIRS);
        add(CBlocks.DARK_OAK_MOSAIC_SLAB, createSlabItemTable(CBlocks.DARK_OAK_MOSAIC_SLAB));
        dropSelf(CBlocks.PALE_OAK_MOSAIC);
        dropSelf(CBlocks.PALE_OAK_MOSAIC_STAIRS);
        add(CBlocks.PALE_OAK_MOSAIC_SLAB, createSlabItemTable(CBlocks.PALE_OAK_MOSAIC_SLAB));
        dropSelf(CBlocks.BIRCH_MOSAIC);
        dropSelf(CBlocks.BIRCH_MOSAIC_STAIRS);
        add(CBlocks.BIRCH_MOSAIC_SLAB, createSlabItemTable(CBlocks.BIRCH_MOSAIC_SLAB));
        dropSelf(CBlocks.SPRUCE_MOSAIC);
        dropSelf(CBlocks.SPRUCE_MOSAIC_STAIRS);
        add(CBlocks.SPRUCE_MOSAIC_SLAB, createSlabItemTable(CBlocks.SPRUCE_MOSAIC_SLAB));
        dropSelf(CBlocks.JUNGLE_MOSAIC);
        dropSelf(CBlocks.JUNGLE_MOSAIC_STAIRS);
        add(CBlocks.JUNGLE_MOSAIC_SLAB, createSlabItemTable(CBlocks.JUNGLE_MOSAIC_SLAB));
        dropSelf(CBlocks.ACACIA_MOSAIC);
        dropSelf(CBlocks.ACACIA_MOSAIC_STAIRS);
        add(CBlocks.ACACIA_MOSAIC_SLAB, createSlabItemTable(CBlocks.ACACIA_MOSAIC_SLAB));
        dropSelf(CBlocks.CHERRY_MOSAIC);
        dropSelf(CBlocks.CHERRY_MOSAIC_STAIRS);
        add(CBlocks.CHERRY_MOSAIC_SLAB, createSlabItemTable(CBlocks.CHERRY_MOSAIC_SLAB));
        dropSelf(CBlocks.MANGROVE_MOSAIC);
        dropSelf(CBlocks.MANGROVE_MOSAIC_STAIRS);
        add(CBlocks.MANGROVE_MOSAIC_SLAB, createSlabItemTable(CBlocks.MANGROVE_MOSAIC_SLAB));
        dropSelf(CBlocks.CRIMSON_MOSAIC);
        dropSelf(CBlocks.CRIMSON_MOSAIC_STAIRS);
        add(CBlocks.CRIMSON_MOSAIC_SLAB, createSlabItemTable(CBlocks.CRIMSON_MOSAIC_SLAB));
        dropSelf(CBlocks.WARPED_MOSAIC);
        dropSelf(CBlocks.WARPED_MOSAIC_STAIRS);
        add(CBlocks.WARPED_MOSAIC_SLAB, createSlabItemTable(CBlocks.WARPED_MOSAIC_SLAB));
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

}
