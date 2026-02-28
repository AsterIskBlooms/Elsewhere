package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.registry.registryclasses.AmethystPillarBlock;
import net.asterisk.elsewhere.registry.registryclasses.AmethystSlabBlock;
import net.asterisk.elsewhere.registry.registryclasses.AmethystStairBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
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
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block OBSIDIAN_BRICK_STAIRS = registerStair("obsidian_brick_stairs", OBSIDIAN_BRICKS);
    Block OBSIDIAN_BRICK_SLAB = registerSlab("obsidian_brick_slab", OBSIDIAN_BRICKS);
    Block OBSIDIAN_PILLAR = register("obsidian_pillar", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 1200.0F).sound(SoundType.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
    );
    Block CHISELED_OBSIDIAN = registerSubBlock("chiseled_obsidian", OBSIDIAN_BRICKS);

































    public static <T extends SignBlock> T registerSignBlock(ResourceKey<Block> key, T block) {
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