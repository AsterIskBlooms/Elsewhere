package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.worldgen.tree.ESaplingGenerators;
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
    Block ROOTSHALE_BRICK_STAIRS = registerStair("rootshale_brick_stairs", ROOTSHALE_BRICKS);
    Block ROOTSHALE_BRICK_SLAB = registerSlab("rootshale_brick_slab", ROOTSHALE_BRICKS);
    Block ROOTSHALE_BRICK_WALL = registerWall("rootshale_brick_wall", ROOTSHALE_BRICKS);

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
    Block CUT_XYLOITE_STAIRS = registerStair("cut_xyloite_stairs", CUT_XYLOITE);
    Block CUT_XYLOITE_SLAB = registerSlab("cut_xyloite_slab", CUT_XYLOITE);
    Block XYLOITE_DOOR = registerDoor("xyloite_door", EBlockSetTypes.XYLOITE, CUT_XYLOITE);
    Block XYLOITE_TRAPDOOR = registerTrapdoor("xyloite_trapdoor", EBlockSetTypes.XYLOITE, CUT_XYLOITE);

    // Sylver Blocks
    Block SYLVER_BLOCK = register("sylver_block", Block::new, true,
            BlockBehaviour.Properties.of().strength(4.0F, 6.0F).sound(SoundType.METAL)
    );

    // Tautolith Blocks
    Block TAUTOLITH_LEAVES = register("tautolith_leaves", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.AZALEA_LEAVES).strength(0.2F, 0.2F).ignitedByLava().noOcclusion()
    );
    Block TAUTOLITH_LOG = register("tautolith_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTOLITH_WOOD = register("tautolith_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTOLITH_PLANKS = register("tautolith_planks", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_TAUTOLITH_LOG = register("stripped_tautolith_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_TAUTOLITH_WOOD = register("stripped_tautolith_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block TAUTOLITH_STAIRS = registerStair("tautolith_stairs", TAUTOLITH_PLANKS);
    Block TAUTOLITH_SLAB = registerSlab("tautolith_slab", TAUTOLITH_PLANKS);
    Block TAUTOLITH_FENCE = registerFence("tautolith_fence", TAUTOLITH_PLANKS);
    Block TAUTOLITH_FENCE_GATE = registerFenceGate("tautolith_fence_gate", EWoodTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_DOOR = registerDoor("tautolith_door", EBlockSetTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_TRAPDOOR = registerTrapdoor("tautolith_trapdoor", EBlockSetTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_BUTTON = registerButton("tautolith_button", EBlockSetTypes.TAUTOLITH, TAUTOLITH_PLANKS, 30);
    Block TAUTOLITH_PRESSURE_PLATE = registerPressurePlate("tautolith_pressure_plate", EBlockSetTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_SHELF = registerShelf("tautolith_shelf", TAUTOLITH_PLANKS);
    Block TAUTOLITH_SAPLING = registerSapling("tautolith_sapling", ESaplingGenerators.TAUTOLITH);
    Block POTTED_TAUTOLITH_SAPLING = registerPottedSapling("potted_tautolith_sapling", TAUTOLITH_SAPLING);

    // Briar Blocks
    Block BRIAR_LEAVES = register("briar_leaves", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.AZALEA_LEAVES).strength(0.2F, 0.2F).ignitedByLava().noOcclusion()
    );
    Block BRIAR_LOG = register("briar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block BRIAR_WOOD = register("briar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block BRIAR_PLANKS = register("briar_planks", Block::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_BRIAR_LOG = register("stripped_briar_log", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block STRIPPED_BRIAR_WOOD = register("stripped_briar_wood", RotatedPillarBlock::new, true,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F, 3.0F).ignitedByLava()
    );
    Block BRIAR_STAIRS = registerStair("briar_stairs", BRIAR_PLANKS);
    Block BRIAR_SLAB = registerSlab("briar_slab", BRIAR_PLANKS);
    Block BRIAR_FENCE = registerFence("briar_fence", BRIAR_PLANKS);
    Block BRIAR_FENCE_GATE = registerFenceGate("briar_fence_gate", EWoodTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_DOOR = registerDoor("briar_door", EBlockSetTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_TRAPDOOR = registerTrapdoor("briar_trapdoor", EBlockSetTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_BUTTON = registerButton("briar_button", EBlockSetTypes.BRIAR, BRIAR_PLANKS, 30);
    Block BRIAR_PRESSURE_PLATE = registerPressurePlate("briar_pressure_plate", EBlockSetTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_SHELF = registerShelf("briar_shelf", BRIAR_PLANKS);
    Block BRIAR_SAPLING = registerSapling("briar_sapling", ESaplingGenerators.BRIAR);
    Block POTTED_BRIAR_SAPLING = registerPottedSapling("potted_briar_sapling", BRIAR_SAPLING);


    // Signs (DEAR GOD)
    Block TAUTOLITH_SIGN = registerSign("tautolith_sign", EWoodTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_WALL_SIGN = registerWallSign("tautolith_wall_sign", EWoodTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_HANGING_SIGN = registerCeilingHangingSign("tautolith_hanging_sign", EWoodTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block TAUTOLITH_WALL_HANGING_SIGN = registerWallHangingSign("tautolith_wall_hanging_sign", EWoodTypes.TAUTOLITH, TAUTOLITH_PLANKS);
    Block BRIAR_SIGN = registerSign("briar_sign", EWoodTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_WALL_SIGN = registerWallSign("briar_wall_sign", EWoodTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_HANGING_SIGN = registerCeilingHangingSign("briar_hanging_sign", EWoodTypes.BRIAR, BRIAR_PLANKS);
    Block BRIAR_WALL_HANGING_SIGN = registerWallHangingSign("briar_wall_hanging_sign", EWoodTypes.BRIAR, BRIAR_PLANKS);


    BlockFamily TAUTOLITH_FAMILY = new BlockFamily.Builder(TAUTOLITH_PLANKS)
            .stairs(EBlocks.TAUTOLITH_STAIRS)
            .slab(EBlocks.TAUTOLITH_SLAB)
            .fence(EBlocks.TAUTOLITH_FENCE)
            .fenceGate(EBlocks.TAUTOLITH_FENCE_GATE)
            .door(EBlocks.TAUTOLITH_DOOR)
            .trapdoor(EBlocks.TAUTOLITH_TRAPDOOR)
            .button(EBlocks.TAUTOLITH_BUTTON)
            .pressurePlate(EBlocks.TAUTOLITH_PRESSURE_PLATE)
            .sign(TAUTOLITH_SIGN, TAUTOLITH_WALL_SIGN)
            .getFamily();

    BlockFamily BRIAR_FAMILY = new BlockFamily.Builder(BRIAR_PLANKS)
            .stairs(EBlocks.BRIAR_STAIRS)
            .slab(EBlocks.BRIAR_SLAB)
            .fence(EBlocks.BRIAR_FENCE)
            .fenceGate(EBlocks.BRIAR_FENCE_GATE)
            .door(EBlocks.BRIAR_DOOR)
            .trapdoor(EBlocks.BRIAR_TRAPDOOR)
            .button(EBlocks.BRIAR_BUTTON)
            .pressurePlate(EBlocks.BRIAR_PRESSURE_PLATE)
            .sign(BRIAR_SIGN, BRIAR_WALL_SIGN)
            .getFamily();

    static void addValidBlocks() {
        BlockEntityType.SIGN.addValidBlock(TAUTOLITH_SIGN);
        BlockEntityType.SIGN.addValidBlock(TAUTOLITH_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(TAUTOLITH_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(TAUTOLITH_WALL_HANGING_SIGN);
        BlockEntityType.SHELF.addValidBlock(TAUTOLITH_SHELF);

        BlockEntityType.SIGN.addValidBlock(BRIAR_SIGN);
        BlockEntityType.SIGN.addValidBlock(BRIAR_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(BRIAR_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(BRIAR_WALL_HANGING_SIGN);
        BlockEntityType.SHELF.addValidBlock(BRIAR_SHELF);
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