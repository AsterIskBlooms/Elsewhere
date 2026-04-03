package team.lookingglass.constructure.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.Nullable;
import team.lookingglass.constructure.registry.CBlocks;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ConRecipeProvider extends FabricRecipeProvider {

    public ConRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public Identifier getRecipeIdentifier(Identifier identifier) {
        return identifier;
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {

        RecipeOutput wrappedOutput = new RecipeOutput() {
            @Override
            public void accept(ResourceKey<Recipe<?>> key, Recipe<?> recipe, @Nullable AdvancementHolder advancement) {
                String namespace = key.identifier().getNamespace();
                ResourceKey<Recipe<?>> remappedKey = ResourceKey.create(
                        Registries.RECIPE,
                        Identifier.fromNamespaceAndPath(namespace, key.identifier().getPath())
                );
                output.accept(remappedKey, recipe, advancement);
            }

            @Override
            public Advancement.Builder advancement() {
                return output.advancement();
            }

            @Override
            public void includeRootAdvancement() {

            }
        };

        return new RecipeProvider(provider, wrappedOutput) {
            @Override
            public void buildRecipes() {
                cobbledStoneSet(wrappedOutput,
                        Items.STONE,
                        Items.STONE_STAIRS,
                        Items.STONE_SLAB,
                        CBlocks.STONE_WALL.asItem(),

                        Items.SMOOTH_STONE,
                        CBlocks.SMOOTH_STONE_STAIRS.asItem(),
                        Items.SMOOTH_STONE_SLAB,
                        CBlocks.SMOOTH_STONE_WALL.asItem(),

                        CBlocks.POLISHED_STONE.asItem(),
                        CBlocks.POLISHED_STONE_STAIRS.asItem(),
                        CBlocks.POLISHED_STONE_SLAB.asItem(),
                        CBlocks.POLISHED_STONE_WALL.asItem(),

                        Items.STONE_BRICKS,
                        Items.STONE_BRICK_STAIRS,
                        Items.STONE_BRICK_SLAB,
                        Items.STONE_BRICK_WALL,

                        CBlocks.CHISELED_STONE.asItem(),
                        Items.CHISELED_STONE_BRICKS,
                        CBlocks.STONE_PILLAR.asItem(),

                        Items.COBBLESTONE,
                        Items.COBBLESTONE_STAIRS,
                        Items.COBBLESTONE_SLAB,
                        Items.COBBLESTONE_WALL,

                        CBlocks.STONE_TILES.asItem(),
                        CBlocks.STONE_TILE_STAIRS.asItem(),
                        CBlocks.STONE_TILE_SLAB.asItem(),
                        CBlocks.STONE_TILE_WALL.asItem()
                );
                cobbledStoneSet(wrappedOutput,
                        Items.DEEPSLATE,
                        CBlocks.DEEPSLATE_STAIRS.asItem(),
                        CBlocks.DEEPSLATE_SLAB.asItem(),
                        CBlocks.DEEPSLATE_WALL.asItem(),

                        CBlocks.SMOOTH_DEEPSLATE.asItem(),
                        CBlocks.SMOOTH_DEEPSLATE_STAIRS.asItem(),
                        CBlocks.SMOOTH_DEEPSLATE_SLAB.asItem(),
                        CBlocks.SMOOTH_DEEPSLATE_WALL.asItem(),

                        Items.POLISHED_DEEPSLATE,
                        Items.POLISHED_DEEPSLATE_STAIRS,
                        Items.POLISHED_DEEPSLATE_SLAB,
                        Items.POLISHED_DEEPSLATE_WALL,

                        Items.DEEPSLATE_BRICKS,
                        Items.DEEPSLATE_BRICK_STAIRS,
                        Items.DEEPSLATE_BRICK_SLAB,
                        Items.DEEPSLATE_BRICK_WALL,

                        Items.CHISELED_DEEPSLATE,
                        CBlocks.CHISELED_DEEPSLATE_BRICKS.asItem(),
                        CBlocks.DEEPSLATE_PILLAR.asItem(),

                        Items.COBBLED_DEEPSLATE,
                        Items.COBBLED_DEEPSLATE_STAIRS,
                        Items.COBBLED_DEEPSLATE_SLAB,
                        Items.COBBLED_DEEPSLATE_WALL,

                        Items.DEEPSLATE_TILES,
                        Items.DEEPSLATE_TILE_STAIRS,
                        Items.DEEPSLATE_TILE_SLAB,
                        Items.DEEPSLATE_TILE_WALL
                );
                cobbledStoneSet(wrappedOutput,
                        CBlocks.SHALE.asItem(),
                        CBlocks.SHALE_STAIRS.asItem(),
                        CBlocks.SHALE_SLAB.asItem(),
                        CBlocks.SHALE_WALL.asItem(),

                        CBlocks.SMOOTH_SHALE.asItem(),
                        CBlocks.SMOOTH_SHALE_STAIRS.asItem(),
                        CBlocks.SMOOTH_SHALE_SLAB.asItem(),
                        CBlocks.SMOOTH_SHALE_WALL.asItem(),

                        CBlocks.POLISHED_SHALE.asItem(),
                        CBlocks.POLISHED_SHALE_STAIRS.asItem(),
                        CBlocks.POLISHED_SHALE_SLAB.asItem(),
                        CBlocks.POLISHED_SHALE_WALL.asItem(),

                        CBlocks.SHALE_BRICKS.asItem(),
                        CBlocks.SHALE_BRICK_STAIRS.asItem(),
                        CBlocks.SHALE_BRICK_SLAB.asItem(),
                        CBlocks.SHALE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_SHALE.asItem(),
                        CBlocks.CHISELED_SHALE_BRICKS.asItem(),
                        CBlocks.SHALE_PILLAR.asItem(),

                        CBlocks.COBBLESHALE.asItem(),
                        CBlocks.COBBLESHALE_STAIRS.asItem(),
                        CBlocks.COBBLESHALE_SLAB.asItem(),
                        CBlocks.COBBLESHALE_WALL.asItem(),

                        CBlocks.SHALE_TILES.asItem(),
                        CBlocks.SHALE_TILE_STAIRS.asItem(),
                        CBlocks.SHALE_TILE_SLAB.asItem(),
                        CBlocks.SHALE_TILE_WALL.asItem()
                );

                stoneSet(wrappedOutput,
                        Items.ANDESITE,
                        Items.ANDESITE_STAIRS,
                        Items.ANDESITE_SLAB,
                        Items.ANDESITE_WALL,

                        CBlocks.SMOOTH_ANDESITE.asItem(),
                        CBlocks.SMOOTH_ANDESITE_STAIRS.asItem(),
                        CBlocks.SMOOTH_ANDESITE_SLAB.asItem(),
                        CBlocks.SMOOTH_ANDESITE_WALL.asItem(),

                        Items.POLISHED_ANDESITE,
                        Items.POLISHED_ANDESITE_STAIRS,
                        Items.POLISHED_ANDESITE_SLAB,
                        CBlocks.POLISHED_ANDESITE_WALL.asItem(),

                        CBlocks.ANDESITE_BRICKS.asItem(),
                        CBlocks.ANDESITE_BRICK_STAIRS.asItem(),
                        CBlocks.ANDESITE_BRICK_SLAB.asItem(),
                        CBlocks.ANDESITE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_ANDESITE.asItem(),
                        CBlocks.CHISELED_ANDESITE_BRICKS.asItem(),
                        CBlocks.ANDESITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.GRANITE,
                        Items.GRANITE_STAIRS,
                        Items.GRANITE_SLAB,
                        Items.GRANITE_WALL,

                        CBlocks.SMOOTH_GRANITE.asItem(),
                        CBlocks.SMOOTH_GRANITE_STAIRS.asItem(),
                        CBlocks.SMOOTH_GRANITE_SLAB.asItem(),
                        CBlocks.SMOOTH_GRANITE_WALL.asItem(),

                        Items.POLISHED_GRANITE,
                        Items.POLISHED_GRANITE_STAIRS,
                        Items.POLISHED_GRANITE_SLAB,
                        CBlocks.POLISHED_GRANITE_WALL.asItem(),

                        CBlocks.GRANITE_BRICKS.asItem(),
                        CBlocks.GRANITE_BRICK_STAIRS.asItem(),
                        CBlocks.GRANITE_BRICK_SLAB.asItem(),
                        CBlocks.GRANITE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_GRANITE.asItem(),
                        CBlocks.CHISELED_GRANITE_BRICKS.asItem(),
                        CBlocks.GRANITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DIORITE,
                        Items.DIORITE_STAIRS,
                        Items.DIORITE_SLAB,
                        Items.DIORITE_WALL,

                        CBlocks.SMOOTH_DIORITE.asItem(),
                        CBlocks.SMOOTH_DIORITE_STAIRS.asItem(),
                        CBlocks.SMOOTH_DIORITE_SLAB.asItem(),
                        CBlocks.SMOOTH_DIORITE_WALL.asItem(),

                        Items.POLISHED_DIORITE,
                        Items.POLISHED_DIORITE_STAIRS,
                        Items.POLISHED_DIORITE_SLAB,
                        CBlocks.POLISHED_DIORITE_WALL.asItem(),

                        CBlocks.DIORITE_BRICKS.asItem(),
                        CBlocks.DIORITE_BRICK_STAIRS.asItem(),
                        CBlocks.DIORITE_BRICK_SLAB.asItem(),
                        CBlocks.DIORITE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_DIORITE.asItem(),
                        CBlocks.CHISELED_DIORITE_BRICKS.asItem(),
                        CBlocks.DIORITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.TUFF,
                        Items.TUFF_STAIRS,
                        Items.TUFF_SLAB,
                        Items.TUFF_WALL,

                        CBlocks.SMOOTH_TUFF.asItem(),
                        CBlocks.SMOOTH_TUFF_STAIRS.asItem(),
                        CBlocks.SMOOTH_TUFF_SLAB.asItem(),
                        CBlocks.SMOOTH_TUFF_WALL.asItem(),

                        Items.POLISHED_TUFF,
                        Items.POLISHED_TUFF_STAIRS,
                        Items.POLISHED_TUFF_SLAB,
                        Items.POLISHED_TUFF_WALL,

                        Items.TUFF_BRICKS,
                        Items.TUFF_BRICK_STAIRS,
                        Items.TUFF_BRICK_SLAB,
                        Items.TUFF_BRICK_WALL,

                        Items.CHISELED_TUFF,
                        Items.CHISELED_TUFF_BRICKS,
                        CBlocks.TUFF_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.CALCITE,
                        CBlocks.CALCITE_STAIRS.asItem(),
                        CBlocks.CALCITE_SLAB.asItem(),
                        CBlocks.CALCITE_WALL.asItem(),

                        CBlocks.SMOOTH_CALCITE.asItem(),
                        CBlocks.SMOOTH_CALCITE_STAIRS.asItem(),
                        CBlocks.SMOOTH_CALCITE_SLAB.asItem(),
                        CBlocks.SMOOTH_CALCITE_WALL.asItem(),

                        CBlocks.POLISHED_CALCITE.asItem(),
                        CBlocks.POLISHED_CALCITE_STAIRS.asItem(),
                        CBlocks.POLISHED_CALCITE_SLAB.asItem(),
                        CBlocks.POLISHED_CALCITE_WALL.asItem(),

                        CBlocks.CALCITE_BRICKS.asItem(),
                        CBlocks.CALCITE_BRICK_STAIRS.asItem(),
                        CBlocks.CALCITE_BRICK_SLAB.asItem(),
                        CBlocks.CALCITE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_CALCITE.asItem(),
                        CBlocks.CHISELED_CALCITE_BRICKS.asItem(),
                        CBlocks.CALCITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DRIPSTONE_BLOCK,
                        CBlocks.DRIPSTONE_STAIRS.asItem(),
                        CBlocks.DRIPSTONE_SLAB.asItem(),
                        CBlocks.DRIPSTONE_WALL.asItem(),

                        CBlocks.SMOOTH_DRIPSTONE.asItem(),
                        CBlocks.SMOOTH_DRIPSTONE_STAIRS.asItem(),
                        CBlocks.SMOOTH_DRIPSTONE_SLAB.asItem(),
                        CBlocks.SMOOTH_DRIPSTONE_WALL.asItem(),

                        CBlocks.POLISHED_DRIPSTONE.asItem(),
                        CBlocks.POLISHED_DRIPSTONE_STAIRS.asItem(),
                        CBlocks.POLISHED_DRIPSTONE_SLAB.asItem(),
                        CBlocks.POLISHED_DRIPSTONE_WALL.asItem(),

                        CBlocks.DRIPSTONE_BRICKS.asItem(),
                        CBlocks.DRIPSTONE_BRICK_STAIRS.asItem(),
                        CBlocks.DRIPSTONE_BRICK_SLAB.asItem(),
                        CBlocks.DRIPSTONE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_DRIPSTONE.asItem(),
                        CBlocks.CHISELED_DRIPSTONE_BRICKS.asItem(),
                        CBlocks.DRIPSTONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.BLACKSTONE,
                        Items.BLACKSTONE_STAIRS,
                        Items.BLACKSTONE_SLAB,
                        Items.BLACKSTONE_WALL,

                        CBlocks.SMOOTH_BLACKSTONE.asItem(),
                        CBlocks.SMOOTH_BLACKSTONE_STAIRS.asItem(),
                        CBlocks.SMOOTH_BLACKSTONE_SLAB.asItem(),
                        CBlocks.SMOOTH_BLACKSTONE_WALL.asItem(),

                        Items.POLISHED_BLACKSTONE,
                        Items.POLISHED_BLACKSTONE_STAIRS,
                        Items.POLISHED_BLACKSTONE_SLAB,
                        Items.POLISHED_BLACKSTONE_WALL,

                        Items.POLISHED_BLACKSTONE_BRICKS,
                        Items.POLISHED_BLACKSTONE_BRICK_STAIRS,
                        Items.POLISHED_BLACKSTONE_BRICK_SLAB,
                        Items.POLISHED_BLACKSTONE_BRICK_WALL,

                        Items.CHISELED_POLISHED_BLACKSTONE,
                        CBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS.asItem(),
                        CBlocks.POLISHED_BLACKSTONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.PRISMARINE,
                        Items.PRISMARINE_STAIRS,
                        Items.PRISMARINE_SLAB,
                        Items.PRISMARINE_WALL,

                        CBlocks.SMOOTH_PRISMARINE.asItem(),
                        CBlocks.SMOOTH_PRISMARINE_STAIRS.asItem(),
                        CBlocks.SMOOTH_PRISMARINE_SLAB.asItem(),
                        CBlocks.SMOOTH_PRISMARINE_WALL.asItem(),

                        CBlocks.POLISHED_PRISMARINE.asItem(),
                        CBlocks.POLISHED_PRISMARINE_STAIRS.asItem(),
                        CBlocks.POLISHED_PRISMARINE_SLAB.asItem(),
                        CBlocks.POLISHED_PRISMARINE_WALL.asItem(),

                        Items.PRISMARINE_BRICKS,
                        Items.PRISMARINE_BRICK_STAIRS,
                        Items.PRISMARINE_BRICK_SLAB,
                        CBlocks.PRISMARINE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_PRISMARINE.asItem(),
                        CBlocks.CHISELED_PRISMARINE_BRICKS.asItem(),
                        CBlocks.PRISMARINE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DARK_PRISMARINE,
                        Items.DARK_PRISMARINE_STAIRS,
                        Items.DARK_PRISMARINE_SLAB,
                        CBlocks.DARK_PRISMARINE_WALL.asItem(),

                        CBlocks.SMOOTH_DARK_PRISMARINE.asItem(),
                        CBlocks.SMOOTH_DARK_PRISMARINE_STAIRS.asItem(),
                        CBlocks.SMOOTH_DARK_PRISMARINE_SLAB.asItem(),
                        CBlocks.SMOOTH_DARK_PRISMARINE_WALL.asItem(),

                        CBlocks.POLISHED_DARK_PRISMARINE.asItem(),
                        CBlocks.POLISHED_DARK_PRISMARINE_STAIRS.asItem(),
                        CBlocks.POLISHED_DARK_PRISMARINE_SLAB.asItem(),
                        CBlocks.POLISHED_DARK_PRISMARINE_WALL.asItem(),

                        CBlocks.DARK_PRISMARINE_BRICKS.asItem(),
                        CBlocks.DARK_PRISMARINE_BRICK_STAIRS.asItem(),
                        CBlocks.DARK_PRISMARINE_BRICK_SLAB.asItem(),
                        CBlocks.DARK_PRISMARINE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_DARK_PRISMARINE.asItem(),
                        CBlocks.CHISELED_DARK_PRISMARINE_BRICKS.asItem(),
                        CBlocks.DARK_PRISMARINE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.BASALT,
                        CBlocks.BASALT_STAIRS.asItem(),
                        CBlocks.BASALT_SLAB.asItem(),
                        CBlocks.BASALT_WALL.asItem(),

                        Items.SMOOTH_BASALT,
                        CBlocks.SMOOTH_BASALT_STAIRS.asItem(),
                        CBlocks.SMOOTH_BASALT_SLAB.asItem(),
                        CBlocks.SMOOTH_BASALT_WALL.asItem(),

                        Items.POLISHED_BASALT,
                        CBlocks.POLISHED_BASALT_STAIRS.asItem(),
                        CBlocks.POLISHED_BASALT_SLAB.asItem(),
                        CBlocks.POLISHED_BASALT_WALL.asItem(),

                        CBlocks.BASALT_BRICKS.asItem(),
                        CBlocks.BASALT_BRICK_STAIRS.asItem(),
                        CBlocks.BASALT_BRICK_SLAB.asItem(),
                        CBlocks.BASALT_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_BASALT.asItem(),
                        CBlocks.CHISELED_BASALT_BRICKS.asItem(),
                        CBlocks.BASALT_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.END_STONE,
                        CBlocks.END_STONE_STAIRS.asItem(),
                        CBlocks.END_STONE_SLAB.asItem(),
                        CBlocks.END_STONE_WALL.asItem(),

                        CBlocks.SMOOTH_END_STONE.asItem(),
                        CBlocks.SMOOTH_END_STONE_STAIRS.asItem(),
                        CBlocks.SMOOTH_END_STONE_SLAB.asItem(),
                        CBlocks.SMOOTH_END_STONE_WALL.asItem(),

                        CBlocks.POLISHED_END_STONE.asItem(),
                        CBlocks.POLISHED_END_STONE_STAIRS.asItem(),
                        CBlocks.POLISHED_END_STONE_SLAB.asItem(),
                        CBlocks.POLISHED_END_STONE_WALL.asItem(),

                        Items.END_STONE_BRICKS,
                        Items.END_STONE_BRICK_STAIRS,
                        Items.END_STONE_BRICK_SLAB,
                        Items.END_STONE_BRICK_WALL,

                        CBlocks.CHISELED_END_STONE.asItem(),
                        CBlocks.CHISELED_END_STONE_BRICKS.asItem(),
                        CBlocks.END_STONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        CBlocks.SODALITE.asItem(),
                        CBlocks.SODALITE_STAIRS.asItem(),
                        CBlocks.SODALITE_SLAB.asItem(),
                        CBlocks.SODALITE_WALL.asItem(),

                        CBlocks.SMOOTH_SODALITE.asItem(),
                        CBlocks.SMOOTH_SODALITE_STAIRS.asItem(),
                        CBlocks.SMOOTH_SODALITE_SLAB.asItem(),
                        CBlocks.SMOOTH_SODALITE_WALL.asItem(),

                        CBlocks.POLISHED_SODALITE.asItem(),
                        CBlocks.POLISHED_SODALITE_STAIRS.asItem(),
                        CBlocks.POLISHED_SODALITE_SLAB.asItem(),
                        CBlocks.POLISHED_SODALITE_WALL.asItem(),

                        CBlocks.SODALITE_BRICKS.asItem(),
                        CBlocks.SODALITE_BRICK_STAIRS.asItem(),
                        CBlocks.SODALITE_BRICK_SLAB.asItem(),
                        CBlocks.SODALITE_BRICK_WALL.asItem(),

                        CBlocks.CHISELED_SODALITE.asItem(),
                        CBlocks.CHISELED_SODALITE_BRICKS.asItem(),
                        CBlocks.SODALITE_PILLAR.asItem()
                );


                quartzSet(wrappedOutput,
                        Items.QUARTZ_BLOCK,
                        Items.QUARTZ_STAIRS,
                        Items.QUARTZ_SLAB,
                        Items.QUARTZ_BRICKS,
                        CBlocks.QUARTZ_BRICK_STAIRS.asItem(),
                        CBlocks.QUARTZ_BRICK_SLAB.asItem(),
                        Items.QUARTZ_PILLAR,
                        Items.CHISELED_QUARTZ_BLOCK
                );
                quartzSet(wrappedOutput,
                        Items.AMETHYST_BLOCK,
                        CBlocks.AMETHYST_STAIRS.asItem(),
                        CBlocks.AMETHYST_SLAB.asItem(),
                        CBlocks.AMETHYST_BRICKS.asItem(),
                        CBlocks.AMETHYST_BRICK_STAIRS.asItem(),
                        CBlocks.AMETHYST_BRICK_SLAB.asItem(),
                        CBlocks.AMETHYST_PILLAR.asItem(),
                        CBlocks.CHISELED_AMETHYST.asItem()
                );
                quartzSet(wrappedOutput,
                        Items.OBSIDIAN,
                        CBlocks.OBSIDIAN_STAIRS.asItem(),
                        CBlocks.OBSIDIAN_SLAB.asItem(),
                        CBlocks.OBSIDIAN_BRICKS.asItem(),
                        CBlocks.OBSIDIAN_BRICK_STAIRS.asItem(),
                        CBlocks.OBSIDIAN_BRICK_SLAB.asItem(),
                        CBlocks.OBSIDIAN_PILLAR.asItem(),
                        CBlocks.CHISELED_OBSIDIAN.asItem()
                );

                purpurSet(wrappedOutput,
                        Items.PURPUR_BLOCK,
                        Items.PURPUR_STAIRS,
                        Items.PURPUR_SLAB,
                        Items.PURPUR_PILLAR,
                        CBlocks.CHISELED_PURPUR.asItem()
                );
            }


            private void cobbledStoneSet(RecipeOutput output,
                                  final ItemLike base,
                                  final ItemLike baseStair,
                                  final ItemLike baseSlab,
                                  final ItemLike baseWall,
                                  final ItemLike smooth,
                                  final ItemLike smoothStair,
                                  final ItemLike smoothSlab,
                                  final ItemLike smoothWall,
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
                                  final ItemLike pillar,
                                  final ItemLike cobble,
                                  final ItemLike cobbleStair,
                                  final ItemLike cobbleSlab,
                                  final ItemLike cobbleWall,
                                  final ItemLike tile,
                                  final ItemLike tileStair,
                                  final ItemLike tileSlab,
                                  final ItemLike tileWall
                                  ) {

                // Base
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseWall, 6).define('#', base).pattern("###").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseWall));

                // Polished from Base
                shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(polished));

                // Polished from Smooth
                shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output,
                                BuiltInRegistries.ITEM.getKey(polished.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(smooth.asItem()).getPath());

                // Smooth
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothStair, 6).define('#', smooth).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothSlab, 6).define('#', smooth).pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothWall, 6).define('#', smooth).pattern("###").pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothWall));

                // Polished
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedStair, 6).define('#', polished).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedSlab, 6).define('#', polished).pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedWall, 6).define('#', polished).pattern("###").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedWall));

                // Bricks
                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', polished).pattern("##").pattern("##")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(brick));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickWall, 6).define('#', brick).pattern("###").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickWall));

                // Chiseled & Pillar
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', polished).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(chiseled));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick, 2).define('#', brick).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(chiseledBrick));
                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(pillar));

                // Cobble
                shaped(RecipeCategory.BUILDING_BLOCKS, cobbleStair, 6).define('#', cobble).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(cobble), has(cobble)).save(output, shapedId(cobbleStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, cobbleSlab, 6).define('#', cobble).pattern("###")
                        .unlockedBy(getHasName(cobble), has(cobble)).save(output, shapedId(cobbleSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, cobbleWall, 6).define('#', cobble).pattern("###").pattern("###")
                        .unlockedBy(getHasName(cobble), has(cobble)).save(output, shapedId(cobbleWall));

                // Tile
                shaped(RecipeCategory.BUILDING_BLOCKS, tile, 4).define('#', cobble).pattern("##").pattern("##")
                        .unlockedBy(getHasName(cobble), has(cobble)).save(output, shapedId(tile));
                shaped(RecipeCategory.BUILDING_BLOCKS, tileStair, 6).define('#', tile).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(tile), has(tile)).save(output, shapedId(tileStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, tileSlab, 6).define('#', tile).pattern("###")
                        .unlockedBy(getHasName(tile), has(tile)).save(output, shapedId(tileSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, tileWall, 6).define('#', tile).pattern("###").pattern("###")
                        .unlockedBy(getHasName(tile), has(tile)).save(output, shapedId(tileWall));

                smeltingResultFromBase(smooth, base);

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, baseStair, baseWall,
                                smooth, smoothStair, smoothWall,
                                polished, polishedStair, polishedWall,
                                brick, brickStair, brickWall,
                                chiseled, chiseledBrick, pillar,
                                cobble, cobbleStair, cobbleWall,
                                tile, tileStair, tileWall
                        ),
                        List.of(baseSlab, smoothSlab, polishedSlab, brickSlab, cobbleSlab, tileSlab)
                );
            }

            private void stoneSet(RecipeOutput output,
                                  final ItemLike base,
                                  final ItemLike baseStair,
                                  final ItemLike baseSlab,
                                  final ItemLike baseWall,
                                  final ItemLike smooth,
                                  final ItemLike smoothStair,
                                  final ItemLike smoothSlab,
                                  final ItemLike smoothWall,
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
                                  final ItemLike pillar) {

                // Base
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseWall, 6).define('#', base).pattern("###").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseWall));

                // Polished from Base
                shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(polished));

                // Polished from Smooth
                shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output,
                                BuiltInRegistries.ITEM.getKey(polished.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(smooth.asItem()).getPath());

                // Smooth
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothStair, 6).define('#', smooth).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothSlab, 6).define('#', smooth).pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, smoothWall, 6).define('#', smooth).pattern("###").pattern("###")
                        .unlockedBy(getHasName(smooth), has(smooth)).save(output, shapedId(smoothWall));

                // Polished
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedStair, 6).define('#', polished).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedSlab, 6).define('#', polished).pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedWall, 6).define('#', polished).pattern("###").pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedWall));

                // Bricks
                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', polished).pattern("##").pattern("##")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(brick));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickWall, 6).define('#', brick).pattern("###").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickWall));

                // Chiseled & Pillar
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', polished).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(chiseled));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick, 2).define('#', brick).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(chiseledBrick));
                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(pillar));

                smeltingResultFromBase(smooth, base);

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, baseStair, baseWall,
                                smooth, smoothStair, smoothWall,
                                polished, polishedStair, polishedWall,
                                brick, brickStair, brickWall,
                                chiseled, chiseledBrick, pillar
                        ),
                        List.of(baseSlab, smoothSlab, polishedSlab, brickSlab)
                );
            }


            private void quartzSet(RecipeOutput output,
                                   final ItemLike base,
                                   final ItemLike baseStair,
                                   final ItemLike baseSlab,
                                   final ItemLike brick,
                                   final ItemLike brickStair,
                                   final ItemLike brickSlab,
                                   final ItemLike pillar,
                                   final ItemLike chiseled) {

                // Shaped
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(brick));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(brickSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(pillar));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', brick).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(brick), has(brick)).save(output, shapedId(chiseled));

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, baseStair, brick, brickStair, pillar, chiseled),
                        List.of(baseSlab, brickSlab)
                );
            }


            private void purpurSet(RecipeOutput output,
                                   final ItemLike base,
                                   final ItemLike baseStair,
                                   final ItemLike baseSlab,
                                   final ItemLike pillar,
                                   final ItemLike chiseled) {

                // Shaped
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', base).pattern("#").pattern("#")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(pillar));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', base).pattern(" #").pattern("# ")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(chiseled));

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, baseStair, pillar, chiseled),
                        List.of(baseSlab)
                );
            }







            // Helper Methods
            private ResourceKey<Recipe<?>> shapedId(ItemLike result) {
                Identifier id = BuiltInRegistries.ITEM.getKey(result.asItem());
                return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath()));
            }

            private void stonecutterSet(RecipeOutput output,
                                        List<ItemLike> fullBlocks,
                                        List<ItemLike> slabs) {
                generateStonecutterGroup(output, fullBlocks, fullBlocks, 1);
                generateStonecutterGroup(output, fullBlocks, slabs, 2);
                generateStonecutterGroup(output, slabs, slabs, 1);
            }

            private void generateStonecutterGroup(RecipeOutput output,
                                                  List<ItemLike> inputs,
                                                  List<ItemLike> results,
                                                  int count) {
                for (ItemLike input : inputs) {
                    for (ItemLike result : results) {

                        // Skip self-referential recipes
                        if (input.asItem() == result.asItem()) continue;

                        Identifier inputId  = BuiltInRegistries.ITEM.getKey(input.asItem());
                        Identifier resultId = BuiltInRegistries.ITEM.getKey(result.asItem());

                        String recipeNamespace;
                        if (!inputId.getNamespace().equals("minecraft")) {
                            recipeNamespace = inputId.getNamespace();
                        } else if (!resultId.getNamespace().equals("minecraft")) {
                            recipeNamespace = resultId.getNamespace();
                        } else {
                            recipeNamespace = "minecraft";
                        }

                        ResourceKey<Recipe<?>> recipeId = ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(recipeNamespace,
                                        resultId.getPath() + "_from_" + inputId.getPath() + "_stonecutting")
                        );

                        SingleItemRecipeBuilder
                                .stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, count)
                                .unlockedBy(getHasName(input.asItem()), has(input.asItem()))
                                .save(output, recipeId);
                    }
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Constructure Recipes";
    }
}