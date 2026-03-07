package team.lookingglass.constructure.datagen;

import team.lookingglass.constructure.registry.CBlocks;
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

                .add(CBlocks.QUARTZ_BRICK_STAIRS)
                .add(CBlocks.QUARTZ_BRICK_SLAB)

                .add(CBlocks.AMETHYST_STAIRS)
                .add(CBlocks.AMETHYST_SLAB)
                .add(CBlocks.AMETHYST_BRICK_STAIRS)
                .add(CBlocks.AMETHYST_BRICK_SLAB)
                .add(CBlocks.AMETHYST_BRICKS)
                .add(CBlocks.AMETHYST_PILLAR)
                .add(CBlocks.CHISELED_AMETHYST)

                .add(CBlocks.OBSIDIAN_STAIRS)
                .add(CBlocks.OBSIDIAN_SLAB)
                .add(CBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(CBlocks.OBSIDIAN_BRICK_SLAB)
                .add(CBlocks.OBSIDIAN_BRICKS)
                .add(CBlocks.OBSIDIAN_PILLAR)
                .add(CBlocks.CHISELED_OBSIDIAN)
        ;

        // Tool Tiers
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Blocks.OBSIDIAN)
                .add(CBlocks.OBSIDIAN_STAIRS)
                .add(CBlocks.OBSIDIAN_SLAB)
                .add(CBlocks.OBSIDIAN_BRICKS)
                .add(CBlocks.OBSIDIAN_BRICK_STAIRS)
                .add(CBlocks.OBSIDIAN_BRICK_SLAB)
                .add(CBlocks.OBSIDIAN_PILLAR)
                .add(CBlocks.CHISELED_OBSIDIAN)
        ;
        valueLookupBuilder(BlockTags.WALLS)
                .add(CBlocks.STONE_WALL)
                .add(CBlocks.SMOOTH_STONE_WALL)
                .add(CBlocks.STONE_TILE_WALL)
                .add(CBlocks.MOSSY_STONE_TILE_WALL)
                .add(CBlocks.POLISHED_ANDESITE_WALL)
                .add(CBlocks.ANDESITE_BRICK_WALL)
                .add(CBlocks.POLISHED_GRANITE_WALL)
                .add(CBlocks.GRANITE_BRICK_WALL)
                .add(CBlocks.POLISHED_DIORITE_WALL)
                .add(CBlocks.DIORITE_BRICK_WALL)
                .add(CBlocks.CALCITE_WALL)
                .add(CBlocks.POLISHED_CALCITE_WALL)
                .add(CBlocks.CALCITE_BRICK_WALL)
                .add(CBlocks.DRIPSTONE_WALL)
                .add(CBlocks.POLISHED_DRIPSTONE_WALL)
                .add(CBlocks.DRIPSTONE_BRICK_WALL)

        ;
    }
}
