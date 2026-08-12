package team.lookingglass.elsewhere.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import team.lookingglass.elsewhere.Elsewhere;

public interface EBlockTags {
    TagKey<Block> MOSAICS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mosaics"));
    TagKey<Block> MOSAIC_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mosaic_stairs"));
    TagKey<Block> MOSAIC_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mosaic_slabs"));
    TagKey<Block> BOARDS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "boards"));
    TagKey<Block> TRIMS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "trims"));

    TagKey<Block> POPLAR_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar_logs"));
    TagKey<Block> AZALEA_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "azalea_logs"));
    TagKey<Block> CEDAR_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar_logs"));
    TagKey<Block> MAHOGANY_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mahogany_logs"));
    TagKey<Block> REDWOOD_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "redwood_logs"));
    TagKey<Block> BAMBOO_STEMS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "bamboo_stems"));

    TagKey<Block> NATURAL_STONE_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "natural_stone_blocks"));
    TagKey<Block> SOIL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soil"));

    TagKey<Block> SHALE_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "shale_ore_replaceables"));
    TagKey<Block> CINNABAR_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cinnabar_ore_replaceables"));
    TagKey<Block> CALCITE_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "calcite_ore_replaceables"));
    TagKey<Block> SULFUR_SPIKE_REPLACEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_spike_replaceable"));
    TagKey<Block> ICICLE_REPLACEABLE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "icicle_replaceable"));

    TagKey<Block> TUNDRA_RED_GRASS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tundra_red_grass"));
    TagKey<Block> TUNDRA_GREEN_GRASS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tundra_green_grass"));

    TagKey<Block> NEEDS_COPPER_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "needs_copper_tool"));
    TagKey<Block> NEEDS_BRONZE_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "needs_bronze_tool"));

    TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "incorrect_for_bronze_tool"));

    TagKey<Block> WOOL_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "wool_blocks"));
    TagKey<Block> WOOL_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "wool_stairs"));
    TagKey<Block> WOOL_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "wool_slabs"));

    TagKey<Block> TERRACOTTA_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_blocks"));
    TagKey<Block> TERRACOTTA_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_stairs"));
    TagKey<Block> TERRACOTTA_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_slabs"));

    TagKey<Block> TERRACOTTA_BRICKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_bricks"));
    TagKey<Block> TERRACOTTA_BRICK_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_brick_stairs"));
    TagKey<Block> TERRACOTTA_BRICK_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_brick_slabs"));

    TagKey<Block> TERRACOTTA_BRICK_TILES = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_brick_tiles"));
    TagKey<Block> TERRACOTTA_BRICK_TILE_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_brick_tile_stairs"));
    TagKey<Block> TERRACOTTA_BRICK_TILE_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "terracotta_brick_tile_slabs"));

    TagKey<Block> CONCRETE = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "concrete"));
    TagKey<Block> CONCRETE_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "concrete_blocks"));
    TagKey<Block> CONCRETE_STAIRS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "concrete_stairs"));
    TagKey<Block> CONCRETE_SLABS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "concrete_slabs"));

    static void initialize() {}
}
