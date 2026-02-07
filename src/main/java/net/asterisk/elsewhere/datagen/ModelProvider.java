package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EBlocks;
import net.asterisk.elsewhere.registry.EItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;

import static net.minecraft.client.data.models.model.TexturedModel.createDefault;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // Gloam Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.GLOAM);
        blockStateModelGenerator.createTrivialBlock(EBlocks.MOSSY_GLOAM, TexturedModel.CUBE_TOP_BOTTOM);

        // Rootshale Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.ROOTSHALE);
        blockStateModelGenerator.createTrivialCube(EBlocks.COBBLED_ROOTSHALE);
        blockStateModelGenerator.family(EBlocks.ROOTSHALE_BRICKS)
                .stairs(EBlocks.ROOTSHALE_BRICK_STAIRS)
                .slab(EBlocks.ROOTSHALE_BRICK_SLAB)
                .wall(EBlocks.ROOTSHALE_BRICK_WALL)
                ;

        // Bitterack Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.BITTERACK);

        // Ore Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.ROOTSHALE_XYLOITE_ORE);
        blockStateModelGenerator.createTrivialCube(EBlocks.ROOTSHALE_SYLVER_ORE);
        blockStateModelGenerator.createTrivialCube(EBlocks.BITTERACK_SYLVER_ORE);

        // Xyloite Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.XYLOITE_BLOCK);
        blockStateModelGenerator.family(EBlocks.CUT_XYLOITE)
                .stairs(EBlocks.CUT_XYLOITE_STAIRS)
                .slab(EBlocks.CUT_XYLOITE_SLAB)
                ;
        blockStateModelGenerator.createDoor(EBlocks.XYLOITE_DOOR);
        blockStateModelGenerator.createTrapdoor(EBlocks.XYLOITE_TRAPDOOR);

        // Sylver Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.SYLVER_BLOCK);

        // Tautolith Blocks
        blockStateModelGenerator.createPlantWithDefaultItem(EBlocks.TAUTOLITH_SAPLING, EBlocks.POTTED_TAUTOLITH_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createTrivialBlock(EBlocks.TAUTOLITH_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.woodProvider(EBlocks.TAUTOLITH_LOG).logWithHorizontal(EBlocks.TAUTOLITH_LOG).wood(EBlocks.TAUTOLITH_WOOD);
        blockStateModelGenerator.woodProvider(EBlocks.STRIPPED_TAUTOLITH_LOG).logWithHorizontal(EBlocks.STRIPPED_TAUTOLITH_LOG).wood(EBlocks.STRIPPED_TAUTOLITH_WOOD);
        blockStateModelGenerator.family(EBlocks.TAUTOLITH_PLANKS).generateFor(EBlocks.TAUTOLITH_FAMILY);
        blockStateModelGenerator.createHangingSign(EBlocks.STRIPPED_TAUTOLITH_LOG, EBlocks.TAUTOLITH_HANGING_SIGN, EBlocks.TAUTOLITH_WALL_HANGING_SIGN);
        blockStateModelGenerator.createShelf(EBlocks.TAUTOLITH_SHELF, EBlocks.STRIPPED_TAUTOLITH_LOG);

        // Briar Blocks
        blockStateModelGenerator.createPlantWithDefaultItem(EBlocks.BRIAR_SAPLING, EBlocks.POTTED_BRIAR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createTrivialBlock(EBlocks.BRIAR_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.woodProvider(EBlocks.BRIAR_LOG).logWithHorizontal(EBlocks.BRIAR_LOG).wood(EBlocks.BRIAR_WOOD);
        blockStateModelGenerator.woodProvider(EBlocks.STRIPPED_BRIAR_LOG).logWithHorizontal(EBlocks.STRIPPED_BRIAR_LOG).wood(EBlocks.STRIPPED_BRIAR_WOOD);
        blockStateModelGenerator.family(EBlocks.BRIAR_PLANKS).generateFor(EBlocks.BRIAR_FAMILY);
        blockStateModelGenerator.createHangingSign(EBlocks.STRIPPED_BRIAR_LOG, EBlocks.BRIAR_HANGING_SIGN, EBlocks.BRIAR_WALL_HANGING_SIGN);
        blockStateModelGenerator.createShelf(EBlocks.BRIAR_SHELF, EBlocks.STRIPPED_BRIAR_LOG);
    }






    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        // Xyloite Items
        itemModelGenerator.generateFlatItem(EItems.RAW_XYLOITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(EItems.XYLOITE_SPEAR);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_BOOTS, ModelTemplates.FLAT_ITEM);


        // Sylver Items
        itemModelGenerator.generateFlatItem(EItems.RAW_SYLVER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateSpear(EItems.SYLVER_SPEAR);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_BOOTS, ModelTemplates.FLAT_ITEM);
    }



    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
