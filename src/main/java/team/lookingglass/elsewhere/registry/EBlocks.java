package team.lookingglass.elsewhere.registry;

import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.material.PushReaction;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.blocktypes.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.Map;
import java.util.function.Function;

public interface EBlocks {


    // Quartz Brick Fill
    Block QUARTZ_BRICK_STAIRS = registerStair("quartz_brick_stairs", Blocks.QUARTZ_BRICKS);
    Block QUARTZ_BRICK_SLAB = registerSlab("quartz_brick_slab", Blocks.QUARTZ_BRICKS);

    // Amethyst-Obsidian Set
    Block AMETHYST_STAIRS = register("amethyst_stairs", p -> new AmethystStairBlock(Blocks.AMETHYST_BLOCK.defaultBlockState(), p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    Block AMETHYST_SLAB = register("amethyst_slab", AmethystSlabBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    Block AMETHYST_BRICKS = register("amethyst_bricks", AmethystBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    Block AMETHYST_BRICK_STAIRS = registerStair("amethyst_brick_stairs", AMETHYST_BRICKS);
    Block AMETHYST_BRICK_SLAB = registerSlab("amethyst_brick_slab", AMETHYST_BRICKS);
    Block AMETHYST_PILLAR = register("amethyst_pillar", AmethystPillarBlock::new, true,
        BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    Block CHISELED_AMETHYST = register("chiseled_amethyst", AmethystBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()
    );
    Block OBSIDIAN_STAIRS = registerStair("obsidian_stairs", Blocks.OBSIDIAN);
    Block OBSIDIAN_SLAB = registerSlab("obsidian_slab", Blocks.OBSIDIAN);
    Block OBSIDIAN_BRICKS = register("obsidian_bricks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.DEEPSLATE_BRICKS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block OBSIDIAN_BRICK_STAIRS = registerStair("obsidian_brick_stairs", OBSIDIAN_BRICKS);
    Block OBSIDIAN_BRICK_SLAB = registerSlab("obsidian_brick_slab", OBSIDIAN_BRICKS);
    Block OBSIDIAN_PILLAR = register("obsidian_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.DEEPSLATE_BRICKS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block CHISELED_OBSIDIAN = registerSubBlock("chiseled_obsidian", OBSIDIAN_BRICKS);



    // STOOOOOONE !!!
    Block STONE_WALL = registerWall("stone_wall", Blocks.STONE);
    Block SMOOTH_STONE_STAIRS = registerStair("smooth_stone_stairs", Blocks.SMOOTH_STONE);
    Block SMOOTH_STONE_WALL = registerWall("smooth_stone_wall", Blocks.SMOOTH_STONE);

    Block POLISHED_STONE = register("polished_stone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)
    );
    Block POLISHED_STONE_STAIRS = registerStair("polished_stone_stairs", POLISHED_STONE);
    Block POLISHED_STONE_SLAB = registerSlab("polished_stone_slab", POLISHED_STONE);
    Block POLISHED_STONE_WALL = registerWall("polished_stone_wall", POLISHED_STONE);

    Block STONE_TILES = registerSubBlock("stone_tiles", Blocks.STONE_BRICKS);
    Block STONE_TILE_STAIRS = registerStair("stone_tile_stairs", STONE_TILES);
    Block STONE_TILE_SLAB = registerSlab("stone_tile_slab", STONE_TILES);
    Block STONE_TILE_WALL = registerWall("stone_tile_wall", STONE_TILES);
    Block MOSSY_STONE_TILES = registerSubBlock("mossy_stone_tiles", STONE_TILES);
    Block MOSSY_STONE_TILE_STAIRS = registerStair("mossy_stone_tile_stairs", STONE_TILES);
    Block MOSSY_STONE_TILE_SLAB = registerSlab("mossy_stone_tile_slab", STONE_TILES);
    Block MOSSY_STONE_TILE_WALL = registerWall("mossy_stone_tile_wall", STONE_TILES);

    Block CHISELED_STONE = registerSubBlock("chiseled_stone", Blocks.STONE_BRICKS);
    Block STONE_PILLAR = register("stone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)
    );

    Block DEEPSLATE_STAIRS = registerStair("deepslate_stairs", Blocks.DEEPSLATE);
    Block DEEPSLATE_SLAB = registerSlab("deepslate_slab", Blocks.DEEPSLATE);
    Block DEEPSLATE_WALL = registerWall("deepslate_wall", Blocks.DEEPSLATE);

    Block SMOOTH_DEEPSLATE = register("smooth_deepslate", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE)
    );
    Block SMOOTH_DEEPSLATE_STAIRS = registerStair("smooth_deepslate_stairs", SMOOTH_DEEPSLATE);
    Block SMOOTH_DEEPSLATE_SLAB = registerSlab("smooth_deepslate_slab", SMOOTH_DEEPSLATE);
    Block SMOOTH_DEEPSLATE_WALL = registerWall("smooth_deepslate_wall", SMOOTH_DEEPSLATE);

    Block CHISELED_DEEPSLATE_BRICKS = registerSubBlock("chiseled_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    Block DEEPSLATE_PILLAR = register("deepslate_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)
    );

    Block SMOOTH_TUFF = register("smooth_tuff", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)
    );
    Block SMOOTH_TUFF_STAIRS = registerStair("smooth_tuff_stairs", SMOOTH_TUFF);
    Block SMOOTH_TUFF_SLAB = registerSlab("smooth_tuff_slab", SMOOTH_TUFF);
    Block SMOOTH_TUFF_WALL = registerWall("smooth_tuff_wall", SMOOTH_TUFF);
    Block TUFF_PILLAR = register("tuff_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF)
    );

    Block SMOOTH_BLACKSTONE = register("smooth_blackstone", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.DRIPSTONE_BLOCK)
    );
    Block SMOOTH_BLACKSTONE_STAIRS = registerStair("smooth_blackstone_stairs", SMOOTH_BLACKSTONE);
    Block SMOOTH_BLACKSTONE_SLAB = registerSlab("smooth_blackstone_slab", SMOOTH_BLACKSTONE);
    Block SMOOTH_BLACKSTONE_WALL = registerWall("smooth_blackstone_wall", SMOOTH_BLACKSTONE);
    Block CHISELED_POLISHED_BLACKSTONE_BRICKS = registerSubBlock("chiseled_polished_blackstone_bricks", SMOOTH_BLACKSTONE
    );
    Block POLISHED_BLACKSTONE_PILLAR = register("polished_blackstone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(SMOOTH_BLACKSTONE)
    );

    Block POLISHED_ANDESITE_WALL = registerWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
    Block SMOOTH_ANDESITE = register("smooth_andesite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)
    );
    Block SMOOTH_ANDESITE_STAIRS = registerStair("smooth_andesite_stairs", SMOOTH_ANDESITE);
    Block SMOOTH_ANDESITE_SLAB = registerSlab("smooth_andesite_slab", SMOOTH_ANDESITE);
    Block SMOOTH_ANDESITE_WALL = registerWall("smooth_andesite_wall", SMOOTH_ANDESITE);
    Block ANDESITE_BRICKS = register("andesite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)
    );
    Block ANDESITE_BRICK_STAIRS = registerStair("andesite_brick_stairs", ANDESITE_BRICKS);
    Block ANDESITE_BRICK_SLAB = registerSlab("andesite_brick_slab", ANDESITE_BRICKS);
    Block ANDESITE_BRICK_WALL = registerWall("andesite_brick_wall", ANDESITE_BRICKS);
    Block CHISELED_ANDESITE = registerSubBlock("chiseled_andesite", ANDESITE_BRICKS);
    Block CHISELED_ANDESITE_BRICKS = registerSubBlock("chiseled_andesite_bricks", ANDESITE_BRICKS);
    Block ANDESITE_PILLAR = register("andesite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(ANDESITE_BRICKS)
    );

    Block POLISHED_GRANITE_WALL = registerWall("polished_granite_wall", Blocks.POLISHED_GRANITE);
    Block SMOOTH_GRANITE = register("smooth_granite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)
    );
    Block SMOOTH_GRANITE_STAIRS = registerStair("smooth_granite_stairs", SMOOTH_GRANITE);
    Block SMOOTH_GRANITE_SLAB = registerSlab("smooth_granite_slab", SMOOTH_GRANITE);
    Block SMOOTH_GRANITE_WALL = registerWall("smooth_granite_wall", SMOOTH_GRANITE);
    Block GRANITE_BRICKS = register("granite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)
    );
    Block GRANITE_BRICK_STAIRS = registerStair("granite_brick_stairs", GRANITE_BRICKS);
    Block GRANITE_BRICK_SLAB = registerSlab("granite_brick_slab", GRANITE_BRICKS);
    Block GRANITE_BRICK_WALL = registerWall("granite_brick_wall", GRANITE_BRICKS);
    Block CHISELED_GRANITE = registerSubBlock("chiseled_granite", GRANITE_BRICKS);
    Block CHISELED_GRANITE_BRICKS = registerSubBlock("chiseled_granite_bricks", GRANITE_BRICKS);
    Block GRANITE_PILLAR = register("granite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(GRANITE_BRICKS)
    );

    Block POLISHED_DIORITE_WALL = registerWall("polished_diorite_wall", Blocks.POLISHED_DIORITE);
    Block SMOOTH_DIORITE = register("smooth_diorite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)
    );
    Block SMOOTH_DIORITE_STAIRS = registerStair("smooth_diorite_stairs", SMOOTH_DIORITE);
    Block SMOOTH_DIORITE_SLAB = registerSlab("smooth_diorite_slab", SMOOTH_DIORITE);
    Block SMOOTH_DIORITE_WALL = registerWall("smooth_diorite_wall", SMOOTH_DIORITE);
    Block DIORITE_BRICKS = register("diorite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)
    );
    Block DIORITE_BRICK_STAIRS = registerStair("diorite_brick_stairs", DIORITE_BRICKS);
    Block DIORITE_BRICK_SLAB = registerSlab("diorite_brick_slab", DIORITE_BRICKS);
    Block DIORITE_BRICK_WALL = registerWall("diorite_brick_wall", DIORITE_BRICKS);
    Block CHISELED_DIORITE = registerSubBlock("chiseled_diorite", DIORITE_BRICKS);
    Block CHISELED_DIORITE_BRICKS = registerSubBlock("chiseled_diorite_bricks", DIORITE_BRICKS);
    Block DIORITE_PILLAR = register("diorite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(DIORITE_BRICKS)
    );

    Block BEJEWELED_CALCITE = registerSubBlock("bejeweled_calcite", Blocks.CALCITE);
    Block CALCITE_STAIRS = registerStair("calcite_stairs", Blocks.CALCITE);
    Block CALCITE_SLAB = registerSlab("calcite_slab", Blocks.CALCITE);
    Block CALCITE_WALL = registerWall("calcite_wall", Blocks.CALCITE);
    Block SMOOTH_CALCITE = register("smooth_calcite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)
    );
    Block SMOOTH_CALCITE_STAIRS = registerStair("smooth_calcite_stairs", SMOOTH_CALCITE);
    Block SMOOTH_CALCITE_SLAB = registerSlab("smooth_calcite_slab", SMOOTH_CALCITE);
    Block SMOOTH_CALCITE_WALL = registerWall("smooth_calcite_wall", SMOOTH_CALCITE);
    Block POLISHED_CALCITE = register("polished_calcite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)
    );
    Block POLISHED_CALCITE_STAIRS = registerStair("polished_calcite_stairs", POLISHED_CALCITE);
    Block POLISHED_CALCITE_SLAB = registerSlab("polished_calcite_slab", POLISHED_CALCITE);
    Block POLISHED_CALCITE_WALL = registerWall("polished_calcite_wall", POLISHED_CALCITE);
    Block CALCITE_BRICKS = register("calcite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE)
    );
    Block CALCITE_BRICK_STAIRS = registerStair("calcite_brick_stairs", CALCITE_BRICKS);
    Block CALCITE_BRICK_SLAB = registerSlab("calcite_brick_slab", CALCITE_BRICKS);
    Block CALCITE_BRICK_WALL = registerWall("calcite_brick_wall", CALCITE_BRICKS);
    Block CHISELED_CALCITE = registerSubBlock("chiseled_calcite", CALCITE_BRICKS);
    Block CHISELED_CALCITE_BRICKS = registerSubBlock("chiseled_calcite_bricks", CALCITE_BRICKS);
    Block CALCITE_PILLAR = register("calcite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS)
    );

    Block DRIPSTONE_STAIRS = registerStair("dripstone_stairs", Blocks.DRIPSTONE_BLOCK);
    Block DRIPSTONE_SLAB = registerSlab("dripstone_slab", Blocks.DRIPSTONE_BLOCK);
    Block DRIPSTONE_WALL = registerWall("dripstone_wall", Blocks.DRIPSTONE_BLOCK);
    Block SMOOTH_DRIPSTONE = register("smooth_dripstone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)
    );
    Block SMOOTH_DRIPSTONE_STAIRS = registerStair("smooth_dripstone_stairs", SMOOTH_DRIPSTONE);
    Block SMOOTH_DRIPSTONE_SLAB = registerSlab("smooth_dripstone_slab", SMOOTH_DRIPSTONE);
    Block SMOOTH_DRIPSTONE_WALL = registerWall("smooth_dripstone_wall", SMOOTH_DRIPSTONE);
    Block POLISHED_DRIPSTONE = register("polished_dripstone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)
    );
    Block POLISHED_DRIPSTONE_STAIRS = registerStair("polished_dripstone_stairs", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_SLAB = registerSlab("polished_dripstone_slab", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_WALL = registerWall("polished_dripstone_wall", POLISHED_DRIPSTONE);
    Block DRIPSTONE_BRICKS = register("dripstone_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE)
    );
    Block DRIPSTONE_BRICK_STAIRS = registerStair("dripstone_brick_stairs", DRIPSTONE_BRICKS);
    Block DRIPSTONE_BRICK_SLAB = registerSlab("dripstone_brick_slab", DRIPSTONE_BRICKS);
    Block DRIPSTONE_BRICK_WALL = registerWall("dripstone_brick_wall", DRIPSTONE_BRICKS);
    Block CHISELED_DRIPSTONE = registerSubBlock("chiseled_dripstone", DRIPSTONE_BRICKS);
    Block CHISELED_DRIPSTONE_BRICKS = registerSubBlock("chiseled_dripstone_bricks", DRIPSTONE_BRICKS);
    Block DRIPSTONE_PILLAR = register("dripstone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS)
    );



    // Sandstone Fills
    Block POLISHED_SANDSTONE = registerSubBlock("polished_sandstone", Blocks.CUT_SANDSTONE);
    Block POLISHED_SANDSTONE_STAIRS = registerStair("polished_sandstone_stairs", POLISHED_SANDSTONE);
    Block POLISHED_SANDSTONE_SLAB = registerSlab("polished_sandstone_slab", POLISHED_SANDSTONE);
    Block POLISHED_SANDSTONE_WALL = registerWall("polished_sandstone_wall", POLISHED_SANDSTONE);

    Block SANDSTONE_BRICKS = registerSubBlock("sandstone_bricks", Blocks.CUT_SANDSTONE);
    Block SANDSTONE_BRICK_STAIRS = registerStair("sandstone_brick_stairs", SANDSTONE_BRICKS);
    Block SANDSTONE_BRICK_SLAB = registerSlab("sandstone_brick_slab", SANDSTONE_BRICKS);
    Block SANDSTONE_BRICK_WALL = registerWall("sandstone_brick_wall", SANDSTONE_BRICKS);

    Block SMOOTH_SANDSTONE_WALL = registerWall("smooth_sandstone_wall", Blocks.SMOOTH_SANDSTONE);

    Block CUT_SANDSTONE_STAIRS = registerStair("cut_sandstone_stairs", Blocks.CUT_SANDSTONE);
    Block CUT_SANDSTONE_WALL = registerWall("cut_sandstone_wall", Blocks.CUT_SANDSTONE);

    Block POLISHED_RED_SANDSTONE = registerSubBlock("polished_red_sandstone", Blocks.CUT_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_STAIRS = registerStair("polished_red_sandstone_stairs", POLISHED_RED_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_SLAB = registerSlab("polished_red_sandstone_slab", POLISHED_RED_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_WALL = registerWall("polished_red_sandstone_wall", POLISHED_RED_SANDSTONE);

    Block RED_SANDSTONE_BRICKS = registerSubBlock("red_sandstone_bricks", Blocks.CUT_RED_SANDSTONE);
    Block RED_SANDSTONE_BRICK_STAIRS = registerStair("red_sandstone_brick_stairs", RED_SANDSTONE_BRICKS);
    Block RED_SANDSTONE_BRICK_SLAB = registerSlab("red_sandstone_brick_slab", RED_SANDSTONE_BRICKS);
    Block RED_SANDSTONE_BRICK_WALL = registerWall("red_sandstone_brick_wall", RED_SANDSTONE_BRICKS);

    Block SMOOTH_RED_SANDSTONE_WALL = registerWall("smooth_red_sandstone_wall", Blocks.SMOOTH_RED_SANDSTONE);

    Block CUT_RED_SANDSTONE_STAIRS = registerStair("cut_red_sandstone_stairs", Blocks.CUT_RED_SANDSTONE);
    Block CUT_RED_SANDSTONE_WALL = registerWall("cut_red_sandstone_wall", Blocks.CUT_RED_SANDSTONE);



    // Prismarine
    Block SMOOTH_PRISMARINE = register("smooth_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)
    );
    Block SMOOTH_PRISMARINE_STAIRS = registerStair("smooth_prismarine_stairs", SMOOTH_PRISMARINE);
    Block SMOOTH_PRISMARINE_SLAB = registerSlab("smooth_prismarine_slab", SMOOTH_PRISMARINE);
    Block SMOOTH_PRISMARINE_WALL = registerWall("smooth_prismarine_wall", SMOOTH_PRISMARINE);
    Block POLISHED_PRISMARINE = register("polished_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)
    );
    Block POLISHED_PRISMARINE_STAIRS = registerStair("polished_prismarine_stairs", POLISHED_PRISMARINE);
    Block POLISHED_PRISMARINE_SLAB = registerSlab("polished_prismarine_slab", POLISHED_PRISMARINE);
    Block POLISHED_PRISMARINE_WALL = registerWall("polished_prismarine_wall", POLISHED_PRISMARINE);
    Block PRISMARINE_BRICK_WALL = registerWall("prismarine_brick_wall", Blocks.PRISMARINE_BRICKS);
    Block CHISELED_PRISMARINE = registerSubBlock("chiseled_prismarine", Blocks.PRISMARINE_BRICKS);
    Block CHISELED_PRISMARINE_BRICKS = registerSubBlock("chiseled_prismarine_bricks", Blocks.PRISMARINE_BRICKS);
    Block PRISMARINE_PILLAR = register("prismarine_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)
    );

    Block DARK_PRISMARINE_WALL = registerWall("dark_prismarine_wall", Blocks.DARK_PRISMARINE);
    Block SMOOTH_DARK_PRISMARINE = register("smooth_dark_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)
    );
    Block SMOOTH_DARK_PRISMARINE_STAIRS = registerStair("smooth_dark_prismarine_stairs", SMOOTH_DARK_PRISMARINE);
    Block SMOOTH_DARK_PRISMARINE_SLAB = registerSlab("smooth_dark_prismarine_slab", SMOOTH_DARK_PRISMARINE);
    Block SMOOTH_DARK_PRISMARINE_WALL = registerWall("smooth_dark_prismarine_wall", SMOOTH_DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE = register("polished_dark_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)
    );
    Block POLISHED_DARK_PRISMARINE_STAIRS = registerStair("polished_dark_prismarine_stairs", POLISHED_DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE_SLAB = registerSlab("polished_dark_prismarine_slab", POLISHED_DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE_WALL = registerWall("polished_dark_prismarine_wall", POLISHED_DARK_PRISMARINE);
    Block DARK_PRISMARINE_BRICKS = register("dark_prismarine_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_DARK_PRISMARINE)
    );
    Block DARK_PRISMARINE_BRICK_STAIRS = registerStair("dark_prismarine_brick_stairs", DARK_PRISMARINE_BRICKS);
    Block DARK_PRISMARINE_BRICK_SLAB = registerSlab("dark_prismarine_brick_slab", DARK_PRISMARINE_BRICKS);
    Block DARK_PRISMARINE_BRICK_WALL = registerWall("dark_prismarine_brick_wall", DARK_PRISMARINE_BRICKS);
    Block CHISELED_DARK_PRISMARINE = registerSubBlock("chiseled_dark_prismarine", DARK_PRISMARINE_BRICKS);
    Block CHISELED_DARK_PRISMARINE_BRICKS = registerSubBlock("chiseled_dark_prismarine_bricks", DARK_PRISMARINE_BRICKS);
    Block DARK_PRISMARINE_PILLAR = register("dark_prismarine_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(DARK_PRISMARINE_BRICKS)
    );


    // Basalt
    Block BASALT_SLAB = registerSlab("basalt_slab", Blocks.BASALT);
    Block SMOOTH_BASALT_STAIRS = registerStair("smooth_basalt_stairs", Blocks.SMOOTH_BASALT);
    Block SMOOTH_BASALT_SLAB = registerSlab("smooth_basalt_slab", Blocks.SMOOTH_BASALT);
    Block SMOOTH_BASALT_WALL = registerWall("smooth_basalt_wall", Blocks.SMOOTH_BASALT);
    Block POLISHED_BASALT_SLAB = registerSlab("polished_basalt_slab", Blocks.POLISHED_BASALT);
    Block BASALT_BRICKS = register("basalt_bricks", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT)
    );
    Block BASALT_BRICK_STAIRS = registerStair("basalt_brick_stairs", BASALT_BRICKS);
    Block BASALT_BRICK_SLAB = registerSlab("basalt_brick_slab", BASALT_BRICKS);
    Block BASALT_BRICK_WALL = registerWall("basalt_brick_wall", BASALT_BRICKS);
    Block CHISELED_BASALT = register("chiseled_basalt", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS)
    );
    Block CHISELED_BASALT_BRICKS = register("chiseled_basalt_bricks", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS)
    );


    // End Stone
    Block SMOOTH_END_STONE = register("smooth_end_stone", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F).sound(ESounds.END_STONE)
    );
    Block END_STONE_STAIRS = registerStair("end_stone_stairs", SMOOTH_END_STONE);
    Block END_STONE_SLAB = registerSlab("end_stone_slab", SMOOTH_END_STONE);
    Block END_STONE_WALL = registerWall("end_stone_wall", SMOOTH_END_STONE);
    Block SMOOTH_END_STONE_STAIRS = registerStair("smooth_end_stone_stairs", SMOOTH_END_STONE);
    Block SMOOTH_END_STONE_SLAB = registerSlab("smooth_end_stone_slab", SMOOTH_END_STONE);
    Block SMOOTH_END_STONE_WALL = registerWall("smooth_end_stone_wall", SMOOTH_END_STONE);
    Block POLISHED_END_STONE = register("polished_end_stone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(SMOOTH_END_STONE)
    );
    Block POLISHED_END_STONE_STAIRS = registerStair("polished_end_stone_stairs", POLISHED_END_STONE);
    Block POLISHED_END_STONE_SLAB = registerSlab("polished_end_stone_slab", POLISHED_END_STONE);
    Block POLISHED_END_STONE_WALL = registerWall("polished_end_stone_wall", POLISHED_END_STONE);
    Block CHISELED_END_STONE = registerSubBlock("chiseled_end_stone", SMOOTH_END_STONE);
    Block CHISELED_END_STONE_BRICKS = registerSubBlock("chiseled_end_stone_bricks", SMOOTH_END_STONE);
    Block END_STONE_PILLAR = register("end_stone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(SMOOTH_END_STONE)
    );


    // Sodalite
    Block SODALITE = register("sodalite", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.0F, 6.0F).sound(SoundType.TUFF)
    );
    Block SODALITE_STAIRS = registerStair("sodalite_stairs", SODALITE);
    Block SODALITE_SLAB = registerSlab("sodalite_slab", SODALITE);
    Block SODALITE_WALL = registerWall("sodalite_wall", SODALITE);
    Block SMOOTH_SODALITE = register("smooth_sodalite", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(SODALITE)
    );
    Block SMOOTH_SODALITE_STAIRS = registerStair("smooth_sodalite_stairs", SMOOTH_SODALITE);
    Block SMOOTH_SODALITE_SLAB = registerSlab("smooth_sodalite_slab", SMOOTH_SODALITE);
    Block SMOOTH_SODALITE_WALL = registerWall("smooth_sodalite_wall", SMOOTH_SODALITE);
    Block POLISHED_SODALITE = register("polished_sodalite", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.0F, 6.0F).sound(SoundType.POLISHED_TUFF)
    );
    Block POLISHED_SODALITE_STAIRS = registerStair("polished_sodalite_stairs", POLISHED_SODALITE);
    Block POLISHED_SODALITE_SLAB = registerSlab("polished_sodalite_slab", POLISHED_SODALITE);
    Block POLISHED_SODALITE_WALL = registerWall("polished_sodalite_wall", POLISHED_SODALITE);
    Block SODALITE_BRICKS = register("sodalite_bricks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.0F, 6.0F).sound(SoundType.TUFF_BRICKS)
    );
    Block SODALITE_BRICK_STAIRS = registerStair("sodalite_brick_stairs", SODALITE_BRICKS);
    Block SODALITE_BRICK_SLAB = registerSlab("sodalite_brick_slab", SODALITE_BRICKS);
    Block SODALITE_BRICK_WALL = registerWall("sodalite_brick_wall", SODALITE_BRICKS);
    Block CHISELED_SODALITE = registerSubBlock("chiseled_sodalite", POLISHED_SODALITE);
    Block CHISELED_SODALITE_BRICKS = registerSubBlock("chiseled_sodalite_bricks", SODALITE_BRICKS);
    Block SODALITE_PILLAR = register("sodalite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_SODALITE)
    );

    // SHAAAALE
    Block SHALE = register("shale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.TUFF)
    );
    Block SHALE_STAIRS = registerStair("shale_stairs", SHALE);
    Block SHALE_SLAB = registerSlab("shale_slab", SHALE);
    Block SHALE_WALL = registerWall("shale_wall", SHALE);
    Block SMOOTH_SHALE = register("smooth_shale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.TUFF)
    );
    Block SMOOTH_SHALE_STAIRS = registerStair("smooth_shale_stairs", SMOOTH_SHALE);
    Block SMOOTH_SHALE_SLAB = registerSlab("smooth_shale_slab", SMOOTH_SHALE);
    Block SMOOTH_SHALE_WALL = registerWall("smooth_shale_wall", SMOOTH_SHALE);
    Block POLISHED_SHALE = register("polished_shale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.POLISHED_TUFF)
    );
    Block POLISHED_SHALE_STAIRS = registerStair("polished_shale_stairs", POLISHED_SHALE);
    Block POLISHED_SHALE_SLAB = registerSlab("polished_shale_slab", POLISHED_SHALE);
    Block POLISHED_SHALE_WALL = registerWall("polished_shale_wall", POLISHED_SHALE);
    Block SHALE_BRICKS = register("shale_bricks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.TUFF_BRICKS)
    );
    Block SHALE_BRICK_STAIRS = registerStair("shale_brick_stairs", SHALE_BRICKS);
    Block SHALE_BRICK_SLAB = registerSlab("shale_brick_slab", SHALE_BRICKS);
    Block SHALE_BRICK_WALL = registerWall("shale_brick_wall", SHALE_BRICKS);
    Block CHISELED_SHALE = registerSubBlock("chiseled_shale", POLISHED_SHALE);
    Block CHISELED_SHALE_BRICKS = registerSubBlock("chiseled_shale_bricks", SHALE_BRICKS);
    Block SHALE_PILLAR = register("shale_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_SHALE)
    );
    Block COBBLESHALE = register("cobbleshale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.TUFF)
    );
    Block COBBLESHALE_STAIRS = registerStair("cobbleshale_stairs", SHALE);
    Block COBBLESHALE_SLAB = registerSlab("cobbleshale_slab", SHALE);
    Block COBBLESHALE_WALL = registerWall("cobbleshale_wall", SHALE);
    Block SHALE_TILES = register("shale_tiles", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.SHALE_TILES)
    );
    Block SHALE_TILE_STAIRS = registerStair("shale_tile_stairs", SHALE);
    Block SHALE_TILE_SLAB = registerSlab("shale_tile_slab", SHALE);
    Block SHALE_TILE_WALL = registerWall("shale_tile_wall", SHALE);

    Block SHALE_COAL_ORE = register("shale_coal_ore", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F, 6.0F).sound(SoundType.TUFF)
    );
    Block SHALE_COPPER_ORE = registerSubBlock("shale_copper_ore", SHALE_COAL_ORE);
    Block SHALE_IRON_ORE = registerSubBlock("shale_iron_ore", SHALE_COAL_ORE);
    Block SHALE_GOLD_ORE = registerSubBlock("shale_gold_ore", SHALE_COAL_ORE);
    Block SHALE_REDSTONE_ORE = register("shale_redstone_ore", RedStoneOreBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().randomTicks().lightLevel(Blocks.litBlockEmission(9)).strength(3.0F, 6.0F).sound(ESounds.CINNABAR)
    );
    Block SHALE_DIAMOND_ORE = registerSubBlock("shale_diamond_ore", SHALE_COAL_ORE);
    Block SHALE_LAPIS_ORE = registerSubBlock("shale_lapis_ore", SHALE_COAL_ORE);
    Block SHALE_EMERALD_ORE = registerSubBlock("shale_emerald_ore", SHALE_COAL_ORE);

    Block SILVER_ORE = registerSubBlock("silver_ore", Blocks.COAL_ORE);
    Block SHALE_SILVER_ORE = registerSubBlock("shale_silver_ore", SHALE_COAL_ORE);
    Block DEEPSLATE_SILVER_ORE = registerSubBlock("deepslate_silver_ore", Blocks.DEEPSLATE_COAL_ORE);
    Block CINNABAR_SILVER_ORE = register("cinnabar_silver_ore", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.CINNABAR)
    );

    Block TIN_ORE = registerSubBlock("tin_ore", Blocks.COAL_ORE);
    Block SHALE_TIN_ORE = registerSubBlock("shale_tin_ore", SHALE_COAL_ORE);
    Block DEEPSLATE_TIN_ORE = registerSubBlock("deepslate_tin_ore", Blocks.DEEPSLATE_COAL_ORE);
    Block CINNABAR_TIN_ORE = registerSubBlock("cinnabar_tin_ore", CINNABAR_SILVER_ORE);


    Block TIN_BLOCK = register("tin_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.IRON)
    );
    Block RAW_TIN_BLOCK = register("raw_tin_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.STONE)
    );
    Block BRONZE_BLOCK = register("bronze_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(4.0F, 6.0F).sound(SoundType.COPPER)
    );
    Block SILVER_BLOCK = register("silver_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)
    );
    Block RAW_SILVER_BLOCK = register("raw_silver_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)
    );
    Block SOULSTEEL_BLOCK = register("soulsteel_block", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK)
    );


    // Sulfur & Cinnabar
    Block SULFUR = register("sulfur", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(ESounds.SULFUR)
    );
    Block SULFUR_STAIRS = registerStair("sulfur_stairs", SULFUR);
    Block SULFUR_SLAB = registerSlab("sulfur_slab", SULFUR);
    Block SULFUR_WALL = registerWall("sulfur_wall", SULFUR);
    Block SMOOTH_SULFUR = register("smooth_sulfur", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(SULFUR)
    );
    Block SMOOTH_SULFUR_STAIRS = registerStair("smooth_sulfur_stairs", SMOOTH_SULFUR);
    Block SMOOTH_SULFUR_SLAB = registerSlab("smooth_sulfur_slab", SMOOTH_SULFUR);
    Block SMOOTH_SULFUR_WALL = registerWall("smooth_sulfur_wall", SMOOTH_SULFUR);
    Block POLISHED_SULFUR = registerSubBlock("polished_sulfur", SULFUR
    );
    Block POLISHED_SULFUR_STAIRS = registerStair("polished_sulfur_stairs", POLISHED_SULFUR);
    Block POLISHED_SULFUR_SLAB = registerSlab("polished_sulfur_slab", POLISHED_SULFUR);
    Block POLISHED_SULFUR_WALL = registerWall("polished_sulfur_wall", POLISHED_SULFUR);
    Block SULFUR_BRICKS = registerSubBlock("sulfur_bricks", POLISHED_SULFUR);
    Block SULFUR_BRICK_STAIRS = registerStair("sulfur_brick_stairs", SULFUR_BRICKS);
    Block SULFUR_BRICK_SLAB = registerSlab("sulfur_brick_slab", SULFUR_BRICKS);
    Block SULFUR_BRICK_WALL = registerWall("sulfur_brick_wall", SULFUR_BRICKS);
    Block CHISELED_SULFUR = registerSubBlock("chiseled_sulfur", POLISHED_SULFUR);
    Block CHISELED_SULFUR_BRICKS = registerSubBlock("chiseled_sulfur_bricks", SULFUR_BRICKS);
    Block SULFUR_PILLAR = register("sulfur_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_SULFUR)
    );

    Block SULFUR_SPIKE = register("sulfur_spike", p -> new SpikeBlock(SULFUR, 2, ESounds.SULFUR_SPIKE_LAND, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(ESounds.SULFUR).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)
    );

    Block POTENT_SULFUR = register("potent_sulfur", PotentSulfurBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(ESounds.SULFUR)
    );

    Block CINNABAR = register("cinnabar", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(ESounds.CINNABAR)
    );
    Block CINNABAR_STAIRS = registerStair("cinnabar_stairs", CINNABAR);
    Block CINNABAR_SLAB = registerSlab("cinnabar_slab", CINNABAR);
    Block CINNABAR_WALL = registerWall("cinnabar_wall", CINNABAR);
    Block SMOOTH_CINNABAR = register("smooth_cinnabar", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(CINNABAR)
    );
    Block SMOOTH_CINNABAR_STAIRS = registerStair("smooth_cinnabar_stairs", SMOOTH_CINNABAR);
    Block SMOOTH_CINNABAR_SLAB = registerSlab("smooth_cinnabar_slab", SMOOTH_CINNABAR);
    Block SMOOTH_CINNABAR_WALL = registerWall("smooth_cinnabar_wall", SMOOTH_CINNABAR);
    Block POLISHED_CINNABAR = registerSubBlock("polished_cinnabar", CINNABAR);
    Block POLISHED_CINNABAR_STAIRS = registerStair("polished_cinnabar_stairs", POLISHED_CINNABAR);
    Block POLISHED_CINNABAR_SLAB = registerSlab("polished_cinnabar_slab", POLISHED_CINNABAR);
    Block POLISHED_CINNABAR_WALL = registerWall("polished_cinnabar_wall", POLISHED_CINNABAR);
    Block CINNABAR_BRICKS = registerSubBlock("cinnabar_bricks", POLISHED_CINNABAR);
    Block CINNABAR_BRICK_STAIRS = registerStair("cinnabar_brick_stairs", CINNABAR_BRICKS);
    Block CINNABAR_BRICK_SLAB = registerSlab("cinnabar_brick_slab", CINNABAR_BRICKS);
    Block CINNABAR_BRICK_WALL = registerWall("cinnabar_brick_wall", CINNABAR_BRICKS);
    Block CHISELED_CINNABAR = registerSubBlock("chiseled_cinnabar", POLISHED_CINNABAR);
    Block CHISELED_CINNABAR_BRICKS = registerSubBlock("chiseled_cinnabar_bricks", CINNABAR_BRICKS);
    Block CINNABAR_PILLAR = register("cinnabar_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_CINNABAR)
    );

    Block CINNABAR_COAL_ORE = register("cinnabar_coal_ore", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.CINNABAR)
    );
    Block CINNABAR_COPPER_ORE = registerSubBlock("cinnabar_copper_ore", CINNABAR_COAL_ORE);
    Block CINNABAR_IRON_ORE = registerSubBlock("cinnabar_iron_ore", CINNABAR_COAL_ORE);
    Block CINNABAR_GOLD_ORE = registerSubBlock("cinnabar_gold_ore", CINNABAR_COAL_ORE);
    Block CINNABAR_REDSTONE_ORE = register("cinnabar_redstone_ore", RedStoneOreBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().randomTicks().lightLevel(Blocks.litBlockEmission(9)).strength(3.0F, 6.0F).sound(ESounds.CINNABAR)
    );
    Block CINNABAR_DIAMOND_ORE = registerSubBlock("cinnabar_diamond_ore", CINNABAR_COAL_ORE);
    Block CINNABAR_LAPIS_ORE = registerSubBlock("cinnabar_lapis_ore", CINNABAR_COAL_ORE);
    Block CINNABAR_EMERALD_ORE = registerSubBlock("cinnabar_emerald_ore", CINNABAR_COAL_ORE);

