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
        translationBuilder.add("ecological.tab", "Ecological");

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
        translationBuilder.add("block.constructure.polished_stone", "Polished Stone");
        translationBuilder.add("block.constructure.polished_stone_stairs", "Polished Stone Stairs");
        translationBuilder.add("block.constructure.polished_stone_slab", "Polished Stone Slab");
        translationBuilder.add("block.constructure.polished_stone_wall", "Polished Stone Wall");
        translationBuilder.add("block.constructure.stone_tiles", "Stone Tiles");
        translationBuilder.add("block.constructure.stone_tile_stairs", "Stone Tile Stairs");
        translationBuilder.add("block.constructure.stone_tile_slab", "Stone Tile Slab");
        translationBuilder.add("block.constructure.stone_tile_wall", "Stone Tile Wall");
        translationBuilder.add("block.constructure.mossy_stone_tiles", "Mossy Stone Tiles");
        translationBuilder.add("block.constructure.mossy_stone_tile_stairs", "Mossy Stone Tile Stairs");
        translationBuilder.add("block.constructure.mossy_stone_tile_slab", "Mossy Stone Tile Slab");
        translationBuilder.add("block.constructure.mossy_stone_tile_wall", "Mossy Stone Tile Wall");
        translationBuilder.add("block.constructure.chiseled_stone", "Chiseled Stone");
        translationBuilder.add("block.constructure.stone_pillar", "Stone Pillar");

        translationBuilder.add("block.constructure.deepslate_stairs", "Deepslate Stairs");
        translationBuilder.add("block.constructure.deepslate_slab", "Deepslate Slab");
        translationBuilder.add("block.constructure.deepslate_wall", "Deepslate Wall");
        translationBuilder.add("block.constructure.smooth_deepslate", "Smooth Deepslate");
        translationBuilder.add("block.constructure.smooth_deepslate_stairs", "Smooth Deepslate Stairs");
        translationBuilder.add("block.constructure.smooth_deepslate_slab", "Smooth Deepslate Slab");
        translationBuilder.add("block.constructure.smooth_deepslate_wall", "Smooth Deepslate Wall");
        translationBuilder.add("block.constructure.chiseled_deepslate_bricks", "Chiseled Deepslate Bricks");
        translationBuilder.add("block.constructure.deepslate_pillar", "Deepslate Pillar");

        translationBuilder.add("block.constructure.smooth_tuff", "Smooth Tuff");
        translationBuilder.add("block.constructure.smooth_tuff_stairs", "Smooth Tuff Stairs");
        translationBuilder.add("block.constructure.smooth_tuff_slab", "Smooth Tuff Slab");
        translationBuilder.add("block.constructure.smooth_tuff_wall", "Smooth Tuff Wall");
        translationBuilder.add("block.constructure.tuff_pillar", "Tuff Pillar");

        translationBuilder.add("block.constructure.smooth_blackstone", "Smooth Blackstone");
        translationBuilder.add("block.constructure.smooth_blackstone_stairs", "Smooth Blackstone Stairs");
        translationBuilder.add("block.constructure.smooth_blackstone_slab", "Smooth Blackstone Slab");
        translationBuilder.add("block.constructure.smooth_blackstone_wall", "Smooth Blackstone Wall");
        translationBuilder.add("block.constructure.chiseled_polished_blackstone_bricks", "Chiseled Polished Blackstone Bricks");
        translationBuilder.add("block.constructure.polished_blackstone_pillar", "Polished Blackstone Pillar");

        translationBuilder.add("block.constructure.polished_andesite_wall", "Polished Andesite Wall");
        translationBuilder.add("block.constructure.smooth_andesite", "Smooth Andesite");
        translationBuilder.add("block.constructure.smooth_andesite_stairs", "Smooth Andesite Stairs");
        translationBuilder.add("block.constructure.smooth_andesite_slab", "Smooth Andesite Slab");
        translationBuilder.add("block.constructure.smooth_andesite_wall", "Smooth Andesite Wall");
        translationBuilder.add("block.constructure.andesite_bricks", "Andesite Bricks");
        translationBuilder.add("block.constructure.andesite_brick_stairs", "Andesite Brick Stairs");
        translationBuilder.add("block.constructure.andesite_brick_slab", "Andesite Brick Slab");
        translationBuilder.add("block.constructure.andesite_brick_wall", "Andesite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_andesite", "Chiseled Andesite");
        translationBuilder.add("block.constructure.chiseled_andesite_bricks", "Chiseled Andesite Bricks");
        translationBuilder.add("block.constructure.andesite_pillar", "Andesite Pillar");

        translationBuilder.add("block.constructure.polished_granite_wall", "Polished Granite Wall");
        translationBuilder.add("block.constructure.smooth_granite", "Smooth Granite");
        translationBuilder.add("block.constructure.smooth_granite_stairs", "Smooth Granite Stairs");
        translationBuilder.add("block.constructure.smooth_granite_slab", "Smooth Granite Slab");
        translationBuilder.add("block.constructure.smooth_granite_wall", "Smooth Granite Wall");
        translationBuilder.add("block.constructure.granite_bricks", "Granite Bricks");
        translationBuilder.add("block.constructure.granite_brick_stairs", "Granite Brick Stairs");
        translationBuilder.add("block.constructure.granite_brick_slab", "Granite Brick Slab");
        translationBuilder.add("block.constructure.granite_brick_wall", "Granite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_granite", "Chiseled Granite");
        translationBuilder.add("block.constructure.chiseled_granite_bricks", "Chiseled Granite Bricks");
        translationBuilder.add("block.constructure.granite_pillar", "Granite Pillar");

        translationBuilder.add("block.constructure.polished_diorite_wall", "Polished Diorite Wall");
        translationBuilder.add("block.constructure.smooth_diorite", "Smooth Diorite");
        translationBuilder.add("block.constructure.smooth_diorite_stairs", "Smooth Diorite Stairs");
        translationBuilder.add("block.constructure.smooth_diorite_slab", "Smooth Diorite Slab");
        translationBuilder.add("block.constructure.smooth_diorite_wall", "Smooth Diorite Wall");
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
        translationBuilder.add("block.constructure.smooth_calcite", "Smooth Calcite");
        translationBuilder.add("block.constructure.smooth_calcite_stairs", "Smooth Calcite Stairs");
        translationBuilder.add("block.constructure.smooth_calcite_slab", "Smooth Calcite Slab");
        translationBuilder.add("block.constructure.smooth_calcite_wall", "Smooth Calcite Wall");
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
        translationBuilder.add("block.constructure.smooth_dripstone", "Smooth Dripstone");
        translationBuilder.add("block.constructure.smooth_dripstone_stairs", "Smooth Dripstone Stairs");
        translationBuilder.add("block.constructure.smooth_dripstone_slab", "Smooth Dripstone Slab");
        translationBuilder.add("block.constructure.smooth_dripstone_wall", "Smooth Dripstone Wall");
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

        translationBuilder.add("block.constructure.polished_sandstone", "Polished Sandstone");
        translationBuilder.add("block.constructure.polished_sandstone_stairs", "Polished Sandstone Stairs");
        translationBuilder.add("block.constructure.polished_sandstone_slab", "Polished Sandstone Slab");
        translationBuilder.add("block.constructure.polished_sandstone_wall", "Polished Sandstone Wall");
        translationBuilder.add("block.constructure.polished_red_sandstone", "Polished Red Sandstone");
        translationBuilder.add("block.constructure.polished_red_sandstone_stairs", "Polished Red Sandstone Stairs");
        translationBuilder.add("block.constructure.polished_red_sandstone_slab", "Polished Red Sandstone Slab");
        translationBuilder.add("block.constructure.polished_red_sandstone_wall", "Polished Red Sandstone Wall");

        translationBuilder.add("block.constructure.sandstone_bricks", "Sandstone Bricks");
        translationBuilder.add("block.constructure.sandstone_brick_stairs", "Sandstone Brick Stairs");
        translationBuilder.add("block.constructure.sandstone_brick_slab", "Sandstone Brick Slab");
        translationBuilder.add("block.constructure.sandstone_brick_wall", "Sandstone Brick Wall");
        translationBuilder.add("block.constructure.red_sandstone_bricks", "Red Sandstone Bricks");
        translationBuilder.add("block.constructure.red_sandstone_brick_stairs", "Red Sandstone Brick Stairs");
        translationBuilder.add("block.constructure.red_sandstone_brick_slab", "Red Sandstone Brick Slab");
        translationBuilder.add("block.constructure.red_sandstone_brick_wall", "Red Sandstone Brick Wall");

        translationBuilder.add("block.constructure.smooth_sandstone_wall", "Smooth Sandstone Wall");
        translationBuilder.add("block.constructure.smooth_red_sandstone_wall", "Smooth Red Sandstone Wall");

        translationBuilder.add("block.constructure.cut_sandstone_stairs", "Cut Sandstone Stairs");
        translationBuilder.add("block.constructure.cut_sandstone_wall", "Cut Sandstone Wall");
        translationBuilder.add("block.constructure.cut_red_sandstone_stairs", "Cut Red Sandstone Stairs");
        translationBuilder.add("block.constructure.cut_red_sandstone_wall", "Cut Red Sandstone Wall");

        translationBuilder.add("block.constructure.smooth_prismarine", "Smooth Prismarine");
        translationBuilder.add("block.constructure.smooth_prismarine_stairs", "Smooth Prismarine Stairs");
        translationBuilder.add("block.constructure.smooth_prismarine_slab", "Smooth Prismarine Slab");
        translationBuilder.add("block.constructure.smooth_prismarine_wall", "Smooth Prismarine Wall");
        translationBuilder.add("block.constructure.polished_prismarine", "Polished Prismarine");
        translationBuilder.add("block.constructure.polished_prismarine_stairs", "Polished Prismarine Stairs");
        translationBuilder.add("block.constructure.polished_prismarine_slab", "Polished Prismarine Slab");
        translationBuilder.add("block.constructure.polished_prismarine_wall", "Polished Prismarine Wall");
        translationBuilder.add("block.constructure.prismarine_brick_wall", "Prismarine Brick Wall");
        translationBuilder.add("block.constructure.chiseled_prismarine", "Chiseled Prismarine");
        translationBuilder.add("block.constructure.chiseled_prismarine_bricks", "Chiseled Prismarine Bricks");
        translationBuilder.add("block.constructure.prismarine_pillar", "Prismarine Pillar");

        translationBuilder.add("block.constructure.dark_prismarine_wall", "Dark Prismarine Wall");
        translationBuilder.add("block.constructure.smooth_dark_prismarine", "Smooth Dark Prismarine");
        translationBuilder.add("block.constructure.smooth_dark_prismarine_stairs", "Smooth Dark Prismarine Stairs");
        translationBuilder.add("block.constructure.smooth_dark_prismarine_slab", "Smooth Dark Prismarine Slab");
        translationBuilder.add("block.constructure.smooth_dark_prismarine_wall", "Smooth Dark Prismarine Wall");
        translationBuilder.add("block.constructure.polished_dark_prismarine", "Polished Dark Prismarine");
        translationBuilder.add("block.constructure.polished_dark_prismarine_stairs", "Polished Dark Prismarine Stairs");
        translationBuilder.add("block.constructure.polished_dark_prismarine_slab", "Polished Dark Prismarine Slab");
        translationBuilder.add("block.constructure.polished_dark_prismarine_wall", "Polished Dark Prismarine Wall");
        translationBuilder.add("block.constructure.dark_prismarine_bricks", "Dark Prismarine Bricks");
        translationBuilder.add("block.constructure.dark_prismarine_brick_stairs", "Dark Prismarine Brick Stairs");
        translationBuilder.add("block.constructure.dark_prismarine_brick_slab", "Dark Prismarine Brick Slab");
        translationBuilder.add("block.constructure.dark_prismarine_brick_wall", "Dark Prismarine Brick Wall");
        translationBuilder.add("block.constructure.chiseled_dark_prismarine", "Chiseled Dark Prismarine");
        translationBuilder.add("block.constructure.chiseled_dark_prismarine_bricks", "Chiseled Dark Prismarine Bricks");
        translationBuilder.add("block.constructure.dark_prismarine_pillar", "Dark Prismarine Pillar");

        translationBuilder.add("block.constructure.basalt_stairs", "Basalt Stairs");
        translationBuilder.add("block.constructure.basalt_slab", "Basalt Slab");
        translationBuilder.add("block.constructure.basalt_wall", "Basalt Wall");
        translationBuilder.add("block.constructure.smooth_basalt_stairs", "Smooth Basalt Stairs");
        translationBuilder.add("block.constructure.smooth_basalt_slab", "Smooth Basalt Slab");
        translationBuilder.add("block.constructure.smooth_basalt_wall", "Smooth Basalt Wall");
        translationBuilder.add("block.constructure.polished_basalt_stairs", "Polished Basalt Stairs");
        translationBuilder.add("block.constructure.polished_basalt_slab", "Polished Basalt Slab");
        translationBuilder.add("block.constructure.polished_basalt_wall", "Polished Basalt Wall");
        translationBuilder.add("block.constructure.basalt_bricks", "Basalt Bricks");
        translationBuilder.add("block.constructure.basalt_brick_stairs", "Basalt Brick Stairs");
        translationBuilder.add("block.constructure.basalt_brick_slab", "Basalt Brick Slab");
        translationBuilder.add("block.constructure.basalt_brick_wall", "Basalt Brick Wall");
        translationBuilder.add("block.constructure.chiseled_basalt", "Chiseled Basalt");
        translationBuilder.add("block.constructure.chiseled_basalt_bricks", "Chiseled Basalt Bricks");
        translationBuilder.add("block.constructure.basalt_pillar", "Basalt Pillar");

        translationBuilder.add("block.constructure.end_stone_stairs", "End Stone Stairs");
        translationBuilder.add("block.constructure.end_stone_slab", "End Stone Slab");
        translationBuilder.add("block.constructure.end_stone_wall", "End Stone Wall");
        translationBuilder.add("block.constructure.smooth_end_stone", "Smooth End Stone");
        translationBuilder.add("block.constructure.smooth_end_stone_stairs", "Smooth End Stone Stairs");
        translationBuilder.add("block.constructure.smooth_end_stone_slab", "Smooth End Stone Slab");
        translationBuilder.add("block.constructure.smooth_end_stone_wall", "Smooth End Stone Wall");
        translationBuilder.add("block.constructure.polished_end_stone", "Polished End Stone");
        translationBuilder.add("block.constructure.polished_end_stone_stairs", "Polished End Stone Stairs");
        translationBuilder.add("block.constructure.polished_end_stone_slab", "Polished End Stone Slab");
        translationBuilder.add("block.constructure.polished_end_stone_wall", "Polished End Stone Wall");
        translationBuilder.add("block.constructure.chiseled_end_stone", "Chiseled End Stone");
        translationBuilder.add("block.constructure.chiseled_end_stone_bricks", "Chiseled End Stone Bricks");
        translationBuilder.add("block.constructure.end_stone_pillar", "End Stone Pillar");

        translationBuilder.add("block.constructure.sodalite", "Sodalite");
        translationBuilder.add("block.constructure.sodalite_stairs", "Sodalite Stairs");
        translationBuilder.add("block.constructure.sodalite_slab", "Sodalite Slab");
        translationBuilder.add("block.constructure.sodalite_wall", "Sodalite Wall");
        translationBuilder.add("block.constructure.smooth_sodalite", "Smooth Sodalite");
        translationBuilder.add("block.constructure.smooth_sodalite_stairs", "Smooth Sodalite Stairs");
        translationBuilder.add("block.constructure.smooth_sodalite_slab", "Smooth Sodalite Slab");
        translationBuilder.add("block.constructure.smooth_sodalite_wall", "Smooth Sodalite Wall");
        translationBuilder.add("block.constructure.polished_sodalite", "Polished Sodalite");
        translationBuilder.add("block.constructure.polished_sodalite_stairs", "Polished Sodalite Stairs");
        translationBuilder.add("block.constructure.polished_sodalite_slab", "Polished Sodalite Slab");
        translationBuilder.add("block.constructure.polished_sodalite_wall", "Polished Sodalite Wall");
        translationBuilder.add("block.constructure.sodalite_bricks", "Sodalite Bricks");
        translationBuilder.add("block.constructure.sodalite_brick_stairs", "Sodalite Brick Stairs");
        translationBuilder.add("block.constructure.sodalite_brick_slab", "Sodalite Brick Slab");
        translationBuilder.add("block.constructure.sodalite_brick_wall", "Sodalite Brick Wall");
        translationBuilder.add("block.constructure.chiseled_sodalite", "Chiseled Sodalite");
        translationBuilder.add("block.constructure.chiseled_sodalite_bricks", "Chiseled Sodalite Bricks");
        translationBuilder.add("block.constructure.sodalite_pillar", "Sodalite Pillar");

        translationBuilder.add("block.constructure.shale", "Shale");
        translationBuilder.add("block.constructure.shale_stairs", "Shale Stairs");
        translationBuilder.add("block.constructure.shale_slab", "Shale Slab");
        translationBuilder.add("block.constructure.shale_wall", "Shale Wall");
        translationBuilder.add("block.constructure.smooth_shale", "Smooth Shale");
        translationBuilder.add("block.constructure.smooth_shale_stairs", "Smooth Shale Stairs");
        translationBuilder.add("block.constructure.smooth_shale_slab", "Smooth Shale Slab");
        translationBuilder.add("block.constructure.smooth_shale_wall", "Smooth Shale Wall");
        translationBuilder.add("block.constructure.polished_shale", "Polished Shale");
        translationBuilder.add("block.constructure.polished_shale_stairs", "Polished Shale Stairs");
        translationBuilder.add("block.constructure.polished_shale_slab", "Polished Shale Slab");
        translationBuilder.add("block.constructure.polished_shale_wall", "Polished Shale Wall");
        translationBuilder.add("block.constructure.shale_bricks", "Shale Bricks");
        translationBuilder.add("block.constructure.shale_brick_stairs", "Shale Brick Stairs");
        translationBuilder.add("block.constructure.shale_brick_slab", "Shale Brick Slab");
        translationBuilder.add("block.constructure.shale_brick_wall", "Shale Brick Wall");
        translationBuilder.add("block.constructure.chiseled_shale", "Chiseled Shale");
        translationBuilder.add("block.constructure.chiseled_shale_bricks", "Chiseled Shale Bricks");
        translationBuilder.add("block.constructure.shale_pillar", "Shale Pillar");
        translationBuilder.add("block.constructure.cobbleshale", "Cobbleshale");
        translationBuilder.add("block.constructure.cobbleshale_stairs", "Cobbleshale Stairs");
        translationBuilder.add("block.constructure.cobbleshale_slab", "Cobbleshale Slab");
        translationBuilder.add("block.constructure.cobbleshale_wall", "Cobbleshale Wall");
        translationBuilder.add("block.constructure.shale_tiles", "Shale Tiles");
        translationBuilder.add("block.constructure.shale_tile_stairs", "Shale Tile Stairs");
        translationBuilder.add("block.constructure.shale_tile_slab", "Shale Tile Slab");
        translationBuilder.add("block.constructure.shale_tile_wall", "Shale Tile Wall");

        translationBuilder.add("block.constructure.shale_coal_ore", "Shale Coal Ore");
        translationBuilder.add("block.constructure.shale_copper_ore", "Shale Copper Ore");
        translationBuilder.add("block.constructure.shale_iron_ore", "Shale Iron Ore");
        translationBuilder.add("block.constructure.shale_gold_ore", "Shale Gold Ore");
        translationBuilder.add("block.constructure.shale_redstone_ore", "Shale Redstone Ore");
        translationBuilder.add("block.constructure.shale_diamond_ore", "Shale Diamond Ore");
        translationBuilder.add("block.constructure.shale_lapis_ore", "Shale Lapis Lazuli Ore");
        translationBuilder.add("block.constructure.shale_emerald_ore", "Shale Emerald Ore");

        translationBuilder.add("block.constructure.chiseled_purpur", "Chiseled Purpur");



        translationBuilder.add("block.constructure.oak_mosaic", "Oak Mosaic");
        translationBuilder.add("block.constructure.oak_mosaic_stairs", "Oak Mosaic Stairs");
        translationBuilder.add("block.constructure.oak_mosaic_slab", "Oak Mosaic Slab");

        translationBuilder.add("block.constructure.dark_oak_mosaic", "Dark Oak Mosaic");
        translationBuilder.add("block.constructure.dark_oak_mosaic_stairs", "Dark Oak Mosaic Stairs");
        translationBuilder.add("block.constructure.dark_oak_mosaic_slab", "Dark Oak Mosaic Slab");

        translationBuilder.add("block.constructure.pale_oak_mosaic", "Pale Oak Mosaic");
        translationBuilder.add("block.constructure.pale_oak_mosaic_stairs", "Pale Oak Mosaic Stairs");
        translationBuilder.add("block.constructure.pale_oak_mosaic_slab", "Pale Oak Mosaic Slab");

        translationBuilder.add("block.constructure.birch_mosaic", "Birch Mosaic");
        translationBuilder.add("block.constructure.birch_mosaic_stairs", "Birch Mosaic Stairs");
        translationBuilder.add("block.constructure.birch_mosaic_slab", "Birch Mosaic Slab");

        translationBuilder.add("block.constructure.spruce_mosaic", "Spruce Mosaic");
        translationBuilder.add("block.constructure.spruce_mosaic_stairs", "Spruce Mosaic Stairs");
        translationBuilder.add("block.constructure.spruce_mosaic_slab", "Spruce Mosaic Slab");

        translationBuilder.add("block.constructure.jungle_mosaic", "Jungle Mosaic");
        translationBuilder.add("block.constructure.jungle_mosaic_stairs", "Jungle Mosaic Stairs");
        translationBuilder.add("block.constructure.jungle_mosaic_slab", "Jungle Mosaic Slab");

        translationBuilder.add("block.constructure.acacia_mosaic", "Acacia Mosaic");
        translationBuilder.add("block.constructure.acacia_mosaic_stairs", "Acacia Mosaic Stairs");
        translationBuilder.add("block.constructure.acacia_mosaic_slab", "Acacia Mosaic Slab");

        translationBuilder.add("block.constructure.cherry_mosaic", "Cherry Mosaic");
        translationBuilder.add("block.constructure.cherry_mosaic_stairs", "Cherry Mosaic Stairs");
        translationBuilder.add("block.constructure.cherry_mosaic_slab", "Cherry Mosaic Slab");

        translationBuilder.add("block.constructure.mangrove_mosaic", "Mangrove Mosaic");
        translationBuilder.add("block.constructure.mangrove_mosaic_stairs", "Mangrove Mosaic Stairs");
        translationBuilder.add("block.constructure.mangrove_mosaic_slab", "Mangrove Mosaic Slab");

        translationBuilder.add("block.constructure.crimson_mosaic", "Crimson Mosaic");
        translationBuilder.add("block.constructure.crimson_mosaic_stairs", "Crimson Mosaic Stairs");
        translationBuilder.add("block.constructure.crimson_mosaic_slab", "Crimson Mosaic Slab");

        translationBuilder.add("block.constructure.warped_mosaic", "Warped Mosaic");
        translationBuilder.add("block.constructure.warped_mosaic_stairs", "Warped Mosaic Stairs");
        translationBuilder.add("block.constructure.warped_mosaic_slab", "Warped Mosaic Slab");

        translationBuilder.add("block.constructure.bluebonnet", "Bluebonnet");
        translationBuilder.add("block.constructure.potted_bluebonnet", "Potted Bluebonnet");








    }
}
