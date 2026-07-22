package team.lookingglass.elsewhere.datagen;

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
        translationBuilder.add("elsewhere.tab", "Elsewhere");

        // Quartz Brick Fill
        translationBuilder.add("block.elsewhere.quartz_brick_stairs", "Quartz Brick Stairs");
        translationBuilder.add("block.elsewhere.quartz_brick_slab", "Quartz Brick Slab");

        // Amethyst-Obsidian Set
        translationBuilder.add("block.elsewhere.amethyst_stairs", "Amethyst Stairs");
        translationBuilder.add("block.elsewhere.amethyst_slab", "Amethyst Slab");
        translationBuilder.add("block.elsewhere.amethyst_bricks", "Amethyst Bricks");
        translationBuilder.add("block.elsewhere.amethyst_brick_stairs", "Amethyst Brick Stairs");
        translationBuilder.add("block.elsewhere.amethyst_brick_slab", "Amethyst Brick Slab");
        translationBuilder.add("block.elsewhere.amethyst_pillar", "Amethyst Pillar");
        translationBuilder.add("block.elsewhere.chiseled_amethyst", "Chiseled Amethyst");

        translationBuilder.add("block.elsewhere.obsidian_stairs", "Obsidian Stairs");
        translationBuilder.add("block.elsewhere.obsidian_slab", "Obsidian Slab");
        translationBuilder.add("block.elsewhere.obsidian_bricks", "Obsidian Bricks");
        translationBuilder.add("block.elsewhere.obsidian_brick_stairs", "Obsidian Brick Stairs");
        translationBuilder.add("block.elsewhere.obsidian_brick_slab", "Obsidian Brick Slab");
        translationBuilder.add("block.elsewhere.obsidian_pillar", "Obsidian Pillar");
        translationBuilder.add("block.elsewhere.chiseled_obsidian", "Chiseled Obsidian");

        // Stone Sets
        translationBuilder.add("block.elsewhere.stone_wall", "Stone Wall");
        translationBuilder.add("block.elsewhere.smooth_stone_stairs", "Smooth Stone Stairs");
        translationBuilder.add("block.elsewhere.smooth_stone_wall", "Smooth Stone Wall");
        translationBuilder.add("block.elsewhere.polished_stone", "Polished Stone");
        translationBuilder.add("block.elsewhere.polished_stone_stairs", "Polished Stone Stairs");
        translationBuilder.add("block.elsewhere.polished_stone_slab", "Polished Stone Slab");
        translationBuilder.add("block.elsewhere.polished_stone_wall", "Polished Stone Wall");
        translationBuilder.add("block.elsewhere.stone_tiles", "Stone Tiles");
        translationBuilder.add("block.elsewhere.stone_tile_stairs", "Stone Tile Stairs");
        translationBuilder.add("block.elsewhere.stone_tile_slab", "Stone Tile Slab");
        translationBuilder.add("block.elsewhere.stone_tile_wall", "Stone Tile Wall");
        translationBuilder.add("block.elsewhere.mossy_stone_tiles", "Mossy Stone Tiles");
        translationBuilder.add("block.elsewhere.mossy_stone_tile_stairs", "Mossy Stone Tile Stairs");
        translationBuilder.add("block.elsewhere.mossy_stone_tile_slab", "Mossy Stone Tile Slab");
        translationBuilder.add("block.elsewhere.mossy_stone_tile_wall", "Mossy Stone Tile Wall");
        translationBuilder.add("block.elsewhere.chiseled_stone", "Chiseled Stone");
        translationBuilder.add("block.elsewhere.stone_pillar", "Stone Pillar");

        translationBuilder.add("block.elsewhere.deepslate_stairs", "Deepslate Stairs");
        translationBuilder.add("block.elsewhere.deepslate_slab", "Deepslate Slab");
        translationBuilder.add("block.elsewhere.deepslate_wall", "Deepslate Wall");
        translationBuilder.add("block.elsewhere.smooth_deepslate", "Smooth Deepslate");
        translationBuilder.add("block.elsewhere.smooth_deepslate_stairs", "Smooth Deepslate Stairs");
        translationBuilder.add("block.elsewhere.smooth_deepslate_slab", "Smooth Deepslate Slab");
        translationBuilder.add("block.elsewhere.smooth_deepslate_wall", "Smooth Deepslate Wall");
        translationBuilder.add("block.elsewhere.chiseled_deepslate_bricks", "Chiseled Deepslate Bricks");
        translationBuilder.add("block.elsewhere.deepslate_pillar", "Deepslate Pillar");

        translationBuilder.add("block.elsewhere.smooth_tuff", "Smooth Tuff");
        translationBuilder.add("block.elsewhere.smooth_tuff_stairs", "Smooth Tuff Stairs");
        translationBuilder.add("block.elsewhere.smooth_tuff_slab", "Smooth Tuff Slab");
        translationBuilder.add("block.elsewhere.smooth_tuff_wall", "Smooth Tuff Wall");
        translationBuilder.add("block.elsewhere.tuff_pillar", "Tuff Pillar");

        translationBuilder.add("block.elsewhere.smooth_blackstone", "Smooth Blackstone");
        translationBuilder.add("block.elsewhere.smooth_blackstone_stairs", "Smooth Blackstone Stairs");
        translationBuilder.add("block.elsewhere.smooth_blackstone_slab", "Smooth Blackstone Slab");
        translationBuilder.add("block.elsewhere.smooth_blackstone_wall", "Smooth Blackstone Wall");
        translationBuilder.add("block.elsewhere.chiseled_polished_blackstone_bricks", "Chiseled Polished Blackstone Bricks");
        translationBuilder.add("block.elsewhere.polished_blackstone_pillar", "Polished Blackstone Pillar");

        translationBuilder.add("block.elsewhere.polished_andesite_wall", "Polished Andesite Wall");
        translationBuilder.add("block.elsewhere.smooth_andesite", "Smooth Andesite");
        translationBuilder.add("block.elsewhere.smooth_andesite_stairs", "Smooth Andesite Stairs");
        translationBuilder.add("block.elsewhere.smooth_andesite_slab", "Smooth Andesite Slab");
        translationBuilder.add("block.elsewhere.smooth_andesite_wall", "Smooth Andesite Wall");
        translationBuilder.add("block.elsewhere.andesite_bricks", "Andesite Bricks");
        translationBuilder.add("block.elsewhere.andesite_brick_stairs", "Andesite Brick Stairs");
        translationBuilder.add("block.elsewhere.andesite_brick_slab", "Andesite Brick Slab");
        translationBuilder.add("block.elsewhere.andesite_brick_wall", "Andesite Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_andesite", "Chiseled Andesite");
        translationBuilder.add("block.elsewhere.chiseled_andesite_bricks", "Chiseled Andesite Bricks");
        translationBuilder.add("block.elsewhere.andesite_pillar", "Andesite Pillar");

        translationBuilder.add("block.elsewhere.polished_granite_wall", "Polished Granite Wall");
        translationBuilder.add("block.elsewhere.smooth_granite", "Smooth Granite");
        translationBuilder.add("block.elsewhere.smooth_granite_stairs", "Smooth Granite Stairs");
        translationBuilder.add("block.elsewhere.smooth_granite_slab", "Smooth Granite Slab");
        translationBuilder.add("block.elsewhere.smooth_granite_wall", "Smooth Granite Wall");
        translationBuilder.add("block.elsewhere.granite_bricks", "Granite Bricks");
        translationBuilder.add("block.elsewhere.granite_brick_stairs", "Granite Brick Stairs");
        translationBuilder.add("block.elsewhere.granite_brick_slab", "Granite Brick Slab");
        translationBuilder.add("block.elsewhere.granite_brick_wall", "Granite Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_granite", "Chiseled Granite");
        translationBuilder.add("block.elsewhere.chiseled_granite_bricks", "Chiseled Granite Bricks");
        translationBuilder.add("block.elsewhere.granite_pillar", "Granite Pillar");

        translationBuilder.add("block.elsewhere.polished_diorite_wall", "Polished Diorite Wall");
        translationBuilder.add("block.elsewhere.smooth_diorite", "Smooth Diorite");
        translationBuilder.add("block.elsewhere.smooth_diorite_stairs", "Smooth Diorite Stairs");
        translationBuilder.add("block.elsewhere.smooth_diorite_slab", "Smooth Diorite Slab");
        translationBuilder.add("block.elsewhere.smooth_diorite_wall", "Smooth Diorite Wall");
        translationBuilder.add("block.elsewhere.diorite_bricks", "Diorite Bricks");
        translationBuilder.add("block.elsewhere.diorite_brick_stairs", "Diorite Brick Stairs");
        translationBuilder.add("block.elsewhere.diorite_brick_slab", "Diorite Brick Slab");
        translationBuilder.add("block.elsewhere.diorite_brick_wall", "Diorite Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_diorite", "Chiseled Diorite");
        translationBuilder.add("block.elsewhere.chiseled_diorite_bricks", "Chiseled Diorite Bricks");
        translationBuilder.add("block.elsewhere.diorite_pillar", "Diorite Pillar");

        translationBuilder.add("block.elsewhere.calcite_stairs", "Calcite Stairs");
        translationBuilder.add("block.elsewhere.calcite_slab", "Calcite Slab");
        translationBuilder.add("block.elsewhere.calcite_wall", "Calcite Wall");
        translationBuilder.add("block.elsewhere.smooth_calcite", "Smooth Calcite");
        translationBuilder.add("block.elsewhere.smooth_calcite_stairs", "Smooth Calcite Stairs");
        translationBuilder.add("block.elsewhere.smooth_calcite_slab", "Smooth Calcite Slab");
        translationBuilder.add("block.elsewhere.smooth_calcite_wall", "Smooth Calcite Wall");
        translationBuilder.add("block.elsewhere.polished_calcite", "Polished Calcite");
        translationBuilder.add("block.elsewhere.polished_calcite_stairs", "Polished Calcite Stairs");
        translationBuilder.add("block.elsewhere.polished_calcite_slab", "Polished Calcite Slab");
        translationBuilder.add("block.elsewhere.polished_calcite_wall", "Polished Calcite Wall");
        translationBuilder.add("block.elsewhere.calcite_bricks", "Calcite Bricks");
        translationBuilder.add("block.elsewhere.calcite_brick_stairs", "Calcite Brick Stairs");
        translationBuilder.add("block.elsewhere.calcite_brick_slab", "Calcite Brick Slab");
        translationBuilder.add("block.elsewhere.calcite_brick_wall", "Calcite Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_calcite", "Chiseled Calcite");
        translationBuilder.add("block.elsewhere.chiseled_calcite_bricks", "Chiseled Calcite Bricks");
        translationBuilder.add("block.elsewhere.calcite_pillar", "Calcite Pillar");

        translationBuilder.add("block.elsewhere.dripstone_stairs", "Dripstone Stairs");
        translationBuilder.add("block.elsewhere.dripstone_slab", "Dripstone Slab");
        translationBuilder.add("block.elsewhere.dripstone_wall", "Dripstone Wall");
        translationBuilder.add("block.elsewhere.smooth_dripstone", "Smooth Dripstone");
        translationBuilder.add("block.elsewhere.smooth_dripstone_stairs", "Smooth Dripstone Stairs");
        translationBuilder.add("block.elsewhere.smooth_dripstone_slab", "Smooth Dripstone Slab");
        translationBuilder.add("block.elsewhere.smooth_dripstone_wall", "Smooth Dripstone Wall");
        translationBuilder.add("block.elsewhere.polished_dripstone", "Polished Dripstone");
        translationBuilder.add("block.elsewhere.polished_dripstone_stairs", "Polished Dripstone Stairs");
        translationBuilder.add("block.elsewhere.polished_dripstone_slab", "Polished Dripstone Slab");
        translationBuilder.add("block.elsewhere.polished_dripstone_wall", "Polished Dripstone Wall");
        translationBuilder.add("block.elsewhere.dripstone_bricks", "Dripstone Bricks");
        translationBuilder.add("block.elsewhere.dripstone_brick_stairs", "Dripstone Brick Stairs");
        translationBuilder.add("block.elsewhere.dripstone_brick_slab", "Dripstone Brick Slab");
        translationBuilder.add("block.elsewhere.dripstone_brick_wall", "Dripstone Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_dripstone", "Chiseled Dripstone");
        translationBuilder.add("block.elsewhere.chiseled_dripstone_bricks", "Chiseled Dripstone Bricks");
        translationBuilder.add("block.elsewhere.dripstone_pillar", "Dripstone Pillar");

        translationBuilder.add("block.elsewhere.polished_sandstone", "Polished Sandstone");
        translationBuilder.add("block.elsewhere.polished_sandstone_stairs", "Polished Sandstone Stairs");
        translationBuilder.add("block.elsewhere.polished_sandstone_slab", "Polished Sandstone Slab");
        translationBuilder.add("block.elsewhere.polished_sandstone_wall", "Polished Sandstone Wall");
        translationBuilder.add("block.elsewhere.polished_red_sandstone", "Polished Red Sandstone");
        translationBuilder.add("block.elsewhere.polished_red_sandstone_stairs", "Polished Red Sandstone Stairs");
        translationBuilder.add("block.elsewhere.polished_red_sandstone_slab", "Polished Red Sandstone Slab");
        translationBuilder.add("block.elsewhere.polished_red_sandstone_wall", "Polished Red Sandstone Wall");

        translationBuilder.add("block.elsewhere.sandstone_bricks", "Sandstone Bricks");
        translationBuilder.add("block.elsewhere.sandstone_brick_stairs", "Sandstone Brick Stairs");
        translationBuilder.add("block.elsewhere.sandstone_brick_slab", "Sandstone Brick Slab");
        translationBuilder.add("block.elsewhere.sandstone_brick_wall", "Sandstone Brick Wall");
        translationBuilder.add("block.elsewhere.red_sandstone_bricks", "Red Sandstone Bricks");
        translationBuilder.add("block.elsewhere.red_sandstone_brick_stairs", "Red Sandstone Brick Stairs");
        translationBuilder.add("block.elsewhere.red_sandstone_brick_slab", "Red Sandstone Brick Slab");
        translationBuilder.add("block.elsewhere.red_sandstone_brick_wall", "Red Sandstone Brick Wall");

        translationBuilder.add("block.elsewhere.smooth_sandstone_wall", "Smooth Sandstone Wall");
        translationBuilder.add("block.elsewhere.smooth_red_sandstone_wall", "Smooth Red Sandstone Wall");

        translationBuilder.add("block.elsewhere.cut_sandstone_stairs", "Cut Sandstone Stairs");
        translationBuilder.add("block.elsewhere.cut_sandstone_wall", "Cut Sandstone Wall");
        translationBuilder.add("block.elsewhere.cut_red_sandstone_stairs", "Cut Red Sandstone Stairs");
        translationBuilder.add("block.elsewhere.cut_red_sandstone_wall", "Cut Red Sandstone Wall");

        translationBuilder.add("block.elsewhere.smooth_prismarine", "Smooth Prismarine");
        translationBuilder.add("block.elsewhere.smooth_prismarine_stairs", "Smooth Prismarine Stairs");
        translationBuilder.add("block.elsewhere.smooth_prismarine_slab", "Smooth Prismarine Slab");
        translationBuilder.add("block.elsewhere.smooth_prismarine_wall", "Smooth Prismarine Wall");
        translationBuilder.add("block.elsewhere.polished_prismarine", "Polished Prismarine");
        translationBuilder.add("block.elsewhere.polished_prismarine_stairs", "Polished Prismarine Stairs");
        translationBuilder.add("block.elsewhere.polished_prismarine_slab", "Polished Prismarine Slab");
        translationBuilder.add("block.elsewhere.polished_prismarine_wall", "Polished Prismarine Wall");
        translationBuilder.add("block.elsewhere.prismarine_brick_wall", "Prismarine Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_prismarine", "Chiseled Prismarine");
        translationBuilder.add("block.elsewhere.chiseled_prismarine_bricks", "Chiseled Prismarine Bricks");
        translationBuilder.add("block.elsewhere.prismarine_pillar", "Prismarine Pillar");

        translationBuilder.add("block.elsewhere.dark_prismarine_wall", "Dark Prismarine Wall");
        translationBuilder.add("block.elsewhere.smooth_dark_prismarine", "Smooth Dark Prismarine");
        translationBuilder.add("block.elsewhere.smooth_dark_prismarine_stairs", "Smooth Dark Prismarine Stairs");
        translationBuilder.add("block.elsewhere.smooth_dark_prismarine_slab", "Smooth Dark Prismarine Slab");
        translationBuilder.add("block.elsewhere.smooth_dark_prismarine_wall", "Smooth Dark Prismarine Wall");
        translationBuilder.add("block.elsewhere.polished_dark_prismarine", "Polished Dark Prismarine");
        translationBuilder.add("block.elsewhere.polished_dark_prismarine_stairs", "Polished Dark Prismarine Stairs");
        translationBuilder.add("block.elsewhere.polished_dark_prismarine_slab", "Polished Dark Prismarine Slab");
        translationBuilder.add("block.elsewhere.polished_dark_prismarine_wall", "Polished Dark Prismarine Wall");
        translationBuilder.add("block.elsewhere.dark_prismarine_bricks", "Dark Prismarine Bricks");
        translationBuilder.add("block.elsewhere.dark_prismarine_brick_stairs", "Dark Prismarine Brick Stairs");
        translationBuilder.add("block.elsewhere.dark_prismarine_brick_slab", "Dark Prismarine Brick Slab");
        translationBuilder.add("block.elsewhere.dark_prismarine_brick_wall", "Dark Prismarine Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_dark_prismarine", "Chiseled Dark Prismarine");
        translationBuilder.add("block.elsewhere.chiseled_dark_prismarine_bricks", "Chiseled Dark Prismarine Bricks");
        translationBuilder.add("block.elsewhere.dark_prismarine_pillar", "Dark Prismarine Pillar");

        translationBuilder.add("block.elsewhere.basalt_slab", "Basalt Slab");
        translationBuilder.add("block.elsewhere.smooth_basalt_stairs", "Smooth Basalt Stairs");
        translationBuilder.add("block.elsewhere.smooth_basalt_slab", "Smooth Basalt Slab");
        translationBuilder.add("block.elsewhere.smooth_basalt_wall", "Smooth Basalt Wall");
        translationBuilder.add("block.elsewhere.polished_basalt_slab", "Polished Basalt Slab");
        translationBuilder.add("block.elsewhere.basalt_bricks", "Basalt Bricks");
        translationBuilder.add("block.elsewhere.basalt_brick_stairs", "Basalt Brick Stairs");
        translationBuilder.add("block.elsewhere.basalt_brick_slab", "Basalt Brick Slab");
        translationBuilder.add("block.elsewhere.basalt_brick_wall", "Basalt Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_basalt", "Chiseled Basalt");
        translationBuilder.add("block.elsewhere.chiseled_basalt_bricks", "Chiseled Basalt Bricks");

        translationBuilder.add("block.elsewhere.end_stone_stairs", "End Stone Stairs");
        translationBuilder.add("block.elsewhere.end_stone_slab", "End Stone Slab");
        translationBuilder.add("block.elsewhere.end_stone_wall", "End Stone Wall");
        translationBuilder.add("block.elsewhere.smooth_end_stone", "Smooth End Stone");
        translationBuilder.add("block.elsewhere.smooth_end_stone_stairs", "Smooth End Stone Stairs");
        translationBuilder.add("block.elsewhere.smooth_end_stone_slab", "Smooth End Stone Slab");
        translationBuilder.add("block.elsewhere.smooth_end_stone_wall", "Smooth End Stone Wall");
        translationBuilder.add("block.elsewhere.polished_end_stone", "Polished End Stone");
        translationBuilder.add("block.elsewhere.polished_end_stone_stairs", "Polished End Stone Stairs");
        translationBuilder.add("block.elsewhere.polished_end_stone_slab", "Polished End Stone Slab");
        translationBuilder.add("block.elsewhere.polished_end_stone_wall", "Polished End Stone Wall");
        translationBuilder.add("block.elsewhere.chiseled_end_stone", "Chiseled End Stone");
        translationBuilder.add("block.elsewhere.chiseled_end_stone_bricks", "Chiseled End Stone Bricks");
        translationBuilder.add("block.elsewhere.end_stone_pillar", "End Stone Pillar");

        translationBuilder.add("block.elsewhere.sodalite", "Sodalite");
        translationBuilder.add("block.elsewhere.sodalite_stairs", "Sodalite Stairs");
        translationBuilder.add("block.elsewhere.sodalite_slab", "Sodalite Slab");
        translationBuilder.add("block.elsewhere.sodalite_wall", "Sodalite Wall");
        translationBuilder.add("block.elsewhere.smooth_sodalite", "Smooth Sodalite");
        translationBuilder.add("block.elsewhere.smooth_sodalite_stairs", "Smooth Sodalite Stairs");
        translationBuilder.add("block.elsewhere.smooth_sodalite_slab", "Smooth Sodalite Slab");
        translationBuilder.add("block.elsewhere.smooth_sodalite_wall", "Smooth Sodalite Wall");
        translationBuilder.add("block.elsewhere.polished_sodalite", "Polished Sodalite");
        translationBuilder.add("block.elsewhere.polished_sodalite_stairs", "Polished Sodalite Stairs");
        translationBuilder.add("block.elsewhere.polished_sodalite_slab", "Polished Sodalite Slab");
        translationBuilder.add("block.elsewhere.polished_sodalite_wall", "Polished Sodalite Wall");
        translationBuilder.add("block.elsewhere.sodalite_bricks", "Sodalite Bricks");
        translationBuilder.add("block.elsewhere.sodalite_brick_stairs", "Sodalite Brick Stairs");
        translationBuilder.add("block.elsewhere.sodalite_brick_slab", "Sodalite Brick Slab");
        translationBuilder.add("block.elsewhere.sodalite_brick_wall", "Sodalite Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_sodalite", "Chiseled Sodalite");
        translationBuilder.add("block.elsewhere.chiseled_sodalite_bricks", "Chiseled Sodalite Bricks");
        translationBuilder.add("block.elsewhere.sodalite_pillar", "Sodalite Pillar");

        translationBuilder.add("block.elsewhere.shale", "Shale");
        translationBuilder.add("block.elsewhere.shale_stairs", "Shale Stairs");
        translationBuilder.add("block.elsewhere.shale_slab", "Shale Slab");
        translationBuilder.add("block.elsewhere.shale_wall", "Shale Wall");
        translationBuilder.add("block.elsewhere.smooth_shale", "Smooth Shale");
        translationBuilder.add("block.elsewhere.smooth_shale_stairs", "Smooth Shale Stairs");
        translationBuilder.add("block.elsewhere.smooth_shale_slab", "Smooth Shale Slab");
        translationBuilder.add("block.elsewhere.smooth_shale_wall", "Smooth Shale Wall");
        translationBuilder.add("block.elsewhere.polished_shale", "Polished Shale");
        translationBuilder.add("block.elsewhere.polished_shale_stairs", "Polished Shale Stairs");
        translationBuilder.add("block.elsewhere.polished_shale_slab", "Polished Shale Slab");
        translationBuilder.add("block.elsewhere.polished_shale_wall", "Polished Shale Wall");
        translationBuilder.add("block.elsewhere.shale_bricks", "Shale Bricks");
        translationBuilder.add("block.elsewhere.shale_brick_stairs", "Shale Brick Stairs");
        translationBuilder.add("block.elsewhere.shale_brick_slab", "Shale Brick Slab");
        translationBuilder.add("block.elsewhere.shale_brick_wall", "Shale Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_shale", "Chiseled Shale");
        translationBuilder.add("block.elsewhere.chiseled_shale_bricks", "Chiseled Shale Bricks");
        translationBuilder.add("block.elsewhere.shale_pillar", "Shale Pillar");
        translationBuilder.add("block.elsewhere.cobbleshale", "Cobbleshale");
        translationBuilder.add("block.elsewhere.cobbleshale_stairs", "Cobbleshale Stairs");
        translationBuilder.add("block.elsewhere.cobbleshale_slab", "Cobbleshale Slab");
        translationBuilder.add("block.elsewhere.cobbleshale_wall", "Cobbleshale Wall");
        translationBuilder.add("block.elsewhere.shale_tiles", "Shale Tiles");
        translationBuilder.add("block.elsewhere.shale_tile_stairs", "Shale Tile Stairs");
        translationBuilder.add("block.elsewhere.shale_tile_slab", "Shale Tile Slab");
        translationBuilder.add("block.elsewhere.shale_tile_wall", "Shale Tile Wall");

        translationBuilder.add("block.elsewhere.shale_coal_ore", "Shale Coal Ore");
        translationBuilder.add("block.elsewhere.shale_copper_ore", "Shale Copper Ore");
        translationBuilder.add("block.elsewhere.shale_iron_ore", "Shale Iron Ore");
        translationBuilder.add("block.elsewhere.shale_gold_ore", "Shale Gold Ore");
        translationBuilder.add("block.elsewhere.shale_redstone_ore", "Shale Redstone Ore");
        translationBuilder.add("block.elsewhere.shale_diamond_ore", "Shale Diamond Ore");
        translationBuilder.add("block.elsewhere.shale_lapis_ore", "Shale Lapis Lazuli Ore");
        translationBuilder.add("block.elsewhere.shale_emerald_ore", "Shale Emerald Ore");

        translationBuilder.add("block.elsewhere.sulfur", "Sulfur");
        translationBuilder.add("block.elsewhere.sulfur_stairs", "Sulfur Stairs");
        translationBuilder.add("block.elsewhere.sulfur_slab", "Sulfur Slab");
        translationBuilder.add("block.elsewhere.sulfur_wall", "Sulfur Wall");
        translationBuilder.add("block.elsewhere.smooth_sulfur", "Smooth Sulfur");
        translationBuilder.add("block.elsewhere.smooth_sulfur_stairs", "Smooth Sulfur Stairs");
        translationBuilder.add("block.elsewhere.smooth_sulfur_slab", "Smooth Sulfur Slab");
        translationBuilder.add("block.elsewhere.smooth_sulfur_wall", "Smooth Sulfur Wall");
        translationBuilder.add("block.elsewhere.polished_sulfur", "Polished Sulfur");
        translationBuilder.add("block.elsewhere.polished_sulfur_stairs", "Polished Sulfur Stairs");
        translationBuilder.add("block.elsewhere.polished_sulfur_slab", "Polished Sulfur Slab");
        translationBuilder.add("block.elsewhere.polished_sulfur_wall", "Polished Sulfur Wall");
        translationBuilder.add("block.elsewhere.sulfur_bricks", "Sulfur Bricks");
        translationBuilder.add("block.elsewhere.sulfur_brick_stairs", "Sulfur Brick Stairs");
        translationBuilder.add("block.elsewhere.sulfur_brick_slab", "Sulfur Brick Slab");
        translationBuilder.add("block.elsewhere.sulfur_brick_wall", "Sulfur Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_sulfur", "Chiseled Sulfur");
        translationBuilder.add("block.elsewhere.chiseled_sulfur_bricks", "Chiseled Sulfur Bricks");
        translationBuilder.add("block.elsewhere.sulfur_pillar", "Sulfur Pillar");

        translationBuilder.add("block.elsewhere.sulfur_spike", "Sulfur Spike");
        translationBuilder.add("block.elsewhere.potent_sulfur", "Potent Sulfur");

        translationBuilder.add("block.elsewhere.cinnabar", "Cinnabar");
        translationBuilder.add("block.elsewhere.cinnabar_stairs", "Cinnabar Stairs");
        translationBuilder.add("block.elsewhere.cinnabar_slab", "Cinnabar Slab");
        translationBuilder.add("block.elsewhere.cinnabar_wall", "Cinnabar Wall");
        translationBuilder.add("block.elsewhere.smooth_cinnabar", "Smooth Cinnabar");
        translationBuilder.add("block.elsewhere.smooth_cinnabar_stairs", "Smooth Cinnabar Stairs");
        translationBuilder.add("block.elsewhere.smooth_cinnabar_slab", "Smooth Cinnabar Slab");
        translationBuilder.add("block.elsewhere.smooth_cinnabar_wall", "Smooth Cinnabar Wall");
        translationBuilder.add("block.elsewhere.polished_cinnabar", "Polished Cinnabar");
        translationBuilder.add("block.elsewhere.polished_cinnabar_stairs", "Polished Cinnabar Stairs");
        translationBuilder.add("block.elsewhere.polished_cinnabar_slab", "Polished Cinnabar Slab");
        translationBuilder.add("block.elsewhere.polished_cinnabar_wall", "Polished Cinnabar Wall");
        translationBuilder.add("block.elsewhere.cinnabar_bricks", "Cinnabar Bricks");
        translationBuilder.add("block.elsewhere.cinnabar_brick_stairs", "Cinnabar Brick Stairs");
        translationBuilder.add("block.elsewhere.cinnabar_brick_slab", "Cinnabar Brick Slab");
        translationBuilder.add("block.elsewhere.cinnabar_brick_wall", "Cinnabar Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_cinnabar", "Chiseled Cinnabar");
        translationBuilder.add("block.elsewhere.chiseled_cinnabar_bricks", "Chiseled Cinnabar Bricks");
        translationBuilder.add("block.elsewhere.cinnabar_pillar", "Cinnabar Pillar");

        translationBuilder.add("block.elsewhere.cinnabar_coal_ore", "Cinnabar Coal Ore");
        translationBuilder.add("block.elsewhere.cinnabar_copper_ore", "Cinnabar Copper Ore");
        translationBuilder.add("block.elsewhere.cinnabar_iron_ore", "Cinnabar Iron Ore");
        translationBuilder.add("block.elsewhere.cinnabar_gold_ore", "Cinnabar Gold Ore");
        translationBuilder.add("block.elsewhere.cinnabar_redstone_ore", "Cinnabar Redstone Ore");
        translationBuilder.add("block.elsewhere.cinnabar_diamond_ore", "Cinnabar Diamond Ore");
        translationBuilder.add("block.elsewhere.cinnabar_lapis_ore", "Cinnabar Lapis Lazuli Ore");
        translationBuilder.add("block.elsewhere.cinnabar_emerald_ore", "Cinnabar Emerald Ore");

        translationBuilder.add("block.elsewhere.orpiment", "Orpiment");
        translationBuilder.add("block.elsewhere.orpiment_stairs", "Orpiment Stairs");
        translationBuilder.add("block.elsewhere.orpiment_slab", "Orpiment Slab");
        translationBuilder.add("block.elsewhere.orpiment_wall", "Orpiment Wall");
        translationBuilder.add("block.elsewhere.smooth_orpiment", "Smooth Orpiment");
        translationBuilder.add("block.elsewhere.smooth_orpiment_stairs", "Smooth Orpiment Stairs");
        translationBuilder.add("block.elsewhere.smooth_orpiment_slab", "Smooth Orpiment Slab");
        translationBuilder.add("block.elsewhere.smooth_orpiment_wall", "Smooth Orpiment Wall");
        translationBuilder.add("block.elsewhere.polished_orpiment", "Polished Orpiment");
        translationBuilder.add("block.elsewhere.polished_orpiment_stairs", "Polished Orpiment Stairs");
        translationBuilder.add("block.elsewhere.polished_orpiment_slab", "Polished Orpiment Slab");
        translationBuilder.add("block.elsewhere.polished_orpiment_wall", "Polished Orpiment Wall");
        translationBuilder.add("block.elsewhere.orpiment_bricks", "Orpiment Bricks");
        translationBuilder.add("block.elsewhere.orpiment_brick_stairs", "Orpiment Brick Stairs");
        translationBuilder.add("block.elsewhere.orpiment_brick_slab", "Orpiment Brick Slab");
        translationBuilder.add("block.elsewhere.orpiment_brick_wall", "Orpiment Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_orpiment", "Chiseled Orpiment");
        translationBuilder.add("block.elsewhere.chiseled_orpiment_bricks", "Chiseled Orpiment Bricks");
        translationBuilder.add("block.elsewhere.orpiment_pillar", "Orpiment Pillar");

        translationBuilder.add("block.elsewhere.netherrack_stairs", "Netherrack Stairs");
        translationBuilder.add("block.elsewhere.netherrack_slab", "Netherrack Slab");
        translationBuilder.add("block.elsewhere.netherrack_wall", "Netherrack Wall");
        translationBuilder.add("block.elsewhere.smooth_netherrack", "Smooth Netherrack");
        translationBuilder.add("block.elsewhere.smooth_netherrack_stairs", "Smooth Netherrack Stairs");
        translationBuilder.add("block.elsewhere.smooth_netherrack_slab", "Smooth Netherrack Slab");
        translationBuilder.add("block.elsewhere.smooth_netherrack_wall", "Smooth Netherrack Wall");
        translationBuilder.add("block.elsewhere.polished_netherrack", "Polished Netherrack");
        translationBuilder.add("block.elsewhere.polished_netherrack_stairs", "Polished Netherrack Stairs");
        translationBuilder.add("block.elsewhere.polished_netherrack_slab", "Polished Netherrack Slab");
        translationBuilder.add("block.elsewhere.polished_netherrack_wall", "Polished Netherrack Wall");
        translationBuilder.add("block.elsewhere.netherrack_bricks", "Netherrack Bricks");
        translationBuilder.add("block.elsewhere.netherrack_brick_stairs", "Netherrack Brick Stairs");
        translationBuilder.add("block.elsewhere.netherrack_brick_slab", "Netherrack Brick Slab");
        translationBuilder.add("block.elsewhere.netherrack_brick_wall", "Netherrack Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_netherrack", "Chiseled Netherrack");
        translationBuilder.add("block.elsewhere.chiseled_netherrack_bricks", "Chiseled Netherrack Bricks");
        translationBuilder.add("block.elsewhere.netherrack_pillar", "Netherrack Pillar");

        translationBuilder.add("block.elsewhere.soul_sandstone", "Soul Sandstone");
        translationBuilder.add("block.elsewhere.soul_sandstone_stairs", "Soul Sandstone Stairs");
        translationBuilder.add("block.elsewhere.soul_sandstone_slab", "Soul Sandstone Slab");
        translationBuilder.add("block.elsewhere.soul_sandstone_wall", "Soul Sandstone Wall");
        translationBuilder.add("block.elsewhere.smooth_soul_sandstone", "Smooth Soul Sandstone");
        translationBuilder.add("block.elsewhere.smooth_soul_sandstone_stairs", "Smooth Soul Sandstone Stairs");
        translationBuilder.add("block.elsewhere.smooth_soul_sandstone_slab", "Smooth Soul Sandstone Slab");
        translationBuilder.add("block.elsewhere.smooth_soul_sandstone_wall", "Smooth Soul Sandstone Wall");
        translationBuilder.add("block.elsewhere.cut_soul_sandstone", "Cut Soul Sandstone");
        translationBuilder.add("block.elsewhere.cut_soul_sandstone_stairs", "Cut Soul Sandstone Stairs");
        translationBuilder.add("block.elsewhere.cut_soul_sandstone_slab", "Cut Soul Sandstone Slab");
        translationBuilder.add("block.elsewhere.cut_soul_sandstone_wall", "Cut Soul Sandstone Wall");
        translationBuilder.add("block.elsewhere.polished_soul_sandstone", "Polished Soul Sandstone");
        translationBuilder.add("block.elsewhere.polished_soul_sandstone_stairs", "Polished Soul Sandstone Stairs");
        translationBuilder.add("block.elsewhere.polished_soul_sandstone_slab", "Polished Soul Sandstone Slab");
        translationBuilder.add("block.elsewhere.polished_soul_sandstone_wall", "Polished Soul Sandstone Wall");
        translationBuilder.add("block.elsewhere.soul_sandstone_bricks", "Soul Sandstone Bricks");
        translationBuilder.add("block.elsewhere.soul_sandstone_brick_stairs", "Soul Sandstone Brick Stairs");
        translationBuilder.add("block.elsewhere.soul_sandstone_brick_slab", "Soul Sandstone Brick Slab");
        translationBuilder.add("block.elsewhere.soul_sandstone_brick_wall", "Soul Sandstone Brick Wall");
        translationBuilder.add("block.elsewhere.chiseled_soul_sandstone", "Chiseled Soul Sandstone");

        translationBuilder.add("block.elsewhere.chiseled_purpur", "Chiseled Purpur");

        translationBuilder.add("block.elsewhere.icicle", "Icicle");

        translationBuilder.add("block.elsewhere.packed_mud_stairs", "Packed Mud Stairs");
        translationBuilder.add("block.elsewhere.packed_mud_slab", "Packed Mud Slab");
        translationBuilder.add("block.elsewhere.packed_mud_wall", "Packed Mud Wall");
        translationBuilder.add("block.elsewhere.chiseled_mud_bricks", "Chiseled Mud Bricks");
        translationBuilder.add("block.elsewhere.mud_brick_pillar", "Mud Brick Pillar");

        translationBuilder.add("block.elsewhere.oak_mosaic", "Oak Mosaic");
        translationBuilder.add("block.elsewhere.oak_mosaic_stairs", "Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.oak_mosaic_slab", "Oak Mosaic Slab");
        translationBuilder.add("block.elsewhere.oak_boards", "Oak Boards");
        translationBuilder.add("block.elsewhere.oak_trim", "Oak Trim");

        translationBuilder.add("block.elsewhere.dark_oak_mosaic", "Dark Oak Mosaic");
        translationBuilder.add("block.elsewhere.dark_oak_mosaic_stairs", "Dark Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.dark_oak_mosaic_slab", "Dark Oak Mosaic Slab");
        translationBuilder.add("block.elsewhere.dark_oak_boards", "Dark Oak Boards");
        translationBuilder.add("block.elsewhere.dark_oak_trim", "Dark Oak Trim");

        translationBuilder.add("block.elsewhere.pale_oak_mosaic", "Pale Oak Mosaic");
        translationBuilder.add("block.elsewhere.pale_oak_mosaic_stairs", "Pale Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.pale_oak_mosaic_slab", "Pale Oak Mosaic Slab");
        translationBuilder.add("block.elsewhere.pale_oak_boards", "Pale Oak Boards");
        translationBuilder.add("block.elsewhere.pale_oak_trim", "Pale Oak Trim");

        translationBuilder.add("block.elsewhere.birch_mosaic", "Birch Mosaic");
        translationBuilder.add("block.elsewhere.birch_mosaic_stairs", "Birch Mosaic Stairs");
        translationBuilder.add("block.elsewhere.birch_mosaic_slab", "Birch Mosaic Slab");
        translationBuilder.add("block.elsewhere.birch_boards", "Birch Boards");
        translationBuilder.add("block.elsewhere.birch_trim", "Birch Trim");

        translationBuilder.add("block.elsewhere.spruce_mosaic", "Spruce Mosaic");
        translationBuilder.add("block.elsewhere.spruce_mosaic_stairs", "Spruce Mosaic Stairs");
        translationBuilder.add("block.elsewhere.spruce_mosaic_slab", "Spruce Mosaic Slab");
        translationBuilder.add("block.elsewhere.spruce_boards", "Spruce Boards");
        translationBuilder.add("block.elsewhere.spruce_trim", "Spruce Trim");

        translationBuilder.add("block.elsewhere.jungle_mosaic", "Jungle Mosaic");
        translationBuilder.add("block.elsewhere.jungle_mosaic_stairs", "Jungle Mosaic Stairs");
        translationBuilder.add("block.elsewhere.jungle_mosaic_slab", "Jungle Mosaic Slab");
        translationBuilder.add("block.elsewhere.jungle_boards", "Jungle Boards");
        translationBuilder.add("block.elsewhere.jungle_trim", "Jungle Trim");

        translationBuilder.add("block.elsewhere.acacia_mosaic", "Acacia Mosaic");
        translationBuilder.add("block.elsewhere.acacia_mosaic_stairs", "Acacia Mosaic Stairs");
        translationBuilder.add("block.elsewhere.acacia_mosaic_slab", "Acacia Mosaic Slab");
        translationBuilder.add("block.elsewhere.acacia_boards", "Acacia Boards");
        translationBuilder.add("block.elsewhere.acacia_trim", "Acacia Trim");

        translationBuilder.add("block.elsewhere.cherry_mosaic", "Cherry Mosaic");
        translationBuilder.add("block.elsewhere.cherry_mosaic_stairs", "Cherry Mosaic Stairs");
        translationBuilder.add("block.elsewhere.cherry_mosaic_slab", "Cherry Mosaic Slab");
        translationBuilder.add("block.elsewhere.cherry_boards", "Cherry Boards");
        translationBuilder.add("block.elsewhere.cherry_trim", "Cherry Trim");

        translationBuilder.add("block.elsewhere.mangrove_mosaic", "Mangrove Mosaic");
        translationBuilder.add("block.elsewhere.mangrove_mosaic_stairs", "Mangrove Mosaic Stairs");
        translationBuilder.add("block.elsewhere.mangrove_mosaic_slab", "Mangrove Mosaic Slab");
        translationBuilder.add("block.elsewhere.mangrove_boards", "Mangrove Boards");
        translationBuilder.add("block.elsewhere.mangrove_trim", "Mangrove Trim");

        translationBuilder.add("block.elsewhere.crimson_mosaic", "Crimson Mosaic");
        translationBuilder.add("block.elsewhere.crimson_mosaic_stairs", "Crimson Mosaic Stairs");
        translationBuilder.add("block.elsewhere.crimson_mosaic_slab", "Crimson Mosaic Slab");
        translationBuilder.add("block.elsewhere.crimson_boards", "Crimson Boards");
        translationBuilder.add("block.elsewhere.crimson_trim", "Crimson Trim");

        translationBuilder.add("block.elsewhere.warped_mosaic", "Warped Mosaic");
        translationBuilder.add("block.elsewhere.warped_mosaic_stairs", "Warped Mosaic Stairs");
        translationBuilder.add("block.elsewhere.warped_mosaic_slab", "Warped Mosaic Slab");
        translationBuilder.add("block.elsewhere.warped_boards", "Warped Boards");
        translationBuilder.add("block.elsewhere.warped_trim", "Warped Trim");

        translationBuilder.add("block.elsewhere.bamboo_stem", "Bamboo Stem");
        translationBuilder.add("block.elsewhere.stripped_bamboo_stem", "Stripped Bamboo Stem");
        translationBuilder.add("block.elsewhere.bamboo_boards", "Bamboo Boards");
        translationBuilder.add("block.elsewhere.bamboo_trim", "Bamboo Trim");




        translationBuilder.add("block.elsewhere.bluebonnet", "Bluebonnet");
        translationBuilder.add("block.elsewhere.potted_bluebonnet", "Potted Bluebonnet");

        translationBuilder.add("block.elsewhere.red_hibiscus", "Red Hibiscus");
        translationBuilder.add("block.elsewhere.potted_red_hibiscus", "Potted Red Hibiscus");
        translationBuilder.add("block.elsewhere.orange_hibiscus", "Orange Hibiscus");
        translationBuilder.add("block.elsewhere.potted_orange_hibiscus", "Potted Orange Hibiscus");
        translationBuilder.add("block.elsewhere.yellow_hibiscus", "Yellow Hibiscus");
        translationBuilder.add("block.elsewhere.potted_yellow_hibiscus", "Potted Yellow Hibiscus");
        translationBuilder.add("block.elsewhere.blue_hibiscus", "Blue Hibiscus");
        translationBuilder.add("block.elsewhere.potted_blue_hibiscus", "Potted Blue Hibiscus");
        translationBuilder.add("block.elsewhere.purple_hibiscus", "Purple Hibiscus");
        translationBuilder.add("block.elsewhere.potted_purple_hibiscus", "Potted Purple Hibiscus");
        translationBuilder.add("block.elsewhere.pink_hibiscus", "Pink Hibiscus");
        translationBuilder.add("block.elsewhere.potted_pink_hibiscus", "Potted Pink Hibiscus");
        translationBuilder.add("block.elsewhere.white_hibiscus", "White Hibiscus");
        translationBuilder.add("block.elsewhere.potted_white_hibiscus", "Potted White Hibiscus");

        translationBuilder.add("block.elsewhere.magenta_coneflower", "Magenta Coneflower");
        translationBuilder.add("block.elsewhere.yellow_coneflower", "Magenta Coneflower");
        translationBuilder.add("block.elsewhere.ironweed", "Ironweed");


        translationBuilder.add("block.elsewhere.arid_dirt", "Arid Dirt");
        translationBuilder.add("block.elsewhere.arid_grass_block", "Arid Grass Block");

        translationBuilder.add("block.elsewhere.red_grass_block", "Red Grass Block");
        translationBuilder.add("block.elsewhere.short_red_grass", "Short Red Grass");
        translationBuilder.add("block.elsewhere.tall_red_grass", "Tall Red Grass");
        translationBuilder.add("block.elsewhere.red_shrub", "Red Shrub");

        translationBuilder.add("block.elsewhere.poplar_log", "Poplar Log");
        translationBuilder.add("block.elsewhere.stripped_poplar_log", "Stripped Poplar Log");
        translationBuilder.add("block.elsewhere.poplar_wood", "Poplar Wood");
        translationBuilder.add("block.elsewhere.stripped_poplar_wood", "Stripped Poplar Wood");

        translationBuilder.add("block.elsewhere.poplar_planks", "Poplar Planks");
        translationBuilder.add("block.elsewhere.poplar_stairs", "Poplar Stairs");
        translationBuilder.add("block.elsewhere.poplar_slab", "Poplar Slab");
        translationBuilder.add("block.elsewhere.poplar_mosaic", "Poplar Mosaic");
        translationBuilder.add("block.elsewhere.poplar_mosaic_stairs", "Poplar Mosaic Stairs");
        translationBuilder.add("block.elsewhere.poplar_mosaic_slab", "Poplar Mosaic Slab");
        translationBuilder.add("block.elsewhere.poplar_boards", "Poplar Boards");
        translationBuilder.add("block.elsewhere.poplar_trim", "Poplar Trim");

        translationBuilder.add("block.elsewhere.poplar_fence", "Poplar Fence");
        translationBuilder.add("block.elsewhere.poplar_fence_gate", "Poplar Fence Gate");
        translationBuilder.add("block.elsewhere.poplar_door", "Poplar Door");
        translationBuilder.add("block.elsewhere.poplar_trapdoor", "Poplar Trapdoor");
        translationBuilder.add("block.elsewhere.poplar_pressure_plate", "Poplar Pressure Plate");
        translationBuilder.add("block.elsewhere.poplar_button", "Poplar Button");

        translationBuilder.add("block.elsewhere.poplar_sign", "Poplar Sign");
        translationBuilder.add("block.elsewhere.poplar_wall_sign", "Poplar Wall Sign");
        translationBuilder.add("block.elsewhere.poplar_hanging_sign", "Poplar Hanging Sign");
        translationBuilder.add("block.elsewhere.poplar_wall_hanging_sign", "Poplar Wall Hanging Sign");

        translationBuilder.add("item.elsewhere.poplar_sign", "Poplar Sign");
        translationBuilder.add("item.elsewhere.poplar_hanging_sign", "Poplar Hanging Sign");
        translationBuilder.add("item.elsewhere.poplar_boat", "Poplar Boat");
        translationBuilder.add("item.elsewhere.poplar_chest_boat", "Poplar Boat with Chest");

        translationBuilder.add("entity.elsewhere.poplar_boat", "Poplar Boat");
        translationBuilder.add("entity.elsewhere.poplar_chest_boat", "Poplar Boat with Chest");

        translationBuilder.add("block.elsewhere.poplar_sapling", "Poplar Sapling");
        translationBuilder.add("block.elsewhere.red_poplar_leaves", "Red Poplar Leaves");
        translationBuilder.add("block.elsewhere.orange_poplar_leaves", "Orange Poplar Leaves");
        translationBuilder.add("block.elsewhere.yellow_poplar_leaves", "Yellow Poplar Leaves");

        translationBuilder.add("block.elsewhere.azalea_log", "Azalea Log");
        translationBuilder.add("block.elsewhere.stripped_azalea_log", "Stripped Azalea Log");
        translationBuilder.add("block.elsewhere.azalea_wood", "Azalea Wood");
        translationBuilder.add("block.elsewhere.stripped_azalea_wood", "Stripped Azalea Wood");

        translationBuilder.add("block.elsewhere.azalea_planks", "Azalea Planks");
        translationBuilder.add("block.elsewhere.azalea_stairs", "Azalea Stairs");
        translationBuilder.add("block.elsewhere.azalea_slab", "Azalea Slab");
        translationBuilder.add("block.elsewhere.azalea_mosaic", "Azalea Mosaic");
        translationBuilder.add("block.elsewhere.azalea_mosaic_stairs", "Azalea Mosaic Stairs");
        translationBuilder.add("block.elsewhere.azalea_mosaic_slab", "Azalea Mosaic Slab");
        translationBuilder.add("block.elsewhere.azalea_boards", "Azalea Boards");
        translationBuilder.add("block.elsewhere.azalea_trim", "Azalea Trim");

        translationBuilder.add("block.elsewhere.azalea_fence", "Azalea Fence");
        translationBuilder.add("block.elsewhere.azalea_fence_gate", "Azalea Fence Gate");
        translationBuilder.add("block.elsewhere.azalea_door", "Azalea Door");
        translationBuilder.add("block.elsewhere.azalea_trapdoor", "Azalea Trapdoor");
        translationBuilder.add("block.elsewhere.azalea_pressure_plate", "Azalea Pressure Plate");
        translationBuilder.add("block.elsewhere.azalea_button", "Azalea Button");

        translationBuilder.add("block.elsewhere.azalea_sign", "Azalea Sign");
        translationBuilder.add("block.elsewhere.azalea_wall_sign", "Azalea Wall Sign");
        translationBuilder.add("block.elsewhere.azalea_hanging_sign", "Azalea Hanging Sign");
        translationBuilder.add("block.elsewhere.azalea_wall_hanging_sign", "Azalea Wall Hanging Sign");

        translationBuilder.add("item.elsewhere.azalea_sign", "Azalea Sign");
        translationBuilder.add("item.elsewhere.azalea_hanging_sign", "Azalea Hanging Sign");
        translationBuilder.add("item.elsewhere.azalea_boat", "Azalea Boat");
        translationBuilder.add("item.elsewhere.azalea_chest_boat", "Azalea Boat with Chest");

        translationBuilder.add("entity.elsewhere.azalea_boat", "Azalea Boat");
        translationBuilder.add("entity.elsewhere.azalea_chest_boat", "Azalea Boat with Chest");

        translationBuilder.add("block.elsewhere.rusty_moss_block", "Rusty Moss Block");
        translationBuilder.add("block.elsewhere.rusty_moss_carpet", "Rusty Moss Carpet");

        translationBuilder.add("item.elsewhere.diamond_shard", "Diamond Shard");
        translationBuilder.add("item.elsewhere.emerald_shard", "Emerald Shard");
        translationBuilder.add("block.elsewhere.bejeweled_calcite", "Bejeweled Calcite");

        translationBuilder.add("block.elsewhere.laterite", "Laterite");

        translationBuilder.add("block.elsewhere.pebble", "Pebble");

        translationBuilder.add("block.elsewhere.white_wool_stairs", "White Wool Stairs");
        translationBuilder.add("block.elsewhere.white_wool_slab", "White Wool Slab");
        translationBuilder.add("block.elsewhere.light_gray_wool_stairs", "Light Gray Wool Stairs");
        translationBuilder.add("block.elsewhere.light_gray_wool_slab", "Light Gray Wool Slab");
        translationBuilder.add("block.elsewhere.gray_wool_stairs", "Gray Wool Stairs");
        translationBuilder.add("block.elsewhere.gray_wool_slab", "Gray Wool Slab");
        translationBuilder.add("block.elsewhere.black_wool_stairs", "Black Wool Stairs");
        translationBuilder.add("block.elsewhere.black_wool_slab", "Black Wool Slab");
        translationBuilder.add("block.elsewhere.brown_wool_stairs", "Brown Wool Stairs");
        translationBuilder.add("block.elsewhere.brown_wool_slab", "Brown Wool Slab");
        translationBuilder.add("block.elsewhere.red_wool_stairs", "Red Wool Stairs");
        translationBuilder.add("block.elsewhere.red_wool_slab", "Red Wool Slab");
        translationBuilder.add("block.elsewhere.orange_wool_stairs", "Orange Wool Stairs");
        translationBuilder.add("block.elsewhere.orange_wool_slab", "Orange Wool Slab");
        translationBuilder.add("block.elsewhere.yellow_wool_stairs", "Yellow Wool Stairs");
        translationBuilder.add("block.elsewhere.yellow_wool_slab", "Yellow Wool Slab");
        translationBuilder.add("block.elsewhere.lime_wool_stairs", "Lime Wool Stairs");
        translationBuilder.add("block.elsewhere.lime_wool_slab", "Lime Wool Slab");
        translationBuilder.add("block.elsewhere.green_wool_stairs", "Green Wool Stairs");
        translationBuilder.add("block.elsewhere.green_wool_slab", "Green Wool Slab");
        translationBuilder.add("block.elsewhere.cyan_wool_stairs", "Cyan Wool Stairs");
        translationBuilder.add("block.elsewhere.cyan_wool_slab", "Cyan Wool Slab");
        translationBuilder.add("block.elsewhere.light_blue_wool_stairs", "Light Blue Wool Stairs");
        translationBuilder.add("block.elsewhere.light_blue_wool_slab", "Light Blue Wool Slab");
        translationBuilder.add("block.elsewhere.blue_wool_stairs", "Blue Wool Stairs");
        translationBuilder.add("block.elsewhere.blue_wool_slab", "Blue Wool Slab");
        translationBuilder.add("block.elsewhere.purple_wool_stairs", "Purple Wool Stairs");
        translationBuilder.add("block.elsewhere.purple_wool_slab", "Purple Wool Slab");
        translationBuilder.add("block.elsewhere.magenta_wool_stairs", "Magenta Wool Stairs");
        translationBuilder.add("block.elsewhere.magenta_wool_slab", "Magenta Wool Slab");
        translationBuilder.add("block.elsewhere.pink_wool_stairs", "Pink Wool Stairs");
        translationBuilder.add("block.elsewhere.pink_wool_slab", "Pink Wool Slab");

        translationBuilder.add("block.elsewhere.terracotta_stairs", "Terracotta Stairs");
        translationBuilder.add("block.elsewhere.terracotta_slab", "Terracotta Slab");
        translationBuilder.add("block.elsewhere.white_terracotta_stairs", "White Terracotta Stairs");
        translationBuilder.add("block.elsewhere.white_terracotta_slab", "White Terracotta Slab");
        translationBuilder.add("block.elsewhere.light_gray_terracotta_stairs", "Light Gray Terracotta Stairs");
        translationBuilder.add("block.elsewhere.light_gray_terracotta_slab", "Light Gray Terracotta Slab");
        translationBuilder.add("block.elsewhere.gray_terracotta_stairs", "Gray Terracotta Stairs");
        translationBuilder.add("block.elsewhere.gray_terracotta_slab", "Gray Terracotta Slab");
        translationBuilder.add("block.elsewhere.black_terracotta_stairs", "Black Terracotta Stairs");
        translationBuilder.add("block.elsewhere.black_terracotta_slab", "Black Terracotta Slab");
        translationBuilder.add("block.elsewhere.brown_terracotta_stairs", "Brown Terracotta Stairs");
        translationBuilder.add("block.elsewhere.brown_terracotta_slab", "Brown Terracotta Slab");
        translationBuilder.add("block.elsewhere.red_terracotta_stairs", "Red Terracotta Stairs");
        translationBuilder.add("block.elsewhere.red_terracotta_slab", "Red Terracotta Slab");
        translationBuilder.add("block.elsewhere.orange_terracotta_stairs", "Orange Terracotta Stairs");
        translationBuilder.add("block.elsewhere.orange_terracotta_slab", "Orange Terracotta Slab");
        translationBuilder.add("block.elsewhere.yellow_terracotta_stairs", "Yellow Terracotta Stairs");
        translationBuilder.add("block.elsewhere.yellow_terracotta_slab", "Yellow Terracotta Slab");
        translationBuilder.add("block.elsewhere.lime_terracotta_stairs", "Lime Terracotta Stairs");
        translationBuilder.add("block.elsewhere.lime_terracotta_slab", "Lime Terracotta Slab");
        translationBuilder.add("block.elsewhere.green_terracotta_stairs", "Green Terracotta Stairs");
        translationBuilder.add("block.elsewhere.green_terracotta_slab", "Green Terracotta Slab");
        translationBuilder.add("block.elsewhere.cyan_terracotta_stairs", "Cyan Terracotta Stairs");
        translationBuilder.add("block.elsewhere.cyan_terracotta_slab", "Cyan Terracotta Slab");
        translationBuilder.add("block.elsewhere.light_blue_terracotta_stairs", "Light Blue Terracotta Stairs");
        translationBuilder.add("block.elsewhere.light_blue_terracotta_slab", "Light Blue Terracotta Slab");
        translationBuilder.add("block.elsewhere.blue_terracotta_stairs", "Blue Terracotta Stairs");
        translationBuilder.add("block.elsewhere.blue_terracotta_slab", "Blue Terracotta Slab");
        translationBuilder.add("block.elsewhere.purple_terracotta_stairs", "Purple Terracotta Stairs");
        translationBuilder.add("block.elsewhere.purple_terracotta_slab", "Purple Terracotta Slab");
        translationBuilder.add("block.elsewhere.magenta_terracotta_stairs", "Magenta Terracotta Stairs");
        translationBuilder.add("block.elsewhere.magenta_terracotta_slab", "Magenta Terracotta Slab");
        translationBuilder.add("block.elsewhere.pink_terracotta_stairs", "Pink Terracotta Stairs");
        translationBuilder.add("block.elsewhere.pink_terracotta_slab", "Pink Terracotta Slab");

        translationBuilder.add("block.elsewhere.white_concrete_stairs", "White Concrete Stairs");
        translationBuilder.add("block.elsewhere.white_concrete_slab", "White Concrete Slab");
        translationBuilder.add("block.elsewhere.light_gray_concrete_stairs", "Light Gray Concrete Stairs");
        translationBuilder.add("block.elsewhere.light_gray_concrete_slab", "Light Gray Concrete Slab");
        translationBuilder.add("block.elsewhere.gray_concrete_stairs", "Gray Concrete Stairs");
        translationBuilder.add("block.elsewhere.gray_concrete_slab", "Gray Concrete Slab");
        translationBuilder.add("block.elsewhere.black_concrete_stairs", "Black Concrete Stairs");
        translationBuilder.add("block.elsewhere.black_concrete_slab", "Black Concrete Slab");
        translationBuilder.add("block.elsewhere.brown_concrete_stairs", "Brown Concrete Stairs");
        translationBuilder.add("block.elsewhere.brown_concrete_slab", "Brown Concrete Slab");
        translationBuilder.add("block.elsewhere.red_concrete_stairs", "Red Concrete Stairs");
        translationBuilder.add("block.elsewhere.red_concrete_slab", "Red Concrete Slab");
        translationBuilder.add("block.elsewhere.orange_concrete_stairs", "Orange Concrete Stairs");
        translationBuilder.add("block.elsewhere.orange_concrete_slab", "Orange Concrete Slab");
        translationBuilder.add("block.elsewhere.yellow_concrete_stairs", "Yellow Concrete Stairs");
        translationBuilder.add("block.elsewhere.yellow_concrete_slab", "Yellow Concrete Slab");
        translationBuilder.add("block.elsewhere.lime_concrete_stairs", "Lime Concrete Stairs");
        translationBuilder.add("block.elsewhere.lime_concrete_slab", "Lime Concrete Slab");
        translationBuilder.add("block.elsewhere.green_concrete_stairs", "Green Concrete Stairs");
        translationBuilder.add("block.elsewhere.green_concrete_slab", "Green Concrete Slab");
        translationBuilder.add("block.elsewhere.cyan_concrete_stairs", "Cyan Concrete Stairs");
        translationBuilder.add("block.elsewhere.cyan_concrete_slab", "Cyan Concrete Slab");
        translationBuilder.add("block.elsewhere.light_blue_concrete_stairs", "Light Blue Concrete Stairs");
        translationBuilder.add("block.elsewhere.light_blue_concrete_slab", "Light Blue Concrete Slab");
        translationBuilder.add("block.elsewhere.blue_concrete_stairs", "Blue Concrete Stairs");
        translationBuilder.add("block.elsewhere.blue_concrete_slab", "Blue Concrete Slab");
        translationBuilder.add("block.elsewhere.purple_concrete_stairs", "Purple Concrete Stairs");
        translationBuilder.add("block.elsewhere.purple_concrete_slab", "Purple Concrete Slab");
        translationBuilder.add("block.elsewhere.magenta_concrete_stairs", "Magenta Concrete Stairs");
        translationBuilder.add("block.elsewhere.magenta_concrete_slab", "Magenta Concrete Slab");
        translationBuilder.add("block.elsewhere.pink_concrete_stairs", "Pink Concrete Stairs");
        translationBuilder.add("block.elsewhere.pink_concrete_slab", "Pink Concrete Slab");

        translationBuilder.add("block.elsewhere.tin_ore", "Tin Ore");
        translationBuilder.add("block.elsewhere.shale_tin_ore", "Shale Tin Ore");
        translationBuilder.add("block.elsewhere.deepslate_tin_ore", "Deepslate Tin Ore");
        translationBuilder.add("block.elsewhere.cinnabar_tin_ore", "Cinnabar Tin Ore");
        translationBuilder.add("item.elsewhere.raw_tin", "Raw Tin");
        translationBuilder.add("item.elsewhere.tin_ingot", "Tin Ingot");
        translationBuilder.add("item.elsewhere.tin_nugget", "Tin Nugget");
        translationBuilder.add("block.elsewhere.tin_block", "Block of Tin");
        translationBuilder.add("block.elsewhere.raw_tin_block", "Block of Raw Tin");

        translationBuilder.add("item.elsewhere.bronze_mix", "Bronze Mix");
        translationBuilder.add("item.elsewhere.bronze_ingot", "Bronze Ingot");
        translationBuilder.add("item.elsewhere.bronze_nugget", "Bronze Nugget");
        translationBuilder.add("block.elsewhere.bronze_block", "Block of Bronze");
        translationBuilder.add("item.elsewhere.bronze_helmet", "Bronze Helmet");
        translationBuilder.add("item.elsewhere.bronze_chestplate", "Bronze Chestplate");
        translationBuilder.add("item.elsewhere.bronze_leggings", "Bronze Leggings");
        translationBuilder.add("item.elsewhere.bronze_boots", "Bronze Boots");
        translationBuilder.add("item.elsewhere.bronze_sword", "Bronze Sword");
        translationBuilder.add("item.elsewhere.bronze_axe", "Bronze Axe");
        translationBuilder.add("item.elsewhere.bronze_spear", "Bronze Spear");
        translationBuilder.add("item.elsewhere.bronze_pickaxe", "Bronze Pickaxe");
        translationBuilder.add("item.elsewhere.bronze_shovel", "Bronze Shovel");
        translationBuilder.add("item.elsewhere.bronze_hoe", "Bronze Hoe");

        translationBuilder.add("block.elsewhere.silver_ore", "Silver Ore");
        translationBuilder.add("block.elsewhere.shale_silver_ore", "Shale Silver Ore");
        translationBuilder.add("block.elsewhere.deepslate_silver_ore", "Deepslate Silver Ore");
        translationBuilder.add("block.elsewhere.cinnabar_silver_ore", "Cinnabar Silver Ore");
        translationBuilder.add("item.elsewhere.raw_silver", "Raw Silver");
        translationBuilder.add("item.elsewhere.silver_ingot", "Silver Ingot");
        translationBuilder.add("item.elsewhere.silver_nugget", "Silver Nugget");
        translationBuilder.add("block.elsewhere.silver_block", "Block of Silver");
        translationBuilder.add("block.elsewhere.raw_silver_block", "Block of Raw Silver");
        translationBuilder.add("item.elsewhere.silver_helmet", "Silver Helmet");
        translationBuilder.add("item.elsewhere.silver_chestplate", "Silver Chestplate");
        translationBuilder.add("item.elsewhere.silver_leggings", "Silver Leggings");
        translationBuilder.add("item.elsewhere.silver_boots", "Silver Boots");
        translationBuilder.add("item.elsewhere.silver_sword", "Silver Sword");
        translationBuilder.add("item.elsewhere.silver_axe", "Silver Axe");
        translationBuilder.add("item.elsewhere.silver_spear", "Silver Spear");
        translationBuilder.add("item.elsewhere.silver_pickaxe", "Silver Pickaxe");
        translationBuilder.add("item.elsewhere.silver_shovel", "Silver Shovel");
        translationBuilder.add("item.elsewhere.silver_hoe", "Silver Hoe");

        translationBuilder.add("item.elsewhere.soulsteel_ingot", "Soulsteel Ingot");
        translationBuilder.add("block.elsewhere.soulsteel_block", "Block of Soulsteel");
        translationBuilder.add("item.elsewhere.soulsteel_helmet", "Soulsteel Helmet");
        translationBuilder.add("item.elsewhere.soulsteel_chestplate", "Soulsteel Chestplate");
        translationBuilder.add("item.elsewhere.soulsteel_leggings", "Soulsteel Leggings");
        translationBuilder.add("item.elsewhere.soulsteel_boots", "Soulsteel Boots");
        translationBuilder.add("item.elsewhere.soulsteel_sword", "Soulsteel Sword");
        translationBuilder.add("item.elsewhere.soulsteel_axe", "Soulsteel Axe");
        translationBuilder.add("item.elsewhere.soulsteel_spear", "Soulsteel Spear");
        translationBuilder.add("item.elsewhere.soulsteel_pickaxe", "Soulsteel Pickaxe");
        translationBuilder.add("item.elsewhere.soulsteel_shovel", "Soulsteel Shovel");
        translationBuilder.add("item.elsewhere.soulsteel_hoe", "Soulsteel Hoe");



        translationBuilder.add("biome.elsewhere.outback", "Outback");
        translationBuilder.add("biome.elsewhere.tundra", "Tundra");
        translationBuilder.add("biome.elsewhere.dappled_forest", "Dappled Forest");

        translationBuilder.add("biome.elsewhere.cold_river", "Cold River");
        translationBuilder.add("biome.elsewhere.lukewarm_river", "Lukewarm River");
        translationBuilder.add("biome.elsewhere.warm_river", "Warm River");

        translationBuilder.add("biome.elsewhere.sulfur_caves", "Sulfur Caves");
        translationBuilder.add("biome.elsewhere.crystalline_caves", "Crystalline Caves");
        translationBuilder.add("biome.elsewhere.arid_caves", "Arid Caves");
        translationBuilder.add("biome.elsewhere.frigid_caves", "Frigid Caves");



        translationBuilder.add("entity.elsewhere.frostbite", "Frostbite");
        translationBuilder.add("item.elsewhere.frostbite_spawn_egg", "Frostbite Spawn Egg");

        translationBuilder.add("entity.elsewhere.perch", "Perch");
        translationBuilder.add("item.elsewhere.perch_spawn_egg", "Perch Spawn Egg");
        translationBuilder.add("item.elsewhere.raw_perch", "Raw Perch");
        translationBuilder.add("item.elsewhere.cooked_perch", "Cooked Perch");
        translationBuilder.add("item.elsewhere.perch_bucket", "Bucket of Perch");


        translationBuilder.add("tag.elsewhere.mosaics", "Mosaics");
        translationBuilder.add("tag.elsewhere.mosaic_stairs", "Mosaic Stairs");
        translationBuilder.add("tag.elsewhere.mosaic_slabs", "Mosaic Slabs");
        translationBuilder.add("tag.elsewhere.boards", "Boards");
        translationBuilder.add("tag.elsewhere.trims", "Trims");
        translationBuilder.add("tag.elsewhere.bamboo_stems", "Bamboo Stems");

        translationBuilder.add("tag.elsewhere.shale_ore_replaceables", "Shale Ore Replaceables");
        translationBuilder.add("tag.elsewhere.cinnabar_ore_replaceables", "Cinnabar Ore Replaceables");
        translationBuilder.add("tag.elsewhere.calcite_ore_replaceables", "Calcite Ore Replaceables");
        translationBuilder.add("tag.elsewhere.sulfur_spike_replaceable", "Sulfur Spike Replaceable");
        translationBuilder.add("tag.elsewhere.icicle_replaceable", "Icicle Replaceable");

        translationBuilder.add("tag.elsewhere.tundra_red_grass", "Tundra Red Grass");
        translationBuilder.add("tag.elsewhere.tundra_green_grass", "Tundra Green Grass");

        translationBuilder.add("tag.elsewhere.needs_copper_tool", "Needs Copper Tool");
        translationBuilder.add("tag.elsewhere.needs_bronze_tool", "Needs Bronze Tool");
        translationBuilder.add("tag.elsewhere.incorrect_for_bronze_tool", "Incorrect For Bronze Tool");



        // Generic Subtitles
        translationBuilder.add("subtitles.elsewhere.block.generic.break", "Block broken");
        translationBuilder.add("subtitles.elsewhere.block.generic.fall", "Something falls on a block");
        translationBuilder.add("subtitles.elsewhere.block.generic.step", "Footsteps");
        translationBuilder.add("subtitles.elsewhere.block.generic.hit", "Block breaking");
        translationBuilder.add("subtitles.elsewhere.block.generic.place", "Block placed");

        // Sulfur Pool Sounds
        translationBuilder.add("subtitles.elsewhere.block.sulfur.noxious_gas", "Noxious gas bubbles");
        translationBuilder.add("subtitles.elsewhere.block.geyser.eruption_start", "Geyser erupts");
        translationBuilder.add("subtitles.elsewhere.block.geyser.eruption_active", "Geyser spraying");

        // Mob Sounds
        translationBuilder.add("subtitles.elsewhere.entity.frostbite.idle", "Frostbite groans");
        translationBuilder.add("subtitles.elsewhere.entity.frostbite.hurt", "Frostbite hurts");
        translationBuilder.add("subtitles.elsewhere.entity.frostbite.death", "Frostbite dies");

        translationBuilder.add("subtitles.elsewhere.entity.perch.flop", "Perch flops");
        translationBuilder.add("subtitles.elsewhere.entity.perch.hurt", "Perch hurts");
        translationBuilder.add("subtitles.elsewhere.entity.perch.death", "Perch dies");







    }
}
