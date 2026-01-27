package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                // Rootshale
                .add(EBlocks.ROOTSHALE)
                .add(EBlocks.COBBLED_ROOTSHALE)
                .add(EBlocks.ROOTSHALE_BRICKS)
                .add(EBlocks.ROOTSHALE_BRICK_STAIRS)
                .add(EBlocks.ROOTSHALE_BRICK_SLAB)
                .add(EBlocks.ROOTSHALE_BRICK_WALL)
                // Bitterack
                .add(EBlocks.BITTERACK)
                // Ores
                .add(EBlocks.ROOTSHALE_XYLOITE_ORE)
                .add(EBlocks.ROOTSHALE_SYLVER_ORE)
                .add(EBlocks.BITTERACK_SYLVER_ORE)
                // Metal Blocks
                .add(EBlocks.XYLOITE_BLOCK)
                .add(EBlocks.CUT_XYLOITE)
                .add(EBlocks.CUT_XYLOITE_STAIRS)
                .add(EBlocks.CUT_XYLOITE_SLAB)
        ;
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(EBlocks.ROOTSHALE_XYLOITE_ORE)
                .add(EBlocks.XYLOITE_BLOCK)
                .add(EBlocks.CUT_XYLOITE)
                .add(EBlocks.CUT_XYLOITE_STAIRS)
                .add(EBlocks.CUT_XYLOITE_SLAB)
        ;
    }
}
