package team.lookingglass.constructure.datagen;

import net.minecraft.client.data.models.model.*;
import team.lookingglass.constructure.registry.CBlockModelGenerators;
import team.lookingglass.constructure.registry.CBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {

        CBlockModelGenerators customGen = new CBlockModelGenerators(gen.blockStateOutput, gen.itemModelOutput, gen.modelOutput);







        // Quartz Brick Fill
        gen.family(Blocks.QUARTZ_BRICKS)
                .stairs(CBlocks.QUARTZ_BRICK_STAIRS)
                .slab(CBlocks.QUARTZ_BRICK_SLAB)
        ;

        // Amethyst-Obsidian Set
        gen.family(Blocks.AMETHYST_BLOCK)
                .stairs(CBlocks.AMETHYST_STAIRS)
                .slab(CBlocks.AMETHYST_SLAB)
        ;
        gen.family(CBlocks.AMETHYST_BRICKS)
                .stairs(CBlocks.AMETHYST_BRICK_STAIRS)
                .slab(CBlocks.AMETHYST_BRICK_SLAB)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_AMETHYST);
        gen.createAxisAlignedPillarBlock(CBlocks.AMETHYST_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.OBSIDIAN)
                .stairs(CBlocks.OBSIDIAN_STAIRS)
                .slab(CBlocks.OBSIDIAN_SLAB)
        ;
        gen.family(CBlocks.OBSIDIAN_BRICKS)
                .stairs(CBlocks.OBSIDIAN_BRICK_STAIRS)
                .slab(CBlocks.OBSIDIAN_BRICK_SLAB)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_OBSIDIAN, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.OBSIDIAN_PILLAR, TexturedModel.COLUMN);

        // Stone Fills
        gen.family(Blocks.STONE)
                .wall(CBlocks.STONE_WALL)
        ;
        gen.family(Blocks.SMOOTH_STONE)
                .stairs(CBlocks.SMOOTH_STONE_STAIRS)
                .wall(CBlocks.SMOOTH_STONE_WALL)
        ;
        gen.family(CBlocks.POLISHED_STONE)
                .stairs(CBlocks.POLISHED_STONE_STAIRS)
                .slab(CBlocks.POLISHED_STONE_SLAB)
                .wall(CBlocks.POLISHED_STONE_WALL)
        ;
        gen.family(CBlocks.STONE_TILES)
                .stairs(CBlocks.STONE_TILE_STAIRS)
                .slab(CBlocks.STONE_TILE_SLAB)
                .wall(CBlocks.STONE_TILE_WALL)
        ;
        gen.family(CBlocks.MOSSY_STONE_TILES)
                .stairs(CBlocks.MOSSY_STONE_TILE_STAIRS)
                .slab(CBlocks.MOSSY_STONE_TILE_SLAB)
                .wall(CBlocks.MOSSY_STONE_TILE_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_STONE);
        gen.createAxisAlignedPillarBlock(CBlocks.STONE_PILLAR, TexturedModel.COLUMN);
        gen.family(Blocks.DEEPSLATE)
                .stairs(CBlocks.DEEPSLATE_STAIRS)
                .slab(CBlocks.DEEPSLATE_SLAB)
                .wall(CBlocks.DEEPSLATE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_DEEPSLATE)
                .stairs(CBlocks.SMOOTH_DEEPSLATE_STAIRS)
                .slab(CBlocks.SMOOTH_DEEPSLATE_SLAB)
                .wall(CBlocks.SMOOTH_DEEPSLATE_WALL)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_DEEPSLATE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.DEEPSLATE_PILLAR, TexturedModel.COLUMN);

        gen.family(CBlocks.SMOOTH_TUFF)
                .stairs(CBlocks.SMOOTH_TUFF_STAIRS)
                .slab(CBlocks.SMOOTH_TUFF_SLAB)
                .wall(CBlocks.SMOOTH_TUFF_WALL)
        ;
        gen.createAxisAlignedPillarBlock(CBlocks.TUFF_PILLAR, TexturedModel.COLUMN);

        gen.family(CBlocks.SMOOTH_BLACKSTONE)
                .stairs(CBlocks.SMOOTH_BLACKSTONE_STAIRS)
                .slab(CBlocks.SMOOTH_BLACKSTONE_SLAB)
                .wall(CBlocks.SMOOTH_BLACKSTONE_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);
        gen.createAxisAlignedPillarBlock(CBlocks.POLISHED_BLACKSTONE_PILLAR, TexturedModel.COLUMN);


        // Stone Sets
        gen.family(Blocks.POLISHED_ANDESITE)
                .wall(CBlocks.POLISHED_ANDESITE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_ANDESITE)
                .stairs(CBlocks.SMOOTH_ANDESITE_STAIRS)
                .slab(CBlocks.SMOOTH_ANDESITE_SLAB)
                .wall(CBlocks.SMOOTH_ANDESITE_WALL)
        ;
        gen.family(CBlocks.ANDESITE_BRICKS)
                .stairs(CBlocks.ANDESITE_BRICK_STAIRS)
                .slab(CBlocks.ANDESITE_BRICK_SLAB)
                .wall(CBlocks.ANDESITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_ANDESITE, TexturedModel.COLUMN);
        gen.createTrivialCube(CBlocks.CHISELED_ANDESITE_BRICKS);
        gen.createAxisAlignedPillarBlock(CBlocks.ANDESITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_GRANITE)
                .wall(CBlocks.POLISHED_GRANITE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_GRANITE)
                .stairs(CBlocks.SMOOTH_GRANITE_STAIRS)
                .slab(CBlocks.SMOOTH_GRANITE_SLAB)
                .wall(CBlocks.SMOOTH_GRANITE_WALL)
        ;
        gen.family(CBlocks.GRANITE_BRICKS)
                .stairs(CBlocks.GRANITE_BRICK_STAIRS)
                .slab(CBlocks.GRANITE_BRICK_SLAB)
                .wall(CBlocks.GRANITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_GRANITE, TexturedModel.COLUMN);
        gen.createTrivialBlock(CBlocks.CHISELED_GRANITE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.GRANITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_DIORITE)
                .wall(CBlocks.POLISHED_DIORITE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_DIORITE)
                .stairs(CBlocks.SMOOTH_DIORITE_STAIRS)
                .slab(CBlocks.SMOOTH_DIORITE_SLAB)
                .wall(CBlocks.SMOOTH_DIORITE_WALL)
        ;
        gen.family(CBlocks.DIORITE_BRICKS)
                .stairs(CBlocks.DIORITE_BRICK_STAIRS)
                .slab(CBlocks.DIORITE_BRICK_SLAB)
                .wall(CBlocks.DIORITE_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_DIORITE);
        gen.createTrivialCube(CBlocks.CHISELED_DIORITE_BRICKS);
        gen.createAxisAlignedPillarBlock(CBlocks.DIORITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.CALCITE)
                .stairs(CBlocks.CALCITE_STAIRS)
                .slab(CBlocks.CALCITE_SLAB)
                .wall(CBlocks.CALCITE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_CALCITE)
                .stairs(CBlocks.SMOOTH_CALCITE_STAIRS)
                .slab(CBlocks.SMOOTH_CALCITE_SLAB)
                .wall(CBlocks.SMOOTH_CALCITE_WALL)
        ;
        gen.family(CBlocks.POLISHED_CALCITE)
                .stairs(CBlocks.POLISHED_CALCITE_STAIRS)
                .slab(CBlocks.POLISHED_CALCITE_SLAB)
                .wall(CBlocks.POLISHED_CALCITE_WALL)
        ;
        gen.family(CBlocks.CALCITE_BRICKS)
                .stairs(CBlocks.CALCITE_BRICK_STAIRS)
                .slab(CBlocks.CALCITE_BRICK_SLAB)
                .wall(CBlocks.CALCITE_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_CALCITE);
        gen.createTrivialBlock(CBlocks.CHISELED_CALCITE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.CALCITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.DRIPSTONE_BLOCK)
                .stairs(CBlocks.DRIPSTONE_STAIRS)
                .slab(CBlocks.DRIPSTONE_SLAB)
                .wall(CBlocks.DRIPSTONE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_DRIPSTONE)
                .stairs(CBlocks.SMOOTH_DRIPSTONE_STAIRS)
                .slab(CBlocks.SMOOTH_DRIPSTONE_SLAB)
                .wall(CBlocks.SMOOTH_DRIPSTONE_WALL)
        ;
        gen.family(CBlocks.POLISHED_DRIPSTONE)
                .stairs(CBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(CBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(CBlocks.POLISHED_DRIPSTONE_WALL)
        ;
        gen.family(CBlocks.DRIPSTONE_BRICKS)
                .stairs(CBlocks.DRIPSTONE_BRICK_STAIRS)
                .slab(CBlocks.DRIPSTONE_BRICK_SLAB)
                .wall(CBlocks.DRIPSTONE_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_DRIPSTONE);
        gen.createTrivialCube(CBlocks.CHISELED_DRIPSTONE_BRICKS);
        gen.createAxisAlignedPillarBlock(CBlocks.DRIPSTONE_PILLAR, TexturedModel.COLUMN);


        // Sandstone Sets
        gen.family(CBlocks.POLISHED_SANDSTONE)
                .stairs(CBlocks.POLISHED_SANDSTONE_STAIRS)
                .slab(CBlocks.POLISHED_SANDSTONE_SLAB)
                .wall(CBlocks.POLISHED_SANDSTONE_WALL)
        ;
        gen.family(CBlocks.POLISHED_RED_SANDSTONE)
                .stairs(CBlocks.POLISHED_RED_SANDSTONE_STAIRS)
                .slab(CBlocks.POLISHED_RED_SANDSTONE_SLAB)
                .wall(CBlocks.POLISHED_RED_SANDSTONE_WALL)
        ;

        customGen.columnFamily(CBlocks.SANDSTONE_BRICKS)
                .stairs(CBlocks.SANDSTONE_BRICK_STAIRS)
                .slab(CBlocks.SANDSTONE_BRICK_SLAB)
                .wall(CBlocks.SANDSTONE_BRICK_WALL)
        ;
        customGen.columnFamily(CBlocks.RED_SANDSTONE_BRICKS)
                .stairs(CBlocks.RED_SANDSTONE_BRICK_STAIRS)
                .slab(CBlocks.RED_SANDSTONE_BRICK_SLAB)
                .wall(CBlocks.RED_SANDSTONE_BRICK_WALL)
        ;
        gen.createTrivialBlock(Blocks.CHISELED_SANDSTONE, TexturedModel.COLUMN);
        gen.createTrivialBlock(Blocks.CHISELED_RED_SANDSTONE, TexturedModel.COLUMN);

        gen.family(Blocks.SMOOTH_SANDSTONE)
                .wall(CBlocks.SMOOTH_SANDSTONE_WALL)
        ;
        gen.family(Blocks.SMOOTH_RED_SANDSTONE)
                .wall(CBlocks.SMOOTH_RED_SANDSTONE_WALL)
        ;

        customGen.columnFamily(Blocks.CUT_SANDSTONE)
                .stairs(CBlocks.CUT_SANDSTONE_STAIRS)
                .slab(Blocks.CUT_SANDSTONE_SLAB)
                .wall(CBlocks.CUT_SANDSTONE_WALL)
        ;
        customGen.columnFamily(Blocks.CUT_RED_SANDSTONE)
                .stairs(CBlocks.CUT_RED_SANDSTONE_STAIRS)
                .slab(Blocks.CUT_RED_SANDSTONE_SLAB)
                .wall(CBlocks.CUT_RED_SANDSTONE_WALL)
        ;


        // Prismarine
        gen.family(CBlocks.SMOOTH_PRISMARINE)
                .stairs(CBlocks.SMOOTH_PRISMARINE_STAIRS)
                .slab(CBlocks.SMOOTH_PRISMARINE_SLAB)
                .wall(CBlocks.SMOOTH_PRISMARINE_WALL)
        ;
        gen.family(CBlocks.POLISHED_PRISMARINE)
                .stairs(CBlocks.POLISHED_PRISMARINE_STAIRS)
                .slab(CBlocks.POLISHED_PRISMARINE_SLAB)
                .wall(CBlocks.POLISHED_PRISMARINE_WALL)
        ;
        gen.family(Blocks.PRISMARINE_BRICKS)
                .wall(CBlocks.PRISMARINE_BRICK_WALL)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_PRISMARINE, TexturedModel.COLUMN);
        gen.createTrivialBlock(CBlocks.CHISELED_PRISMARINE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.PRISMARINE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.DARK_PRISMARINE)
                .wall(CBlocks.DARK_PRISMARINE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_DARK_PRISMARINE)
                .stairs(CBlocks.SMOOTH_DARK_PRISMARINE_STAIRS)
                .slab(CBlocks.SMOOTH_DARK_PRISMARINE_SLAB)
                .wall(CBlocks.SMOOTH_DARK_PRISMARINE_WALL)
        ;
        gen.family(CBlocks.POLISHED_DARK_PRISMARINE)
                .stairs(CBlocks.POLISHED_DARK_PRISMARINE_STAIRS)
                .slab(CBlocks.POLISHED_DARK_PRISMARINE_SLAB)
                .wall(CBlocks.POLISHED_DARK_PRISMARINE_WALL)
        ;
        gen.family(CBlocks.DARK_PRISMARINE_BRICKS)
                .stairs(CBlocks.DARK_PRISMARINE_BRICK_STAIRS)
                .slab(CBlocks.DARK_PRISMARINE_BRICK_SLAB)
                .wall(CBlocks.DARK_PRISMARINE_BRICK_WALL)
        ;
        gen.createTrivialBlock(CBlocks.CHISELED_DARK_PRISMARINE, TexturedModel.COLUMN);
        gen.createTrivialBlock(CBlocks.CHISELED_DARK_PRISMARINE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.DARK_PRISMARINE_PILLAR, TexturedModel.COLUMN);

        customGen.axisAlignedPillarFamily(Blocks.BASALT, TexturedModel.COLUMN,
                CBlocks.BASALT_STAIRS,
                CBlocks.BASALT_SLAB,
                CBlocks.BASALT_WALL
        );
        gen.family(Blocks.SMOOTH_BASALT)
                .stairs(CBlocks.SMOOTH_BASALT_STAIRS)
                .slab(CBlocks.SMOOTH_BASALT_SLAB)
                .wall(CBlocks.SMOOTH_BASALT_WALL)
        ;
        customGen.axisAlignedPillarFamily(Blocks.POLISHED_BASALT, TexturedModel.COLUMN,
                CBlocks.POLISHED_BASALT_STAIRS,
                CBlocks.POLISHED_BASALT_SLAB,
                CBlocks.POLISHED_BASALT_WALL
        );
        gen.family(CBlocks.BASALT_BRICKS)
                .stairs(CBlocks.BASALT_BRICK_STAIRS)
                .slab(CBlocks.BASALT_BRICK_SLAB)
                .wall(CBlocks.BASALT_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_BASALT);
        gen.createTrivialBlock(CBlocks.CHISELED_BASALT_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.BASALT_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.END_STONE)
                .stairs(CBlocks.END_STONE_STAIRS)
                .slab(CBlocks.END_STONE_SLAB)
                .wall(CBlocks.END_STONE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_END_STONE)
                .stairs(CBlocks.SMOOTH_END_STONE_STAIRS)
                .slab(CBlocks.SMOOTH_END_STONE_SLAB)
                .wall(CBlocks.SMOOTH_END_STONE_WALL)
        ;
        gen.family(CBlocks.POLISHED_END_STONE)
                .stairs(CBlocks.POLISHED_END_STONE_STAIRS)
                .slab(CBlocks.POLISHED_END_STONE_SLAB)
                .wall(CBlocks.POLISHED_END_STONE_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_END_STONE);
        gen.createTrivialBlock(CBlocks.CHISELED_END_STONE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.END_STONE_PILLAR, TexturedModel.COLUMN);

        gen.family(CBlocks.SODALITE)
                .stairs(CBlocks.SODALITE_STAIRS)
                .slab(CBlocks.SODALITE_SLAB)
                .wall(CBlocks.SODALITE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_SODALITE)
                .stairs(CBlocks.SMOOTH_SODALITE_STAIRS)
                .slab(CBlocks.SMOOTH_SODALITE_SLAB)
                .wall(CBlocks.SMOOTH_SODALITE_WALL)
        ;
        gen.family(CBlocks.POLISHED_SODALITE)
                .stairs(CBlocks.POLISHED_SODALITE_STAIRS)
                .slab(CBlocks.POLISHED_SODALITE_SLAB)
                .wall(CBlocks.POLISHED_SODALITE_WALL)
        ;
        gen.family(CBlocks.SODALITE_BRICKS)
                .stairs(CBlocks.SODALITE_BRICK_STAIRS)
                .slab(CBlocks.SODALITE_BRICK_SLAB)
                .wall(CBlocks.SODALITE_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_SODALITE);
        gen.createTrivialBlock(CBlocks.CHISELED_SODALITE_BRICKS, TexturedModel.CUBE_TOP_BOTTOM);
        gen.createAxisAlignedPillarBlock(CBlocks.SODALITE_PILLAR, TexturedModel.COLUMN);

        customGen.columnFamily(CBlocks.SHALE)
                .stairs(CBlocks.SHALE_STAIRS)
                .slab(CBlocks.SHALE_SLAB)
                .wall(CBlocks.SHALE_WALL)
        ;
        gen.family(CBlocks.SMOOTH_SHALE)
                .stairs(CBlocks.SMOOTH_SHALE_STAIRS)
                .slab(CBlocks.SMOOTH_SHALE_SLAB)
                .wall(CBlocks.SMOOTH_SHALE_WALL)
        ;
        gen.family(CBlocks.POLISHED_SHALE)
                .stairs(CBlocks.POLISHED_SHALE_STAIRS)
                .slab(CBlocks.POLISHED_SHALE_SLAB)
                .wall(CBlocks.POLISHED_SHALE_WALL)
        ;
        gen.family(CBlocks.SHALE_BRICKS)
                .stairs(CBlocks.SHALE_BRICK_STAIRS)
                .slab(CBlocks.SHALE_BRICK_SLAB)
                .wall(CBlocks.SHALE_BRICK_WALL)
        ;
        gen.createTrivialCube(CBlocks.CHISELED_SHALE);
        gen.createTrivialBlock(CBlocks.CHISELED_SHALE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(CBlocks.SHALE_PILLAR, TexturedModel.COLUMN);
        gen.family(CBlocks.COBBLESHALE)
                .stairs(CBlocks.COBBLESHALE_STAIRS)
                .slab(CBlocks.COBBLESHALE_SLAB)
                .wall(CBlocks.COBBLESHALE_WALL)
        ;
        gen.family(CBlocks.SHALE_TILES)
                .stairs(CBlocks.SHALE_TILE_STAIRS)
                .slab(CBlocks.SHALE_TILE_SLAB)
                .wall(CBlocks.SHALE_TILE_WALL)
        ;
        gen.createTrivialCube(CBlocks.SHALE_COAL_ORE);
        gen.createTrivialCube(CBlocks.SHALE_COPPER_ORE);
        gen.createTrivialCube(CBlocks.SHALE_IRON_ORE);
        gen.createTrivialCube(CBlocks.SHALE_GOLD_ORE);
        gen.createTrivialCube(CBlocks.SHALE_REDSTONE_ORE);
        gen.createTrivialCube(CBlocks.SHALE_DIAMOND_ORE);
        gen.createTrivialCube(CBlocks.SHALE_LAPIS_ORE);
        gen.createTrivialCube(CBlocks.SHALE_EMERALD_ORE);



        // Purpur
        gen.createTrivialBlock(CBlocks.CHISELED_PURPUR, TexturedModel.COLUMN);


        // Wood Sets
        gen.family(CBlocks.OAK_MOSAIC)
                .stairs(CBlocks.OAK_MOSAIC_STAIRS)
                .slab(CBlocks.OAK_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.DARK_OAK_MOSAIC)
                .stairs(CBlocks.DARK_OAK_MOSAIC_STAIRS)
                .slab(CBlocks.DARK_OAK_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.PALE_OAK_MOSAIC)
                .stairs(CBlocks.PALE_OAK_MOSAIC_STAIRS)
                .slab(CBlocks.PALE_OAK_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.BIRCH_MOSAIC)
                .stairs(CBlocks.BIRCH_MOSAIC_STAIRS)
                .slab(CBlocks.BIRCH_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.SPRUCE_MOSAIC)
                .stairs(CBlocks.SPRUCE_MOSAIC_STAIRS)
                .slab(CBlocks.SPRUCE_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.JUNGLE_MOSAIC)
                .stairs(CBlocks.JUNGLE_MOSAIC_STAIRS)
                .slab(CBlocks.JUNGLE_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.ACACIA_MOSAIC)
                .stairs(CBlocks.ACACIA_MOSAIC_STAIRS)
                .slab(CBlocks.ACACIA_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.CHERRY_MOSAIC)
                .stairs(CBlocks.CHERRY_MOSAIC_STAIRS)
                .slab(CBlocks.CHERRY_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.MANGROVE_MOSAIC)
                .stairs(CBlocks.MANGROVE_MOSAIC_STAIRS)
                .slab(CBlocks.MANGROVE_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.CRIMSON_MOSAIC)
                .stairs(CBlocks.CRIMSON_MOSAIC_STAIRS)
                .slab(CBlocks.CRIMSON_MOSAIC_SLAB)
        ;
        gen.family(CBlocks.WARPED_MOSAIC)
                .stairs(CBlocks.WARPED_MOSAIC_STAIRS)
                .slab(CBlocks.WARPED_MOSAIC_SLAB)
        ;


        gen.createPlantWithDefaultItem(CBlocks.BLUEBONNET, CBlocks.POTTED_BLUEBONNET, BlockModelGenerators.PlantType.TINTED);




    }



    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {


    }



    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
