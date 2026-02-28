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
import net.minecraft.world.level.block.Blocks;

import static net.minecraft.client.data.models.model.TexturedModel.createDefault;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // Quartz Brick Fill
        blockStateModelGenerator.family(Blocks.QUARTZ_BRICKS)
                .stairs(EBlocks.QUARTZ_BRICK_STAIRS)
                .slab(EBlocks.QUARTZ_BRICK_SLAB)
        ;

        // Amethyst-Obsidian Set
        blockStateModelGenerator.family(Blocks.AMETHYST_BLOCK)
                .stairs(EBlocks.AMETHYST_STAIRS)
                .slab(EBlocks.AMETHYST_SLAB)
        ;
        blockStateModelGenerator.family(EBlocks.AMETHYST_BRICKS)
                .stairs(EBlocks.AMETHYST_BRICK_STAIRS)
                .slab(EBlocks.AMETHYST_BRICK_SLAB)
        ;
        blockStateModelGenerator.createTrivialCube(EBlocks.CHISELED_AMETHYST);
        blockStateModelGenerator.createAxisAlignedPillarBlock(EBlocks.AMETHYST_PILLAR, TexturedModel.COLUMN);

        blockStateModelGenerator.family(Blocks.OBSIDIAN)
                .stairs(EBlocks.OBSIDIAN_STAIRS)
                .slab(EBlocks.OBSIDIAN_SLAB)
        ;
        blockStateModelGenerator.family(EBlocks.OBSIDIAN_BRICKS)
                .stairs(EBlocks.OBSIDIAN_BRICK_STAIRS)
                .slab(EBlocks.OBSIDIAN_BRICK_SLAB)
        ;
        blockStateModelGenerator.createTrivialCube(EBlocks.CHISELED_OBSIDIAN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(EBlocks.OBSIDIAN_PILLAR, TexturedModel.COLUMN);

    }






    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
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
