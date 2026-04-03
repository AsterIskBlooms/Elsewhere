package team.lookingglass.constructure.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import team.lookingglass.constructure.Constructure;
import team.lookingglass.constructure.registry.CBlocks;
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

    public static final TagKey<Block> MOSAICS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Constructure.MODID, "mosaics"));
    public static final TagKey<Block> SHALE_ORE_REPLACABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Constructure.MODID, "shale_ore_replaceables"));


    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(SHALE_ORE_REPLACABLES)
                .add(CBlocks.SHALE)
        ;

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        CBlocks.QUARTZ_BRICK_STAIRS, CBlocks.QUARTZ_BRICK_SLAB,

                        CBlocks.AMETHYST_STAIRS, CBlocks.AMETHYST_SLAB,
                        CBlocks.AMETHYST_BRICKS, CBlocks.AMETHYST_BRICK_STAIRS, CBlocks.AMETHYST_BRICK_SLAB,
                        CBlocks.AMETHYST_PILLAR, CBlocks.CHISELED_AMETHYST,

                        CBlocks.OBSIDIAN_STAIRS, CBlocks.OBSIDIAN_SLAB,
                        CBlocks.OBSIDIAN_BRICKS, CBlocks.OBSIDIAN_BRICK_STAIRS, CBlocks.OBSIDIAN_BRICK_SLAB,
                        CBlocks.OBSIDIAN_PILLAR, CBlocks.CHISELED_OBSIDIAN,

                        CBlocks.STONE_WALL,
                        CBlocks.SMOOTH_STONE_STAIRS, CBlocks.SMOOTH_STONE_WALL,
                        CBlocks.POLISHED_STONE, CBlocks.POLISHED_STONE_STAIRS, CBlocks.POLISHED_STONE_SLAB, CBlocks.POLISHED_STONE_WALL,
                        CBlocks.STONE_TILES, CBlocks.STONE_TILE_STAIRS, CBlocks.STONE_TILE_SLAB, CBlocks.STONE_TILE_WALL,
                        CBlocks.MOSSY_STONE_TILES, CBlocks.MOSSY_STONE_TILE_STAIRS, CBlocks.MOSSY_STONE_TILE_SLAB, CBlocks.MOSSY_STONE_TILE_WALL,
                        CBlocks.STONE_PILLAR, CBlocks.CHISELED_STONE,

                        CBlocks.DEEPSLATE_STAIRS, CBlocks.DEEPSLATE_SLAB, CBlocks.DEEPSLATE_WALL,
                        CBlocks.SMOOTH_DEEPSLATE, CBlocks.SMOOTH_DEEPSLATE_STAIRS, CBlocks.SMOOTH_DEEPSLATE_SLAB, CBlocks.SMOOTH_DEEPSLATE_WALL,
                        CBlocks.DEEPSLATE_PILLAR, CBlocks.CHISELED_DEEPSLATE_BRICKS,

                        CBlocks.SMOOTH_TUFF, CBlocks.SMOOTH_TUFF_STAIRS, CBlocks.SMOOTH_TUFF_SLAB, CBlocks.SMOOTH_TUFF_WALL,
                        CBlocks.TUFF_PILLAR,

                        CBlocks.SMOOTH_BLACKSTONE, CBlocks.SMOOTH_BLACKSTONE_STAIRS, CBlocks.SMOOTH_BLACKSTONE_SLAB, CBlocks.SMOOTH_BLACKSTONE_WALL,
                        CBlocks.POLISHED_BLACKSTONE_PILLAR, CBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS,

                        CBlocks.POLISHED_ANDESITE_WALL,
                        CBlocks.SMOOTH_ANDESITE, CBlocks.SMOOTH_ANDESITE_STAIRS, CBlocks.SMOOTH_ANDESITE_SLAB, CBlocks.SMOOTH_ANDESITE_WALL,
                        CBlocks.ANDESITE_BRICKS, CBlocks.ANDESITE_BRICK_STAIRS, CBlocks.ANDESITE_BRICK_SLAB, CBlocks.ANDESITE_BRICK_WALL,
                        CBlocks.ANDESITE_PILLAR, CBlocks.CHISELED_ANDESITE, CBlocks.CHISELED_ANDESITE_BRICKS,

                        CBlocks.POLISHED_GRANITE_WALL,
                        CBlocks.SMOOTH_GRANITE, CBlocks.SMOOTH_GRANITE_STAIRS, CBlocks.SMOOTH_GRANITE_SLAB, CBlocks.SMOOTH_GRANITE_WALL,
                        CBlocks.GRANITE_BRICKS, CBlocks.GRANITE_BRICK_STAIRS, CBlocks.GRANITE_BRICK_SLAB, CBlocks.GRANITE_BRICK_WALL,
                        CBlocks.GRANITE_PILLAR, CBlocks.CHISELED_GRANITE, CBlocks.CHISELED_GRANITE_BRICKS,

                        CBlocks.POLISHED_DIORITE_WALL,
                        CBlocks.SMOOTH_DIORITE, CBlocks.SMOOTH_DIORITE_STAIRS, CBlocks.SMOOTH_DIORITE_SLAB, CBlocks.SMOOTH_DIORITE_WALL,
                        CBlocks.DIORITE_BRICKS, CBlocks.DIORITE_BRICK_STAIRS, CBlocks.DIORITE_BRICK_SLAB, CBlocks.DIORITE_BRICK_WALL,
                        CBlocks.DIORITE_PILLAR, CBlocks.CHISELED_DIORITE, CBlocks.CHISELED_DIORITE_BRICKS,

                        CBlocks.CALCITE_STAIRS, CBlocks.CALCITE_SLAB, CBlocks.CALCITE_WALL,
                        CBlocks.SMOOTH_CALCITE, CBlocks.SMOOTH_CALCITE_STAIRS, CBlocks.SMOOTH_CALCITE_SLAB, CBlocks.SMOOTH_CALCITE_WALL,
                        CBlocks.POLISHED_CALCITE, CBlocks.POLISHED_CALCITE_STAIRS, CBlocks.POLISHED_CALCITE_SLAB, CBlocks.POLISHED_CALCITE_WALL,
                        CBlocks.CALCITE_BRICKS, CBlocks.CALCITE_BRICK_STAIRS, CBlocks.CALCITE_BRICK_SLAB, CBlocks.CALCITE_BRICK_WALL,
                        CBlocks.CALCITE_PILLAR, CBlocks.CHISELED_CALCITE, CBlocks.CHISELED_CALCITE_BRICKS,

                        CBlocks.DRIPSTONE_STAIRS, CBlocks.DRIPSTONE_SLAB, CBlocks.DRIPSTONE_WALL,
                        CBlocks.SMOOTH_DRIPSTONE, CBlocks.SMOOTH_DRIPSTONE_STAIRS, CBlocks.SMOOTH_DRIPSTONE_SLAB, CBlocks.SMOOTH_DRIPSTONE_WALL,
                        CBlocks.POLISHED_DRIPSTONE, CBlocks.POLISHED_DRIPSTONE_STAIRS, CBlocks.POLISHED_DRIPSTONE_SLAB, CBlocks.POLISHED_DRIPSTONE_WALL,
                        CBlocks.DRIPSTONE_BRICKS, CBlocks.DRIPSTONE_BRICK_STAIRS, CBlocks.DRIPSTONE_BRICK_SLAB, CBlocks.DRIPSTONE_BRICK_WALL,
                        CBlocks.DRIPSTONE_PILLAR, CBlocks.CHISELED_DRIPSTONE, CBlocks.CHISELED_DRIPSTONE_BRICKS,

                        CBlocks.POLISHED_SANDSTONE, CBlocks.POLISHED_SANDSTONE_STAIRS, CBlocks.POLISHED_SANDSTONE_SLAB, CBlocks.POLISHED_SANDSTONE_WALL,
                        CBlocks.SANDSTONE_BRICKS, CBlocks.SANDSTONE_BRICK_STAIRS, CBlocks.SANDSTONE_BRICK_SLAB, CBlocks.SANDSTONE_BRICK_WALL,
                        CBlocks.SMOOTH_SANDSTONE_WALL, CBlocks.CUT_SANDSTONE_STAIRS, CBlocks.CUT_SANDSTONE_WALL,

                        CBlocks.POLISHED_RED_SANDSTONE, CBlocks.POLISHED_RED_SANDSTONE_STAIRS, CBlocks.POLISHED_RED_SANDSTONE_SLAB, CBlocks.POLISHED_RED_SANDSTONE_WALL,
                        CBlocks.RED_SANDSTONE_BRICKS, CBlocks.RED_SANDSTONE_BRICK_STAIRS, CBlocks.RED_SANDSTONE_BRICK_SLAB, CBlocks.RED_SANDSTONE_BRICK_WALL,
                        CBlocks.SMOOTH_RED_SANDSTONE_WALL, CBlocks.CUT_RED_SANDSTONE_STAIRS, CBlocks.CUT_RED_SANDSTONE_WALL,

                        CBlocks.SMOOTH_PRISMARINE, CBlocks.SMOOTH_PRISMARINE_STAIRS, CBlocks.SMOOTH_PRISMARINE_SLAB, CBlocks.SMOOTH_PRISMARINE_WALL,
                        CBlocks.POLISHED_PRISMARINE, CBlocks.POLISHED_PRISMARINE_STAIRS, CBlocks.POLISHED_PRISMARINE_SLAB, CBlocks.POLISHED_PRISMARINE_WALL,
                        CBlocks.PRISMARINE_BRICK_WALL, CBlocks.PRISMARINE_PILLAR, CBlocks.CHISELED_PRISMARINE, CBlocks.CHISELED_PRISMARINE_BRICKS,

                        CBlocks.DARK_PRISMARINE_WALL,
                        CBlocks.SMOOTH_DARK_PRISMARINE, CBlocks.SMOOTH_DARK_PRISMARINE_STAIRS, CBlocks.SMOOTH_DARK_PRISMARINE_SLAB, CBlocks.SMOOTH_DARK_PRISMARINE_WALL,
                        CBlocks.POLISHED_DARK_PRISMARINE, CBlocks.POLISHED_DARK_PRISMARINE_STAIRS, CBlocks.POLISHED_DARK_PRISMARINE_SLAB, CBlocks.POLISHED_DARK_PRISMARINE_WALL,
                        CBlocks.DARK_PRISMARINE_BRICKS, CBlocks.DARK_PRISMARINE_BRICK_STAIRS, CBlocks.DARK_PRISMARINE_BRICK_SLAB, CBlocks.DARK_PRISMARINE_BRICK_WALL,
                        CBlocks.DARK_PRISMARINE_PILLAR, CBlocks.CHISELED_DARK_PRISMARINE, CBlocks.CHISELED_DARK_PRISMARINE_BRICKS,

                        CBlocks.BASALT_STAIRS, CBlocks.BASALT_SLAB, CBlocks.BASALT_WALL,
                        CBlocks.SMOOTH_BASALT_STAIRS, CBlocks.SMOOTH_BASALT_SLAB, CBlocks.SMOOTH_BASALT_WALL,
                        CBlocks.POLISHED_BASALT_STAIRS, CBlocks.POLISHED_BASALT_SLAB, CBlocks.POLISHED_BASALT_WALL,
                        CBlocks.BASALT_BRICKS, CBlocks.BASALT_BRICK_STAIRS, CBlocks.BASALT_BRICK_SLAB, CBlocks.BASALT_BRICK_WALL,
                        CBlocks.BASALT_PILLAR, CBlocks.CHISELED_BASALT, CBlocks.CHISELED_BASALT_BRICKS,

                        CBlocks.SMOOTH_END_STONE, CBlocks.END_STONE_STAIRS, CBlocks.END_STONE_SLAB, CBlocks.END_STONE_WALL,
                        CBlocks.SMOOTH_END_STONE_STAIRS, CBlocks.SMOOTH_END_STONE_SLAB, CBlocks.SMOOTH_END_STONE_WALL,
                        CBlocks.POLISHED_END_STONE, CBlocks.POLISHED_END_STONE_STAIRS, CBlocks.POLISHED_END_STONE_SLAB, CBlocks.POLISHED_END_STONE_WALL,
                        CBlocks.END_STONE_PILLAR, CBlocks.CHISELED_END_STONE, CBlocks.CHISELED_END_STONE_BRICKS,

                        CBlocks.SODALITE, CBlocks.SODALITE_STAIRS, CBlocks.SODALITE_SLAB, CBlocks.SODALITE_WALL,
                        CBlocks.SMOOTH_SODALITE, CBlocks.SMOOTH_SODALITE_STAIRS, CBlocks.SMOOTH_SODALITE_SLAB, CBlocks.SMOOTH_SODALITE_WALL,
                        CBlocks.POLISHED_SODALITE, CBlocks.POLISHED_SODALITE_STAIRS, CBlocks.POLISHED_SODALITE_SLAB, CBlocks.POLISHED_SODALITE_WALL,
                        CBlocks.SODALITE_BRICKS, CBlocks.SODALITE_BRICK_STAIRS, CBlocks.SODALITE_BRICK_SLAB, CBlocks.SODALITE_BRICK_WALL,
                        CBlocks.SODALITE_PILLAR, CBlocks.CHISELED_SODALITE, CBlocks.CHISELED_SODALITE_BRICKS,

                        CBlocks.SHALE, CBlocks.SHALE_STAIRS, CBlocks.SHALE_SLAB, CBlocks.SHALE_WALL,
                        CBlocks.SMOOTH_SHALE, CBlocks.SMOOTH_SHALE_STAIRS, CBlocks.SMOOTH_SHALE_SLAB, CBlocks.SMOOTH_SHALE_WALL,
                        CBlocks.POLISHED_SHALE, CBlocks.POLISHED_SHALE_STAIRS, CBlocks.POLISHED_SHALE_SLAB, CBlocks.POLISHED_SHALE_WALL,
                        CBlocks.SHALE_BRICKS, CBlocks.SHALE_BRICK_STAIRS, CBlocks.SHALE_BRICK_SLAB, CBlocks.SHALE_BRICK_WALL,
                        CBlocks.SHALE_PILLAR, CBlocks.CHISELED_SHALE, CBlocks.CHISELED_SHALE_BRICKS,
                        CBlocks.COBBLESHALE, CBlocks.COBBLESHALE_STAIRS, CBlocks.COBBLESHALE_SLAB, CBlocks.COBBLESHALE_WALL,
                        CBlocks.SHALE_TILES, CBlocks.SHALE_TILE_STAIRS, CBlocks.SHALE_TILE_SLAB, CBlocks.SHALE_TILE_WALL,

                        CBlocks.SHALE_COAL_ORE, CBlocks.SHALE_COPPER_ORE, CBlocks.SHALE_IRON_ORE, CBlocks.SHALE_GOLD_ORE, CBlocks.SHALE_REDSTONE_ORE, CBlocks.SHALE_DIAMOND_ORE, CBlocks.SHALE_LAPIS_ORE, CBlocks.SHALE_EMERALD_ORE,

                        CBlocks.CHISELED_PURPUR
                );

        valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD)
                .add(CBlocks.SHALE)
        ;

        // Tool Tiers
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.OBSIDIAN)
                .add(CBlocks.OBSIDIAN_STAIRS)
                .add(CBlocks.OBSIDIAN_SLAB)
                .add(CBlocks.OBSIDIAN_BRICKS)
                .add(CBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(CBlocks.OBSIDIAN_BRICK_SLAB)
                .add(CBlocks.OBSIDIAN_PILLAR)
                .add(CBlocks.CHISELED_OBSIDIAN)
                .add(CBlocks.SHALE_GOLD_ORE, CBlocks.SHALE_REDSTONE_ORE, CBlocks.SHALE_DIAMOND_ORE, CBlocks.SHALE_EMERALD_ORE)
        ;
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(CBlocks.SHALE_COAL_ORE, CBlocks.SHALE_COPPER_ORE, CBlocks.SHALE_IRON_ORE, CBlocks.SHALE_LAPIS_ORE)
        ;

        // Wood Sets
        valueLookupBuilder(MOSAICS)
                .add(CBlocks.OAK_MOSAIC)
                .add(CBlocks.DARK_OAK_MOSAIC)
                .add(CBlocks.PALE_OAK_MOSAIC)
                .add(CBlocks.BIRCH_MOSAIC)
                .add(CBlocks.SPRUCE_MOSAIC)
                .add(CBlocks.JUNGLE_MOSAIC)
                .add(CBlocks.ACACIA_MOSAIC)
                .add(CBlocks.CHERRY_MOSAIC)
                .add(CBlocks.MANGROVE_MOSAIC)
                .add(CBlocks.CRIMSON_MOSAIC)
                .add(CBlocks.WARPED_MOSAIC)
                .add(Blocks.BAMBOO_MOSAIC)
        ;

        // Walls
        valueLookupBuilder(BlockTags.WALLS)
                .add(CBlocks.STONE_WALL)
                .add(CBlocks.SMOOTH_STONE_WALL)
                .add(CBlocks.POLISHED_STONE_WALL)
                .add(CBlocks.STONE_TILE_WALL)
                .add(CBlocks.MOSSY_STONE_TILE_WALL)
                .add(CBlocks.DEEPSLATE_WALL)
                .add(CBlocks.SMOOTH_DEEPSLATE_WALL)
                .add(CBlocks.SMOOTH_TUFF_WALL)
                .add(CBlocks.SMOOTH_ANDESITE_WALL)
                .add(CBlocks.POLISHED_ANDESITE_WALL)
                .add(CBlocks.ANDESITE_BRICK_WALL)
                .add(CBlocks.SMOOTH_GRANITE_WALL)
                .add(CBlocks.POLISHED_GRANITE_WALL)
                .add(CBlocks.GRANITE_BRICK_WALL)
                .add(CBlocks.SMOOTH_DIORITE_WALL)
                .add(CBlocks.POLISHED_DIORITE_WALL)
                .add(CBlocks.DIORITE_BRICK_WALL)
                .add(CBlocks.CALCITE_WALL)
                .add(CBlocks.SMOOTH_CALCITE_WALL)
                .add(CBlocks.POLISHED_CALCITE_WALL)
                .add(CBlocks.CALCITE_BRICK_WALL)
                .add(CBlocks.DRIPSTONE_WALL)
                .add(CBlocks.SMOOTH_DRIPSTONE_WALL)
                .add(CBlocks.POLISHED_DRIPSTONE_WALL)
                .add(CBlocks.DRIPSTONE_BRICK_WALL)

                .add(CBlocks.POLISHED_SANDSTONE_WALL)
                .add(CBlocks.POLISHED_RED_SANDSTONE_WALL)
                .add(CBlocks.SANDSTONE_BRICK_WALL)
                .add(CBlocks.RED_SANDSTONE_BRICK_WALL)
                .add(CBlocks.SMOOTH_SANDSTONE_WALL)
                .add(CBlocks.SMOOTH_RED_SANDSTONE_WALL)
                .add(CBlocks.CUT_SANDSTONE_WALL)
                .add(CBlocks.CUT_RED_SANDSTONE_WALL)

                .add(CBlocks.SMOOTH_PRISMARINE_WALL)
                .add(CBlocks.POLISHED_PRISMARINE_WALL)
                .add(CBlocks.PRISMARINE_BRICK_WALL)
                .add(CBlocks.DARK_PRISMARINE_WALL)
                .add(CBlocks.SMOOTH_DARK_PRISMARINE_WALL)
                .add(CBlocks.POLISHED_DARK_PRISMARINE_WALL)
                .add(CBlocks.DARK_PRISMARINE_BRICK_WALL)
                .add(CBlocks.BASALT_WALL)
                .add(CBlocks.SMOOTH_BASALT_WALL)
                .add(CBlocks.POLISHED_BASALT_WALL)
                .add(CBlocks.BASALT_BRICK_WALL)
                .add(CBlocks.END_STONE_WALL)
                .add(CBlocks.SMOOTH_END_STONE_WALL)
                .add(CBlocks.POLISHED_END_STONE_WALL)
                .add(CBlocks.SODALITE_WALL)
                .add(CBlocks.SMOOTH_SODALITE_WALL)
                .add(CBlocks.POLISHED_SODALITE_WALL)
                .add(CBlocks.SODALITE_BRICK_WALL)

                .add(CBlocks.SHALE_WALL)
                .add(CBlocks.SMOOTH_SHALE_WALL)
                .add(CBlocks.POLISHED_SHALE_WALL)
                .add(CBlocks.SHALE_BRICK_WALL)
                .add(CBlocks.COBBLESHALE_WALL)
                .add(CBlocks.SHALE_TILE_WALL)


        ;
    }
}
