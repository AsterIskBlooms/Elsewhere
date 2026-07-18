package team.lookingglass.elsewhere.datagen;

import team.lookingglass.elsewhere.registry.tags.EBlockTags;
import team.lookingglass.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }



    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(EBlockTags.SHALE_ORE_REPLACEABLES).add(EBlocks.SHALE);
        valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD).add(EBlocks.SHALE);

        valueLookupBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(Blocks.SMOOTH_BASALT);

        valueLookupBuilder(EBlockTags.SULFUR_SPIKE_REPLACEABLE).add(EBlocks.SULFUR);
        valueLookupBuilder(EBlockTags.CINNABAR_ORE_REPLACEABLES).add(EBlocks.CINNABAR);
        valueLookupBuilder(EBlockTags.CALCITE_ORE_REPLACEABLES).add(Blocks.CALCITE);

        valueLookupBuilder(EBlockTags.ICICLE_REPLACEABLE).add(Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE);

        valueLookupBuilder(EBlockTags.TUNDRA_RED_GRASS).add(EBlocks.RED_GRASS_BLOCK);
        valueLookupBuilder(EBlockTags.TUNDRA_GREEN_GRASS).add(Blocks.GRASS_BLOCK);

        valueLookupBuilder(BlockTags.DIRT).add(
                EBlocks.ARID_DIRT, EBlocks.ARID_GRASS_BLOCK,
                EBlocks.RED_GRASS_BLOCK,
                EBlocks.LATERITE
        );
        valueLookupBuilder(BlockTags.GRASS_BLOCKS).add(
                EBlocks.ARID_GRASS_BLOCK,
                EBlocks.RED_GRASS_BLOCK
        );

        valueLookupBuilder(BlockTags.REPLACEABLE).add(
                EBlocks.PEBBLE,
                EBlocks.RED_GRASS_BLOCK, EBlocks.TALL_RED_GRASS, EBlocks.RED_SHRUB,
                EBlocks.BLUEBONNET,
                EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS,
                EBlocks.MAGENTA_CONEFLOWER, EBlocks.YELLOW_CONEFLOWER, EBlocks.IRONWEED
        );
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(
                EBlocks.PEBBLE,
                EBlocks.RED_GRASS_BLOCK, EBlocks.TALL_RED_GRASS, EBlocks.RED_SHRUB,
                EBlocks.BLUEBONNET,
                EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS,
                EBlocks.MAGENTA_CONEFLOWER, EBlocks.YELLOW_CONEFLOWER, EBlocks.IRONWEED
        );
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(
                EBlocks.PEBBLE,
                EBlocks.RED_GRASS_BLOCK, EBlocks.TALL_RED_GRASS, EBlocks.RED_SHRUB,
                EBlocks.BLUEBONNET,
                EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS,
                EBlocks.MAGENTA_CONEFLOWER, EBlocks.YELLOW_CONEFLOWER, EBlocks.IRONWEED
        );
        valueLookupBuilder(BlockTags.MOSS_BLOCKS).add(
                EBlocks.RUSTY_MOSS_BLOCK, EBlocks.RUSTY_MOSS_CARPET
        );

        valueLookupBuilder(BlockTags.LEAVES).add(
                EBlocks.RED_POPLAR_LEAVES, EBlocks.ORANGE_POPLAR_LEAVES, EBlocks.YELLOW_POPLAR_LEAVES
        );


        valueLookupBuilder(BlockTags.FLOWERS)
                .add(
                        EBlocks.BLUEBONNET,
                        EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                        EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
                );
        valueLookupBuilder(BlockTags.SMALL_FLOWERS)
                .add(
                        EBlocks.BLUEBONNET,
                        EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                        EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
                );
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(
                        EBlocks.BLUEBONNET,
                        EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                        EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
                );
        valueLookupBuilder(BlockTags.BEE_GROWABLES)
                .add(
                        EBlocks.BLUEBONNET,
                        EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS, EBlocks.BLUE_HIBISCUS,
                        EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
                );


        // Tool Mineables
        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        EBlocks.ARID_DIRT, EBlocks.ARID_GRASS_BLOCK,
                        EBlocks.RED_GRASS_BLOCK,
                        EBlocks.LATERITE
                );

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        EBlocks.LATERITE,

                        EBlocks.QUARTZ_BRICK_STAIRS, EBlocks.QUARTZ_BRICK_SLAB,

                        EBlocks.AMETHYST_STAIRS, EBlocks.AMETHYST_SLAB,
                        EBlocks.AMETHYST_BRICKS, EBlocks.AMETHYST_BRICK_STAIRS, EBlocks.AMETHYST_BRICK_SLAB,
                        EBlocks.AMETHYST_PILLAR, EBlocks.CHISELED_AMETHYST,

                        EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB,
                        EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB,
                        EBlocks.OBSIDIAN_PILLAR, EBlocks.CHISELED_OBSIDIAN,

                        EBlocks.STONE_WALL,
                        EBlocks.SMOOTH_STONE_STAIRS, EBlocks.SMOOTH_STONE_WALL,
                        EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_SLAB, EBlocks.POLISHED_STONE_WALL,
                        EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_SLAB, EBlocks.STONE_TILE_WALL,
                        EBlocks.MOSSY_STONE_TILES, EBlocks.MOSSY_STONE_TILE_STAIRS, EBlocks.MOSSY_STONE_TILE_SLAB, EBlocks.MOSSY_STONE_TILE_WALL,
                        EBlocks.STONE_PILLAR, EBlocks.CHISELED_STONE,

                        EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL,
                        EBlocks.SMOOTH_DEEPSLATE, EBlocks.SMOOTH_DEEPSLATE_STAIRS, EBlocks.SMOOTH_DEEPSLATE_SLAB, EBlocks.SMOOTH_DEEPSLATE_WALL,
                        EBlocks.DEEPSLATE_PILLAR, EBlocks.CHISELED_DEEPSLATE_BRICKS,

                        EBlocks.SMOOTH_TUFF, EBlocks.SMOOTH_TUFF_STAIRS, EBlocks.SMOOTH_TUFF_SLAB, EBlocks.SMOOTH_TUFF_WALL,
                        EBlocks.TUFF_PILLAR,

                        EBlocks.SMOOTH_BLACKSTONE, EBlocks.SMOOTH_BLACKSTONE_STAIRS, EBlocks.SMOOTH_BLACKSTONE_SLAB, EBlocks.SMOOTH_BLACKSTONE_WALL,
                        EBlocks.POLISHED_BLACKSTONE_PILLAR, EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS,

                        EBlocks.POLISHED_ANDESITE_WALL,
                        EBlocks.SMOOTH_ANDESITE, EBlocks.SMOOTH_ANDESITE_STAIRS, EBlocks.SMOOTH_ANDESITE_SLAB, EBlocks.SMOOTH_ANDESITE_WALL,
                        EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_SLAB, EBlocks.ANDESITE_BRICK_WALL,
                        EBlocks.ANDESITE_PILLAR, EBlocks.CHISELED_ANDESITE, EBlocks.CHISELED_ANDESITE_BRICKS,

                        EBlocks.POLISHED_GRANITE_WALL,
                        EBlocks.SMOOTH_GRANITE, EBlocks.SMOOTH_GRANITE_STAIRS, EBlocks.SMOOTH_GRANITE_SLAB, EBlocks.SMOOTH_GRANITE_WALL,
                        EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_SLAB, EBlocks.GRANITE_BRICK_WALL,
                        EBlocks.GRANITE_PILLAR, EBlocks.CHISELED_GRANITE, EBlocks.CHISELED_GRANITE_BRICKS,

                        EBlocks.POLISHED_DIORITE_WALL,
                        EBlocks.SMOOTH_DIORITE, EBlocks.SMOOTH_DIORITE_STAIRS, EBlocks.SMOOTH_DIORITE_SLAB, EBlocks.SMOOTH_DIORITE_WALL,
                        EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_SLAB, EBlocks.DIORITE_BRICK_WALL,
                        EBlocks.DIORITE_PILLAR, EBlocks.CHISELED_DIORITE, EBlocks.CHISELED_DIORITE_BRICKS,

                        EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_SLAB, EBlocks.CALCITE_WALL,
                        EBlocks.SMOOTH_CALCITE, EBlocks.SMOOTH_CALCITE_STAIRS, EBlocks.SMOOTH_CALCITE_SLAB, EBlocks.SMOOTH_CALCITE_WALL,
                        EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.POLISHED_CALCITE_WALL,
                        EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_SLAB, EBlocks.CALCITE_BRICK_WALL,
                        EBlocks.CALCITE_PILLAR, EBlocks.CHISELED_CALCITE, EBlocks.CHISELED_CALCITE_BRICKS,

                        EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_SLAB, EBlocks.DRIPSTONE_WALL,
                        EBlocks.SMOOTH_DRIPSTONE, EBlocks.SMOOTH_DRIPSTONE_STAIRS, EBlocks.SMOOTH_DRIPSTONE_SLAB, EBlocks.SMOOTH_DRIPSTONE_WALL,
                        EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_WALL,
                        EBlocks.DRIPSTONE_BRICKS, EBlocks.DRIPSTONE_BRICK_STAIRS, EBlocks.DRIPSTONE_BRICK_SLAB, EBlocks.DRIPSTONE_BRICK_WALL,
                        EBlocks.DRIPSTONE_PILLAR, EBlocks.CHISELED_DRIPSTONE, EBlocks.CHISELED_DRIPSTONE_BRICKS,

                        EBlocks.POLISHED_SANDSTONE, EBlocks.POLISHED_SANDSTONE_STAIRS, EBlocks.POLISHED_SANDSTONE_SLAB, EBlocks.POLISHED_SANDSTONE_WALL,
                        EBlocks.SANDSTONE_BRICKS, EBlocks.SANDSTONE_BRICK_STAIRS, EBlocks.SANDSTONE_BRICK_SLAB, EBlocks.SANDSTONE_BRICK_WALL,
                        EBlocks.SMOOTH_SANDSTONE_WALL, EBlocks.CUT_SANDSTONE_STAIRS, EBlocks.CUT_SANDSTONE_WALL,

                        EBlocks.POLISHED_RED_SANDSTONE, EBlocks.POLISHED_RED_SANDSTONE_STAIRS, EBlocks.POLISHED_RED_SANDSTONE_SLAB, EBlocks.POLISHED_RED_SANDSTONE_WALL,
                        EBlocks.RED_SANDSTONE_BRICKS, EBlocks.RED_SANDSTONE_BRICK_STAIRS, EBlocks.RED_SANDSTONE_BRICK_SLAB, EBlocks.RED_SANDSTONE_BRICK_WALL,
                        EBlocks.SMOOTH_RED_SANDSTONE_WALL, EBlocks.CUT_RED_SANDSTONE_STAIRS, EBlocks.CUT_RED_SANDSTONE_WALL,

                        EBlocks.SMOOTH_PRISMARINE, EBlocks.SMOOTH_PRISMARINE_STAIRS, EBlocks.SMOOTH_PRISMARINE_SLAB, EBlocks.SMOOTH_PRISMARINE_WALL,
                        EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_WALL,
                        EBlocks.PRISMARINE_BRICK_WALL, EBlocks.PRISMARINE_PILLAR, EBlocks.CHISELED_PRISMARINE, EBlocks.CHISELED_PRISMARINE_BRICKS,

                        EBlocks.DARK_PRISMARINE_WALL,
                        EBlocks.SMOOTH_DARK_PRISMARINE, EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS, EBlocks.SMOOTH_DARK_PRISMARINE_SLAB, EBlocks.SMOOTH_DARK_PRISMARINE_WALL,
                        EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_WALL,
                        EBlocks.DARK_PRISMARINE_BRICKS, EBlocks.DARK_PRISMARINE_BRICK_STAIRS, EBlocks.DARK_PRISMARINE_BRICK_SLAB, EBlocks.DARK_PRISMARINE_BRICK_WALL,
                        EBlocks.DARK_PRISMARINE_PILLAR, EBlocks.CHISELED_DARK_PRISMARINE, EBlocks.CHISELED_DARK_PRISMARINE_BRICKS,

                        EBlocks.BASALT_SLAB, EBlocks.POLISHED_BASALT_SLAB,
                        EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL,
                        EBlocks.BASALT_BRICKS, EBlocks.BASALT_BRICK_STAIRS, EBlocks.BASALT_BRICK_SLAB, EBlocks.BASALT_BRICK_WALL,
                        EBlocks.CHISELED_BASALT, EBlocks.CHISELED_BASALT_BRICKS,

                        EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_SLAB, EBlocks.NETHERRACK_WALL, EBlocks.SMOOTH_NETHERRACK,
                        EBlocks.SMOOTH_NETHERRACK_STAIRS, EBlocks.SMOOTH_NETHERRACK_SLAB, EBlocks.SMOOTH_NETHERRACK_WALL,
                        EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_WALL,
                        EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.NETHERRACK_BRICK_WALL,
                        EBlocks.NETHERRACK_PILLAR, EBlocks.CHISELED_NETHERRACK, EBlocks.CHISELED_NETHERRACK_BRICKS,

                        EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_SLAB, EBlocks.END_STONE_WALL, EBlocks.SMOOTH_END_STONE,
                        EBlocks.SMOOTH_END_STONE_STAIRS, EBlocks.SMOOTH_END_STONE_SLAB, EBlocks.SMOOTH_END_STONE_WALL,
                        EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_SLAB, EBlocks.POLISHED_END_STONE_WALL,
                        EBlocks.END_STONE_PILLAR, EBlocks.CHISELED_END_STONE, EBlocks.CHISELED_END_STONE_BRICKS,

                        EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_SLAB, EBlocks.SODALITE_WALL,
                        EBlocks.SMOOTH_SODALITE, EBlocks.SMOOTH_SODALITE_STAIRS, EBlocks.SMOOTH_SODALITE_SLAB, EBlocks.SMOOTH_SODALITE_WALL,
                        EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.POLISHED_SODALITE_WALL,
                        EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_SLAB, EBlocks.SODALITE_BRICK_WALL,
                        EBlocks.SODALITE_PILLAR, EBlocks.CHISELED_SODALITE, EBlocks.CHISELED_SODALITE_BRICKS,

                        EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL,
                        EBlocks.SMOOTH_SHALE, EBlocks.SMOOTH_SHALE_STAIRS, EBlocks.SMOOTH_SHALE_SLAB, EBlocks.SMOOTH_SHALE_WALL,
                        EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL,
                        EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL,
                        EBlocks.SHALE_PILLAR, EBlocks.CHISELED_SHALE, EBlocks.CHISELED_SHALE_BRICKS,
                        EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL,
                        EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL,

                        EBlocks.SHALE_COAL_ORE, EBlocks.SHALE_COPPER_ORE, EBlocks.SHALE_IRON_ORE, EBlocks.SHALE_GOLD_ORE, EBlocks.SHALE_REDSTONE_ORE, EBlocks.SHALE_DIAMOND_ORE, EBlocks.SHALE_LAPIS_ORE, EBlocks.SHALE_EMERALD_ORE,

                        EBlocks.CINNABAR_COAL_ORE, EBlocks.CINNABAR_COPPER_ORE, EBlocks.CINNABAR_IRON_ORE, EBlocks.CINNABAR_GOLD_ORE, EBlocks.CINNABAR_REDSTONE_ORE, EBlocks.CINNABAR_DIAMOND_ORE, EBlocks.CINNABAR_LAPIS_ORE, EBlocks.CINNABAR_EMERALD_ORE,

                        EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_SLAB, EBlocks.NETHERRACK_WALL,
                        EBlocks.SMOOTH_NETHERRACK, EBlocks.SMOOTH_NETHERRACK_STAIRS, EBlocks.SMOOTH_NETHERRACK_SLAB, EBlocks.SMOOTH_NETHERRACK_WALL,
                        EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_WALL,
                        EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.NETHERRACK_BRICK_WALL,
                        EBlocks.NETHERRACK_PILLAR, EBlocks.CHISELED_NETHERRACK, EBlocks.CHISELED_NETHERRACK_BRICKS,

                        EBlocks.TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.DEEPSLATE_TIN_ORE, EBlocks.CINNABAR_TIN_ORE,
                        EBlocks.TIN_BLOCK, EBlocks.RAW_TIN_BLOCK,

                        EBlocks.BRONZE_BLOCK,

                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE,
                        EBlocks.SILVER_BLOCK, EBlocks.RAW_SILVER_BLOCK,

                        EBlocks.SOULSTEEL_BLOCK,

                        EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_SLAB, EBlocks.SULFUR_WALL,
                        EBlocks.SMOOTH_SULFUR, EBlocks.SMOOTH_SULFUR_STAIRS, EBlocks.SMOOTH_SULFUR_SLAB, EBlocks.SMOOTH_SULFUR_WALL,
                        EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.POLISHED_SULFUR_WALL,
                        EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_SLAB, EBlocks.SULFUR_BRICK_WALL,
                        EBlocks.SULFUR_PILLAR, EBlocks.CHISELED_SULFUR, EBlocks.CHISELED_SULFUR_BRICKS, EBlocks.SULFUR_SPIKE,

                        EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_SLAB, EBlocks.CINNABAR_WALL,
                        EBlocks.SMOOTH_CINNABAR, EBlocks.SMOOTH_CINNABAR_STAIRS, EBlocks.SMOOTH_CINNABAR_SLAB, EBlocks.SMOOTH_CINNABAR_WALL,
                        EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_WALL,
                        EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_SLAB, EBlocks.CINNABAR_BRICK_WALL,
                        EBlocks.CINNABAR_PILLAR, EBlocks.CHISELED_CINNABAR, EBlocks.CHISELED_CINNABAR_BRICKS,

                        EBlocks.ORPIMENT, EBlocks.ORPIMENT_STAIRS, EBlocks.ORPIMENT_SLAB, EBlocks.ORPIMENT_WALL,
                        EBlocks.SMOOTH_ORPIMENT, EBlocks.SMOOTH_ORPIMENT_STAIRS, EBlocks.SMOOTH_ORPIMENT_SLAB, EBlocks.SMOOTH_ORPIMENT_WALL,
                        EBlocks.POLISHED_ORPIMENT, EBlocks.POLISHED_ORPIMENT_STAIRS, EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.POLISHED_ORPIMENT_WALL,
                        EBlocks.ORPIMENT_BRICKS, EBlocks.ORPIMENT_BRICK_STAIRS, EBlocks.ORPIMENT_BRICK_SLAB, EBlocks.ORPIMENT_BRICK_WALL,
                        EBlocks.ORPIMENT_PILLAR, EBlocks.CHISELED_ORPIMENT, EBlocks.CHISELED_ORPIMENT_BRICKS,

                        EBlocks.SOUL_SANDSTONE, EBlocks.SOUL_SANDSTONE_STAIRS, EBlocks.SOUL_SANDSTONE_SLAB, EBlocks.SOUL_SANDSTONE_WALL,
                        EBlocks.SMOOTH_SOUL_SANDSTONE, EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, EBlocks.SMOOTH_SOUL_SANDSTONE_WALL,
                        EBlocks.CUT_SOUL_SANDSTONE, EBlocks.CUT_SOUL_SANDSTONE_STAIRS, EBlocks.CUT_SOUL_SANDSTONE_SLAB, EBlocks.CUT_SOUL_SANDSTONE_WALL,
                        EBlocks.POLISHED_SOUL_SANDSTONE, EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, EBlocks.POLISHED_SOUL_SANDSTONE_SLAB, EBlocks.POLISHED_SOUL_SANDSTONE_WALL,
                        EBlocks.SOUL_SANDSTONE_BRICKS, EBlocks.SOUL_SANDSTONE_BRICK_STAIRS, EBlocks.SOUL_SANDSTONE_BRICK_SLAB, EBlocks.SOUL_SANDSTONE_BRICK_WALL,
                        EBlocks.CHISELED_SOUL_SANDSTONE,

                        EBlocks.PACKED_MUD_STAIRS, EBlocks.PACKED_MUD_SLAB, EBlocks.PACKED_MUD_WALL,
                        EBlocks.CHISELED_MUD_BRICKS, EBlocks.MUD_BRICK_PILLAR,

                        EBlocks.CHISELED_PURPUR
                );

        // Unlocks Shale
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .remove(
                        Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_BLOCK,
                        Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_BLOCK, Blocks.RAW_GOLD_BLOCK,
                        Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE,
                        Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE
                )
        ;
        valueLookupBuilder(EBlockTags.NEEDS_COPPER_TOOL)
                .add(
                        EBlocks.TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.CINNABAR_TIN_ORE,
                        EBlocks.TIN_BLOCK, EBlocks.RAW_TIN_BLOCK,

                        EBlocks.BRONZE_BLOCK,

                        Blocks.REDSTONE_ORE, EBlocks.SHALE_REDSTONE_ORE, EBlocks.CINNABAR_REDSTONE_ORE,

                        Blocks.LAPIS_ORE, EBlocks.SHALE_LAPIS_ORE, EBlocks.CINNABAR_LAPIS_ORE,

                        EBlocks.SHALE_COAL_ORE, EBlocks.SHALE_COPPER_ORE,

                        EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL,
                        EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL,
                        EBlocks.SMOOTH_SHALE, EBlocks.SMOOTH_SHALE_STAIRS, EBlocks.SMOOTH_SHALE_SLAB, EBlocks.SMOOTH_SHALE_WALL,
                        EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL,
                        EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL,
                        EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL,
                        EBlocks.SHALE_PILLAR, EBlocks.CHISELED_SHALE, EBlocks.CHISELED_SHALE_BRICKS
                )
        ;
        // Unlocks Deepslate & Iron
        valueLookupBuilder(EBlockTags.NEEDS_BRONZE_TOOL)
                .add(
                        Blocks.IRON_ORE, EBlocks.SHALE_IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, EBlocks.CINNABAR_IRON_ORE,
                        Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK,

                        Blocks.GOLD_ORE, EBlocks.SHALE_GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, EBlocks.CINNABAR_GOLD_ORE, Blocks.NETHER_GOLD_ORE,
                        Blocks.GOLD_BLOCK, Blocks.RAW_GOLD_BLOCK,

                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE,
                        EBlocks.SILVER_BLOCK, EBlocks.RAW_SILVER_BLOCK,

                        Blocks.EMERALD_ORE, EBlocks.SHALE_EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, EBlocks.CINNABAR_EMERALD_ORE, Blocks.EMERALD_BLOCK,

                        Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_LAPIS_ORE,  Blocks.DEEPSLATE_REDSTONE_ORE, EBlocks.DEEPSLATE_TIN_ORE,

                        Blocks.DEEPSLATE, EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL,
                        Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE_WALL,
                        EBlocks.SMOOTH_DEEPSLATE, EBlocks.SMOOTH_DEEPSLATE_STAIRS, EBlocks.SMOOTH_DEEPSLATE_SLAB, EBlocks.SMOOTH_DEEPSLATE_WALL,
                        Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE_WALL,
                        Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_BRICK_WALL,
                        Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_TILE_WALL,
                        EBlocks.DEEPSLATE_PILLAR, Blocks.CHISELED_DEEPSLATE, EBlocks.CHISELED_DEEPSLATE_BRICKS
                )
        ;
        // Unlocks Gold & Silver
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        Blocks.OBSIDIAN, EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB,
                        EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB,
                        EBlocks.OBSIDIAN_PILLAR, EBlocks.CHISELED_OBSIDIAN,
                        Blocks.CRYING_OBSIDIAN, Blocks.RESPAWN_ANCHOR
                )
                .remove(
                        Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.REDSTONE_ORE,
                        Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_BLOCK,
                        Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_BLOCK
                )
        ;
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .remove(
                        Blocks.DIAMOND_ORE, EBlocks.SHALE_DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, EBlocks.CINNABAR_DIAMOND_ORE,
                        Blocks.DIAMOND_BLOCK,

                        Blocks.ANCIENT_DEBRIS, Blocks.NETHERITE_BLOCK, EBlocks.SOULSTEEL_BLOCK,

                        Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.RESPAWN_ANCHOR,
                        Blocks.ANCIENT_DEBRIS, Blocks.NETHERITE_BLOCK
                        )
        ;

        // Incorrect Tags
        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(EBlockTags.NEEDS_COPPER_TOOL)
                .addTag(EBlockTags.NEEDS_BRONZE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_COPPER_TOOL)
                .addTag(EBlockTags.NEEDS_BRONZE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        valueLookupBuilder(EBlockTags.INCORRECT_FOR_BRONZE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
        ;
        valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
        ;

        //Logs
        valueLookupBuilder(EBlockTags.POPLAR_LOGS).add(
                EBlocks.POPLAR_LOG, EBlocks.STRIPPED_POPLAR_LOG,
                EBlocks.POPLAR_WOOD, EBlocks.STRIPPED_POPLAR_WOOD
        );
        valueLookupBuilder(EBlockTags.AZALEA_LOGS).add(
                EBlocks.AZALEA_LOG, EBlocks.STRIPPED_AZALEA_LOG,
                EBlocks.AZALEA_WOOD, EBlocks.STRIPPED_AZALEA_WOOD
        );
        valueLookupBuilder(EBlockTags.BAMBOO_STEMS).add(EBlocks.BAMBOO_STEM, EBlocks.STRIPPED_BAMBOO_STEM);

        valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .addTag(EBlockTags.POPLAR_LOGS)
                .addTag(EBlockTags.AZALEA_LOGS)
                .addTag(EBlockTags.BAMBOO_STEMS)
        ;
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(EBlockTags.POPLAR_LOGS)
                .addTag(EBlockTags.AZALEA_LOGS)
        ;
        valueLookupBuilder(BlockTags.LOGS)
                .addTag(EBlockTags.POPLAR_LOGS)
                .addTag(EBlockTags.AZALEA_LOGS)
                .addTag(EBlockTags.BAMBOO_STEMS)
        ;

        // Planks
        valueLookupBuilder(BlockTags.PLANKS).add(
                EBlocks.POPLAR_PLANKS,
                EBlocks.AZALEA_PLANKS
        );

        // Stairs
        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(
                EBlocks.POPLAR_STAIRS,
                EBlocks.AZALEA_STAIRS
        );
        valueLookupBuilder(BlockTags.STAIRS).add(
                EBlocks.POPLAR_STAIRS,
                EBlocks.AZALEA_STAIRS
        );

        // Slabs
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(
                EBlocks.POPLAR_SLAB,
                EBlocks.AZALEA_SLAB
        );
        valueLookupBuilder(BlockTags.SLABS).add(
                EBlocks.POPLAR_SLAB,
                EBlocks.AZALEA_SLAB
        );

        // Fences
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(
                EBlocks.POPLAR_FENCE,
                EBlocks.AZALEA_FENCE
        );
        valueLookupBuilder(BlockTags.FENCES).add(
                EBlocks.POPLAR_FENCE,
                EBlocks.AZALEA_FENCE
        );
        valueLookupBuilder(BlockTags.FENCE_GATES).add(
                EBlocks.POPLAR_FENCE_GATE,
                EBlocks.AZALEA_FENCE_GATE
        );

        // Pressure Plates
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(
                EBlocks.POPLAR_PRESSURE_PLATE,
                EBlocks.AZALEA_PRESSURE_PLATE
        );
        valueLookupBuilder(BlockTags.PRESSURE_PLATES).add(
                EBlocks.POPLAR_PRESSURE_PLATE,
                EBlocks.AZALEA_PRESSURE_PLATE
        );

        // Buttons
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(
                EBlocks.POPLAR_BUTTON,
                EBlocks.AZALEA_BUTTON
        );
        valueLookupBuilder(BlockTags.BUTTONS).add(
                EBlocks.POPLAR_BUTTON,
                EBlocks.AZALEA_BUTTON
        );

        // Doors
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(
                EBlocks.POPLAR_DOOR,
                EBlocks.AZALEA_DOOR
        );
        valueLookupBuilder(BlockTags.DOORS).add(
                EBlocks.POPLAR_DOOR,
                EBlocks.AZALEA_DOOR
        );
        valueLookupBuilder(BlockTags.MOB_INTERACTABLE_DOORS).add(
                EBlocks.POPLAR_DOOR,
                EBlocks.AZALEA_DOOR
        );

        // Trapdoors
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(
                EBlocks.POPLAR_TRAPDOOR,
                EBlocks.AZALEA_TRAPDOOR
        );
        valueLookupBuilder(BlockTags.TRAPDOORS).add(
                EBlocks.POPLAR_TRAPDOOR,
                EBlocks.AZALEA_TRAPDOOR
        );

        // Signs
        valueLookupBuilder(BlockTags.STANDING_SIGNS).add(
                EBlocks.POPLAR_SIGN,
                EBlocks.AZALEA_SIGN
        );
        valueLookupBuilder(BlockTags.WALL_SIGNS).add(
                EBlocks.POPLAR_WALL_SIGN,
                EBlocks.AZALEA_WALL_SIGN
        );
        valueLookupBuilder(BlockTags.SIGNS).add(
                EBlocks.POPLAR_SIGN, EBlocks.POPLAR_WALL_SIGN,
                EBlocks.AZALEA_SIGN, EBlocks.AZALEA_WALL_SIGN
        );
        valueLookupBuilder(BlockTags.ALL_SIGNS).add(
                EBlocks.POPLAR_SIGN, EBlocks.POPLAR_WALL_SIGN,
                EBlocks.AZALEA_SIGN, EBlocks.AZALEA_WALL_SIGN
        );

        // Hanging Signs
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(
                EBlocks.POPLAR_HANGING_SIGN,
                EBlocks.AZALEA_HANGING_SIGN
        );
        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(
                EBlocks.POPLAR_WALL_HANGING_SIGN,
                EBlocks.AZALEA_WALL_HANGING_SIGN
        );
        valueLookupBuilder(BlockTags.ALL_HANGING_SIGNS).add(
                EBlocks.POPLAR_HANGING_SIGN, EBlocks.POPLAR_WALL_HANGING_SIGN,
                EBlocks.AZALEA_HANGING_SIGN, EBlocks.AZALEA_WALL_HANGING_SIGN
        );
        valueLookupBuilder(EBlockTags.MOSAICS).add(
                EBlocks.OAK_MOSAIC, EBlocks.DARK_OAK_MOSAIC, EBlocks.PALE_OAK_MOSAIC,
                EBlocks.BIRCH_MOSAIC, EBlocks.SPRUCE_MOSAIC, EBlocks.JUNGLE_MOSAIC,
                EBlocks.ACACIA_MOSAIC, EBlocks.CHERRY_MOSAIC, EBlocks.MANGROVE_MOSAIC,
                EBlocks.CRIMSON_MOSAIC, EBlocks.WARPED_MOSAIC,
                EBlocks.POPLAR_MOSAIC, EBlocks.AZALEA_MOSAIC,
                Blocks.BAMBOO_MOSAIC
        );
        valueLookupBuilder(EBlockTags.MOSAIC_STAIRS).add(
                EBlocks.OAK_MOSAIC_STAIRS, EBlocks.DARK_OAK_MOSAIC_STAIRS, EBlocks.PALE_OAK_MOSAIC_STAIRS,
                EBlocks.BIRCH_MOSAIC_STAIRS, EBlocks.SPRUCE_MOSAIC_STAIRS, EBlocks.JUNGLE_MOSAIC_STAIRS,
                EBlocks.ACACIA_MOSAIC_STAIRS, EBlocks.CHERRY_MOSAIC_STAIRS, EBlocks.MANGROVE_MOSAIC_STAIRS,
                EBlocks.CRIMSON_MOSAIC_STAIRS, EBlocks.WARPED_MOSAIC_STAIRS,
                EBlocks.POPLAR_MOSAIC_STAIRS, EBlocks.AZALEA_MOSAIC_STAIRS,
                Blocks.BAMBOO_MOSAIC_STAIRS
        );
        valueLookupBuilder(EBlockTags.MOSAIC_SLABS).add(
                EBlocks.OAK_MOSAIC_SLAB, EBlocks.DARK_OAK_MOSAIC_SLAB, EBlocks.PALE_OAK_MOSAIC_SLAB,
                EBlocks.BIRCH_MOSAIC_SLAB, EBlocks.SPRUCE_MOSAIC_SLAB, EBlocks.JUNGLE_MOSAIC_SLAB,
                EBlocks.ACACIA_MOSAIC_SLAB, EBlocks.CHERRY_MOSAIC_SLAB, EBlocks.MANGROVE_MOSAIC_SLAB,
                EBlocks.CRIMSON_MOSAIC_SLAB, EBlocks.WARPED_MOSAIC_SLAB,
                EBlocks.POPLAR_MOSAIC_SLAB, EBlocks.AZALEA_MOSAIC_SLAB,
                Blocks.BAMBOO_MOSAIC_SLAB
        );
        valueLookupBuilder(EBlockTags.BOARDS).add(
                EBlocks.OAK_BOARDS, EBlocks.DARK_OAK_BOARDS, EBlocks.PALE_OAK_BOARDS,
                EBlocks.BIRCH_BOARDS, EBlocks.SPRUCE_BOARDS, EBlocks.JUNGLE_BOARDS,
                EBlocks.ACACIA_BOARDS, EBlocks.CHERRY_BOARDS, EBlocks.MANGROVE_BOARDS,
                EBlocks.CRIMSON_BOARDS, EBlocks.WARPED_BOARDS,
                EBlocks.POPLAR_BOARDS, EBlocks.AZALEA_BOARDS,
                EBlocks.BAMBOO_BOARDS
        );
        valueLookupBuilder(EBlockTags.TRIMS).add(
                EBlocks.OAK_TRIM, EBlocks.DARK_OAK_TRIM, EBlocks.PALE_OAK_TRIM,
                EBlocks.BIRCH_TRIM, EBlocks.SPRUCE_TRIM, EBlocks.JUNGLE_TRIM,
                EBlocks.ACACIA_TRIM, EBlocks.CHERRY_TRIM, EBlocks.MANGROVE_TRIM,
                EBlocks.CRIMSON_TRIM, EBlocks.WARPED_TRIM,
                EBlocks.POPLAR_TRIM, EBlocks.AZALEA_TRIM,
                EBlocks.BAMBOO_TRIM
        );
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS)
                .addTag(BlockTags.PLANKS).addTag(BlockTags.WOODEN_STAIRS).addTag(BlockTags.WOODEN_SLABS)
                .addTag(BlockTags.WOODEN_FENCES).addTag(BlockTags.FENCE_GATES)
                .addTag(BlockTags.WOODEN_PRESSURE_PLATES).addTag(BlockTags.WOODEN_BUTTONS)
                .addTag(BlockTags.WOODEN_DOORS).addTag(BlockTags.WOODEN_TRAPDOORS)
                .addTag(BlockTags.ALL_SIGNS).addTag(BlockTags.ALL_HANGING_SIGNS)
                .addTag(EBlockTags.MOSAICS).addTag(EBlockTags.MOSAIC_STAIRS).addTag(EBlockTags.MOSAIC_SLABS)
                .addTag(EBlockTags.BOARDS).addTag(EBlockTags.TRIMS)
        ;

        // Walls
        valueLookupBuilder(BlockTags.WALLS).add(
                EBlocks.STONE_WALL, EBlocks.SMOOTH_STONE_WALL, EBlocks.POLISHED_STONE_WALL, EBlocks.STONE_TILE_WALL, EBlocks.MOSSY_STONE_TILE_WALL,
                EBlocks.DEEPSLATE_WALL, EBlocks.SMOOTH_DEEPSLATE_WALL,
                EBlocks.SMOOTH_TUFF_WALL,
                EBlocks.SMOOTH_ANDESITE_WALL, EBlocks.POLISHED_ANDESITE_WALL, EBlocks.ANDESITE_BRICK_WALL,
                EBlocks.SMOOTH_GRANITE_WALL, EBlocks.POLISHED_GRANITE_WALL, EBlocks.GRANITE_BRICK_WALL,
                EBlocks.SMOOTH_DIORITE_WALL, EBlocks.POLISHED_DIORITE_WALL, EBlocks.DIORITE_BRICK_WALL,
                EBlocks.CALCITE_WALL, EBlocks.SMOOTH_CALCITE_WALL, EBlocks.POLISHED_CALCITE_WALL, EBlocks.CALCITE_BRICK_WALL,
                EBlocks.DRIPSTONE_WALL, EBlocks.SMOOTH_DRIPSTONE_WALL, EBlocks.POLISHED_DRIPSTONE_WALL, EBlocks.DRIPSTONE_BRICK_WALL,

                EBlocks.POLISHED_SANDSTONE_WALL, EBlocks.POLISHED_RED_SANDSTONE_WALL,
                EBlocks.SANDSTONE_BRICK_WALL, EBlocks.RED_SANDSTONE_BRICK_WALL,
                EBlocks.SMOOTH_SANDSTONE_WALL, EBlocks.SMOOTH_RED_SANDSTONE_WALL,
                EBlocks.CUT_SANDSTONE_WALL, EBlocks.CUT_RED_SANDSTONE_WALL,

                EBlocks.SMOOTH_PRISMARINE_WALL, EBlocks.POLISHED_PRISMARINE_WALL, EBlocks.PRISMARINE_BRICK_WALL,
                EBlocks.DARK_PRISMARINE_WALL, EBlocks.SMOOTH_DARK_PRISMARINE_WALL, EBlocks.POLISHED_DARK_PRISMARINE_WALL, EBlocks.DARK_PRISMARINE_BRICK_WALL,
                EBlocks.SMOOTH_BASALT_WALL, EBlocks.BASALT_BRICK_WALL,
                EBlocks.END_STONE_WALL, EBlocks.SMOOTH_END_STONE_WALL, EBlocks.POLISHED_END_STONE_WALL,
                EBlocks.SODALITE_WALL, EBlocks.SMOOTH_SODALITE_WALL, EBlocks.POLISHED_SODALITE_WALL, EBlocks.SODALITE_BRICK_WALL,
                EBlocks.SULFUR_WALL, EBlocks.SMOOTH_SULFUR_WALL, EBlocks.POLISHED_SULFUR_WALL, EBlocks.SULFUR_BRICK_WALL,
                EBlocks.CINNABAR_WALL, EBlocks.SMOOTH_CINNABAR_WALL, EBlocks.POLISHED_CINNABAR_WALL, EBlocks.CINNABAR_BRICK_WALL,
                EBlocks.ORPIMENT_WALL, EBlocks.SMOOTH_ORPIMENT_WALL, EBlocks.POLISHED_ORPIMENT_WALL, EBlocks.ORPIMENT_BRICK_WALL,
                EBlocks.SOUL_SANDSTONE_WALL, EBlocks.SMOOTH_SOUL_SANDSTONE_WALL, EBlocks.CUT_SOUL_SANDSTONE_WALL, EBlocks.POLISHED_SOUL_SANDSTONE_WALL, EBlocks.SOUL_SANDSTONE_BRICK_WALL,
                EBlocks.PACKED_MUD_WALL,

                EBlocks.NETHERRACK_WALL, EBlocks.SMOOTH_NETHERRACK_WALL, EBlocks.POLISHED_NETHERRACK_WALL, EBlocks.NETHERRACK_BRICK_WALL,

                EBlocks.SHALE_WALL, EBlocks.SMOOTH_SHALE_WALL, EBlocks.POLISHED_SHALE_WALL, EBlocks.SHALE_BRICK_WALL,
                EBlocks.COBBLESHALE_WALL, EBlocks.SHALE_TILE_WALL
        );
        valueLookupBuilder(BlockTags.FENCES).add(
                EBlocks.POPLAR_FENCE
        );
        valueLookupBuilder(BlockTags.FENCE_GATES).add(
                EBlocks.POPLAR_FENCE_GATE
        );
    }
}
