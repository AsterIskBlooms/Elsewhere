package team.lookingglass.constructure.datagen;

import team.lookingglass.constructure.registry.CBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Blocks;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // Quartz Brick Fill
        blockStateModelGenerator.family(Blocks.QUARTZ_BRICKS)
                .stairs(CBlocks.QUARTZ_BRICK_STAIRS)
                .slab(CBlocks.QUARTZ_BRICK_SLAB)
        ;

        // Amethyst-Obsidian Set
        blockStateModelGenerator.family(Blocks.AMETHYST_BLOCK)
                .stairs(CBlocks.AMETHYST_STAIRS)
                .slab(CBlocks.AMETHYST_SLAB)
        ;
        blockStateModelGenerator.family(CBlocks.AMETHYST_BRICKS)
                .stairs(CBlocks.AMETHYST_BRICK_STAIRS)
                .slab(CBlocks.AMETHYST_BRICK_SLAB)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_AMETHYST);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.AMETHYST_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.OBSIDIAN)
                .stairs(CBlocks.OBSIDIAN_STAIRS)
                .slab(CBlocks.OBSIDIAN_SLAB)
        ;
        blockStateModelGenerator.family(CBlocks.OBSIDIAN_BRICKS)
                .stairs(CBlocks.OBSIDIAN_BRICK_STAIRS)
                .slab(CBlocks.OBSIDIAN_BRICK_SLAB)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_OBSIDIAN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.OBSIDIAN_PILLAR, TexturedModel.COLUMN);

        // Stone Fills
        blockStateModelGenerator.family(Blocks.STONE)
                .wall(CBlocks.STONE_WALL)
        ;
        blockStateModelGenerator.family(Blocks.SMOOTH_STONE)
                .stairs(CBlocks.SMOOTH_STONE_STAIRS)
                .wall(CBlocks.SMOOTH_STONE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.STONE_TILES)
                .stairs(CBlocks.STONE_TILE_STAIRS)
                .slab(CBlocks.STONE_TILE_SLAB)
                .wall(CBlocks.STONE_TILE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.MOSSY_STONE_TILES)
                .stairs(CBlocks.MOSSY_STONE_TILE_STAIRS)
                .slab(CBlocks.MOSSY_STONE_TILE_SLAB)
                .wall(CBlocks.MOSSY_STONE_TILE_WALL)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_STONE_BRICKS);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.STONE_PILLAR, TexturedModel.COLUMN);
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_DEEPSLATE_BRICKS, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.DEEPSLATE_PILLAR, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.TUFF_PILLAR, TexturedModel.COLUMN);


        // Stone Sets
        blockStateModelGenerator.family(Blocks.POLISHED_ANDESITE)
                .wall(CBlocks.POLISHED_ANDESITE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.ANDESITE_BRICKS)
                .stairs(CBlocks.ANDESITE_BRICK_STAIRS)
                .slab(CBlocks.ANDESITE_BRICK_SLAB)
                .wall(CBlocks.ANDESITE_BRICK_WALL)
        ;
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_ANDESITE, TexturedModel.COLUMN);
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_ANDESITE_BRICKS);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.ANDESITE_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.POLISHED_GRANITE)
                .wall(CBlocks.POLISHED_GRANITE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.GRANITE_BRICKS)
                .stairs(CBlocks.GRANITE_BRICK_STAIRS)
                .slab(CBlocks.GRANITE_BRICK_SLAB)
                .wall(CBlocks.GRANITE_BRICK_WALL)
        ;
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_GRANITE, TexturedModel.COLUMN);
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_GRANITE_BRICKS, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.GRANITE_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.POLISHED_DIORITE)
                .wall(CBlocks.POLISHED_DIORITE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.DIORITE_BRICKS)
                .stairs(CBlocks.DIORITE_BRICK_STAIRS)
                .slab(CBlocks.DIORITE_BRICK_SLAB)
                .wall(CBlocks.DIORITE_BRICK_WALL)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_DIORITE);
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_DIORITE_BRICKS);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.DIORITE_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.CALCITE)
                .stairs(CBlocks.CALCITE_STAIRS)
                .slab(CBlocks.CALCITE_SLAB)
                .wall(CBlocks.CALCITE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.POLISHED_CALCITE)
                .stairs(CBlocks.POLISHED_CALCITE_STAIRS)
                .slab(CBlocks.POLISHED_CALCITE_SLAB)
                .wall(CBlocks.POLISHED_CALCITE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.CALCITE_BRICKS)
                .stairs(CBlocks.CALCITE_BRICK_STAIRS)
                .slab(CBlocks.CALCITE_BRICK_SLAB)
                .wall(CBlocks.CALCITE_BRICK_WALL)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_CALCITE);
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_CALCITE_BRICKS, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.CALCITE_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.DRIPSTONE_BLOCK)
                .stairs(CBlocks.DRIPSTONE_STAIRS)
                .slab(CBlocks.DRIPSTONE_SLAB)
                .wall(CBlocks.DRIPSTONE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.POLISHED_DRIPSTONE)
                .stairs(CBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(CBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(CBlocks.POLISHED_DRIPSTONE_WALL)
        ;
        blockStateModelGenerator.family(CBlocks.DRIPSTONE_BRICKS)
                .stairs(CBlocks.DRIPSTONE_BRICK_STAIRS)
                .slab(CBlocks.DRIPSTONE_BRICK_SLAB)
                .wall(CBlocks.DRIPSTONE_BRICK_WALL)
        ;
        blockStateModelGenerator.createTrivialCube(CBlocks.CHISELED_DRIPSTONE);
        blockStateModelGenerator.createTrivialBlock(CBlocks.CHISELED_DRIPSTONE_BRICKS, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CBlocks.DRIPSTONE_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.CUT_SANDSTONE)
                .stairs(CBlocks.CUT_SANDSTONE_STAIRS)
        ;
        blockStateModelGenerator.family(Blocks.CUT_RED_SANDSTONE)
                .stairs(CBlocks.CUT_RED_SANDSTONE_STAIRS)
        ;
    }






    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {


    }



    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
