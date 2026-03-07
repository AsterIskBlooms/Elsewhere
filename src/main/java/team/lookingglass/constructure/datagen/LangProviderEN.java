package team.lookingglass.constructure.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LangProviderEN extends FabricLanguageProvider {
    public LangProviderEN(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
        // Tab Title
        translationBuilder.add("constructure.building_tab", "ELSEWHERE: Constructure");

        // Quartz Brick Fill
        translationBuilder.add("block.constructure.quartz_brick_stairs", "Quartz Brick Stairs");
        translationBuilder.add("block.constructure.quartz_brick_slab", "Quartz Brick Slab");

        // Amethyst-Obsidian Set
        translationBuilder.add("block.constructure.amethyst_stairs", "Amethyst Stairs");
        translationBuilder.add("block.constructure.amethyst_slab", "Amethyst Slab");
        translationBuilder.add("block.constructure.amethyst_bricks", "Amethyst Bricks");
        translationBuilder.add("block.constructure.amethyst_brick_stairs", "Amethyst Brick Stairs");
        translationBuilder.add("block.constructure.amethyst_brick_slab", "Amethyst Brick Slab");
        translationBuilder.add("block.constructure.amethyst_pillar", "Amethyst Pillar");
        translationBuilder.add("block.constructure.chiseled_amethyst", "Chiseled Amethyst");

        translationBuilder.add("block.constructure.obsidian_stairs", "Obsidian Stairs");
        translationBuilder.add("block.constructure.obsidian_slab", "Obsidian Slab");
        translationBuilder.add("block.constructure.obsidian_bricks", "Obsidian Bricks");
        translationBuilder.add("block.constructure.obsidian_brick_stairs", "Obsidian Brick Stairs");
        translationBuilder.add("block.constructure.obsidian_brick_slab", "Obsidian Brick Slab");
        translationBuilder.add("block.constructure.obsidian_pillar", "Obsidian Pillar");
        translationBuilder.add("block.constructure.chiseled_obsidian", "Chiseled Obsidian");

        // Stone Sets
        translationBuilder.add("block.constructure.stone_wall", "Stone Wall");
        translationBuilder.add("block.constructure.smooth_stone_stairs", "Smooth Stone Stairs");
        translationBuilder.add("block.constructure.smooth_stone_wall", "Smooth Stone Wall");
        translationBuilder.add("block.constructure.stone_tiles", "Stone Tiles");
        translationBuilder.add("block.constructure.stone_tile_stairs", "Stone Tile Stairs");
        translationBuilder.add("block.constructure.stone_tile_slab", "Stone Tile Slab");
        translationBuilder.add("block.constructure.stone_tile_wall", "Stone Tile Wall");
        translationBuilder.add("block.constructure.mossy_stone_tiles", "Mossy Stone Tiles");
        translationBuilder.add("block.constructure.mossy_stone_tile_stairs", "Mossy Stone Tile Stairs");
        translationBuilder.add("block.constructure.mossy_stone_tile_slab", "Mossy Stone Tile Slab");
        translationBuilder.add("block.constructure.mossy_stone_tile_wall", "Mossy Stone Tile Wall");
        translationBuilder.add("block.constructure.chiseled_stone_bricks", "Chiseled Stone Bricks");
        translationBuilder.add("block.constructure.stone_pillar", "Stone Pillar");

        translationBuilder.add("block.constructure.chiseled_deepslate_bricks", "Chiseled Deepslate Bricks");
        translationBuilder.add("block.constructure.deepslate_pillar", "Deepslate Pillar");

        translationBuilder.add("block.constructure.tuff_pillar", "Tuff Pillar");

        translationBuilder.add("block.constructure.polished_andesite_wall", "Polished Andesite Wall");
        translationBuilder.add("block.constructure.andesite_bricks", "Andesite Bricks");
        translationBuilder.add("block.constructure.andesite_brick_stairs", "Andesite Brick Stairs");
        translationBuilder.add("block.constructure.andesite_brick_slab", "Andesite Brick Slab");
        translationBuilder.add("block.constructure.andesite_brick_wall", "Andesite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_andesite", "Chiseled Andesite");
        translationBuilder.add("block.constructure.chiseled_andesite_bricks", "Chiseled Andesite Bricks");
        translationBuilder.add("block.constructure.andesite_pillar", "Andesite Pillar");

        translationBuilder.add("block.constructure.polished_granite_wall", "Polished Granite Wall");
        translationBuilder.add("block.constructure.granite_bricks", "Granite Bricks");
        translationBuilder.add("block.constructure.granite_brick_stairs", "Granite Brick Stairs");
        translationBuilder.add("block.constructure.granite_brick_slab", "Granite Brick Slab");
        translationBuilder.add("block.constructure.granite_brick_wall", "Granite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_granite", "Chiseled Granite");
        translationBuilder.add("block.constructure.chiseled_granite_bricks", "Chiseled Granite Bricks");
        translationBuilder.add("block.constructure.granite_pillar", "Granite Pillar");

        translationBuilder.add("block.constructure.polished_diorite_wall", "Polished Diorite Wall");
        translationBuilder.add("block.constructure.diorite_bricks", "Diorite Bricks");
        translationBuilder.add("block.constructure.diorite_brick_stairs", "Diorite Brick Stairs");
        translationBuilder.add("block.constructure.diorite_brick_slab", "Diorite Brick Slab");
        translationBuilder.add("block.constructure.diorite_brick_wall", "Diorite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_diorite", "Chiseled Diorite");
        translationBuilder.add("block.constructure.chiseled_diorite_bricks", "Chiseled Diorite Bricks");
        translationBuilder.add("block.constructure.diorite_pillar", "Diorite Pillar");

        translationBuilder.add("block.constructure.calcite_stairs", "Calcite Stairs");
        translationBuilder.add("block.constructure.calcite_slab", "Calcite Slab");
        translationBuilder.add("block.constructure.calcite_wall", "Calcite Wall");
        translationBuilder.add("block.constructure.polished_calcite", "Polished Calcite");
        translationBuilder.add("block.constructure.polished_calcite_stairs", "Polished Calcite Stairs");
        translationBuilder.add("block.constructure.polished_calcite_slab", "Polished Calcite Slab");
        translationBuilder.add("block.constructure.polished_calcite_wall", "Polished Calcite Wall");
        translationBuilder.add("block.constructure.calcite_bricks", "Calcite Bricks");
        translationBuilder.add("block.constructure.calcite_brick_stairs", "Calcite Brick Stairs");
        translationBuilder.add("block.constructure.calcite_brick_slab", "Calcite Brick Slab");
        translationBuilder.add("block.constructure.calcite_brick_wall", "Calcite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_calcite", "Chiseled Calcite");
        translationBuilder.add("block.constructure.chiseled_calcite_bricks", "Chiseled Calcite Bricks");
        translationBuilder.add("block.constructure.calcite_pillar", "Calcite Pillar");

        translationBuilder.add("block.constructure.dripstone_stairs", "Dripstone Stairs");
        translationBuilder.add("block.constructure.dripstone_slab", "Dripstone Slab");
        translationBuilder.add("block.constructure.dripstone_wall", "Dripstone Wall");
        translationBuilder.add("block.constructure.polished_dripstone", "Polished Dripstone");
        translationBuilder.add("block.constructure.polished_dripstone_stairs", "Polished Dripstone Stairs");
        translationBuilder.add("block.constructure.polished_dripstone_slab", "Polished Dripstone Slab");
        translationBuilder.add("block.constructure.polished_dripstone_wall", "Polished Dripstone Wall");
        translationBuilder.add("block.constructure.dripstone_bricks", "Dripstone Bricks");
        translationBuilder.add("block.constructure.dripstone_brick_stairs", "Dripstone Brick Stairs");
        translationBuilder.add("block.constructure.dripstone_brick_slab", "Dripstone Brick Slab");
        translationBuilder.add("block.constructure.dripstone_brick_wall", "Dripstone Brick Wall");
        translationBuilder.add("block.constructure.chiseled_dripstone", "Chiseled Dripstone");
        translationBuilder.add("block.constructure.chiseled_dripstone_bricks", "Chiseled Dripstone Bricks");
        translationBuilder.add("block.constructure.dripstone_pillar", "Dripstone Pillar");

        translationBuilder.add("block.constructure.cut_sandstone_stairs", "Cut Sandstone Stairs");
        translationBuilder.add("block.constructure.cut_red_sandstone_stairs", "Cut Red Sandstone Stairs");









    }
}
