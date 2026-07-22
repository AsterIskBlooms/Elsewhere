package team.lookingglass.elsewhere.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import team.lookingglass.elsewhere.Elsewhere;

public class ETabs {
    private static final ResourceKey<CreativeModeTab> ELSEWHERE = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "elsewhere_tab"));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ELSEWHERE, FabricCreativeModeTab.builder()
                .title(Component.translatable("elsewhere.tab"))
                .icon(() -> new ItemStack(EBlocks.STONE_TILES))
                .displayItems((context, output) -> {
                    // Tin
                    output.accept(EBlocks.TIN_ORE);
                    output.accept(EBlocks.SHALE_TIN_ORE);
                    output.accept(EBlocks.DEEPSLATE_TIN_ORE);
                    output.accept(EBlocks.CINNABAR_TIN_ORE);
                    output.accept(EItems.RAW_TIN);
                    output.accept(EBlocks.RAW_TIN_BLOCK);
                    output.accept(EItems.TIN_INGOT);
                    output.accept(EItems.TIN_NUGGET);
                    output.accept(EBlocks.TIN_BLOCK);

                    // Bronze
                    output.accept(EItems.BRONZE_INGOT);
                    output.accept(EItems.BRONZE_NUGGET);
                    output.accept(EBlocks.BRONZE_BLOCK);
                    output.accept(EItems.BRONZE_SWORD);
                    output.accept(EItems.BRONZE_AXE);
                    output.accept(EItems.BRONZE_PICKAXE);
                    output.accept(EItems.BRONZE_SHOVEL);
                    output.accept(EItems.BRONZE_HOE);
                    output.accept(EItems.BRONZE_HELMET);
                    output.accept(EItems.BRONZE_CHESTPLATE);
                    output.accept(EItems.BRONZE_LEGGINGS);
                    output.accept(EItems.BRONZE_BOOTS);

                    // Silver
                    output.accept(EBlocks.SILVER_ORE);
                    output.accept(EBlocks.SHALE_SILVER_ORE);
                    output.accept(EBlocks.DEEPSLATE_SILVER_ORE);
                    output.accept(EBlocks.CINNABAR_SILVER_ORE);
                    output.accept(EItems.RAW_SILVER);
                    output.accept(EBlocks.RAW_SILVER_BLOCK);
                    output.accept(EItems.SILVER_INGOT);
                    output.accept(EItems.SILVER_NUGGET);
                    output.accept(EBlocks.SILVER_BLOCK);

                    // Soulsteel
                    output.accept(EItems.SOULSTEEL_INGOT);
                    output.accept(EBlocks.SOULSTEEL_BLOCK);
                    output.accept(EItems.SOULSTEEL_SWORD);
                    output.accept(EItems.SOULSTEEL_AXE);
                    output.accept(EItems.SOULSTEEL_PICKAXE);
                    output.accept(EItems.SOULSTEEL_SHOVEL);
                    output.accept(EItems.SOULSTEEL_HOE);
                    output.accept(EItems.SOULSTEEL_HELMET);
                    output.accept(EItems.SOULSTEEL_CHESTPLATE);
                    output.accept(EItems.SOULSTEEL_LEGGINGS);
                    output.accept(EItems.SOULSTEEL_BOOTS);

                    // Worldgen
                    output.accept(EBlocks.PEBBLE);
                    output.accept(EBlocks.ARID_GRASS_BLOCK);
                    output.accept(EBlocks.ARID_DIRT);
                    output.accept(EBlocks.LATERITE);
                    output.accept(EBlocks.BLUEBONNET);

                    // Spawn Eggs
                    output.accept(EItems.FROSTBITE_SPAWN_EGG);

                    // Stone Set
                    output.accept(EBlocks.STONE_WALL);
                    output.accept(EBlocks.SMOOTH_STONE_STAIRS);
                    output.accept(EBlocks.SMOOTH_STONE_WALL);

                    output.accept(EBlocks.POLISHED_STONE);
                    output.accept(EBlocks.POLISHED_STONE_STAIRS);
                    output.accept(EBlocks.POLISHED_STONE_SLAB);
                    output.accept(EBlocks.POLISHED_STONE_WALL);

                    output.accept(EBlocks.CHISELED_STONE);
                    output.accept(EBlocks.STONE_TILES);
                    output.accept(EBlocks.STONE_TILE_STAIRS);
                    output.accept(EBlocks.STONE_TILE_SLAB);
                    output.accept(EBlocks.STONE_TILE_WALL);
                    output.accept(EBlocks.MOSSY_STONE_TILES);
                    output.accept(EBlocks.MOSSY_STONE_TILE_STAIRS);
                    output.accept(EBlocks.MOSSY_STONE_TILE_SLAB);
                    output.accept(EBlocks.MOSSY_STONE_TILE_WALL);
                    output.accept(EBlocks.STONE_PILLAR);

                    output.accept(EBlocks.SHALE);
                    output.accept(EBlocks.SHALE_STAIRS);
                    output.accept(EBlocks.SHALE_SLAB);
                    output.accept(EBlocks.SHALE_WALL);
                    output.accept(EBlocks.SMOOTH_SHALE);
                    output.accept(EBlocks.SMOOTH_SHALE_STAIRS);
                    output.accept(EBlocks.SMOOTH_SHALE_SLAB);
                    output.accept(EBlocks.SMOOTH_SHALE_WALL);
                    output.accept(EBlocks.POLISHED_SHALE);
                    output.accept(EBlocks.POLISHED_SHALE_STAIRS);
                    output.accept(EBlocks.POLISHED_SHALE_SLAB);
                    output.accept(EBlocks.POLISHED_SHALE_WALL);
                    output.accept(EBlocks.SHALE_BRICKS);
                    output.accept(EBlocks.SHALE_BRICK_STAIRS);
                    output.accept(EBlocks.SHALE_BRICK_SLAB);
                    output.accept(EBlocks.SHALE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_SHALE);
                    output.accept(EBlocks.CHISELED_SHALE_BRICKS);
                    output.accept(EBlocks.SHALE_PILLAR);
                    output.accept(EBlocks.COBBLESHALE);
                    output.accept(EBlocks.COBBLESHALE_STAIRS);
                    output.accept(EBlocks.COBBLESHALE_SLAB);
                    output.accept(EBlocks.COBBLESHALE_WALL);
                    output.accept(EBlocks.SHALE_TILES);
                    output.accept(EBlocks.SHALE_TILE_STAIRS);
                    output.accept(EBlocks.SHALE_TILE_SLAB);
                    output.accept(EBlocks.SHALE_TILE_WALL);

                    output.accept(EBlocks.SHALE_COAL_ORE);
                    output.accept(EBlocks.SHALE_COPPER_ORE);
                    output.accept(EBlocks.SHALE_IRON_ORE);
                    output.accept(EBlocks.SHALE_GOLD_ORE);
                    output.accept(EBlocks.SHALE_REDSTONE_ORE);
                    output.accept(EBlocks.SHALE_DIAMOND_ORE);
                    output.accept(EBlocks.SHALE_LAPIS_ORE);
                    output.accept(EBlocks.SHALE_EMERALD_ORE);

                    output.accept(EBlocks.DEEPSLATE_STAIRS);
                    output.accept(EBlocks.DEEPSLATE_SLAB);
                    output.accept(EBlocks.DEEPSLATE_WALL);

                    output.accept(EBlocks.SMOOTH_DEEPSLATE);
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_STAIRS);
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_SLAB);
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_WALL);

                    output.accept(EBlocks.CHISELED_DEEPSLATE_BRICKS);
                    output.accept(EBlocks.DEEPSLATE_PILLAR);

                    output.accept(EBlocks.SMOOTH_TUFF);
                    output.accept(EBlocks.SMOOTH_TUFF_STAIRS);
                    output.accept(EBlocks.SMOOTH_TUFF_SLAB);
                    output.accept(EBlocks.SMOOTH_TUFF_WALL);
                    output.accept(EBlocks.TUFF_PILLAR);

                    output.accept(EBlocks.SMOOTH_BLACKSTONE);
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_STAIRS);
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_SLAB);
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_WALL);
                    output.accept(EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);
                    output.accept(EBlocks.POLISHED_BLACKSTONE_PILLAR);

                    output.accept(EBlocks.POLISHED_ANDESITE_WALL);
                    output.accept(EBlocks.SMOOTH_ANDESITE);
                    output.accept(EBlocks.SMOOTH_ANDESITE_STAIRS);
                    output.accept(EBlocks.SMOOTH_ANDESITE_SLAB);
                    output.accept(EBlocks.SMOOTH_ANDESITE_WALL);
                    output.accept(EBlocks.ANDESITE_BRICKS);
                    output.accept(EBlocks.ANDESITE_BRICK_STAIRS);
                    output.accept(EBlocks.ANDESITE_BRICK_SLAB);
                    output.accept(EBlocks.ANDESITE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_ANDESITE);
                    output.accept(EBlocks.CHISELED_ANDESITE_BRICKS);
                    output.accept(EBlocks.ANDESITE_PILLAR);

                    output.accept(EBlocks.POLISHED_GRANITE_WALL);
                    output.accept(EBlocks.SMOOTH_GRANITE);
                    output.accept(EBlocks.SMOOTH_GRANITE_STAIRS);
                    output.accept(EBlocks.SMOOTH_GRANITE_SLAB);
                    output.accept(EBlocks.SMOOTH_GRANITE_WALL);
                    output.accept(EBlocks.GRANITE_BRICKS);
                    output.accept(EBlocks.GRANITE_BRICK_STAIRS);
                    output.accept(EBlocks.GRANITE_BRICK_SLAB);
                    output.accept(EBlocks.GRANITE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_GRANITE);
                    output.accept(EBlocks.CHISELED_GRANITE_BRICKS);
                    output.accept(EBlocks.GRANITE_PILLAR);

                    output.accept(EBlocks.POLISHED_DIORITE_WALL);
                    output.accept(EBlocks.SMOOTH_DIORITE);
                    output.accept(EBlocks.SMOOTH_DIORITE_STAIRS);
                    output.accept(EBlocks.SMOOTH_DIORITE_SLAB);
                    output.accept(EBlocks.SMOOTH_DIORITE_WALL);
                    output.accept(EBlocks.DIORITE_BRICKS);
                    output.accept(EBlocks.DIORITE_BRICK_STAIRS);
                    output.accept(EBlocks.DIORITE_BRICK_SLAB);
                    output.accept(EBlocks.DIORITE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_DIORITE);
                    output.accept(EBlocks.CHISELED_DIORITE_BRICKS);
                    output.accept(EBlocks.DIORITE_PILLAR);

                    output.accept(EBlocks.CALCITE_STAIRS);
                    output.accept(EBlocks.CALCITE_SLAB);
                    output.accept(EBlocks.CALCITE_WALL);
                    output.accept(EBlocks.SMOOTH_CALCITE);
                    output.accept(EBlocks.SMOOTH_CALCITE_STAIRS);
                    output.accept(EBlocks.SMOOTH_CALCITE_SLAB);
                    output.accept(EBlocks.SMOOTH_CALCITE_WALL);
                    output.accept(EBlocks.POLISHED_CALCITE);
                    output.accept(EBlocks.POLISHED_CALCITE_STAIRS);
                    output.accept(EBlocks.POLISHED_CALCITE_SLAB);
                    output.accept(EBlocks.POLISHED_CALCITE_WALL);
                    output.accept(EBlocks.CALCITE_BRICKS);
                    output.accept(EBlocks.CALCITE_BRICK_STAIRS);
                    output.accept(EBlocks.CALCITE_BRICK_SLAB);
                    output.accept(EBlocks.CALCITE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_CALCITE);
                    output.accept(EBlocks.CHISELED_CALCITE_BRICKS);
                    output.accept(EBlocks.CALCITE_PILLAR);

                    output.accept(EBlocks.DRIPSTONE_STAIRS);
                    output.accept(EBlocks.DRIPSTONE_SLAB);
                    output.accept(EBlocks.DRIPSTONE_WALL);
                    output.accept(EBlocks.SMOOTH_DRIPSTONE);
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_STAIRS);
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_SLAB);
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_WALL);
                    output.accept(EBlocks.POLISHED_DRIPSTONE);
                    output.accept(EBlocks.POLISHED_DRIPSTONE_STAIRS);
                    output.accept(EBlocks.POLISHED_DRIPSTONE_SLAB);
                    output.accept(EBlocks.POLISHED_DRIPSTONE_WALL);
                    output.accept(EBlocks.DRIPSTONE_BRICKS);
                    output.accept(EBlocks.DRIPSTONE_BRICK_STAIRS);
                    output.accept(EBlocks.DRIPSTONE_BRICK_SLAB);
                    output.accept(EBlocks.DRIPSTONE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_DRIPSTONE);
                    output.accept(EBlocks.CHISELED_DRIPSTONE_BRICKS);
                    output.accept(EBlocks.DRIPSTONE_PILLAR);

                    output.accept(EBlocks.BASALT_SLAB);
                    output.accept(EBlocks.SMOOTH_BASALT_STAIRS);
                    output.accept(EBlocks.SMOOTH_BASALT_SLAB);
                    output.accept(EBlocks.SMOOTH_BASALT_WALL);
                    output.accept(EBlocks.POLISHED_BASALT_SLAB);
                    output.accept(EBlocks.BASALT_BRICKS);
                    output.accept(EBlocks.BASALT_BRICK_STAIRS);
                    output.accept(EBlocks.BASALT_BRICK_SLAB);
                    output.accept(EBlocks.BASALT_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_BASALT);
                    output.accept(EBlocks.CHISELED_BASALT_BRICKS);

                    output.accept(EBlocks.SODALITE);
                    output.accept(EBlocks.SODALITE_STAIRS);
                    output.accept(EBlocks.SODALITE_SLAB);
                    output.accept(EBlocks.SODALITE_WALL);
                    output.accept(EBlocks.SMOOTH_SODALITE);
                    output.accept(EBlocks.SMOOTH_SODALITE_STAIRS);
                    output.accept(EBlocks.SMOOTH_SODALITE_SLAB);
                    output.accept(EBlocks.SMOOTH_SODALITE_WALL);
                    output.accept(EBlocks.POLISHED_SODALITE);
                    output.accept(EBlocks.POLISHED_SODALITE_STAIRS);
                    output.accept(EBlocks.POLISHED_SODALITE_SLAB);
                    output.accept(EBlocks.POLISHED_SODALITE_WALL);
                    output.accept(EBlocks.SODALITE_BRICKS);
                    output.accept(EBlocks.SODALITE_BRICK_STAIRS);
                    output.accept(EBlocks.SODALITE_BRICK_SLAB);
                    output.accept(EBlocks.SODALITE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_SODALITE);
                    output.accept(EBlocks.CHISELED_SODALITE_BRICKS);
                    output.accept(EBlocks.SODALITE_PILLAR);

                    output.accept(EBlocks.SULFUR);
                    output.accept(EBlocks.SULFUR_STAIRS);
                    output.accept(EBlocks.SULFUR_SLAB);
                    output.accept(EBlocks.SULFUR_WALL);
                    output.accept(EBlocks.SMOOTH_SULFUR);
                    output.accept(EBlocks.SMOOTH_SULFUR_STAIRS);
                    output.accept(EBlocks.SMOOTH_SULFUR_SLAB);
                    output.accept(EBlocks.SMOOTH_SULFUR_WALL);
                    output.accept(EBlocks.POLISHED_SULFUR);
                    output.accept(EBlocks.POLISHED_SULFUR_STAIRS);
                    output.accept(EBlocks.POLISHED_SULFUR_SLAB);
                    output.accept(EBlocks.POLISHED_SULFUR_WALL);
                    output.accept(EBlocks.SULFUR_BRICKS);
                    output.accept(EBlocks.SULFUR_BRICK_STAIRS);
                    output.accept(EBlocks.SULFUR_BRICK_SLAB);
                    output.accept(EBlocks.SULFUR_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_SULFUR);
                    output.accept(EBlocks.CHISELED_SULFUR_BRICKS);
                    output.accept(EBlocks.SULFUR_PILLAR);
                    output.accept(EBlocks.SULFUR_SPIKE);
                    output.accept(EBlocks.POTENT_SULFUR);

                    output.accept(EBlocks.ORPIMENT);
                    output.accept(EBlocks.ORPIMENT_STAIRS);
                    output.accept(EBlocks.ORPIMENT_SLAB);
                    output.accept(EBlocks.ORPIMENT_WALL);
                    output.accept(EBlocks.SMOOTH_ORPIMENT);
                    output.accept(EBlocks.SMOOTH_ORPIMENT_STAIRS);
                    output.accept(EBlocks.SMOOTH_ORPIMENT_SLAB);
                    output.accept(EBlocks.SMOOTH_ORPIMENT_WALL);
                    output.accept(EBlocks.POLISHED_ORPIMENT);
                    output.accept(EBlocks.POLISHED_ORPIMENT_STAIRS);
                    output.accept(EBlocks.POLISHED_ORPIMENT_SLAB);
                    output.accept(EBlocks.POLISHED_ORPIMENT_WALL);
                    output.accept(EBlocks.ORPIMENT_BRICKS);
                    output.accept(EBlocks.ORPIMENT_BRICK_STAIRS);
                    output.accept(EBlocks.ORPIMENT_BRICK_SLAB);
                    output.accept(EBlocks.ORPIMENT_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_ORPIMENT);
                    output.accept(EBlocks.CHISELED_ORPIMENT_BRICKS);
                    output.accept(EBlocks.ORPIMENT_PILLAR);

                    output.accept(EBlocks.CINNABAR);
                    output.accept(EBlocks.CINNABAR_STAIRS);
                    output.accept(EBlocks.CINNABAR_SLAB);
                    output.accept(EBlocks.CINNABAR_WALL);
                    output.accept(EBlocks.SMOOTH_CINNABAR);
                    output.accept(EBlocks.SMOOTH_CINNABAR_STAIRS);
                    output.accept(EBlocks.SMOOTH_CINNABAR_SLAB);
                    output.accept(EBlocks.SMOOTH_CINNABAR_WALL);
                    output.accept(EBlocks.POLISHED_CINNABAR);
                    output.accept(EBlocks.POLISHED_CINNABAR_STAIRS);
                    output.accept(EBlocks.POLISHED_CINNABAR_SLAB);
                    output.accept(EBlocks.POLISHED_CINNABAR_WALL);
                    output.accept(EBlocks.CINNABAR_BRICKS);
                    output.accept(EBlocks.CINNABAR_BRICK_STAIRS);
                    output.accept(EBlocks.CINNABAR_BRICK_SLAB);
                    output.accept(EBlocks.CINNABAR_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_CINNABAR);
                    output.accept(EBlocks.CHISELED_CINNABAR_BRICKS);
                    output.accept(EBlocks.CINNABAR_PILLAR);

                    output.accept(EBlocks.CINNABAR_COAL_ORE);
                    output.accept(EBlocks.CINNABAR_COPPER_ORE);
                    output.accept(EBlocks.CINNABAR_IRON_ORE);
                    output.accept(EBlocks.CINNABAR_GOLD_ORE);
                    output.accept(EBlocks.CINNABAR_REDSTONE_ORE);
                    output.accept(EBlocks.CINNABAR_DIAMOND_ORE);
                    output.accept(EBlocks.CINNABAR_LAPIS_ORE);
                    output.accept(EBlocks.CINNABAR_EMERALD_ORE);

                    output.accept(EBlocks.PACKED_MUD_STAIRS);
                    output.accept(EBlocks.PACKED_MUD_SLAB);
                    output.accept(EBlocks.PACKED_MUD_WALL);
                    output.accept(EBlocks.CHISELED_MUD_BRICKS);
                    output.accept(EBlocks.MUD_BRICK_PILLAR);

                    output.accept(EBlocks.NETHERRACK_STAIRS);
                    output.accept(EBlocks.NETHERRACK_SLAB);
                    output.accept(EBlocks.NETHERRACK_WALL);
                    output.accept(EBlocks.SMOOTH_NETHERRACK);
                    output.accept(EBlocks.SMOOTH_NETHERRACK_STAIRS);
                    output.accept(EBlocks.SMOOTH_NETHERRACK_SLAB);
                    output.accept(EBlocks.SMOOTH_NETHERRACK_WALL);
                    output.accept(EBlocks.POLISHED_NETHERRACK);
                    output.accept(EBlocks.POLISHED_NETHERRACK_STAIRS);
                    output.accept(EBlocks.POLISHED_NETHERRACK_SLAB);
                    output.accept(EBlocks.POLISHED_NETHERRACK_WALL);
                    output.accept(EBlocks.NETHERRACK_BRICKS);
                    output.accept(EBlocks.NETHERRACK_BRICK_STAIRS);
                    output.accept(EBlocks.NETHERRACK_BRICK_SLAB);
                    output.accept(EBlocks.NETHERRACK_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_NETHERRACK);
                    output.accept(EBlocks.CHISELED_NETHERRACK_BRICKS);
                    output.accept(EBlocks.NETHERRACK_PILLAR);

                    output.accept(EBlocks.END_STONE_STAIRS);
                    output.accept(EBlocks.END_STONE_SLAB);
                    output.accept(EBlocks.END_STONE_WALL);
                    output.accept(EBlocks.SMOOTH_END_STONE);
                    output.accept(EBlocks.SMOOTH_END_STONE_STAIRS);
                    output.accept(EBlocks.SMOOTH_END_STONE_SLAB);
                    output.accept(EBlocks.SMOOTH_END_STONE_WALL);
                    output.accept(EBlocks.POLISHED_END_STONE);
                    output.accept(EBlocks.POLISHED_END_STONE_STAIRS);
                    output.accept(EBlocks.POLISHED_END_STONE_SLAB);
                    output.accept(EBlocks.POLISHED_END_STONE_WALL);
                    output.accept(EBlocks.CHISELED_END_STONE);
                    output.accept(EBlocks.CHISELED_END_STONE_BRICKS);
                    output.accept(EBlocks.END_STONE_PILLAR);

                    output.accept(EBlocks.SMOOTH_SANDSTONE_WALL);
                    output.accept(EBlocks.CUT_SANDSTONE_STAIRS);
                    output.accept(EBlocks.CUT_SANDSTONE_WALL);
                    output.accept(EBlocks.POLISHED_SANDSTONE);
                    output.accept(EBlocks.POLISHED_SANDSTONE_STAIRS);
                    output.accept(EBlocks.POLISHED_SANDSTONE_SLAB);
                    output.accept(EBlocks.POLISHED_SANDSTONE_WALL);
                    output.accept(EBlocks.SANDSTONE_BRICKS);
                    output.accept(EBlocks.SANDSTONE_BRICK_STAIRS);
                    output.accept(EBlocks.SANDSTONE_BRICK_SLAB);
                    output.accept(EBlocks.SANDSTONE_BRICK_WALL);

                    output.accept(EBlocks.SMOOTH_RED_SANDSTONE_WALL);
                    output.accept(EBlocks.CUT_RED_SANDSTONE_STAIRS);
                    output.accept(EBlocks.CUT_RED_SANDSTONE_WALL);
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE);
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_STAIRS);
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_SLAB);
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_WALL);
                    output.accept(EBlocks.RED_SANDSTONE_BRICKS);
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_STAIRS);
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_SLAB);
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_WALL);

                    output.accept(EBlocks.SOUL_SANDSTONE);
                    output.accept(EBlocks.SOUL_SANDSTONE_STAIRS);
                    output.accept(EBlocks.SOUL_SANDSTONE_SLAB);
                    output.accept(EBlocks.SOUL_SANDSTONE_WALL);
                    output.accept(EBlocks.SMOOTH_SOUL_SANDSTONE);
                    output.accept(EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
                    output.accept(EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB);
                    output.accept(EBlocks.SMOOTH_SOUL_SANDSTONE_WALL);
                    output.accept(EBlocks.CUT_SOUL_SANDSTONE);
                    output.accept(EBlocks.CUT_SOUL_SANDSTONE_STAIRS);
                    output.accept(EBlocks.CUT_SOUL_SANDSTONE_SLAB);
                    output.accept(EBlocks.CUT_SOUL_SANDSTONE_WALL);
                    output.accept(EBlocks.POLISHED_SOUL_SANDSTONE);
                    output.accept(EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS);
                    output.accept(EBlocks.POLISHED_SOUL_SANDSTONE_SLAB);
                    output.accept(EBlocks.POLISHED_SOUL_SANDSTONE_WALL);
                    output.accept(EBlocks.SOUL_SANDSTONE_BRICKS);
                    output.accept(EBlocks.SOUL_SANDSTONE_BRICK_STAIRS);
                    output.accept(EBlocks.SOUL_SANDSTONE_BRICK_SLAB);
                    output.accept(EBlocks.SOUL_SANDSTONE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_SOUL_SANDSTONE);

                    output.accept(EBlocks.SMOOTH_PRISMARINE);
                    output.accept(EBlocks.SMOOTH_PRISMARINE_STAIRS);
                    output.accept(EBlocks.SMOOTH_PRISMARINE_SLAB);
                    output.accept(EBlocks.SMOOTH_PRISMARINE_WALL);
                    output.accept(EBlocks.POLISHED_PRISMARINE);
                    output.accept(EBlocks.POLISHED_PRISMARINE_STAIRS);
                    output.accept(EBlocks.POLISHED_PRISMARINE_SLAB);
                    output.accept(EBlocks.POLISHED_PRISMARINE_WALL);
                    output.accept(EBlocks.PRISMARINE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_PRISMARINE);
                    output.accept(EBlocks.CHISELED_PRISMARINE_BRICKS);
                    output.accept(EBlocks.PRISMARINE_PILLAR);

                    output.accept(EBlocks.DARK_PRISMARINE_WALL);
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE);
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS);
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_SLAB);
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_WALL);
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE);
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_STAIRS);
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_SLAB);
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_WALL);
                    output.accept(EBlocks.DARK_PRISMARINE_BRICKS);
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_STAIRS);
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_SLAB);
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_WALL);
                    output.accept(EBlocks.CHISELED_DARK_PRISMARINE);
                    output.accept(EBlocks.CHISELED_DARK_PRISMARINE_BRICKS);
                    output.accept(EBlocks.DARK_PRISMARINE_PILLAR);

                    // Quartz Brick Fill
                    output.accept(EBlocks.QUARTZ_BRICK_STAIRS);
                    output.accept(EBlocks.QUARTZ_BRICK_SLAB);

                    // Amethyst-Obsidian Set
                    output.accept(EBlocks.AMETHYST_STAIRS);
                    output.accept(EBlocks.AMETHYST_SLAB);
                    output.accept(EBlocks.AMETHYST_BRICKS);
                    output.accept(EBlocks.AMETHYST_BRICK_STAIRS);
                    output.accept(EBlocks.AMETHYST_BRICK_SLAB);
                    output.accept(EBlocks.AMETHYST_PILLAR);
                    output.accept(EBlocks.CHISELED_AMETHYST);

                    output.accept(EBlocks.OBSIDIAN_STAIRS);
                    output.accept(EBlocks.OBSIDIAN_SLAB);
                    output.accept(EBlocks.OBSIDIAN_BRICKS);
                    output.accept(EBlocks.OBSIDIAN_BRICK_STAIRS);
                    output.accept(EBlocks.OBSIDIAN_BRICK_SLAB);
                    output.accept(EBlocks.OBSIDIAN_PILLAR);
                    output.accept(EBlocks.CHISELED_OBSIDIAN);

                    output.accept(EBlocks.CHISELED_PURPUR);

                    output.accept(EBlocks.ICICLE);

                    output.accept(EBlocks.OAK_BOARDS);
                    output.accept(EBlocks.OAK_TRIM);
                    output.accept(EBlocks.OAK_MOSAIC);
                    output.accept(EBlocks.OAK_MOSAIC_STAIRS);
                    output.accept(EBlocks.OAK_MOSAIC_SLAB);
                    output.accept(EBlocks.SPRUCE_BOARDS);
                    output.accept(EBlocks.SPRUCE_TRIM);
                    output.accept(EBlocks.SPRUCE_MOSAIC);
                    output.accept(EBlocks.SPRUCE_MOSAIC_STAIRS);
                    output.accept(EBlocks.SPRUCE_MOSAIC_SLAB);
                    output.accept(EBlocks.BIRCH_BOARDS);
                    output.accept(EBlocks.BIRCH_TRIM);
                    output.accept(EBlocks.BIRCH_MOSAIC);
                    output.accept(EBlocks.BIRCH_MOSAIC_STAIRS);
                    output.accept(EBlocks.BIRCH_MOSAIC_SLAB);
                    output.accept(EBlocks.JUNGLE_BOARDS);
                    output.accept(EBlocks.JUNGLE_TRIM);
                    output.accept(EBlocks.JUNGLE_MOSAIC);
                    output.accept(EBlocks.JUNGLE_MOSAIC_STAIRS);
                    output.accept(EBlocks.JUNGLE_MOSAIC_SLAB);
                    output.accept(EBlocks.ACACIA_BOARDS);
                    output.accept(EBlocks.ACACIA_TRIM);
                    output.accept(EBlocks.ACACIA_MOSAIC);
                    output.accept(EBlocks.ACACIA_MOSAIC_STAIRS);
                    output.accept(EBlocks.ACACIA_MOSAIC_SLAB);
                    output.accept(EBlocks.DARK_OAK_BOARDS);
                    output.accept(EBlocks.DARK_OAK_TRIM);
                    output.accept(EBlocks.DARK_OAK_MOSAIC);
                    output.accept(EBlocks.DARK_OAK_MOSAIC_STAIRS);
                    output.accept(EBlocks.DARK_OAK_MOSAIC_SLAB);
                    output.accept(EBlocks.MANGROVE_BOARDS);
                    output.accept(EBlocks.MANGROVE_TRIM);
                    output.accept(EBlocks.MANGROVE_MOSAIC);
                    output.accept(EBlocks.MANGROVE_MOSAIC_STAIRS);
                    output.accept(EBlocks.MANGROVE_MOSAIC_SLAB);
                    output.accept(EBlocks.CHERRY_BOARDS);
                    output.accept(EBlocks.CHERRY_TRIM);
                    output.accept(EBlocks.CHERRY_MOSAIC);
                    output.accept(EBlocks.CHERRY_MOSAIC_STAIRS);
                    output.accept(EBlocks.CHERRY_MOSAIC_SLAB);
                    output.accept(EBlocks.PALE_OAK_BOARDS);
                    output.accept(EBlocks.PALE_OAK_TRIM);
                    output.accept(EBlocks.PALE_OAK_MOSAIC);
                    output.accept(EBlocks.PALE_OAK_MOSAIC_STAIRS);
                    output.accept(EBlocks.PALE_OAK_MOSAIC_SLAB);
                    output.accept(EBlocks.CRIMSON_BOARDS);
                    output.accept(EBlocks.CRIMSON_TRIM);
                    output.accept(EBlocks.CRIMSON_MOSAIC);
                    output.accept(EBlocks.CRIMSON_MOSAIC_STAIRS);
                    output.accept(EBlocks.CRIMSON_MOSAIC_SLAB);
                    output.accept(EBlocks.WARPED_BOARDS);
                    output.accept(EBlocks.WARPED_TRIM);
                    output.accept(EBlocks.WARPED_MOSAIC);
                    output.accept(EBlocks.WARPED_MOSAIC_STAIRS);
                    output.accept(EBlocks.WARPED_MOSAIC_SLAB);


                })
                .build()

        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.insertAfter(Items.GRASS_BLOCK, EBlocks.ARID_GRASS_BLOCK, EBlocks.RED_GRASS_BLOCK);
            output.insertAfter(Items.DIRT, EBlocks.ARID_DIRT);
            output.insertAfter(Items.PODZOL, EBlocks.LATERITE);
            output.insertAfter(Items.PACKED_ICE, EBlocks.ICICLE);

            output.insertAfter(Items.SHORT_GRASS, EBlocks.SHORT_RED_GRASS);
            output.insertAfter(Items.DEAD_BUSH, EBlocks.RED_SHRUB);
            output.insertAfter(Items.TALL_GRASS, EBlocks.TALL_RED_GRASS);

            output.insertAfter(Items.MOSS_CARPET, EBlocks.RUSTY_MOSS_BLOCK, EBlocks.RUSTY_MOSS_CARPET);

            output.insertAfter(Items.STONE, EBlocks.SHALE);
            output.insertAfter(Items.CALCITE, EBlocks.SODALITE);
            output.insertAfter(Items.POINTED_DRIPSTONE, EBlocks.SULFUR, EBlocks.SULFUR_SPIKE, EBlocks.POTENT_SULFUR, EBlocks.ORPIMENT, EBlocks.CINNABAR);
            output.insertAfter(Items.SOUL_SOIL, EBlocks.SOUL_SANDSTONE);

            output.insertAfter(Items.COAL_ORE, EBlocks.CINNABAR_COAL_ORE, EBlocks.SHALE_COAL_ORE);
            output.insertAfter(Items.IRON_ORE, EBlocks.CINNABAR_IRON_ORE, EBlocks.SHALE_IRON_ORE);
            output.insertAfter(Items.COPPER_ORE, EBlocks.CINNABAR_COPPER_ORE, EBlocks.SHALE_COPPER_ORE);
            output.insertAfter(Items.DEEPSLATE_COPPER_ORE, EBlocks.TIN_ORE, EBlocks.CINNABAR_TIN_ORE, EBlocks.SHALE_TIN_ORE, EBlocks.DEEPSLATE_TIN_ORE);
            output.insertAfter(Items.DEEPSLATE_GOLD_ORE, EBlocks.SILVER_ORE, EBlocks.CINNABAR_SILVER_ORE, EBlocks.SHALE_SILVER_ORE, EBlocks.DEEPSLATE_SILVER_ORE);
            output.insertAfter(Items.REDSTONE_ORE, EBlocks.CINNABAR_REDSTONE_ORE, EBlocks.SHALE_REDSTONE_ORE);
            output.insertAfter(Items.EMERALD_ORE, EBlocks.CINNABAR_EMERALD_ORE, EBlocks.SHALE_EMERALD_ORE);
            output.insertAfter(Items.LAPIS_ORE, EBlocks.CINNABAR_LAPIS_ORE, EBlocks.SHALE_LAPIS_ORE);
            output.insertAfter(Items.DIAMOND_ORE, EBlocks.CINNABAR_DIAMOND_ORE, EBlocks.SHALE_DIAMOND_ORE);

            output.insertBefore(Items.GILDED_BLACKSTONE, EBlocks.BEJEWELED_CALCITE);

            output.insertAfter(Items.RAW_COPPER_BLOCK, EBlocks.RAW_TIN_BLOCK);
            output.insertAfter(Items.RAW_GOLD_BLOCK, EBlocks.RAW_SILVER_BLOCK);

            output.insertAfter(Items.LILY_OF_THE_VALLEY, EBlocks.BLUEBONNET);
            output.insertAfter(Items.PINK_TULIP,
                    EBlocks.RED_HIBISCUS, EBlocks.ORANGE_HIBISCUS, EBlocks.YELLOW_HIBISCUS,
                    EBlocks.BLUE_HIBISCUS, EBlocks.PURPLE_HIBISCUS, EBlocks.PINK_HIBISCUS, EBlocks.WHITE_HIBISCUS
            );
            output.insertAfter(Items.LEAF_LITTER, EBlocks.PEBBLE);

        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {

            // Stone & Shale
            output.insertAfter(Items.STONE_SLAB, EBlocks.STONE_WALL);

            output.insertAfter(Items.SMOOTH_STONE_SLAB,
                    EBlocks.SMOOTH_STONE_STAIRS, EBlocks.SMOOTH_STONE_WALL,
                    EBlocks.CHISELED_STONE,
                    EBlocks.STONE_PILLAR,
                    EBlocks.POLISHED_STONE, EBlocks.POLISHED_STONE_STAIRS, EBlocks.POLISHED_STONE_SLAB, EBlocks.POLISHED_STONE_WALL
            );

            output.insertAfter(Items.MOSSY_STONE_BRICK_WALL,
                    EBlocks.STONE_TILES, EBlocks.STONE_TILE_STAIRS, EBlocks.STONE_TILE_SLAB, EBlocks.STONE_TILE_WALL,
                    EBlocks.MOSSY_STONE_TILES, EBlocks.MOSSY_STONE_TILE_STAIRS, EBlocks.MOSSY_STONE_TILE_SLAB, EBlocks.MOSSY_STONE_TILE_WALL,

                    // Shale
                    EBlocks.SHALE, EBlocks.SHALE_STAIRS, EBlocks.SHALE_SLAB, EBlocks.SHALE_WALL,
                    EBlocks.COBBLESHALE, EBlocks.COBBLESHALE_STAIRS, EBlocks.COBBLESHALE_SLAB, EBlocks.COBBLESHALE_WALL,
                    EBlocks.SMOOTH_SHALE, EBlocks.SMOOTH_SHALE_STAIRS, EBlocks.SMOOTH_SHALE_SLAB, EBlocks.SMOOTH_SHALE_WALL,
                    EBlocks.POLISHED_SHALE, EBlocks.POLISHED_SHALE_STAIRS, EBlocks.POLISHED_SHALE_SLAB, EBlocks.POLISHED_SHALE_WALL,
                    EBlocks.CHISELED_SHALE, EBlocks.SHALE_PILLAR,
                    EBlocks.SHALE_BRICKS, EBlocks.SHALE_BRICK_STAIRS, EBlocks.SHALE_BRICK_SLAB, EBlocks.SHALE_BRICK_WALL,
                    EBlocks.CHISELED_SHALE_BRICKS,
                    EBlocks.SHALE_TILES, EBlocks.SHALE_TILE_STAIRS, EBlocks.SHALE_TILE_SLAB, EBlocks.SHALE_TILE_WALL
            );

            // Deepslate
            output.insertAfter(Items.DEEPSLATE,
                    EBlocks.DEEPSLATE_STAIRS, EBlocks.DEEPSLATE_SLAB, EBlocks.DEEPSLATE_WALL);
            output.insertAfter(Items.COBBLED_DEEPSLATE_WALL,
                    EBlocks.SMOOTH_DEEPSLATE, EBlocks.SMOOTH_DEEPSLATE_STAIRS, EBlocks.SMOOTH_DEEPSLATE_SLAB, EBlocks.SMOOTH_DEEPSLATE_WALL);
            output.insertAfter(Items.CHISELED_DEEPSLATE, EBlocks.DEEPSLATE_PILLAR);
            output.insertAfter(Items.DEEPSLATE_BRICK_WALL, EBlocks.CHISELED_DEEPSLATE_BRICKS);

            // Granite, Diorite, Andesite
            output.insertAfter(Items.GRANITE_WALL,
                    EBlocks.SMOOTH_GRANITE, EBlocks.SMOOTH_GRANITE_STAIRS, EBlocks.SMOOTH_GRANITE_SLAB, EBlocks.SMOOTH_GRANITE_WALL,
                    EBlocks.CHISELED_GRANITE,  EBlocks.GRANITE_PILLAR);
            output.insertAfter(Items.POLISHED_GRANITE_SLAB,
                    EBlocks.POLISHED_GRANITE_WALL,
                    EBlocks.GRANITE_BRICKS, EBlocks.GRANITE_BRICK_STAIRS, EBlocks.GRANITE_BRICK_SLAB, EBlocks.GRANITE_BRICK_WALL,
                    EBlocks.CHISELED_GRANITE_BRICKS);

            output.insertAfter(Items.DIORITE_WALL,
                    EBlocks.SMOOTH_DIORITE, EBlocks.SMOOTH_DIORITE_STAIRS, EBlocks.SMOOTH_DIORITE_SLAB, EBlocks.SMOOTH_DIORITE_WALL,
                    EBlocks.CHISELED_DIORITE, EBlocks.DIORITE_PILLAR);
            output.insertAfter(Items.POLISHED_DIORITE_SLAB,
                    EBlocks.POLISHED_DIORITE_WALL,
                    EBlocks.DIORITE_BRICKS, EBlocks.DIORITE_BRICK_STAIRS, EBlocks.DIORITE_BRICK_SLAB, EBlocks.DIORITE_BRICK_WALL,
                    EBlocks.CHISELED_DIORITE_BRICKS);

            output.insertAfter(Items.ANDESITE_WALL,
                    EBlocks.SMOOTH_ANDESITE, EBlocks.SMOOTH_ANDESITE_STAIRS, EBlocks.SMOOTH_ANDESITE_SLAB, EBlocks.SMOOTH_ANDESITE_WALL,
                    EBlocks.CHISELED_ANDESITE, EBlocks.ANDESITE_PILLAR);
            output.insertAfter(Items.POLISHED_ANDESITE_SLAB,
                    EBlocks.POLISHED_ANDESITE_WALL,
                    EBlocks.ANDESITE_BRICKS, EBlocks.ANDESITE_BRICK_STAIRS, EBlocks.ANDESITE_BRICK_SLAB, EBlocks.ANDESITE_BRICK_WALL,
                    EBlocks.CHISELED_ANDESITE_BRICKS);

            // Tuff
            output.insertAfter(Items.TUFF_WALL,
                    EBlocks.SMOOTH_TUFF, EBlocks.SMOOTH_TUFF_STAIRS, EBlocks.SMOOTH_TUFF_SLAB, EBlocks.SMOOTH_TUFF_WALL);
            output.insertAfter(Items.CHISELED_TUFF, EBlocks.TUFF_PILLAR);

            // Calcite, Sodalite, Dripstone, Sulfur, Orpiment, & Cinnabar
            output.insertAfter(Items.CHISELED_TUFF_BRICKS,
                    Blocks.CALCITE, EBlocks.CALCITE_STAIRS, EBlocks.CALCITE_SLAB, EBlocks.CALCITE_WALL,
                    EBlocks.SMOOTH_CALCITE, EBlocks.SMOOTH_CALCITE_STAIRS, EBlocks.SMOOTH_CALCITE_SLAB, EBlocks.SMOOTH_CALCITE_WALL,
                    EBlocks.CHISELED_CALCITE, EBlocks.CALCITE_PILLAR,
                    EBlocks.POLISHED_CALCITE, EBlocks.POLISHED_CALCITE_STAIRS, EBlocks.POLISHED_CALCITE_SLAB, EBlocks.POLISHED_CALCITE_WALL,
                    EBlocks.CALCITE_BRICKS, EBlocks.CALCITE_BRICK_STAIRS, EBlocks.CALCITE_BRICK_SLAB, EBlocks.CALCITE_BRICK_WALL,
                    EBlocks.CHISELED_CALCITE_BRICKS,

                    EBlocks.SODALITE, EBlocks.SODALITE_STAIRS, EBlocks.SODALITE_SLAB, EBlocks.SODALITE_WALL,
                    EBlocks.SMOOTH_SODALITE, EBlocks.SMOOTH_SODALITE_STAIRS, EBlocks.SMOOTH_SODALITE_SLAB, EBlocks.SMOOTH_SODALITE_WALL,
                    EBlocks.CHISELED_SODALITE, EBlocks.SODALITE_PILLAR,
                    EBlocks.POLISHED_SODALITE, EBlocks.POLISHED_SODALITE_STAIRS, EBlocks.POLISHED_SODALITE_SLAB, EBlocks.POLISHED_SODALITE_WALL,
                    EBlocks.SODALITE_BRICKS, EBlocks.SODALITE_BRICK_STAIRS, EBlocks.SODALITE_BRICK_SLAB, EBlocks.SODALITE_BRICK_WALL,
                    EBlocks.CHISELED_SODALITE_BRICKS,

                    Blocks.DRIPSTONE_BLOCK, EBlocks.DRIPSTONE_STAIRS, EBlocks.DRIPSTONE_SLAB, EBlocks.DRIPSTONE_WALL,
                    EBlocks.SMOOTH_DRIPSTONE, EBlocks.SMOOTH_DRIPSTONE_STAIRS, EBlocks.SMOOTH_DRIPSTONE_SLAB, EBlocks.SMOOTH_DRIPSTONE_WALL,
                    EBlocks.CHISELED_DRIPSTONE, EBlocks.DRIPSTONE_PILLAR,
                    EBlocks.POLISHED_DRIPSTONE, EBlocks.POLISHED_DRIPSTONE_STAIRS, EBlocks.POLISHED_DRIPSTONE_SLAB, EBlocks.POLISHED_DRIPSTONE_WALL,
                    EBlocks.DRIPSTONE_BRICKS, EBlocks.DRIPSTONE_BRICK_STAIRS, EBlocks.DRIPSTONE_BRICK_SLAB, EBlocks.DRIPSTONE_BRICK_WALL,
                    EBlocks.CHISELED_DRIPSTONE_BRICKS,

                    EBlocks.SULFUR, EBlocks.SULFUR_STAIRS, EBlocks.SULFUR_SLAB, EBlocks.SULFUR_WALL,
                    EBlocks.SMOOTH_SULFUR, EBlocks.SMOOTH_SULFUR_STAIRS, EBlocks.SMOOTH_SULFUR_SLAB, EBlocks.SMOOTH_SULFUR_WALL,
                    EBlocks.CHISELED_SULFUR, EBlocks.SULFUR_PILLAR,
                    EBlocks.POLISHED_SULFUR, EBlocks.POLISHED_SULFUR_STAIRS, EBlocks.POLISHED_SULFUR_SLAB, EBlocks.POLISHED_SULFUR_WALL,
                    EBlocks.SULFUR_BRICKS, EBlocks.SULFUR_BRICK_STAIRS, EBlocks.SULFUR_BRICK_SLAB, EBlocks.SULFUR_BRICK_WALL,
                    EBlocks.CHISELED_SULFUR_BRICKS,

                    EBlocks.ORPIMENT, EBlocks.ORPIMENT_STAIRS, EBlocks.ORPIMENT_SLAB, EBlocks.ORPIMENT_WALL,
                    EBlocks.SMOOTH_ORPIMENT, EBlocks.SMOOTH_ORPIMENT_STAIRS, EBlocks.SMOOTH_ORPIMENT_SLAB, EBlocks.SMOOTH_ORPIMENT_WALL,
                    EBlocks.CHISELED_ORPIMENT, EBlocks.ORPIMENT_PILLAR,
                    EBlocks.POLISHED_ORPIMENT, EBlocks.POLISHED_ORPIMENT_STAIRS, EBlocks.POLISHED_ORPIMENT_SLAB, EBlocks.POLISHED_ORPIMENT_WALL,
                    EBlocks.ORPIMENT_BRICKS, EBlocks.ORPIMENT_BRICK_STAIRS, EBlocks.ORPIMENT_BRICK_SLAB, EBlocks.ORPIMENT_BRICK_WALL,
                    EBlocks.CHISELED_ORPIMENT_BRICKS,

                    EBlocks.CINNABAR, EBlocks.CINNABAR_STAIRS, EBlocks.CINNABAR_SLAB, EBlocks.CINNABAR_WALL,
                    EBlocks.SMOOTH_CINNABAR, EBlocks.SMOOTH_CINNABAR_STAIRS, EBlocks.SMOOTH_CINNABAR_SLAB, EBlocks.SMOOTH_CINNABAR_WALL,
                    EBlocks.CHISELED_CINNABAR, EBlocks.CINNABAR_PILLAR,
                    EBlocks.POLISHED_CINNABAR, EBlocks.POLISHED_CINNABAR_STAIRS, EBlocks.POLISHED_CINNABAR_SLAB, EBlocks.POLISHED_CINNABAR_WALL,
                    EBlocks.CINNABAR_BRICKS, EBlocks.CINNABAR_BRICK_STAIRS, EBlocks.CINNABAR_BRICK_SLAB, EBlocks.CINNABAR_BRICK_WALL,
                    EBlocks.CHISELED_CINNABAR_BRICKS);

            // Prismarine
            output.insertAfter(Items.PRISMARINE_WALL,
                    EBlocks.SMOOTH_PRISMARINE, EBlocks.SMOOTH_PRISMARINE_STAIRS, EBlocks.SMOOTH_PRISMARINE_SLAB, EBlocks.SMOOTH_PRISMARINE_WALL,
                    EBlocks.CHISELED_PRISMARINE, EBlocks.PRISMARINE_PILLAR,
                    EBlocks.POLISHED_PRISMARINE, EBlocks.POLISHED_PRISMARINE_STAIRS, EBlocks.POLISHED_PRISMARINE_SLAB, EBlocks.POLISHED_PRISMARINE_WALL);
            output.insertAfter(Items.PRISMARINE_BRICK_SLAB,
                    EBlocks.PRISMARINE_BRICK_WALL,
                    EBlocks.CHISELED_PRISMARINE_BRICKS);

            output.insertAfter(Items.DARK_PRISMARINE_SLAB,
                    EBlocks.DARK_PRISMARINE_WALL,
                    EBlocks.SMOOTH_DARK_PRISMARINE, EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS, EBlocks.SMOOTH_DARK_PRISMARINE_SLAB, EBlocks.SMOOTH_DARK_PRISMARINE_WALL,
                    EBlocks.CHISELED_DARK_PRISMARINE, EBlocks.DARK_PRISMARINE_PILLAR,
                    EBlocks.POLISHED_DARK_PRISMARINE, EBlocks.POLISHED_DARK_PRISMARINE_STAIRS, EBlocks.POLISHED_DARK_PRISMARINE_SLAB, EBlocks.POLISHED_DARK_PRISMARINE_WALL,
                    EBlocks.DARK_PRISMARINE_BRICKS, EBlocks.DARK_PRISMARINE_BRICK_STAIRS, EBlocks.DARK_PRISMARINE_BRICK_SLAB, EBlocks.DARK_PRISMARINE_BRICK_WALL,
                    EBlocks.CHISELED_DARK_PRISMARINE_BRICKS);

            output.insertAfter(Items.NETHERRACK,
                    EBlocks.NETHERRACK_STAIRS, EBlocks.NETHERRACK_SLAB, EBlocks.NETHERRACK_WALL,
                    EBlocks.SMOOTH_NETHERRACK, EBlocks.SMOOTH_NETHERRACK_STAIRS, EBlocks.SMOOTH_NETHERRACK_SLAB, EBlocks.SMOOTH_NETHERRACK_WALL,
                    EBlocks.CHISELED_NETHERRACK, EBlocks.NETHERRACK_PILLAR,
                    EBlocks.POLISHED_NETHERRACK, EBlocks.POLISHED_NETHERRACK_STAIRS, EBlocks.POLISHED_NETHERRACK_SLAB, EBlocks.POLISHED_NETHERRACK_WALL,
                    EBlocks.NETHERRACK_BRICKS, EBlocks.NETHERRACK_BRICK_STAIRS, EBlocks.NETHERRACK_BRICK_SLAB, EBlocks.NETHERRACK_BRICK_WALL,
                    EBlocks.CHISELED_NETHERRACK_BRICKS);

            output.insertAfter(Items.GILDED_BLACKSTONE,
                    EBlocks.SMOOTH_BLACKSTONE, EBlocks.SMOOTH_BLACKSTONE_STAIRS, EBlocks.SMOOTH_BLACKSTONE_SLAB, EBlocks.SMOOTH_BLACKSTONE_WALL);
            output.insertAfter(Items.CHISELED_POLISHED_BLACKSTONE, EBlocks.POLISHED_BLACKSTONE_PILLAR);
            output.insertAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL, EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS);

            // Basalt & End Stone
            output.insertAfter(Items.BASALT, EBlocks.BASALT_SLAB);
            output.insertAfter(Items.SMOOTH_BASALT,
                    EBlocks.SMOOTH_BASALT_STAIRS, EBlocks.SMOOTH_BASALT_SLAB, EBlocks.SMOOTH_BASALT_WALL
                    );
            output.insertAfter(Items.POLISHED_BASALT,
                    EBlocks.POLISHED_BASALT_SLAB,
                    EBlocks.CHISELED_BASALT,
                    EBlocks.BASALT_BRICKS, EBlocks.BASALT_BRICK_STAIRS, EBlocks.BASALT_BRICK_SLAB, EBlocks.BASALT_BRICK_WALL,
                    EBlocks.CHISELED_BASALT_BRICKS
            );

            output.insertAfter(Items.END_STONE,
                    EBlocks.END_STONE_STAIRS, EBlocks.END_STONE_SLAB, EBlocks.END_STONE_WALL,
                    EBlocks.SMOOTH_END_STONE, EBlocks.SMOOTH_END_STONE_STAIRS, EBlocks.SMOOTH_END_STONE_SLAB, EBlocks.SMOOTH_END_STONE_WALL,
                    EBlocks.CHISELED_END_STONE, EBlocks.END_STONE_PILLAR,
                    EBlocks.POLISHED_END_STONE, EBlocks.POLISHED_END_STONE_STAIRS, EBlocks.POLISHED_END_STONE_SLAB, EBlocks.POLISHED_END_STONE_WALL);
            output.insertAfter(Items.END_STONE_BRICK_WALL,
                    EBlocks.CHISELED_END_STONE_BRICKS);

            // Sandstones
            output.insertAfter(Items.SMOOTH_SANDSTONE_SLAB,
                    EBlocks.SMOOTH_SANDSTONE_WALL);
            output.insertAfter(Items.CUT_SANDSTONE, EBlocks.CUT_SANDSTONE_STAIRS);
            output.insertAfter(Blocks.CUT_SANDSTONE_SLAB,
                    EBlocks.CUT_SANDSTONE_WALL,
                    EBlocks.POLISHED_SANDSTONE, EBlocks.POLISHED_SANDSTONE_STAIRS, EBlocks.POLISHED_SANDSTONE_SLAB, EBlocks.POLISHED_SANDSTONE_WALL,
                    EBlocks.SANDSTONE_BRICKS, EBlocks.SANDSTONE_BRICK_STAIRS, EBlocks.SANDSTONE_BRICK_SLAB, EBlocks.SANDSTONE_BRICK_WALL);

            output.insertAfter(Items.SMOOTH_RED_SANDSTONE_SLAB,
                    EBlocks.SMOOTH_RED_SANDSTONE_WALL);
            output.insertAfter(Items.CUT_RED_SANDSTONE, EBlocks.CUT_RED_SANDSTONE_STAIRS);
            output.insertAfter(Items.CUT_RED_SANDSTONE_SLAB,
                    EBlocks.CUT_RED_SANDSTONE_WALL,
                    EBlocks.POLISHED_RED_SANDSTONE, EBlocks.POLISHED_RED_SANDSTONE_STAIRS, EBlocks.POLISHED_RED_SANDSTONE_SLAB, EBlocks.POLISHED_RED_SANDSTONE_WALL,
                    EBlocks.RED_SANDSTONE_BRICKS, EBlocks.RED_SANDSTONE_BRICK_STAIRS, EBlocks.RED_SANDSTONE_BRICK_SLAB, EBlocks.RED_SANDSTONE_BRICK_WALL,

                    EBlocks.SOUL_SANDSTONE, EBlocks.SOUL_SANDSTONE_STAIRS, EBlocks.SOUL_SANDSTONE_SLAB, EBlocks.SOUL_SANDSTONE_WALL,
                    EBlocks.SMOOTH_SOUL_SANDSTONE, EBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, EBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, EBlocks.SMOOTH_SOUL_SANDSTONE_WALL,
                    EBlocks.CUT_SOUL_SANDSTONE, EBlocks.CUT_SOUL_SANDSTONE_STAIRS, EBlocks.CUT_SOUL_SANDSTONE_SLAB, EBlocks.CUT_SOUL_SANDSTONE_WALL,
                    EBlocks.CHISELED_SOUL_SANDSTONE,
                    EBlocks.POLISHED_SOUL_SANDSTONE, EBlocks.POLISHED_SOUL_SANDSTONE_STAIRS, EBlocks.POLISHED_SOUL_SANDSTONE_SLAB, EBlocks.POLISHED_SOUL_SANDSTONE_WALL,
                    EBlocks.SOUL_SANDSTONE_BRICKS, EBlocks.SOUL_SANDSTONE_BRICK_STAIRS, EBlocks.SOUL_SANDSTONE_BRICK_SLAB, EBlocks.SOUL_SANDSTONE_BRICK_WALL);

            // Mud, Quartz, & Amethyst
            output.insertAfter(Items.PACKED_MUD,
                    EBlocks.PACKED_MUD_STAIRS, EBlocks.PACKED_MUD_SLAB, EBlocks.PACKED_MUD_WALL);
            output.insertAfter(Items.MUD_BRICK_WALL,
                    EBlocks.CHISELED_MUD_BRICKS, EBlocks.MUD_BRICK_PILLAR);

            output.insertAfter(Items.QUARTZ_BRICKS,
                    EBlocks.QUARTZ_BRICK_STAIRS, EBlocks.QUARTZ_BRICK_SLAB);

            output.insertAfter(
                    Items.AMETHYST_BLOCK, EBlocks.AMETHYST_STAIRS, EBlocks.AMETHYST_SLAB, EBlocks.CHISELED_AMETHYST,
                    EBlocks.AMETHYST_BRICKS, EBlocks.AMETHYST_BRICK_STAIRS, EBlocks.AMETHYST_BRICK_SLAB, EBlocks.AMETHYST_PILLAR,
                    Blocks.OBSIDIAN, EBlocks.OBSIDIAN_STAIRS, EBlocks.OBSIDIAN_SLAB, EBlocks.CHISELED_OBSIDIAN,
                    EBlocks.OBSIDIAN_BRICKS, EBlocks.OBSIDIAN_BRICK_STAIRS, EBlocks.OBSIDIAN_BRICK_SLAB, EBlocks.OBSIDIAN_PILLAR
            );

            // Purpur
            output.insertAfter(Items.PURPUR_PILLAR,
                    EBlocks.CHISELED_PURPUR);

            // Planks & Mosaics, Boards & Trims
            output.insertAfter(Items.OAK_PLANKS, EBlocks.OAK_MOSAIC);
            output.insertAfter(Items.OAK_STAIRS, EBlocks.OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.OAK_SLAB, EBlocks.OAK_MOSAIC_SLAB, EBlocks.OAK_BOARDS, EBlocks.OAK_TRIM);

            output.insertAfter(Items.SPRUCE_PLANKS, EBlocks.SPRUCE_MOSAIC);
            output.insertAfter(Items.SPRUCE_STAIRS, EBlocks.SPRUCE_MOSAIC_STAIRS);
            output.insertAfter(Items.SPRUCE_SLAB, EBlocks.SPRUCE_MOSAIC_SLAB, EBlocks.SPRUCE_BOARDS, EBlocks.SPRUCE_TRIM);

            output.insertAfter(Items.BIRCH_PLANKS, EBlocks.BIRCH_MOSAIC);
            output.insertAfter(Items.BIRCH_STAIRS, EBlocks.BIRCH_MOSAIC_STAIRS);
            output.insertAfter(Items.BIRCH_SLAB, EBlocks.BIRCH_MOSAIC_SLAB, EBlocks.BIRCH_BOARDS, EBlocks.BIRCH_TRIM);

            output.insertAfter(Items.JUNGLE_PLANKS, EBlocks.JUNGLE_MOSAIC);
            output.insertAfter(Items.JUNGLE_STAIRS, EBlocks.JUNGLE_MOSAIC_STAIRS);
            output.insertAfter(Items.JUNGLE_SLAB, EBlocks.JUNGLE_MOSAIC_SLAB, EBlocks.JUNGLE_BOARDS, EBlocks.JUNGLE_TRIM);

            output.insertAfter(Items.ACACIA_PLANKS, EBlocks.ACACIA_MOSAIC);
            output.insertAfter(Items.ACACIA_STAIRS, EBlocks.ACACIA_MOSAIC_STAIRS);
            output.insertAfter(Items.ACACIA_SLAB, EBlocks.ACACIA_MOSAIC_SLAB, EBlocks.ACACIA_BOARDS, EBlocks.ACACIA_TRIM);

            output.insertAfter(Items.DARK_OAK_PLANKS, EBlocks.DARK_OAK_MOSAIC);
            output.insertAfter(Items.DARK_OAK_STAIRS, EBlocks.DARK_OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.DARK_OAK_SLAB, EBlocks.DARK_OAK_MOSAIC_SLAB, EBlocks.DARK_OAK_BOARDS, EBlocks.DARK_OAK_TRIM);

            output.insertAfter(Items.MANGROVE_PLANKS, EBlocks.MANGROVE_MOSAIC);
            output.insertAfter(Items.MANGROVE_STAIRS, EBlocks.MANGROVE_MOSAIC_STAIRS);
            output.insertAfter(Items.MANGROVE_SLAB, EBlocks.MANGROVE_MOSAIC_SLAB, EBlocks.MANGROVE_BOARDS, EBlocks.MANGROVE_TRIM);

            output.insertAfter(Items.CHERRY_PLANKS, EBlocks.CHERRY_MOSAIC);
            output.insertAfter(Items.CHERRY_STAIRS, EBlocks.CHERRY_MOSAIC_STAIRS);
            output.insertAfter(Items.CHERRY_SLAB, EBlocks.CHERRY_MOSAIC_SLAB, EBlocks.CHERRY_BOARDS, EBlocks.CHERRY_TRIM);

            output.insertAfter(Items.PALE_OAK_PLANKS, EBlocks.PALE_OAK_MOSAIC);
            output.insertAfter(Items.PALE_OAK_STAIRS, EBlocks.PALE_OAK_MOSAIC_STAIRS);
            output.insertAfter(Items.PALE_OAK_SLAB, EBlocks.PALE_OAK_MOSAIC_SLAB, EBlocks.PALE_OAK_BOARDS, EBlocks.PALE_OAK_TRIM);

            output.insertAfter(Items.CRIMSON_PLANKS, EBlocks.CRIMSON_MOSAIC);
            output.insertAfter(Items.CRIMSON_STAIRS, EBlocks.CRIMSON_MOSAIC_STAIRS);
            output.insertAfter(Items.CRIMSON_SLAB, EBlocks.CRIMSON_MOSAIC_SLAB, EBlocks.CRIMSON_BOARDS, EBlocks.CRIMSON_TRIM);

            output.insertAfter(Items.WARPED_PLANKS, EBlocks.WARPED_MOSAIC);
            output.insertAfter(Items.WARPED_STAIRS, EBlocks.WARPED_MOSAIC_STAIRS);
            output.insertAfter(Items.WARPED_SLAB, EBlocks.WARPED_MOSAIC_SLAB, EBlocks.WARPED_BOARDS, EBlocks.WARPED_TRIM);

            output.insertAfter(Items.BAMBOO_BLOCK, EBlocks.BAMBOO_STEM);
            output.insertAfter(Items.STRIPPED_BAMBOO_BLOCK, EBlocks.STRIPPED_BAMBOO_STEM);
            output.insertAfter(Items.BAMBOO_MOSAIC_SLAB, EBlocks.BAMBOO_BOARDS, EBlocks.BAMBOO_TRIM);

            output.insertAfter(Blocks.PALE_OAK_BUTTON,
                    EBlocks.POPLAR_LOG, EBlocks.POPLAR_WOOD,
                    EBlocks.STRIPPED_POPLAR_LOG, EBlocks.STRIPPED_POPLAR_WOOD,
                    EBlocks.POPLAR_PLANKS, EBlocks.POPLAR_MOSAIC,
                    EBlocks.POPLAR_STAIRS, EBlocks.POPLAR_MOSAIC_STAIRS,
                    EBlocks.POPLAR_SLAB, EBlocks.POPLAR_MOSAIC_SLAB,
                    EBlocks.POPLAR_BOARDS, EBlocks.POPLAR_TRIM,
                    EBlocks.POPLAR_FENCE, EBlocks.POPLAR_FENCE_GATE,
                    EBlocks.POPLAR_DOOR, EBlocks.POPLAR_TRAPDOOR,
                    EBlocks.POPLAR_PRESSURE_PLATE, EBlocks.POPLAR_BUTTON,

                    EBlocks.AZALEA_LOG, EBlocks.AZALEA_WOOD,
                    EBlocks.STRIPPED_AZALEA_LOG, EBlocks.STRIPPED_AZALEA_WOOD,
                    EBlocks.AZALEA_PLANKS, EBlocks.AZALEA_MOSAIC,
                    EBlocks.AZALEA_STAIRS, EBlocks.AZALEA_MOSAIC_STAIRS,
                    EBlocks.AZALEA_SLAB, EBlocks.AZALEA_MOSAIC_SLAB,
                    EBlocks.AZALEA_BOARDS, EBlocks.AZALEA_TRIM,
                    EBlocks.AZALEA_FENCE, EBlocks.AZALEA_FENCE_GATE,
                    EBlocks.AZALEA_DOOR, EBlocks.AZALEA_TRAPDOOR,
                    EBlocks.AZALEA_PRESSURE_PLATE, EBlocks.AZALEA_BUTTON
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> {
            output.insertAfter(Items.WHITE_WOOL, EBlocks.WHITE_WOOL_STAIRS, EBlocks.WHITE_WOOL_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_WOOL, EBlocks.LIGHT_GRAY_WOOL_STAIRS, EBlocks.LIGHT_GRAY_WOOL_SLAB);
            output.insertAfter(Items.GRAY_WOOL, EBlocks.GRAY_WOOL_STAIRS, EBlocks.GRAY_WOOL_SLAB);
            output.insertAfter(Items.BLACK_WOOL, EBlocks.BLACK_WOOL_STAIRS, EBlocks.BLACK_WOOL_SLAB);
            output.insertAfter(Items.BROWN_WOOL, EBlocks.BROWN_WOOL_STAIRS, EBlocks.BROWN_WOOL_SLAB);
            output.insertAfter(Items.RED_WOOL, EBlocks.RED_WOOL_STAIRS, EBlocks.RED_WOOL_SLAB);
            output.insertAfter(Items.ORANGE_WOOL, EBlocks.ORANGE_WOOL_STAIRS, EBlocks.ORANGE_WOOL_SLAB);
            output.insertAfter(Items.YELLOW_WOOL, EBlocks.YELLOW_WOOL_STAIRS, EBlocks.YELLOW_WOOL_SLAB);
            output.insertAfter(Items.LIME_WOOL, EBlocks.LIME_WOOL_STAIRS, EBlocks.LIME_WOOL_SLAB);
            output.insertAfter(Items.GREEN_WOOL, EBlocks.GREEN_WOOL_STAIRS, EBlocks.GREEN_WOOL_SLAB);
            output.insertAfter(Items.CYAN_WOOL, EBlocks.CYAN_WOOL_STAIRS, EBlocks.CYAN_WOOL_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_WOOL, EBlocks.LIGHT_BLUE_WOOL_STAIRS, EBlocks.LIGHT_BLUE_WOOL_SLAB);
            output.insertAfter(Items.BLUE_WOOL, EBlocks.BLUE_WOOL_STAIRS, EBlocks.BLUE_WOOL_SLAB);
            output.insertAfter(Items.PURPLE_WOOL, EBlocks.PURPLE_WOOL_STAIRS, EBlocks.PURPLE_WOOL_SLAB);
            output.insertAfter(Items.MAGENTA_WOOL, EBlocks.MAGENTA_WOOL_STAIRS, EBlocks.MAGENTA_WOOL_SLAB);
            output.insertAfter(Items.PINK_WOOL, EBlocks.PINK_WOOL_STAIRS, EBlocks.PINK_WOOL_SLAB);

            output.insertAfter(Items.TERRACOTTA, EBlocks.TERRACOTTA_STAIRS, EBlocks.TERRACOTTA_SLAB);
            output.insertAfter(Items.WHITE_TERRACOTTA, EBlocks.WHITE_TERRACOTTA_STAIRS, EBlocks.WHITE_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_TERRACOTTA, EBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, EBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
            output.insertAfter(Items.GRAY_TERRACOTTA, EBlocks.GRAY_TERRACOTTA_STAIRS, EBlocks.GRAY_TERRACOTTA_SLAB);
            output.insertAfter(Items.BLACK_TERRACOTTA, EBlocks.BLACK_TERRACOTTA_STAIRS, EBlocks.BLACK_TERRACOTTA_SLAB);
            output.insertAfter(Items.BROWN_TERRACOTTA, EBlocks.BROWN_TERRACOTTA_STAIRS, EBlocks.BROWN_TERRACOTTA_SLAB);
            output.insertAfter(Items.RED_TERRACOTTA, EBlocks.RED_TERRACOTTA_STAIRS, EBlocks.RED_TERRACOTTA_SLAB);
            output.insertAfter(Items.ORANGE_TERRACOTTA, EBlocks.ORANGE_TERRACOTTA_STAIRS, EBlocks.ORANGE_TERRACOTTA_SLAB);
            output.insertAfter(Items.YELLOW_TERRACOTTA, EBlocks.YELLOW_TERRACOTTA_STAIRS, EBlocks.YELLOW_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIME_TERRACOTTA, EBlocks.LIME_TERRACOTTA_STAIRS, EBlocks.LIME_TERRACOTTA_SLAB);
            output.insertAfter(Items.GREEN_TERRACOTTA, EBlocks.GREEN_TERRACOTTA_STAIRS, EBlocks.GREEN_TERRACOTTA_SLAB);
            output.insertAfter(Items.CYAN_TERRACOTTA, EBlocks.CYAN_TERRACOTTA_STAIRS, EBlocks.CYAN_TERRACOTTA_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_TERRACOTTA, EBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, EBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
            output.insertAfter(Items.BLUE_TERRACOTTA, EBlocks.BLUE_TERRACOTTA_STAIRS, EBlocks.BLUE_TERRACOTTA_SLAB);
            output.insertAfter(Items.PURPLE_TERRACOTTA, EBlocks.PURPLE_TERRACOTTA_STAIRS, EBlocks.PURPLE_TERRACOTTA_SLAB);
            output.insertAfter(Items.MAGENTA_TERRACOTTA, EBlocks.MAGENTA_TERRACOTTA_STAIRS, EBlocks.MAGENTA_TERRACOTTA_SLAB);
            output.insertAfter(Items.PINK_TERRACOTTA, EBlocks.PINK_TERRACOTTA_STAIRS, EBlocks.PINK_TERRACOTTA_SLAB);

            output.insertAfter(Items.WHITE_CONCRETE, EBlocks.WHITE_CONCRETE_STAIRS, EBlocks.WHITE_CONCRETE_SLAB);
            output.insertAfter(Items.LIGHT_GRAY_CONCRETE, EBlocks.LIGHT_GRAY_CONCRETE_STAIRS, EBlocks.LIGHT_GRAY_CONCRETE_SLAB);
            output.insertAfter(Items.GRAY_CONCRETE, EBlocks.GRAY_CONCRETE_STAIRS, EBlocks.GRAY_CONCRETE_SLAB);
            output.insertAfter(Items.BLACK_CONCRETE, EBlocks.BLACK_CONCRETE_STAIRS, EBlocks.BLACK_CONCRETE_SLAB);
            output.insertAfter(Items.BROWN_CONCRETE, EBlocks.BROWN_CONCRETE_STAIRS, EBlocks.BROWN_CONCRETE_SLAB);
            output.insertAfter(Items.RED_CONCRETE, EBlocks.RED_CONCRETE_STAIRS, EBlocks.RED_CONCRETE_SLAB);
            output.insertAfter(Items.ORANGE_CONCRETE, EBlocks.ORANGE_CONCRETE_STAIRS, EBlocks.ORANGE_CONCRETE_SLAB);
            output.insertAfter(Items.YELLOW_CONCRETE, EBlocks.YELLOW_CONCRETE_STAIRS, EBlocks.YELLOW_CONCRETE_SLAB);
            output.insertAfter(Items.LIME_CONCRETE, EBlocks.LIME_CONCRETE_STAIRS, EBlocks.LIME_CONCRETE_SLAB);
            output.insertAfter(Items.GREEN_CONCRETE, EBlocks.GREEN_CONCRETE_STAIRS, EBlocks.GREEN_CONCRETE_SLAB);
            output.insertAfter(Items.CYAN_CONCRETE, EBlocks.CYAN_CONCRETE_STAIRS, EBlocks.CYAN_CONCRETE_SLAB);
            output.insertAfter(Items.LIGHT_BLUE_CONCRETE, EBlocks.LIGHT_BLUE_CONCRETE_STAIRS, EBlocks.LIGHT_BLUE_CONCRETE_SLAB);
            output.insertAfter(Items.BLUE_CONCRETE, EBlocks.BLUE_CONCRETE_STAIRS, EBlocks.BLUE_CONCRETE_SLAB);
            output.insertAfter(Items.PURPLE_CONCRETE, EBlocks.PURPLE_CONCRETE_STAIRS, EBlocks.PURPLE_CONCRETE_SLAB);
            output.insertAfter(Items.MAGENTA_CONCRETE, EBlocks.MAGENTA_CONCRETE_STAIRS, EBlocks.MAGENTA_CONCRETE_SLAB);
            output.insertAfter(Items.PINK_CONCRETE, EBlocks.PINK_CONCRETE_STAIRS, EBlocks.PINK_CONCRETE_SLAB);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> {
            output.insertAfter(Items.DROWNED_SPAWN_EGG, EItems.FROSTBITE_SPAWN_EGG);
            output.insertBefore(Items.PUFFERFISH_SPAWN_EGG, EItems.PERCH_SPAWN_EGG);
        });


    }




}
