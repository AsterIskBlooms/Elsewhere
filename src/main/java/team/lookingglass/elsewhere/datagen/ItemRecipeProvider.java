package team.lookingglass.elsewhere.datagen;

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
import team.lookingglass.elsewhere.registry.EBlocks;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemRecipeProvider extends FabricRecipeProvider {

    public ItemRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
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
                        EBlocks.STONE_WALL.asItem(),

                        Items.SMOOTH_STONE,
                        EBlocks.SMOOTH_STONE_STAIRS.asItem(),
                        Items.SMOOTH_STONE_SLAB,
                        EBlocks.SMOOTH_STONE_WALL.asItem(),

                        EBlocks.POLISHED_STONE.asItem(),
                        EBlocks.POLISHED_STONE_STAIRS.asItem(),
                        EBlocks.POLISHED_STONE_SLAB.asItem(),
                        EBlocks.POLISHED_STONE_WALL.asItem(),

                        Items.STONE_BRICKS,
                        Items.STONE_BRICK_STAIRS,
                        Items.STONE_BRICK_SLAB,
                        Items.STONE_BRICK_WALL,

                        EBlocks.CHISELED_STONE.asItem(),
                        Items.CHISELED_STONE_BRICKS,
                        EBlocks.STONE_PILLAR.asItem(),

                        Items.COBBLESTONE,
                        Items.COBBLESTONE_STAIRS,
                        Items.COBBLESTONE_SLAB,
                        Items.COBBLESTONE_WALL,

                        EBlocks.STONE_TILES.asItem(),
                        EBlocks.STONE_TILE_STAIRS.asItem(),
                        EBlocks.STONE_TILE_SLAB.asItem(),
                        EBlocks.STONE_TILE_WALL.asItem()
                );
                cobbledStoneSet(wrappedOutput,
                        Items.DEEPSLATE,
                        EBlocks.DEEPSLATE_STAIRS.asItem(),
                        EBlocks.DEEPSLATE_SLAB.asItem(),
                        EBlocks.DEEPSLATE_WALL.asItem(),

                        EBlocks.SMOOTH_DEEPSLATE.asItem(),
                        EBlocks.SMOOTH_DEEPSLATE_STAIRS.asItem(),
                        EBlocks.SMOOTH_DEEPSLATE_SLAB.asItem(),
                        EBlocks.SMOOTH_DEEPSLATE_WALL.asItem(),

                        Items.POLISHED_DEEPSLATE,
                        Items.POLISHED_DEEPSLATE_STAIRS,
                        Items.POLISHED_DEEPSLATE_SLAB,
                        Items.POLISHED_DEEPSLATE_WALL,

                        Items.DEEPSLATE_BRICKS,
                        Items.DEEPSLATE_BRICK_STAIRS,
                        Items.DEEPSLATE_BRICK_SLAB,
                        Items.DEEPSLATE_BRICK_WALL,

                        Items.CHISELED_DEEPSLATE,
                        EBlocks.CHISELED_DEEPSLATE_BRICKS.asItem(),
                        EBlocks.DEEPSLATE_PILLAR.asItem(),

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
                        EBlocks.SHALE.asItem(),
                        EBlocks.SHALE_STAIRS.asItem(),
                        EBlocks.SHALE_SLAB.asItem(),
                        EBlocks.SHALE_WALL.asItem(),

                        EBlocks.SMOOTH_SHALE.asItem(),
                        EBlocks.SMOOTH_SHALE_STAIRS.asItem(),
                        EBlocks.SMOOTH_SHALE_SLAB.asItem(),
                        EBlocks.SMOOTH_SHALE_WALL.asItem(),

                        EBlocks.POLISHED_SHALE.asItem(),
                        EBlocks.POLISHED_SHALE_STAIRS.asItem(),
                        EBlocks.POLISHED_SHALE_SLAB.asItem(),
                        EBlocks.POLISHED_SHALE_WALL.asItem(),

                        EBlocks.SHALE_BRICKS.asItem(),
                        EBlocks.SHALE_BRICK_STAIRS.asItem(),
                        EBlocks.SHALE_BRICK_SLAB.asItem(),
                        EBlocks.SHALE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_SHALE.asItem(),
                        EBlocks.CHISELED_SHALE_BRICKS.asItem(),
                        EBlocks.SHALE_PILLAR.asItem(),

                        EBlocks.COBBLESHALE.asItem(),
                        EBlocks.COBBLESHALE_STAIRS.asItem(),
                        EBlocks.COBBLESHALE_SLAB.asItem(),
                        EBlocks.COBBLESHALE_WALL.asItem(),

                        EBlocks.SHALE_TILES.asItem(),
                        EBlocks.SHALE_TILE_STAIRS.asItem(),
                        EBlocks.SHALE_TILE_SLAB.asItem(),
                        EBlocks.SHALE_TILE_WALL.asItem()
                );

                stoneSet(wrappedOutput,
                        Items.ANDESITE,
                        Items.ANDESITE_STAIRS,
                        Items.ANDESITE_SLAB,
                        Items.ANDESITE_WALL,

                        EBlocks.SMOOTH_ANDESITE.asItem(),
                        EBlocks.SMOOTH_ANDESITE_STAIRS.asItem(),
                        EBlocks.SMOOTH_ANDESITE_SLAB.asItem(),
                        EBlocks.SMOOTH_ANDESITE_WALL.asItem(),

                        Items.POLISHED_ANDESITE,
                        Items.POLISHED_ANDESITE_STAIRS,
                        Items.POLISHED_ANDESITE_SLAB,
                        EBlocks.POLISHED_ANDESITE_WALL.asItem(),

                        EBlocks.ANDESITE_BRICKS.asItem(),
                        EBlocks.ANDESITE_BRICK_STAIRS.asItem(),
                        EBlocks.ANDESITE_BRICK_SLAB.asItem(),
                        EBlocks.ANDESITE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_ANDESITE.asItem(),
                        EBlocks.CHISELED_ANDESITE_BRICKS.asItem(),
                        EBlocks.ANDESITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.GRANITE,
                        Items.GRANITE_STAIRS,
                        Items.GRANITE_SLAB,
                        Items.GRANITE_WALL,

                        EBlocks.SMOOTH_GRANITE.asItem(),
                        EBlocks.SMOOTH_GRANITE_STAIRS.asItem(),
                        EBlocks.SMOOTH_GRANITE_SLAB.asItem(),
                        EBlocks.SMOOTH_GRANITE_WALL.asItem(),

                        Items.POLISHED_GRANITE,
                        Items.POLISHED_GRANITE_STAIRS,
                        Items.POLISHED_GRANITE_SLAB,
                        EBlocks.POLISHED_GRANITE_WALL.asItem(),

                        EBlocks.GRANITE_BRICKS.asItem(),
                        EBlocks.GRANITE_BRICK_STAIRS.asItem(),
                        EBlocks.GRANITE_BRICK_SLAB.asItem(),
                        EBlocks.GRANITE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_GRANITE.asItem(),
                        EBlocks.CHISELED_GRANITE_BRICKS.asItem(),
                        EBlocks.GRANITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DIORITE,
                        Items.DIORITE_STAIRS,
                        Items.DIORITE_SLAB,
                        Items.DIORITE_WALL,

                        EBlocks.SMOOTH_DIORITE.asItem(),
                        EBlocks.SMOOTH_DIORITE_STAIRS.asItem(),
                        EBlocks.SMOOTH_DIORITE_SLAB.asItem(),
                        EBlocks.SMOOTH_DIORITE_WALL.asItem(),

                        Items.POLISHED_DIORITE,
                        Items.POLISHED_DIORITE_STAIRS,
                        Items.POLISHED_DIORITE_SLAB,
                        EBlocks.POLISHED_DIORITE_WALL.asItem(),

                        EBlocks.DIORITE_BRICKS.asItem(),
                        EBlocks.DIORITE_BRICK_STAIRS.asItem(),
                        EBlocks.DIORITE_BRICK_SLAB.asItem(),
                        EBlocks.DIORITE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_DIORITE.asItem(),
                        EBlocks.CHISELED_DIORITE_BRICKS.asItem(),
                        EBlocks.DIORITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.TUFF,
                        Items.TUFF_STAIRS,
                        Items.TUFF_SLAB,
                        Items.TUFF_WALL,

                        EBlocks.SMOOTH_TUFF.asItem(),
                        EBlocks.SMOOTH_TUFF_STAIRS.asItem(),
                        EBlocks.SMOOTH_TUFF_SLAB.asItem(),
                        EBlocks.SMOOTH_TUFF_WALL.asItem(),

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
                        EBlocks.TUFF_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.CALCITE,
                        EBlocks.CALCITE_STAIRS.asItem(),
                        EBlocks.CALCITE_SLAB.asItem(),
                        EBlocks.CALCITE_WALL.asItem(),

                        EBlocks.SMOOTH_CALCITE.asItem(),
                        EBlocks.SMOOTH_CALCITE_STAIRS.asItem(),
                        EBlocks.SMOOTH_CALCITE_SLAB.asItem(),
                        EBlocks.SMOOTH_CALCITE_WALL.asItem(),

                        EBlocks.POLISHED_CALCITE.asItem(),
                        EBlocks.POLISHED_CALCITE_STAIRS.asItem(),
                        EBlocks.POLISHED_CALCITE_SLAB.asItem(),
                        EBlocks.POLISHED_CALCITE_WALL.asItem(),

                        EBlocks.CALCITE_BRICKS.asItem(),
                        EBlocks.CALCITE_BRICK_STAIRS.asItem(),
                        EBlocks.CALCITE_BRICK_SLAB.asItem(),
                        EBlocks.CALCITE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_CALCITE.asItem(),
                        EBlocks.CHISELED_CALCITE_BRICKS.asItem(),
                        EBlocks.CALCITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DRIPSTONE_BLOCK,
                        EBlocks.DRIPSTONE_STAIRS.asItem(),
                        EBlocks.DRIPSTONE_SLAB.asItem(),
                        EBlocks.DRIPSTONE_WALL.asItem(),

                        EBlocks.SMOOTH_DRIPSTONE.asItem(),
                        EBlocks.SMOOTH_DRIPSTONE_STAIRS.asItem(),
                        EBlocks.SMOOTH_DRIPSTONE_SLAB.asItem(),
                        EBlocks.SMOOTH_DRIPSTONE_WALL.asItem(),

                        EBlocks.POLISHED_DRIPSTONE.asItem(),
                        EBlocks.POLISHED_DRIPSTONE_STAIRS.asItem(),
                        EBlocks.POLISHED_DRIPSTONE_SLAB.asItem(),
                        EBlocks.POLISHED_DRIPSTONE_WALL.asItem(),

                        EBlocks.DRIPSTONE_BRICKS.asItem(),
                        EBlocks.DRIPSTONE_BRICK_STAIRS.asItem(),
                        EBlocks.DRIPSTONE_BRICK_SLAB.asItem(),
                        EBlocks.DRIPSTONE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_DRIPSTONE.asItem(),
                        EBlocks.CHISELED_DRIPSTONE_BRICKS.asItem(),
                        EBlocks.DRIPSTONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.BLACKSTONE,
                        Items.BLACKSTONE_STAIRS,
                        Items.BLACKSTONE_SLAB,
                        Items.BLACKSTONE_WALL,

                        EBlocks.SMOOTH_BLACKSTONE.asItem(),
                        EBlocks.SMOOTH_BLACKSTONE_STAIRS.asItem(),
                        EBlocks.SMOOTH_BLACKSTONE_SLAB.asItem(),
                        EBlocks.SMOOTH_BLACKSTONE_WALL.asItem(),

                        Items.POLISHED_BLACKSTONE,
                        Items.POLISHED_BLACKSTONE_STAIRS,
                        Items.POLISHED_BLACKSTONE_SLAB,
                        Items.POLISHED_BLACKSTONE_WALL,

                        Items.POLISHED_BLACKSTONE_BRICKS,
                        Items.POLISHED_BLACKSTONE_BRICK_STAIRS,
                        Items.POLISHED_BLACKSTONE_BRICK_SLAB,
                        Items.POLISHED_BLACKSTONE_BRICK_WALL,

                        Items.CHISELED_POLISHED_BLACKSTONE,
                        EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS.asItem(),
                        EBlocks.POLISHED_BLACKSTONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.PRISMARINE,
                        Items.PRISMARINE_STAIRS,
                        Items.PRISMARINE_SLAB,
                        Items.PRISMARINE_WALL,

                        EBlocks.SMOOTH_PRISMARINE.asItem(),
                        EBlocks.SMOOTH_PRISMARINE_STAIRS.asItem(),
                        EBlocks.SMOOTH_PRISMARINE_SLAB.asItem(),
                        EBlocks.SMOOTH_PRISMARINE_WALL.asItem(),

                        EBlocks.POLISHED_PRISMARINE.asItem(),
                        EBlocks.POLISHED_PRISMARINE_STAIRS.asItem(),
                        EBlocks.POLISHED_PRISMARINE_SLAB.asItem(),
                        EBlocks.POLISHED_PRISMARINE_WALL.asItem(),

                        Items.PRISMARINE_BRICKS,
                        Items.PRISMARINE_BRICK_STAIRS,
                        Items.PRISMARINE_BRICK_SLAB,
                        EBlocks.PRISMARINE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_PRISMARINE.asItem(),
                        EBlocks.CHISELED_PRISMARINE_BRICKS.asItem(),
                        EBlocks.PRISMARINE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.DARK_PRISMARINE,
                        Items.DARK_PRISMARINE_STAIRS,
                        Items.DARK_PRISMARINE_SLAB,
                        EBlocks.DARK_PRISMARINE_WALL.asItem(),

                        EBlocks.SMOOTH_DARK_PRISMARINE.asItem(),
                        EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS.asItem(),
                        EBlocks.SMOOTH_DARK_PRISMARINE_SLAB.asItem(),
                        EBlocks.SMOOTH_DARK_PRISMARINE_WALL.asItem(),

                        EBlocks.POLISHED_DARK_PRISMARINE.asItem(),
                        EBlocks.POLISHED_DARK_PRISMARINE_STAIRS.asItem(),
                        EBlocks.POLISHED_DARK_PRISMARINE_SLAB.asItem(),
                        EBlocks.POLISHED_DARK_PRISMARINE_WALL.asItem(),

                        EBlocks.DARK_PRISMARINE_BRICKS.asItem(),
                        EBlocks.DARK_PRISMARINE_BRICK_STAIRS.asItem(),
                        EBlocks.DARK_PRISMARINE_BRICK_SLAB.asItem(),
                        EBlocks.DARK_PRISMARINE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_DARK_PRISMARINE.asItem(),
                        EBlocks.CHISELED_DARK_PRISMARINE_BRICKS.asItem(),
                        EBlocks.DARK_PRISMARINE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.BASALT,
                        EBlocks.BASALT_STAIRS.asItem(),
                        EBlocks.BASALT_SLAB.asItem(),
                        EBlocks.BASALT_WALL.asItem(),

                        Items.SMOOTH_BASALT,
                        EBlocks.SMOOTH_BASALT_STAIRS.asItem(),
                        EBlocks.SMOOTH_BASALT_SLAB.asItem(),
                        EBlocks.SMOOTH_BASALT_WALL.asItem(),

                        Items.POLISHED_BASALT,
                        EBlocks.POLISHED_BASALT_STAIRS.asItem(),
                        EBlocks.POLISHED_BASALT_SLAB.asItem(),
                        EBlocks.POLISHED_BASALT_WALL.asItem(),

                        EBlocks.BASALT_BRICKS.asItem(),
                        EBlocks.BASALT_BRICK_STAIRS.asItem(),
                        EBlocks.BASALT_BRICK_SLAB.asItem(),
                        EBlocks.BASALT_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_BASALT.asItem(),
                        EBlocks.CHISELED_BASALT_BRICKS.asItem(),
                        EBlocks.BASALT_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        Items.END_STONE,
                        EBlocks.END_STONE_STAIRS.asItem(),
                        EBlocks.END_STONE_SLAB.asItem(),
                        EBlocks.END_STONE_WALL.asItem(),

                        EBlocks.SMOOTH_END_STONE.asItem(),
                        EBlocks.SMOOTH_END_STONE_STAIRS.asItem(),
                        EBlocks.SMOOTH_END_STONE_SLAB.asItem(),
                        EBlocks.SMOOTH_END_STONE_WALL.asItem(),

                        EBlocks.POLISHED_END_STONE.asItem(),
                        EBlocks.POLISHED_END_STONE_STAIRS.asItem(),
                        EBlocks.POLISHED_END_STONE_SLAB.asItem(),
                        EBlocks.POLISHED_END_STONE_WALL.asItem(),

                        Items.END_STONE_BRICKS,
                        Items.END_STONE_BRICK_STAIRS,
                        Items.END_STONE_BRICK_SLAB,
                        Items.END_STONE_BRICK_WALL,

                        EBlocks.CHISELED_END_STONE.asItem(),
                        EBlocks.CHISELED_END_STONE_BRICKS.asItem(),
                        EBlocks.END_STONE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        EBlocks.SODALITE.asItem(),
                        EBlocks.SODALITE_STAIRS.asItem(),
                        EBlocks.SODALITE_SLAB.asItem(),
                        EBlocks.SODALITE_WALL.asItem(),

                        EBlocks.SMOOTH_SODALITE.asItem(),
                        EBlocks.SMOOTH_SODALITE_STAIRS.asItem(),
                        EBlocks.SMOOTH_SODALITE_SLAB.asItem(),
                        EBlocks.SMOOTH_SODALITE_WALL.asItem(),

                        EBlocks.POLISHED_SODALITE.asItem(),
                        EBlocks.POLISHED_SODALITE_STAIRS.asItem(),
                        EBlocks.POLISHED_SODALITE_SLAB.asItem(),
                        EBlocks.POLISHED_SODALITE_WALL.asItem(),

                        EBlocks.SODALITE_BRICKS.asItem(),
                        EBlocks.SODALITE_BRICK_STAIRS.asItem(),
                        EBlocks.SODALITE_BRICK_SLAB.asItem(),
                        EBlocks.SODALITE_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_SODALITE.asItem(),
                        EBlocks.CHISELED_SODALITE_BRICKS.asItem(),
                        EBlocks.SODALITE_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        EBlocks.SULFUR.asItem(),
                        EBlocks.SULFUR_STAIRS.asItem(),
                        EBlocks.SULFUR_SLAB.asItem(),
                        EBlocks.SULFUR_WALL.asItem(),

                        EBlocks.SMOOTH_SULFUR.asItem(),
                        EBlocks.SMOOTH_SULFUR_STAIRS.asItem(),
                        EBlocks.SMOOTH_SULFUR_SLAB.asItem(),
                        EBlocks.SMOOTH_SULFUR_WALL.asItem(),

                        EBlocks.POLISHED_SULFUR.asItem(),
                        EBlocks.POLISHED_SULFUR_STAIRS.asItem(),
                        EBlocks.POLISHED_SULFUR_SLAB.asItem(),
                        EBlocks.POLISHED_SULFUR_WALL.asItem(),

                        EBlocks.SULFUR_BRICKS.asItem(),
                        EBlocks.SULFUR_BRICK_STAIRS.asItem(),
                        EBlocks.SULFUR_BRICK_SLAB.asItem(),
                        EBlocks.SULFUR_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_SULFUR.asItem(),
                        EBlocks.CHISELED_SULFUR_BRICKS.asItem(),
                        EBlocks.SULFUR_PILLAR.asItem()
                );
                stoneSet(wrappedOutput,
                        EBlocks.CINNABAR.asItem(),
                        EBlocks.CINNABAR_STAIRS.asItem(),
                        EBlocks.CINNABAR_SLAB.asItem(),
                        EBlocks.CINNABAR_WALL.asItem(),

                        EBlocks.SMOOTH_CINNABAR.asItem(),
                        EBlocks.SMOOTH_CINNABAR_STAIRS.asItem(),
                        EBlocks.SMOOTH_CINNABAR_SLAB.asItem(),
                        EBlocks.SMOOTH_CINNABAR_WALL.asItem(),

                        EBlocks.POLISHED_CINNABAR.asItem(),
                        EBlocks.POLISHED_CINNABAR_STAIRS.asItem(),
                        EBlocks.POLISHED_CINNABAR_SLAB.asItem(),
                        EBlocks.POLISHED_CINNABAR_WALL.asItem(),

                        EBlocks.CINNABAR_BRICKS.asItem(),
                        EBlocks.CINNABAR_BRICK_STAIRS.asItem(),
                        EBlocks.CINNABAR_BRICK_SLAB.asItem(),
                        EBlocks.CINNABAR_BRICK_WALL.asItem(),

                        EBlocks.CHISELED_CINNABAR.asItem(),
                        EBlocks.CHISELED_CINNABAR_BRICKS.asItem(),
                        EBlocks.CINNABAR_PILLAR.asItem()
                );


                quartzSet(wrappedOutput,
                        Items.QUARTZ_BLOCK,
                        Items.QUARTZ_STAIRS,
                        Items.QUARTZ_SLAB,
                        Items.QUARTZ_BRICKS,
                        EBlocks.QUARTZ_BRICK_STAIRS.asItem(),
                        EBlocks.QUARTZ_BRICK_SLAB.asItem(),
                        Items.QUARTZ_PILLAR,
                        Items.CHISELED_QUARTZ_BLOCK
                );
                quartzSet(wrappedOutput,
                        Items.AMETHYST_BLOCK,
                        EBlocks.AMETHYST_STAIRS.asItem(),
                        EBlocks.AMETHYST_SLAB.asItem(),
                        EBlocks.AMETHYST_BRICKS.asItem(),
                        EBlocks.AMETHYST_BRICK_STAIRS.asItem(),
                        EBlocks.AMETHYST_BRICK_SLAB.asItem(),
                        EBlocks.AMETHYST_PILLAR.asItem(),
                        EBlocks.CHISELED_AMETHYST.asItem()
                );
                quartzSet(wrappedOutput,
                        Items.OBSIDIAN,
                        EBlocks.OBSIDIAN_STAIRS.asItem(),
                        EBlocks.OBSIDIAN_SLAB.asItem(),
                        EBlocks.OBSIDIAN_BRICKS.asItem(),
                        EBlocks.OBSIDIAN_BRICK_STAIRS.asItem(),
                        EBlocks.OBSIDIAN_BRICK_SLAB.asItem(),
                        EBlocks.OBSIDIAN_PILLAR.asItem(),
                        EBlocks.CHISELED_OBSIDIAN.asItem()
                );

                purpurSet(wrappedOutput,
                        Items.PURPUR_BLOCK,
                        Items.PURPUR_STAIRS,
                        Items.PURPUR_SLAB,
                        Items.PURPUR_PILLAR,
                        EBlocks.CHISELED_PURPUR.asItem()
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
        return "Elsewhere Recipes";
    }
}