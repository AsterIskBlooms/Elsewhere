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
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.Nullable;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.EItems;

import java.util.ArrayList;
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
                fullCookingBook(EItems.RAW_PERCH, EItems.COOKED_PERCH);

                shapeless(RecipeCategory.MISC, EItems.DIAMOND_SHARD, 9).requires(Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(output);
                shapeless(RecipeCategory.MISC, Items.DIAMOND).requires(EItems.DIAMOND_SHARD, 9)
                        .unlockedBy(getHasName(EItems.DIAMOND_SHARD), has(EItems.DIAMOND_SHARD)).save(output);

                shapeless(RecipeCategory.MISC, EItems.EMERALD_SHARD, 9).requires(Items.EMERALD)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(output);
                shapeless(RecipeCategory.MISC, Items.EMERALD).requires(EItems.EMERALD_SHARD, 9)
                        .unlockedBy(getHasName(EItems.EMERALD_SHARD), has(EItems.EMERALD_SHARD)).save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE, 1).pattern("##").pattern("##").define('#', EBlocks.PEBBLE)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(output);

                // Tin
                itemSmeltableNBSet(wrappedOutput,
                        EBlocks.TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.DEEPSLATE_TIN_ORE, EBlocks.CINNABAR_TIN_ORE, EItems.RAW_TIN,
                        EItems.TIN_INGOT, EItems.TIN_NUGGET, EBlocks.RAW_TIN_BLOCK, EBlocks.TIN_BLOCK
                );

                // Bronze
                shapeless(RecipeCategory.MISC, EItems.BRONZE_INGOT).requires(Items.COPPER_INGOT, 2).requires(EItems.TIN_INGOT, 1)
                        .unlockedBy(getHasName(EItems.TIN_INGOT), has(EItems.TIN_INGOT)).save(output);
                itemUnsmeltableNBSet(wrappedOutput,
                        EItems.BRONZE_INGOT, EItems.BRONZE_NUGGET, EBlocks.BRONZE_BLOCK
                );
                equipmentSetCrafting(wrappedOutput,
                        EItems.BRONZE_INGOT, Items.STICK,
                        
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR, EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_HOE,
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS
                );

                // Silver
                itemSmeltableNBSet(wrappedOutput,
                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE, EItems.RAW_SILVER,
                        EItems.SILVER_INGOT, EItems.SILVER_NUGGET, EBlocks.SILVER_BLOCK, EBlocks.RAW_SILVER_BLOCK
                );

                // Soulsteel
                shapeless(RecipeCategory.MISC, EItems.SOULSTEEL_INGOT).requires(Items.NETHERITE_SCRAP, 4).requires(EItems.SILVER_INGOT, 4)
                        .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(output);
                itemUnsmeltableNBSet(wrappedOutput,
                        EItems.SOULSTEEL_INGOT, EItems.SOULSTEEL_NUGGET, EBlocks.SOULSTEEL_BLOCK
                );
                equipmentSetSmithing(wrappedOutput,
                        EItems.SOULSTEEL_INGOT, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,

                        Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_SPEAR, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE,
                        Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,

                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR, EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_HOE,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS
                );

                // Stones
                cobbledStoneSet(wrappedOutput,
                        Items.STONE, Items.STONE_STAIRS, Items.STONE_SLAB, EBlocks.STONE_WALL,
                        Items.SMOOTH_STONE, EBlocks.SMOOTH_STONE_STAIRS, Items.SMOOTH_STONE_SLAB, EBlocks.SMOOTH_STONE_WALL,
                        EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_SLAB, EBlocks.POLISHED_STONE_WALL,
                        Items.STONE_BRICKS, Items.STONE_BRICK_STAIRS, Items.STONE_BRICK_SLAB, Items.STONE_BRICK_WALL,
                        EBlocks.CHISELED_STONE, Items.CHISELED_STONE_BRICKS, EBlocks.STONE_PILLAR,
                        Items.COBBLESTONE, Items.COBBLESTONE_STAIRS, Items.COBBLESTONE_SLAB, Items.COBBLESTONE_WALL,
                        EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_SLAB, EBlocks.STONE_TILE_WALL
                );
                cobbledStoneSet(wrappedOutput,
                        Items.DEEPSLATE, EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL,
                        EBlocks.SMOOTH_DEEPSLATE, EBlocks.SMOOTH_DEEPSLATE_STAIRS, EBlocks.SMOOTH_DEEPSLATE_SLAB, EBlocks.SMOOTH_DEEPSLATE_WALL,
                        Items.POLISHED_DEEPSLATE, Items.POLISHED_DEEPSLATE_STAIRS, Items.POLISHED_DEEPSLATE_SLAB, Items.POLISHED_DEEPSLATE_WALL,
                        Items.DEEPSLATE_BRICKS, Items.DEEPSLATE_BRICK_STAIRS, Items.DEEPSLATE_BRICK_SLAB, Items.DEEPSLATE_BRICK_WALL,
                        Items.CHISELED_DEEPSLATE, EBlocks.CHISELED_DEEPSLATE_BRICKS, EBlocks.DEEPSLATE_PILLAR,
                        Items.COBBLED_DEEPSLATE, Items.COBBLED_DEEPSLATE_STAIRS, Items.COBBLED_DEEPSLATE_SLAB, Items.COBBLED_DEEPSLATE_WALL,
                        Items.DEEPSLATE_TILES, Items.DEEPSLATE_TILE_STAIRS, Items.DEEPSLATE_TILE_SLAB, Items.DEEPSLATE_TILE_WALL
                );
                cobbledStoneSet(wrappedOutput,
                        EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL,
                        EBlocks.SMOOTH_SHALE, EBlocks.SMOOTH_SHALE_STAIRS, EBlocks.SMOOTH_SHALE_SLAB, EBlocks.SMOOTH_SHALE_WALL,
                        EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL,
                        EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL,
                        EBlocks.CHISELED_SHALE, EBlocks.CHISELED_SHALE_BRICKS, EBlocks.SHALE_PILLAR,
                        EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL,
                        EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL
                );

                sandstoneSet(wrappedOutput,
                        Items.SANDSTONE, Items.SANDSTONE_STAIRS, Items.SANDSTONE_SLAB, Items.SANDSTONE_WALL,
                        Items.SMOOTH_SANDSTONE, Items.SMOOTH_SANDSTONE_STAIRS, Items.SMOOTH_SANDSTONE_SLAB, EBlocks.SMOOTH_SANDSTONE_WALL,
                        EBlocks.POLISHED_SANDSTONE, EBlocks.POLISHED_SANDSTONE_STAIRS, EBlocks.POLISHED_SANDSTONE_SLAB, EBlocks.POLISHED_SANDSTONE_WALL,
                        EBlocks.SANDSTONE_BRICKS, EBlocks.SANDSTONE_BRICK_STAIRS, EBlocks.SANDSTONE_BRICK_SLAB, EBlocks.SANDSTONE_BRICK_WALL,
                        Items.CUT_SANDSTONE, EBlocks.CUT_SANDSTONE_STAIRS, Blocks.CUT_SANDSTONE_SLAB, EBlocks.CUT_SANDSTONE_WALL,
                        Items.CHISELED_SANDSTONE
                );
                sandstoneSet(wrappedOutput,
                        Items.RED_SANDSTONE, Items.RED_SANDSTONE_STAIRS, Items.RED_SANDSTONE_SLAB, Items.RED_SANDSTONE_WALL,
                        Items.SMOOTH_RED_SANDSTONE, Items.SMOOTH_RED_SANDSTONE_STAIRS, Items.SMOOTH_RED_SANDSTONE_SLAB, EBlocks.SMOOTH_RED_SANDSTONE_WALL,
                        EBlocks.POLISHED_RED_SANDSTONE, EBlocks.POLISHED_RED_SANDSTONE_STAIRS, EBlocks.POLISHED_RED_SANDSTONE_SLAB, EBlocks.POLISHED_RED_SANDSTONE_WALL,
                        EBlocks.RED_SANDSTONE_BRICKS, EBlocks.RED_SANDSTONE_BRICK_STAIRS, EBlocks.RED_SANDSTONE_BRICK_SLAB, EBlocks.RED_SANDSTONE_BRICK_WALL,
                        Items.CUT_RED_SANDSTONE, EBlocks.CUT_RED_SANDSTONE_STAIRS, Blocks.CUT_RED_SANDSTONE_SLAB, EBlocks.CUT_RED_SANDSTONE_WALL,
                        Items.CHISELED_RED_SANDSTONE
                );
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.SOUL_SANDSTONE).pattern("##").pattern("##").define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                        .unlockedBy(getHasName(Blocks.SOUL_SAND), has(ItemTags.SOUL_FIRE_BASE_BLOCKS)).save(output);
                sandstoneSet(wrappedOutput,
                        EBlocks.SOUL_SANDSTONE, EBlocks.SOUL_SANDSTONE_STAIRS, EBlocks.SOUL_SANDSTONE_SLAB, EBlocks.SOUL_SANDSTONE_WALL,
                        EBlocks.SMOOTH_SOUL_SANDSTONE, EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, EBlocks.SMOOTH_SOUL_SANDSTONE_WALL,
                        EBlocks.POLISHED_SOUL_SANDSTONE, EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, EBlocks.POLISHED_SOUL_SANDSTONE_SLAB, EBlocks.POLISHED_SOUL_SANDSTONE_WALL,
                        EBlocks.SOUL_SANDSTONE_BRICKS, EBlocks.SOUL_SANDSTONE_BRICK_STAIRS, EBlocks.SOUL_SANDSTONE_BRICK_SLAB, EBlocks.SOUL_SANDSTONE_BRICK_WALL,
                        EBlocks.CUT_SOUL_SANDSTONE, EBlocks.CUT_SOUL_SANDSTONE_STAIRS, EBlocks.CUT_SOUL_SANDSTONE_SLAB, EBlocks.CUT_SOUL_SANDSTONE_WALL,
                        EBlocks.CHISELED_SOUL_SANDSTONE
                );

                stoneSet(wrappedOutput,
                        Items.ANDESITE, Items.ANDESITE_STAIRS, Items.ANDESITE_SLAB, Items.ANDESITE_WALL,
                        EBlocks.SMOOTH_ANDESITE, EBlocks.SMOOTH_ANDESITE_STAIRS, EBlocks.SMOOTH_ANDESITE_SLAB, EBlocks.SMOOTH_ANDESITE_WALL,
                        Items.POLISHED_ANDESITE, Items.POLISHED_ANDESITE_STAIRS, Items.POLISHED_ANDESITE_SLAB, EBlocks.POLISHED_ANDESITE_WALL,
                        EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_SLAB, EBlocks.ANDESITE_BRICK_WALL,
                        EBlocks.CHISELED_ANDESITE, EBlocks.CHISELED_ANDESITE_BRICKS, EBlocks.ANDESITE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.GRANITE, Items.GRANITE_STAIRS, Items.GRANITE_SLAB, Items.GRANITE_WALL,
                        EBlocks.SMOOTH_GRANITE, EBlocks.SMOOTH_GRANITE_STAIRS, EBlocks.SMOOTH_GRANITE_SLAB, EBlocks.SMOOTH_GRANITE_WALL,
                        Items.POLISHED_GRANITE, Items.POLISHED_GRANITE_STAIRS, Items.POLISHED_GRANITE_SLAB, EBlocks.POLISHED_GRANITE_WALL,
                        EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_SLAB, EBlocks.GRANITE_BRICK_WALL,
                        EBlocks.CHISELED_GRANITE, EBlocks.CHISELED_GRANITE_BRICKS, EBlocks.GRANITE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.DIORITE, Items.DIORITE_STAIRS, Items.DIORITE_SLAB, Items.DIORITE_WALL,
                        EBlocks.SMOOTH_DIORITE, EBlocks.SMOOTH_DIORITE_STAIRS, EBlocks.SMOOTH_DIORITE_SLAB, EBlocks.SMOOTH_DIORITE_WALL,
                        Items.POLISHED_DIORITE, Items.POLISHED_DIORITE_STAIRS, Items.POLISHED_DIORITE_SLAB, EBlocks.POLISHED_DIORITE_WALL,
                        EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_SLAB, EBlocks.DIORITE_BRICK_WALL,
                        EBlocks.CHISELED_DIORITE, EBlocks.CHISELED_DIORITE_BRICKS, EBlocks.DIORITE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.TUFF, Items.TUFF_STAIRS, Items.TUFF_SLAB, Items.TUFF_WALL,
                        EBlocks.SMOOTH_TUFF, EBlocks.SMOOTH_TUFF_STAIRS, EBlocks.SMOOTH_TUFF_SLAB, EBlocks.SMOOTH_TUFF_WALL,
                        Items.POLISHED_TUFF, Items.POLISHED_TUFF_STAIRS, Items.POLISHED_TUFF_SLAB, Items.POLISHED_TUFF_WALL,
                        Items.TUFF_BRICKS, Items.TUFF_BRICK_STAIRS, Items.TUFF_BRICK_SLAB, Items.TUFF_BRICK_WALL,
                        Items.CHISELED_TUFF, Items.CHISELED_TUFF_BRICKS, EBlocks.TUFF_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.CALCITE, EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_SLAB, EBlocks.CALCITE_WALL,
                        EBlocks.SMOOTH_CALCITE, EBlocks.SMOOTH_CALCITE_STAIRS, EBlocks.SMOOTH_CALCITE_SLAB, EBlocks.SMOOTH_CALCITE_WALL,
                        EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.POLISHED_CALCITE_WALL,
                        EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_SLAB, EBlocks.CALCITE_BRICK_WALL,
                        EBlocks.CHISELED_CALCITE, EBlocks.CHISELED_CALCITE_BRICKS, EBlocks.CALCITE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.DRIPSTONE_BLOCK, EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_SLAB, EBlocks.DRIPSTONE_WALL,
                        EBlocks.SMOOTH_DRIPSTONE, EBlocks.SMOOTH_DRIPSTONE_STAIRS, EBlocks.SMOOTH_DRIPSTONE_SLAB, EBlocks.SMOOTH_DRIPSTONE_WALL,
                        EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_WALL,
                        EBlocks.DRIPSTONE_BRICKS, EBlocks.DRIPSTONE_BRICK_STAIRS, EBlocks.DRIPSTONE_BRICK_SLAB, EBlocks.DRIPSTONE_BRICK_WALL,
                        EBlocks.CHISELED_DRIPSTONE, EBlocks.CHISELED_DRIPSTONE_BRICKS, EBlocks.DRIPSTONE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.BLACKSTONE, Items.BLACKSTONE_STAIRS, Items.BLACKSTONE_SLAB, Items.BLACKSTONE_WALL,
                        EBlocks.SMOOTH_BLACKSTONE, EBlocks.SMOOTH_BLACKSTONE_STAIRS, EBlocks.SMOOTH_BLACKSTONE_SLAB, EBlocks.SMOOTH_BLACKSTONE_WALL,
                        Items.POLISHED_BLACKSTONE, Items.POLISHED_BLACKSTONE_STAIRS, Items.POLISHED_BLACKSTONE_SLAB, Items.POLISHED_BLACKSTONE_WALL,
                        Items.POLISHED_BLACKSTONE_BRICKS, Items.POLISHED_BLACKSTONE_BRICK_STAIRS, Items.POLISHED_BLACKSTONE_BRICK_SLAB, Items.POLISHED_BLACKSTONE_BRICK_WALL,
                        Items.CHISELED_POLISHED_BLACKSTONE, EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS, EBlocks.POLISHED_BLACKSTONE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.PRISMARINE, Items.PRISMARINE_STAIRS, Items.PRISMARINE_SLAB, Items.PRISMARINE_WALL,
                        EBlocks.SMOOTH_PRISMARINE, EBlocks.SMOOTH_PRISMARINE_STAIRS, EBlocks.SMOOTH_PRISMARINE_SLAB, EBlocks.SMOOTH_PRISMARINE_WALL,
                        EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_WALL,
                        Items.PRISMARINE_BRICKS, Items.PRISMARINE_BRICK_STAIRS, Items.PRISMARINE_BRICK_SLAB, EBlocks.PRISMARINE_BRICK_WALL,
                        EBlocks.CHISELED_PRISMARINE, EBlocks.CHISELED_PRISMARINE_BRICKS, EBlocks.PRISMARINE_PILLAR
                );
                stoneSet(wrappedOutput,
                        Items.DARK_PRISMARINE, Items.DARK_PRISMARINE_STAIRS, Items.DARK_PRISMARINE_SLAB, EBlocks.DARK_PRISMARINE_WALL,
                        EBlocks.SMOOTH_DARK_PRISMARINE, EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS, EBlocks.SMOOTH_DARK_PRISMARINE_SLAB, EBlocks.SMOOTH_DARK_PRISMARINE_WALL,
                        EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_WALL,
                        EBlocks.DARK_PRISMARINE_BRICKS, EBlocks.DARK_PRISMARINE_BRICK_STAIRS, EBlocks.DARK_PRISMARINE_BRICK_SLAB, EBlocks.DARK_PRISMARINE_BRICK_WALL,
                        EBlocks.CHISELED_DARK_PRISMARINE, EBlocks.CHISELED_DARK_PRISMARINE_BRICKS, EBlocks.DARK_PRISMARINE_PILLAR
                );
                basaltSet(wrappedOutput,
                        Items.BASALT, EBlocks.BASALT_SLAB,
                        Items.SMOOTH_BASALT, EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL,
                        Items.POLISHED_BASALT, EBlocks.POLISHED_BASALT_SLAB,
                        EBlocks.BASALT_BRICKS, EBlocks.BASALT_BRICK_STAIRS, EBlocks.BASALT_BRICK_SLAB, EBlocks.BASALT_BRICK_WALL,
                        EBlocks.CHISELED_BASALT, EBlocks.CHISELED_BASALT_BRICKS
                );
                stoneSet(wrappedOutput,
                        Items.END_STONE, EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_SLAB, EBlocks.END_STONE_WALL,
                        EBlocks.SMOOTH_END_STONE, EBlocks.SMOOTH_END_STONE_STAIRS, EBlocks.SMOOTH_END_STONE_SLAB, EBlocks.SMOOTH_END_STONE_WALL,
                        EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_SLAB, EBlocks.POLISHED_END_STONE_WALL,
                        Items.END_STONE_BRICKS, Items.END_STONE_BRICK_STAIRS, Items.END_STONE_BRICK_SLAB, Items.END_STONE_BRICK_WALL,
                        EBlocks.CHISELED_END_STONE, EBlocks.CHISELED_END_STONE_BRICKS, EBlocks.END_STONE_PILLAR
                );
                stoneSet(wrappedOutput,
                        EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_SLAB, EBlocks.SODALITE_WALL,
                        EBlocks.SMOOTH_SODALITE, EBlocks.SMOOTH_SODALITE_STAIRS, EBlocks.SMOOTH_SODALITE_SLAB, EBlocks.SMOOTH_SODALITE_WALL,
                        EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.POLISHED_SODALITE_WALL,
                        EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_SLAB, EBlocks.SODALITE_BRICK_WALL,
                        EBlocks.CHISELED_SODALITE, EBlocks.CHISELED_SODALITE_BRICKS, EBlocks.SODALITE_PILLAR
                );
                stoneSet(wrappedOutput,
                        EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_SLAB, EBlocks.SULFUR_WALL,
                        EBlocks.SMOOTH_SULFUR, EBlocks.SMOOTH_SULFUR_STAIRS, EBlocks.SMOOTH_SULFUR_SLAB, EBlocks.SMOOTH_SULFUR_WALL,
                        EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.POLISHED_SULFUR_WALL,
                        EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_SLAB, EBlocks.SULFUR_BRICK_WALL,
                        EBlocks.CHISELED_SULFUR, EBlocks.CHISELED_SULFUR_BRICKS, EBlocks.SULFUR_PILLAR
                );
                stoneSet(wrappedOutput,
                        EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_SLAB, EBlocks.CINNABAR_WALL,
                        EBlocks.SMOOTH_CINNABAR, EBlocks.SMOOTH_CINNABAR_STAIRS, EBlocks.SMOOTH_CINNABAR_SLAB, EBlocks.SMOOTH_CINNABAR_WALL,
                        EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_WALL,
                        EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_SLAB, EBlocks.CINNABAR_BRICK_WALL,
                        EBlocks.CHISELED_CINNABAR, EBlocks.CHISELED_CINNABAR_BRICKS, EBlocks.CINNABAR_PILLAR
                );


                quartzSet(wrappedOutput,
                        Items.QUARTZ_BLOCK, Items.QUARTZ_STAIRS, Items.QUARTZ_SLAB,
                        Items.QUARTZ_BRICKS, EBlocks.QUARTZ_BRICK_STAIRS, EBlocks.QUARTZ_BRICK_SLAB,
                        Items.QUARTZ_PILLAR, Items.CHISELED_QUARTZ_BLOCK
                );
                quartzSet(wrappedOutput,
                        Items.AMETHYST_BLOCK, EBlocks.AMETHYST_STAIRS, EBlocks.AMETHYST_SLAB,
                        EBlocks.AMETHYST_BRICKS, EBlocks.AMETHYST_BRICK_STAIRS, EBlocks.AMETHYST_BRICK_SLAB,
                        EBlocks.AMETHYST_PILLAR, EBlocks.CHISELED_AMETHYST
                );
                quartzSet(wrappedOutput,
                        Items.OBSIDIAN, EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB,
                        EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB,
                        EBlocks.OBSIDIAN_PILLAR, EBlocks.CHISELED_OBSIDIAN
                );

                purpurSet(wrappedOutput,
                        Items.PURPUR_BLOCK, Items.PURPUR_STAIRS, Items.PURPUR_SLAB,
                        Items.PURPUR_PILLAR, EBlocks.CHISELED_PURPUR
                );

                woodSet(wrappedOutput,
                        Items.OAK_PLANKS, Items.OAK_STAIRS, Items.OAK_SLAB,
                        EBlocks.OAK_MOSAIC, EBlocks.OAK_MOSAIC_STAIRS, EBlocks.OAK_MOSAIC_SLAB,
                        EBlocks.OAK_BOARDS, EBlocks.OAK_TRIM
                );
                woodSet(wrappedOutput,
                        Items.DARK_OAK_PLANKS, Items.DARK_OAK_STAIRS, Items.DARK_OAK_SLAB,
                        EBlocks.DARK_OAK_MOSAIC, EBlocks.DARK_OAK_MOSAIC_STAIRS, EBlocks.DARK_OAK_MOSAIC_SLAB,
                        EBlocks.DARK_OAK_BOARDS, EBlocks.DARK_OAK_TRIM
                );
                woodSet(wrappedOutput,
                        Items.PALE_OAK_PLANKS, Items.PALE_OAK_STAIRS, Items.PALE_OAK_SLAB,
                        EBlocks.PALE_OAK_MOSAIC, EBlocks.PALE_OAK_MOSAIC_STAIRS, EBlocks.PALE_OAK_MOSAIC_SLAB,
                        EBlocks.PALE_OAK_BOARDS, EBlocks.PALE_OAK_TRIM
                );
                woodSet(wrappedOutput,
                        Items.BIRCH_PLANKS, Items.BIRCH_STAIRS, Items.BIRCH_SLAB,
                        EBlocks.BIRCH_MOSAIC, EBlocks.BIRCH_MOSAIC_STAIRS, EBlocks.BIRCH_MOSAIC_SLAB,
                        EBlocks.BIRCH_BOARDS, EBlocks.BIRCH_TRIM
                );
                woodSet(wrappedOutput,
                        Items.SPRUCE_PLANKS, Items.SPRUCE_STAIRS, Items.SPRUCE_SLAB,
                        EBlocks.SPRUCE_MOSAIC, EBlocks.SPRUCE_MOSAIC_STAIRS, EBlocks.SPRUCE_MOSAIC_SLAB,
                        EBlocks.SPRUCE_BOARDS, EBlocks.SPRUCE_TRIM
                );
                woodSet(wrappedOutput,
                        Items.JUNGLE_PLANKS, Items.JUNGLE_STAIRS, Items.JUNGLE_SLAB,
                        EBlocks.JUNGLE_MOSAIC, EBlocks.JUNGLE_MOSAIC_STAIRS, EBlocks.JUNGLE_MOSAIC_SLAB,
                        EBlocks.JUNGLE_BOARDS, EBlocks.JUNGLE_TRIM
                );
                woodSet(wrappedOutput,
                        Items.ACACIA_PLANKS, Items.ACACIA_STAIRS, Items.ACACIA_SLAB,
                        EBlocks.ACACIA_MOSAIC, EBlocks.ACACIA_MOSAIC_STAIRS, EBlocks.ACACIA_MOSAIC_SLAB,
                        EBlocks.ACACIA_BOARDS, EBlocks.ACACIA_TRIM
                );
                woodSet(wrappedOutput,
                        Items.MANGROVE_PLANKS, Items.MANGROVE_STAIRS, Items.MANGROVE_SLAB,
                        EBlocks.MANGROVE_MOSAIC, EBlocks.MANGROVE_MOSAIC_STAIRS, EBlocks.MANGROVE_MOSAIC_SLAB,
                        EBlocks.MANGROVE_BOARDS, EBlocks.MANGROVE_TRIM
                );
                woodSet(wrappedOutput,
                        Items.CHERRY_PLANKS, Items.CHERRY_STAIRS, Items.CHERRY_SLAB,
                        EBlocks.CHERRY_MOSAIC, EBlocks.CHERRY_MOSAIC_STAIRS, EBlocks.CHERRY_MOSAIC_SLAB,
                        EBlocks.CHERRY_BOARDS, EBlocks.CHERRY_TRIM
                );
                woodSet(wrappedOutput,
                        Items.CRIMSON_PLANKS, Items.CRIMSON_STAIRS, Items.CRIMSON_SLAB,
                        EBlocks.CRIMSON_MOSAIC, EBlocks.CRIMSON_MOSAIC_STAIRS, EBlocks.CRIMSON_MOSAIC_SLAB,
                        EBlocks.CRIMSON_BOARDS, EBlocks.CRIMSON_TRIM
                );
                woodSet(wrappedOutput,
                        Items.WARPED_PLANKS, Items.WARPED_STAIRS, Items.WARPED_SLAB,
                        EBlocks.WARPED_MOSAIC, EBlocks.WARPED_MOSAIC_STAIRS, EBlocks.WARPED_MOSAIC_SLAB,
                        EBlocks.WARPED_BOARDS, EBlocks.WARPED_TRIM
                );
                woodSet(wrappedOutput,
                        Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_STAIRS, Blocks.BAMBOO_SLAB,
                        Blocks.BAMBOO_MOSAIC, Blocks.BAMBOO_MOSAIC_STAIRS, Blocks.BAMBOO_MOSAIC_SLAB,
                        EBlocks.BAMBOO_BOARDS, EBlocks.BAMBOO_TRIM
                );
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.BAMBOO_STEM).pattern("###").pattern("###").pattern("###").define('#', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO)).save(output, shapedId(Items.BAMBOO));
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO).requires(EBlocks.BAMBOO_STEM)
                        .unlockedBy(getHasName(EBlocks.BAMBOO_STEM), has(EBlocks.BAMBOO_STEM)).save(output, shapedId(EBlocks.BAMBOO_STEM));
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO).requires(EBlocks.STRIPPED_BAMBOO_STEM)
                        .unlockedBy(getHasName(EBlocks.BAMBOO_STEM), has(EBlocks.BAMBOO_STEM)).save(output, shapedId(EBlocks.STRIPPED_BAMBOO_STEM));

                itemToDye(EBlocks.BLUEBONNET, Items.BLUE_DYE);
                itemToDye(EBlocks.RED_HIBISCUS, Items.RED_DYE);
                itemToDye(EBlocks.ORANGE_HIBISCUS, Items.ORANGE_DYE);
                itemToDye(EBlocks.YELLOW_HIBISCUS, Items.YELLOW_DYE);
                itemToDye(EBlocks.BLUE_HIBISCUS, Items.BLUE_DYE);
                itemToDye(EBlocks.PURPLE_HIBISCUS, Items.PURPLE_DYE);
                itemToDye(EBlocks.PINK_HIBISCUS, Items.PINK_DYE);
                itemToDye(EBlocks.WHITE_HIBISCUS, Items.WHITE_DYE);
            }



            private void itemToDye(ItemLike item, ItemLike dye) {
                shapeless(RecipeCategory.MISC, dye).requires(item)
                        .unlockedBy(getHasName(item), has(item)).save(output, shapedId(item));
            }
            private void fullCookingBook(ItemLike raw, ItemLike cooked) {
                simpleCookingRecipe("smelting", SmeltingRecipe::new, 200, raw, cooked, 0.35F);
                simpleCookingRecipe("smoking", SmokingRecipe::new, 100, raw, cooked, 0.35F);
                simpleCookingRecipe("campfire", CampfireCookingRecipe::new, 600, raw, cooked, 0.35F);
            }
            private void itemSmeltableNBSet(RecipeOutput output,
                                   ItemLike oreBlock, ItemLike shaleOreBlock, ItemLike deepslateOreBlock, ItemLike cinnabarOreBlock,
                                   ItemLike raw, ItemLike ingot, ItemLike nugget,
                                   ItemLike rawBlock, ItemLike compBlock) {
                List<ItemLike> smeltables = new ArrayList<>();
                smeltables.add(oreBlock); smeltables.add(shaleOreBlock); smeltables.add(deepslateOreBlock); smeltables.add(cinnabarOreBlock); smeltables.add(raw);

                oreSmelting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 1.0F, 200, getItemName(ingot));
                oreBlasting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 1.0F, 100, getItemName(ingot));

                shapeless(RecipeCategory.BUILDING_BLOCKS, rawBlock).requires(raw, 9)
                        .unlockedBy(getHasName(rawBlock), has(rawBlock)).save(output);
                shapeless(RecipeCategory.MISC, raw, 9).requires(rawBlock)
                        .unlockedBy(getHasName(raw), has(raw)).save(output);

                shapeless(RecipeCategory.MISC, ingot).requires(nugget, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(output,
                                BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath());
                shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                        .unlockedBy(getHasName(nugget), has(nugget)).save(output,
                                BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath());

                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(output,
                                BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath());
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(output,
                                BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath());
            }
            private void itemUnsmeltableNBSet(RecipeOutput output,
                                            ItemLike ingot, ItemLike nugget, ItemLike compBlock) {
                shapeless(RecipeCategory.MISC, ingot).requires(nugget, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(output,
                                BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath());
                shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                        .unlockedBy(getHasName(nugget), has(nugget)).save(output,
                                BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath());

                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(output,
                                BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath());
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(output,
                                BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath());
            }
            private void equipmentSetCrafting(RecipeOutput output, 
                                              ItemLike material, ItemLike handle, 
                                              ItemLike sword, ItemLike axe, ItemLike spear, ItemLike pickaxe, ItemLike shovel, ItemLike hoe, 
                                              ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots) {
                shaped(RecipeCategory.COMBAT, sword).define('#', material).define('T', handle)
                        .pattern("#").pattern("#").pattern("T")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(sword));
                shaped(RecipeCategory.TOOLS, axe).define('#', material).define('T', handle)
                        .pattern("##").pattern("#T").pattern(" T")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(axe));
                shaped(RecipeCategory.COMBAT, spear).define('#', material).define('T', handle)
                        .pattern("  #").pattern(" T ").pattern("T  ")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(spear));
                shaped(RecipeCategory.TOOLS, pickaxe).define('#', material).define('T', handle)
                        .pattern("###").pattern(" T ").pattern(" T ")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(pickaxe));
                shaped(RecipeCategory.TOOLS, shovel).define('#', material).define('T', handle)
                        .pattern("#").pattern("T").pattern("T")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(shovel));
                shaped(RecipeCategory.TOOLS, hoe).define('#', material).define('T', handle)
                        .pattern("##").pattern(" T").pattern(" T")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(hoe));

                shaped(RecipeCategory.COMBAT, helmet).define('#', material)
                        .pattern("###").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(helmet));
                shaped(RecipeCategory.COMBAT, chestplate).define('#', material)
                        .pattern("# #").pattern("###").pattern("###")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(chestplate));
                shaped(RecipeCategory.COMBAT, leggings).define('#', material)
                        .pattern("###").pattern("# #").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(leggings));
                shaped(RecipeCategory.COMBAT, boots).define('#', material)
                        .pattern("# #").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(output, shapedId(boots));
            }
            private void equipmentSetSmithing(RecipeOutput output,
                                              ItemLike material, ItemLike template,
                                              ItemLike baseSword, ItemLike baseAxe, ItemLike baseSpear, ItemLike basePickaxe, ItemLike baseShovel, ItemLike baseHoe, 
                                              ItemLike baseHelmet, ItemLike baseChestplate, ItemLike baseLeggings, ItemLike baseBoots,
                                              Item sword, Item axe, Item spear, Item pickaxe, Item shovel, Item hoe,
                                              Item helmet, Item chestplate, Item leggings, Item boots) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseSword), Ingredient.of(material), RecipeCategory.COMBAT, sword)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(sword) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseAxe), Ingredient.of(material), RecipeCategory.TOOLS, axe)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(axe) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseSpear), Ingredient.of(material), RecipeCategory.COMBAT, spear)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(spear) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(basePickaxe), Ingredient.of(material), RecipeCategory.TOOLS, pickaxe)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(pickaxe) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseShovel), Ingredient.of(material), RecipeCategory.TOOLS, shovel)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(shovel) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseHoe), Ingredient.of(material), RecipeCategory.TOOLS, hoe)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(hoe) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseHelmet), Ingredient.of(material), RecipeCategory.COMBAT, helmet)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(helmet) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseChestplate), Ingredient.of(material), RecipeCategory.COMBAT, chestplate)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(chestplate) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseLeggings), Ingredient.of(material), RecipeCategory.COMBAT, leggings)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(leggings) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseBoots), Ingredient.of(material), RecipeCategory.COMBAT, boots)
                        .unlocks(getHasName(material), has(material)).save(output, getItemName(boots) + "_smithing");
            }
            
            private void cobbledStoneSet(RecipeOutput output,
                                         ItemLike base, ItemLike baseStair, ItemLike baseSlab, ItemLike baseWall,
                                         ItemLike smooth, ItemLike smoothStair, ItemLike smoothSlab, ItemLike smoothWall,
                                         ItemLike polished, ItemLike polishedStair, ItemLike polishedSlab, ItemLike polishedWall,
                                         ItemLike brick, ItemLike brickStair, ItemLike brickSlab, ItemLike brickWall,
                                         ItemLike chiseled, ItemLike chiseledBrick, ItemLike pillar,
                                         ItemLike cobble, ItemLike cobbleStair, ItemLike cobbleSlab, ItemLike cobbleWall,
                                         ItemLike tile, ItemLike tileStair, ItemLike tileSlab, ItemLike tileWall) {
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
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled).define('#', polishedSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(polishedSlab), has(polishedSlab)).save(output, shapedId(chiseled));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick).define('#', brickSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brickSlab), has(brickSlab)).save(output, shapedId(chiseledBrick));
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
                                  ItemLike base, ItemLike baseStair, ItemLike baseSlab, ItemLike baseWall,
                                  ItemLike smooth, ItemLike smoothStair, ItemLike smoothSlab, ItemLike smoothWall,
                                  ItemLike polished, ItemLike polishedStair, ItemLike polishedSlab, ItemLike polishedWall,
                                  ItemLike brick, ItemLike brickStair, ItemLike brickSlab, ItemLike brickWall,
                                  ItemLike chiseled, ItemLike chiseledBrick, ItemLike pillar) {

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
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled).define('#', polishedSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(polishedSlab), has(polishedSlab)).save(output, shapedId(chiseled));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick).define('#', brickSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brickSlab), has(brickSlab)).save(output, shapedId(chiseledBrick));
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

            private void sandstoneSet(RecipeOutput output,
                                  ItemLike base, ItemLike baseStair, ItemLike baseSlab, ItemLike baseWall,
                                  ItemLike smooth, ItemLike smoothStair, ItemLike smoothSlab, ItemLike smoothWall,
                                  ItemLike polished, ItemLike polishedStair, ItemLike polishedSlab, ItemLike polishedWall,
                                  ItemLike brick, ItemLike brickStair, ItemLike brickSlab, ItemLike brickWall,
                                  ItemLike cut, ItemLike cutStair, ItemLike cutSlab, ItemLike cutWall,
                                  ItemLike chiseled) {

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

                // Cut
                shaped(RecipeCategory.BUILDING_BLOCKS, cut, 4).define('#', polished).pattern("##")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(cut));
                shaped(RecipeCategory.BUILDING_BLOCKS, cutStair, 6).define('#', cut).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(cut), has(cut)).save(output, shapedId(cutStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, cutSlab, 6).define('#', cut).pattern("###")
                        .unlockedBy(getHasName(cut), has(cut)).save(output, shapedId(cutSlab));
                shaped(RecipeCategory.BUILDING_BLOCKS, cutWall, 6).define('#', cut).pattern("###").pattern("###")
                        .unlockedBy(getHasName(cut), has(cut)).save(output, shapedId(cutWall));

                // Chiseled
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled).define('#', polishedSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(polishedSlab), has(polishedSlab)).save(output, shapedId(chiseled));

                smeltingResultFromBase(smooth, base);

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, baseStair, baseWall,
                                smooth, smoothStair, smoothWall,
                                polished, polishedStair, polishedWall,
                                brick, brickStair, brickWall,
                                cut, cutStair, cutWall,
                                chiseled
                        ),
                        List.of(baseSlab, smoothSlab, polishedSlab, brickSlab, cutSlab)
                );
            }

            private void basaltSet(RecipeOutput output,
                                  ItemLike base, ItemLike baseSlab, ItemLike smooth, ItemLike smoothStair,
                                  ItemLike smoothSlab, ItemLike smoothWall, ItemLike polished, ItemLike polishedSlab,
                                  ItemLike brick, ItemLike brickStair, ItemLike brickSlab, ItemLike brickWall,
                                  ItemLike chiseled, ItemLike chiseledBrick) {

                // Base
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(output, shapedId(baseSlab));

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
                shaped(RecipeCategory.BUILDING_BLOCKS, polishedSlab, 6).define('#', polished).pattern("###")
                        .unlockedBy(getHasName(polished), has(polished)).save(output, shapedId(polishedSlab));

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
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled).define('#', polishedSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(polishedSlab), has(polishedSlab)).save(output, shapedId(chiseled));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBrick).define('#', brickSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brickSlab), has(brickSlab)).save(output, shapedId(chiseledBrick));

                smeltingResultFromBase(smooth, base);

                // Stonecutter
                stonecutterSet(output,
                        List.of(base, polished,
                                smooth, smoothStair, smoothWall,
                                brick, brickStair, brickWall,
                                chiseled, chiseledBrick
                        ),
                        List.of(baseSlab, smoothSlab, polishedSlab, brickSlab)
                );
            }


            private void quartzSet(RecipeOutput output,
                                   ItemLike base, ItemLike baseStair, ItemLike baseSlab,
                                   ItemLike brick, ItemLike brickStair, ItemLike brickSlab,
                                   ItemLike pillar, ItemLike chiseled) {

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
                                   ItemLike base, ItemLike baseStair, ItemLike baseSlab,
                                   ItemLike pillar, ItemLike chiseled) {

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

            private void woodSet(RecipeOutput output,
                                   ItemLike planks, ItemLike plankStair, ItemLike plankSlab,
                                 ItemLike mosaic, ItemLike mosaicStair, ItemLike mosaicSlab,
                                 ItemLike boards, ItemLike trim) {

                // Shaped
                shaped(RecipeCategory.BUILDING_BLOCKS, plankStair, 6).define('#', planks).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(output, shapedId(plankStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, plankSlab, 6).define('#', planks).pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(output, shapedId(plankSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, mosaic, 4).define('#', planks).pattern("##").pattern("##")
                        .unlockedBy(getHasName(planks), has(planks)).save(output, shapedId(mosaic));
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicStair, 6).define('#', mosaic).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(output, shapedId(mosaicStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicSlab, 6).define('#', mosaic).pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(output, shapedId(mosaicSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, boards).define('#', plankSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(output, shapedId(boards));
                shaped(RecipeCategory.BUILDING_BLOCKS, trim, 3).define('#', plankSlab).pattern("###").pattern("###")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(output, shapedId(trim));
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
                        if (input == result) continue;

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
                                .unlockedBy(getHasName(input), has(input))
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