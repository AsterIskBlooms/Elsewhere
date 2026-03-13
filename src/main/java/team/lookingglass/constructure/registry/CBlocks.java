package team.lookingglass.constructure.registry;

import team.lookingglass.constructure.Constructure;
import team.lookingglass.constructure.registry.registryclasses.AmethystPillarBlock;
import team.lookingglass.constructure.registry.registryclasses.AmethystSlabBlock;
import team.lookingglass.constructure.registry.registryclasses.AmethystStairBlock;
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

import java.util.function.Function;

public interface CBlocks {


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
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block OBSIDIAN_BRICK_STAIRS = registerStair("obsidian_brick_stairs", OBSIDIAN_BRICKS);
    Block OBSIDIAN_BRICK_SLAB = registerSlab("obsidian_brick_slab", OBSIDIAN_BRICKS);
    Block OBSIDIAN_PILLAR = register("obsidian_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block CHISELED_OBSIDIAN = registerSubBlock("chiseled_obsidian", OBSIDIAN_BRICKS);




    // STOOOOOONE !!!
    Block STONE_WALL = registerWall("stone_wall", Blocks.STONE);
    Block SMOOTH_STONE_STAIRS = registerStair("smooth_stone_stairs", Blocks.SMOOTH_STONE);
    Block SMOOTH_STONE_WALL = registerWall("smooth_stone_wall", Blocks.SMOOTH_STONE);

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

    Block CHISELED_DEEPSLATE_BRICKS = registerSubBlock("chiseled_deepslate_bricks", Blocks.DEEPSLATE_BRICKS);
    Block DEEPSLATE_PILLAR = register("deepslate_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)
    );

    Block TUFF_PILLAR = register("tuff_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)
    );

    Block POLISHED_ANDESITE_WALL = registerWall("polished_andesite_wall", Blocks.POLISHED_ANDESITE);
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

    Block CALCITE_STAIRS = registerStair("calcite_stairs", Blocks.CALCITE);
    Block CALCITE_SLAB = registerSlab("calcite_slab", Blocks.CALCITE);
    Block CALCITE_WALL = registerWall("calcite_wall", Blocks.CALCITE);
    Block POLISHED_CALCITE = register("polished_calcite", Block::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(1.5F, 1.0F)
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
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5F, 1.0F)
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
    Block CUT_SANDSTONE_STAIRS = registerStair("cut_sandstone_stairs", Blocks.CUT_SANDSTONE);
    Block CUT_RED_SANDSTONE_STAIRS = registerStair("cut_red_sandstone_stairs", Blocks.CUT_RED_SANDSTONE);


























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
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(team.lookingglass.constructure.Constructure.MODID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Constructure.MODID, name));
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