package team.lookingglass.elsewhere.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import team.lookingglass.elsewhere.Elsewhere;
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

    public static final TagKey<Block> MOSAICS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mosaics"));
    public static final TagKey<Block> SHALE_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "shale_ore_replaceables"));
    public static final TagKey<Block> CINNABAR_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cinnabar_ore_replaceables"));
    public static final TagKey<Block> SULFUR_SPIKE_REPLACEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_replaceable"));
    public static final TagKey<Block> ICICLE_REPLACEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_replaceable"));


    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(SHALE_ORE_REPLACEABLES).add(EBlocks.SHALE);
        valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD).add(EBlocks.SHALE);

        valueLookupBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(Blocks.SMOOTH_BASALT);

        valueLookupBuilder(SULFUR_SPIKE_REPLACEABLE).add(EBlocks.SULFUR);
        valueLookupBuilder(CINNABAR_ORE_REPLACEABLES).add(EBlocks.CINNABAR);

        valueLookupBuilder(ICICLE_REPLACEABLE).add(Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE);



        valueLookupBuilder(BlockTags.DIRT).add(EBlocks.ARID_DIRT);
        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(EBlocks.ARID_DIRT);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
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

                        EBlocks.BASALT_STAIRS, EBlocks.BASALT_SLAB, EBlocks.BASALT_WALL,
                        EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL,
                        EBlocks.POLISHED_BASALT_STAIRS, EBlocks.POLISHED_BASALT_SLAB, EBlocks.POLISHED_BASALT_WALL,
                        EBlocks.BASALT_BRICKS, EBlocks.BASALT_BRICK_STAIRS, EBlocks.BASALT_BRICK_SLAB, EBlocks.BASALT_BRICK_WALL,
                        EBlocks.BASALT_PILLAR, EBlocks.CHISELED_BASALT, EBlocks.CHISELED_BASALT_BRICKS,

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

                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE,

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

                        EBlocks.CHISELED_PURPUR
                );

        // Tool Tiers
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.OBSIDIAN)
                .add(EBlocks.OBSIDIAN_STAIRS)
                .add(EBlocks.OBSIDIAN_SLAB)
                .add(EBlocks.OBSIDIAN_BRICKS)
                .add(EBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(EBlocks.OBSIDIAN_BRICK_SLAB)
                .add(EBlocks.OBSIDIAN_PILLAR)
                .add(EBlocks.CHISELED_OBSIDIAN)
                .add(EBlocks.SHALE_GOLD_ORE, EBlocks.SHALE_REDSTONE_ORE, EBlocks.SHALE_DIAMOND_ORE, EBlocks.SHALE_EMERALD_ORE,
                        EBlocks.CINNABAR_GOLD_ORE, EBlocks.CINNABAR_REDSTONE_ORE, EBlocks.CINNABAR_DIAMOND_ORE, EBlocks.CINNABAR_EMERALD_ORE,
                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE
                )
        ;
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(EBlocks.SHALE_COAL_ORE, EBlocks.SHALE_COPPER_ORE, EBlocks.SHALE_IRON_ORE, EBlocks.SHALE_LAPIS_ORE,
                        EBlocks.CINNABAR_COAL_ORE, EBlocks.CINNABAR_COPPER_ORE, EBlocks.CINNABAR_IRON_ORE, EBlocks.CINNABAR_LAPIS_ORE
                )
        ;

        // Wood Sets
        valueLookupBuilder(MOSAICS)
                .add(EBlocks.OAK_MOSAIC)
                .add(EBlocks.DARK_OAK_MOSAIC)
                .add(EBlocks.PALE_OAK_MOSAIC)
                .add(EBlocks.BIRCH_MOSAIC)
                .add(EBlocks.SPRUCE_MOSAIC)
                .add(EBlocks.JUNGLE_MOSAIC)
                .add(EBlocks.ACACIA_MOSAIC)
                .add(EBlocks.CHERRY_MOSAIC)
                .add(EBlocks.MANGROVE_MOSAIC)
                .add(EBlocks.CRIMSON_MOSAIC)
                .add(EBlocks.WARPED_MOSAIC)
                .add(Blocks.BAMBOO_MOSAIC)
        ;

        // Walls
        valueLookupBuilder(BlockTags.WALLS)
                .add(EBlocks.STONE_WALL)
                .add(EBlocks.SMOOTH_STONE_WALL)
                .add(EBlocks.POLISHED_STONE_WALL)
                .add(EBlocks.STONE_TILE_WALL)
                .add(EBlocks.MOSSY_STONE_TILE_WALL)
                .add(EBlocks.DEEPSLATE_WALL)
                .add(EBlocks.SMOOTH_DEEPSLATE_WALL)
                .add(EBlocks.SMOOTH_TUFF_WALL)
                .add(EBlocks.SMOOTH_ANDESITE_WALL)
                .add(EBlocks.POLISHED_ANDESITE_WALL)
                .add(EBlocks.ANDESITE_BRICK_WALL)
                .add(EBlocks.SMOOTH_GRANITE_WALL)
                .add(EBlocks.POLISHED_GRANITE_WALL)
                .add(EBlocks.GRANITE_BRICK_WALL)
                .add(EBlocks.SMOOTH_DIORITE_WALL)
                .add(EBlocks.POLISHED_DIORITE_WALL)
                .add(EBlocks.DIORITE_BRICK_WALL)
                .add(EBlocks.CALCITE_WALL)
                .add(EBlocks.SMOOTH_CALCITE_WALL)
                .add(EBlocks.POLISHED_CALCITE_WALL)
                .add(EBlocks.CALCITE_BRICK_WALL)
                .add(EBlocks.DRIPSTONE_WALL)
                .add(EBlocks.SMOOTH_DRIPSTONE_WALL)
                .add(EBlocks.POLISHED_DRIPSTONE_WALL)
                .add(EBlocks.DRIPSTONE_BRICK_WALL)

                .add(EBlocks.POLISHED_SANDSTONE_WALL)
                .add(EBlocks.POLISHED_RED_SANDSTONE_WALL)
                .add(EBlocks.SANDSTONE_BRICK_WALL)
                .add(EBlocks.RED_SANDSTONE_BRICK_WALL)
                .add(EBlocks.SMOOTH_SANDSTONE_WALL)
                .add(EBlocks.SMOOTH_RED_SANDSTONE_WALL)
                .add(EBlocks.CUT_SANDSTONE_WALL)
                .add(EBlocks.CUT_RED_SANDSTONE_WALL)

                .add(EBlocks.SMOOTH_PRISMARINE_WALL)
                .add(EBlocks.POLISHED_PRISMARINE_WALL)
                .add(EBlocks.PRISMARINE_BRICK_WALL)
                .add(EBlocks.DARK_PRISMARINE_WALL)
                .add(EBlocks.SMOOTH_DARK_PRISMARINE_WALL)
                .add(EBlocks.POLISHED_DARK_PRISMARINE_WALL)
                .add(EBlocks.DARK_PRISMARINE_BRICK_WALL)
                .add(EBlocks.BASALT_WALL)
                .add(EBlocks.SMOOTH_BASALT_WALL)
                .add(EBlocks.POLISHED_BASALT_WALL)
                .add(EBlocks.BASALT_BRICK_WALL)
                .add(EBlocks.END_STONE_WALL)
                .add(EBlocks.SMOOTH_END_STONE_WALL)
                .add(EBlocks.POLISHED_END_STONE_WALL)
                .add(EBlocks.SODALITE_WALL)
                .add(EBlocks.SMOOTH_SODALITE_WALL)
                .add(EBlocks.POLISHED_SODALITE_WALL)
                .add(EBlocks.SODALITE_BRICK_WALL)
                .add(EBlocks.SULFUR_WALL)
                .add(EBlocks.SMOOTH_SULFUR_WALL)
                .add(EBlocks.POLISHED_SULFUR_WALL)
                .add(EBlocks.SULFUR_BRICK_WALL)
                .add(EBlocks.CINNABAR_WALL)
                .add(EBlocks.SMOOTH_CINNABAR_WALL)
                .add(EBlocks.POLISHED_CINNABAR_WALL)
                .add(EBlocks.CINNABAR_BRICK_WALL)
                .add(EBlocks.ORPIMENT_WALL)
                .add(EBlocks.SMOOTH_ORPIMENT_WALL)
                .add(EBlocks.POLISHED_ORPIMENT_WALL)
                .add(EBlocks.ORPIMENT_BRICK_WALL)

                .add(EBlocks.NETHERRACK_WALL)
                .add(EBlocks.SMOOTH_NETHERRACK_WALL)
                .add(EBlocks.POLISHED_NETHERRACK_WALL)
                .add(EBlocks.NETHERRACK_BRICK_WALL)

                .add(EBlocks.SHALE_WALL)
                .add(EBlocks.SMOOTH_SHALE_WALL)
                .add(EBlocks.POLISHED_SHALE_WALL)
                .add(EBlocks.SHALE_BRICK_WALL)
                .add(EBlocks.COBBLESHALE_WALL)
                .add(EBlocks.SHALE_TILE_WALL)


        ;
    }
}
