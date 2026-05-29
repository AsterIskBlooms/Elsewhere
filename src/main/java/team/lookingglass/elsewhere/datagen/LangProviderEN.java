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

        translationBuilder.add("block.elsewhere.silver_ore", "Silver Ore");
        translationBuilder.add("block.elsewhere.shale_silver_ore", "Shale Silver Ore");
        translationBuilder.add("block.elsewhere.deepslate_silver_ore", "Deepslate Silver Ore");

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
        translationBuilder.add("block.elsewhere.cinnabar_silver_ore", "Cinnabar Silver Ore");
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


        translationBuilder.add("block.elsewhere.oak_mosaic", "Oak Mosaic");
        translationBuilder.add("block.elsewhere.oak_mosaic_stairs", "Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.oak_mosaic_slab", "Oak Mosaic Slab");

        translationBuilder.add("block.elsewhere.dark_oak_mosaic", "Dark Oak Mosaic");
        translationBuilder.add("block.elsewhere.dark_oak_mosaic_stairs", "Dark Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.dark_oak_mosaic_slab", "Dark Oak Mosaic Slab");

        translationBuilder.add("block.elsewhere.pale_oak_mosaic", "Pale Oak Mosaic");
        translationBuilder.add("block.elsewhere.pale_oak_mosaic_stairs", "Pale Oak Mosaic Stairs");
        translationBuilder.add("block.elsewhere.pale_oak_mosaic_slab", "Pale Oak Mosaic Slab");

        translationBuilder.add("block.elsewhere.birch_mosaic", "Birch Mosaic");
        translationBuilder.add("block.elsewhere.birch_mosaic_stairs", "Birch Mosaic Stairs");
        translationBuilder.add("block.elsewhere.birch_mosaic_slab", "Birch Mosaic Slab");

        translationBuilder.add("block.elsewhere.spruce_mosaic", "Spruce Mosaic");
        translationBuilder.add("block.elsewhere.spruce_mosaic_stairs", "Spruce Mosaic Stairs");
        translationBuilder.add("block.elsewhere.spruce_mosaic_slab", "Spruce Mosaic Slab");

        translationBuilder.add("block.elsewhere.jungle_mosaic", "Jungle Mosaic");
        translationBuilder.add("block.elsewhere.jungle_mosaic_stairs", "Jungle Mosaic Stairs");
        translationBuilder.add("block.elsewhere.jungle_mosaic_slab", "Jungle Mosaic Slab");

        translationBuilder.add("block.elsewhere.acacia_mosaic", "Acacia Mosaic");
        translationBuilder.add("block.elsewhere.acacia_mosaic_stairs", "Acacia Mosaic Stairs");
        translationBuilder.add("block.elsewhere.acacia_mosaic_slab", "Acacia Mosaic Slab");

        translationBuilder.add("block.elsewhere.cherry_mosaic", "Cherry Mosaic");
        translationBuilder.add("block.elsewhere.cherry_mosaic_stairs", "Cherry Mosaic Stairs");
        translationBuilder.add("block.elsewhere.cherry_mosaic_slab", "Cherry Mosaic Slab");

        translationBuilder.add("block.elsewhere.mangrove_mosaic", "Mangrove Mosaic");
        translationBuilder.add("block.elsewhere.mangrove_mosaic_stairs", "Mangrove Mosaic Stairs");
        translationBuilder.add("block.elsewhere.mangrove_mosaic_slab", "Mangrove Mosaic Slab");

        translationBuilder.add("block.elsewhere.crimson_mosaic", "Crimson Mosaic");
        translationBuilder.add("block.elsewhere.crimson_mosaic_stairs", "Crimson Mosaic Stairs");
        translationBuilder.add("block.elsewhere.crimson_mosaic_slab", "Crimson Mosaic Slab");

        translationBuilder.add("block.elsewhere.warped_mosaic", "Warped Mosaic");
        translationBuilder.add("block.elsewhere.warped_mosaic_stairs", "Warped Mosaic Stairs");
        translationBuilder.add("block.elsewhere.warped_mosaic_slab", "Warped Mosaic Slab");

        translationBuilder.add("block.elsewhere.bluebonnet", "Bluebonnet");
        translationBuilder.add("block.elsewhere.potted_bluebonnet", "Potted Bluebonnet");

        translationBuilder.add("block.elsewhere.arid_dirt", "Arid Dirt");


        translationBuilder.add("item.elsewhere.raw_silver", "Raw Silver");
        translationBuilder.add("item.elsewhere.silver_ingot", "Silver Ingot");
        translationBuilder.add("item.elsewhere.silver_nugget", "Silver Nugget");
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
        translationBuilder.add("item.elsewhere.soulsteel_nugget", "Soulsteel Nugget");
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
        translationBuilder.add("biome.elsewhere.sulfur_caves", "Sulfur Caves");
        translationBuilder.add("biome.elsewhere.crystalline_caves", "Crystalline Caves");




        translationBuilder.add("tag.elsewhere.mosaics", "Mosaics");
        translationBuilder.add("tag.elsewhere.shale_ore_replaceables", "Shale Ore Replaceables");
        translationBuilder.add("tag.elsewhere.cinnabar_ore_replaceables", "Cinnabar Ore Replaceables");
        translationBuilder.add("tag.elsewhere.sulfur_spike_replaceable", "Sulfur Spike Replaceable");
        translationBuilder.add("tag.elsewhere.icicle_replaceable", "Icicle Replaceable");
        translationBuilder.add("tag.elsewhere.repairs_silver_armor", "Repairs Silver Armor");
        translationBuilder.add("tag.elsewhere.repairs_soulsteel_armor", "Repairs Soulsteel Armor");







    }
}