    // Netherrack
    Block NETHERRACK_STAIRS = registerStair("netherrack_stairs", Blocks.NETHERRACK);
    Block NETHERRACK_SLAB = registerSlab("netherrack_slab", Blocks.NETHERRACK);
    Block NETHERRACK_WALL = registerWall("netherrack_wall", Blocks.NETHERRACK);
    Block SMOOTH_NETHERRACK = registerSubBlock("smooth_netherrack", Blocks.NETHERRACK);
    Block SMOOTH_NETHERRACK_STAIRS = registerStair("smooth_netherrack_stairs", SMOOTH_NETHERRACK);
    Block SMOOTH_NETHERRACK_SLAB = registerSlab("smooth_netherrack_slab", SMOOTH_NETHERRACK);
    Block SMOOTH_NETHERRACK_WALL = registerWall("smooth_netherrack_wall", SMOOTH_NETHERRACK);
    Block POLISHED_NETHERRACK = registerSubBlock("polished_netherrack", SMOOTH_NETHERRACK);
    Block POLISHED_NETHERRACK_STAIRS = registerStair("polished_netherrack_stairs", POLISHED_NETHERRACK);
    Block POLISHED_NETHERRACK_SLAB = registerSlab("polished_netherrack_slab", POLISHED_NETHERRACK);
    Block POLISHED_NETHERRACK_WALL = registerWall("polished_netherrack_wall", POLISHED_NETHERRACK);
    Block NETHERRACK_BRICKS = registerSubBlock("netherrack_bricks", POLISHED_NETHERRACK);
    Block NETHERRACK_BRICK_STAIRS = registerStair("netherrack_brick_stairs", NETHERRACK_BRICKS);
    Block NETHERRACK_BRICK_SLAB = registerSlab("netherrack_brick_slab", NETHERRACK_BRICKS);
    Block NETHERRACK_BRICK_WALL = registerWall("netherrack_brick_wall", NETHERRACK_BRICKS);
    Block CHISELED_NETHERRACK = registerSubBlock("chiseled_netherrack", NETHERRACK_BRICKS);
    Block CHISELED_NETHERRACK_BRICKS = registerSubBlock("chiseled_netherrack_bricks", NETHERRACK_BRICKS);
    Block NETHERRACK_PILLAR = register("netherrack_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(NETHERRACK_BRICKS)
    );

