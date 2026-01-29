package net.asterisk.elsewhere;

import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ChunkSectionLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class ElsewhereClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTWOOD_LEAVES, ChunkSectionLayer.SOLID);
        ChunkSectionLayerMap.putBlock(EBlocks.TAUTWOOD_SAPLING, ChunkSectionLayer.CUTOUT);

    }
}
