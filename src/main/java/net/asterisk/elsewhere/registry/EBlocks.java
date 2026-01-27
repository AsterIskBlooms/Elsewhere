package net.asterisk.elsewhere.registry;

import com.mojang.serialization.MapCodec;
import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.worldgen.tree.ESaplingGenerators;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Function;

public interface EBlocks {

    // Gloam Blocks
    Block GLOAM = register("gloam", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.ROOTED_DIRT).strength(0.3F)
    );
    Block MOSSY_GLOAM = register("mossy_gloam", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.MOSS).strength(0.6F)
    );

    // Rootshale Blocks
    Block ROOTSHALE = register("rootshale", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F, 4.0F).requiresCorrectToolForDrops()
    );
    Block COBBLED_ROOTSHALE = register("cobbled_rootshale", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.5F, 4.0F).requiresCorrectToolForDrops()
    );
    Block ROOTSHALE_BRICKS = register("rootshale_bricks", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F).requiresCorrectToolForDrops()
    );
    Block ROOTSHALE_BRICK_STAIRS = registerStair("rootshale_brick_stairs", ROOTSHALE_BRICKS
    );
    Block ROOTSHALE_BRICK_SLAB = register("rootshale_brick_slab", SlabBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F).requiresCorrectToolForDrops()
    );
    Block ROOTSHALE_BRICK_WALL = register("rootshale_brick_wall", WallBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F).requiresCorrectToolForDrops()
    );

    // Bitterack Blocks
    Block BITTERACK = register("bitterack", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.CALCITE).strength(2.0F, 3.0F).requiresCorrectToolForDrops()
    );

    // Ores
    Block ROOTSHALE_XYLOITE_ORE = register("rootshale_xyloite_ore", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F, 4.0F).requiresCorrectToolForDrops()
    );
    Block ROOTSHALE_SYLVER_ORE = register("rootshale_sylver_ore", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1.0F, 4.0F).requiresCorrectToolForDrops()
    );
    Block BITTERACK_SYLVER_ORE = register("bitterack_sylver_ore", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(3.0F, 3.0F).requiresCorrectToolForDrops()
    );

    // Xyloite Blocks
    Block XYLOITE_BLOCK = register("xyloite_block", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3.0F, 12.0F).requiresCorrectToolForDrops()
    );
    Block CUT_XYLOITE = register("cut_xyloite", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2.0F).requiresCorrectToolForDrops()
    );
    Block CUT_XYLOITE_STAIRS = registerStair("cut_xyloite_stairs", CUT_XYLOITE
    );
    Block CUT_XYLOITE_SLAB = register("cut_xyloite_slab", SlabBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2.0F).requiresCorrectToolForDrops()
    );

    // Sylver Blocks
    Block SYLVER_BLOCK = register("sylver_block", Block::new, true,
            BlockBehaviour.Properties.of().strength(4.0F, 6.0F).sound(SoundType.METAL)
    );

    // Tautwood Blocks
    Block TAUTWOOD_SAPLING = registerSapling("tautwood_sapling", ESaplingGenerators.TAUTWOOD
    );
    Block TAUTWOOD_LEAVES = register("tautwood_leaves", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.AZALEA_LEAVES).strength(0.2F, 0.2F).ignitedByLava()
    );
    Block TAUTWOOD_LOG = register("tautwood_log", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTWOOD_WOOD = register("tautwood_wood", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_TAUTWOOD_LOG = register("stripped_tautwood_log", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_TAUTWOOD_WOOD = register("stripped_tautwood_wood", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTWOOD_PLANKS = register("tautwood_planks", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTWOOD_STAIRS = registerStair("tautwood_stairs", TAUTWOOD_PLANKS
    );
    Block TAUTWOOD_SLAB = register("tautwood_slab", SlabBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTWOOD_FENCE = register("tautwood_fence", FenceBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTWOOD_FENCE_GATE = registerFenceGate("tautwood_fence_gate", EWoodTypes.TAUTWOOD, TAUTWOOD_FENCE
    );
    Block TAUTWOOD_HANGING_SIGN = registerCeilingHangingSign("tautwood_hanging_sign", EWoodTypes.TAUTWOOD
    );
    Block TAUTWOOD_WALL_HANGING_SIGN = registerWallHangingSign("tautwood_wall_hanging_sign", EWoodTypes.TAUTWOOD
    );
    Block TAUTWOOD_SHELF = register("tautwood_shelf", ShelfBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );













    // Method
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

    private static Block registerStair(final String id, Block block) {
        return register(id, p -> new StairBlock(block.defaultBlockState(), p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static Block registerSapling(final String id, TreeGrower treeGrower) {
        return register(id, p -> new SaplingBlock(treeGrower, p), true, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    }

    private static Block registerFenceGate(final String id, WoodType woodType, Block block) {
        return register(id, p -> new FenceGateBlock(woodType, p), true, BlockBehaviour.Properties.ofFullCopy(block));
    }

    private static Block registerCeilingHangingSign(final String id, WoodType woodType) {
        return register(id, p -> new CeilingHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN));
    }

    private static Block registerWallHangingSign(final String id, WoodType woodType) {
        return register(id, p -> new WallHangingSignBlock(woodType, p), false, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN));
    }


    // Initialize
    static void initialize() {}
}