package team.lookingglass.constructure.datagen;

import net.minecraft.data.recipes.RecipeProvider;
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

                // Amethyst Bricks
                shaped(RecipeCategory.BUILDING_BLOCKS, CBlocks.AMETHYST_BRICKS.asItem())
                        .pattern("##")
                        .pattern("##")
                        .define('#', Items.AMETHYST_SHARD)
                        .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                        .save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, CBlocks.AMETHYST_BRICK_STAIRS.asItem(), 6)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .define('#', CBlocks.AMETHYST_BRICKS.asItem())
                        .unlockedBy(getHasName(CBlocks.AMETHYST_BRICKS.asItem()), has(CBlocks.AMETHYST_BRICKS.asItem()))
                        .save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, CBlocks.AMETHYST_BRICK_SLAB.asItem(), 6)
                        .pattern("###")
                        .define('#', CBlocks.AMETHYST_BRICKS.asItem())
                        .unlockedBy(getHasName(CBlocks.AMETHYST_BRICKS.asItem()), has(CBlocks.AMETHYST_BRICKS.asItem()))
                        .save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, CBlocks.AMETHYST_PILLAR.asItem(), 2)
                        .pattern("#")
                        .pattern("#")
                        .define('#', CBlocks.AMETHYST_BRICKS.asItem())
                        .unlockedBy(getHasName(CBlocks.AMETHYST_BRICKS.asItem()), has(CBlocks.AMETHYST_BRICKS.asItem()))
                        .save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, CBlocks.CHISELED_AMETHYST.asItem(), 2)
                        .pattern(" #")
                        .pattern("# ")
                        .define('#', CBlocks.AMETHYST_BRICKS.asItem())
                        .unlockedBy(getHasName(CBlocks.AMETHYST_BRICKS.asItem()), has(CBlocks.AMETHYST_BRICKS.asItem()))
                        .save(output);









            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
