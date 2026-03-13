package team.lookingglass.constructure.datagen;

import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import team.lookingglass.constructure.registry.CBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ConRecipeProvider extends FabricRecipeProvider {
    public ConRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                stoneSet(Items.STONE,
                        Items.STONE_STAIRS,
                        Items.STONE_SLAB,
                        CBlocks.STONE_WALL.asItem(),

                        Items.SMOOTH_STONE,
                        CBlocks.SMOOTH_STONE_STAIRS.asItem(),
                        Items.SMOOTH_STONE_SLAB,
                        CBlocks.SMOOTH_STONE_WALL.asItem(),

                        Items.STONE_BRICKS,
                        Items.STONE_BRICK_STAIRS,
                        Items.STONE_BRICK_SLAB,
                        Items.STONE_BRICK_WALL,

                        CBlocks.CHISELED_STONE.asItem(),
                        Items.CHISELED_STONE_BRICKS,
                        CBlocks.STONE_PILLAR.asItem()
                );

                // Amethyst & Obsidian Blocks
                quartzSet(Items.AMETHYST_BLOCK,
                        CBlocks.AMETHYST_STAIRS.asItem(),
                        CBlocks.AMETHYST_SLAB.asItem(),

                        CBlocks.AMETHYST_BRICKS.asItem(),
                        CBlocks.AMETHYST_BRICK_STAIRS.asItem(),
                        CBlocks.AMETHYST_BRICK_SLAB.asItem(),

                        CBlocks.AMETHYST_PILLAR.asItem(),
                        CBlocks.CHISELED_AMETHYST.asItem()
                );
                quartzSet(Items.OBSIDIAN,
                        CBlocks.OBSIDIAN_STAIRS.asItem(),
                        CBlocks.OBSIDIAN_SLAB.asItem(),

                        CBlocks.OBSIDIAN_BRICKS.asItem(),
                        CBlocks.OBSIDIAN_BRICK_STAIRS.asItem(),
                        CBlocks.OBSIDIAN_BRICK_SLAB.asItem(),

                        CBlocks.OBSIDIAN_PILLAR.asItem(),
                        CBlocks.CHISELED_OBSIDIAN.asItem()
                );









            }
            public void stoneSet(final ItemLike base,
                                 final ItemLike baseStair,
                                 final ItemLike baseSlab,
                                 final ItemLike baseWall,
                                 final ItemLike polished,
                                 final ItemLike polishedStair,
                                 final ItemLike polishedSlab,
                                 final ItemLike polishedWall,
                                 final ItemLike brick,
                                 final ItemLike brickStair,
                                 final ItemLike brickSlab,
                                 final ItemLike brickWall,
                                 final ItemLike chiseled,
                                 final ItemLike chiseledBrick,
                                 final ItemLike pillar ) {

                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, baseWall, 6).define('#', base).pattern("###").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedStair, 6).define('#', polished).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedSlab, 6).define('#', polished).pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedWall, 6).define('#', polished).pattern("###").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', polished).pattern("##").pattern("##")
                        .unlockedBy(getHasName(polished), has(polished)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brickWall, 6).define('#', brick).pattern("###").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', polished).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(polished), has(polished)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick, 2).define('#', brick).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);

            }

            public void quartzSet(final ItemLike base,
                                  final ItemLike baseStair,
                                  final ItemLike baseSlab,
                                  final ItemLike brick,
                                  final ItemLike brickStair,
                                  final ItemLike brickSlab,
                                  final ItemLike pillar,
                                  final ItemLike chiseled) {
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', brick).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(brick), has(brick)).save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
