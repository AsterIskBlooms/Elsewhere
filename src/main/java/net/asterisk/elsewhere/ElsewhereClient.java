package net.asterisk.elsewhere;

import net.asterisk.elsewhere.registry.EBlocks;
import net.asterisk.elsewhere.registry.EWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ChunkSectionLayerMap;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ElsewhereClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTOLITH_LEAVES, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTOLITH_DOOR, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTOLITH_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTOLITH_SAPLING, ChunkSectionLayer.CUTOUT);





    }
}
