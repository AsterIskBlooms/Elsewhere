package team.lookingglass.elsewhere.registry;

import net.fabricmc.fabric.api.client.rendering.v1.ColorResolverRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.dimension.portal.VeilrootPortalBlock;
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
import team.lookingglass.elsewhere.registry.render.EParticles;
import team.lookingglass.elsewhere.registry.sets.EBlockSets;
import team.lookingglass.elsewhere.registry.sets.EWoodTypes;
import team.lookingglass.elsewhere.worldgen.EConfiguredFeatures;

import java.util.Map;
import java.util.function.Function;

public interface EBlocks {


    // Quartz Brick Fill
    Block QUARTZ_BRICK_STAIRS = registerStair("quartz_brick_stairs", Blocks.QUARTZ_BRICKS);
    Block QUARTZ_BRICK_SLAB = registerSlab("quartz_brick_slab", Blocks.QUARTZ_BRICKS);

    // Amethyst-Obsidian Set
    Block AMETHYST_STAIRS = register("amethyst_stairs", p -> new AmethystStairBlock(Blocks.AMETHYST_BLOCK.defaultBlockState(), p), true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block AMETHYST_SLAB = register("amethyst_slab", AmethystSlabBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block AMETHYST_BRICKS = register("amethyst_bricks", AmethystBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block AMETHYST_BRICK_STAIRS = register("amethyst_brick_stairs", p -> new AmethystStairBlock(Blocks.AMETHYST_BLOCK.defaultBlockState(), p), true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block AMETHYST_BRICK_SLAB = register("amethyst_brick_slab", AmethystSlabBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block AMETHYST_PILLAR = register("amethyst_pillar", AmethystPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
    );
    Block CHISELED_AMETHYST = register("chiseled_amethyst", AmethystBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
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

    Block CHISELED_DEEPSLATE_BRICKS = registerSubBlock("chiseled_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    Block DEEPSLATE_PILLAR = register("deepslate_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)
    );

    Block TUFF_PILLAR = register("tuff_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF)
    );

    Block BLACKSTONE_PILLAR = register("blackstone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
    );

    Block POLISHED_ANDESITE_WALL = registerWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
    Block ANDESITE_BRICKS = register("andesite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE)
    );
    Block ANDESITE_BRICK_STAIRS = registerStair("andesite_brick_stairs", ANDESITE_BRICKS);
    Block ANDESITE_BRICK_SLAB = registerSlab("andesite_brick_slab", ANDESITE_BRICKS);
    Block ANDESITE_BRICK_WALL = registerWall("andesite_brick_wall", ANDESITE_BRICKS);
    Block CHISELED_ANDESITE = registerSubBlock("chiseled_andesite", ANDESITE_BRICKS);
    Block ANDESITE_PILLAR = register("andesite_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(ANDESITE_BRICKS)
    );

    Block POLISHED_GRANITE_WALL = registerWall("polished_granite_wall", Blocks.POLISHED_GRANITE);
    Block GRANITE_BRICKS = register("granite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE)
    );
    Block GRANITE_BRICK_STAIRS = registerStair("granite_brick_stairs", GRANITE_BRICKS);
    Block GRANITE_BRICK_SLAB = registerSlab("granite_brick_slab", GRANITE_BRICKS);
    Block GRANITE_BRICK_WALL = registerWall("granite_brick_wall", GRANITE_BRICKS);
    Block CHISELED_GRANITE = registerSubBlock("chiseled_granite", GRANITE_BRICKS);

    Block POLISHED_DIORITE_WALL = registerWall("polished_diorite_wall", Blocks.POLISHED_DIORITE);
    Block DIORITE_BRICKS = register("diorite_bricks", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE)
    );
    Block DIORITE_BRICK_STAIRS = registerStair("diorite_brick_stairs", DIORITE_BRICKS);
    Block DIORITE_BRICK_SLAB = registerSlab("diorite_brick_slab", DIORITE_BRICKS);
    Block DIORITE_BRICK_WALL = registerWall("diorite_brick_wall", DIORITE_BRICKS);
    Block CHISELED_DIORITE = registerSubBlock("chiseled_diorite", DIORITE_BRICKS);

    Block BEJEWELED_CALCITE = registerSubBlock("bejeweled_calcite", Blocks.CALCITE);
    Block CALCITE_STAIRS = registerStair("calcite_stairs", Blocks.CALCITE);
    Block CALCITE_SLAB = registerSlab("calcite_slab", Blocks.CALCITE);
    Block CALCITE_WALL = registerWall("calcite_wall", Blocks.CALCITE);
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
    Block POLISHED_DRIPSTONE = register("polished_dripstone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)
    );
    Block POLISHED_DRIPSTONE_STAIRS = registerStair("polished_dripstone_stairs", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_SLAB = registerSlab("polished_dripstone_slab", POLISHED_DRIPSTONE);
    Block POLISHED_DRIPSTONE_WALL = registerWall("polished_dripstone_wall", POLISHED_DRIPSTONE);
    Block DRIPSTONE_TILES = registerSubBlock("dripstone_tiles", POLISHED_DRIPSTONE);
    Block DRIPSTONE_TILE_STAIRS = registerStair("dripstone_tile_stairs", DRIPSTONE_TILES);
    Block DRIPSTONE_TILE_SLAB = registerSlab("dripstone_tile_slab", DRIPSTONE_TILES);
    Block DRIPSTONE_TILE_WALL = registerWall("dripstone_tile_wall", DRIPSTONE_TILES);
    Block CHISELED_DRIPSTONE_TILES = registerSubBlock("chiseled_dripstone_tiles", DRIPSTONE_TILES);
    Block DRIPSTONE_PILLAR = register("dripstone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_TILES)
    );



    // Sandstone Fills
    Block POLISHED_SANDSTONE = registerSubBlock("polished_sandstone", Blocks.CUT_SANDSTONE);
    Block POLISHED_SANDSTONE_STAIRS = registerStair("polished_sandstone_stairs", POLISHED_SANDSTONE);
    Block POLISHED_SANDSTONE_SLAB = registerSlab("polished_sandstone_slab", POLISHED_SANDSTONE);
    Block POLISHED_SANDSTONE_WALL = registerWall("polished_sandstone_wall", POLISHED_SANDSTONE);

    Block SMOOTH_SANDSTONE_WALL = registerWall("smooth_sandstone_wall", Blocks.SMOOTH_SANDSTONE);

    Block CUT_SANDSTONE_STAIRS = registerStair("cut_sandstone_stairs", Blocks.CUT_SANDSTONE);
    Block CUT_SANDSTONE_WALL = registerWall("cut_sandstone_wall", Blocks.CUT_SANDSTONE);

    Block POLISHED_RED_SANDSTONE = registerSubBlock("polished_red_sandstone", Blocks.CUT_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_STAIRS = registerStair("polished_red_sandstone_stairs", POLISHED_RED_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_SLAB = registerSlab("polished_red_sandstone_slab", POLISHED_RED_SANDSTONE);
    Block POLISHED_RED_SANDSTONE_WALL = registerWall("polished_red_sandstone_wall", POLISHED_RED_SANDSTONE);

    Block SMOOTH_RED_SANDSTONE_WALL = registerWall("smooth_red_sandstone_wall", Blocks.SMOOTH_RED_SANDSTONE);

    Block CUT_RED_SANDSTONE_STAIRS = registerStair("cut_red_sandstone_stairs", Blocks.CUT_RED_SANDSTONE);
    Block CUT_RED_SANDSTONE_WALL = registerWall("cut_red_sandstone_wall", Blocks.CUT_RED_SANDSTONE);



    // Prismarine
    Block POLISHED_PRISMARINE = register("polished_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)
    );
    Block POLISHED_PRISMARINE_STAIRS = registerStair("polished_prismarine_stairs", POLISHED_PRISMARINE);
    Block POLISHED_PRISMARINE_SLAB = registerSlab("polished_prismarine_slab", POLISHED_PRISMARINE);
    Block POLISHED_PRISMARINE_WALL = registerWall("polished_prismarine_wall", POLISHED_PRISMARINE);
    Block PRISMARINE_BRICK_WALL = registerWall("prismarine_brick_wall", Blocks.PRISMARINE_BRICKS);
    Block CHISELED_PRISMARINE = registerSubBlock("chiseled_prismarine", Blocks.PRISMARINE_BRICKS);
    Block PRISMARINE_PILLAR = register("prismarine_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)
    );

    Block DARK_PRISMARINE_WALL = registerWall("dark_prismarine_wall", Blocks.DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE = register("polished_dark_prismarine", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE)
    );
    Block POLISHED_DARK_PRISMARINE_STAIRS = registerStair("polished_dark_prismarine_stairs", POLISHED_DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE_SLAB = registerSlab("polished_dark_prismarine_slab", POLISHED_DARK_PRISMARINE);
    Block POLISHED_DARK_PRISMARINE_WALL = registerWall("polished_dark_prismarine_wall", POLISHED_DARK_PRISMARINE);
    Block DARK_PRISMARINE_SCALES = register("dark_prismarine_scales", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(POLISHED_DARK_PRISMARINE).sound(ESounds.STONE_TILES)
    );
    Block DARK_PRISMARINE_SCALE_STAIRS = registerStair("dark_prismarine_scale_stairs", DARK_PRISMARINE_SCALES);
    Block DARK_PRISMARINE_SCALE_SLAB = registerSlab("dark_prismarine_scale_slab", DARK_PRISMARINE_SCALES);
    Block DARK_PRISMARINE_SCALE_WALL = registerWall("dark_prismarine_scale_wall", DARK_PRISMARINE_SCALES);
    Block CHISELED_DARK_PRISMARINE = registerSubBlock("chiseled_dark_prismarine", DARK_PRISMARINE_SCALES);


    // Basalt & Smooth Basalt
    Block BASALT_SLAB = registerSlab("basalt_slab", Blocks.BASALT);
    Block POLISHED_BASALT_SLAB = registerSlab("polished_basalt_slab", Blocks.POLISHED_BASALT);

    Block SMOOTH_BASALT_STAIRS = registerStair("smooth_basalt_stairs", Blocks.SMOOTH_BASALT);
    Block SMOOTH_BASALT_SLAB = registerSlab("smooth_basalt_slab", Blocks.SMOOTH_BASALT);
    Block SMOOTH_BASALT_WALL = registerWall("smooth_basalt_wall", Blocks.SMOOTH_BASALT);
    Block POLISHED_SMOOTH_BASALT = registerSubBlock("polished_smooth_basalt", Blocks.SMOOTH_BASALT);
    Block POLISHED_SMOOTH_BASALT_STAIRS = registerStair("polished_smooth_basalt_stairs", Blocks.SMOOTH_BASALT);
    Block POLISHED_SMOOTH_BASALT_SLAB = registerSlab("polished_smooth_basalt_slab", Blocks.SMOOTH_BASALT);
    Block POLISHED_SMOOTH_BASALT_WALL = registerWall("polished_smooth_basalt_wall", Blocks.SMOOTH_BASALT);
    Block SMOOTH_BASALT_BRICKS = registerSubBlock("smooth_basalt_bricks", Blocks.POLISHED_BASALT);
    Block SMOOTH_BASALT_BRICK_STAIRS = registerStair("smooth_basalt_brick_stairs", SMOOTH_BASALT_BRICKS);
    Block SMOOTH_BASALT_BRICK_SLAB = registerSlab("smooth_basalt_brick_slab", SMOOTH_BASALT_BRICKS);
    Block SMOOTH_BASALT_BRICK_WALL = registerWall("smooth_basalt_brick_wall", SMOOTH_BASALT_BRICKS);
    Block SMOOTH_BASALT_TILES = registerSubBlock("smooth_basalt_tiles", SMOOTH_BASALT_BRICKS);
    Block SMOOTH_BASALT_TILE_STAIRS = registerStair("smooth_basalt_tile_stairs", SMOOTH_BASALT_TILES);
    Block SMOOTH_BASALT_TILE_SLAB = registerSlab("smooth_basalt_tile_slab", SMOOTH_BASALT_TILES);
    Block SMOOTH_BASALT_TILE_WALL = registerWall("smooth_basalt_tile_wall", SMOOTH_BASALT_TILES);


    // End Stone
    Block POLISHED_END_STONE = register("polished_end_stone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
    );
    Block END_STONE_STAIRS = registerStair("end_stone_stairs", POLISHED_END_STONE);
    Block END_STONE_SLAB = registerSlab("end_stone_slab", POLISHED_END_STONE);
    Block END_STONE_WALL = registerWall("end_stone_wall", POLISHED_END_STONE);
    Block POLISHED_END_STONE_STAIRS = registerStair("polished_end_stone_stairs", POLISHED_END_STONE);
    Block POLISHED_END_STONE_SLAB = registerSlab("polished_end_stone_slab", POLISHED_END_STONE);
    Block POLISHED_END_STONE_WALL = registerWall("polished_end_stone_wall", POLISHED_END_STONE);
    Block CHISELED_END_STONE = registerSubBlock("chiseled_end_stone", Blocks.END_STONE_BRICKS);
    Block END_STONE_PILLAR = register("end_stone_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)
    );


    // Sodalite
    Block SODALITE = register("sodalite", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.0F, 6.0F).sound(SoundType.TUFF)
    );
    Block SODALITE_STAIRS = registerStair("sodalite_stairs", SODALITE);
    Block SODALITE_SLAB = registerSlab("sodalite_slab", SODALITE);
    Block SODALITE_WALL = registerWall("sodalite_wall", SODALITE);
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
            BlockBehaviour.Properties.ofFullCopy(SODALITE_BRICKS)
    );

    // SHAAAALE
    Block SHALE = register("shale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(ESounds.SHALE)
    );
    Block SHALE_STAIRS = registerStair("shale_stairs", SHALE);
    Block SHALE_SLAB = registerSlab("shale_slab", SHALE);
    Block SHALE_WALL = registerWall("shale_wall", SHALE);
    Block POLISHED_SHALE = register("polished_shale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.SHALE)
    );
    Block POLISHED_SHALE_STAIRS = registerStair("polished_shale_stairs", POLISHED_SHALE);
    Block POLISHED_SHALE_SLAB = registerSlab("polished_shale_slab", POLISHED_SHALE);
    Block POLISHED_SHALE_WALL = registerWall("polished_shale_wall", POLISHED_SHALE);
    Block SHALE_BRICKS = register("shale_bricks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.SHALE_BRICKS)
    );
    Block SHALE_BRICK_STAIRS = registerStair("shale_brick_stairs", SHALE_BRICKS);
    Block SHALE_BRICK_SLAB = registerSlab("shale_brick_slab", SHALE_BRICKS);
    Block SHALE_BRICK_WALL = registerWall("shale_brick_wall", SHALE_BRICKS);
    Block CHISELED_SHALE = registerSubBlock("chiseled_shale", POLISHED_SHALE);
    Block CHISELED_SHALE_BRICKS = registerSubBlock("chiseled_shale_bricks", SHALE_BRICKS);
    Block SHALE_PILLAR = register("shale_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(SHALE_BRICKS)
    );
    Block COBBLESHALE = register("cobbleshale", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ESounds.SHALE)
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
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F, 6.0F).sound(ESounds.SHALE)
    );
    Block SHALE_COPPER_ORE = registerSubBlock("shale_copper_ore", SHALE_COAL_ORE);
    Block SHALE_IRON_ORE = registerSubBlock("shale_iron_ore", SHALE_COAL_ORE);
    Block SHALE_GOLD_ORE = registerSubBlock("shale_gold_ore", SHALE_COAL_ORE);
    Block SHALE_REDSTONE_ORE = register("shale_redstone_ore", RedStoneOreBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().randomTicks().lightLevel(Blocks.litBlockEmission(9)).strength(3.0F, 6.0F).sound(ESounds.SHALE)
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
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.0F, 6.0F).sound(ESounds.SULFUR)
    );
    Block SULFUR_STAIRS = registerStair("sulfur_stairs", SULFUR);
    Block SULFUR_SLAB = registerSlab("sulfur_slab", SULFUR);
    Block SULFUR_WALL = registerWall("sulfur_wall", SULFUR);
    Block POLISHED_SULFUR = registerSubBlock("polished_sulfur", SULFUR);
    Block POLISHED_SULFUR_STAIRS = registerStair("polished_sulfur_stairs", POLISHED_SULFUR);
    Block POLISHED_SULFUR_SLAB = registerSlab("polished_sulfur_slab", POLISHED_SULFUR);
    Block POLISHED_SULFUR_WALL = registerWall("polished_sulfur_wall", POLISHED_SULFUR);
    Block SULFUR_BRICKS = registerSubBlock("sulfur_bricks", POLISHED_SULFUR);
    Block SULFUR_BRICK_STAIRS = registerStair("sulfur_brick_stairs", SULFUR_BRICKS);
    Block SULFUR_BRICK_SLAB = registerSlab("sulfur_brick_slab", SULFUR_BRICKS);
    Block SULFUR_BRICK_WALL = registerWall("sulfur_brick_wall", SULFUR_BRICKS);
    Block CHISELED_SULFUR = registerSubBlock("chiseled_sulfur", POLISHED_SULFUR);
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
    Block POLISHED_CINNABAR = registerSubBlock("polished_cinnabar", CINNABAR);
    Block POLISHED_CINNABAR_STAIRS = registerStair("polished_cinnabar_stairs", POLISHED_CINNABAR);
    Block POLISHED_CINNABAR_SLAB = registerSlab("polished_cinnabar_slab", POLISHED_CINNABAR);
    Block POLISHED_CINNABAR_WALL = registerWall("polished_cinnabar_wall", POLISHED_CINNABAR);
    Block CINNABAR_BRICKS = registerSubBlock("cinnabar_bricks", POLISHED_CINNABAR);
    Block CINNABAR_BRICK_STAIRS = registerStair("cinnabar_brick_stairs", CINNABAR_BRICKS);
    Block CINNABAR_BRICK_SLAB = registerSlab("cinnabar_brick_slab", CINNABAR_BRICKS);
    Block CINNABAR_BRICK_WALL = registerWall("cinnabar_brick_wall", CINNABAR_BRICKS);
    Block CHISELED_CINNABAR = registerSubBlock("chiseled_cinnabar", POLISHED_CINNABAR);
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
    Block POLISHED_NETHERRACK = registerSubBlock("polished_netherrack", Blocks.NETHERRACK);
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
    Block POLISHED_ORPIMENT = registerSubBlock("polished_orpiment", ORPIMENT);
    Block POLISHED_ORPIMENT_STAIRS = registerStair("polished_orpiment_stairs", POLISHED_ORPIMENT);
    Block POLISHED_ORPIMENT_SLAB = registerSlab("polished_orpiment_slab", POLISHED_ORPIMENT);
    Block POLISHED_ORPIMENT_WALL = registerWall("polished_orpiment_wall", POLISHED_ORPIMENT);
    Block ORPIMENT_BRICKS = registerSubBlock("orpiment_bricks", POLISHED_ORPIMENT);
    Block ORPIMENT_BRICK_STAIRS = registerStair("orpiment_brick_stairs", ORPIMENT_BRICKS);
    Block ORPIMENT_BRICK_SLAB = registerSlab("orpiment_brick_slab", ORPIMENT_BRICKS);
    Block ORPIMENT_BRICK_WALL = registerWall("orpiment_brick_wall", ORPIMENT_BRICKS);
    Block CHISELED_ORPIMENT = registerSubBlock("chiseled_orpiment", POLISHED_ORPIMENT);
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
    Block OAK_TRIM = register("oak_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
    );

    Block DARK_OAK_MOSAIC = registerSubBlock("dark_oak_mosaic", Blocks.DARK_OAK_PLANKS);
    Block DARK_OAK_MOSAIC_STAIRS = registerStair("dark_oak_mosaic_stairs", DARK_OAK_MOSAIC);
    Block DARK_OAK_MOSAIC_SLAB = registerSlab("dark_oak_mosaic_slab", DARK_OAK_MOSAIC);
    Block DARK_OAK_BOARDS = register("dark_oak_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
    );
    Block DARK_OAK_TRIM = register("dark_oak_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
    );

    Block PALE_OAK_MOSAIC = registerSubBlock("pale_oak_mosaic", Blocks.PALE_OAK_PLANKS);
    Block PALE_OAK_MOSAIC_STAIRS = registerStair("pale_oak_mosaic_stairs", PALE_OAK_MOSAIC);
    Block PALE_OAK_MOSAIC_SLAB = registerSlab("pale_oak_mosaic_slab", PALE_OAK_MOSAIC);
    Block PALE_OAK_BOARDS = register("pale_oak_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS)
    );
    Block PALE_OAK_TRIM = register("pale_oak_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS)
    );

    Block BIRCH_MOSAIC = registerSubBlock("birch_mosaic", Blocks.BIRCH_PLANKS);
    Block BIRCH_MOSAIC_STAIRS = registerStair("birch_mosaic_stairs", BIRCH_MOSAIC);
    Block BIRCH_MOSAIC_SLAB = registerSlab("birch_mosaic_slab", BIRCH_MOSAIC);
    Block BIRCH_BOARDS = register("birch_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
    );
    Block BIRCH_TRIM = register("birch_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
    );

    Block SPRUCE_MOSAIC = registerSubBlock("spruce_mosaic", Blocks.SPRUCE_PLANKS);
    Block SPRUCE_MOSAIC_STAIRS = registerStair("spruce_mosaic_stairs", SPRUCE_MOSAIC);
    Block SPRUCE_MOSAIC_SLAB = registerSlab("spruce_mosaic_slab", SPRUCE_MOSAIC);
    Block SPRUCE_BOARDS = register("spruce_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
    );
    Block SPRUCE_TRIM = register("spruce_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
    );

    Block JUNGLE_MOSAIC = registerSubBlock("jungle_mosaic", Blocks.JUNGLE_PLANKS);
    Block JUNGLE_MOSAIC_STAIRS = registerStair("jungle_mosaic_stairs", JUNGLE_MOSAIC);
    Block JUNGLE_MOSAIC_SLAB = registerSlab("jungle_mosaic_slab", JUNGLE_MOSAIC);
    Block JUNGLE_BOARDS = register("jungle_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
    );
    Block JUNGLE_TRIM = register("jungle_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
    );

    Block ACACIA_MOSAIC = registerSubBlock("acacia_mosaic", Blocks.ACACIA_PLANKS);
    Block ACACIA_MOSAIC_STAIRS = registerStair("acacia_mosaic_stairs", ACACIA_MOSAIC);
    Block ACACIA_MOSAIC_SLAB = registerSlab("acacia_mosaic_slab", ACACIA_MOSAIC);
    Block ACACIA_BOARDS = register("acacia_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
    );
    Block ACACIA_TRIM = register("acacia_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
    );

    Block CHERRY_MOSAIC = registerSubBlock("cherry_mosaic", Blocks.CHERRY_PLANKS);
    Block CHERRY_MOSAIC_STAIRS = registerStair("cherry_mosaic_stairs", CHERRY_MOSAIC);
    Block CHERRY_MOSAIC_SLAB = registerSlab("cherry_mosaic_slab", CHERRY_MOSAIC);
    Block CHERRY_BOARDS = register("cherry_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
    );
    Block CHERRY_TRIM = register("cherry_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
    );

    Block MANGROVE_MOSAIC = registerSubBlock("mangrove_mosaic", Blocks.MANGROVE_PLANKS);
    Block MANGROVE_MOSAIC_STAIRS = registerStair("mangrove_mosaic_stairs", MANGROVE_MOSAIC);
    Block MANGROVE_MOSAIC_SLAB = registerSlab("mangrove_mosaic_slab", MANGROVE_MOSAIC);
    Block MANGROVE_BOARDS = register("mangrove_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
    );
    Block MANGROVE_TRIM = register("mangrove_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
    );

    Block CRIMSON_MOSAIC = registerSubBlock("crimson_mosaic", Blocks.CRIMSON_PLANKS);
    Block CRIMSON_MOSAIC_STAIRS = registerStair("crimson_mosaic_stairs", CRIMSON_MOSAIC);
    Block CRIMSON_MOSAIC_SLAB = registerSlab("crimson_mosaic_slab", CRIMSON_MOSAIC);
    Block CRIMSON_BOARDS = register("crimson_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
    );
    Block CRIMSON_TRIM = register("crimson_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
    );

    Block WARPED_MOSAIC = registerSubBlock("warped_mosaic", Blocks.WARPED_PLANKS);
    Block WARPED_MOSAIC_STAIRS = registerStair("warped_mosaic_stairs", WARPED_MOSAIC);
    Block WARPED_MOSAIC_SLAB = registerSlab("warped_mosaic_slab", WARPED_MOSAIC);
    Block WARPED_BOARDS = register("warped_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
    );
    Block WARPED_TRIM = register("warped_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
    );

    Block BAMBOO_STEM = register("bamboo_stem", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK)
    );
    Block STRIPPED_BAMBOO_STEM = register("stripped_bamboo_stem", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK)
    );
    Block BAMBOO_BOARDS = register("bamboo_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
    );
    Block BAMBOO_TRIM = register("bamboo_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
    );

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

    Block MAGENTA_CONEFLOWER = register("magenta_coneflower", p -> new FlowerBlock(MobEffects.POISON, 3.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block YELLOW_CONEFLOWER = register("yellow_coneflower", p -> new FlowerBlock(MobEffects.POISON, 3.0F, p), true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block POTTED_MAGENTA_CONEFLOWER = register("potted_magenta_coneflower", p -> new FlowerPotBlock(MAGENTA_CONEFLOWER, p),false,
            Blocks.flowerPotProperties()
    );
    Block POTTED_YELLOW_CONEFLOWER = register("potted_yellow_coneflower", p -> new FlowerPotBlock(YELLOW_CONEFLOWER, p),false,
            Blocks.flowerPotProperties()
    );

    Block IRONWEED = register("ironweed", TallFlowerBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ)
    );

    Block PEBBLE = register("pebble", PebbleBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instabreak().sound(SoundType.STONE).noOcclusion()
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




    // Dappled Forest
    Block POPLAR_LOG = register("poplar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.CHERRY_WOOD)
    );
    Block STRIPPED_POPLAR_LOG = register("stripped_poplar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(2.0F, 2.0F).sound(SoundType.CHERRY_WOOD)
    );
    Block POPLAR_WOOD = register("poplar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.CHERRY_WOOD)
    );
    Block STRIPPED_POPLAR_WOOD = register("stripped_poplar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(2.0F, 2.0F).sound(SoundType.CHERRY_WOOD)
    );
    Block POPLAR_PLANKS = register("poplar_planks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(2.0F, 2.0F).sound(SoundType.CHERRY_WOOD)
    );
    Block POPLAR_STAIRS = registerStair("poplar_stairs", POPLAR_PLANKS);
    Block POPLAR_SLAB = registerSlab("poplar_slab", POPLAR_PLANKS);
    Block POPLAR_MOSAIC = registerSubBlock("poplar_mosaic", POPLAR_PLANKS);
    Block POPLAR_MOSAIC_STAIRS = registerStair("poplar_mosaic_stairs", POPLAR_MOSAIC);
    Block POPLAR_MOSAIC_SLAB = registerSlab("poplar_mosaic_slab", POPLAR_MOSAIC);
    Block POPLAR_BOARDS = register("poplar_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS)
    );
    Block POPLAR_TRIM = register("poplar_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS)
    );
    Block POPLAR_FENCE = registerFence("poplar_fence", POPLAR_PLANKS);
    Block POPLAR_FENCE_GATE = registerFenceGate("poplar_fence_gate", EWoodTypes.POPLAR, POPLAR_PLANKS);
    Block POPLAR_DOOR = registerDoor("poplar_door", EBlockSets.POPLAR, POPLAR_PLANKS);
    Block POPLAR_TRAPDOOR = registerTrapdoor("poplar_trapdoor", EBlockSets.POPLAR, POPLAR_PLANKS);
    Block POPLAR_PRESSURE_PLATE = registerPressurePlate("poplar_pressure_plate", EBlockSets.POPLAR, POPLAR_PLANKS);
    Block POPLAR_BUTTON = registerButton("poplar_button", EBlockSets.POPLAR, POPLAR_PLANKS, 30);
    Block POPLAR_SIGN = registerSign("poplar_sign", EWoodTypes.POPLAR, POPLAR_PLANKS);
    Block POPLAR_WALL_SIGN = registerWallSign("poplar_wall_sign", EWoodTypes.POPLAR, POPLAR_PLANKS);
    Block POPLAR_HANGING_SIGN = registerCeilingHangingSign("poplar_hanging_sign", EWoodTypes.POPLAR, POPLAR_PLANKS);
    Block POPLAR_WALL_HANGING_SIGN = registerWallHangingSign("poplar_wall_hanging_sign", EWoodTypes.POPLAR, POPLAR_PLANKS);
    Block POPLAR_SHELF = register("poplar_shelf", ShelfBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS).sound(SoundType.SHELF)
    );

    Block RED_POPLAR_LEAVES = register("red_poplar_leaves",
            p -> new UntintedParticleLeavesBlock(0.01F, EParticles.RED_POPLAR_LEAVES, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion()
    );
    Block ORANGE_POPLAR_LEAVES = register("orange_poplar_leaves",
            p -> new UntintedParticleLeavesBlock(0.01F, EParticles.ORANGE_POPLAR_LEAVES, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion()
    );
    Block YELLOW_POPLAR_LEAVES = register("yellow_poplar_leaves",
            p -> new UntintedParticleLeavesBlock(0.01F, EParticles.YELLOW_POPLAR_LEAVES, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.2F, 0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion()
    );
    Block POPLAR_SAPLING = registerSapling( "poplar_sapling", ETreeGrowers.POPLAR);
    Block POTTED_POPLAR_SAPLING = registerPottedSapling( "potted_poplar_sapling", POPLAR_SAPLING);

    Block RUSTY_MOSS_BLOCK = register("rusty_moss_block", p -> new BonemealableFeaturePlacerBlock(EConfiguredFeatures.RUSTY_MOSS_PATCH_BONEMEAL, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.1F).sound(SoundType.MOSS)
    );
    Block RUSTY_MOSS_CARPET = register("rusty_moss_carpet", CarpetBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(RUSTY_MOSS_BLOCK).sound(SoundType.MOSS_CARPET)
    );

    Block SEAGRASS_SAND = register("seagrass_sand", p -> new SandBlock(new ColorRGBA(14406560), p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.5F, 0.5F).sound(SoundType.WET_GRASS)
    );



    // Azalea
    Block AZALEA_LOG = register("azalea_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_AZALEA_LOG = register("stripped_azalea_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block AZALEA_WOOD = register("azalea_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_AZALEA_WOOD = register("stripped_azalea_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block AZALEA_PLANKS = register("azalea_planks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block AZALEA_STAIRS = registerStair("azalea_stairs", AZALEA_PLANKS);
    Block AZALEA_SLAB = registerSlab("azalea_slab", AZALEA_PLANKS);
    Block AZALEA_MOSAIC = registerSubBlock("azalea_mosaic", AZALEA_PLANKS);
    Block AZALEA_MOSAIC_STAIRS = registerStair("azalea_mosaic_stairs", AZALEA_MOSAIC);
    Block AZALEA_MOSAIC_SLAB = registerSlab("azalea_mosaic_slab", AZALEA_MOSAIC);
    Block AZALEA_BOARDS = register("azalea_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
    );
    Block AZALEA_TRIM = register("azalea_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS)
    );
    Block AZALEA_FENCE = registerFence("azalea_fence", AZALEA_PLANKS);
    Block AZALEA_FENCE_GATE = registerFenceGate("azalea_fence_gate", EWoodTypes.AZALEA, AZALEA_PLANKS);
    Block AZALEA_DOOR = registerDoor("azalea_door", EBlockSets.AZALEA, AZALEA_PLANKS);
    Block AZALEA_TRAPDOOR = registerTrapdoor("azalea_trapdoor", EBlockSets.AZALEA, AZALEA_PLANKS);
    Block AZALEA_PRESSURE_PLATE = registerPressurePlate("azalea_pressure_plate", EBlockSets.AZALEA, AZALEA_PLANKS);
    Block AZALEA_BUTTON = registerButton("azalea_button", EBlockSets.AZALEA, AZALEA_PLANKS, 30);
    Block AZALEA_SIGN = registerSign("azalea_sign", EWoodTypes.AZALEA, AZALEA_PLANKS);
    Block AZALEA_WALL_SIGN = registerWallSign("azalea_wall_sign", EWoodTypes.AZALEA, AZALEA_PLANKS);
    Block AZALEA_HANGING_SIGN = registerCeilingHangingSign("azalea_hanging_sign", EWoodTypes.AZALEA, AZALEA_PLANKS);
    Block AZALEA_WALL_HANGING_SIGN = registerWallHangingSign("azalea_wall_hanging_sign", EWoodTypes.AZALEA, AZALEA_PLANKS);
    Block AZALEA_SHELF = register("azalea_shelf", ShelfBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(AZALEA_PLANKS).sound(SoundType.SHELF)
    );

    // Cedar
    Block CEDAR_LOG = register("cedar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_CEDAR_LOG = register("stripped_cedar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block CEDAR_WOOD = register("cedar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_CEDAR_WOOD = register("stripped_cedar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block CEDAR_PLANKS = register("cedar_planks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block CEDAR_STAIRS = registerStair("cedar_stairs", CEDAR_PLANKS);
    Block CEDAR_SLAB = registerSlab("cedar_slab", CEDAR_PLANKS);
    Block CEDAR_MOSAIC = registerSubBlock("cedar_mosaic", CEDAR_PLANKS);
    Block CEDAR_MOSAIC_STAIRS = registerStair("cedar_mosaic_stairs", CEDAR_MOSAIC);
    Block CEDAR_MOSAIC_SLAB = registerSlab("cedar_mosaic_slab", CEDAR_MOSAIC);
    Block CEDAR_BOARDS = register("cedar_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS)
    );
    Block CEDAR_TRIM = register("cedar_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS)
    );
    Block CEDAR_FENCE = registerFence("cedar_fence", CEDAR_PLANKS);
    Block CEDAR_FENCE_GATE = registerFenceGate("cedar_fence_gate", EWoodTypes.CEDAR, CEDAR_PLANKS);
    Block CEDAR_DOOR = registerDoor("cedar_door", EBlockSets.CEDAR, CEDAR_PLANKS);
    Block CEDAR_TRAPDOOR = registerTrapdoor("cedar_trapdoor", EBlockSets.CEDAR, CEDAR_PLANKS);
    Block CEDAR_PRESSURE_PLATE = registerPressurePlate("cedar_pressure_plate", EBlockSets.CEDAR, CEDAR_PLANKS);
    Block CEDAR_BUTTON = registerButton("cedar_button", EBlockSets.CEDAR, CEDAR_PLANKS, 30);
    Block CEDAR_SIGN = registerSign("cedar_sign", EWoodTypes.CEDAR, CEDAR_PLANKS);
    Block CEDAR_WALL_SIGN = registerWallSign("cedar_wall_sign", EWoodTypes.CEDAR, CEDAR_PLANKS);
    Block CEDAR_HANGING_SIGN = registerCeilingHangingSign("cedar_hanging_sign", EWoodTypes.CEDAR, CEDAR_PLANKS);
    Block CEDAR_WALL_HANGING_SIGN = registerWallHangingSign("cedar_wall_hanging_sign", EWoodTypes.CEDAR, CEDAR_PLANKS);
    Block CEDAR_SHELF = register("cedar_shelf", ShelfBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(CEDAR_PLANKS).sound(SoundType.SHELF)
    );

    Block CEDAR_SAPLING = registerSapling( "cedar_sapling", ETreeGrowers.CEDAR);
    Block POTTED_CEDAR_SAPLING = registerPottedSapling( "potted_cedar_sapling", CEDAR_SAPLING);
    Block CEDAR_LEAVES = register("cedar_leaves",
            p -> new TintedParticleLeavesBlock(0.01F, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.2F, 0.2F).sound(SoundType.GRASS).noOcclusion()
    );

    // Mahogany
    Block MAHOGANY_LOG = register("mahogany_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_MAHOGANY_LOG = register("stripped_mahogany_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block MAHOGANY_WOOD = register("mahogany_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block STRIPPED_MAHOGANY_WOOD = register("stripped_mahogany_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block MAHOGANY_PLANKS = register("mahogany_planks", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(2.0F, 2.0F).sound(SoundType.WOOD)
    );
    Block MAHOGANY_STAIRS = registerStair("mahogany_stairs", MAHOGANY_PLANKS);
    Block MAHOGANY_SLAB = registerSlab("mahogany_slab", MAHOGANY_PLANKS);
    Block MAHOGANY_MOSAIC = registerSubBlock("mahogany_mosaic", MAHOGANY_PLANKS);
    Block MAHOGANY_MOSAIC_STAIRS = registerStair("mahogany_mosaic_stairs", MAHOGANY_MOSAIC);
    Block MAHOGANY_MOSAIC_SLAB = registerSlab("mahogany_mosaic_slab", MAHOGANY_MOSAIC);
    Block MAHOGANY_BOARDS = register("mahogany_boards", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(MAHOGANY_PLANKS)
    );
    Block MAHOGANY_TRIM = register("mahogany_trim", HorizontalBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(MAHOGANY_PLANKS)
    );
    Block MAHOGANY_FENCE = registerFence("mahogany_fence", MAHOGANY_PLANKS);
    Block MAHOGANY_FENCE_GATE = registerFenceGate("mahogany_fence_gate", EWoodTypes.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_DOOR = registerDoor("mahogany_door", EBlockSets.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_TRAPDOOR = registerTrapdoor("mahogany_trapdoor", EBlockSets.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_PRESSURE_PLATE = registerPressurePlate("mahogany_pressure_plate", EBlockSets.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_BUTTON = registerButton("mahogany_button", EBlockSets.MAHOGANY, MAHOGANY_PLANKS, 30);
    Block MAHOGANY_SIGN = registerSign("mahogany_sign", EWoodTypes.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_WALL_SIGN = registerWallSign("mahogany_wall_sign", EWoodTypes.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_HANGING_SIGN = registerCeilingHangingSign("mahogany_hanging_sign", EWoodTypes.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_WALL_HANGING_SIGN = registerWallHangingSign("mahogany_wall_hanging_sign", EWoodTypes.MAHOGANY, MAHOGANY_PLANKS);
    Block MAHOGANY_SHELF = register("mahogany_shelf", ShelfBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(MAHOGANY_PLANKS).sound(SoundType.SHELF)
    );

    Block MAHOGANY_SAPLING = registerSapling( "mahogany_sapling", ETreeGrowers.MAHOGANY);
    Block POTTED_MAHOGANY_SAPLING = registerPottedSapling( "potted_mahogany_sapling", MAHOGANY_SAPLING);
    Block MAHOGANY_LEAVES = register("mahogany_leaves",
            p -> new TintedParticleLeavesBlock(0.01F, p), true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.2F, 0.2F).sound(SoundType.GRASS).noOcclusion()
    );

    // Arid Dirt
    ResourceKey<Block> ARID_DIRT_KEY = ResourceKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "arid_dirt")
    );
    Block ARID_DIRT = register("arid_dirt", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.ROOTED_DIRT)
    );
    Block ARID_GRASS_BLOCK = register("arid_grass_block", AridGrassBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(0.5F).sound(SoundType.ROOTED_DIRT).randomTicks()
    );
    Map<Block, Block> DIRT_TO_GRASS = Map.of(
            Blocks.DIRT, Blocks.GRASS_BLOCK,
            ARID_DIRT, ARID_GRASS_BLOCK
    );

    Block CATTAILS = register("cattails", AmphibiousDoublePlantBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.WET_GRASS).mapColor(MapColor.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)
    );

    // Cave Flora
    Block CAVE_ROOT = register("cave_root", CaveRootBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.GRASS).mapColor(MapColor.GLOW_LICHEN).offsetType(BlockBehaviour.OffsetType.XZ)
    );
    Block GLEAMSHROOM = register("gleamshroom", GleamshroomBlock::new, true,
            BlockBehaviour.Properties.of().noCollision().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.GRASS).mapColor(MapColor.GLOW_LICHEN).offsetType(BlockBehaviour.OffsetType.XZ)
                    .lightLevel(_ -> 5).emissiveRendering(Blocks::always)
    );


    // Wool Stairs & Slabs
    Block WHITE_WOOL_STAIRS = registerStair("white_wool_stairs", Blocks.WHITE_WOOL);
    Block WHITE_WOOL_SLAB = registerSlab("white_wool_slab", Blocks.WHITE_WOOL);
    Block LIGHT_GRAY_WOOL_STAIRS = registerStair("light_gray_wool_stairs", Blocks.LIGHT_GRAY_WOOL);
    Block LIGHT_GRAY_WOOL_SLAB = registerSlab("light_gray_wool_slab", Blocks.LIGHT_GRAY_WOOL);
    Block GRAY_WOOL_STAIRS = registerStair("gray_wool_stairs", Blocks.GRAY_WOOL);
    Block GRAY_WOOL_SLAB = registerSlab("gray_wool_slab", Blocks.GRAY_WOOL);
    Block BLACK_WOOL_STAIRS = registerStair("black_wool_stairs", Blocks.BLACK_WOOL);
    Block BLACK_WOOL_SLAB = registerSlab("black_wool_slab", Blocks.BLACK_WOOL);
    Block BROWN_WOOL_STAIRS = registerStair("brown_wool_stairs", Blocks.BROWN_WOOL);
    Block BROWN_WOOL_SLAB = registerSlab("brown_wool_slab", Blocks.BROWN_WOOL);
    Block RED_WOOL_STAIRS = registerStair("red_wool_stairs", Blocks.RED_WOOL);
    Block RED_WOOL_SLAB = registerSlab("red_wool_slab", Blocks.RED_WOOL);
    Block ORANGE_WOOL_STAIRS = registerStair("orange_wool_stairs", Blocks.ORANGE_WOOL);
    Block ORANGE_WOOL_SLAB = registerSlab("orange_wool_slab", Blocks.ORANGE_WOOL);
    Block YELLOW_WOOL_STAIRS = registerStair("yellow_wool_stairs", Blocks.YELLOW_WOOL);
    Block YELLOW_WOOL_SLAB = registerSlab("yellow_wool_slab", Blocks.YELLOW_WOOL);
    Block LIME_WOOL_STAIRS = registerStair("lime_wool_stairs", Blocks.LIME_WOOL);
    Block LIME_WOOL_SLAB = registerSlab("lime_wool_slab", Blocks.LIME_WOOL);
    Block GREEN_WOOL_STAIRS = registerStair("green_wool_stairs", Blocks.GREEN_WOOL);
    Block GREEN_WOOL_SLAB = registerSlab("green_wool_slab", Blocks.GREEN_WOOL);
    Block CYAN_WOOL_STAIRS = registerStair("cyan_wool_stairs", Blocks.CYAN_WOOL);
    Block CYAN_WOOL_SLAB = registerSlab("cyan_wool_slab", Blocks.CYAN_WOOL);
    Block LIGHT_BLUE_WOOL_STAIRS = registerStair("light_blue_wool_stairs", Blocks.LIGHT_BLUE_WOOL);
    Block LIGHT_BLUE_WOOL_SLAB = registerSlab("light_blue_wool_slab", Blocks.LIGHT_BLUE_WOOL);
    Block BLUE_WOOL_STAIRS = registerStair("blue_wool_stairs", Blocks.BLUE_WOOL);
    Block BLUE_WOOL_SLAB = registerSlab("blue_wool_slab", Blocks.BLUE_WOOL);
    Block PURPLE_WOOL_STAIRS = registerStair("purple_wool_stairs", Blocks.PURPLE_WOOL);
    Block PURPLE_WOOL_SLAB = registerSlab("purple_wool_slab", Blocks.PURPLE_WOOL);
    Block MAGENTA_WOOL_STAIRS = registerStair("magenta_wool_stairs", Blocks.MAGENTA_WOOL);
    Block MAGENTA_WOOL_SLAB = registerSlab("magenta_wool_slab", Blocks.MAGENTA_WOOL);
    Block PINK_WOOL_STAIRS = registerStair("pink_wool_stairs", Blocks.PINK_WOOL);
    Block PINK_WOOL_SLAB = registerSlab("pink_wool_slab", Blocks.PINK_WOOL);

    Block TERRACOTTA_STAIRS = registerStair("terracotta_stairs", Blocks.TERRACOTTA);
    Block TERRACOTTA_SLAB = registerSlab("terracotta_slab", Blocks.TERRACOTTA);
    Block WHITE_TERRACOTTA_STAIRS = registerStair("white_terracotta_stairs", Blocks.WHITE_TERRACOTTA);
    Block WHITE_TERRACOTTA_SLAB = registerSlab("white_terracotta_slab", Blocks.WHITE_TERRACOTTA);
    Block LIGHT_GRAY_TERRACOTTA_STAIRS = registerStair("light_gray_terracotta_stairs", Blocks.LIGHT_GRAY_TERRACOTTA);
    Block LIGHT_GRAY_TERRACOTTA_SLAB = registerSlab("light_gray_terracotta_slab", Blocks.LIGHT_GRAY_TERRACOTTA);
    Block GRAY_TERRACOTTA_STAIRS = registerStair("gray_terracotta_stairs", Blocks.GRAY_TERRACOTTA);
    Block GRAY_TERRACOTTA_SLAB = registerSlab("gray_terracotta_slab", Blocks.GRAY_TERRACOTTA);
    Block BLACK_TERRACOTTA_STAIRS = registerStair("black_terracotta_stairs", Blocks.BLACK_TERRACOTTA);
    Block BLACK_TERRACOTTA_SLAB = registerSlab("black_terracotta_slab", Blocks.BLACK_TERRACOTTA);
    Block BROWN_TERRACOTTA_STAIRS = registerStair("brown_terracotta_stairs", Blocks.BROWN_TERRACOTTA);
    Block BROWN_TERRACOTTA_SLAB = registerSlab("brown_terracotta_slab", Blocks.BROWN_TERRACOTTA);
    Block RED_TERRACOTTA_STAIRS = registerStair("red_terracotta_stairs", Blocks.RED_TERRACOTTA);
    Block RED_TERRACOTTA_SLAB = registerSlab("red_terracotta_slab", Blocks.RED_TERRACOTTA);
    Block ORANGE_TERRACOTTA_STAIRS = registerStair("orange_terracotta_stairs", Blocks.ORANGE_TERRACOTTA);
    Block ORANGE_TERRACOTTA_SLAB = registerSlab("orange_terracotta_slab", Blocks.ORANGE_TERRACOTTA);
    Block YELLOW_TERRACOTTA_STAIRS = registerStair("yellow_terracotta_stairs", Blocks.YELLOW_TERRACOTTA);
    Block YELLOW_TERRACOTTA_SLAB = registerSlab("yellow_terracotta_slab", Blocks.YELLOW_TERRACOTTA);
    Block LIME_TERRACOTTA_STAIRS = registerStair("lime_terracotta_stairs", Blocks.LIME_TERRACOTTA);
    Block LIME_TERRACOTTA_SLAB = registerSlab("lime_terracotta_slab", Blocks.LIME_TERRACOTTA);
    Block GREEN_TERRACOTTA_STAIRS = registerStair("green_terracotta_stairs", Blocks.GREEN_TERRACOTTA);
    Block GREEN_TERRACOTTA_SLAB = registerSlab("green_terracotta_slab", Blocks.GREEN_TERRACOTTA);
    Block CYAN_TERRACOTTA_STAIRS = registerStair("cyan_terracotta_stairs", Blocks.CYAN_TERRACOTTA);
    Block CYAN_TERRACOTTA_SLAB = registerSlab("cyan_terracotta_slab", Blocks.CYAN_TERRACOTTA);
    Block LIGHT_BLUE_TERRACOTTA_STAIRS = registerStair("light_blue_terracotta_stairs", Blocks.LIGHT_BLUE_TERRACOTTA);
    Block LIGHT_BLUE_TERRACOTTA_SLAB = registerSlab("light_blue_terracotta_slab", Blocks.LIGHT_BLUE_TERRACOTTA);
    Block BLUE_TERRACOTTA_STAIRS = registerStair("blue_terracotta_stairs", Blocks.BLUE_TERRACOTTA);
    Block BLUE_TERRACOTTA_SLAB = registerSlab("blue_terracotta_slab", Blocks.BLUE_TERRACOTTA);
    Block PURPLE_TERRACOTTA_STAIRS = registerStair("purple_terracotta_stairs", Blocks.PURPLE_TERRACOTTA);
    Block PURPLE_TERRACOTTA_SLAB = registerSlab("purple_terracotta_slab", Blocks.PURPLE_TERRACOTTA);
    Block MAGENTA_TERRACOTTA_STAIRS = registerStair("magenta_terracotta_stairs", Blocks.MAGENTA_TERRACOTTA);
    Block MAGENTA_TERRACOTTA_SLAB = registerSlab("magenta_terracotta_slab", Blocks.MAGENTA_TERRACOTTA);
    Block PINK_TERRACOTTA_STAIRS = registerStair("pink_terracotta_stairs", Blocks.PINK_TERRACOTTA);
    Block PINK_TERRACOTTA_SLAB = registerSlab("pink_terracotta_slab", Blocks.PINK_TERRACOTTA);

    Block TERRACOTTA_BRICKS = registerTerracottaBricks("terracotta_bricks", Blocks.TERRACOTTA);
    Block TERRACOTTA_BRICK_STAIRS = registerStair("terracotta_brick_stairs", TERRACOTTA_BRICKS);
    Block TERRACOTTA_BRICK_SLAB = registerSlab("terracotta_brick_slab", TERRACOTTA_BRICKS);
    Block WHITE_TERRACOTTA_BRICKS = registerTerracottaBricks("white_terracotta_bricks", Blocks.WHITE_TERRACOTTA);
    Block WHITE_TERRACOTTA_BRICK_STAIRS = registerStair("white_terracotta_brick_stairs", WHITE_TERRACOTTA_BRICKS);
    Block WHITE_TERRACOTTA_BRICK_SLAB = registerSlab("white_terracotta_brick_slab", WHITE_TERRACOTTA_BRICKS);
    Block LIGHT_GRAY_TERRACOTTA_BRICKS = registerTerracottaBricks("light_gray_terracotta_bricks", Blocks.LIGHT_GRAY_TERRACOTTA);
    Block LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = registerStair("light_gray_terracotta_brick_stairs", LIGHT_GRAY_TERRACOTTA_BRICKS);
    Block LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = registerSlab("light_gray_terracotta_brick_slab", LIGHT_GRAY_TERRACOTTA_BRICKS);
    Block GRAY_TERRACOTTA_BRICKS = registerTerracottaBricks("gray_terracotta_bricks", Blocks.GRAY_TERRACOTTA);
    Block GRAY_TERRACOTTA_BRICK_STAIRS = registerStair("gray_terracotta_brick_stairs", GRAY_TERRACOTTA_BRICKS);
    Block GRAY_TERRACOTTA_BRICK_SLAB = registerSlab("gray_terracotta_brick_slab", GRAY_TERRACOTTA_BRICKS);
    Block BLACK_TERRACOTTA_BRICKS = registerTerracottaBricks("black_terracotta_bricks", Blocks.BLACK_TERRACOTTA);
    Block BLACK_TERRACOTTA_BRICK_STAIRS = registerStair("black_terracotta_brick_stairs", BLACK_TERRACOTTA_BRICKS);
    Block BLACK_TERRACOTTA_BRICK_SLAB = registerSlab("black_terracotta_brick_slab", BLACK_TERRACOTTA_BRICKS);
    Block BROWN_TERRACOTTA_BRICKS = registerTerracottaBricks("brown_terracotta_bricks", Blocks.BROWN_TERRACOTTA);
    Block BROWN_TERRACOTTA_BRICK_STAIRS = registerStair("brown_terracotta_brick_stairs", BROWN_TERRACOTTA_BRICKS);
    Block BROWN_TERRACOTTA_BRICK_SLAB = registerSlab("brown_terracotta_brick_slab", BROWN_TERRACOTTA_BRICKS);
    Block RED_TERRACOTTA_BRICKS = registerTerracottaBricks("red_terracotta_bricks", Blocks.RED_TERRACOTTA);
    Block RED_TERRACOTTA_BRICK_STAIRS = registerStair("red_terracotta_brick_stairs", RED_TERRACOTTA_BRICKS);
    Block RED_TERRACOTTA_BRICK_SLAB = registerSlab("red_terracotta_brick_slab", RED_TERRACOTTA_BRICKS);
    Block ORANGE_TERRACOTTA_BRICKS = registerTerracottaBricks("orange_terracotta_bricks", Blocks.ORANGE_TERRACOTTA);
    Block ORANGE_TERRACOTTA_BRICK_STAIRS = registerStair("orange_terracotta_brick_stairs", ORANGE_TERRACOTTA_BRICKS);
    Block ORANGE_TERRACOTTA_BRICK_SLAB = registerSlab("orange_terracotta_brick_slab", ORANGE_TERRACOTTA_BRICKS);
    Block YELLOW_TERRACOTTA_BRICKS = registerTerracottaBricks("yellow_terracotta_bricks", Blocks.YELLOW_TERRACOTTA);
    Block YELLOW_TERRACOTTA_BRICK_STAIRS = registerStair("yellow_terracotta_brick_stairs", YELLOW_TERRACOTTA_BRICKS);
    Block YELLOW_TERRACOTTA_BRICK_SLAB = registerSlab("yellow_terracotta_brick_slab", YELLOW_TERRACOTTA_BRICKS);
    Block LIME_TERRACOTTA_BRICKS = registerTerracottaBricks("lime_terracotta_bricks", Blocks.LIME_TERRACOTTA);
    Block LIME_TERRACOTTA_BRICK_STAIRS = registerStair("lime_terracotta_brick_stairs", LIME_TERRACOTTA_BRICKS);
    Block LIME_TERRACOTTA_BRICK_SLAB = registerSlab("lime_terracotta_brick_slab", LIME_TERRACOTTA_BRICKS);
    Block GREEN_TERRACOTTA_BRICKS = registerTerracottaBricks("green_terracotta_bricks", Blocks.GREEN_TERRACOTTA);
    Block GREEN_TERRACOTTA_BRICK_STAIRS = registerStair("green_terracotta_brick_stairs", GREEN_TERRACOTTA_BRICKS);
    Block GREEN_TERRACOTTA_BRICK_SLAB = registerSlab("green_terracotta_brick_slab", GREEN_TERRACOTTA_BRICKS);
    Block CYAN_TERRACOTTA_BRICKS = registerTerracottaBricks("cyan_terracotta_bricks", Blocks.CYAN_TERRACOTTA);
    Block CYAN_TERRACOTTA_BRICK_STAIRS = registerStair("cyan_terracotta_brick_stairs", CYAN_TERRACOTTA_BRICKS);
    Block CYAN_TERRACOTTA_BRICK_SLAB = registerSlab("cyan_terracotta_brick_slab", CYAN_TERRACOTTA_BRICKS);
    Block LIGHT_BLUE_TERRACOTTA_BRICKS = registerTerracottaBricks("light_blue_terracotta_bricks", Blocks.LIGHT_BLUE_TERRACOTTA);
    Block LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = registerStair("light_blue_terracotta_brick_stairs", LIGHT_BLUE_TERRACOTTA_BRICKS);
    Block LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = registerSlab("light_blue_terracotta_brick_slab", LIGHT_BLUE_TERRACOTTA_BRICKS);
    Block BLUE_TERRACOTTA_BRICKS = registerTerracottaBricks("blue_terracotta_bricks", Blocks.BLUE_TERRACOTTA);
    Block BLUE_TERRACOTTA_BRICK_STAIRS = registerStair("blue_terracotta_brick_stairs", BLUE_TERRACOTTA_BRICKS);
    Block BLUE_TERRACOTTA_BRICK_SLAB = registerSlab("blue_terracotta_brick_slab", BLUE_TERRACOTTA_BRICKS);
    Block PURPLE_TERRACOTTA_BRICKS = registerTerracottaBricks("purple_terracotta_bricks", Blocks.PURPLE_TERRACOTTA);
    Block PURPLE_TERRACOTTA_BRICK_STAIRS = registerStair("purple_terracotta_brick_stairs", PURPLE_TERRACOTTA_BRICKS);
    Block PURPLE_TERRACOTTA_BRICK_SLAB = registerSlab("purple_terracotta_brick_slab", PURPLE_TERRACOTTA_BRICKS);
    Block MAGENTA_TERRACOTTA_BRICKS = registerTerracottaBricks("magenta_terracotta_bricks", Blocks.MAGENTA_TERRACOTTA);
    Block MAGENTA_TERRACOTTA_BRICK_STAIRS = registerStair("magenta_terracotta_brick_stairs", MAGENTA_TERRACOTTA_BRICKS);
    Block MAGENTA_TERRACOTTA_BRICK_SLAB = registerSlab("magenta_terracotta_brick_slab", MAGENTA_TERRACOTTA_BRICKS);
    Block PINK_TERRACOTTA_BRICKS = registerTerracottaBricks("pink_terracotta_bricks", Blocks.PINK_TERRACOTTA);
    Block PINK_TERRACOTTA_BRICK_STAIRS = registerStair("pink_terracotta_brick_stairs", PINK_TERRACOTTA_BRICKS);
    Block PINK_TERRACOTTA_BRICK_SLAB = registerSlab("pink_terracotta_brick_slab", PINK_TERRACOTTA_BRICKS);

    Block TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("terracotta_brick_tiles", Blocks.TERRACOTTA);
    Block TERRACOTTA_BRICK_TILE_STAIRS = registerStair("terracotta_brick_tile_stairs", TERRACOTTA_BRICK_TILES);
    Block TERRACOTTA_BRICK_TILE_SLAB = registerSlab("terracotta_brick_tile_slab", TERRACOTTA_BRICK_TILES);
    Block WHITE_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("white_terracotta_brick_tiles", Blocks.WHITE_TERRACOTTA);
    Block WHITE_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("white_terracotta_brick_tile_stairs", WHITE_TERRACOTTA_BRICK_TILES);
    Block WHITE_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("white_terracotta_brick_tile_slab", WHITE_TERRACOTTA_BRICK_TILES);
    Block LIGHT_GRAY_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("light_gray_terracotta_brick_tiles", Blocks.LIGHT_GRAY_TERRACOTTA);
    Block LIGHT_GRAY_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("light_gray_terracotta_brick_tile_stairs", LIGHT_GRAY_TERRACOTTA_BRICK_TILES);
    Block LIGHT_GRAY_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("light_gray_terracotta_brick_tile_slab", LIGHT_GRAY_TERRACOTTA_BRICK_TILES);
    Block GRAY_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("gray_terracotta_brick_tiles", Blocks.GRAY_TERRACOTTA);
    Block GRAY_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("gray_terracotta_brick_tile_stairs", GRAY_TERRACOTTA_BRICK_TILES);
    Block GRAY_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("gray_terracotta_brick_tile_slab", GRAY_TERRACOTTA_BRICK_TILES);
    Block BLACK_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("black_terracotta_brick_tiles", Blocks.BLACK_TERRACOTTA);
    Block BLACK_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("black_terracotta_brick_tile_stairs", BLACK_TERRACOTTA_BRICK_TILES);
    Block BLACK_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("black_terracotta_brick_tile_slab", BLACK_TERRACOTTA_BRICK_TILES);
    Block BROWN_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("brown_terracotta_brick_tiles", Blocks.BROWN_TERRACOTTA);
    Block BROWN_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("brown_terracotta_brick_tile_stairs", BROWN_TERRACOTTA_BRICK_TILES);
    Block BROWN_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("brown_terracotta_brick_tile_slab", BROWN_TERRACOTTA_BRICK_TILES);
    Block RED_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("red_terracotta_brick_tiles", Blocks.RED_TERRACOTTA);
    Block RED_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("red_terracotta_brick_tile_stairs", RED_TERRACOTTA_BRICK_TILES);
    Block RED_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("red_terracotta_brick_tile_slab", RED_TERRACOTTA_BRICK_TILES);
    Block ORANGE_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("orange_terracotta_brick_tiles", Blocks.ORANGE_TERRACOTTA);
    Block ORANGE_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("orange_terracotta_brick_tile_stairs", ORANGE_TERRACOTTA_BRICK_TILES);
    Block ORANGE_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("orange_terracotta_brick_tile_slab", ORANGE_TERRACOTTA_BRICK_TILES);
    Block YELLOW_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("yellow_terracotta_brick_tiles", Blocks.YELLOW_TERRACOTTA);
    Block YELLOW_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("yellow_terracotta_brick_tile_stairs", YELLOW_TERRACOTTA_BRICK_TILES);
    Block YELLOW_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("yellow_terracotta_brick_tile_slab", YELLOW_TERRACOTTA_BRICK_TILES);
    Block LIME_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("lime_terracotta_brick_tiles", Blocks.LIME_TERRACOTTA);
    Block LIME_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("lime_terracotta_brick_tile_stairs", LIME_TERRACOTTA_BRICK_TILES);
    Block LIME_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("lime_terracotta_brick_tile_slab", LIME_TERRACOTTA_BRICK_TILES);
    Block GREEN_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("green_terracotta_brick_tiles", Blocks.GREEN_TERRACOTTA);
    Block GREEN_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("green_terracotta_brick_tile_stairs", GREEN_TERRACOTTA_BRICK_TILES);
    Block GREEN_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("green_terracotta_brick_tile_slab", GREEN_TERRACOTTA_BRICK_TILES);
    Block CYAN_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("cyan_terracotta_brick_tiles", Blocks.CYAN_TERRACOTTA);
    Block CYAN_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("cyan_terracotta_brick_tile_stairs", CYAN_TERRACOTTA_BRICK_TILES);
    Block CYAN_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("cyan_terracotta_brick_tile_slab", CYAN_TERRACOTTA_BRICK_TILES);
    Block LIGHT_BLUE_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("light_blue_terracotta_brick_tiles", Blocks.LIGHT_BLUE_TERRACOTTA);
    Block LIGHT_BLUE_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("light_blue_terracotta_brick_tile_stairs", LIGHT_BLUE_TERRACOTTA_BRICK_TILES);
    Block LIGHT_BLUE_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("light_blue_terracotta_brick_tile_slab", LIGHT_BLUE_TERRACOTTA_BRICK_TILES);
    Block BLUE_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("blue_terracotta_brick_tiles", Blocks.BLUE_TERRACOTTA);
    Block BLUE_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("blue_terracotta_brick_tile_stairs", BLUE_TERRACOTTA_BRICK_TILES);
    Block BLUE_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("blue_terracotta_brick_tile_slab", BLUE_TERRACOTTA_BRICK_TILES);
    Block PURPLE_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("purple_terracotta_brick_tiles", Blocks.PURPLE_TERRACOTTA);
    Block PURPLE_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("purple_terracotta_brick_tile_stairs", PURPLE_TERRACOTTA_BRICK_TILES);
    Block PURPLE_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("purple_terracotta_brick_tile_slab", PURPLE_TERRACOTTA_BRICK_TILES);
    Block MAGENTA_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("magenta_terracotta_brick_tiles", Blocks.MAGENTA_TERRACOTTA);
    Block MAGENTA_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("magenta_terracotta_brick_tile_stairs", MAGENTA_TERRACOTTA_BRICK_TILES);
    Block MAGENTA_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("magenta_terracotta_brick_tile_slab", MAGENTA_TERRACOTTA_BRICK_TILES);
    Block PINK_TERRACOTTA_BRICK_TILES = registerTerracottaBrickTiles("pink_terracotta_brick_tiles", Blocks.PINK_TERRACOTTA);
    Block PINK_TERRACOTTA_BRICK_TILE_STAIRS = registerStair("pink_terracotta_brick_tile_stairs", PINK_TERRACOTTA_BRICK_TILES);
    Block PINK_TERRACOTTA_BRICK_TILE_SLAB = registerSlab("pink_terracotta_brick_tile_slab", PINK_TERRACOTTA_BRICK_TILES);

    Block WHITE_CONCRETE_STAIRS = registerStair("white_concrete_stairs", Blocks.WHITE_CONCRETE);
    Block WHITE_CONCRETE_SLAB = registerSlab("white_concrete_slab", Blocks.WHITE_CONCRETE);
    Block LIGHT_GRAY_CONCRETE_STAIRS = registerStair("light_gray_concrete_stairs", Blocks.LIGHT_GRAY_CONCRETE);
    Block LIGHT_GRAY_CONCRETE_SLAB = registerSlab("light_gray_concrete_slab", Blocks.LIGHT_GRAY_CONCRETE);
    Block GRAY_CONCRETE_STAIRS = registerStair("gray_concrete_stairs", Blocks.GRAY_CONCRETE);
    Block GRAY_CONCRETE_SLAB = registerSlab("gray_concrete_slab", Blocks.GRAY_CONCRETE);
    Block BLACK_CONCRETE_STAIRS = registerStair("black_concrete_stairs", Blocks.BLACK_CONCRETE);
    Block BLACK_CONCRETE_SLAB = registerSlab("black_concrete_slab", Blocks.BLACK_CONCRETE);
    Block BROWN_CONCRETE_STAIRS = registerStair("brown_concrete_stairs", Blocks.BROWN_CONCRETE);
    Block BROWN_CONCRETE_SLAB = registerSlab("brown_concrete_slab", Blocks.BROWN_CONCRETE);
    Block RED_CONCRETE_STAIRS = registerStair("red_concrete_stairs", Blocks.RED_CONCRETE);
    Block RED_CONCRETE_SLAB = registerSlab("red_concrete_slab", Blocks.RED_CONCRETE);
    Block ORANGE_CONCRETE_STAIRS = registerStair("orange_concrete_stairs", Blocks.ORANGE_CONCRETE);
    Block ORANGE_CONCRETE_SLAB = registerSlab("orange_concrete_slab", Blocks.ORANGE_CONCRETE);
    Block YELLOW_CONCRETE_STAIRS = registerStair("yellow_concrete_stairs", Blocks.YELLOW_CONCRETE);
    Block YELLOW_CONCRETE_SLAB = registerSlab("yellow_concrete_slab", Blocks.YELLOW_CONCRETE);
    Block LIME_CONCRETE_STAIRS = registerStair("lime_concrete_stairs", Blocks.LIME_CONCRETE);
    Block LIME_CONCRETE_SLAB = registerSlab("lime_concrete_slab", Blocks.LIME_CONCRETE);
    Block GREEN_CONCRETE_STAIRS = registerStair("green_concrete_stairs", Blocks.GREEN_CONCRETE);
    Block GREEN_CONCRETE_SLAB = registerSlab("green_concrete_slab", Blocks.GREEN_CONCRETE);
    Block CYAN_CONCRETE_STAIRS = registerStair("cyan_concrete_stairs", Blocks.CYAN_CONCRETE);
    Block CYAN_CONCRETE_SLAB = registerSlab("cyan_concrete_slab", Blocks.CYAN_CONCRETE);
    Block LIGHT_BLUE_CONCRETE_STAIRS = registerStair("light_blue_concrete_stairs", Blocks.LIGHT_BLUE_CONCRETE);
    Block LIGHT_BLUE_CONCRETE_SLAB = registerSlab("light_blue_concrete_slab", Blocks.LIGHT_BLUE_CONCRETE);
    Block BLUE_CONCRETE_STAIRS = registerStair("blue_concrete_stairs", Blocks.BLUE_CONCRETE);
    Block BLUE_CONCRETE_SLAB = registerSlab("blue_concrete_slab", Blocks.BLUE_CONCRETE);
    Block PURPLE_CONCRETE_STAIRS = registerStair("purple_concrete_stairs", Blocks.PURPLE_CONCRETE);
    Block PURPLE_CONCRETE_SLAB = registerSlab("purple_concrete_slab", Blocks.PURPLE_CONCRETE);
    Block MAGENTA_CONCRETE_STAIRS = registerStair("magenta_concrete_stairs", Blocks.MAGENTA_CONCRETE);
    Block MAGENTA_CONCRETE_SLAB = registerSlab("magenta_concrete_slab", Blocks.MAGENTA_CONCRETE);
    Block PINK_CONCRETE_STAIRS = registerStair("pink_concrete_stairs", Blocks.PINK_CONCRETE);
    Block PINK_CONCRETE_SLAB = registerSlab("pink_concrete_slab", Blocks.PINK_CONCRETE);

    Block BEACHSTONE = register("beachstone", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(1.5F, 1.0F).sound(SoundType.DRIPSTONE_BLOCK)
    );
    Block BEACHSTONE_STAIRS = registerStair("beachstone_stairs", BEACHSTONE);
    Block BEACHSTONE_SLAB = registerSlab("beachstone_slab", BEACHSTONE);
    Block BEACHSTONE_WALL = registerWall("beachstone_wall", BEACHSTONE);
    Block POLISHED_BEACHSTONE = registerSubBlock("polished_beachstone", BEACHSTONE);
    Block POLISHED_BEACHSTONE_STAIRS = registerStair("polished_beachstone_stairs", POLISHED_BEACHSTONE);
    Block POLISHED_BEACHSTONE_SLAB = registerSlab("polished_beachstone_slab", POLISHED_BEACHSTONE);
    Block POLISHED_BEACHSTONE_WALL = registerWall("polished_beachstone_wall", POLISHED_BEACHSTONE);

    Block BEACHSTONE_BRICKS = registerSubBlock("beachstone_bricks", BEACHSTONE);
    Block BEACHSTONE_BRICK_STAIRS = registerStair("beachstone_brick_stairs", BEACHSTONE_BRICKS);
    Block BEACHSTONE_BRICK_SLAB = registerSlab("beachstone_brick_slab", BEACHSTONE_BRICKS);
    Block BEACHSTONE_BRICK_WALL = registerWall("beachstone_brick_wall", BEACHSTONE_BRICKS);
    Block CHISELED_BEACHSTONE = registerSubBlock("chiseled_beachstone", BEACHSTONE_BRICKS);

    Block LIMESTONE = register("limestone", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(1.5F, 1.0F).sound(ESounds.SHALE)
    );
    Block LIMESTONE_STAIRS = registerStair("limestone_stairs", LIMESTONE);
    Block LIMESTONE_SLAB = registerSlab("limestone_slab", LIMESTONE);
    Block LIMESTONE_WALL = registerWall("limestone_wall", LIMESTONE);
    Block CUT_LIMESTONE = register("cut_limestone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(LIMESTONE).sound(ESounds.SHALE_TILES)
    );
    Block CUT_LIMESTONE_STAIRS = registerStair("cut_limestone_stairs", CUT_LIMESTONE);
    Block CUT_LIMESTONE_SLAB = registerSlab("cut_limestone_slab", CUT_LIMESTONE);
    Block CUT_LIMESTONE_WALL = registerWall("cut_limestone_wall", CUT_LIMESTONE);

    Block ROCKWEED_BASALT = register("rockweed_basalt", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_BASALT).sound(ESounds.ROCKWEED_BASALT)
    );
    Block BASALT_VENT = register("basalt_vent", BasaltVentBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).lightLevel(state -> state.getValue(BasaltVentBlock.ACTIVE) ? 3 : 0)
    );

    Block PINK_SAND = register("pink_sand", p -> new SandBlock(new ColorRGBA(0xFFECCFBD), p), true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.TERRACOTTA_PINK)
    );
    Block PINK_SANDSTONE = register("pink_sandstone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).mapColor(MapColor.TERRACOTTA_PINK)
    );
    Block PINK_SANDSTONE_STAIRS = registerStair("pink_sandstone_stairs", PINK_SANDSTONE);
    Block PINK_SANDSTONE_SLAB = registerSlab("pink_sandstone_slab", PINK_SANDSTONE);
    Block PINK_SANDSTONE_WALL = registerWall("pink_sandstone_wall", PINK_SANDSTONE);

    Block SMOOTH_PINK_SANDSTONE = registerSubBlock("smooth_pink_sandstone", PINK_SANDSTONE);
    Block SMOOTH_PINK_SANDSTONE_STAIRS = registerStair("smooth_pink_sandstone_stairs", SMOOTH_PINK_SANDSTONE);
    Block SMOOTH_PINK_SANDSTONE_SLAB = registerSlab("smooth_pink_sandstone_slab", SMOOTH_PINK_SANDSTONE);
    Block SMOOTH_PINK_SANDSTONE_WALL = registerWall("smooth_pink_sandstone_wall", SMOOTH_PINK_SANDSTONE);

    Block CUT_PINK_SANDSTONE = registerSubBlock("cut_pink_sandstone", PINK_SANDSTONE);
    Block CUT_PINK_SANDSTONE_STAIRS = registerStair("cut_pink_sandstone_stairs", CUT_PINK_SANDSTONE);
    Block CUT_PINK_SANDSTONE_SLAB = registerSlab("cut_pink_sandstone_slab", CUT_PINK_SANDSTONE);
    Block CUT_PINK_SANDSTONE_WALL = registerWall("cut_pink_sandstone_wall", CUT_PINK_SANDSTONE);

    Block POLISHED_PINK_SANDSTONE = registerSubBlock("polished_pink_sandstone", PINK_SANDSTONE);
    Block POLISHED_PINK_SANDSTONE_STAIRS = registerStair("polished_pink_sandstone_stairs", POLISHED_PINK_SANDSTONE);
    Block POLISHED_PINK_SANDSTONE_SLAB = registerSlab("polished_pink_sandstone_slab", POLISHED_PINK_SANDSTONE);
    Block POLISHED_PINK_SANDSTONE_WALL = registerWall("polished_pink_sandstone_wall", POLISHED_PINK_SANDSTONE);

    Block CHISELED_PINK_SANDSTONE = registerSubBlock("chiseled_pink_sandstone", PINK_SANDSTONE);





    // Veilroot!
    Block VEILROOT_PORTAL = register("veilroot_portal", VeilrootPortalBlock::new, false,
            BlockBehaviour.Properties.of().noCollision().noOcclusion().strength(-1F).lightLevel((_) -> 5)
    );

    Block ASH = register("ash", p -> new SandBlock(new ColorRGBA(0xFF625A5C), p), true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_LIGHT_GRAY)
    );
    Block ASHSTONE = register("ashstone", Block::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_LIGHT_GRAY)
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

        // Register if it needs an item (ex: initialize piston, don't initialize moving piston)
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
    private static Block registerTerracottaBricks(final String name, Block block) {
        return register(name, Block::new, true, BlockBehaviour.Properties.ofFullCopy(block).sound(ESounds.STONE_BRICKS));
    }
    private static Block registerTerracottaBrickTiles(final String name, Block block) {
        return register(name, Block::new, true, BlockBehaviour.Properties.ofFullCopy(block).sound(ESounds.STONE_TILES));
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
        return register(name, p -> new FlowerPotBlock(block, p), false, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING));
    }

    // Sign Methods (HELP ME)
    private static Block registerSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new StandingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block).noCollision());
    }

    private static Block registerWallSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new WallSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block).noCollision());
    }

    private static Block registerCeilingHangingSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new CeilingHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block).noCollision());
    }

    private static Block registerWallHangingSign(final String name, WoodType woodType, Block block) {
        return register(name, p -> new WallHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(block));
    }


    // Initialize
    static void initialize() {}
}