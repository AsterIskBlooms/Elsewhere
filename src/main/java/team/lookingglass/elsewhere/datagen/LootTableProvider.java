package team.lookingglass.elsewhere.datagen;

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

public class LootTableProvider extends FabricBlockLootSubProvider {
    public LootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }



    @Override
    public void generate() {
        // Copper Ore Changes
        add(Blocks.COPPER_ORE, createOreDrop(Blocks.COPPER_ORE, Items.RAW_COPPER));
        add(Blocks.DEEPSLATE_COPPER_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 3.0F, 5.0F));

        // Deepslate Buff
        add(Blocks.DEEPSLATE_IRON_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_GOLD_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_REDSTONE_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 5.0F, 7.0F));
        // Diamond remains unchanged as it's meant to be scarce
        add(Blocks.DEEPSLATE_LAPIS_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 6.0F, 11.0F));
        add(Blocks.DEEPSLATE_EMERALD_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 1.0F, 2.0F));

        // Shale Ores
        add(EBlocks.SHALE_COAL_ORE, createMultipleOreDrops(EBlocks.SHALE_COAL_ORE, Items.COAL, 1.0F, 2.0F));
        add(EBlocks.SHALE_COPPER_ORE, createMultipleOreDrops(EBlocks.SHALE_COPPER_ORE, Items.RAW_COPPER, 1.0F, 2.0F));
        add(EBlocks.SHALE_IRON_ORE, createOreDrop(EBlocks.SHALE_IRON_ORE, Items.RAW_IRON));
        add(EBlocks.SHALE_GOLD_ORE, createOreDrop(EBlocks.SHALE_GOLD_ORE, Items.RAW_GOLD));
        add(EBlocks.SHALE_REDSTONE_ORE, createMultipleOreDrops(EBlocks.SHALE_REDSTONE_ORE, Items.REDSTONE, 4.0F, 6.0F));
        add(EBlocks.SHALE_DIAMOND_ORE, createOreDrop(EBlocks.SHALE_DIAMOND_ORE, Items.DIAMOND));
        add(EBlocks.SHALE_LAPIS_ORE, createMultipleOreDrops(EBlocks.SHALE_LAPIS_ORE, Items.LAPIS_LAZULI, 4.0F, 9.0F));
        add(EBlocks.SHALE_EMERALD_ORE, createOreDrop(EBlocks.SHALE_EMERALD_ORE, Items.EMERALD));

        // Silver Ores
        add(EBlocks.SILVER_ORE, createOreDrop(EBlocks.SILVER_ORE, EItems.RAW_SILVER));
        add(EBlocks.SHALE_SILVER_ORE, createOreDrop(EBlocks.SHALE_SILVER_ORE, EItems.RAW_SILVER));
        add(EBlocks.DEEPSLATE_SILVER_ORE, createMultipleOreDrops(EBlocks.DEEPSLATE_SILVER_ORE, EItems.RAW_SILVER, 1.0F, 2.0F));

        add(EBlocks.CINNABAR_COAL_ORE, createMultipleOreDrops(EBlocks.CINNABAR_COAL_ORE, Items.COAL, 1.0F, 2.0F));
        add(EBlocks.CINNABAR_COPPER_ORE, createMultipleOreDrops(EBlocks.CINNABAR_COPPER_ORE, Items.RAW_COPPER, 1.0F, 2.0F));
        add(EBlocks.CINNABAR_IRON_ORE, createOreDrop(EBlocks.CINNABAR_IRON_ORE, Items.RAW_IRON));
        add(EBlocks.CINNABAR_GOLD_ORE, createOreDrop(EBlocks.CINNABAR_GOLD_ORE, Items.RAW_GOLD));
        add(EBlocks.CINNABAR_REDSTONE_ORE, createMultipleOreDrops(EBlocks.CINNABAR_REDSTONE_ORE, Items.REDSTONE, 4.0F, 6.0F));
        add(EBlocks.CINNABAR_DIAMOND_ORE, createOreDrop(EBlocks.CINNABAR_DIAMOND_ORE, Items.DIAMOND));
        add(EBlocks.CINNABAR_LAPIS_ORE, createMultipleOreDrops(EBlocks.CINNABAR_LAPIS_ORE, Items.LAPIS_LAZULI, 4.0F, 9.0F));
        add(EBlocks.CINNABAR_EMERALD_ORE, createOreDrop(EBlocks.CINNABAR_EMERALD_ORE, Items.EMERALD));


        // Quartz Brick Fill
        dropSelf(EBlocks.QUARTZ_BRICK_STAIRS);
        add(EBlocks.QUARTZ_BRICK_SLAB, createSlabItemTable(EBlocks.QUARTZ_BRICK_SLAB));

        // Amethyst-Obsidian Set
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

        dropSelf(EBlocks.ARID_DIRT);

        dropSelf(EBlocks.OAK_MOSAIC);
        dropSelf(EBlocks.OAK_MOSAIC_STAIRS);
        add(EBlocks.OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.DARK_OAK_MOSAIC);
        dropSelf(EBlocks.DARK_OAK_MOSAIC_STAIRS);
        add(EBlocks.DARK_OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.DARK_OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.PALE_OAK_MOSAIC);
        dropSelf(EBlocks.PALE_OAK_MOSAIC_STAIRS);
        add(EBlocks.PALE_OAK_MOSAIC_SLAB, createSlabItemTable(EBlocks.PALE_OAK_MOSAIC_SLAB));
        dropSelf(EBlocks.BIRCH_MOSAIC);
        dropSelf(EBlocks.BIRCH_MOSAIC_STAIRS);
        add(EBlocks.BIRCH_MOSAIC_SLAB, createSlabItemTable(EBlocks.BIRCH_MOSAIC_SLAB));
        dropSelf(EBlocks.SPRUCE_MOSAIC);
        dropSelf(EBlocks.SPRUCE_MOSAIC_STAIRS);
        add(EBlocks.SPRUCE_MOSAIC_SLAB, createSlabItemTable(EBlocks.SPRUCE_MOSAIC_SLAB));
        dropSelf(EBlocks.JUNGLE_MOSAIC);
        dropSelf(EBlocks.JUNGLE_MOSAIC_STAIRS);
        add(EBlocks.JUNGLE_MOSAIC_SLAB, createSlabItemTable(EBlocks.JUNGLE_MOSAIC_SLAB));
        dropSelf(EBlocks.ACACIA_MOSAIC);
        dropSelf(EBlocks.ACACIA_MOSAIC_STAIRS);
        add(EBlocks.ACACIA_MOSAIC_SLAB, createSlabItemTable(EBlocks.ACACIA_MOSAIC_SLAB));
        dropSelf(EBlocks.CHERRY_MOSAIC);
        dropSelf(EBlocks.CHERRY_MOSAIC_STAIRS);
        add(EBlocks.CHERRY_MOSAIC_SLAB, createSlabItemTable(EBlocks.CHERRY_MOSAIC_SLAB));
        dropSelf(EBlocks.MANGROVE_MOSAIC);
        dropSelf(EBlocks.MANGROVE_MOSAIC_STAIRS);
        add(EBlocks.MANGROVE_MOSAIC_SLAB, createSlabItemTable(EBlocks.MANGROVE_MOSAIC_SLAB));
        dropSelf(EBlocks.CRIMSON_MOSAIC);
        dropSelf(EBlocks.CRIMSON_MOSAIC_STAIRS);
        add(EBlocks.CRIMSON_MOSAIC_SLAB, createSlabItemTable(EBlocks.CRIMSON_MOSAIC_SLAB));
        dropSelf(EBlocks.WARPED_MOSAIC);
        dropSelf(EBlocks.WARPED_MOSAIC_STAIRS);
        add(EBlocks.WARPED_MOSAIC_SLAB, createSlabItemTable(EBlocks.WARPED_MOSAIC_SLAB));
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
