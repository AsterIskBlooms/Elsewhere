package team.lookingglass.elsewhere.datagen.render;

import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAssets;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.datagen.helpers.EBlockModelGenerators;
import team.lookingglass.elsewhere.datagen.helpers.EItemModelGenerators;
import team.lookingglass.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import team.lookingglass.elsewhere.registry.EItems;
import team.lookingglass.elsewhere.registry.trim.EEquipmentAssets;

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
        gen.createTrivialBlock(EBlocks.CHISELED_DEEPSLATE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.DEEPSLATE_PILLAR, TexturedModel.COLUMN);

        gen.createAxisAlignedPillarBlock(EBlocks.TUFF_PILLAR, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.BLACKSTONE_PILLAR, TexturedModel.COLUMN);


        // Stone Sets
        gen.family(Blocks.POLISHED_ANDESITE)
                .wall(EBlocks.POLISHED_ANDESITE_WALL)
        ;
        gen.family(EBlocks.ANDESITE_BRICKS)
                .stairs(EBlocks.ANDESITE_BRICK_STAIRS)
                .slab(EBlocks.ANDESITE_BRICK_SLAB)
                .wall(EBlocks.ANDESITE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_ANDESITE);
        gen.createAxisAlignedPillarBlock(EBlocks.ANDESITE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_GRANITE)
                .wall(EBlocks.POLISHED_GRANITE_WALL)
        ;
        gen.family(EBlocks.GRANITE_BRICKS)
                .stairs(EBlocks.GRANITE_BRICK_STAIRS)
                .slab(EBlocks.GRANITE_BRICK_SLAB)
                .wall(EBlocks.GRANITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_GRANITE, TexturedModel.COLUMN);

        gen.family(Blocks.POLISHED_DIORITE)
                .wall(EBlocks.POLISHED_DIORITE_WALL)
        ;
        gen.family(EBlocks.DIORITE_BRICKS)
                .stairs(EBlocks.DIORITE_BRICK_STAIRS)
                .slab(EBlocks.DIORITE_BRICK_SLAB)
                .wall(EBlocks.DIORITE_BRICK_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_DIORITE, TexturedModel.COLUMN);

        gen.family(Blocks.CALCITE)
                .stairs(EBlocks.CALCITE_STAIRS)
                .slab(EBlocks.CALCITE_SLAB)
                .wall(EBlocks.CALCITE_WALL)
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
        gen.family(EBlocks.POLISHED_DRIPSTONE)
                .stairs(EBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(EBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(EBlocks.POLISHED_DRIPSTONE_WALL)
        ;
        gen.family(EBlocks.DRIPSTONE_TILES)
                .stairs(EBlocks.DRIPSTONE_TILE_STAIRS)
                .slab(EBlocks.DRIPSTONE_TILE_SLAB)
                .wall(EBlocks.DRIPSTONE_TILE_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_DRIPSTONE_TILES);
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
        gen.family(EBlocks.POLISHED_PRISMARINE)
                .stairs(EBlocks.POLISHED_PRISMARINE_STAIRS)
                .slab(EBlocks.POLISHED_PRISMARINE_SLAB)
                .wall(EBlocks.POLISHED_PRISMARINE_WALL)
        ;
        gen.family(Blocks.PRISMARINE_BRICKS)
                .wall(EBlocks.PRISMARINE_BRICK_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_PRISMARINE);
        gen.createAxisAlignedPillarBlock(EBlocks.PRISMARINE_PILLAR, TexturedModel.COLUMN);

        gen.family(Blocks.DARK_PRISMARINE)
                .wall(EBlocks.DARK_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.POLISHED_DARK_PRISMARINE)
                .stairs(EBlocks.POLISHED_DARK_PRISMARINE_STAIRS)
                .slab(EBlocks.POLISHED_DARK_PRISMARINE_SLAB)
                .wall(EBlocks.POLISHED_DARK_PRISMARINE_WALL)
        ;
        gen.family(EBlocks.DARK_PRISMARINE_SCALES)
                .stairs(EBlocks.DARK_PRISMARINE_SCALE_STAIRS)
                .slab(EBlocks.DARK_PRISMARINE_SCALE_SLAB)
                .wall(EBlocks.DARK_PRISMARINE_SCALE_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_DARK_PRISMARINE, TexturedModel.COLUMN);

        customGen.axisAlignedPillarFamily(Blocks.BASALT, TexturedModel.COLUMN)
                .slab(EBlocks.BASALT_SLAB)
        ;
        gen.family(Blocks.SMOOTH_BASALT)
                .stairs(EBlocks.SMOOTH_BASALT_STAIRS)
                .slab(EBlocks.SMOOTH_BASALT_SLAB)
                .wall(EBlocks.SMOOTH_BASALT_WALL)
        ;
        customGen.axisAlignedPillarFamily(Blocks.POLISHED_BASALT, TexturedModel.COLUMN)
                .slab(EBlocks.POLISHED_BASALT_SLAB)
        ;
        gen.family(EBlocks.POLISHED_SMOOTH_BASALT)
                .stairs(EBlocks.POLISHED_SMOOTH_BASALT_STAIRS)
                .slab(EBlocks.POLISHED_SMOOTH_BASALT_SLAB)
                .wall(EBlocks.POLISHED_SMOOTH_BASALT_WALL)
        ;
        gen.family(EBlocks.SMOOTH_BASALT_BRICKS)
                .stairs(EBlocks.SMOOTH_BASALT_BRICK_STAIRS)
                .slab(EBlocks.SMOOTH_BASALT_BRICK_SLAB)
                .wall(EBlocks.SMOOTH_BASALT_BRICK_WALL)
        ;
        gen.family(EBlocks.SMOOTH_BASALT_TILES)
                .stairs(EBlocks.SMOOTH_BASALT_TILE_STAIRS)
                .slab(EBlocks.SMOOTH_BASALT_TILE_SLAB)
                .wall(EBlocks.SMOOTH_BASALT_TILE_WALL)
        ;

        gen.family(Blocks.END_STONE)
                .stairs(EBlocks.END_STONE_STAIRS)
                .slab(EBlocks.END_STONE_SLAB)
                .wall(EBlocks.END_STONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_END_STONE)
                .stairs(EBlocks.POLISHED_END_STONE_STAIRS)
                .slab(EBlocks.POLISHED_END_STONE_SLAB)
                .wall(EBlocks.POLISHED_END_STONE_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_END_STONE);
        gen.createAxisAlignedPillarBlock(EBlocks.END_STONE_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SODALITE)
                .stairs(EBlocks.SODALITE_STAIRS)
                .slab(EBlocks.SODALITE_SLAB)
                .wall(EBlocks.SODALITE_WALL)
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
        gen.createTrivialBlock(EBlocks.CHISELED_SODALITE_BRICKS, TexturedModel.COLUMN);
        gen.createAxisAlignedPillarBlock(EBlocks.SODALITE_PILLAR, TexturedModel.COLUMN);

        gen.family(EBlocks.SHALE)
                .stairs(EBlocks.SHALE_STAIRS)
                .slab(EBlocks.SHALE_SLAB)
                .wall(EBlocks.SHALE_WALL)
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
        gen.createTrivialCube(EBlocks.CHISELED_SHALE_BRICKS);
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

        // Sulfur & Cinnabar
        gen.family(EBlocks.SULFUR)
                .stairs(EBlocks.SULFUR_STAIRS)
                .slab(EBlocks.SULFUR_SLAB)
                .wall(EBlocks.SULFUR_WALL)
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
        gen.createAxisAlignedPillarBlock(EBlocks.SULFUR_PILLAR, TexturedModel.COLUMN);

        customGen.generateStalactite(gen, EBlocks.SULFUR_SPIKE);

        gen.createTrivialCube(EBlocks.POTENT_SULFUR);

        gen.family(EBlocks.CINNABAR)
                .stairs(EBlocks.CINNABAR_STAIRS)
                .slab(EBlocks.CINNABAR_SLAB)
                .wall(EBlocks.CINNABAR_WALL)
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
        gen.createAxisAlignedPillarBlock(EBlocks.CINNABAR_PILLAR, TexturedModel.COLUMN);

        gen.createTrivialCube(EBlocks.CINNABAR_COAL_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_COPPER_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_IRON_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_GOLD_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_REDSTONE_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_DIAMOND_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_LAPIS_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_EMERALD_ORE);

        // Netherrack
        customGen.netherrackFamily(Blocks.NETHERRACK)
                .stairs(EBlocks.NETHERRACK_STAIRS)
                .slab(EBlocks.NETHERRACK_SLAB)
                .wall(EBlocks.NETHERRACK_WALL);
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
        gen.createAxisAlignedPillarBlock(EBlocks.ORPIMENT_PILLAR, TexturedModel.COLUMN);

        // Soul Sandstone
        customGen.cubeTopFamily(EBlocks.SOUL_SANDSTONE)
                .stairs(EBlocks.SOUL_SANDSTONE_STAIRS)
                .slab(EBlocks.SOUL_SANDSTONE_SLAB)
                .wall(EBlocks.SOUL_SANDSTONE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_SOUL_SANDSTONE)
                .stairs(EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS)
                .slab(EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB)
                .wall(EBlocks.SMOOTH_SOUL_SANDSTONE_WALL)
        ;
        customGen.columnFamily(EBlocks.CUT_SOUL_SANDSTONE)
                .stairs(EBlocks.CUT_SOUL_SANDSTONE_STAIRS)
                .slab(EBlocks.CUT_SOUL_SANDSTONE_SLAB)
                .wall(EBlocks.CUT_SOUL_SANDSTONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_SOUL_SANDSTONE)
                .stairs(EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS)
                .slab(EBlocks.POLISHED_SOUL_SANDSTONE_SLAB)
                .wall(EBlocks.POLISHED_SOUL_SANDSTONE_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_SOUL_SANDSTONE, TexturedModel.COLUMN);


        gen.createRotatedVariantBlock(EBlocks.PINK_SAND);
        customGen.cubeTopFamily(EBlocks.PINK_SANDSTONE)
                .stairs(EBlocks.PINK_SANDSTONE_STAIRS)
                .slab(EBlocks.PINK_SANDSTONE_SLAB)
                .wall(EBlocks.PINK_SANDSTONE_WALL)
        ;
        gen.family(EBlocks.SMOOTH_PINK_SANDSTONE)
                .stairs(EBlocks.SMOOTH_PINK_SANDSTONE_STAIRS)
                .slab(EBlocks.SMOOTH_PINK_SANDSTONE_SLAB)
                .wall(EBlocks.SMOOTH_PINK_SANDSTONE_WALL)
        ;
        customGen.columnFamily(EBlocks.CUT_PINK_SANDSTONE)
                .stairs(EBlocks.CUT_PINK_SANDSTONE_STAIRS)
                .slab(EBlocks.CUT_PINK_SANDSTONE_SLAB)
                .wall(EBlocks.CUT_PINK_SANDSTONE_WALL)
        ;
        gen.family(EBlocks.POLISHED_PINK_SANDSTONE)
                .stairs(EBlocks.POLISHED_PINK_SANDSTONE_STAIRS)
                .slab(EBlocks.POLISHED_PINK_SANDSTONE_SLAB)
                .wall(EBlocks.POLISHED_PINK_SANDSTONE_WALL)
        ;
        gen.createTrivialBlock(EBlocks.CHISELED_PINK_SANDSTONE, TexturedModel.COLUMN);


        // Beach Overhaul
        gen.createTrivialCube(EBlocks.BEACHSTONE);
        gen.createTrivialCube(EBlocks.ROCKWEED_BASALT);

        customGen.createSeagrassSandBlock();


        // Purpur
        gen.createTrivialBlock(EBlocks.CHISELED_PURPUR, TexturedModel.COLUMN);

        customGen.generateStalactite(gen, EBlocks.ICICLE);

        // Mud
        gen.family(Blocks.PACKED_MUD)
                .stairs(EBlocks.PACKED_MUD_STAIRS)
                .slab(EBlocks.PACKED_MUD_SLAB)
                .wall(EBlocks.PACKED_MUD_WALL)
        ;
        gen.createTrivialCube(EBlocks.CHISELED_MUD_BRICKS);
        gen.createRotatedPillarWithHorizontalVariant(EBlocks.MUD_BRICK_PILLAR, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);


        // Wood Sets
        gen.family(EBlocks.OAK_MOSAIC).stairs(EBlocks.OAK_MOSAIC_STAIRS).slab(EBlocks.OAK_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.OAK_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.OAK_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.DARK_OAK_MOSAIC).stairs(EBlocks.DARK_OAK_MOSAIC_STAIRS).slab(EBlocks.DARK_OAK_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.DARK_OAK_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.DARK_OAK_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.PALE_OAK_MOSAIC).stairs(EBlocks.PALE_OAK_MOSAIC_STAIRS).slab(EBlocks.PALE_OAK_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.PALE_OAK_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.PALE_OAK_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.BIRCH_MOSAIC).stairs(EBlocks.BIRCH_MOSAIC_STAIRS).slab(EBlocks.BIRCH_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.BIRCH_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.BIRCH_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.SPRUCE_MOSAIC).stairs(EBlocks.SPRUCE_MOSAIC_STAIRS).slab(EBlocks.SPRUCE_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.SPRUCE_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.SPRUCE_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.JUNGLE_MOSAIC).stairs(EBlocks.JUNGLE_MOSAIC_STAIRS).slab(EBlocks.JUNGLE_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.JUNGLE_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.JUNGLE_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.ACACIA_MOSAIC).stairs(EBlocks.ACACIA_MOSAIC_STAIRS).slab(EBlocks.ACACIA_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.ACACIA_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.ACACIA_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.CHERRY_MOSAIC).stairs(EBlocks.CHERRY_MOSAIC_STAIRS).slab(EBlocks.CHERRY_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.CHERRY_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.CHERRY_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.MANGROVE_MOSAIC).stairs(EBlocks.MANGROVE_MOSAIC_STAIRS).slab(EBlocks.MANGROVE_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.MANGROVE_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.MANGROVE_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.CRIMSON_MOSAIC).stairs(EBlocks.CRIMSON_MOSAIC_STAIRS).slab(EBlocks.CRIMSON_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.CRIMSON_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.CRIMSON_TRIM, TexturedModel.CUBE);

        gen.family(EBlocks.WARPED_MOSAIC).stairs(EBlocks.WARPED_MOSAIC_STAIRS).slab(EBlocks.WARPED_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.WARPED_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.WARPED_TRIM, TexturedModel.CUBE);

        gen.createRotatedPillarWithHorizontalVariant(EBlocks.BAMBOO_STEM, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
        gen.createRotatedPillarWithHorizontalVariant(EBlocks.STRIPPED_BAMBOO_STEM, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
        customGen.createWoodenBoards(EBlocks.BAMBOO_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.BAMBOO_TRIM, TexturedModel.CUBE);


        customGen.createPlantWithUniquePottedTexture(EBlocks.BLUEBONNET, EBlocks.POTTED_BLUEBONNET, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createPlantWithDefaultItem(EBlocks.RED_HIBISCUS, EBlocks.POTTED_RED_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.ORANGE_HIBISCUS, EBlocks.POTTED_ORANGE_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.YELLOW_HIBISCUS, EBlocks.POTTED_YELLOW_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.BLUE_HIBISCUS, EBlocks.POTTED_BLUE_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.PURPLE_HIBISCUS, EBlocks.POTTED_PURPLE_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.PINK_HIBISCUS, EBlocks.POTTED_PINK_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.WHITE_HIBISCUS, EBlocks.POTTED_WHITE_HIBISCUS, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createPlantWithDefaultItem(EBlocks.MAGENTA_CONEFLOWER, EBlocks.POTTED_MAGENTA_CONEFLOWER, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createPlantWithDefaultItem(EBlocks.YELLOW_CONEFLOWER, EBlocks.POTTED_YELLOW_CONEFLOWER, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createDoublePlantWithDefaultItem(EBlocks.IRONWEED, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createTrivialBlock(EBlocks.ARID_DIRT, TexturedModel.COLUMN);
        customGen.createAridGrassBlock();

        customGen.createTundraGrassBlock();
        gen.createCrossBlockWithDefaultItem(EBlocks.SHORT_RED_GRASS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createDoublePlantWithDefaultItem(EBlocks.TALL_RED_GRASS, BlockModelGenerators.PlantType.NOT_TINTED);
        gen.createCrossBlockWithDefaultItem(EBlocks.RED_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.woodProvider(EBlocks.POPLAR_LOG).logWithHorizontal(EBlocks.POPLAR_LOG).wood(EBlocks.POPLAR_WOOD);
        gen.woodProvider(EBlocks.STRIPPED_POPLAR_LOG).logWithHorizontal(EBlocks.STRIPPED_POPLAR_LOG).wood(EBlocks.STRIPPED_POPLAR_WOOD);
        gen.family(EBlocks.POPLAR_PLANKS)
                .stairs(EBlocks.POPLAR_STAIRS)
                .slab(EBlocks.POPLAR_SLAB)
                .fence(EBlocks.POPLAR_FENCE)
                .fenceGate(EBlocks.POPLAR_FENCE_GATE)
                .pressurePlate(EBlocks.POPLAR_PRESSURE_PLATE)
                .button(EBlocks.POPLAR_BUTTON)
        ;
        gen.createDoor(EBlocks.POPLAR_DOOR);
        gen.createOrientableTrapdoor(EBlocks.POPLAR_TRAPDOOR);
        gen.createParticleOnlyBlock(EBlocks.POPLAR_SIGN, EBlocks.POPLAR_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.POPLAR_WALL_SIGN, EBlocks.POPLAR_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.POPLAR_HANGING_SIGN, EBlocks.STRIPPED_POPLAR_LOG);
        gen.createParticleOnlyBlock(EBlocks.POPLAR_WALL_HANGING_SIGN, EBlocks.STRIPPED_POPLAR_LOG);
        gen.family(EBlocks.POPLAR_MOSAIC).stairs(EBlocks.POPLAR_MOSAIC_STAIRS).slab(EBlocks.POPLAR_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.POPLAR_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.POPLAR_TRIM, TexturedModel.CUBE);
        gen.createShelf(EBlocks.POPLAR_SHELF, EBlocks.STRIPPED_POPLAR_LOG);

        gen.createPlantWithDefaultItem(EBlocks.POPLAR_SAPLING, EBlocks.POTTED_POPLAR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createTrivialCube(EBlocks.RED_POPLAR_LEAVES);
        gen.createTrivialCube(EBlocks.ORANGE_POPLAR_LEAVES);
        gen.createTrivialCube(EBlocks.YELLOW_POPLAR_LEAVES);

        gen.createFullAndCarpetBlocks(EBlocks.RUSTY_MOSS_BLOCK, EBlocks.RUSTY_MOSS_CARPET);

        gen.woodProvider(EBlocks.AZALEA_LOG).logWithHorizontal(EBlocks.AZALEA_LOG).wood(EBlocks.AZALEA_WOOD);
        gen.woodProvider(EBlocks.STRIPPED_AZALEA_LOG).logWithHorizontal(EBlocks.STRIPPED_AZALEA_LOG).wood(EBlocks.STRIPPED_AZALEA_WOOD);
        gen.family(EBlocks.AZALEA_PLANKS)
                .stairs(EBlocks.AZALEA_STAIRS)
                .slab(EBlocks.AZALEA_SLAB)
                .fence(EBlocks.AZALEA_FENCE)
                .fenceGate(EBlocks.AZALEA_FENCE_GATE)
                .pressurePlate(EBlocks.AZALEA_PRESSURE_PLATE)
                .button(EBlocks.AZALEA_BUTTON)
        ;
        gen.createDoor(EBlocks.AZALEA_DOOR);
        gen.createOrientableTrapdoor(EBlocks.AZALEA_TRAPDOOR);
        gen.createParticleOnlyBlock(EBlocks.AZALEA_SIGN, EBlocks.AZALEA_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.AZALEA_WALL_SIGN, EBlocks.AZALEA_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.AZALEA_HANGING_SIGN, EBlocks.STRIPPED_AZALEA_LOG);
        gen.createParticleOnlyBlock(EBlocks.AZALEA_WALL_HANGING_SIGN, EBlocks.STRIPPED_AZALEA_LOG);
        gen.family(EBlocks.AZALEA_MOSAIC).stairs(EBlocks.AZALEA_MOSAIC_STAIRS).slab(EBlocks.AZALEA_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.AZALEA_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.AZALEA_TRIM, TexturedModel.CUBE);
        gen.createShelf(EBlocks.AZALEA_SHELF, EBlocks.STRIPPED_AZALEA_LOG);

        gen.woodProvider(EBlocks.CEDAR_LOG).logWithHorizontal(EBlocks.CEDAR_LOG).wood(EBlocks.CEDAR_WOOD);
        gen.woodProvider(EBlocks.STRIPPED_CEDAR_LOG).logWithHorizontal(EBlocks.STRIPPED_CEDAR_LOG).wood(EBlocks.STRIPPED_CEDAR_WOOD);
        gen.family(EBlocks.CEDAR_PLANKS)
                .stairs(EBlocks.CEDAR_STAIRS)
                .slab(EBlocks.CEDAR_SLAB)
                .fence(EBlocks.CEDAR_FENCE)
                .fenceGate(EBlocks.CEDAR_FENCE_GATE)
                .pressurePlate(EBlocks.CEDAR_PRESSURE_PLATE)
                .button(EBlocks.CEDAR_BUTTON)
        ;
        gen.createDoor(EBlocks.CEDAR_DOOR);
        gen.createOrientableTrapdoor(EBlocks.CEDAR_TRAPDOOR);
        gen.createParticleOnlyBlock(EBlocks.CEDAR_SIGN, EBlocks.CEDAR_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.CEDAR_WALL_SIGN, EBlocks.CEDAR_PLANKS);
        gen.createParticleOnlyBlock(EBlocks.CEDAR_HANGING_SIGN, EBlocks.STRIPPED_CEDAR_LOG);
        gen.createParticleOnlyBlock(EBlocks.CEDAR_WALL_HANGING_SIGN, EBlocks.STRIPPED_CEDAR_LOG);
        gen.family(EBlocks.CEDAR_MOSAIC).stairs(EBlocks.CEDAR_MOSAIC_STAIRS).slab(EBlocks.CEDAR_MOSAIC_SLAB);
        customGen.createWoodenBoards(EBlocks.CEDAR_BOARDS);
        customGen.createSimpleHorizontallyRotatedBlock(EBlocks.CEDAR_TRIM, TexturedModel.CUBE);
        gen.createShelf(EBlocks.CEDAR_SHELF, EBlocks.STRIPPED_CEDAR_LOG);
        gen.createTintedLeaves(EBlocks.CEDAR_LEAVES, TexturedModel.LEAVES, 0x65A65B);
        gen.createPlantWithDefaultItem(EBlocks.CEDAR_SAPLING, EBlocks.POTTED_CEDAR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        gen.createTrivialBlock(EBlocks.LATERITE, TexturedModel.COLUMN);

        gen.createTrivialCube(EBlocks.BEJEWELED_CALCITE);

        gen.createTrivialCube(EBlocks.TIN_ORE);
        gen.createTrivialCube(EBlocks.SHALE_TIN_ORE);
        gen.createTrivialCube(EBlocks.DEEPSLATE_TIN_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_TIN_ORE);
        gen.createTrivialCube(EBlocks.RAW_TIN_BLOCK);
        gen.createTrivialCube(EBlocks.TIN_BLOCK);

        gen.createTrivialCube(EBlocks.BRONZE_BLOCK);

        gen.createTrivialCube(EBlocks.SILVER_ORE);
        gen.createTrivialCube(EBlocks.SHALE_SILVER_ORE);
        gen.createTrivialCube(EBlocks.DEEPSLATE_SILVER_ORE);
        gen.createTrivialCube(EBlocks.CINNABAR_SILVER_ORE);
        gen.createTrivialCube(EBlocks.RAW_SILVER_BLOCK);
        gen.createTrivialCube(EBlocks.SILVER_BLOCK);

        gen.createTrivialCube(EBlocks.SOULSTEEL_BLOCK);

        gen.family(Blocks.WHITE_WOOL).stairs(EBlocks.WHITE_WOOL_STAIRS).slab(EBlocks.WHITE_WOOL_SLAB);
        gen.family(Blocks.LIGHT_GRAY_WOOL).stairs(EBlocks.LIGHT_GRAY_WOOL_STAIRS).slab(EBlocks.LIGHT_GRAY_WOOL_SLAB);
        gen.family(Blocks.GRAY_WOOL).stairs(EBlocks.GRAY_WOOL_STAIRS).slab(EBlocks.GRAY_WOOL_SLAB);
        gen.family(Blocks.BLACK_WOOL).stairs(EBlocks.BLACK_WOOL_STAIRS).slab(EBlocks.BLACK_WOOL_SLAB);
        gen.family(Blocks.BROWN_WOOL).stairs(EBlocks.BROWN_WOOL_STAIRS).slab(EBlocks.BROWN_WOOL_SLAB);
        gen.family(Blocks.RED_WOOL).stairs(EBlocks.RED_WOOL_STAIRS).slab(EBlocks.RED_WOOL_SLAB);
        gen.family(Blocks.ORANGE_WOOL).stairs(EBlocks.ORANGE_WOOL_STAIRS).slab(EBlocks.ORANGE_WOOL_SLAB);
        gen.family(Blocks.YELLOW_WOOL).stairs(EBlocks.YELLOW_WOOL_STAIRS).slab(EBlocks.YELLOW_WOOL_SLAB);
        gen.family(Blocks.LIME_WOOL).stairs(EBlocks.LIME_WOOL_STAIRS).slab(EBlocks.LIME_WOOL_SLAB);
        gen.family(Blocks.GREEN_WOOL).stairs(EBlocks.GREEN_WOOL_STAIRS).slab(EBlocks.GREEN_WOOL_SLAB);
        gen.family(Blocks.CYAN_WOOL).stairs(EBlocks.CYAN_WOOL_STAIRS).slab(EBlocks.CYAN_WOOL_SLAB);
        gen.family(Blocks.LIGHT_BLUE_WOOL).stairs(EBlocks.LIGHT_BLUE_WOOL_STAIRS).slab(EBlocks.LIGHT_BLUE_WOOL_SLAB);
        gen.family(Blocks.BLUE_WOOL).stairs(EBlocks.BLUE_WOOL_STAIRS).slab(EBlocks.BLUE_WOOL_SLAB);
        gen.family(Blocks.PURPLE_WOOL).stairs(EBlocks.PURPLE_WOOL_STAIRS).slab(EBlocks.PURPLE_WOOL_SLAB);
        gen.family(Blocks.MAGENTA_WOOL).stairs(EBlocks.MAGENTA_WOOL_STAIRS).slab(EBlocks.MAGENTA_WOOL_SLAB);
        gen.family(Blocks.PINK_WOOL).stairs(EBlocks.PINK_WOOL_STAIRS).slab(EBlocks.PINK_WOOL_SLAB);

        gen.family(Blocks.TERRACOTTA).stairs(EBlocks.TERRACOTTA_STAIRS).slab(EBlocks.TERRACOTTA_SLAB);
        gen.family(Blocks.WHITE_TERRACOTTA).stairs(EBlocks.WHITE_TERRACOTTA_STAIRS).slab(EBlocks.WHITE_TERRACOTTA_SLAB);
        gen.family(Blocks.LIGHT_GRAY_TERRACOTTA).stairs(EBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS).slab(EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        gen.family(Blocks.GRAY_TERRACOTTA).stairs(EBlocks.GRAY_TERRACOTTA_STAIRS).slab(EBlocks.GRAY_TERRACOTTA_SLAB);
        gen.family(Blocks.BLACK_TERRACOTTA).stairs(EBlocks.BLACK_TERRACOTTA_STAIRS).slab(EBlocks.BLACK_TERRACOTTA_SLAB);
        gen.family(Blocks.BROWN_TERRACOTTA).stairs(EBlocks.BROWN_TERRACOTTA_STAIRS).slab(EBlocks.BROWN_TERRACOTTA_SLAB);
        gen.family(Blocks.RED_TERRACOTTA).stairs(EBlocks.RED_TERRACOTTA_STAIRS).slab(EBlocks.RED_TERRACOTTA_SLAB);
        gen.family(Blocks.ORANGE_TERRACOTTA).stairs(EBlocks.ORANGE_TERRACOTTA_STAIRS).slab(EBlocks.ORANGE_TERRACOTTA_SLAB);
        gen.family(Blocks.YELLOW_TERRACOTTA).stairs(EBlocks.YELLOW_TERRACOTTA_STAIRS).slab(EBlocks.YELLOW_TERRACOTTA_SLAB);
        gen.family(Blocks.LIME_TERRACOTTA).stairs(EBlocks.LIME_TERRACOTTA_STAIRS).slab(EBlocks.LIME_TERRACOTTA_SLAB);
        gen.family(Blocks.GREEN_TERRACOTTA).stairs(EBlocks.GREEN_TERRACOTTA_STAIRS).slab(EBlocks.GREEN_TERRACOTTA_SLAB);
        gen.family(Blocks.CYAN_TERRACOTTA).stairs(EBlocks.CYAN_TERRACOTTA_STAIRS).slab(EBlocks.CYAN_TERRACOTTA_SLAB);
        gen.family(Blocks.LIGHT_BLUE_TERRACOTTA).stairs(EBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS).slab(EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        gen.family(Blocks.BLUE_TERRACOTTA).stairs(EBlocks.BLUE_TERRACOTTA_STAIRS).slab(EBlocks.BLUE_TERRACOTTA_SLAB);
        gen.family(Blocks.PURPLE_TERRACOTTA).stairs(EBlocks.PURPLE_TERRACOTTA_STAIRS).slab(EBlocks.PURPLE_TERRACOTTA_SLAB);
        gen.family(Blocks.MAGENTA_TERRACOTTA).stairs(EBlocks.MAGENTA_TERRACOTTA_STAIRS).slab(EBlocks.MAGENTA_TERRACOTTA_SLAB);
        gen.family(Blocks.PINK_TERRACOTTA).stairs(EBlocks.PINK_TERRACOTTA_STAIRS).slab(EBlocks.PINK_TERRACOTTA_SLAB);

        gen.family(EBlocks.TERRACOTTA_BRICKS).stairs(EBlocks.TERRACOTTA_BRICK_STAIRS).slab(EBlocks.TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.WHITE_TERRACOTTA_BRICKS).stairs(EBlocks.WHITE_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.WHITE_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS).stairs(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.GRAY_TERRACOTTA_BRICKS).stairs(EBlocks.GRAY_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.GRAY_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.BLACK_TERRACOTTA_BRICKS).stairs(EBlocks.BLACK_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.BLACK_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.BROWN_TERRACOTTA_BRICKS).stairs(EBlocks.BROWN_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.BROWN_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.RED_TERRACOTTA_BRICKS).stairs(EBlocks.RED_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.RED_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.ORANGE_TERRACOTTA_BRICKS).stairs(EBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.ORANGE_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.YELLOW_TERRACOTTA_BRICKS).stairs(EBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.YELLOW_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.LIME_TERRACOTTA_BRICKS).stairs(EBlocks.LIME_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.LIME_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.GREEN_TERRACOTTA_BRICKS).stairs(EBlocks.GREEN_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.GREEN_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.CYAN_TERRACOTTA_BRICKS).stairs(EBlocks.CYAN_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.CYAN_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS).stairs(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.BLUE_TERRACOTTA_BRICKS).stairs(EBlocks.BLUE_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.BLUE_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.PURPLE_TERRACOTTA_BRICKS).stairs(EBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.PURPLE_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.MAGENTA_TERRACOTTA_BRICKS).stairs(EBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB);
        gen.family(EBlocks.PINK_TERRACOTTA_BRICKS).stairs(EBlocks.PINK_TERRACOTTA_BRICK_STAIRS).slab(EBlocks.PINK_TERRACOTTA_BRICK_SLAB);

        gen.family(EBlocks.TERRACOTTA_BRICK_TILES).stairs(EBlocks.TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.WHITE_TERRACOTTA_BRICK_TILES).stairs(EBlocks.WHITE_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.WHITE_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILES).stairs(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.GRAY_TERRACOTTA_BRICK_TILES).stairs(EBlocks.GRAY_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.GRAY_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.BLACK_TERRACOTTA_BRICK_TILES).stairs(EBlocks.BLACK_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.BLACK_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.BROWN_TERRACOTTA_BRICK_TILES).stairs(EBlocks.BROWN_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.BROWN_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.RED_TERRACOTTA_BRICK_TILES).stairs(EBlocks.RED_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.RED_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.ORANGE_TERRACOTTA_BRICK_TILES).stairs(EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.YELLOW_TERRACOTTA_BRICK_TILES).stairs(EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.LIME_TERRACOTTA_BRICK_TILES).stairs(EBlocks.LIME_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.LIME_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.GREEN_TERRACOTTA_BRICK_TILES).stairs(EBlocks.GREEN_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.GREEN_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.CYAN_TERRACOTTA_BRICK_TILES).stairs(EBlocks.CYAN_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.CYAN_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILES).stairs(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.BLUE_TERRACOTTA_BRICK_TILES).stairs(EBlocks.BLUE_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.BLUE_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.PURPLE_TERRACOTTA_BRICK_TILES).stairs(EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.MAGENTA_TERRACOTTA_BRICK_TILES).stairs(EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_SLAB);
        gen.family(EBlocks.PINK_TERRACOTTA_BRICK_TILES).stairs(EBlocks.PINK_TERRACOTTA_BRICK_TILE_STAIRS).slab(EBlocks.PINK_TERRACOTTA_BRICK_TILE_SLAB);

        gen.family(Blocks.WHITE_CONCRETE).stairs(EBlocks.WHITE_CONCRETE_STAIRS).slab(EBlocks.WHITE_CONCRETE_SLAB);
        gen.family(Blocks.LIGHT_GRAY_CONCRETE).stairs(EBlocks.LIGHT_GRAY_CONCRETE_STAIRS).slab(EBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        gen.family(Blocks.GRAY_CONCRETE).stairs(EBlocks.GRAY_CONCRETE_STAIRS).slab(EBlocks.GRAY_CONCRETE_SLAB);
        gen.family(Blocks.BLACK_CONCRETE).stairs(EBlocks.BLACK_CONCRETE_STAIRS).slab(EBlocks.BLACK_CONCRETE_SLAB);
        gen.family(Blocks.BROWN_CONCRETE).stairs(EBlocks.BROWN_CONCRETE_STAIRS).slab(EBlocks.BROWN_CONCRETE_SLAB);
        gen.family(Blocks.RED_CONCRETE).stairs(EBlocks.RED_CONCRETE_STAIRS).slab(EBlocks.RED_CONCRETE_SLAB);
        gen.family(Blocks.ORANGE_CONCRETE).stairs(EBlocks.ORANGE_CONCRETE_STAIRS).slab(EBlocks.ORANGE_CONCRETE_SLAB);
        gen.family(Blocks.YELLOW_CONCRETE).stairs(EBlocks.YELLOW_CONCRETE_STAIRS).slab(EBlocks.YELLOW_CONCRETE_SLAB);
        gen.family(Blocks.LIME_CONCRETE).stairs(EBlocks.LIME_CONCRETE_STAIRS).slab(EBlocks.LIME_CONCRETE_SLAB);
        gen.family(Blocks.GREEN_CONCRETE).stairs(EBlocks.GREEN_CONCRETE_STAIRS).slab(EBlocks.GREEN_CONCRETE_SLAB);
        gen.family(Blocks.CYAN_CONCRETE).stairs(EBlocks.CYAN_CONCRETE_STAIRS).slab(EBlocks.CYAN_CONCRETE_SLAB);
        gen.family(Blocks.LIGHT_BLUE_CONCRETE).stairs(EBlocks.LIGHT_BLUE_CONCRETE_STAIRS).slab(EBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        gen.family(Blocks.BLUE_CONCRETE).stairs(EBlocks.BLUE_CONCRETE_STAIRS).slab(EBlocks.BLUE_CONCRETE_SLAB);
        gen.family(Blocks.PURPLE_CONCRETE).stairs(EBlocks.PURPLE_CONCRETE_STAIRS).slab(EBlocks.PURPLE_CONCRETE_SLAB);
        gen.family(Blocks.MAGENTA_CONCRETE).stairs(EBlocks.MAGENTA_CONCRETE_STAIRS).slab(EBlocks.MAGENTA_CONCRETE_SLAB);
        gen.family(Blocks.PINK_CONCRETE).stairs(EBlocks.PINK_CONCRETE_STAIRS).slab(EBlocks.PINK_CONCRETE_SLAB);

    }



    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        EItemModelGenerators armorModelGenerator = new EItemModelGenerators(itemModelGenerator.itemModelOutput, itemModelGenerator.modelOutput);
        
        itemModelGenerator.generateFlatItem(EBlocks.SULFUR_SPIKE.asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EBlocks.ICICLE.asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(EBlocks.PEBBLE.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.DIAMOND_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.EMERALD_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.RAW_TIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.TIN_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.TIN_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.BRONZE_MIX, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_NUGGET, ModelTemplates.FLAT_ITEM);
        armorModelGenerator.generateFullTrimmableItem(EItems.BRONZE_HELMET, EEquipmentAssets.BRONZE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.BRONZE_CHESTPLATE, EEquipmentAssets.BRONZE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.BRONZE_LEGGINGS, EEquipmentAssets.BRONZE, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.BRONZE_BOOTS, EEquipmentAssets.BRONZE, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(EItems.BRONZE_SPEAR);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.BRONZE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(EItems.RAW_SILVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SILVER_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SILVER_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.NETHERITE_MIX, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_MIX, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_INGOT, ModelTemplates.FLAT_ITEM);
        armorModelGenerator.generateFullTrimmableItem(EItems.SOULSTEEL_HELMET, EEquipmentAssets.SOULSTEEL, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.SOULSTEEL_CHESTPLATE, EEquipmentAssets.SOULSTEEL, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.SOULSTEEL_LEGGINGS, EEquipmentAssets.SOULSTEEL, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateFullTrimmableItem(EItems.SOULSTEEL_BOOTS, EEquipmentAssets.SOULSTEEL, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(EItems.SOULSTEEL_SPEAR);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SOULSTEEL_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(EItems.FROSTBITE_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.PERCH_SPAWN_EGG, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.RAW_PERCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.COOKED_PERCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SHINING_PERCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.PERCH_BUCKET, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.POPLAR_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.POPLAR_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.POPLAR_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.POPLAR_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.AZALEA_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.AZALEA_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.AZALEA_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.AZALEA_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EItems.CEDAR_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.CEDAR_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.CEDAR_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.CEDAR_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        armorModelGenerator.generateCustomTrimCases(Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);

        armorModelGenerator.generateCustomTrimCases(Items.LEATHER_HELMET, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_HELMET, true);
        armorModelGenerator.generateCustomTrimCases(Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, true);
        armorModelGenerator.generateCustomTrimCases(Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, true);
        armorModelGenerator.generateCustomTrimCases(Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, ItemModelGenerators.TRIM_PREFIX_BOOTS, true);

        armorModelGenerator.generateCustomTrimCases(Items.COPPER_HELMET, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.COPPER_BOOTS, EquipmentAssets.COPPER, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        armorModelGenerator.generateCustomTrimCases(Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        armorModelGenerator.generateCustomTrimCases(Items.IRON_HELMET, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.IRON_CHESTPLATE, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.IRON_LEGGINGS, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.IRON_BOOTS, EquipmentAssets.IRON, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        armorModelGenerator.generateCustomTrimCases(Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        armorModelGenerator.generateCustomTrimCases(Items.GOLDEN_HELMET, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        armorModelGenerator.generateCustomTrimCases(Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        armorModelGenerator.generateCustomTrimCases(Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        armorModelGenerator.generateCustomTrimCases(Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        armorModelGenerator.generateCustomTrimCases(Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
    }



    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
