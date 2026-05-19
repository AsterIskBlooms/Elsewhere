package team.lookingglass.elsewhere.datagen;

import net.minecraft.client.data.models.model.*;
import team.lookingglass.elsewhere.datagen.helpers.EBlockModelGenerators;
import team.lookingglass.elsewhere.registry.EBlocks;
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

        EBlockModelGenerators customGen = new EBlockModelGenerators(gen.blockStateOutput, gen.itemModelOutput, gen.modelOutput);



        // Quartz Brick Fill
        gen.family(Blocks.QUARTZ_BRICKS)
                .stairs(EBlocks.QUARTZ_BRICK_STAIRS)
                .slab(EBlocks.QUARTZ_BRICK_SLAB)
        ;

        // Amethyst-Obsidian Set
        gen.family(Blocks.AMETHYST_BLOCK)
                .stairs(EBlocks.AMETHYST_STAIRS)
                .slab(EBlocks.AMETHYST_SLAB)
        ;
        gen.family(EBlocks.AMETHYST_BRICKS)
                .stairs(EBlocks.AMETHYST_BRICK_STAIRS)
                .slab(EBlocks.AMETHYST_BRICK_SLAB)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_AMETHYST);
        gen.createAxisAlignedPillarBlock(EBlocks.AMETHYST_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.OBSIDIAN)
                .stairs(EBlocks.OBSIDIAN_STAIRS)
                .slab(EBlocks.OBSIDIAN_SLAB)
        ;
        gen.family(EBlocks.OBSIDIAN_BRICKS)
                .stairs(EBlocks.OBSIDIAN_BRICK_STAIRS)
                .slab(EBlocks.OBSIDIAN_BRICK_SLAB)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_OBSIDIAN, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.OBSIDIAN_PILLAR, TexturedModel.COLUMN);

        // Stone Fills
        gen.family(Blocks.STONE)
                .wall(EBlocks.STONE_WALL)
        ;
        gen.family(Blocks.SMOOTH_STONE)
                .stairs(EBlocks.SMOOTH_STONE_STAIRS)
                .wall(EBlocks.SMOOTH_STONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_STONE)
                .stairs(EBlocks.POLISHED_STONE_STAIRS)
                .slab(EBlocks.POLISHED_STONE_SLAB)
                .wall(EBlocks.POLISHED_STONE_WALL)
        ;
        gen.family(EBlocks.STONE_TILES)
                .stairs(EBlocks.STONE_TILE_STAIRS)
                .slab(EBlocks.STONE_TILE_SLAB)
                .wall(EBlocks.STONE_TILE_WALL)
        ;
        gen.family(EBlocks.MOSSY_STONE_TILES)
                .stairs(EBlocks.MOSSY_STONE_TILE_STAIRS)
                .slab(EBlocks.MOSSY_STONE_TILE_SLAB)
                .wall(EBlocks.MOSSY_STONE_TILE_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_STONE);
        gen.createAxisAlignedPillarBlock(EBlocks.STONE_PILLAR, TexturedModel.COLUMN);
        gen.family(Blocks.DEEPSLATE)
                .stairs(EBlocks.DEEPSLATE_STAIRS)
                .slab(EBlocks.DEEPSLATE_SLAB)
                .wall(EBlocks.DEEPSLATE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_DEEPSLATE)
                .stairs(EBlocks.SMOOTH_DEEPSLATE_STAIRS)
                .slab(EBlocks.SMOOTH_DEEPSLATE_SLAB)
                .wall(EBlocks.SMOOTH_DEEPSLATE_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_DEEPSLATE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.DEEPSLATE_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SMOOTH_TUFF)
                .stairs(EBlocks.SMOOTH_TUFF_STAIRS)
                .slab(EBlocks.SMOOTH_TUFF_SLAB)
                .wall(EBlocks.SMOOTH_TUFF_WALL)
        ;
        gen.createAxisAlignedPillarBlock(EBlocks.TUFF_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SMOOTH_BLACKSTONE)
                .stairs(EBlocks.SMOOTH_BLACKSTONE_STAIRS)
                .slab(EBlocks.SMOOTH_BLACKSTONE_SLAB)
                .wall(EBlocks.SMOOTH_BLACKSTONE_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);
        gen.createAxisAlignedPillarBlock(EBlocks.POLISHED_BLACKSTONE_PILLAR, TexturedModel.COLUMN);


        // Stone Sets
        gen.family(Blocks.POLISHED_ANDESITE)
                .wall(EBlocks.POLISHED_ANDESITE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_ANDESITE)
                .stairs(EBlocks.SMOOTH_ANDESITE_STAIRS)
                .slab(EBlocks.SMOOTH_ANDESITE_SLAB)
                .wall(EBlocks.SMOOTH_ANDESITE_WALL)
        ;
        gen.family(EBlocks.ANDESITE_BRICKS)
                .stairs(EBlocks.ANDESITE_BRICK_STAIRS)
                .slab(EBlocks.ANDESITE_BRICK_SLAB)
                .wall(EBlocks.ANDESITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_ANDESITE, TexturedModel.COLUMN);
        gen.createTrivialCube(EBlocks.CHISELED_ANDESITE_BRICKS);
        gen.createAxisAlignedPillarBlock(EBlocks.ANDESITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_GRANITE)
                .wall(EBlocks.POLISHED_GRANITE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_GRANITE)
                .stairs(EBlocks.SMOOTH_GRANITE_STAIRS)
                .slab(EBlocks.SMOOTH_GRANITE_SLAB)
                .wall(EBlocks.SMOOTH_GRANITE_WALL)
        ;
        gen.family(EBlocks.GRANITE_BRICKS)
                .stairs(EBlocks.GRANITE_BRICK_STAIRS)
                .slab(EBlocks.GRANITE_BRICK_SLAB)
                .wall(EBlocks.GRANITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_GRANITE, TexturedModel.COLUMN);
        gen.createTrivialBlock(EBlocks.CHISELED_GRANITE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.GRANITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_DIORITE)
                .wall(EBlocks.POLISHED_DIORITE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_DIORITE)
                .stairs(EBlocks.SMOOTH_DIORITE_STAIRS)
                .slab(EBlocks.SMOOTH_DIORITE_SLAB)
                .wall(EBlocks.SMOOTH_DIORITE_WALL)
        ;
        gen.family(EBlocks.DIORITE_BRICKS)
                .stairs(EBlocks.DIORITE_BRICK_STAIRS)
                .slab(EBlocks.DIORITE_BRICK_SLAB)
                .wall(EBlocks.DIORITE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_DIORITE);
        gen.createTrivialCube(EBlocks.CHISELED_DIORITE_BRICKS);
        gen.createAxisAlignedPillarBlock(EBlocks.DIORITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.CALCITE)
                .stairs(EBlocks.CALCITE_STAIRS)
                .slab(EBlocks.CALCITE_SLAB)
                .wall(EBlocks.CALCITE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_CALCITE)
                .stairs(EBlocks.SMOOTH_CALCITE_STAIRS)
                .slab(EBlocks.SMOOTH_CALCITE_SLAB)
                .wall(EBlocks.SMOOTH_CALCITE_WALL)
        ;
        gen.family(EBlocks.POLISHED_CALCITE)
                .stairs(EBlocks.POLISHED_CALCITE_STAIRS)
                .slab(EBlocks.POLISHED_CALCITE_SLAB)
                .wall(EBlocks.POLISHED_CALCITE_WALL)
        ;
        gen.family(EBlocks.CALCITE_BRICKS)
                .stairs(EBlocks.CALCITE_BRICK_STAIRS)
                .slab(EBlocks.CALCITE_BRICK_SLAB)
                .wall(EBlocks.CALCITE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_CALCITE);
        gen.createTrivialBlock(EBlocks.CHISELED_CALCITE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.CALCITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.DRIPSTONE_BLOCK)
                .stairs(EBlocks.DRIPSTONE_STAIRS)
                .slab(EBlocks.DRIPSTONE_SLAB)
                .wall(EBlocks.DRIPSTONE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_DRIPSTONE)
                .stairs(EBlocks.SMOOTH_DRIPSTONE_STAIRS)
                .slab(EBlocks.SMOOTH_DRIPSTONE_SLAB)
                .wall(EBlocks.SMOOTH_DRIPSTONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_DRIPSTONE)
                .stairs(EBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(EBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(EBlocks.POLISHED_DRIPSTONE_WALL)
        ;
        gen.family(EBlocks.DRIPSTONE_BRICKS)
                .stairs(EBlocks.DRIPSTONE_BRICK_STAIRS)
                .slab(EBlocks.DRIPSTONE_BRICK_SLAB)
                .wall(EBlocks.DRIPSTONE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_DRIPSTONE);
        gen.createTrivialCube(EBlocks.CHISELED_DRIPSTONE_BRICKS);
        gen.createAxisAlignedPillarBlock(EBlocks.DRIPSTONE_PILLAR, TexturedModel.COLUMN);


        // Sandstone Sets
        gen.family(EBlocks.POLISHED_SANDSTONE)
                .stairs(EBlocks.POLISHED_SANDSTONE_STAIRS)
                .slab(EBlocks.POLISHED_SANDSTONE_SLAB)
                .wall(EBlocks.POLISHED_SANDSTONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_RED_SANDSTONE)
                .stairs(EBlocks.POLISHED_RED_SANDSTONE_STAIRS)
                .slab(EBlocks.POLISHED_RED_SANDSTONE_SLAB)
                .wall(EBlocks.POLISHED_RED_SANDSTONE_WALL)
        ;

        customGen.columnFamily(EBlocks.SANDSTONE_BRICKS)
                .stairs(EBlocks.SANDSTONE_BRICK_STAIRS)
                .slab(EBlocks.SANDSTONE_BRICK_SLAB)
                .wall(EBlocks.SANDSTONE_BRICK_WALL)
        ;
        customGen.columnFamily(EBlocks.RED_SANDSTONE_BRICKS)
                .stairs(EBlocks.RED_SANDSTONE_BRICK_STAIRS)
                .slab(EBlocks.RED_SANDSTONE_BRICK_SLAB)
                .wall(EBlocks.RED_SANDSTONE_BRICK_WALL)
        ;
        gen.createTrivialBlock(Blocks.CHISELED_SANDSTONE, TexturedModel.COLUMN);
        gen.createTrivialBlock(Blocks.CHISELED_RED_SANDSTONE, TexturedModel.COLUMN);

        gen.family(Blocks.SMOOTH_SANDSTONE)
                .wall(EBlocks.SMOOTH_SANDSTONE_WALL)
        ;
        gen.family(Blocks.SMOOTH_RED_SANDSTONE)
                .wall(EBlocks.SMOOTH_RED_SANDSTONE_WALL)
        ;

        customGen.columnFamily(Blocks.CUT_SANDSTONE)
                .stairs(EBlocks.CUT_SANDSTONE_STAIRS)
                .slab(Blocks.CUT_SANDSTONE_SLAB)
                .wall(EBlocks.CUT_SANDSTONE_WALL)
        ;
        customGen.columnFamily(Blocks.CUT_RED_SANDSTONE)
                .stairs(EBlocks.CUT_RED_SANDSTONE_STAIRS)
                .slab(Blocks.CUT_RED_SANDSTONE_SLAB)
                .wall(EBlocks.CUT_RED_SANDSTONE_WALL)
        ;


        // Prismarine
        gen.family(EBlocks.SMOOTH_PRISMARINE)
                .stairs(EBlocks.SMOOTH_PRISMARINE_STAIRS)
                .slab(EBlocks.SMOOTH_PRISMARINE_SLAB)
                .wall(EBlocks.SMOOTH_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.POLISHED_PRISMARINE)
                .stairs(EBlocks.POLISHED_PRISMARINE_STAIRS)
                .slab(EBlocks.POLISHED_PRISMARINE_SLAB)
                .wall(EBlocks.POLISHED_PRISMARINE_WALL)
        ;
        gen.family(Blocks.PRISMARINE_BRICKS)
                .wall(EBlocks.PRISMARINE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_PRISMARINE, TexturedModel.COLUMN);
        gen.createTrivialBlock(EBlocks.CHISELED_PRISMARINE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.PRISMARINE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.DARK_PRISMARINE)
                .wall(EBlocks.DARK_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_DARK_PRISMARINE)
                .stairs(EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS)
                .slab(EBlocks.SMOOTH_DARK_PRISMARINE_SLAB)
                .wall(EBlocks.SMOOTH_DARK_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.POLISHED_DARK_PRISMARINE)
                .stairs(EBlocks.POLISHED_DARK_PRISMARINE_STAIRS)
                .slab(EBlocks.POLISHED_DARK_PRISMARINE_SLAB)
                .wall(EBlocks.POLISHED_DARK_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.DARK_PRISMARINE_BRICKS)
                .stairs(EBlocks.DARK_PRISMARINE_BRICK_STAIRS)
                .slab(EBlocks.DARK_PRISMARINE_BRICK_SLAB)
                .wall(EBlocks.DARK_PRISMARINE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_DARK_PRISMARINE, TexturedModel.COLUMN);
        gen.createTrivialBlock(EBlocks.CHISELED_DARK_PRISMARINE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.DARK_PRISMARINE_PILLAR, TexturedModel.COLUMN);

        customGen.axisAlignedPillarFamily(Blocks.BASALT, TexturedModel.COLUMN,
                EBlocks.BASALT_STAIRS,
                EBlocks.BASALT_SLAB,
                EBlocks.BASALT_WALL
        );
        gen.family(Blocks.SMOOTH_BASALT)
                .stairs(EBlocks.SMOOTH_BASALT_STAIRS)
                .slab(EBlocks.SMOOTH_BASALT_SLAB)
                .wall(EBlocks.SMOOTH_BASALT_WALL)
        ;
        customGen.axisAlignedPillarFamily(Blocks.POLISHED_BASALT, TexturedModel.COLUMN,
                EBlocks.POLISHED_BASALT_STAIRS,
                EBlocks.POLISHED_BASALT_SLAB,
                EBlocks.POLISHED_BASALT_WALL
        );
        gen.family(EBlocks.BASALT_BRICKS)
                .stairs(EBlocks.BASALT_BRICK_STAIRS)
                .slab(EBlocks.BASALT_BRICK_SLAB)
                .wall(EBlocks.BASALT_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_BASALT);
        gen.createTrivialBlock(EBlocks.CHISELED_BASALT_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.BASALT_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.END_STONE)
                .stairs(EBlocks.END_STONE_STAIRS)
                .slab(EBlocks.END_STONE_SLAB)
                .wall(EBlocks.END_STONE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_END_STONE)
                .stairs(EBlocks.SMOOTH_END_STONE_STAIRS)
                .slab(EBlocks.SMOOTH_END_STONE_SLAB)
                .wall(EBlocks.SMOOTH_END_STONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_END_STONE)
                .stairs(EBlocks.POLISHED_END_STONE_STAIRS)
                .slab(EBlocks.POLISHED_END_STONE_SLAB)
                .wall(EBlocks.POLISHED_END_STONE_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_END_STONE);
        gen.createTrivialBlock(EBlocks.CHISELED_END_STONE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.END_STONE_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SODALITE)
                .stairs(EBlocks.SODALITE_STAIRS)
                .slab(EBlocks.SODALITE_SLAB)
                .wall(EBlocks.SODALITE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_SODALITE)
                .stairs(EBlocks.SMOOTH_SODALITE_STAIRS)
                .slab(EBlocks.SMOOTH_SODALITE_SLAB)
                .wall(EBlocks.SMOOTH_SODALITE_WALL)
        ;
        gen.family(EBlocks.POLISHED_SODALITE)
                .stairs(EBlocks.POLISHED_SODALITE_STAIRS)
                .slab(EBlocks.POLISHED_SODALITE_SLAB)
                .wall(EBlocks.POLISHED_SODALITE_WALL)
        ;
        gen.family(EBlocks.SODALITE_BRICKS)
                .stairs(EBlocks.SODALITE_BRICK_STAIRS)
                .slab(EBlocks.SODALITE_BRICK_SLAB)
                .wall(EBlocks.SODALITE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_SODALITE);
        gen.createTrivialBlock(EBlocks.CHISELED_SODALITE_BRICKS, TexturedModel.CUBE_TOP_BOTTOM);
        gen.createAxisAlignedPillarBlock(EBlocks.SODALITE_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SHALE)
                .stairs(EBlocks.SHALE_STAIRS)
                .slab(EBlocks.SHALE_SLAB)
                .wall(EBlocks.SHALE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_SHALE)
                .stairs(EBlocks.SMOOTH_SHALE_STAIRS)
                .slab(EBlocks.SMOOTH_SHALE_SLAB)
                .wall(EBlocks.SMOOTH_SHALE_WALL)
        ;
        gen.family(EBlocks.POLISHED_SHALE)
                .stairs(EBlocks.POLISHED_SHALE_STAIRS)
                .slab(EBlocks.POLISHED_SHALE_SLAB)
                .wall(EBlocks.POLISHED_SHALE_WALL)
        ;
        gen.family(EBlocks.SHALE_BRICKS)
                .stairs(EBlocks.SHALE_BRICK_STAIRS)
                .slab(EBlocks.SHALE_BRICK_SLAB)
                .wall(EBlocks.SHALE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_SHALE);
        gen.createTrivialBlock(EBlocks.CHISELED_SHALE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.SHALE_PILLAR, TexturedModel.COLUMN);
        gen.family(EBlocks.COBBLESHALE)
                .stairs(EBlocks.COBBLESHALE_STAIRS)
                .slab(EBlocks.COBBLESHALE_SLAB)
                .wall(EBlocks.COBBLESHALE_WALL)
        ;
        gen.family(EBlocks.SHALE_TILES)
                .stairs(EBlocks.SHALE_TILE_STAIRS)
                .slab(EBlocks.SHALE_TILE_SLAB)
                .wall(EBlocks.SHALE_TILE_WALL)
        ;
        gen.createTrivialCube(EBlocks.SHALE_COAL_ORE);
        gen.createTrivialCube(EBlocks.SHALE_COPPER_ORE);
        gen.createTrivialCube(EBlocks.SHALE_IRON_ORE);
        gen.createTrivialCube(EBlocks.SHALE_GOLD_ORE);
        gen.createTrivialCube(EBlocks.SHALE_REDSTONE_ORE);
        gen.createTrivialCube(EBlocks.SHALE_DIAMOND_ORE);
        gen.createTrivialCube(EBlocks.SHALE_LAPIS_ORE);
        gen.createTrivialCube(EBlocks.SHALE_EMERALD_ORE);

        gen.createTrivialCube(EBlocks.SILVER_ORE);
        gen.createTrivialCube(EBlocks.SHALE_SILVER_ORE);
        gen.createTrivialCube(EBlocks.DEEPSLATE_SILVER_ORE);

        // Sulfur & Cinnabar
        gen.family(EBlocks.SULFUR)
                .stairs(EBlocks.SULFUR_STAIRS)
                .slab(EBlocks.SULFUR_SLAB)
                .wall(EBlocks.SULFUR_WALL)
        ;
        gen.family(EBlocks.SMOOTH_SULFUR)
                .stairs(EBlocks.SMOOTH_SULFUR_STAIRS)
                .slab(EBlocks.SMOOTH_SULFUR_SLAB)
                .wall(EBlocks.SMOOTH_SULFUR_WALL)
        ;
        gen.family(EBlocks.POLISHED_SULFUR)
                .stairs(EBlocks.POLISHED_SULFUR_STAIRS)
                .slab(EBlocks.POLISHED_SULFUR_SLAB)
                .wall(EBlocks.POLISHED_SULFUR_WALL)
        ;
        gen.family(EBlocks.SULFUR_BRICKS)
                .stairs(EBlocks.SULFUR_BRICK_STAIRS)
                .slab(EBlocks.SULFUR_BRICK_SLAB)
                .wall(EBlocks.SULFUR_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_SULFUR);
        gen.createTrivialBlock(EBlocks.CHISELED_SULFUR_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.SULFUR_PILLAR, TexturedModel.COLUMN);

        customGen.generateStalactite(gen, EBlocks.SULFUR_SPIKE);

        gen.createTrivialCube(EBlocks.POTENT_SULFUR);

        gen.family(EBlocks.CINNABAR)
                .stairs(EBlocks.CINNABAR_STAIRS)
                .slab(EBlocks.CINNABAR_SLAB)
                .wall(EBlocks.CINNABAR_WALL)
        ;
        gen.family(EBlocks.SMOOTH_CINNABAR)
                .stairs(EBlocks.SMOOTH_CINNABAR_STAIRS)
                .slab(EBlocks.SMOOTH_CINNABAR_SLAB)
                .wall(EBlocks.SMOOTH_CINNABAR_WALL)
        ;
        gen.family(EBlocks.POLISHED_CINNABAR)
                .stairs(EBlocks.POLISHED_CINNABAR_STAIRS)
                .slab(EBlocks.POLISHED_CINNABAR_SLAB)
                .wall(EBlocks.POLISHED_CINNABAR_WALL)
        ;
        gen.family(EBlocks.CINNABAR_BRICKS)
                .stairs(EBlocks.CINNABAR_BRICK_STAIRS)
                .slab(EBlocks.CINNABAR_BRICK_SLAB)
                .wall(EBlocks.CINNABAR_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_CINNABAR);
        gen.createTrivialBlock(EBlocks.CHISELED_CINNABAR_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.CINNABAR_PILLAR, TexturedModel.COLUMN);

        gen.createTrivialCube(EBlocks.CINNABAR_COAL_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_COPPER_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_IRON_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_GOLD_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_SILVER_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_REDSTONE_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_DIAMOND_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_LAPIS_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_EMERALD_ORE);

        // Netherrack
        gen.family(Blocks.NETHERRACK)
                .stairs(EBlocks.NETHERRACK_STAIRS)
                .slab(EBlocks.NETHERRACK_SLAB)
                .wall(EBlocks.NETHERRACK_WALL)
        ;
        gen.family(EBlocks.SMOOTH_NETHERRACK)
                .stairs(EBlocks.SMOOTH_NETHERRACK_STAIRS)
                .slab(EBlocks.SMOOTH_NETHERRACK_SLAB)
                .wall(EBlocks.SMOOTH_NETHERRACK_WALL)
        ;
        gen.family(EBlocks.POLISHED_NETHERRACK)
                .stairs(EBlocks.POLISHED_NETHERRACK_STAIRS)
                .slab(EBlocks.POLISHED_NETHERRACK_SLAB)
                .wall(EBlocks.POLISHED_NETHERRACK_WALL)
        ;
        gen.family(EBlocks.NETHERRACK_BRICKS)
                .stairs(EBlocks.NETHERRACK_BRICK_STAIRS)
                .slab(EBlocks.NETHERRACK_BRICK_SLAB)
                .wall(EBlocks.NETHERRACK_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_NETHERRACK);
        gen.createTrivialCube(EBlocks.CHISELED_NETHERRACK_BRICKS);
        gen.createAxisAlignedPillarBlock(EBlocks.NETHERRACK_PILLAR, TexturedModel.COLUMN);

        // Orpiment
        gen.family(EBlocks.ORPIMENT)
                .stairs(EBlocks.ORPIMENT_STAIRS)
                .slab(EBlocks.ORPIMENT_SLAB)
                .wall(EBlocks.ORPIMENT_WALL)
        ;
        gen.family(EBlocks.SMOOTH_ORPIMENT)
                .stairs(EBlocks.SMOOTH_ORPIMENT_STAIRS)
                .slab(EBlocks.SMOOTH_ORPIMENT_SLAB)
                .wall(EBlocks.SMOOTH_ORPIMENT_WALL)
        ;
        gen.family(EBlocks.POLISHED_ORPIMENT)
                .stairs(EBlocks.POLISHED_ORPIMENT_STAIRS)
                .slab(EBlocks.POLISHED_ORPIMENT_SLAB)
                .wall(EBlocks.POLISHED_ORPIMENT_WALL)
        ;
        gen.family(EBlocks.ORPIMENT_BRICKS)
                .stairs(EBlocks.ORPIMENT_BRICK_STAIRS)
                .slab(EBlocks.ORPIMENT_BRICK_SLAB)
                .wall(EBlocks.ORPIMENT_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_ORPIMENT);
        gen.createTrivialBlock(EBlocks.CHISELED_ORPIMENT_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.ORPIMENT_PILLAR, TexturedModel.COLUMN);

        // Purpur
        gen.createTrivialBlock(EBlocks.CHISELED_PURPUR, TexturedModel.COLUMN);

        customGen.generateStalactite(gen, EBlocks.ICICLE);


        // Wood Sets
        gen.family(EBlocks.OAK_MOSAIC)
                .stairs(EBlocks.OAK_MOSAIC_STAIRS)
                .slab(EBlocks.OAK_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.DARK_OAK_MOSAIC)
                .stairs(EBlocks.DARK_OAK_MOSAIC_STAIRS)
                .slab(EBlocks.DARK_OAK_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.PALE_OAK_MOSAIC)
                .stairs(EBlocks.PALE_OAK_MOSAIC_STAIRS)
                .slab(EBlocks.PALE_OAK_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.BIRCH_MOSAIC)
                .stairs(EBlocks.BIRCH_MOSAIC_STAIRS)
                .slab(EBlocks.BIRCH_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.SPRUCE_MOSAIC)
                .stairs(EBlocks.SPRUCE_MOSAIC_STAIRS)
                .slab(EBlocks.SPRUCE_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.JUNGLE_MOSAIC)
                .stairs(EBlocks.JUNGLE_MOSAIC_STAIRS)
                .slab(EBlocks.JUNGLE_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.ACACIA_MOSAIC)
                .stairs(EBlocks.ACACIA_MOSAIC_STAIRS)
                .slab(EBlocks.ACACIA_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.CHERRY_MOSAIC)
                .stairs(EBlocks.CHERRY_MOSAIC_STAIRS)
                .slab(EBlocks.CHERRY_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.MANGROVE_MOSAIC)
                .stairs(EBlocks.MANGROVE_MOSAIC_STAIRS)
                .slab(EBlocks.MANGROVE_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.CRIMSON_MOSAIC)
                .stairs(EBlocks.CRIMSON_MOSAIC_STAIRS)
                .slab(EBlocks.CRIMSON_MOSAIC_SLAB)
        ;
        gen.family(EBlocks.WARPED_MOSAIC)
                .stairs(EBlocks.WARPED_MOSAIC_STAIRS)
                .slab(EBlocks.WARPED_MOSAIC_SLAB)
        ;


        gen.createPlantWithDefaultItem(EBlocks.BLUEBONNET, EBlocks.POTTED_BLUEBONNET, BlockModelGenerators.PlantType.TINTED);

        gen.createTrivialBlock(EBlocks.ARID_DIRT, TexturedModel.COLUMN);


    }



    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(EBlocks.SULFUR_SPIKE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EBlocks.ICICLE.asItem(), ModelTemplates.FLAT_ITEM);

    }



    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
