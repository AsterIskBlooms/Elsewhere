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

    public static final TexturedModel.Provider PLANT = createDefault(TextureMapping::cross, ModelTemplates.CROSS);

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
                .slab(EBlocks.CUT_XYLOITE_SLAB);

        // Sylver Blocks
        blockStateModelGenerator.createTrivialCube(EBlocks.SYLVER_BLOCK);

        // Tautwood Blocks
        blockStateModelGenerator.createTrivialBlock(EBlocks.TAUTWOOD_SAPLING, PLANT);
        blockStateModelGenerator.createTrivialBlock(EBlocks.TAUTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(EBlocks.TAUTWOOD_LOG, TexturedModel.COLUMN_ALT);
        blockStateModelGenerator.createTrivialCube(EBlocks.TAUTWOOD_WOOD);
        blockStateModelGenerator.createTrivialBlock(EBlocks.STRIPPED_TAUTWOOD_LOG, TexturedModel.COLUMN_ALT);
        blockStateModelGenerator.createTrivialCube(EBlocks.STRIPPED_TAUTWOOD_WOOD);
        blockStateModelGenerator.family(EBlocks.TAUTWOOD_PLANKS)
                .stairs(EBlocks.TAUTWOOD_STAIRS)
                .slab(EBlocks.TAUTWOOD_SLAB)
                .fence(EBlocks.TAUTWOOD_FENCE)
                .fenceGate(EBlocks.TAUTWOOD_FENCE_GATE)
                //.sign(EBlocks.TAUTWOOD_SIGN)
                ;
    }






    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        // Xyloite Items
        itemModelGenerator.generateFlatItem(EItems.RAW_XYLOITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.XYLOITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        // Do spear manually
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
        // Do spear manually
        itemModelGenerator.generateFlatItem(EItems.SYLVER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(EItems.SYLVER_BOOTS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(EBlocks.TAUTWOOD_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
    }





    @Override
    public String getName() {
        return "BlockModelProvider";
    }
}
