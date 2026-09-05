package team.lookingglass.elsewhere.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ETabs {

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.insertAfter(Items.GRASS_BLOCK, EBlocks.ARID_GRASS_BLOCK, EBlocks.RED_GRASS_BLOCK);
            output.insertAfter(Items.DIRT, EBlocks.ARID_DIRT);
            output.insertAfter(Items.PODZOL, EBlocks.LATERITE);
            output.insertAfter(Items.PACKED_ICE, EBlocks.ICICLE);

            output.insertAfter(Items.SANDSTONE, EBlocks.PINK_SAND, EBlocks.PINK_SANDSTONE);

            output.insertAfter(Items.SHORT_GRASS,
                    EBlocks.SHORT_RED_GRASS,
                    EBlocks.SHORT_MOSS_SPOROPHYTE, EBlocks.SHORT_RUSTY_MOSS_SPOROPHYTE, EBlocks.SHORT_PALE_MOSS_SPOROPHYTE
            );
            output.insertAfter(Items.TALL_GRASS,
                    EBlocks.TALL_RED_GRASS,
                    EBlocks.TALL_MOSS_SPOROPHYTE, EBlocks.TALL_RUSTY_MOSS_SPOROPHYTE, EBlocks.TALL_PALE_MOSS_SPOROPHYTE
            );
            output.insertAfter(Items.DRY_SHORT_GRASS, EBlocks.CAVE_WEED);
            output.insertAfter(Items.DEAD_BUSH, EBlocks.RED_SHRUB);
            output.insertAfter(Items.RED_MUSHROOM, EBlocks.GLEAMSHROOM);
            output.insertAfter(Items.LARGE_FERN, EBlocks.CATTAILS);

            output.insertAfter(Items.MOSS_CARPET, EBlocks.RUSTY_MOSS_BLOCK, EBlocks.RUSTY_MOSS_CARPET);
            output.insertAfter(Items.MUD, EBlocks.MOSSY_MUD, EBlocks.MUDSTONE);

            output.insertAfter(Items.RED_SANDSTONE, EBlocks.BEACHSTONE);
            output.insertAfter(Items.SMOOTH_BASALT, EBlocks.ROCKWEED_BASALT);
            output.insertAfter(Items.SEAGRASS, EBlocks.SEAGRASS_SAND);

            output.insertAfter(Items.BIRCH_SAPLING, EBlocks.CEDAR_SAPLING);
            output.insertAfter(Items.BIRCH_LOG, EBlocks.CEDAR_LOG);
            output.insertAfter(Items.BIRCH_LEAVES, EBlocks.GILDED_BIRCH_LEAVES, EBlocks.CEDAR_LEAVES);

            output.insertAfter(Items.JUNGLE_SAPLING, EBlocks.MAHOGANY_SAPLING);
            output.insertAfter(Items.JUNGLE_LOG, EBlocks.MAHOGANY_LOG);
            output.insertAfter(Items.JUNGLE_LEAVES, EBlocks.MAHOGANY_LEAVES);

            output.insertAfter(Items.PALE_OAK_SAPLING, EBlocks.POPLAR_SAPLING);
            output.insertAfter(Items.PALE_OAK_LOG, EBlocks.POPLAR_LOG);
            output.insertAfter(Items.PALE_OAK_LEAVES, EBlocks.RED_POPLAR_LEAVES, EBlocks.ORANGE_POPLAR_LEAVES, EBlocks.YELLOW_POPLAR_LEAVES);

            output.insertAfter(Items.STONE, EBlocks.SHALE);
            output.insertAfter(Items.CALCITE, EBlocks.SODALITE);
            output.insertAfter(Items.ANDESITE, EBlocks.LIMESTONE);
            output.insertAfter(Items.POINTED_DRIPSTONE, EBlocks.SULFUR, EBlocks.SULFUR_SPIKE, EBlocks.POTENT_SULFUR, EBlocks.ORPIMENT, EBlocks.CINNABAR);
            output.insertAfter(Items.SOUL_SOIL, EBlocks.SOUL_SANDSTONE);

            output.insertAfter(Items.COAL_ORE, EBlocks.CINNABAR_COAL_ORE, EBlocks.SHALE_COAL_ORE);
            output.insertAfter(Items.IRON_ORE, EBlocks.CINNABAR_IRON_ORE, EBlocks.SHALE_IRON_ORE);
            output.insertAfter(Items.COPPER_ORE, EBlocks.CINNABAR_COPPER_ORE, EBlocks.SHALE_COPPER_ORE);
            output.insertAfter(Items.DEEPSLATE_COPPER_ORE, EBlocks.TIN_ORE, EBlocks.CINNABAR_TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.DEEPSLATE_TIN_ORE);
            output.insertAfter(Items.GOLD_ORE, EBlocks.CINNABAR_GOLD_ORE, EBlocks.SHALE_GOLD_ORE);
            output.insertAfter(Items.DEEPSLATE_GOLD_ORE, EBlocks.SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE);
            output.insertAfter(Items.REDSTONE_ORE, EBlocks.CINNABAR_REDSTONE_ORE, EBlocks.SHALE_REDSTONE_ORE);
            output.insertAfter(Items.EMERALD_ORE, EBlocks.CINNABAR_EMERALD_ORE, EBlocks.SHALE_EMERALD_ORE);
            output.insertAfter(Items.LAPIS_ORE, EBlocks.CINNABAR_LAPIS_ORE, EBlocks.SHALE_LAPIS_ORE);
            output.insertAfter(Items.DIAMOND_ORE, EBlocks.CINNABAR_DIAMOND_ORE, EBlocks.SHALE_DIAMOND_ORE);

            output.insertBefore(Items.GILDED_BLACKSTONE, EBlocks.BEJEWELED_CALCITE);

            output.insertAfter(Items.RAW_COPPER_BLOCK, EBlocks.RAW_TIN_BLOCK);
            output.insertAfter(Items.RAW_GOLD_BLOCK, EBlocks.RAW_SILVER_BLOCK);

            output.insertAfter(Items.LILY_OF_THE_VALLEY, EBlocks.BLUEBONNET, EBlocks.YELLOW_CONEFLOWER, EBlocks.MAGENTA_CONEFLOWER);
            output.insertAfter(Items.PINK_TULIP,
                    EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS,
                    EBlocks.BLUE_HIBISCUS, EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
            );
            output.insertAfter(Items.DANDELION, EBlocks.ROSE);
            output.insertAfter(Items.LEAF_LITTER, EBlocks.PEBBLE);

        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {

            // Stone & Shale
            output.insertAfter(Items.STONE_SLAB, EBlocks.STONE_WALL);

            output.insertAfter(Items.SMOOTH_STONE_SLAB,
                    EBlocks.SMOOTH_STONE_STAIRS, EBlocks.SMOOTH_STONE_WALL,
                    EBlocks.CHISELED_STONE,
                    EBlocks.STONE_PILLAR,
                    EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_SLAB, EBlocks.POLISHED_STONE_WALL
            );

            output.insertAfter(Items.MOSSY_STONE_BRICK_WALL,
                    EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_SLAB, EBlocks.STONE_TILE_WALL,
                    EBlocks.MOSSY_STONE_TILES, EBlocks.MOSSY_STONE_TILE_STAIRS, EBlocks.MOSSY_STONE_TILE_SLAB, EBlocks.MOSSY_STONE_TILE_WALL,

                    // Shale
                    EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL,
                    EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL,
                    EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL,
                    EBlocks.CHISELED_SHALE, EBlocks.SHALE_PILLAR,
                    EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL,
                    EBlocks.CHISELED_SHALE_BRICKS,
                    EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL
            );

            // Deepslate
            output.insertAfter(Items.DEEPSLATE,
                    EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL);
            output.insertAfter(Items.CHISELED_DEEPSLATE, EBlocks.DEEPSLATE_PILLAR);
            output.insertAfter(Items.DEEPSLATE_BRICK_WALL, EBlocks.CHISELED_DEEPSLATE_BRICKS);

            // Granite, Diorite, Andesite
            output.insertAfter(Items.GRANITE_WALL, EBlocks.CHISELED_GRANITE);
            output.insertAfter(Items.POLISHED_GRANITE_SLAB,
                    EBlocks.POLISHED_GRANITE_WALL,
                    EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_SLAB, EBlocks.GRANITE_BRICK_WALL);

            output.insertAfter(Items.DIORITE_WALL, EBlocks.CHISELED_DIORITE);
            output.insertAfter(Items.POLISHED_DIORITE_SLAB,
                    EBlocks.POLISHED_DIORITE_WALL,
                    EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_SLAB, EBlocks.DIORITE_BRICK_WALL);

            output.insertAfter(Items.ANDESITE_WALL,
                    EBlocks.CHISELED_ANDESITE, EBlocks.ANDESITE_PILLAR);
            output.insertAfter(Items.POLISHED_ANDESITE_SLAB,
                    EBlocks.POLISHED_ANDESITE_WALL,
                    EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_SLAB, EBlocks.ANDESITE_BRICK_WALL);

            // Tuff
            output.insertAfter(Items.CHISELED_TUFF, EBlocks.TUFF_PILLAR);

            // Calcite, Sodalite, Dripstone, Sulfur, Orpiment, & Cinnabar
            output.insertAfter(Items.CHISELED_TUFF_BRICKS,
                    Blocks.CALCITE, EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_SLAB, EBlocks.CALCITE_WALL,
                    EBlocks.CHISELED_CALCITE, EBlocks.CALCITE_PILLAR,
                    EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.POLISHED_CALCITE_WALL,
                    EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_SLAB, EBlocks.CALCITE_BRICK_WALL,
                    EBlocks.CHISELED_CALCITE_BRICKS,

                    EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_SLAB, EBlocks.SODALITE_WALL,
                    EBlocks.CHISELED_SODALITE, EBlocks.SODALITE_PILLAR,
                    EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.POLISHED_SODALITE_WALL,
                    EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_SLAB, EBlocks.SODALITE_BRICK_WALL,
                    EBlocks.CHISELED_SODALITE_BRICKS,

                    Blocks.DRIPSTONE_BLOCK, EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_SLAB, EBlocks.DRIPSTONE_WALL,EBlocks.DRIPSTONE_PILLAR,
                    EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_WALL,
                    EBlocks.DRIPSTONE_TILES, EBlocks.DRIPSTONE_TILE_STAIRS, EBlocks.DRIPSTONE_TILE_SLAB, EBlocks.DRIPSTONE_TILE_WALL,
                    EBlocks.CHISELED_DRIPSTONE_TILES,

                    EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_SLAB, EBlocks.SULFUR_WALL,
                    EBlocks.CHISELED_SULFUR, EBlocks.SULFUR_PILLAR,
                    EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.POLISHED_SULFUR_WALL,
                    EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_SLAB, EBlocks.SULFUR_BRICK_WALL,

                    EBlocks.ORPIMENT, EBlocks.ORPIMENT_STAIRS, EBlocks.ORPIMENT_SLAB, EBlocks.ORPIMENT_WALL,
                    EBlocks.CHISELED_ORPIMENT, EBlocks.ORPIMENT_PILLAR,
                    EBlocks.POLISHED_ORPIMENT, EBlocks.POLISHED_ORPIMENT_STAIRS, EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.POLISHED_ORPIMENT_WALL,
                    EBlocks.ORPIMENT_BRICKS, EBlocks.ORPIMENT_BRICK_STAIRS, EBlocks.ORPIMENT_BRICK_SLAB, EBlocks.ORPIMENT_BRICK_WALL,

                    EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_SLAB, EBlocks.CINNABAR_WALL,
                    EBlocks.CHISELED_CINNABAR, EBlocks.CINNABAR_PILLAR,
                    EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_WALL,
                    EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_SLAB, EBlocks.CINNABAR_BRICK_WALL);

            // Prismarine
            output.insertAfter(Items.PRISMARINE_WALL,
                    EBlocks.CHISELED_PRISMARINE, EBlocks.PRISMARINE_PILLAR,
                    EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_WALL);
            output.insertAfter(Items.PRISMARINE_BRICK_SLAB,
                    EBlocks.PRISMARINE_BRICK_WALL);

            output.insertAfter(Items.DARK_PRISMARINE_SLAB,
                    EBlocks.DARK_PRISMARINE_WALL,
                    EBlocks.CHISELED_DARK_PRISMARINE,
                    EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_WALL,
                    EBlocks.DARK_PRISMARINE_SCALES, EBlocks.DARK_PRISMARINE_SCALE_STAIRS, EBlocks.DARK_PRISMARINE_SCALE_SLAB, EBlocks.DARK_PRISMARINE_SCALE_WALL);

            output.insertAfter(Items.NETHERRACK,
                    EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_SLAB, EBlocks.NETHERRACK_WALL,
                    EBlocks.CHISELED_NETHERRACK, EBlocks.NETHERRACK_PILLAR,
                    EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_WALL,
                    EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.NETHERRACK_BRICK_WALL,
                    EBlocks.CHISELED_NETHERRACK_BRICKS);

            output.insertAfter(Items.BLACKSTONE_WALL, EBlocks.BLACKSTONE_PILLAR);

            // Basalt & End Stone
            output.insertAfter(Items.BASALT, EBlocks.BASALT_SLAB);
            output.insertAfter(Items.SMOOTH_BASALT,
                    EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL
                    );
            output.insertAfter(Items.POLISHED_BASALT,
                    EBlocks.POLISHED_BASALT_SLAB,
                    EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL,
                    EBlocks.POLISHED_SMOOTH_BASALT, EBlocks.POLISHED_SMOOTH_BASALT_STAIRS, EBlocks.POLISHED_SMOOTH_BASALT_SLAB, EBlocks.POLISHED_SMOOTH_BASALT_WALL,
                    EBlocks.SMOOTH_BASALT_BRICKS, EBlocks.SMOOTH_BASALT_BRICK_STAIRS, EBlocks.SMOOTH_BASALT_BRICK_SLAB, EBlocks.SMOOTH_BASALT_BRICK_WALL,
                    EBlocks.SMOOTH_BASALT_TILES, EBlocks.SMOOTH_BASALT_TILE_STAIRS, EBlocks.SMOOTH_BASALT_TILE_SLAB, EBlocks.SMOOTH_BASALT_TILE_WALL
                    );

            output.insertAfter(Items.END_STONE,
                    EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_SLAB, EBlocks.END_STONE_WALL,
                    EBlocks.CHISELED_END_STONE, EBlocks.END_STONE_PILLAR,
                    EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_SLAB, EBlocks.POLISHED_END_STONE_WALL);

            // Sandstones
            output.insertAfter(Items.SMOOTH_SANDSTONE_SLAB,
                    EBlocks.SMOOTH_SANDSTONE_WALL);
            output.insertAfter(Items.CUT_SANDSTONE, EBlocks.CUT_SANDSTONE_STAIRS);
            output.insertAfter(Blocks.CUT_SANDSTONE_SLAB,
                    EBlocks.CUT_SANDSTONE_WALL,
                    EBlocks.POLISHED_SANDSTONE, EBlocks.POLISHED_SANDSTONE_STAIRS, EBlocks.POLISHED_SANDSTONE_SLAB, EBlocks.POLISHED_SANDSTONE_WALL);

            output.insertAfter(Items.SMOOTH_RED_SANDSTONE_SLAB,
                    EBlocks.SMOOTH_RED_SANDSTONE_WALL);
            output.insertAfter(Items.CUT_RED_SANDSTONE, EBlocks.CUT_RED_SANDSTONE_STAIRS);
            output.insertAfter(Items.CUT_RED_SANDSTONE_SLAB,
                    EBlocks.CUT_RED_SANDSTONE_WALL,
                    EBlocks.POLISHED_RED_SANDSTONE, EBlocks.POLISHED_RED_SANDSTONE_STAIRS, EBlocks.POLISHED_RED_SANDSTONE_SLAB, EBlocks.POLISHED_RED_SANDSTONE_WALL,

                    EBlocks.PINK_SANDSTONE, EBlocks.PINK_SANDSTONE_STAIRS, EBlocks.PINK_SANDSTONE_SLAB, EBlocks.PINK_SANDSTONE_WALL,
                    EBlocks.SMOOTH_PINK_SANDSTONE, EBlocks.SMOOTH_PINK_SANDSTONE_STAIRS, EBlocks.SMOOTH_PINK_SANDSTONE_SLAB, EBlocks.SMOOTH_PINK_SANDSTONE_WALL,
                    EBlocks.CUT_PINK_SANDSTONE, EBlocks.CUT_PINK_SANDSTONE_STAIRS, EBlocks.CUT_PINK_SANDSTONE_SLAB, EBlocks.CUT_PINK_SANDSTONE_WALL,
                    EBlocks.CHISELED_PINK_SANDSTONE,
                    EBlocks.POLISHED_PINK_SANDSTONE, EBlocks.POLISHED_PINK_SANDSTONE_STAIRS, EBlocks.POLISHED_PINK_SANDSTONE_SLAB, EBlocks.POLISHED_PINK_SANDSTONE_WALL,

                    EBlocks.SOUL_SANDSTONE, EBlocks.SOUL_SANDSTONE_STAIRS, EBlocks.SOUL_SANDSTONE_SLAB, EBlocks.SOUL_SANDSTONE_WALL,
                    EBlocks.SMOOTH_SOUL_SANDSTONE, EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, EBlocks.SMOOTH_SOUL_SANDSTONE_WALL,
                    EBlocks.CUT_SOUL_SANDSTONE, EBlocks.CUT_SOUL_SANDSTONE_STAIRS, EBlocks.CUT_SOUL_SANDSTONE_SLAB, EBlocks.CUT_SOUL_SANDSTONE_WALL,
                    EBlocks.CHISELED_SOUL_SANDSTONE,
                    EBlocks.POLISHED_SOUL_SANDSTONE, EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, EBlocks.POLISHED_SOUL_SANDSTONE_SLAB, EBlocks.POLISHED_SOUL_SANDSTONE_WALL);

            // Mud, Quartz, & Amethyst
            output.insertAfter(Items.PACKED_MUD,
                    EBlocks.PACKED_MUD_STAIRS, EBlocks.PACKED_MUD_SLAB, EBlocks.PACKED_MUD_WALL);
            output.insertAfter(Items.MUD_BRICK_WALL,
                    EBlocks.CHISELED_MUD_BRICKS, EBlocks.MUD_BRICK_PILLAR);

            output.insertAfter(Items.QUARTZ_BRICKS,
                    EBlocks.QUARTZ_BRICK_STAIRS, EBlocks.QUARTZ_BRICK_SLAB);

            output.insertAfter(
                    Items.AMETHYST_BLOCK, EBlocks.AMETHYST_STAIRS, EBlocks.AMETHYST_SLAB, EBlocks.CHISELED_AMETHYST,
                    EBlocks.AMETHYST_BRICKS, EBlocks.AMETHYST_BRICK_STAIRS, EBlocks.AMETHYST_BRICK_SLAB, EBlocks.AMETHYST_PILLAR,
                    Blocks.OBSIDIAN, EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB, EBlocks.CHISELED_OBSIDIAN,
                    EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB, EBlocks.OBSIDIAN_PILLAR,

                    EBlocks.SILVER_BLOCK, EBlocks.SILVER_PILLAR,
                    EBlocks.POLISHED_SILVER, EBlocks.POLISHED_SILVER_STAIRS, EBlocks.POLISHED_SILVER_SLAB,
                    EBlocks.CUT_SILVER, EBlocks.CUT_SILVER_STAIRS, EBlocks.CUT_SILVER_SLAB,
                    EBlocks.SILVER_BARS,

                    EBlocks.TIN_BLOCK, EBlocks.CHISELED_TIN,
                    EBlocks.CUT_TIN, EBlocks.CUT_TIN_STAIRS, EBlocks.CUT_TIN_SLAB,
                    EBlocks.TIN_BARS,

                    EBlocks.WROUGHT_IRON_BLOCK, EBlocks.WROUGHT_IRON_STAIRS, EBlocks.WROUGHT_IRON_SLAB,
                    EBlocks.WROUGHT_IRON_GRATE,
                    EBlocks.CUT_WROUGHT_IRON, EBlocks.CUT_WROUGHT_IRON_STAIRS, EBlocks.CUT_WROUGHT_IRON_SLAB
            );

            // Purpur
            output.insertAfter(Items.PURPUR_PILLAR,
                    EBlocks.CHISELED_PURPUR);

            // Planks & Mosaics, Boards & Trims
            output.insertAfter(Items.OAK_PLANKS, EBlocks.OAK_MOSAIC);
            output.insertAfter(Items.OAK_STAIRS, EBlocks.OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.OAK_SLAB, EBlocks.OAK_MOSAIC_SLAB, EBlocks.OAK_BOARDS, EBlocks.OAK_TRIM);

            output.insertAfter(Items.SPRUCE_PLANKS, EBlocks.SPRUCE_MOSAIC);
            output.insertAfter(Items.SPRUCE_STAIRS, EBlocks.SPRUCE_MOSAIC_STAIRS);
            output.insertAfter(Items.SPRUCE_SLAB, EBlocks.SPRUCE_MOSAIC_SLAB, EBlocks.SPRUCE_BOARDS, EBlocks.SPRUCE_TRIM);

            output.insertAfter(Items.BIRCH_PLANKS, EBlocks.BIRCH_MOSAIC);
            output.insertAfter(Items.BIRCH_STAIRS, EBlocks.BIRCH_MOSAIC_STAIRS);
            output.insertAfter(Items.BIRCH_SLAB, EBlocks.BIRCH_MOSAIC_SLAB, EBlocks.BIRCH_BOARDS, EBlocks.BIRCH_TRIM);

            output.insertAfter(Items.JUNGLE_PLANKS, EBlocks.JUNGLE_MOSAIC);
            output.insertAfter(Items.JUNGLE_STAIRS, EBlocks.JUNGLE_MOSAIC_STAIRS);
            output.insertAfter(Items.JUNGLE_SLAB, EBlocks.JUNGLE_MOSAIC_SLAB, EBlocks.JUNGLE_BOARDS, EBlocks.JUNGLE_TRIM);

            output.insertAfter(Items.ACACIA_PLANKS, EBlocks.ACACIA_MOSAIC);
            output.insertAfter(Items.ACACIA_STAIRS, EBlocks.ACACIA_MOSAIC_STAIRS);
            output.insertAfter(Items.ACACIA_SLAB, EBlocks.ACACIA_MOSAIC_SLAB, EBlocks.ACACIA_BOARDS, EBlocks.ACACIA_TRIM);

            output.insertAfter(Items.DARK_OAK_PLANKS, EBlocks.DARK_OAK_MOSAIC);
            output.insertAfter(Items.DARK_OAK_STAIRS, EBlocks.DARK_OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.DARK_OAK_SLAB, EBlocks.DARK_OAK_MOSAIC_SLAB, EBlocks.DARK_OAK_BOARDS, EBlocks.DARK_OAK_TRIM);

            output.insertAfter(Items.MANGROVE_PLANKS, EBlocks.MANGROVE_MOSAIC);
            output.insertAfter(Items.MANGROVE_STAIRS, EBlocks.MANGROVE_MOSAIC_STAIRS);
            output.insertAfter(Items.MANGROVE_SLAB, EBlocks.MANGROVE_MOSAIC_SLAB, EBlocks.MANGROVE_BOARDS, EBlocks.MANGROVE_TRIM);

            output.insertAfter(Items.CHERRY_PLANKS, EBlocks.CHERRY_MOSAIC);
            output.insertAfter(Items.CHERRY_STAIRS, EBlocks.CHERRY_MOSAIC_STAIRS);
            output.insertAfter(Items.CHERRY_SLAB, EBlocks.CHERRY_MOSAIC_SLAB, EBlocks.CHERRY_BOARDS, EBlocks.CHERRY_TRIM);

            output.insertAfter(Items.PALE_OAK_PLANKS, EBlocks.PALE_OAK_MOSAIC);
            output.insertAfter(Items.PALE_OAK_STAIRS, EBlocks.PALE_OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.PALE_OAK_SLAB, EBlocks.PALE_OAK_MOSAIC_SLAB, EBlocks.PALE_OAK_BOARDS, EBlocks.PALE_OAK_TRIM);

            output.insertAfter(Items.CRIMSON_PLANKS, EBlocks.CRIMSON_MOSAIC);
            output.insertAfter(Items.CRIMSON_STAIRS, EBlocks.CRIMSON_MOSAIC_STAIRS);
            output.insertAfter(Items.CRIMSON_SLAB, EBlocks.CRIMSON_MOSAIC_SLAB, EBlocks.CRIMSON_BOARDS, EBlocks.CRIMSON_TRIM);

            output.insertAfter(Items.WARPED_PLANKS, EBlocks.WARPED_MOSAIC);
            output.insertAfter(Items.WARPED_STAIRS, EBlocks.WARPED_MOSAIC_STAIRS);
            output.insertAfter(Items.WARPED_SLAB, EBlocks.WARPED_MOSAIC_SLAB, EBlocks.WARPED_BOARDS, EBlocks.WARPED_TRIM);

            output.insertAfter(Items.BAMBOO_BLOCK, EBlocks.BAMBOO_STEM);
            output.insertAfter(Items.STRIPPED_BAMBOO_BLOCK, EBlocks.STRIPPED_BAMBOO_STEM);
            output.insertAfter(Items.BAMBOO_MOSAIC_SLAB, EBlocks.BAMBOO_BOARDS, EBlocks.BAMBOO_TRIM);

            output.insertAfter(Items.BIRCH_BUTTON,
                    EBlocks.CEDAR_LOG, EBlocks.CEDAR_WOOD,
                    EBlocks.STRIPPED_CEDAR_LOG, EBlocks.STRIPPED_CEDAR_WOOD,
                    EBlocks.CEDAR_PLANKS, EBlocks.CEDAR_MOSAIC,
                    EBlocks.CEDAR_STAIRS, EBlocks.CEDAR_MOSAIC_STAIRS,
                    EBlocks.CEDAR_SLAB, EBlocks.CEDAR_MOSAIC_SLAB,
                    EBlocks.CEDAR_BOARDS, EBlocks.CEDAR_TRIM,
                    EBlocks.CEDAR_FENCE, EBlocks.CEDAR_FENCE_GATE,
                    EBlocks.CEDAR_DOOR, EBlocks.CEDAR_TRAPDOOR,
                    EBlocks.CEDAR_PRESSURE_PLATE, EBlocks.CEDAR_BUTTON
            );

            output.insertAfter(Items.JUNGLE_BUTTON,
                    EBlocks.MAHOGANY_LOG, EBlocks.MAHOGANY_WOOD,
                    EBlocks.STRIPPED_MAHOGANY_LOG, EBlocks.STRIPPED_MAHOGANY_WOOD,
                    EBlocks.MAHOGANY_PLANKS, EBlocks.MAHOGANY_MOSAIC,
                    EBlocks.MAHOGANY_STAIRS, EBlocks.MAHOGANY_MOSAIC_STAIRS,
                    EBlocks.MAHOGANY_SLAB, EBlocks.MAHOGANY_MOSAIC_SLAB,
                    EBlocks.MAHOGANY_BOARDS, EBlocks.MAHOGANY_TRIM,
                    EBlocks.MAHOGANY_FENCE, EBlocks.MAHOGANY_FENCE_GATE,
                    EBlocks.MAHOGANY_DOOR, EBlocks.MAHOGANY_TRAPDOOR,
                    EBlocks.MAHOGANY_PRESSURE_PLATE, EBlocks.MAHOGANY_BUTTON
            );

            output.insertAfter(Blocks.PALE_OAK_BUTTON,
                    EBlocks.POPLAR_LOG, EBlocks.POPLAR_WOOD,
                    EBlocks.STRIPPED_POPLAR_LOG, EBlocks.STRIPPED_POPLAR_WOOD,
                    EBlocks.POPLAR_PLANKS, EBlocks.POPLAR_MOSAIC,
                    EBlocks.POPLAR_STAIRS, EBlocks.POPLAR_MOSAIC_STAIRS,
                    EBlocks.POPLAR_SLAB, EBlocks.POPLAR_MOSAIC_SLAB,
                    EBlocks.POPLAR_BOARDS, EBlocks.POPLAR_TRIM,
                    EBlocks.POPLAR_FENCE, EBlocks.POPLAR_FENCE_GATE,
                    EBlocks.POPLAR_DOOR, EBlocks.POPLAR_TRAPDOOR,
                    EBlocks.POPLAR_PRESSURE_PLATE, EBlocks.POPLAR_BUTTON,

                    EBlocks.AZALEA_LOG, EBlocks.AZALEA_WOOD,
                    EBlocks.STRIPPED_AZALEA_LOG, EBlocks.STRIPPED_AZALEA_WOOD,
                    EBlocks.AZALEA_PLANKS, EBlocks.AZALEA_MOSAIC,
                    EBlocks.AZALEA_STAIRS, EBlocks.AZALEA_MOSAIC_STAIRS,
                    EBlocks.AZALEA_SLAB, EBlocks.AZALEA_MOSAIC_SLAB,
                    EBlocks.AZALEA_BOARDS, EBlocks.AZALEA_TRIM,
                    EBlocks.AZALEA_FENCE, EBlocks.AZALEA_FENCE_GATE,
                    EBlocks.AZALEA_DOOR, EBlocks.AZALEA_TRAPDOOR,
                    EBlocks.AZALEA_PRESSURE_PLATE, EBlocks.AZALEA_BUTTON
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> {
            output.insertAfter(Items.WHITE_WOOL, EBlocks.WHITE_WOOL_STAIRS, EBlocks.WHITE_WOOL_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_WOOL, EBlocks.LIGHT_GRAY_WOOL_STAIRS, EBlocks.LIGHT_GRAY_WOOL_SLAB);
            output.insertAfter(Items.GRAY_WOOL, EBlocks.GRAY_WOOL_STAIRS, EBlocks.GRAY_WOOL_SLAB);
            output.insertAfter(Items.BLACK_WOOL, EBlocks.BLACK_WOOL_STAIRS, EBlocks.BLACK_WOOL_SLAB);
            output.insertAfter(Items.BROWN_WOOL, EBlocks.BROWN_WOOL_STAIRS, EBlocks.BROWN_WOOL_SLAB);
            output.insertAfter(Items.RED_WOOL, EBlocks.RED_WOOL_STAIRS, EBlocks.RED_WOOL_SLAB);
            output.insertAfter(Items.ORANGE_WOOL, EBlocks.ORANGE_WOOL_STAIRS, EBlocks.ORANGE_WOOL_SLAB);
            output.insertAfter(Items.YELLOW_WOOL, EBlocks.YELLOW_WOOL_STAIRS, EBlocks.YELLOW_WOOL_SLAB);
            output.insertAfter(Items.LIME_WOOL, EBlocks.LIME_WOOL_STAIRS, EBlocks.LIME_WOOL_SLAB);
            output.insertAfter(Items.GREEN_WOOL, EBlocks.GREEN_WOOL_STAIRS, EBlocks.GREEN_WOOL_SLAB);
            output.insertAfter(Items.CYAN_WOOL, EBlocks.CYAN_WOOL_STAIRS, EBlocks.CYAN_WOOL_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_WOOL, EBlocks.LIGHT_BLUE_WOOL_STAIRS, EBlocks.LIGHT_BLUE_WOOL_SLAB);
            output.insertAfter(Items.BLUE_WOOL, EBlocks.BLUE_WOOL_STAIRS, EBlocks.BLUE_WOOL_SLAB);
            output.insertAfter(Items.PURPLE_WOOL, EBlocks.PURPLE_WOOL_STAIRS, EBlocks.PURPLE_WOOL_SLAB);
            output.insertAfter(Items.MAGENTA_WOOL, EBlocks.MAGENTA_WOOL_STAIRS, EBlocks.MAGENTA_WOOL_SLAB);
            output.insertAfter(Items.PINK_WOOL, EBlocks.PINK_WOOL_STAIRS, EBlocks.PINK_WOOL_SLAB);

            output.insertAfter(Items.TERRACOTTA, EBlocks.TERRACOTTA_STAIRS, EBlocks.TERRACOTTA_SLAB);
            output.insertAfter(Items.WHITE_TERRACOTTA, EBlocks.WHITE_TERRACOTTA_STAIRS, EBlocks.WHITE_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_TERRACOTTA, EBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
            output.insertAfter(Items.GRAY_TERRACOTTA, EBlocks.GRAY_TERRACOTTA_STAIRS, EBlocks.GRAY_TERRACOTTA_SLAB);
            output.insertAfter(Items.BLACK_TERRACOTTA, EBlocks.BLACK_TERRACOTTA_STAIRS, EBlocks.BLACK_TERRACOTTA_SLAB);
            output.insertAfter(Items.BROWN_TERRACOTTA, EBlocks.BROWN_TERRACOTTA_STAIRS, EBlocks.BROWN_TERRACOTTA_SLAB);
            output.insertAfter(Items.RED_TERRACOTTA, EBlocks.RED_TERRACOTTA_STAIRS, EBlocks.RED_TERRACOTTA_SLAB);
            output.insertAfter(Items.ORANGE_TERRACOTTA, EBlocks.ORANGE_TERRACOTTA_STAIRS, EBlocks.ORANGE_TERRACOTTA_SLAB);
            output.insertAfter(Items.YELLOW_TERRACOTTA, EBlocks.YELLOW_TERRACOTTA_STAIRS, EBlocks.YELLOW_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIME_TERRACOTTA, EBlocks.LIME_TERRACOTTA_STAIRS, EBlocks.LIME_TERRACOTTA_SLAB);
            output.insertAfter(Items.GREEN_TERRACOTTA, EBlocks.GREEN_TERRACOTTA_STAIRS, EBlocks.GREEN_TERRACOTTA_SLAB);
            output.insertAfter(Items.CYAN_TERRACOTTA, EBlocks.CYAN_TERRACOTTA_STAIRS, EBlocks.CYAN_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_TERRACOTTA, EBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
            output.insertAfter(Items.BLUE_TERRACOTTA, EBlocks.BLUE_TERRACOTTA_STAIRS, EBlocks.BLUE_TERRACOTTA_SLAB);
            output.insertAfter(Items.PURPLE_TERRACOTTA, EBlocks.PURPLE_TERRACOTTA_STAIRS, EBlocks.PURPLE_TERRACOTTA_SLAB);
            output.insertAfter(Items.MAGENTA_TERRACOTTA, EBlocks.MAGENTA_TERRACOTTA_STAIRS, EBlocks.MAGENTA_TERRACOTTA_SLAB);
            output.insertAfter(Items.PINK_TERRACOTTA, EBlocks.PINK_TERRACOTTA_STAIRS, EBlocks.PINK_TERRACOTTA_SLAB,

                    EBlocks.TERRACOTTA_BRICKS, EBlocks.TERRACOTTA_BRICK_STAIRS, EBlocks.TERRACOTTA_BRICK_SLAB,
                    EBlocks.WHITE_TERRACOTTA_BRICKS, EBlocks.WHITE_TERRACOTTA_BRICK_STAIRS, EBlocks.WHITE_TERRACOTTA_BRICK_SLAB,
                    EBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB,
                    EBlocks.GRAY_TERRACOTTA_BRICKS, EBlocks.GRAY_TERRACOTTA_BRICK_STAIRS, EBlocks.GRAY_TERRACOTTA_BRICK_SLAB,
                    EBlocks.BLACK_TERRACOTTA_BRICKS, EBlocks.BLACK_TERRACOTTA_BRICK_STAIRS, EBlocks.BLACK_TERRACOTTA_BRICK_SLAB,
                    EBlocks.BROWN_TERRACOTTA_BRICKS, EBlocks.BROWN_TERRACOTTA_BRICK_STAIRS, EBlocks.BROWN_TERRACOTTA_BRICK_SLAB,
                    EBlocks.RED_TERRACOTTA_BRICKS, EBlocks.RED_TERRACOTTA_BRICK_STAIRS, EBlocks.RED_TERRACOTTA_BRICK_SLAB,
                    EBlocks.ORANGE_TERRACOTTA_BRICKS, EBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS, EBlocks.ORANGE_TERRACOTTA_BRICK_SLAB,
                    EBlocks.YELLOW_TERRACOTTA_BRICKS, EBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS, EBlocks.YELLOW_TERRACOTTA_BRICK_SLAB,
                    EBlocks.LIME_TERRACOTTA_BRICKS, EBlocks.LIME_TERRACOTTA_BRICK_STAIRS, EBlocks.LIME_TERRACOTTA_BRICK_SLAB,
                    EBlocks.GREEN_TERRACOTTA_BRICKS, EBlocks.GREEN_TERRACOTTA_BRICK_STAIRS, EBlocks.GREEN_TERRACOTTA_BRICK_SLAB,
                    EBlocks.CYAN_TERRACOTTA_BRICKS, EBlocks.CYAN_TERRACOTTA_BRICK_STAIRS, EBlocks.CYAN_TERRACOTTA_BRICK_SLAB,
                    EBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB,
                    EBlocks.BLUE_TERRACOTTA_BRICKS, EBlocks.BLUE_TERRACOTTA_BRICK_STAIRS, EBlocks.BLUE_TERRACOTTA_BRICK_SLAB,
                    EBlocks.PURPLE_TERRACOTTA_BRICKS, EBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS, EBlocks.PURPLE_TERRACOTTA_BRICK_SLAB,
                    EBlocks.MAGENTA_TERRACOTTA_BRICKS, EBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS, EBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB,
                    EBlocks.PINK_TERRACOTTA_BRICKS, EBlocks.PINK_TERRACOTTA_BRICK_STAIRS, EBlocks.PINK_TERRACOTTA_BRICK_SLAB,

                    EBlocks.TERRACOTTA_BRICK_TILES, EBlocks.TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.WHITE_TERRACOTTA_BRICK_TILES, EBlocks.WHITE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.WHITE_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILES, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.GRAY_TERRACOTTA_BRICK_TILES, EBlocks.GRAY_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.GRAY_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.BLACK_TERRACOTTA_BRICK_TILES, EBlocks.BLACK_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BLACK_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.BROWN_TERRACOTTA_BRICK_TILES, EBlocks.BROWN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BROWN_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.RED_TERRACOTTA_BRICK_TILES, EBlocks.RED_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.RED_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.ORANGE_TERRACOTTA_BRICK_TILES, EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.YELLOW_TERRACOTTA_BRICK_TILES, EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.LIME_TERRACOTTA_BRICK_TILES, EBlocks.LIME_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIME_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.GREEN_TERRACOTTA_BRICK_TILES, EBlocks.GREEN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.GREEN_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.CYAN_TERRACOTTA_BRICK_TILES, EBlocks.CYAN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.CYAN_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILES, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.BLUE_TERRACOTTA_BRICK_TILES, EBlocks.BLUE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BLUE_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.PURPLE_TERRACOTTA_BRICK_TILES, EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.MAGENTA_TERRACOTTA_BRICK_TILES, EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_SLAB,
                    EBlocks.PINK_TERRACOTTA_BRICK_TILES, EBlocks.PINK_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.PINK_TERRACOTTA_BRICK_TILE_SLAB
            );

            output.insertAfter(Items.WHITE_CONCRETE, EBlocks.WHITE_CONCRETE_STAIRS, EBlocks.WHITE_CONCRETE_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_CONCRETE, EBlocks.LIGHT_GRAY_CONCRETE_STAIRS, EBlocks.LIGHT_GRAY_CONCRETE_SLAB);
            output.insertAfter(Items.GRAY_CONCRETE, EBlocks.GRAY_CONCRETE_STAIRS, EBlocks.GRAY_CONCRETE_SLAB);
            output.insertAfter(Items.BLACK_CONCRETE, EBlocks.BLACK_CONCRETE_STAIRS, EBlocks.BLACK_CONCRETE_SLAB);
            output.insertAfter(Items.BROWN_CONCRETE, EBlocks.BROWN_CONCRETE_STAIRS, EBlocks.BROWN_CONCRETE_SLAB);
            output.insertAfter(Items.RED_CONCRETE, EBlocks.RED_CONCRETE_STAIRS, EBlocks.RED_CONCRETE_SLAB);
            output.insertAfter(Items.ORANGE_CONCRETE, EBlocks.ORANGE_CONCRETE_STAIRS, EBlocks.ORANGE_CONCRETE_SLAB);
            output.insertAfter(Items.YELLOW_CONCRETE, EBlocks.YELLOW_CONCRETE_STAIRS, EBlocks.YELLOW_CONCRETE_SLAB);
            output.insertAfter(Items.LIME_CONCRETE, EBlocks.LIME_CONCRETE_STAIRS, EBlocks.LIME_CONCRETE_SLAB);
            output.insertAfter(Items.GREEN_CONCRETE, EBlocks.GREEN_CONCRETE_STAIRS, EBlocks.GREEN_CONCRETE_SLAB);
            output.insertAfter(Items.CYAN_CONCRETE, EBlocks.CYAN_CONCRETE_STAIRS, EBlocks.CYAN_CONCRETE_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_CONCRETE, EBlocks.LIGHT_BLUE_CONCRETE_STAIRS, EBlocks.LIGHT_BLUE_CONCRETE_SLAB);
            output.insertAfter(Items.BLUE_CONCRETE, EBlocks.BLUE_CONCRETE_STAIRS, EBlocks.BLUE_CONCRETE_SLAB);
            output.insertAfter(Items.PURPLE_CONCRETE, EBlocks.PURPLE_CONCRETE_STAIRS, EBlocks.PURPLE_CONCRETE_SLAB);
            output.insertAfter(Items.MAGENTA_CONCRETE, EBlocks.MAGENTA_CONCRETE_STAIRS, EBlocks.MAGENTA_CONCRETE_SLAB);
            output.insertAfter(Items.PINK_CONCRETE, EBlocks.PINK_CONCRETE_STAIRS, EBlocks.PINK_CONCRETE_SLAB);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output -> {
            output.insertAfter(Items.BIRCH_SHELF, EBlocks.CEDAR_SHELF);
            output.insertAfter(Items.BIRCH_HANGING_SIGN, EItems.CEDAR_SIGN, EItems.CEDAR_HANGING_SIGN);

            output.insertAfter(Items.JUNGLE_SHELF, EBlocks.MAHOGANY_SHELF);
            output.insertAfter(Items.JUNGLE_HANGING_SIGN, EItems.MAHOGANY_SIGN, EItems.MAHOGANY_HANGING_SIGN);

            output.insertAfter(Items.PALE_OAK_SHELF, EBlocks.POPLAR_SHELF, EBlocks.AZALEA_SHELF);
            output.insertAfter(Items.PALE_OAK_HANGING_SIGN, EItems.POPLAR_SIGN, EItems.POPLAR_HANGING_SIGN, EItems.AZALEA_SIGN, EItems.AZALEA_HANGING_SIGN);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.insertAfter(Items.IRON_HOE, EItems.BRONZE_SHOVEL, EItems.BRONZE_PICKAXE, EItems.BRONZE_AXE, EItems.BRONZE_HOE);
            output.insertAfter(Items.NETHERITE_HOE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_HOE);

            output.insertAfter(Items.BIRCH_CHEST_BOAT, EItems.CEDAR_BOAT, EItems.CEDAR_CHEST_BOAT);
            output.insertAfter(Items.JUNGLE_CHEST_BOAT, EItems.MAHOGANY_BOAT, EItems.MAHOGANY_CHEST_BOAT);
            output.insertAfter(Items.PALE_OAK_BOAT, EItems.POPLAR_BOAT, EItems.POPLAR_CHEST_BOAT, EItems.AZALEA_BOAT, EItems.AZALEA_CHEST_BOAT);

            output.insertAfter(Items.MUSIC_DISC_CAT, EItems.MUSIC_DISC_FOX);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.insertAfter(Items.IRON_SWORD, EItems.BRONZE_SWORD);
            output.insertAfter(Items.IRON_SPEAR, EItems.BRONZE_SPEAR);
            output.insertAfter(Items.IRON_AXE, EItems.BRONZE_AXE);
            output.insertAfter(Items.IRON_BOOTS, EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS);

            output.insertAfter(Items.NETHERITE_SWORD, EItems.SOULSTEEL_SWORD);
            output.insertAfter(Items.NETHERITE_SPEAR, EItems.SOULSTEEL_SPEAR);
            output.insertAfter(Items.NETHERITE_AXE, EItems.SOULSTEEL_AXE);
            output.insertAfter(Items.NETHERITE_BOOTS, EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS);

            output.insertBefore(Items.WIND_CHARGE, Items.FIRE_CHARGE);

            output.insertAfter(Items.TURTLE_HELMET, EItems.VANGUARD_MASK);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.insertAfter(Items.RAW_COPPER, EItems.RAW_TIN);
            output.insertAfter(Items.RAW_GOLD, EItems.RAW_SILVER);
            output.insertAfter(Items.COPPER_NUGGET, EItems.TIN_NUGGET, EItems.BRONZE_NUGGET);
            output.insertAfter(Items.GOLD_NUGGET, EItems.SILVER_NUGGET);
            output.insertAfter(Items.COPPER_INGOT, EItems.TIN_INGOT, EItems.BRONZE_INGOT);
            output.insertAfter(Items.GOLD_INGOT, EItems.SILVER_INGOT);
            output.insertAfter(Items.NETHERITE_INGOT, EItems.SOULSTEEL_INGOT);

            output.insertBefore(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE);

            output.insertAfter(Items.SLIME_BALL, EItems.SUBSLIME_CLUSTER, EItems.SULFUR_CREAM);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.insertAfter(Items.COOKED_SALMON, EItems.RAW_PERCH, EItems.COOKED_PERCH, EItems.SHINING_PERCH);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> {
            output.insertAfter(Items.DROWNED_SPAWN_EGG, EItems.FROSTBITE_SPAWN_EGG);
            output.insertAfter(Items.WARDEN_SPAWN_EGG, EItems.WEREWOLF_SPAWN_EGG);
            output.insertBefore(Items.WARDEN_SPAWN_EGG, EItems.VANGUARD_SPAWN_EGG);
            output.insertAfter(Items.SLIME_SPAWN_EGG, EItems.SUBSLIME_SPAWN_EGG, EItems.SULFUR_CUBE_SPAWN_EGG);
            output.insertBefore(Items.SILVERFISH_SPAWN_EGG, EItems.SWEEPER_SPAWN_EGG);
            output.insertAfter(Items.IRON_GOLEM_SPAWN_EGG, EItems.MUD_GOLEM_SPAWN_EGG);

            output.insertBefore(Items.PUFFERFISH_SPAWN_EGG, EItems.PERCH_SPAWN_EGG);
        });


    }




}
