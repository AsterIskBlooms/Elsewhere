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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.Nullable;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.EItems;
import team.lookingglass.elsewhere.registry.tags.EItemTags;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ERecipeProvider extends FabricRecipeProvider {

    public ERecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
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

                shaped(RecipeCategory.COMBAT, Items.STONE_SWORD, 1).pattern("#").pattern("#").pattern("S")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, Items.STONE_AXE, 1).pattern("##").pattern("#S").pattern(" S")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shaped(RecipeCategory.COMBAT, Items.STONE_SPEAR, 1).pattern("  #").pattern(" S ").pattern("S  ")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, Items.STONE_PICKAXE, 1).pattern("###").pattern(" S ").pattern(" S ")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, Items.STONE_SHOVEL, 1).pattern("#").pattern("S").pattern("S")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, Items.STONE_HOE, 1).pattern("##").pattern(" S").pattern(" S")
                        .define('#', EBlocks.PEBBLE).define('S', Items.STICK)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);

                fullCookingBook(EItems.RAW_PERCH, EItems.COOKED_PERCH);

                shapeless(RecipeCategory.MISC, EItems.DIAMOND_NUGGET, 9).requires(Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(wrappedOutput);
                shapeless(RecipeCategory.MISC, Items.DIAMOND).requires(EItems.DIAMOND_NUGGET, 9)
                        .unlockedBy(getHasName(EItems.DIAMOND_NUGGET), has(EItems.DIAMOND_NUGGET)).save(wrappedOutput);

                shapeless(RecipeCategory.MISC, EItems.EMERALD_NUGGET, 9).requires(Items.EMERALD)
                        .unlockedBy(getHasName(Items.EMERALD), has(Items.EMERALD)).save(wrappedOutput);
                shapeless(RecipeCategory.MISC, Items.EMERALD).requires(EItems.EMERALD_NUGGET, 9)
                        .unlockedBy(getHasName(EItems.EMERALD_NUGGET), has(EItems.EMERALD_NUGGET)).save(wrappedOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE, 1).pattern("##").pattern("##").define('#', EBlocks.PEBBLE)
                        .unlockedBy(getHasName(EBlocks.PEBBLE), has(EBlocks.PEBBLE)).save(wrappedOutput);
                shapeless(RecipeCategory.MISC, EBlocks.PEBBLE).requires(Blocks.COBBLESTONE, 4)
                        .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE)).save(wrappedOutput);

                // Tin
                itemFullSmeltableNBSet(0.7F,
                        EBlocks.TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.DEEPSLATE_TIN_ORE, EBlocks.CINNABAR_TIN_ORE, EItems.RAW_TIN,
                        EItems.TIN_INGOT, EItems.TIN_NUGGET, EBlocks.RAW_TIN_BLOCK, EBlocks.TIN_BLOCK
                );
                recipe2x2t1(EItems.TIN_INGOT, EBlocks.CUT_TIN);
                recipeStairSlab(EBlocks.CUT_TIN, EBlocks.CUT_TIN_STAIRS, EBlocks.CUT_TIN_SLAB);
                recipe2x1t1(EBlocks.CUT_TIN, EBlocks.CHISELED_TIN);
                stonecutterSet(List.of(EBlocks.CUT_TIN, EBlocks.CUT_TIN_STAIRS), List.of(EBlocks.CUT_TIN_SLAB));
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.TIN_BARS, 16).define('#', EItems.TIN_INGOT)
                        .pattern("###").pattern("###")
                        .unlockedBy(getHasName(EItems.TIN_INGOT), has(EItems.TIN_INGOT)).save(wrappedOutput);

                // Bronze
                shapeless(RecipeCategory.MISC, EItems.BRONZE_INGOT).requires(Items.COPPER_INGOT, 5).requires(EItems.TIN_INGOT, 4)
                        .unlockedBy(getHasName(EItems.TIN_INGOT), has(EItems.TIN_INGOT)).save(wrappedOutput);
                itemUnsmeltableNBSet(EItems.BRONZE_INGOT, EItems.BRONZE_NUGGET, EBlocks.BRONZE_BLOCK);
                shaped(RecipeCategory.MISC, EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE).define('#', EItems.TIN_INGOT).define('C', Blocks.STONE).define('T', EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE)
                        .pattern("#T#").pattern("#C#").pattern("###")
                        .unlockedBy(getHasName(EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE), has(EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE)).save(wrappedOutput);
                equipmentSetSmithing(
                        EItems.BRONZE_INGOT, EItems.BRONZE_UPGRADE_SMITHING_TEMPLATE,

                        Items.IRON_SWORD, Items.IRON_AXE, Items.IRON_SPEAR, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_HOE,
                        Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS,
                        
                        EItems.BRONZE_SWORD, EItems.BRONZE_AXE, EItems.BRONZE_SPEAR, EItems.BRONZE_PICKAXE, EItems.BRONZE_SHOVEL, EItems.BRONZE_HOE,
                        EItems.BRONZE_HELMET, EItems.BRONZE_CHESTPLATE, EItems.BRONZE_LEGGINGS, EItems.BRONZE_BOOTS,

                        EItems.BRONZE_NUGGET
                );

                // Silver
                itemFullSmeltableNBSet(1.0F,
                        EBlocks.SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE, EItems.RAW_SILVER,
                        EItems.SILVER_INGOT, EItems.SILVER_NUGGET, EBlocks.RAW_SILVER_BLOCK, EBlocks.SILVER_BLOCK
                );
                recipe2x2t1(EItems.SILVER_INGOT, EBlocks.POLISHED_SILVER);
                recipeStairSlab(EBlocks.POLISHED_SILVER, EBlocks.POLISHED_SILVER_STAIRS, EBlocks.POLISHED_SILVER_SLAB);
                recipe2x2(EBlocks.POLISHED_SILVER, EBlocks.CUT_SILVER);
                recipeStairSlab(EBlocks.CUT_SILVER, EBlocks.CUT_SILVER_STAIRS, EBlocks.CUT_SILVER_SLAB);
                recipe2x1t2(EBlocks.CUT_SILVER, EBlocks.SILVER_PILLAR);
                stonecutterSet(List.of(EBlocks.POLISHED_SILVER, EBlocks.POLISHED_SILVER_STAIRS, EBlocks.CUT_SILVER, EBlocks.CUT_SILVER_STAIRS, EBlocks.SILVER_PILLAR), List.of(EBlocks.POLISHED_SILVER_SLAB, EBlocks.CUT_SILVER_SLAB));
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.SILVER_BARS, 16).define('#', EItems.SILVER_INGOT)
                        .pattern("###").pattern("###")
                        .unlockedBy(getHasName(EItems.SILVER_INGOT), has(EItems.SILVER_INGOT)).save(wrappedOutput);

                // Wrought Iron
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.WROUGHT_IRON_BLOCK).define('#', Items.IRON_INGOT)
                        .pattern("##").pattern("##")
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.WROUGHT_IRON_GRATE, 2).define('#', Items.IRON_INGOT)
                        .pattern("###").pattern("# #").pattern("###")
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(wrappedOutput);
                recipeStairSlab(EBlocks.WROUGHT_IRON_BLOCK, EBlocks.WROUGHT_IRON_STAIRS, EBlocks.WROUGHT_IRON_SLAB);
                recipe2x2(EBlocks.WROUGHT_IRON_BLOCK, EBlocks.CUT_WROUGHT_IRON);
                recipeStairSlab(EBlocks.CUT_WROUGHT_IRON, EBlocks.CUT_WROUGHT_IRON_STAIRS, EBlocks.CUT_WROUGHT_IRON_SLAB);
                stonecutterSet(List.of(EBlocks.WROUGHT_IRON_BLOCK, EBlocks.WROUGHT_IRON_STAIRS, EBlocks.CUT_WROUGHT_IRON, EBlocks.CUT_WROUGHT_IRON_STAIRS, EBlocks.WROUGHT_IRON_GRATE), List.of(EBlocks.WROUGHT_IRON_SLAB, EBlocks.CUT_WROUGHT_IRON_SLAB));

                // Mixes
                shapeless(RecipeCategory.MISC, EItems.SOULSTEEL_INGOT)
                        .requires(Items.NETHERITE_SCRAP, 2).requires(EItems.SILVER_INGOT, 2).requires(Items.QUARTZ, 5)
                        .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP)).save(wrappedOutput);

                // Soulsteel
                itemUnsmeltableBSet(EItems.SOULSTEEL_INGOT, EBlocks.SOULSTEEL_BLOCK);
                equipmentSetSmithing(
                        EItems.SOULSTEEL_INGOT, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,

                        Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_SPEAR, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE,
                        Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,

                        EItems.SOULSTEEL_SWORD, EItems.SOULSTEEL_AXE, EItems.SOULSTEEL_SPEAR, EItems.SOULSTEEL_PICKAXE, EItems.SOULSTEEL_SHOVEL, EItems.SOULSTEEL_HOE,
                        EItems.SOULSTEEL_HELMET, EItems.SOULSTEEL_CHESTPLATE, EItems.SOULSTEEL_LEGGINGS, EItems.SOULSTEEL_BOOTS,

                        Items.NETHERITE_SCRAP
                );

                // Stone
                recipeStairSlabWall(Blocks.STONE, Blocks.STONE_STAIRS, Blocks.STONE_SLAB, EBlocks.STONE_WALL);
                recipe2x2(Blocks.STONE, EBlocks.POLISHED_STONE);
                recipeStairSlabWall(EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_SLAB, EBlocks.POLISHED_STONE_WALL);
                recipe2x1t1(EBlocks.POLISHED_STONE_SLAB, EBlocks.CHISELED_STONE);
                recipe2x1t2(EBlocks.POLISHED_STONE, EBlocks.STONE_PILLAR);
                recipe2x2(EBlocks.POLISHED_STONE, Blocks.STONE_BRICKS);
                recipeStairSlabWall(Blocks.STONE_BRICKS, Blocks.STONE_BRICK_STAIRS, Blocks.STONE_BRICK_SLAB, Blocks.STONE_BRICK_WALL);
                recipe2x1t1(Blocks.STONE_BRICK_SLAB, Blocks.CHISELED_STONE_BRICKS);
                recipeStairSlabWall(Blocks.SMOOTH_STONE, EBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE_SLAB, EBlocks.SMOOTH_STONE_WALL);
                recipe2x2(Blocks.COBBLESTONE, EBlocks.STONE_TILES);
                recipeStairSlabWall(EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_SLAB, EBlocks.STONE_TILE_WALL);
                stonecutterSet(List.of(Blocks.STONE, Blocks.STONE_STAIRS, EBlocks.STONE_WALL, Blocks.SMOOTH_STONE, EBlocks.SMOOTH_STONE_STAIRS, EBlocks.SMOOTH_STONE_WALL, EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_WALL, Blocks.STONE_BRICKS, Blocks.STONE_BRICK_STAIRS, Blocks.STONE_BRICK_WALL, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_WALL, EBlocks.STONE_PILLAR, EBlocks.CHISELED_STONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE_STAIRS, Blocks.COBBLESTONE_WALL), List.of(Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, EBlocks.POLISHED_STONE_SLAB, Blocks.STONE_BRICK_SLAB, EBlocks.STONE_TILE_SLAB, Blocks.COBBLESTONE_SLAB));

                // Deepslate
                recipeStairSlabWall(Blocks.DEEPSLATE, EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL);
                recipe2x2(Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
                recipeStairSlabWall(Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE_WALL);
                recipe2x1t1(Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.CHISELED_DEEPSLATE);
                recipe2x1t2(Blocks.POLISHED_DEEPSLATE, EBlocks.DEEPSLATE_PILLAR);
                recipe2x2(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
                recipeStairSlabWall(Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_BRICK_WALL);
                recipe2x1t1(Blocks.DEEPSLATE_BRICK_SLAB, EBlocks.CHISELED_DEEPSLATE_BRICKS);
                recipe2x2(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_TILES);
                recipeStairSlabWall(Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_TILE_WALL);
                stonecutterSet(List.of(Blocks.DEEPSLATE, EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_WALL, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_WALL, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE, EBlocks.CHISELED_DEEPSLATE_BRICKS, EBlocks.DEEPSLATE_PILLAR, Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_WALL, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES), List.of(EBlocks.DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_TILE_SLAB));

                // Shale
                recipeStairSlabWall(EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL);
                recipe2x2(EBlocks.SHALE, EBlocks.POLISHED_SHALE);
                recipeStairSlabWall(EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL);
                recipe2x1t1(EBlocks.POLISHED_SHALE_SLAB, EBlocks.CHISELED_SHALE);
                recipe2x1t2(EBlocks.POLISHED_SHALE, EBlocks.SHALE_PILLAR);
                recipe2x2(EBlocks.POLISHED_SHALE, EBlocks.SHALE_BRICKS);
                recipeStairSlabWall(EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL);
                recipe2x1t1(EBlocks.SHALE_BRICK_SLAB, EBlocks.CHISELED_SHALE_BRICKS);
                recipeStairSlabWall(EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL);
                recipe2x2(EBlocks.COBBLESHALE, EBlocks.SHALE_TILES);
                recipeStairSlabWall(EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL);
                stonecutterSet(List.of(EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_WALL, EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_WALL, EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_WALL, EBlocks.SHALE_PILLAR, EBlocks.CHISELED_SHALE, EBlocks.CHISELED_SHALE_BRICKS), List.of(EBlocks.SHALE_SLAB, EBlocks.POLISHED_SHALE_SLAB, EBlocks.SHALE_BRICK_SLAB));

                // Andesite
                recipeStairSlabWall(Blocks.ANDESITE, Blocks.ANDESITE_STAIRS, Blocks.ANDESITE_SLAB, Blocks.ANDESITE_WALL);
                recipe2x2(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE);
                recipeStairSlabWall(Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE_STAIRS, Blocks.POLISHED_ANDESITE_SLAB, EBlocks.POLISHED_ANDESITE_WALL);
                recipe2x1t1(Blocks.POLISHED_ANDESITE_SLAB, EBlocks.CHISELED_ANDESITE);
                recipe2x1t2(Blocks.POLISHED_ANDESITE, EBlocks.ANDESITE_PILLAR);
                recipe2x2(Blocks.POLISHED_ANDESITE, EBlocks.ANDESITE_BRICKS);
                recipeStairSlabWall(EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_SLAB, EBlocks.ANDESITE_BRICK_WALL);
                stonecutterSet(List.of(Blocks.ANDESITE, Blocks.ANDESITE_STAIRS, Blocks.ANDESITE_WALL, Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE_STAIRS, EBlocks.POLISHED_ANDESITE_WALL, EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_WALL, EBlocks.ANDESITE_PILLAR, EBlocks.CHISELED_ANDESITE), List.of(Blocks.ANDESITE_SLAB, Blocks.POLISHED_ANDESITE_SLAB, EBlocks.ANDESITE_BRICK_SLAB));

                // Granite
                recipeStairSlabWall(Blocks.GRANITE, Blocks.GRANITE_STAIRS, Blocks.GRANITE_SLAB, Blocks.GRANITE_WALL);
                recipe2x2(Blocks.GRANITE, Blocks.POLISHED_GRANITE);
                recipeStairSlabWall(Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE_STAIRS, Blocks.POLISHED_GRANITE_SLAB, EBlocks.POLISHED_GRANITE_WALL);
                recipe2x1t1(Blocks.POLISHED_GRANITE_SLAB, EBlocks.CHISELED_GRANITE);
                recipe2x2(Blocks.POLISHED_GRANITE, EBlocks.GRANITE_BRICKS);
                recipeStairSlabWall(EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_SLAB, EBlocks.GRANITE_BRICK_WALL);
                stonecutterSet(List.of(Blocks.GRANITE, Blocks.GRANITE_STAIRS, Blocks.GRANITE_WALL, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE_STAIRS, EBlocks.POLISHED_GRANITE_WALL, EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_WALL, EBlocks.CHISELED_GRANITE), List.of(Blocks.GRANITE_SLAB, Blocks.POLISHED_GRANITE_SLAB, EBlocks.GRANITE_BRICK_SLAB));

                // Diorite
                recipeStairSlabWall(Blocks.DIORITE, Blocks.DIORITE_STAIRS, Blocks.DIORITE_SLAB, Blocks.DIORITE_WALL);
                recipe2x2(Blocks.DIORITE, Blocks.POLISHED_DIORITE);
                recipeStairSlabWall(Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE_STAIRS, Blocks.POLISHED_DIORITE_SLAB, EBlocks.POLISHED_DIORITE_WALL);
                recipe2x1t1(Blocks.POLISHED_DIORITE_SLAB, EBlocks.CHISELED_DIORITE);
                recipe2x2(Blocks.POLISHED_DIORITE, EBlocks.DIORITE_BRICKS);
                recipeStairSlabWall(EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_SLAB, EBlocks.DIORITE_BRICK_WALL);
                stonecutterSet(List.of(Blocks.DIORITE, Blocks.DIORITE_STAIRS, Blocks.DIORITE_WALL, Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE_STAIRS, EBlocks.POLISHED_DIORITE_WALL, EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_WALL, EBlocks.CHISELED_DIORITE), List.of(Blocks.DIORITE_SLAB, Blocks.POLISHED_DIORITE_SLAB, EBlocks.DIORITE_BRICK_SLAB));

                // Tuff
                recipeStairSlabWall(Blocks.TUFF, Blocks.TUFF_STAIRS, Blocks.TUFF_SLAB, Blocks.TUFF_WALL);
                recipe2x2(Blocks.TUFF, Blocks.POLISHED_TUFF);
                recipeStairSlabWall(Blocks.POLISHED_TUFF, Blocks.POLISHED_TUFF_STAIRS, Blocks.POLISHED_TUFF_SLAB, Blocks.POLISHED_TUFF_WALL);
                recipe2x1t1(Blocks.POLISHED_TUFF_SLAB, Blocks.CHISELED_TUFF);
                recipe2x1t2(Blocks.POLISHED_TUFF, EBlocks.TUFF_PILLAR);
                recipe2x2(Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
                recipeStairSlabWall(Blocks.TUFF_BRICKS, Blocks.TUFF_BRICK_STAIRS, Blocks.TUFF_BRICK_SLAB, Blocks.TUFF_BRICK_WALL);
                recipe2x1t1(Blocks.TUFF_BRICK_SLAB, Blocks.CHISELED_TUFF_BRICKS);
                stonecutterSet(List.of(Blocks.TUFF, Blocks.TUFF_STAIRS, Blocks.TUFF_WALL, Blocks.POLISHED_TUFF, Blocks.POLISHED_TUFF_STAIRS, Blocks.POLISHED_TUFF_WALL, Blocks.TUFF_BRICKS, Blocks.TUFF_BRICK_STAIRS, Blocks.TUFF_BRICK_WALL, EBlocks.TUFF_PILLAR, Blocks.CHISELED_TUFF), List.of(Blocks.TUFF_SLAB, Blocks.POLISHED_TUFF_SLAB, Blocks.TUFF_BRICK_SLAB));

                // Calcite
                recipeStairSlabWall(Blocks.CALCITE, EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_SLAB, EBlocks.CALCITE_WALL);
                recipe2x2(Blocks.CALCITE, EBlocks.POLISHED_CALCITE);
                recipeStairSlabWall(EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.POLISHED_CALCITE_WALL);
                recipe2x1t1(EBlocks.POLISHED_CALCITE_SLAB, EBlocks.CHISELED_CALCITE);
                recipe2x1t2(EBlocks.POLISHED_CALCITE, EBlocks.CALCITE_PILLAR);
                recipe2x2(EBlocks.POLISHED_CALCITE, EBlocks.CALCITE_BRICKS);
                recipeStairSlabWall(EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_SLAB, EBlocks.CALCITE_BRICK_WALL);
                recipe2x1t1(EBlocks.CALCITE_BRICK_SLAB, EBlocks.CHISELED_CALCITE_BRICKS);
                stonecutterSet(List.of(Blocks.CALCITE, EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_WALL, EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_WALL, EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_WALL, EBlocks.CALCITE_PILLAR, EBlocks.CHISELED_CALCITE, EBlocks.CHISELED_CALCITE_BRICKS), List.of(EBlocks.CALCITE_SLAB, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.CALCITE_BRICK_SLAB));

                // Dripstone
                recipeStairSlabWall(Blocks.DRIPSTONE_BLOCK, EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_SLAB, EBlocks.DRIPSTONE_WALL);
                recipe2x2(Blocks.DRIPSTONE_BLOCK, EBlocks.POLISHED_DRIPSTONE);
                recipeStairSlabWall(EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_WALL);
                recipe2x1t2(EBlocks.POLISHED_DRIPSTONE, EBlocks.DRIPSTONE_PILLAR);
                recipe2x2(EBlocks.POLISHED_DRIPSTONE, EBlocks.DRIPSTONE_TILES);
                recipeStairSlabWall(EBlocks.DRIPSTONE_TILES, EBlocks.DRIPSTONE_TILE_STAIRS, EBlocks.DRIPSTONE_TILE_SLAB, EBlocks.DRIPSTONE_TILE_WALL);
                recipe2x1t1(EBlocks.DRIPSTONE_TILE_SLAB, EBlocks.CHISELED_DRIPSTONE_TILES);
                stonecutterSet(List.of(Blocks.DRIPSTONE_BLOCK, EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_WALL, EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_WALL, EBlocks.DRIPSTONE_TILES, EBlocks.DRIPSTONE_TILE_STAIRS, EBlocks.DRIPSTONE_TILE_WALL, EBlocks.DRIPSTONE_PILLAR, EBlocks.CHISELED_DRIPSTONE_TILES), List.of(EBlocks.DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.DRIPSTONE_TILE_SLAB));

                // Blackstone
                recipeStairSlabWall(Blocks.BLACKSTONE, Blocks.BLACKSTONE_STAIRS, Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE_WALL);
                recipe2x1t2(Blocks.BLACKSTONE, EBlocks.BLACKSTONE_PILLAR);
                recipe2x2(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
                recipeStairSlabWall(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_STAIRS, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_WALL);
                recipe2x1t1(Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.CHISELED_POLISHED_BLACKSTONE);
                recipe2x2(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
                recipeStairSlabWall(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_WALL);
                stonecutterSet(List.of(Items.BLACKSTONE, Items.BLACKSTONE_STAIRS, Items.BLACKSTONE_WALL, Items.POLISHED_BLACKSTONE, Items.POLISHED_BLACKSTONE_STAIRS, Items.POLISHED_BLACKSTONE_WALL, Items.POLISHED_BLACKSTONE_BRICKS, Items.POLISHED_BLACKSTONE_BRICK_STAIRS, Items.POLISHED_BLACKSTONE_BRICK_WALL, EBlocks.BLACKSTONE_PILLAR, Items.CHISELED_POLISHED_BLACKSTONE), List.of(Items.BLACKSTONE_SLAB, Items.POLISHED_BLACKSTONE_SLAB, Items.POLISHED_BLACKSTONE_BRICK_SLAB));

                // Prismarine
                recipeStairSlabWall(Blocks.PRISMARINE, Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_WALL);
                recipe2x2(Blocks.PRISMARINE, EBlocks.POLISHED_PRISMARINE);
                recipeStairSlabWall(EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_WALL);
                recipe2x1t1(EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.CHISELED_PRISMARINE);
                recipe2x1t2(EBlocks.POLISHED_PRISMARINE, EBlocks.PRISMARINE_PILLAR);
                recipe2x2(EBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS);
                recipeStairSlabWall(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.PRISMARINE_BRICK_SLAB, EBlocks.PRISMARINE_BRICK_WALL);
                stonecutterSet(List.of(Blocks.PRISMARINE, Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_WALL, EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_WALL, Blocks.PRISMARINE_BRICKS, EBlocks.PRISMARINE_BRICK_WALL, EBlocks.PRISMARINE_PILLAR, EBlocks.CHISELED_PRISMARINE), List.of(Blocks.PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_SLAB));

                // Dark Prismarine
                recipeStairSlabWall(Blocks.DARK_PRISMARINE, Blocks.DARK_PRISMARINE_STAIRS, Blocks.DARK_PRISMARINE_SLAB, EBlocks.DARK_PRISMARINE_WALL);
                recipe2x2(Blocks.DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE);
                recipeStairSlabWall(EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_WALL);
                recipe2x1t1(EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.CHISELED_DARK_PRISMARINE);
                recipe2x2(EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.DARK_PRISMARINE_SCALES);
                recipeStairSlabWall(EBlocks.DARK_PRISMARINE_SCALES, EBlocks.DARK_PRISMARINE_SCALE_STAIRS, EBlocks.DARK_PRISMARINE_SCALE_SLAB, EBlocks.DARK_PRISMARINE_SCALE_WALL);
                stonecutterSet(List.of(Blocks.DARK_PRISMARINE, Items.DARK_PRISMARINE_STAIRS, EBlocks.DARK_PRISMARINE_WALL, EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_WALL, EBlocks.DARK_PRISMARINE_SCALES, EBlocks.DARK_PRISMARINE_SCALE_STAIRS, EBlocks.DARK_PRISMARINE_SCALE_WALL, EBlocks.CHISELED_DARK_PRISMARINE), List.of(Items.DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.DARK_PRISMARINE_SCALE_SLAB));

                // Netherrack
                recipeStairSlabWall(Blocks.NETHERRACK, EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_SLAB, EBlocks.NETHERRACK_WALL);
                recipe2x2(Blocks.NETHERRACK, EBlocks.POLISHED_NETHERRACK);
                recipeStairSlabWall(EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_WALL);
                recipe2x1t1(EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.CHISELED_NETHERRACK);
                recipe2x1t2(EBlocks.POLISHED_NETHERRACK, EBlocks.NETHERRACK_PILLAR);
                recipe2x2(EBlocks.POLISHED_NETHERRACK, EBlocks.NETHERRACK_BRICKS);
                recipeStairSlabWall(EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.NETHERRACK_BRICK_WALL);
                recipe2x1t1(EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.CHISELED_NETHERRACK_BRICKS);
                stonecutterSet(List.of(Blocks.NETHERRACK, EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_WALL, EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_WALL, EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_WALL, EBlocks.NETHERRACK_PILLAR, EBlocks.CHISELED_NETHERRACK, EBlocks.CHISELED_NETHERRACK_BRICKS), List.of(EBlocks.NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.NETHERRACK_BRICK_SLAB));

                // End Stone
                recipeStairSlabWall(Blocks.END_STONE, EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_SLAB, EBlocks.END_STONE_WALL);
                recipe2x2(Blocks.END_STONE, EBlocks.POLISHED_END_STONE);
                recipeStairSlabWall(EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_SLAB, EBlocks.POLISHED_END_STONE_WALL);
                recipe2x1t1(EBlocks.POLISHED_END_STONE_SLAB, EBlocks.CHISELED_END_STONE);
                recipe2x1t2(EBlocks.POLISHED_END_STONE, EBlocks.END_STONE_PILLAR);
                recipe2x2(EBlocks.POLISHED_END_STONE, Blocks.END_STONE_BRICKS);
                recipeStairSlabWall(Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICK_WALL);
                stonecutterSet(List.of(Blocks.END_STONE, EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_WALL, EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_WALL, Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICK_WALL, EBlocks.END_STONE_PILLAR, EBlocks.CHISELED_END_STONE), List.of(EBlocks.END_STONE_SLAB, EBlocks.POLISHED_END_STONE_SLAB, Blocks.END_STONE_BRICK_SLAB));

                // Sodalite
                recipeStairSlabWall(EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_SLAB, EBlocks.SODALITE_WALL);
                recipe2x2(EBlocks.SODALITE, EBlocks.POLISHED_SODALITE);
                recipeStairSlabWall(EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.POLISHED_SODALITE_WALL);
                recipe2x1t1(EBlocks.POLISHED_SODALITE_SLAB, EBlocks.CHISELED_SODALITE);
                recipe2x1t2(EBlocks.POLISHED_SODALITE, EBlocks.SODALITE_PILLAR);
                recipe2x2(EBlocks.POLISHED_SODALITE, EBlocks.SODALITE_BRICKS);
                recipeStairSlabWall(EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_SLAB, EBlocks.SODALITE_BRICK_WALL);
                recipe2x1t1(EBlocks.SODALITE_BRICK_SLAB, EBlocks.CHISELED_SODALITE_BRICKS);
                stonecutterSet(List.of(EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_WALL, EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_WALL, EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_WALL, EBlocks.SODALITE_PILLAR, EBlocks.CHISELED_SODALITE, EBlocks.CHISELED_SODALITE_BRICKS), List.of(EBlocks.SODALITE_SLAB, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.SODALITE_BRICK_SLAB));

                // Sulfur
                recipeStairSlabWall(EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_SLAB, EBlocks.SULFUR_WALL);
                recipe2x2(EBlocks.SULFUR, EBlocks.POLISHED_SULFUR);
                recipeStairSlabWall(EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.POLISHED_SULFUR_WALL);
                recipe2x1t1(EBlocks.POLISHED_SULFUR_SLAB, EBlocks.CHISELED_SULFUR);
                recipe2x1t2(EBlocks.POLISHED_SULFUR, EBlocks.SULFUR_PILLAR);
                recipe2x2(EBlocks.POLISHED_SULFUR, EBlocks.SULFUR_BRICKS);
                recipeStairSlabWall(EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_SLAB, EBlocks.SULFUR_BRICK_WALL);
                stonecutterSet(List.of(EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_WALL, EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_WALL, EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_WALL, EBlocks.SULFUR_PILLAR, EBlocks.CHISELED_SULFUR), List.of(EBlocks.SULFUR_SLAB, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.SULFUR_BRICK_SLAB));
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.POTENT_SULFUR, 3).define('C', EItems.SULFUR_CREAM).define('#', EBlocks.SULFUR)
                        .pattern(" # ").pattern("#C#").pattern(" # ")
                        .unlockedBy(getHasName(EItems.SULFUR_CREAM), has(EItems.SULFUR_CREAM)).save(wrappedOutput);

                // Orpiment
                shapeless(RecipeCategory.BUILDING_BLOCKS, EBlocks.ORPIMENT, 3).requires(EBlocks.SULFUR, 2).requires(EBlocks.CINNABAR)
                        .unlockedBy(getHasName(EBlocks.SULFUR), has(EBlocks.SULFUR)).save(wrappedOutput);
                recipeStairSlabWall(EBlocks.ORPIMENT, EBlocks.ORPIMENT_STAIRS, EBlocks.ORPIMENT_SLAB, EBlocks.ORPIMENT_WALL);
                recipe2x2(EBlocks.ORPIMENT, EBlocks.POLISHED_ORPIMENT);
                recipeStairSlabWall(EBlocks.POLISHED_ORPIMENT, EBlocks.POLISHED_ORPIMENT_STAIRS, EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.POLISHED_ORPIMENT_WALL);
                recipe2x1t1(EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.CHISELED_ORPIMENT);
                recipe2x1t2(EBlocks.POLISHED_ORPIMENT, EBlocks.ORPIMENT_PILLAR);
                recipe2x2(EBlocks.POLISHED_ORPIMENT, EBlocks.ORPIMENT_BRICKS);
                recipeStairSlabWall(EBlocks.ORPIMENT_BRICKS, EBlocks.ORPIMENT_BRICK_STAIRS, EBlocks.ORPIMENT_BRICK_SLAB, EBlocks.ORPIMENT_BRICK_WALL);
                stonecutterSet(List.of(EBlocks.ORPIMENT, EBlocks.ORPIMENT_STAIRS, EBlocks.ORPIMENT_WALL, EBlocks.POLISHED_ORPIMENT, EBlocks.POLISHED_ORPIMENT_STAIRS, EBlocks.POLISHED_ORPIMENT_WALL, EBlocks.ORPIMENT_BRICKS, EBlocks.ORPIMENT_BRICK_STAIRS, EBlocks.ORPIMENT_BRICK_WALL, EBlocks.ORPIMENT_PILLAR, EBlocks.CHISELED_ORPIMENT), List.of(EBlocks.ORPIMENT_SLAB, EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.ORPIMENT_BRICK_SLAB));

                // Cinnabar
                recipeStairSlabWall(EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_SLAB, EBlocks.CINNABAR_WALL);
                recipe2x2(EBlocks.CINNABAR, EBlocks.POLISHED_CINNABAR);
                recipeStairSlabWall(EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_WALL);
                recipe2x1t1(EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.CHISELED_CINNABAR);
                recipe2x1t2(EBlocks.POLISHED_CINNABAR, EBlocks.CINNABAR_PILLAR);
                recipe2x2(EBlocks.POLISHED_CINNABAR, EBlocks.CINNABAR_BRICKS);
                recipeStairSlabWall(EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_SLAB, EBlocks.CINNABAR_BRICK_WALL);
                stonecutterSet(List.of(EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_WALL, EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_WALL, EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_WALL, EBlocks.CINNABAR_PILLAR, EBlocks.CHISELED_CINNABAR), List.of(EBlocks.CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.CINNABAR_BRICK_SLAB));

                // Basalt
                recipeStairSlabWall(Blocks.SMOOTH_BASALT, EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL);
                recipe2x2(Blocks.SMOOTH_BASALT, EBlocks.POLISHED_SMOOTH_BASALT);
                recipeStairSlabWall(EBlocks.POLISHED_SMOOTH_BASALT, EBlocks.POLISHED_SMOOTH_BASALT_STAIRS, EBlocks.POLISHED_SMOOTH_BASALT_SLAB, EBlocks.POLISHED_SMOOTH_BASALT_WALL);
                recipe2x2(EBlocks.POLISHED_SMOOTH_BASALT, EBlocks.SMOOTH_BASALT_BRICKS);
                recipeStairSlabWall(EBlocks.SMOOTH_BASALT_BRICKS, EBlocks.SMOOTH_BASALT_BRICK_STAIRS, EBlocks.SMOOTH_BASALT_BRICK_SLAB, EBlocks.SMOOTH_BASALT_BRICK_WALL);
                recipe2x1t1(EBlocks.SMOOTH_BASALT_BRICK_SLAB, EBlocks.SMOOTH_BASALT_TILES);
                recipeStairSlabWall(EBlocks.SMOOTH_BASALT_TILES, EBlocks.SMOOTH_BASALT_TILE_STAIRS, EBlocks.SMOOTH_BASALT_TILE_SLAB, EBlocks.SMOOTH_BASALT_TILE_WALL);
                stonecutterSet(List.of(Blocks.BASALT, Blocks.POLISHED_BASALT, Blocks.SMOOTH_BASALT, EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_WALL, EBlocks.POLISHED_SMOOTH_BASALT, EBlocks.POLISHED_SMOOTH_BASALT_STAIRS, EBlocks.POLISHED_SMOOTH_BASALT_WALL, EBlocks.SMOOTH_BASALT_BRICKS, EBlocks.SMOOTH_BASALT_BRICK_STAIRS, EBlocks.SMOOTH_BASALT_BRICK_WALL, EBlocks.SMOOTH_BASALT_TILES, EBlocks.SMOOTH_BASALT_TILE_STAIRS, EBlocks.SMOOTH_BASALT_TILE_WALL), List.of(EBlocks.BASALT_SLAB, EBlocks.POLISHED_BASALT_SLAB, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.POLISHED_SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_BRICK_SLAB, EBlocks.SMOOTH_BASALT_TILE_SLAB));

                // Limestone
                shapeless(RecipeCategory.BUILDING_BLOCKS, EBlocks.LIMESTONE).requires(Blocks.CALCITE).requires(Items.QUARTZ)
                        .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ)).save(wrappedOutput);
                recipeStairSlabWall(EBlocks.LIMESTONE, EBlocks.LIMESTONE_STAIRS, EBlocks.LIMESTONE_SLAB, EBlocks.LIMESTONE_WALL);
                recipe2x2(EBlocks.LIMESTONE, EBlocks.CUT_LIMESTONE);
                recipeStairSlabWall(EBlocks.CUT_LIMESTONE, EBlocks.CUT_LIMESTONE_STAIRS, EBlocks.CUT_LIMESTONE_SLAB, EBlocks.CUT_LIMESTONE_WALL);

                // Beachstone
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.BEACHSTONE, 3).define('S', Blocks.SAND).define('#', EBlocks.LIMESTONE)
                        .pattern("#S").pattern("S#")
                        .unlockedBy(getHasName(EBlocks.LIMESTONE), has(EBlocks.LIMESTONE)).save(wrappedOutput);
                recipeStairSlabWall(EBlocks.BEACHSTONE, EBlocks.BEACHSTONE_STAIRS, EBlocks.BEACHSTONE_SLAB, EBlocks.BEACHSTONE_WALL);
                recipe2x2(EBlocks.BEACHSTONE, EBlocks.POLISHED_BEACHSTONE);
                recipeStairSlabWall(EBlocks.POLISHED_BEACHSTONE, EBlocks.POLISHED_BEACHSTONE_STAIRS, EBlocks.POLISHED_BEACHSTONE_SLAB, EBlocks.POLISHED_BEACHSTONE_WALL);
                recipe2x2(EBlocks.POLISHED_BEACHSTONE, EBlocks.BEACHSTONE_BRICKS);
                recipeStairSlabWall(EBlocks.BEACHSTONE_BRICKS, EBlocks.BEACHSTONE_BRICK_STAIRS, EBlocks.BEACHSTONE_BRICK_SLAB, EBlocks.BEACHSTONE_BRICK_WALL);
                recipe2x1t1(EBlocks.POLISHED_BEACHSTONE_SLAB, EBlocks.CHISELED_BEACHSTONE);

                // Mudstone
                shapeless(RecipeCategory.BUILDING_BLOCKS, EBlocks.MUDSTONE).requires(Blocks.MUD).requires(EBlocks.COBBLESHALE)
                        .unlockedBy(getHasName(Blocks.MUD), has(Blocks.MUD)).save(wrappedOutput);




                quartzSet(
                        Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_STAIRS, Blocks.QUARTZ_SLAB,
                        Blocks.QUARTZ_BRICKS, EBlocks.QUARTZ_BRICK_STAIRS, EBlocks.QUARTZ_BRICK_SLAB,
                        Blocks.QUARTZ_PILLAR, Blocks.CHISELED_QUARTZ_BLOCK
                );
                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BUDDING_AMETHYST)
                        .define('S', EBlocks.SODALITE).define('C', Blocks.CALCITE).define('#', Blocks.AMETHYST_BLOCK)
                        .pattern("#S#").pattern("C#C").pattern("#S#")
                        .unlockedBy(getHasName(Blocks.AMETHYST_BLOCK), has(Blocks.AMETHYST_BLOCK)).save(wrappedOutput);
                quartzSet(
                        Blocks.AMETHYST_BLOCK, EBlocks.AMETHYST_STAIRS, EBlocks.AMETHYST_SLAB,
                        EBlocks.AMETHYST_BRICKS, EBlocks.AMETHYST_BRICK_STAIRS, EBlocks.AMETHYST_BRICK_SLAB,
                        EBlocks.AMETHYST_PILLAR, EBlocks.CHISELED_AMETHYST
                );
                quartzSet(
                        Blocks.OBSIDIAN, EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB,
                        EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB,
                        EBlocks.OBSIDIAN_PILLAR, EBlocks.CHISELED_OBSIDIAN
                );

                purpurSet(
                        Blocks.PURPUR_BLOCK, Blocks.PURPUR_STAIRS, Blocks.PURPUR_SLAB,
                        Blocks.PURPUR_PILLAR, EBlocks.CHISELED_PURPUR
                );

                // Wood
                fullWoodSet(
                        EBlocks.POPLAR_LOG, EBlocks.STRIPPED_POPLAR_LOG, EBlocks.POPLAR_WOOD, EBlocks.STRIPPED_POPLAR_WOOD, EItemTags.POPLAR_LOGS,
                        EBlocks.POPLAR_PLANKS, EBlocks.POPLAR_STAIRS, EBlocks.POPLAR_SLAB,
                        EBlocks.POPLAR_MOSAIC, EBlocks.POPLAR_MOSAIC_STAIRS, EBlocks.POPLAR_MOSAIC_SLAB,
                        EBlocks.POPLAR_BOARDS, EBlocks.POPLAR_TRIM,
                        EBlocks.POPLAR_FENCE, EBlocks.POPLAR_FENCE_GATE, EBlocks.POPLAR_DOOR, EBlocks.POPLAR_TRAPDOOR,
                        EBlocks.POPLAR_PRESSURE_PLATE, EBlocks.POPLAR_BUTTON, EItems.POPLAR_SIGN, EItems.POPLAR_HANGING_SIGN,
                        EItems.POPLAR_BOAT, EBlocks.POPLAR_SHELF
                );
                fullWoodSet(
                        EBlocks.AZALEA_LOG, EBlocks.STRIPPED_AZALEA_LOG, EBlocks.AZALEA_WOOD, EBlocks.STRIPPED_AZALEA_WOOD, EItemTags.AZALEA_LOGS,
                        EBlocks.AZALEA_PLANKS, EBlocks.AZALEA_STAIRS, EBlocks.AZALEA_SLAB,
                        EBlocks.AZALEA_MOSAIC, EBlocks.AZALEA_MOSAIC_STAIRS, EBlocks.AZALEA_MOSAIC_SLAB,
                        EBlocks.AZALEA_BOARDS, EBlocks.AZALEA_TRIM,
                        EBlocks.AZALEA_FENCE, EBlocks.AZALEA_FENCE_GATE, EBlocks.AZALEA_DOOR, EBlocks.AZALEA_TRAPDOOR,
                        EBlocks.AZALEA_PRESSURE_PLATE, EBlocks.AZALEA_BUTTON, EItems.AZALEA_SIGN, EItems.AZALEA_HANGING_SIGN,
                        EItems.AZALEA_BOAT, EBlocks.AZALEA_SHELF
                );
                fullWoodSet(
                        EBlocks.CEDAR_LOG, EBlocks.STRIPPED_CEDAR_LOG, EBlocks.CEDAR_WOOD, EBlocks.STRIPPED_CEDAR_WOOD, EItemTags.CEDAR_LOGS,
                        EBlocks.CEDAR_PLANKS, EBlocks.CEDAR_STAIRS, EBlocks.CEDAR_SLAB,
                        EBlocks.CEDAR_MOSAIC, EBlocks.CEDAR_MOSAIC_STAIRS, EBlocks.CEDAR_MOSAIC_SLAB,
                        EBlocks.CEDAR_BOARDS, EBlocks.CEDAR_TRIM,
                        EBlocks.CEDAR_FENCE, EBlocks.CEDAR_FENCE_GATE, EBlocks.CEDAR_DOOR, EBlocks.CEDAR_TRAPDOOR,
                        EBlocks.CEDAR_PRESSURE_PLATE, EBlocks.CEDAR_BUTTON, EItems.CEDAR_SIGN, EItems.CEDAR_HANGING_SIGN,
                        EItems.CEDAR_BOAT, EBlocks.CEDAR_SHELF
                );
                fullWoodSet(
                        EBlocks.MAHOGANY_LOG, EBlocks.STRIPPED_MAHOGANY_LOG, EBlocks.MAHOGANY_WOOD, EBlocks.STRIPPED_MAHOGANY_WOOD, EItemTags.MAHOGANY_LOGS,
                        EBlocks.MAHOGANY_PLANKS, EBlocks.MAHOGANY_STAIRS, EBlocks.MAHOGANY_SLAB,
                        EBlocks.MAHOGANY_MOSAIC, EBlocks.MAHOGANY_MOSAIC_STAIRS, EBlocks.MAHOGANY_MOSAIC_SLAB,
                        EBlocks.MAHOGANY_BOARDS, EBlocks.MAHOGANY_TRIM,
                        EBlocks.MAHOGANY_FENCE, EBlocks.MAHOGANY_FENCE_GATE, EBlocks.MAHOGANY_DOOR, EBlocks.MAHOGANY_TRAPDOOR,
                        EBlocks.MAHOGANY_PRESSURE_PLATE, EBlocks.MAHOGANY_BUTTON, EItems.MAHOGANY_SIGN, EItems.MAHOGANY_HANGING_SIGN,
                        EItems.MAHOGANY_BOAT, EBlocks.MAHOGANY_SHELF
                );
                woodSet(
                        Blocks.OAK_PLANKS, Blocks.OAK_STAIRS, Blocks.OAK_SLAB,
                        EBlocks.OAK_MOSAIC, EBlocks.OAK_MOSAIC_STAIRS, EBlocks.OAK_MOSAIC_SLAB,
                        EBlocks.OAK_BOARDS, EBlocks.OAK_TRIM
                );
                woodSet(
                        Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_STAIRS, Blocks.DARK_OAK_SLAB,
                        EBlocks.DARK_OAK_MOSAIC, EBlocks.DARK_OAK_MOSAIC_STAIRS, EBlocks.DARK_OAK_MOSAIC_SLAB,
                        EBlocks.DARK_OAK_BOARDS, EBlocks.DARK_OAK_TRIM
                );
                woodSet(
                        Blocks.PALE_OAK_PLANKS, Blocks.PALE_OAK_STAIRS, Blocks.PALE_OAK_SLAB,
                        EBlocks.PALE_OAK_MOSAIC, EBlocks.PALE_OAK_MOSAIC_STAIRS, EBlocks.PALE_OAK_MOSAIC_SLAB,
                        EBlocks.PALE_OAK_BOARDS, EBlocks.PALE_OAK_TRIM
                );
                woodSet(
                        Blocks.BIRCH_PLANKS, Blocks.BIRCH_STAIRS, Blocks.BIRCH_SLAB,
                        EBlocks.BIRCH_MOSAIC, EBlocks.BIRCH_MOSAIC_STAIRS, EBlocks.BIRCH_MOSAIC_SLAB,
                        EBlocks.BIRCH_BOARDS, EBlocks.BIRCH_TRIM
                );
                woodSet(
                        Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_STAIRS, Blocks.SPRUCE_SLAB,
                        EBlocks.SPRUCE_MOSAIC, EBlocks.SPRUCE_MOSAIC_STAIRS, EBlocks.SPRUCE_MOSAIC_SLAB,
                        EBlocks.SPRUCE_BOARDS, EBlocks.SPRUCE_TRIM
                );
                woodSet(
                        Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_STAIRS, Blocks.JUNGLE_SLAB,
                        EBlocks.JUNGLE_MOSAIC, EBlocks.JUNGLE_MOSAIC_STAIRS, EBlocks.JUNGLE_MOSAIC_SLAB,
                        EBlocks.JUNGLE_BOARDS, EBlocks.JUNGLE_TRIM
                );
                woodSet(
                        Blocks.ACACIA_PLANKS, Blocks.ACACIA_STAIRS, Blocks.ACACIA_SLAB,
                        EBlocks.ACACIA_MOSAIC, EBlocks.ACACIA_MOSAIC_STAIRS, EBlocks.ACACIA_MOSAIC_SLAB,
                        EBlocks.ACACIA_BOARDS, EBlocks.ACACIA_TRIM
                );
                woodSet(
                        Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_STAIRS, Blocks.MANGROVE_SLAB,
                        EBlocks.MANGROVE_MOSAIC, EBlocks.MANGROVE_MOSAIC_STAIRS, EBlocks.MANGROVE_MOSAIC_SLAB,
                        EBlocks.MANGROVE_BOARDS, EBlocks.MANGROVE_TRIM
                );
                woodSet(
                        Blocks.CHERRY_PLANKS, Blocks.CHERRY_STAIRS, Blocks.CHERRY_SLAB,
                        EBlocks.CHERRY_MOSAIC, EBlocks.CHERRY_MOSAIC_STAIRS, EBlocks.CHERRY_MOSAIC_SLAB,
                        EBlocks.CHERRY_BOARDS, EBlocks.CHERRY_TRIM
                );
                woodSet(
                        Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STAIRS, Blocks.CRIMSON_SLAB,
                        EBlocks.CRIMSON_MOSAIC, EBlocks.CRIMSON_MOSAIC_STAIRS, EBlocks.CRIMSON_MOSAIC_SLAB,
                        EBlocks.CRIMSON_BOARDS, EBlocks.CRIMSON_TRIM
                );
                woodSet(
                        Blocks.WARPED_PLANKS, Blocks.WARPED_STAIRS, Blocks.WARPED_SLAB,
                        EBlocks.WARPED_MOSAIC, EBlocks.WARPED_MOSAIC_STAIRS, EBlocks.WARPED_MOSAIC_SLAB,
                        EBlocks.WARPED_BOARDS, EBlocks.WARPED_TRIM
                );
                woodSet(
                        Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_STAIRS, Blocks.BAMBOO_SLAB,
                        Blocks.BAMBOO_MOSAIC, Blocks.BAMBOO_MOSAIC_STAIRS, Blocks.BAMBOO_MOSAIC_SLAB,
                        EBlocks.BAMBOO_BOARDS, EBlocks.BAMBOO_TRIM
                );
                shaped(RecipeCategory.BUILDING_BLOCKS, EBlocks.BAMBOO_STEM).pattern("###").pattern("###").pattern("###").define('#', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO)).save(wrappedOutput, shapedId(Items.BAMBOO));
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO).requires(EBlocks.BAMBOO_STEM)
                        .unlockedBy(getHasName(EBlocks.BAMBOO_STEM), has(EBlocks.BAMBOO_STEM)).save(wrappedOutput, shapedId(EBlocks.BAMBOO_STEM));
                shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO).requires(EBlocks.STRIPPED_BAMBOO_STEM)
                        .unlockedBy(getHasName(EBlocks.BAMBOO_STEM), has(EBlocks.BAMBOO_STEM)).save(wrappedOutput, shapedId(EBlocks.STRIPPED_BAMBOO_STEM));

                itemToDye(EBlocks.RED_HIBISCUS, Items.RED_DYE);
                itemToDye(EBlocks.ORANGE_HIBISCUS, Items.ORANGE_DYE);
                itemToDye(EBlocks.YELLOW_HIBISCUS, Items.YELLOW_DYE);
                itemToDye(EBlocks.BLUE_HIBISCUS, Items.BLUE_DYE);
                itemToDye(EBlocks.PURPLE_HIBISCUS, Items.PURPLE_DYE);
                itemToDye(EBlocks.PINK_HIBISCUS, Items.PINK_DYE);
                itemToDye(EBlocks.WHITE_HIBISCUS, Items.WHITE_DYE);

                itemToDye(EBlocks.BLUEBONNET, Items.BLUE_DYE);
                itemToDye(EBlocks.MAGENTA_CONEFLOWER, Items.MAGENTA_DYE);
                itemToDye(EBlocks.YELLOW_CONEFLOWER, Items.YELLOW_DYE);
                itemToDye(EBlocks.IRONWEED, Items.MAGENTA_DYE);
                itemToDye(EBlocks.ROSE, Items.RED_DYE);

                recipeStairSlab(Blocks.WHITE_WOOL, EBlocks.WHITE_WOOL_STAIRS, EBlocks.WHITE_WOOL_SLAB);
                recipeStairSlab(Blocks.LIGHT_GRAY_WOOL, EBlocks.LIGHT_GRAY_WOOL_STAIRS, EBlocks.LIGHT_GRAY_WOOL_SLAB);
                recipeStairSlab(Blocks.GRAY_WOOL, EBlocks.GRAY_WOOL_STAIRS, EBlocks.GRAY_WOOL_SLAB);
                recipeStairSlab(Blocks.BLACK_WOOL, EBlocks.BLACK_WOOL_STAIRS, EBlocks.BLACK_WOOL_SLAB);
                recipeStairSlab(Blocks.BROWN_WOOL, EBlocks.BROWN_WOOL_STAIRS, EBlocks.BROWN_WOOL_SLAB);
                recipeStairSlab(Blocks.RED_WOOL, EBlocks.RED_WOOL_STAIRS, EBlocks.RED_WOOL_SLAB);
                recipeStairSlab(Blocks.ORANGE_WOOL, EBlocks.ORANGE_WOOL_STAIRS, EBlocks.ORANGE_WOOL_SLAB);
                recipeStairSlab(Blocks.YELLOW_WOOL, EBlocks.YELLOW_WOOL_STAIRS, EBlocks.YELLOW_WOOL_SLAB);
                recipeStairSlab(Blocks.LIME_WOOL, EBlocks.LIME_WOOL_STAIRS, EBlocks.LIME_WOOL_SLAB);
                recipeStairSlab(Blocks.GREEN_WOOL, EBlocks.GREEN_WOOL_STAIRS, EBlocks.GREEN_WOOL_SLAB);
                recipeStairSlab(Blocks.CYAN_WOOL, EBlocks.CYAN_WOOL_STAIRS, EBlocks.CYAN_WOOL_SLAB);
                recipeStairSlab(Blocks.LIGHT_BLUE_WOOL, EBlocks.LIGHT_BLUE_WOOL_STAIRS, EBlocks.LIGHT_BLUE_WOOL_SLAB);
                recipeStairSlab(Blocks.BLUE_WOOL, EBlocks.BLUE_WOOL_STAIRS, EBlocks.BLUE_WOOL_SLAB);
                recipeStairSlab(Blocks.PURPLE_WOOL, EBlocks.PURPLE_WOOL_STAIRS, EBlocks.PURPLE_WOOL_SLAB);
                recipeStairSlab(Blocks.MAGENTA_WOOL, EBlocks.MAGENTA_WOOL_STAIRS, EBlocks.MAGENTA_WOOL_SLAB);
                recipeStairSlab(Blocks.PINK_WOOL, EBlocks.PINK_WOOL_STAIRS, EBlocks.PINK_WOOL_SLAB);

                recipeStairSlab(Blocks.TERRACOTTA, EBlocks.TERRACOTTA_STAIRS, EBlocks.TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.WHITE_TERRACOTTA, EBlocks.WHITE_TERRACOTTA_STAIRS, EBlocks.WHITE_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.LIGHT_GRAY_TERRACOTTA, EBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.GRAY_TERRACOTTA, EBlocks.GRAY_TERRACOTTA_STAIRS, EBlocks.GRAY_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.BLACK_TERRACOTTA, EBlocks.BLACK_TERRACOTTA_STAIRS, EBlocks.BLACK_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.BROWN_TERRACOTTA, EBlocks.BROWN_TERRACOTTA_STAIRS, EBlocks.BROWN_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.RED_TERRACOTTA, EBlocks.RED_TERRACOTTA_STAIRS, EBlocks.RED_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.ORANGE_TERRACOTTA, EBlocks.ORANGE_TERRACOTTA_STAIRS, EBlocks.ORANGE_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.YELLOW_TERRACOTTA, EBlocks.YELLOW_TERRACOTTA_STAIRS, EBlocks.YELLOW_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.LIME_TERRACOTTA, EBlocks.LIME_TERRACOTTA_STAIRS, EBlocks.LIME_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.GREEN_TERRACOTTA, EBlocks.GREEN_TERRACOTTA_STAIRS, EBlocks.GREEN_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.CYAN_TERRACOTTA, EBlocks.CYAN_TERRACOTTA_STAIRS, EBlocks.CYAN_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.LIGHT_BLUE_TERRACOTTA, EBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.BLUE_TERRACOTTA, EBlocks.BLUE_TERRACOTTA_STAIRS, EBlocks.BLUE_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.PURPLE_TERRACOTTA, EBlocks.PURPLE_TERRACOTTA_STAIRS, EBlocks.PURPLE_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.MAGENTA_TERRACOTTA, EBlocks.MAGENTA_TERRACOTTA_STAIRS, EBlocks.MAGENTA_TERRACOTTA_SLAB);
                recipeStairSlab(Blocks.PINK_TERRACOTTA, EBlocks.PINK_TERRACOTTA_STAIRS, EBlocks.PINK_TERRACOTTA_SLAB);

                recipe2x2(Blocks.TERRACOTTA, EBlocks.TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.TERRACOTTA_BRICKS, EBlocks.TERRACOTTA_BRICK_STAIRS,  EBlocks.TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.TERRACOTTA_BRICK_SLAB, EBlocks.TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.TERRACOTTA_BRICK_TILES, EBlocks.TERRACOTTA_BRICK_TILE_STAIRS,  EBlocks.TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.WHITE_TERRACOTTA, EBlocks.WHITE_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.WHITE_TERRACOTTA_BRICKS, EBlocks.WHITE_TERRACOTTA_BRICK_STAIRS, EBlocks.WHITE_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.WHITE_TERRACOTTA_BRICK_SLAB, EBlocks.WHITE_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.WHITE_TERRACOTTA_BRICK_TILES, EBlocks.WHITE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.WHITE_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.LIGHT_GRAY_TERRACOTTA, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILES, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.GRAY_TERRACOTTA, EBlocks.GRAY_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.GRAY_TERRACOTTA_BRICKS, EBlocks.GRAY_TERRACOTTA_BRICK_STAIRS, EBlocks.GRAY_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.GRAY_TERRACOTTA_BRICK_SLAB, EBlocks.GRAY_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.GRAY_TERRACOTTA_BRICK_TILES, EBlocks.GRAY_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.GRAY_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.BLACK_TERRACOTTA, EBlocks.BLACK_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.BLACK_TERRACOTTA_BRICKS, EBlocks.BLACK_TERRACOTTA_BRICK_STAIRS, EBlocks.BLACK_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.BLACK_TERRACOTTA_BRICK_SLAB, EBlocks.BLACK_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.BLACK_TERRACOTTA_BRICK_TILES, EBlocks.BLACK_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BLACK_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.BROWN_TERRACOTTA, EBlocks.BROWN_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.BROWN_TERRACOTTA_BRICKS, EBlocks.BROWN_TERRACOTTA_BRICK_STAIRS, EBlocks.BROWN_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.BROWN_TERRACOTTA_BRICK_SLAB, EBlocks.BROWN_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.BROWN_TERRACOTTA_BRICK_TILES, EBlocks.BROWN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BROWN_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.RED_TERRACOTTA, EBlocks.RED_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.RED_TERRACOTTA_BRICKS, EBlocks.RED_TERRACOTTA_BRICK_STAIRS, EBlocks.RED_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.RED_TERRACOTTA_BRICK_SLAB, EBlocks.RED_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.RED_TERRACOTTA_BRICK_TILES, EBlocks.RED_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.RED_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.ORANGE_TERRACOTTA, EBlocks.ORANGE_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.ORANGE_TERRACOTTA_BRICKS, EBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS, EBlocks.ORANGE_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.ORANGE_TERRACOTTA_BRICK_SLAB, EBlocks.ORANGE_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.ORANGE_TERRACOTTA_BRICK_TILES, EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.ORANGE_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.YELLOW_TERRACOTTA, EBlocks.YELLOW_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.YELLOW_TERRACOTTA_BRICKS, EBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS, EBlocks.YELLOW_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.YELLOW_TERRACOTTA_BRICK_SLAB, EBlocks.YELLOW_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.YELLOW_TERRACOTTA_BRICK_TILES, EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.YELLOW_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.LIME_TERRACOTTA, EBlocks.LIME_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.LIME_TERRACOTTA_BRICKS, EBlocks.LIME_TERRACOTTA_BRICK_STAIRS, EBlocks.LIME_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.LIME_TERRACOTTA_BRICK_SLAB, EBlocks.LIME_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.LIME_TERRACOTTA_BRICK_TILES, EBlocks.LIME_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIME_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.GREEN_TERRACOTTA, EBlocks.GREEN_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.GREEN_TERRACOTTA_BRICKS, EBlocks.GREEN_TERRACOTTA_BRICK_STAIRS, EBlocks.GREEN_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.GREEN_TERRACOTTA_BRICK_SLAB, EBlocks.GREEN_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.GREEN_TERRACOTTA_BRICK_TILES, EBlocks.GREEN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.GREEN_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.CYAN_TERRACOTTA, EBlocks.CYAN_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.CYAN_TERRACOTTA_BRICKS, EBlocks.CYAN_TERRACOTTA_BRICK_STAIRS, EBlocks.CYAN_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.CYAN_TERRACOTTA_BRICK_SLAB, EBlocks.CYAN_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.CYAN_TERRACOTTA_BRICK_TILES, EBlocks.CYAN_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.CYAN_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.LIGHT_BLUE_TERRACOTTA, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILES, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.BLUE_TERRACOTTA, EBlocks.BLUE_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.BLUE_TERRACOTTA_BRICKS, EBlocks.BLUE_TERRACOTTA_BRICK_STAIRS, EBlocks.BLUE_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.BLUE_TERRACOTTA_BRICK_SLAB, EBlocks.BLUE_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.BLUE_TERRACOTTA_BRICK_TILES, EBlocks.BLUE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.BLUE_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.PURPLE_TERRACOTTA, EBlocks.PURPLE_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.PURPLE_TERRACOTTA_BRICKS, EBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS, EBlocks.PURPLE_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.PURPLE_TERRACOTTA_BRICK_SLAB, EBlocks.PURPLE_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.PURPLE_TERRACOTTA_BRICK_TILES, EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.PURPLE_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.MAGENTA_TERRACOTTA, EBlocks.MAGENTA_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.MAGENTA_TERRACOTTA_BRICKS, EBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS, EBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB, EBlocks.MAGENTA_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.MAGENTA_TERRACOTTA_BRICK_TILES, EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.MAGENTA_TERRACOTTA_BRICK_TILE_SLAB);
                recipe2x2(Blocks.PINK_TERRACOTTA, EBlocks.PINK_TERRACOTTA_BRICKS);
                recipeStairSlab(EBlocks.PINK_TERRACOTTA_BRICKS, EBlocks.PINK_TERRACOTTA_BRICK_STAIRS, EBlocks.PINK_TERRACOTTA_BRICK_SLAB);
                recipe2x1t1(EBlocks.PINK_TERRACOTTA_BRICK_SLAB, EBlocks.PINK_TERRACOTTA_BRICK_TILES);
                recipeStairSlab(EBlocks.PINK_TERRACOTTA_BRICK_TILES, EBlocks.PINK_TERRACOTTA_BRICK_TILE_STAIRS, EBlocks.PINK_TERRACOTTA_BRICK_TILE_SLAB);

                recipeStairSlab(Blocks.WHITE_CONCRETE, EBlocks.WHITE_CONCRETE_STAIRS, EBlocks.WHITE_CONCRETE_SLAB);
                recipeStairSlab(Blocks.LIGHT_GRAY_CONCRETE, EBlocks.LIGHT_GRAY_CONCRETE_STAIRS, EBlocks.LIGHT_GRAY_CONCRETE_SLAB);
                recipeStairSlab(Blocks.GRAY_CONCRETE, EBlocks.GRAY_CONCRETE_STAIRS, EBlocks.GRAY_CONCRETE_SLAB);
                recipeStairSlab(Blocks.BLACK_CONCRETE, EBlocks.BLACK_CONCRETE_STAIRS, EBlocks.BLACK_CONCRETE_SLAB);
                recipeStairSlab(Blocks.BROWN_CONCRETE, EBlocks.BROWN_CONCRETE_STAIRS, EBlocks.BROWN_CONCRETE_SLAB);
                recipeStairSlab(Blocks.RED_CONCRETE, EBlocks.RED_CONCRETE_STAIRS, EBlocks.RED_CONCRETE_SLAB);
                recipeStairSlab(Blocks.ORANGE_CONCRETE, EBlocks.ORANGE_CONCRETE_STAIRS, EBlocks.ORANGE_CONCRETE_SLAB);
                recipeStairSlab(Blocks.YELLOW_CONCRETE, EBlocks.YELLOW_CONCRETE_STAIRS, EBlocks.YELLOW_CONCRETE_SLAB);
                recipeStairSlab(Blocks.LIME_CONCRETE, EBlocks.LIME_CONCRETE_STAIRS, EBlocks.LIME_CONCRETE_SLAB);
                recipeStairSlab(Blocks.GREEN_CONCRETE, EBlocks.GREEN_CONCRETE_STAIRS, EBlocks.GREEN_CONCRETE_SLAB);
                recipeStairSlab(Blocks.CYAN_CONCRETE, EBlocks.CYAN_CONCRETE_STAIRS, EBlocks.CYAN_CONCRETE_SLAB);
                recipeStairSlab(Blocks.LIGHT_BLUE_CONCRETE, EBlocks.LIGHT_BLUE_CONCRETE_STAIRS, EBlocks.LIGHT_BLUE_CONCRETE_SLAB);
                recipeStairSlab(Blocks.BLUE_CONCRETE, EBlocks.BLUE_CONCRETE_STAIRS, EBlocks.BLUE_CONCRETE_SLAB);
                recipeStairSlab(Blocks.PURPLE_CONCRETE, EBlocks.PURPLE_CONCRETE_STAIRS, EBlocks.PURPLE_CONCRETE_SLAB);
                recipeStairSlab(Blocks.MAGENTA_CONCRETE, EBlocks.MAGENTA_CONCRETE_STAIRS, EBlocks.MAGENTA_CONCRETE_SLAB);
                recipeStairSlab(Blocks.PINK_CONCRETE, EBlocks.PINK_CONCRETE_STAIRS, EBlocks.PINK_CONCRETE_SLAB);
            }



            private void itemToDye(ItemLike item, ItemLike dye) {
                shapeless(RecipeCategory.MISC, dye).requires(item)
                        .unlockedBy(getHasName(item), has(item)).save(wrappedOutput, shapedId(item));
            }
            private void fullCookingBook(ItemLike raw, ItemLike cooked) {
                customSimpleCookingRecipe("smelting", SmeltingRecipe::new, 200, raw, cooked, 0.35F);
                customSimpleCookingRecipe("smoking", SmokingRecipe::new, 100, raw, cooked, 0.35F);
                customSimpleCookingRecipe("campfire", CampfireCookingRecipe::new, 600, raw, cooked, 0.35F);
            }
            private void itemFullSmeltableNBSet(Float exp,
                                                ItemLike oreBlock, ItemLike shaleOreBlock, ItemLike deepslateOreBlock, ItemLike cinnabarOreBlock,
                                                ItemLike raw, ItemLike ingot, ItemLike nugget,
                                                ItemLike rawBlock, ItemLike compBlock) {
                List<ItemLike> smeltables = new ArrayList<>();
                smeltables.add(oreBlock); smeltables.add(shaleOreBlock); smeltables.add(deepslateOreBlock); smeltables.add(cinnabarOreBlock); smeltables.add(raw);

                customOreSmelting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, exp, 200, getItemName(ingot));
                customOreBlasting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, exp, 100, getItemName(ingot));

                shapeless(RecipeCategory.BUILDING_BLOCKS, rawBlock).requires(raw, 9)
                        .unlockedBy(getHasName(rawBlock), has(rawBlock)).save(wrappedOutput, specificPath(rawBlock, "_from_" + getItemName(raw)));
                shapeless(RecipeCategory.MISC, raw, 9).requires(rawBlock)
                        .unlockedBy(getHasName(raw), has(raw)).save(wrappedOutput, specificPath(raw, "_from_" + getItemName(rawBlock)));

                shapeless(RecipeCategory.MISC, ingot).requires(nugget, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                        .unlockedBy(getHasName(nugget), has(nugget)).save(wrappedOutput, specificPath(nugget, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));

                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(compBlock, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath()));
            }
            private void itemSmeltableNBSet(Float exp,
                                            ItemLike raw, ItemLike ingot, ItemLike nugget,
                                            ItemLike compBlock) {
                List<ItemLike> smeltables = new ArrayList<>();
                smeltables.add(raw);

                customOreSmelting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, exp, 200, getItemName(ingot));
                customOreBlasting(smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ingot, exp, 100, getItemName(ingot));

                shapeless(RecipeCategory.MISC, ingot).requires(nugget, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                        .unlockedBy(getHasName(nugget), has(nugget)).save(wrappedOutput, specificPath(nugget, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));

                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(compBlock, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath()));
            }
            private void itemUnsmeltableNBSet(ItemLike ingot, ItemLike nugget, ItemLike compBlock) {
                shapeless(RecipeCategory.MISC, ingot).requires(nugget, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(nugget.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, nugget, 9).requires(ingot)
                        .unlockedBy(getHasName(nugget), has(nugget)).save(wrappedOutput, specificPath(nugget, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));

                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(wrappedOutput, specificPath(compBlock, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));
            }
            private void itemUnsmeltableBSet(ItemLike ingot, ItemLike compBlock) {
                shapeless(RecipeCategory.BUILDING_BLOCKS, compBlock).requires(ingot, 9)
                        .unlockedBy(getHasName(ingot), has(ingot)).save(wrappedOutput, specificPath(ingot, "_from_" + BuiltInRegistries.ITEM.getKey(compBlock.asItem()).getPath()));
                shapeless(RecipeCategory.MISC, ingot, 9).requires(compBlock)
                        .unlockedBy(getHasName(compBlock), has(compBlock)).save(wrappedOutput, specificPath(compBlock, "_from_" + BuiltInRegistries.ITEM.getKey(ingot.asItem()).getPath()));
            }
            private void equipmentSetCrafting(ItemLike material, ItemLike handle,
                                              ItemLike sword, ItemLike axe, ItemLike spear, ItemLike pickaxe, ItemLike shovel, ItemLike hoe,
                                              ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots,
                                              ItemLike scrapResult) {
                shaped(RecipeCategory.COMBAT, sword).define('#', material).define('T', handle)
                        .pattern("#").pattern("#").pattern("T")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, axe).define('#', material).define('T', handle)
                        .pattern("##").pattern("#T").pattern(" T")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.COMBAT, spear).define('#', material).define('T', handle)
                        .pattern("  #").pattern(" T ").pattern("T  ")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, pickaxe).define('#', material).define('T', handle)
                        .pattern("###").pattern(" T ").pattern(" T ")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, shovel).define('#', material).define('T', handle)
                        .pattern("#").pattern("T").pattern("T")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.TOOLS, hoe).define('#', material).define('T', handle)
                        .pattern("##").pattern(" T").pattern(" T")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);

                shaped(RecipeCategory.COMBAT, helmet).define('#', material)
                        .pattern("###").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.COMBAT, chestplate).define('#', material)
                        .pattern("# #").pattern("###").pattern("###")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.COMBAT, leggings).define('#', material)
                        .pattern("###").pattern("# #").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);
                shaped(RecipeCategory.COMBAT, boots).define('#', material)
                        .pattern("# #").pattern("# #")
                        .unlockedBy(getHasName(material), has(material)).save(wrappedOutput);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(sword, axe, spear, pickaxe, shovel, hoe, helmet, chestplate, leggings, boots),
                        RecipeCategory.MISC, CookingBookCategory.MISC,
                        scrapResult, 0.1F, 200
                ).unlockedBy(getHasName(material), has(material)).save(wrappedOutput,
                        ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(Elsewhere.MODID, getSmeltingRecipeName(scrapResult))));

                SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(sword, axe, spear, pickaxe, shovel, hoe, helmet, chestplate, leggings, boots),
                        RecipeCategory.MISC, CookingBookCategory.MISC,
                        scrapResult, 0.1F, 200
                ).unlockedBy(getHasName(material), has(material)).save(wrappedOutput,
                        ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(Elsewhere.MODID, getBlastingRecipeName(scrapResult))));
            }
            private void equipmentSetSmithing(ItemLike material, ItemLike template,
                                              ItemLike baseSword, ItemLike baseAxe, ItemLike baseSpear, ItemLike basePickaxe, ItemLike baseShovel, ItemLike baseHoe,
                                              ItemLike baseHelmet, ItemLike baseChestplate, ItemLike baseLeggings, ItemLike baseBoots,
                                              Item sword, Item axe, Item spear, Item pickaxe, Item shovel, Item hoe,
                                              Item helmet, Item chestplate, Item leggings, Item boots,
                                              ItemLike scrapResult) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseSword), Ingredient.of(material), RecipeCategory.COMBAT, sword)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(sword, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseAxe), Ingredient.of(material), RecipeCategory.TOOLS, axe)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(axe, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseSpear), Ingredient.of(material), RecipeCategory.COMBAT, spear)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(spear, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(basePickaxe), Ingredient.of(material), RecipeCategory.TOOLS, pickaxe)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(pickaxe, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseShovel), Ingredient.of(material), RecipeCategory.TOOLS, shovel)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(shovel, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseHoe), Ingredient.of(material), RecipeCategory.TOOLS, hoe)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(hoe, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseHelmet), Ingredient.of(material), RecipeCategory.COMBAT, helmet)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(helmet, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseChestplate), Ingredient.of(material), RecipeCategory.COMBAT, chestplate)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(chestplate, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseLeggings), Ingredient.of(material), RecipeCategory.COMBAT, leggings)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(leggings, "_smithing"));
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(baseBoots), Ingredient.of(material), RecipeCategory.COMBAT, boots)
                        .unlocks(getHasName(material), has(material)).save(wrappedOutput, specificPath(boots, "_smithing"));

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(sword, axe, spear, pickaxe, shovel, hoe, helmet, chestplate, leggings, boots),
                        RecipeCategory.MISC, CookingBookCategory.MISC,
                        scrapResult, 0.1F, 200
                ).unlockedBy(getHasName(material), has(material)).save(wrappedOutput,
                        ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(Elsewhere.MODID, getSmeltingRecipeName(scrapResult))));

                SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(sword, axe, spear, pickaxe, shovel, hoe, helmet, chestplate, leggings, boots),
                        RecipeCategory.MISC, CookingBookCategory.MISC,
                        scrapResult, 0.1F, 200
                ).unlockedBy(getHasName(material), has(material)).save(wrappedOutput,
                        ResourceKey.create(Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(Elsewhere.MODID, getBlastingRecipeName(scrapResult))));
            }

            private void recipe2x2(ItemLike ingredient, ItemLike result){shaped(RecipeCategory.BUILDING_BLOCKS, result, 4).define('#', ingredient).pattern("##").pattern("##").unlockedBy(getHasName(ingredient), has(ingredient)).save(wrappedOutput, shapedId(result));}
            private void recipe2x2t1(ItemLike ingredient, ItemLike result){shaped(RecipeCategory.BUILDING_BLOCKS, result).define('#', ingredient).pattern("##").pattern("##").unlockedBy(getHasName(ingredient), has(ingredient)).save(wrappedOutput, shapedId(result));}
            private void recipe2x1t2(ItemLike ingredient, ItemLike result){shaped(RecipeCategory.BUILDING_BLOCKS, result, 2).define('#', ingredient).pattern("#").pattern("#").unlockedBy(getHasName(ingredient), has(ingredient)).save(wrappedOutput, shapedId(result));}
            private void recipe2x1t1(ItemLike ingredient, ItemLike result){shaped(RecipeCategory.BUILDING_BLOCKS, result).define('#', ingredient).pattern("#").pattern("#").unlockedBy(getHasName(ingredient), has(ingredient)).save(wrappedOutput, shapedId(result));}
            private void recipeStairSlab(ItemLike block, ItemLike stair, ItemLike slab) {
                shaped(RecipeCategory.BUILDING_BLOCKS, stair, 6).define('#', block).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(block), has(block)).save(wrappedOutput, shapedId(stair));
                shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).define('#', block).pattern("###").unlockedBy(getHasName(block), has(block)).save(wrappedOutput, shapedId(slab));
            }
            private void recipeStairSlabWall(ItemLike block, ItemLike stair, ItemLike slab, ItemLike wall){
                shaped(RecipeCategory.BUILDING_BLOCKS, stair, 6).define('#', block).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(block), has(block)).save(wrappedOutput, shapedId(stair));
                shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).define('#', block).pattern("###").unlockedBy(getHasName(block), has(block)).save(wrappedOutput, shapedId(slab));
                shaped(RecipeCategory.BUILDING_BLOCKS, wall, 6).define('#', block).pattern("###").pattern("###").unlockedBy(getHasName(block), has(block)).save(wrappedOutput, shapedId(wall));
            }


            private void quartzSet(ItemLike base, ItemLike baseStair, ItemLike baseSlab,
                                   ItemLike brick, ItemLike brickStair, ItemLike brickSlab,
                                   ItemLike pillar, ItemLike chiseled) {

                // Shaped
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(baseSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, brick, 4).define('#', base).pattern("##").pattern("##")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(brick));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickStair, 6).define('#', brick).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(wrappedOutput, shapedId(brickStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, brickSlab, 6).define('#', brick).pattern("###")
                        .unlockedBy(getHasName(brick), has(brick)).save(wrappedOutput, shapedId(brickSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', brick).pattern("#").pattern("#")
                        .unlockedBy(getHasName(brick), has(brick)).save(wrappedOutput, shapedId(pillar));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', baseSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(chiseled));

                // Stonecutter
                stonecutterSet(
                        List.of(base, baseStair, brick, brickStair, pillar, chiseled),
                        List.of(baseSlab, brickSlab)
                );
            }


            private void purpurSet(ItemLike base, ItemLike baseStair, ItemLike baseSlab,
                                   ItemLike pillar, ItemLike chiseled) {

                // Shaped
                shaped(RecipeCategory.BUILDING_BLOCKS, baseStair, 6).define('#', base).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(baseStair));
                shaped(RecipeCategory.BUILDING_BLOCKS, baseSlab, 6).define('#', base).pattern("###")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(baseSlab));

                shaped(RecipeCategory.BUILDING_BLOCKS, pillar, 2).define('#', base).pattern("#").pattern("#")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(pillar));
                shaped(RecipeCategory.BUILDING_BLOCKS, chiseled, 2).define('#', baseSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(base), has(base)).save(wrappedOutput, shapedId(chiseled));

                // Stonecutter
                stonecutterSet(
                        List.of(base, baseStair, pillar, chiseled),
                        List.of(baseSlab)
                );
            }

            private void woodSet(ItemLike planks, ItemLike plankStair, ItemLike plankSlab,
                                 ItemLike mosaic, ItemLike mosaicStair, ItemLike mosaicSlab,
                                 ItemLike boards, ItemLike trim) {

                shaped(RecipeCategory.BUILDING_BLOCKS, plankStair, 6).define('#', planks).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, plankSlab, 6).define('#', planks).pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, mosaic, 4).define('#', planks).pattern("##").pattern("##")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicStair, 6).define('#', mosaic).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicSlab, 6).define('#', mosaic).pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(wrappedOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, boards).define('#', plankSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, trim, 3).define('#', plankSlab).pattern("###").pattern("###")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(wrappedOutput);
            }

            private void fullWoodSet(
                                     ItemLike log, ItemLike strippedLog, ItemLike wood, ItemLike strippedWood, TagKey<Item> logTag,
                                     ItemLike planks, ItemLike plankStair, ItemLike plankSlab,
                                     ItemLike mosaic, ItemLike mosaicStair, ItemLike mosaicSlab,
                                     ItemLike boards, ItemLike trim,
                                     ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor,
                                     ItemLike pressurePlate, ItemLike button, ItemLike sign, ItemLike hangingSign,
                                     ItemLike boat, ItemLike shelf) {

                // Log/Wood tag -> Planks
                shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4).requires(logTag)
                        .unlockedBy(getHasName(log), has(logTag)).save(wrappedOutput);

                // Log -> Wood
                shaped(RecipeCategory.BUILDING_BLOCKS, wood, 3).define('#', log).pattern("##").pattern("##")
                        .unlockedBy(getHasName(log), has(log)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, strippedWood, 3).define('#', strippedLog).pattern("##").pattern("##")
                        .unlockedBy(getHasName(strippedLog), has(strippedLog)).save(wrappedOutput);

                // Planks derivatives
                shaped(RecipeCategory.BUILDING_BLOCKS, plankStair, 6).define('#', planks).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, plankSlab, 6).define('#', planks).pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, mosaic, 1).define('#', plankSlab).pattern("#").pattern("#")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicStair, 6).define('#', mosaic).pattern("#  ").pattern("## ").pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, mosaicSlab, 6).define('#', mosaic).pattern("###")
                        .unlockedBy(getHasName(mosaic), has(mosaic)).save(wrappedOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, boards, 3).define('#', planks).pattern("#").pattern("#").pattern("#")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, trim, 3).define('#', plankSlab).pattern("###").pattern("###")
                        .unlockedBy(getHasName(plankSlab), has(plankSlab)).save(wrappedOutput);

                // Functional blocks
                shaped(RecipeCategory.DECORATIONS, fence, 3).define('#', Items.STICK).define('W', planks).pattern("W#W").pattern("W#W")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.REDSTONE, fenceGate).define('#', Items.STICK).define('W', planks).pattern("#W#").pattern("#W#")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.REDSTONE, door, 3).define('#', planks).pattern("##").pattern("##").pattern("##")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.REDSTONE, trapdoor, 6).define('#', planks).pattern("###").pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.REDSTONE, pressurePlate).define('#', planks).pattern("##")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shapeless(RecipeCategory.REDSTONE, button).requires(planks)
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.DECORATIONS, sign, 3).define('#', planks).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
                shaped(RecipeCategory.DECORATIONS, hangingSign, 6).define('#', strippedLog).define('C', Items.IRON_CHAIN).pattern("C C").pattern("###").pattern("###")
                        .unlockedBy(getHasName(strippedLog), has(strippedLog)).save(wrappedOutput);
                shaped(RecipeCategory.BUILDING_BLOCKS, shelf, 6).define('#', strippedLog).pattern("###").pattern("###")
                        .unlockedBy(getHasName(strippedLog), has(strippedLog)).save(wrappedOutput);

                // Boat
                shaped(RecipeCategory.TRANSPORTATION, boat).define('#', planks).pattern("# #").pattern("###")
                        .unlockedBy(getHasName(planks), has(planks)).save(wrappedOutput);
            }








            // Helper Methods
            private String specificPath(ItemLike item, String suffix) {
                Identifier id = BuiltInRegistries.ITEM.getKey(item.asItem());
                return Identifier.fromNamespaceAndPath(Elsewhere.MODID, id.getPath() + suffix).toString();
            }
            private ResourceKey<Recipe<?>> shapedId(ItemLike result) {
                Identifier id = BuiltInRegistries.ITEM.getKey(result.asItem());
                return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath()));
            }

            public void customOreSmelting(List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group) {
                customOreCooking(SmeltingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_smelting");
            }

            public void customOreBlasting(List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group) {
                customOreCooking(BlastingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_blasting");
            }

            public <T extends AbstractCookingRecipe> void customOreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc) {
                for (ItemLike item : smeltables) {
                    ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE,
                            Identifier.fromNamespaceAndPath(Elsewhere.MODID, getItemName(result) + fromDesc + "_" + getItemName(item)));
                    SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                            .group(group)
                            .unlockedBy(getHasName(item), this.has(item))
                            .save(wrappedOutput, key);
                }
            }

            public <T extends AbstractCookingRecipe> void customSimpleCookingRecipe(String source, AbstractCookingRecipe.Factory<T> factory, int cookingTime, ItemLike base, ItemLike result, float experience) {
                ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE,
                        Identifier.fromNamespaceAndPath(Elsewhere.MODID, getItemName(result) + "_from_" + source));
                SimpleCookingRecipeBuilder.generic(Ingredient.of(base), RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, cookingTime, factory)
                        .unlockedBy(getHasName(base), this.has(base))
                        .save(wrappedOutput, key);
            }

            private void stonecutterSet(List<ItemLike> fullBlocks,
                                        List<ItemLike> slabs) {
                generateStonecutterGroup(fullBlocks, fullBlocks, 1);
                generateStonecutterGroup(fullBlocks, slabs, 2);
                generateStonecutterGroup(slabs, slabs, 1);
            }

            private void generateStonecutterGroup(List<ItemLike> inputs,
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
                                .save(wrappedOutput, recipeId);
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