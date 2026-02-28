package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)

                .add(EBlocks.QUARTZ_BRICK_STAIRS)
                .add(EBlocks.QUARTZ_BRICK_SLAB)

                .add(EBlocks.AMETHYST_STAIRS)
                .add(EBlocks.AMETHYST_SLAB)
                .add(EBlocks.AMETHYST_BRICK_STAIRS)
                .add(EBlocks.AMETHYST_BRICK_SLAB)
                .add(EBlocks.AMETHYST_BRICKS)
                .add(EBlocks.AMETHYST_PILLAR)
                .add(EBlocks.CHISELED_AMETHYST)

                .add(EBlocks.OBSIDIAN_STAIRS)
                .add(EBlocks.OBSIDIAN_SLAB)
                .add(EBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(EBlocks.OBSIDIAN_BRICK_SLAB)
                .add(EBlocks.OBSIDIAN_BRICKS)
                .add(EBlocks.OBSIDIAN_PILLAR)
                .add(EBlocks.CHISELED_OBSIDIAN)
        ;

        // Tool Tiers
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.OBSIDIAN)
                .add(EBlocks.OBSIDIAN_STAIRS)
                .add(EBlocks.OBSIDIAN_SLAB)
                .add(EBlocks.OBSIDIAN_BRICKS)
                .add(EBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(EBlocks.OBSIDIAN_BRICK_SLAB)
                .add(EBlocks.OBSIDIAN_PILLAR)
                .add(EBlocks.CHISELED_OBSIDIAN)
        ;
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.OBSIDIAN)
        ;
    }
}
