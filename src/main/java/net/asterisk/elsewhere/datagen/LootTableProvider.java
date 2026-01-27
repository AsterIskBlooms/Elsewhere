package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootSubProvider {
    public LootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        // Gloam
        dropSelf(EBlocks.GLOAM);

        // Rootshale
        dropSelf(EBlocks.COBBLED_ROOTSHALE);
        dropSelf(EBlocks.ROOTSHALE_BRICKS);
        dropSelf(EBlocks.ROOTSHALE_BRICK_STAIRS);
        dropSelf(EBlocks.ROOTSHALE_BRICK_SLAB);
        dropSelf(EBlocks.ROOTSHALE_BRICK_WALL);

        // Bitterack
        dropSelf(EBlocks.BITTERACK);

        // Tautwood
        dropSelf(EBlocks.TAUTWOOD_SAPLING);
        dropSelf(EBlocks.TAUTWOOD_LOG);
        dropSelf(EBlocks.TAUTWOOD_WOOD);
        dropSelf(EBlocks.STRIPPED_TAUTWOOD_LOG);
        dropSelf(EBlocks.STRIPPED_TAUTWOOD_WOOD);
        dropSelf(EBlocks.TAUTWOOD_PLANKS);
        dropSelf(EBlocks.TAUTWOOD_STAIRS);
        dropSelf(EBlocks.TAUTWOOD_SLAB);
        dropSelf(EBlocks.TAUTWOOD_FENCE);
        dropSelf(EBlocks.TAUTWOOD_FENCE_GATE);
        dropLeaves(EBlocks.TAUTWOOD_LEAVES);
    }

    public void dropLeaves(final Block block) {
        this.createShearsOrSilkTouchOnlyDrop(block);
    }

}