    // Orpiment
    Block ORPIMENT = register("orpiment", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CALCITE)
    );
    Block ORPIMENT_STAIRS = registerStair("orpiment_stairs", ORPIMENT);
    Block ORPIMENT_SLAB = registerSlab("orpiment_slab", ORPIMENT);
    Block ORPIMENT_WALL = registerWall("orpiment_wall", ORPIMENT);
    Block SMOOTH_ORPIMENT = registerSubBlock("smooth_orpiment", ORPIMENT);
    Block SMOOTH_ORPIMENT_STAIRS = registerStair("smooth_orpiment_stairs", SMOOTH_ORPIMENT);
    Block SMOOTH_ORPIMENT_SLAB = registerSlab("smooth_orpiment_slab", SMOOTH_ORPIMENT);
    Block SMOOTH_ORPIMENT_WALL = registerWall("smooth_orpiment_wall", SMOOTH_ORPIMENT);
    Block POLISHED_ORPIMENT = registerSubBlock("polished_orpiment", ORPIMENT);
    Block POLISHED_ORPIMENT_STAIRS = registerStair("polished_orpiment_stairs", POLISHED_ORPIMENT);
    Block POLISHED_ORPIMENT_SLAB = registerSlab("polished_orpiment_slab", POLISHED_ORPIMENT);
    Block POLISHED_ORPIMENT_WALL = registerWall("polished_orpiment_wall", POLISHED_ORPIMENT);
    Block ORPIMENT_BRICKS = registerSubBlock("orpiment_bricks", POLISHED_ORPIMENT);
    Block ORPIMENT_BRICK_STAIRS = registerStair("orpiment_brick_stairs", ORPIMENT_BRICKS);
    Block ORPIMENT_BRICK_SLAB = registerSlab("orpiment_brick_slab", ORPIMENT_BRICKS);
    Block ORPIMENT_BRICK_WALL = registerWall("orpiment_brick_wall", ORPIMENT_BRICKS);
    Block CHISELED_ORPIMENT = registerSubBlock("chiseled_orpiment", POLISHED_ORPIMENT);
    Block CHISELED_ORPIMENT_BRICKS = registerSubBlock("chiseled_orpiment_bricks", ORPIMENT_BRICKS);
    Block ORPIMENT_PILLAR = register("orpiment_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_ORPIMENT)
    );


    // Soul Sandstone
    Block SOUL_SANDSTONE = register("soul_sandstone", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.BASALT)
    );
    Block SOUL_SANDSTONE_STAIRS = registerStair("soul_sandstone_stairs", SOUL_SANDSTONE);
    Block SOUL_SANDSTONE_SLAB = registerSlab("soul_sandstone_slab", SOUL_SANDSTONE);
    Block SOUL_SANDSTONE_WALL = registerWall("soul_sandstone_wall", SOUL_SANDSTONE);

    Block SMOOTH_SOUL_SANDSTONE = registerSubBlock("smooth_soul_sandstone", SOUL_SANDSTONE);
    Block SMOOTH_SOUL_SANDSTONE_STAIRS = registerStair("smooth_soul_sandstone_stairs", SMOOTH_SOUL_SANDSTONE);
    Block SMOOTH_SOUL_SANDSTONE_SLAB = registerSlab("smooth_soul_sandstone_slab", SMOOTH_SOUL_SANDSTONE);
    Block SMOOTH_SOUL_SANDSTONE_WALL = registerWall("smooth_soul_sandstone_wall", SMOOTH_SOUL_SANDSTONE);

    Block CUT_SOUL_SANDSTONE = registerSubBlock("cut_soul_sandstone", SOUL_SANDSTONE);
    Block CUT_SOUL_SANDSTONE_STAIRS = registerStair("cut_soul_sandstone_stairs", CUT_SOUL_SANDSTONE);
    Block CUT_SOUL_SANDSTONE_SLAB = registerSlab("cut_soul_sandstone_slab", CUT_SOUL_SANDSTONE);
    Block CUT_SOUL_SANDSTONE_WALL = registerWall("cut_soul_sandstone_wall", CUT_SOUL_SANDSTONE);

    Block POLISHED_SOUL_SANDSTONE = registerSubBlock("polished_soul_sandstone", SOUL_SANDSTONE);
    Block POLISHED_SOUL_SANDSTONE_STAIRS = registerStair("polished_soul_sandstone_stairs", POLISHED_SOUL_SANDSTONE);
    Block POLISHED_SOUL_SANDSTONE_SLAB = registerSlab("polished_soul_sandstone_slab", POLISHED_SOUL_SANDSTONE);
    Block POLISHED_SOUL_SANDSTONE_WALL = registerWall("polished_soul_sandstone_wall", POLISHED_SOUL_SANDSTONE);

    Block SOUL_SANDSTONE_BRICKS = registerSubBlock("soul_sandstone_bricks", SOUL_SANDSTONE);
    Block SOUL_SANDSTONE_BRICK_STAIRS = registerStair("soul_sandstone_brick_stairs", SOUL_SANDSTONE_BRICKS);
    Block SOUL_SANDSTONE_BRICK_SLAB = registerSlab("soul_sandstone_brick_slab", SOUL_SANDSTONE_BRICKS);
    Block SOUL_SANDSTONE_BRICK_WALL = registerWall("soul_sandstone_brick_wall", SOUL_SANDSTONE_BRICKS);

    Block CHISELED_SOUL_SANDSTONE = registerSubBlock("chiseled_soul_sandstone", SOUL_SANDSTONE);

    // Singular Purpur Block
    Block CHISELED_PURPUR = registerSubBlock("chiseled_purpur", Blocks.PURPUR_BLOCK);

    Block ICICLE = register("icicle", p -> new SpikeBlock(Blocks.PACKED_ICE, 5, SoundEvents.GLASS_BREAK, p), true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)
    );

    Block PACKED_MUD_STAIRS = registerStair("packed_mud_stairs", Blocks.PACKED_MUD);
    Block PACKED_MUD_SLAB = registerSlab("packed_mud_slab", Blocks.PACKED_MUD);
    Block PACKED_MUD_WALL = registerWall("packed_mud_wall", Blocks.PACKED_MUD);
    Block CHISELED_MUD_BRICKS = registerSubBlock("chiseled_mud_bricks", Blocks.MUD_BRICKS);
    Block MUD_BRICK_PILLAR = register("mud_brick_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)
    );


    // Wood Blocks
    Block OAK_MOSAIC = registerSubBlock("oak_mosaic", Blocks.OAK_PLANKS);
    Block OAK_MOSAIC_STAIRS = registerStair("oak_mosaic_stairs", OAK_MOSAIC);
    Block OAK_MOSAIC_SLAB = registerSlab("oak_mosaic_slab", OAK_MOSAIC);
    Block OAK_BOARDS = register("oak_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
    );
    Block OAK_TRIM = registerSubBlock("oak_trim", Blocks.OAK_PLANKS);

    Block DARK_OAK_MOSAIC = registerSubBlock("dark_oak_mosaic", Blocks.DARK_OAK_PLANKS);
    Block DARK_OAK_MOSAIC_STAIRS = registerStair("dark_oak_mosaic_stairs", DARK_OAK_MOSAIC);
    Block DARK_OAK_MOSAIC_SLAB = registerSlab("dark_oak_mosaic_slab", DARK_OAK_MOSAIC);
    Block DARK_OAK_BOARDS = register("dark_oak_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
    );
    Block DARK_OAK_TRIM = registerSubBlock("dark_oak_trim", Blocks.DARK_OAK_PLANKS);

    Block PALE_OAK_MOSAIC = registerSubBlock("pale_oak_mosaic", Blocks.PALE_OAK_PLANKS);
    Block PALE_OAK_MOSAIC_STAIRS = registerStair("pale_oak_mosaic_stairs", PALE_OAK_MOSAIC);
    Block PALE_OAK_MOSAIC_SLAB = registerSlab("pale_oak_mosaic_slab", PALE_OAK_MOSAIC);
    Block PALE_OAK_BOARDS = register("pale_oak_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS)
    );
    Block PALE_OAK_TRIM = registerSubBlock("pale_oak_trim", Blocks.PALE_OAK_PLANKS);

    Block BIRCH_MOSAIC = registerSubBlock("birch_mosaic", Blocks.BIRCH_PLANKS);
    Block BIRCH_MOSAIC_STAIRS = registerStair("birch_mosaic_stairs", BIRCH_MOSAIC);
    Block BIRCH_MOSAIC_SLAB = registerSlab("birch_mosaic_slab", BIRCH_MOSAIC);
    Block BIRCH_BOARDS = register("birch_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
    );
    Block BIRCH_TRIM = registerSubBlock("birch_trim", Blocks.BIRCH_PLANKS);

    Block SPRUCE_MOSAIC = registerSubBlock("spruce_mosaic", Blocks.SPRUCE_PLANKS);
    Block SPRUCE_MOSAIC_STAIRS = registerStair("spruce_mosaic_stairs", SPRUCE_MOSAIC);
    Block SPRUCE_MOSAIC_SLAB = registerSlab("spruce_mosaic_slab", SPRUCE_MOSAIC);
    Block SPRUCE_BOARDS = register("spruce_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
    );
    Block SPRUCE_TRIM = registerSubBlock("spruce_trim", Blocks.SPRUCE_PLANKS);

    Block JUNGLE_MOSAIC = registerSubBlock("jungle_mosaic", Blocks.JUNGLE_PLANKS);
    Block JUNGLE_MOSAIC_STAIRS = registerStair("jungle_mosaic_stairs", JUNGLE_MOSAIC);
    Block JUNGLE_MOSAIC_SLAB = registerSlab("jungle_mosaic_slab", JUNGLE_MOSAIC);
    Block JUNGLE_BOARDS = register("jungle_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
    );
    Block JUNGLE_TRIM = registerSubBlock("jungle_trim", Blocks.JUNGLE_PLANKS);

    Block ACACIA_MOSAIC = registerSubBlock("acacia_mosaic", Blocks.ACACIA_PLANKS);
    Block ACACIA_MOSAIC_STAIRS = registerStair("acacia_mosaic_stairs", ACACIA_MOSAIC);
    Block ACACIA_MOSAIC_SLAB = registerSlab("acacia_mosaic_slab", ACACIA_MOSAIC);
    Block ACACIA_BOARDS = register("acacia_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
    );
    Block ACACIA_TRIM = registerSubBlock("acacia_trim", Blocks.ACACIA_PLANKS);

    Block CHERRY_MOSAIC = registerSubBlock("cherry_mosaic", Blocks.CHERRY_PLANKS);
    Block CHERRY_MOSAIC_STAIRS = registerStair("cherry_mosaic_stairs", CHERRY_MOSAIC);
    Block CHERRY_MOSAIC_SLAB = registerSlab("cherry_mosaic_slab", CHERRY_MOSAIC);
    Block CHERRY_BOARDS = register("cherry_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
    );
    Block CHERRY_TRIM = registerSubBlock("cherry_trim", Blocks.CHERRY_PLANKS);

    Block MANGROVE_MOSAIC = registerSubBlock("mangrove_mosaic", Blocks.MANGROVE_PLANKS);
    Block MANGROVE_MOSAIC_STAIRS = registerStair("mangrove_mosaic_stairs", MANGROVE_MOSAIC);
    Block MANGROVE_MOSAIC_SLAB = registerSlab("mangrove_mosaic_slab", MANGROVE_MOSAIC);
    Block MANGROVE_BOARDS = register("mangrove_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
    );
    Block MANGROVE_TRIM = registerSubBlock("mangrove_trim", Blocks.MANGROVE_PLANKS);

    Block CRIMSON_MOSAIC = registerSubBlock("crimson_mosaic", Blocks.CRIMSON_PLANKS);
    Block CRIMSON_MOSAIC_STAIRS = registerStair("crimson_mosaic_stairs", CRIMSON_MOSAIC);
    Block CRIMSON_MOSAIC_SLAB = registerSlab("crimson_mosaic_slab", CRIMSON_MOSAIC);
    Block CRIMSON_BOARDS = register("crimson_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
    );
    Block CRIMSON_TRIM = registerSubBlock("crimson_trim", Blocks.CRIMSON_PLANKS);

    Block WARPED_MOSAIC = registerSubBlock("warped_mosaic", Blocks.WARPED_PLANKS);
    Block WARPED_MOSAIC_STAIRS = registerStair("warped_mosaic_stairs", WARPED_MOSAIC);
    Block WARPED_MOSAIC_SLAB = registerSlab("warped_mosaic_slab", WARPED_MOSAIC);
    Block WARPED_BOARDS = register("warped_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
    );
    Block WARPED_TRIM = registerSubBlock("warped_trim", Blocks.WARPED_PLANKS);




    // Hibiscus
    Block RED_HIBISCUS = register("red_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block ORANGE_HIBISCUS = register("orange_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block YELLOW_HIBISCUS = register("yellow_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block BLUE_HIBISCUS = register("blue_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block PURPLE_HIBISCUS = register("purple_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block PINK_HIBISCUS = register("pink_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block WHITE_HIBISCUS = register("white_hibiscus", p -> new FlowerBlock(MobEffects.HASTE, 10.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );

    Block POTTED_RED_HIBISCUS = register("potted_red_hibiscus", p -> new FlowerPotBlock(RED_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_ORANGE_HIBISCUS = register("potted_orange_hibiscus", p -> new FlowerPotBlock(ORANGE_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_YELLOW_HIBISCUS = register("potted_yellow_hibiscus", p -> new FlowerPotBlock(YELLOW_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_BLUE_HIBISCUS = register("potted_blue_hibiscus", p -> new FlowerPotBlock(BLUE_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_PURPLE_HIBISCUS = register("potted_purple_hibiscus", p -> new FlowerPotBlock(PURPLE_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_PINK_HIBISCUS = register("potted_pink_hibiscus", p -> new FlowerPotBlock(PINK_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_WHITE_HIBISCUS = register("potted_white_hibiscus", p -> new FlowerPotBlock(WHITE_HIBISCUS, p), false,
            Blocks.flowerPotProperties()
    );

    // Natural blocks
    Block BLUEBONNET = register("bluebonnet", p -> new FlowerBlock(MobEffects.RESISTANCE, 5.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block POTTED_BLUEBONNET = register("potted_bluebonnet", p -> new FlowerPotBlock(BLUEBONNET, p),false,
            Blocks.flowerPotProperties()
    );

    Block PEBBLE = register("pebble", PebbleBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instabreak().sound(SoundType.STONE).noOcclusion().noCollision()
    );

    Block LATERITE = register("laterite", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.WART_BLOCK)
    );

    Block RED_GRASS_BLOCK = register("red_grass_block", SnowyBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.5F).sound(SoundType.GRASS)
    );
    Block SHORT_RED_GRASS = register("short_red_grass", BushBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block TALL_RED_GRASS = register("tall_red_grass", DoublePlantBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block RED_SHRUB = register("red_shrub", BushBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)
    );

    Block RUSTY_MOSS_BLOCK = register("rusty_moss_block", p -> new BonemealableFeaturePlacerBlock(VegetationFeatures.PALE_MOSS_PATCH_BONEMEAL, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.1F).sound(SoundType.MOSS)
    );
    Block RUSTY_MOSS_CARPET = register("rusty_moss_carpet", MossyCarpetBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(RUSTY_MOSS_BLOCK).sound(SoundType.MOSS_CARPET)
    );

    // Arid Dirt
    ResourceKey<Block> ARID_DIRT_KEY = ResourceKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "arid_dirt")
    );
    Block ARID_DIRT = register("arid_dirt", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.ROOTED_DIRT)
    );
    Block ARID_GRASS_BLOCK = register("arid_grass_block", AridGrassBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.ROOTED_DIRT).randomTicks()
    );
    Map<Block, Block> DIRT_TO_GRASS = Map.of(
            Blocks.DIRT, Blocks.GRASS_BLOCK,
            ARID_DIRT, ARID_GRASS_BLOCK
    );
















    static <T extends SignBlock> T registerSignBlock(ResourceKey<Block> key, T block) {
        if (block instanceof StandingSignBlock || block instanceof WallSignBlock) {
            BlockEntityType.SIGN.addValidBlock(block);
        } else if (block instanceof CeilingHangingSignBlock || block instanceof WallHangingSignBlock) {
            BlockEntityType.HANGING_SIGN.addValidBlock(block);
        } else {
            throw new IllegalArgumentException("This method only accepts vanilla sign blocks and descendants!");
        }

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }







    // Registry Method
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory,  boolean shouldRegisterItem, BlockBehaviour.Properties settings) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Register if it needs an item (ex: register piston, don't register moving piston)
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }

    // Helper Methods
    private static Block registerSubBlock(final String name, Block block) {
        return register(name, Block::new, true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerStair(final String name, Block block) {
        return register(name, p -> new StairBlock(block.defaultBlockState(), p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerSlab(final String name, Block block) {
        return register(name, SlabBlock::new, true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerFence(final String name, Block block) {
        return register(name, FenceBlock::new, true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerFenceGate(final String name, WoodType woodType, Block block) {
        return register(name, p -> new FenceGateBlock(woodType, p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerWall(final String name, Block block) {
        return register(name, WallBlock::new, true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerDoor(final String name, BlockSetType blockSetType, Block block) {
        return register(name, p -> new DoorBlock(blockSetType, p.noOcclusion()), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerTrapdoor(final String name, BlockSetType blockSetType, Block block) {
        return register(name, p -> new TrapDoorBlock(blockSetType, p.noOcclusion()), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerButton(final String name, BlockSetType blockSetType, Block block, Integer ticksToStayPressed) {
        return register(name, p -> new ButtonBlock(blockSetType, ticksToStayPressed, p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerPressurePlate(final String name, BlockSetType blockSetType, Block block) {
        return register(name, p -> new PressurePlateBlock(blockSetType, p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerShelf(final String name, Block block) {
        return register(name, ShelfBlock::new, true, BlockBehaviour.Properties.ofFullCopy(block));
    }
    private static Block registerSapling(final String name, TreeGrower treeGrower) {
        return register(name, p -> new SaplingBlock(treeGrower, p), true, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    }
    private static Block registerPottedSapling(final String name, Block block) {
        return register(name, p -> new FlowerPotBlock(block, p), true, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING));
    }

    // Sign Methods (HELP ME)
    private static Block registerSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new StandingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static Block registerWallSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new WallSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static Block registerCeilingHangingSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new CeilingHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static Block registerWallHangingSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new WallHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block));
    }


    // Initialize
    static void initialize() {}
}