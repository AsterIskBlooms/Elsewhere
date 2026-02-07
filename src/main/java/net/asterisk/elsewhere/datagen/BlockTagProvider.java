package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    public static final TagKey<Block> TAUTOLITH_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tautolith_logs"));
    public static final TagKey<Block> BRIAR_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "briar_logs"));

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


        valueLookupBuilder(TAUTOLITH_LOGS)
                .add(EBlocks.TAUTOLITH_LOG)
                .add(EBlocks.TAUTOLITH_WOOD)
                .add(EBlocks.STRIPPED_TAUTOLITH_LOG)
                .add(EBlocks.STRIPPED_TAUTOLITH_WOOD)
        ;
        valueLookupBuilder(BRIAR_LOGS)
                .add(EBlocks.BRIAR_LOG)
                .add(EBlocks.BRIAR_WOOD)
                .add(EBlocks.STRIPPED_BRIAR_LOG)
                .add(EBlocks.STRIPPED_BRIAR_WOOD)
        ;
        valueLookupBuilder(BlockTags.LOGS)
                .addTag(TAUTOLITH_LOGS)
                .addTag(BRIAR_LOGS)
        ;
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(TAUTOLITH_LOGS)
                .addTag(BRIAR_LOGS)
        ;
        valueLookupBuilder(BlockTags.LEAVES)
                .add(EBlocks.TAUTOLITH_LEAVES)
                .add(EBlocks.BRIAR_LEAVES)
        ;
        valueLookupBuilder(BlockTags.FENCES)
                .add(EBlocks.TAUTOLITH_FENCE)
                .add(EBlocks.BRIAR_FENCE)
        ;
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(EBlocks.TAUTOLITH_FENCE_GATE)
                .add(EBlocks.BRIAR_FENCE_GATE)
        ;
        valueLookupBuilder(BlockTags.WALLS)
                .add(EBlocks.ROOTSHALE_BRICK_WALL)
        ;

        valueLookupBuilder(BlockTags.ALL_SIGNS)
                .add(EBlocks.TAUTOLITH_SIGN)
                .add(EBlocks.TAUTOLITH_WALL_SIGN)
                .add(EBlocks.TAUTOLITH_HANGING_SIGN)
                .add(EBlocks.TAUTOLITH_WALL_HANGING_SIGN)
                .add(EBlocks.BRIAR_SIGN)
                .add(EBlocks.BRIAR_WALL_SIGN)
                .add(EBlocks.BRIAR_HANGING_SIGN)
                .add(EBlocks.BRIAR_WALL_HANGING_SIGN)
        ;
        valueLookupBuilder(BlockTags.SIGNS)
                .add(EBlocks.TAUTOLITH_SIGN)
                .add(EBlocks.TAUTOLITH_WALL_SIGN)
                .add(EBlocks.BRIAR_SIGN)
                .add(EBlocks.BRIAR_WALL_SIGN)
        ;
        valueLookupBuilder(BlockTags.STANDING_SIGNS)
                .add(EBlocks.TAUTOLITH_SIGN)
                .add(EBlocks.BRIAR_SIGN)
        ;
        valueLookupBuilder(BlockTags.WALL_SIGNS)
                .add(EBlocks.TAUTOLITH_WALL_SIGN)
                .add(EBlocks.BRIAR_WALL_SIGN)
        ;
        valueLookupBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(EBlocks.TAUTOLITH_HANGING_SIGN)
                .add(EBlocks.TAUTOLITH_WALL_HANGING_SIGN)
                .add(EBlocks.BRIAR_HANGING_SIGN)
                .add(EBlocks.BRIAR_WALL_HANGING_SIGN)
        ;
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(EBlocks.TAUTOLITH_HANGING_SIGN)
                .add(EBlocks.BRIAR_HANGING_SIGN)
        ;
        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(EBlocks.TAUTOLITH_WALL_HANGING_SIGN)
                .add(EBlocks.BRIAR_WALL_HANGING_SIGN)
        ;
    }
}
