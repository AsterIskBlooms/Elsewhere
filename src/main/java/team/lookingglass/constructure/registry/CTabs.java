package team.lookingglass.constructure.registry;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import team.lookingglass.constructure.Constructure;

public class CTabs {
    private static final ResourceKey<CreativeModeTab> ECOLOGICAL = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Constructure.MODID, "ecological_tab"));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ECOLOGICAL, FabricCreativeModeTab.builder()
                .title(Component.translatable("ecological.tab"))
                .icon(() -> new ItemStack(CBlocks.STONE_TILES))
                .displayItems((context, output) -> {
                    // Quartz Brick Fill
                    output.accept(CBlocks.QUARTZ_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.QUARTZ_BRICK_SLAB.asItem());

                    // Amethyst-Obsidian Set
                    output.accept(CBlocks.AMETHYST_STAIRS.asItem());
                    output.accept(CBlocks.AMETHYST_SLAB.asItem());
                    output.accept(CBlocks.AMETHYST_BRICKS.asItem());
                    output.accept(CBlocks.AMETHYST_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.AMETHYST_BRICK_SLAB.asItem());
                    output.accept(CBlocks.AMETHYST_PILLAR.asItem());
                    output.accept(CBlocks.CHISELED_AMETHYST.asItem());

                    output.accept(CBlocks.OBSIDIAN_STAIRS.asItem());
                    output.accept(CBlocks.OBSIDIAN_SLAB.asItem());
                    output.accept(CBlocks.OBSIDIAN_BRICKS.asItem());
                    output.accept(CBlocks.OBSIDIAN_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.OBSIDIAN_BRICK_SLAB.asItem());
                    output.accept(CBlocks.OBSIDIAN_PILLAR.asItem());
                    output.accept(CBlocks.CHISELED_OBSIDIAN.asItem());

                    // Stone Set
                    output.accept(CBlocks.STONE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_STONE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_STONE_WALL.asItem());

                    output.accept(CBlocks.POLISHED_STONE.asItem());
                    output.accept(CBlocks.POLISHED_STONE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_STONE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_STONE_WALL.asItem());

                    output.accept(CBlocks.CHISELED_STONE.asItem());
                    output.accept(CBlocks.STONE_TILES.asItem());
                    output.accept(CBlocks.STONE_TILE_STAIRS.asItem());
                    output.accept(CBlocks.STONE_TILE_SLAB.asItem());
                    output.accept(CBlocks.STONE_TILE_WALL.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILES.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_WALL.asItem());
                    output.accept(CBlocks.STONE_PILLAR.asItem());

                    output.accept(CBlocks.SHALE.asItem());
                    output.accept(CBlocks.SHALE_STAIRS.asItem());
                    output.accept(CBlocks.SHALE_SLAB.asItem());
                    output.accept(CBlocks.SHALE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_SHALE.asItem());
                    output.accept(CBlocks.SMOOTH_SHALE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_SHALE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_SHALE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_SHALE.asItem());
                    output.accept(CBlocks.POLISHED_SHALE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_SHALE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_SHALE_WALL.asItem());
                    output.accept(CBlocks.SHALE_BRICKS.asItem());
                    output.accept(CBlocks.SHALE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.SHALE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.SHALE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_SHALE.asItem());
                    output.accept(CBlocks.CHISELED_SHALE_BRICKS.asItem());
                    output.accept(CBlocks.SHALE_PILLAR.asItem());
                    output.accept(CBlocks.COBBLESHALE.asItem());
                    output.accept(CBlocks.COBBLESHALE_STAIRS.asItem());
                    output.accept(CBlocks.COBBLESHALE_SLAB.asItem());
                    output.accept(CBlocks.COBBLESHALE_WALL.asItem());
                    output.accept(CBlocks.SHALE_TILES.asItem());
                    output.accept(CBlocks.SHALE_TILE_STAIRS.asItem());
                    output.accept(CBlocks.SHALE_TILE_SLAB.asItem());
                    output.accept(CBlocks.SHALE_TILE_WALL.asItem());

                    output.accept(CBlocks.SHALE_COAL_ORE.asItem());
                    output.accept(CBlocks.SHALE_COPPER_ORE.asItem());
                    output.accept(CBlocks.SHALE_IRON_ORE.asItem());
                    output.accept(CBlocks.SHALE_GOLD_ORE.asItem());
                    output.accept(CBlocks.SHALE_REDSTONE_ORE.asItem());
                    output.accept(CBlocks.SHALE_DIAMOND_ORE.asItem());
                    output.accept(CBlocks.SHALE_LAPIS_ORE.asItem());
                    output.accept(CBlocks.SHALE_EMERALD_ORE.asItem());

                    output.accept(CBlocks.SMOOTH_DEEPSLATE.asItem());
                    output.accept(CBlocks.SMOOTH_DEEPSLATE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_DEEPSLATE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_DEEPSLATE_WALL.asItem());

                    output.accept(CBlocks.CHISELED_DEEPSLATE_BRICKS.asItem());
                    output.accept(CBlocks.DEEPSLATE_PILLAR.asItem());

                    output.accept(CBlocks.SMOOTH_TUFF.asItem());
                    output.accept(CBlocks.SMOOTH_TUFF_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_TUFF_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_TUFF_WALL.asItem());
                    output.accept(CBlocks.TUFF_PILLAR.asItem());

                    output.accept(CBlocks.SMOOTH_BLACKSTONE.asItem());
                    output.accept(CBlocks.SMOOTH_BLACKSTONE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_BLACKSTONE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_BLACKSTONE_WALL.asItem());
                    output.accept(CBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS.asItem());
                    output.accept(CBlocks.POLISHED_BLACKSTONE_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_ANDESITE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_ANDESITE.asItem());
                    output.accept(CBlocks.SMOOTH_ANDESITE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_ANDESITE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_ANDESITE_WALL.asItem());
                    output.accept(CBlocks.ANDESITE_BRICKS.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_ANDESITE.asItem());
                    output.accept(CBlocks.CHISELED_ANDESITE_BRICKS.asItem());
                    output.accept(CBlocks.ANDESITE_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_GRANITE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_GRANITE.asItem());
                    output.accept(CBlocks.SMOOTH_GRANITE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_GRANITE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_GRANITE_WALL.asItem());
                    output.accept(CBlocks.GRANITE_BRICKS.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_GRANITE.asItem());
                    output.accept(CBlocks.CHISELED_GRANITE_BRICKS.asItem());
                    output.accept(CBlocks.GRANITE_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_DIORITE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_DIORITE.asItem());
                    output.accept(CBlocks.SMOOTH_DIORITE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_DIORITE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_DIORITE_WALL.asItem());
                    output.accept(CBlocks.DIORITE_BRICKS.asItem());
                    output.accept(CBlocks.DIORITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.DIORITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.DIORITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_DIORITE.asItem());
                    output.accept(CBlocks.CHISELED_DIORITE_BRICKS.asItem());
                    output.accept(CBlocks.DIORITE_PILLAR.asItem());

                    output.accept(CBlocks.CALCITE_STAIRS.asItem());
                    output.accept(CBlocks.CALCITE_SLAB.asItem());
                    output.accept(CBlocks.CALCITE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_CALCITE.asItem());
                    output.accept(CBlocks.SMOOTH_CALCITE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_CALCITE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_CALCITE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_CALCITE.asItem());
                    output.accept(CBlocks.POLISHED_CALCITE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_CALCITE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_CALCITE_WALL.asItem());
                    output.accept(CBlocks.CALCITE_BRICKS.asItem());
                    output.accept(CBlocks.CALCITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.CALCITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.CALCITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_CALCITE.asItem());
                    output.accept(CBlocks.CHISELED_CALCITE_BRICKS.asItem());
                    output.accept(CBlocks.CALCITE_PILLAR.asItem());

                    output.accept(CBlocks.DRIPSTONE_STAIRS.asItem());
                    output.accept(CBlocks.DRIPSTONE_SLAB.asItem());
                    output.accept(CBlocks.DRIPSTONE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_DRIPSTONE.asItem());
                    output.accept(CBlocks.SMOOTH_DRIPSTONE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_DRIPSTONE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_DRIPSTONE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_DRIPSTONE.asItem());
                    output.accept(CBlocks.POLISHED_DRIPSTONE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_DRIPSTONE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_DRIPSTONE_WALL.asItem());
                    output.accept(CBlocks.DRIPSTONE_BRICKS.asItem());
                    output.accept(CBlocks.DRIPSTONE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.DRIPSTONE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.DRIPSTONE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_DRIPSTONE.asItem());
                    output.accept(CBlocks.CHISELED_DRIPSTONE_BRICKS.asItem());
                    output.accept(CBlocks.DRIPSTONE_PILLAR.asItem());

                    output.accept(CBlocks.BASALT_STAIRS.asItem());
                    output.accept(CBlocks.BASALT_SLAB.asItem());
                    output.accept(CBlocks.BASALT_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_BASALT_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_BASALT_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_BASALT_WALL.asItem());
                    output.accept(CBlocks.POLISHED_BASALT_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_BASALT_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_BASALT_WALL.asItem());
                    output.accept(CBlocks.BASALT_BRICKS.asItem());
                    output.accept(CBlocks.BASALT_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.BASALT_BRICK_SLAB.asItem());
                    output.accept(CBlocks.BASALT_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_BASALT.asItem());
                    output.accept(CBlocks.CHISELED_BASALT_BRICKS.asItem());
                    output.accept(CBlocks.BASALT_PILLAR.asItem());

                    output.accept(CBlocks.SODALITE.asItem());
                    output.accept(CBlocks.SODALITE_STAIRS.asItem());
                    output.accept(CBlocks.SODALITE_SLAB.asItem());
                    output.accept(CBlocks.SODALITE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_SODALITE.asItem());
                    output.accept(CBlocks.SMOOTH_SODALITE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_SODALITE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_SODALITE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_SODALITE.asItem());
                    output.accept(CBlocks.POLISHED_SODALITE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_SODALITE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_SODALITE_WALL.asItem());
                    output.accept(CBlocks.SODALITE_BRICKS.asItem());
                    output.accept(CBlocks.SODALITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.SODALITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.SODALITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_SODALITE.asItem());
                    output.accept(CBlocks.CHISELED_SODALITE_BRICKS.asItem());
                    output.accept(CBlocks.SODALITE_PILLAR.asItem());

                    output.accept(CBlocks.END_STONE_STAIRS.asItem());
                    output.accept(CBlocks.END_STONE_SLAB.asItem());
                    output.accept(CBlocks.END_STONE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_END_STONE.asItem());
                    output.accept(CBlocks.SMOOTH_END_STONE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_END_STONE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_END_STONE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_END_STONE.asItem());
                    output.accept(CBlocks.POLISHED_END_STONE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_END_STONE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_END_STONE_WALL.asItem());
                    output.accept(CBlocks.CHISELED_END_STONE.asItem());
                    output.accept(CBlocks.CHISELED_END_STONE_BRICKS.asItem());
                    output.accept(CBlocks.END_STONE_PILLAR.asItem());

                    output.accept(CBlocks.SMOOTH_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.CUT_SANDSTONE_STAIRS.asItem());
                    output.accept(CBlocks.CUT_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_SANDSTONE.asItem());
                    output.accept(CBlocks.POLISHED_SANDSTONE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_SANDSTONE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.SANDSTONE_BRICKS.asItem());
                    output.accept(CBlocks.SANDSTONE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.SANDSTONE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.SANDSTONE_BRICK_WALL.asItem());

                    output.accept(CBlocks.SMOOTH_RED_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.CUT_RED_SANDSTONE_STAIRS.asItem());
                    output.accept(CBlocks.CUT_RED_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_RED_SANDSTONE.asItem());
                    output.accept(CBlocks.POLISHED_RED_SANDSTONE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_RED_SANDSTONE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_RED_SANDSTONE_WALL.asItem());
                    output.accept(CBlocks.RED_SANDSTONE_BRICKS.asItem());
                    output.accept(CBlocks.RED_SANDSTONE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.RED_SANDSTONE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.RED_SANDSTONE_BRICK_WALL.asItem());

                    output.accept(CBlocks.SMOOTH_PRISMARINE.asItem());
                    output.accept(CBlocks.SMOOTH_PRISMARINE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_PRISMARINE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_PRISMARINE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_PRISMARINE.asItem());
                    output.accept(CBlocks.POLISHED_PRISMARINE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_PRISMARINE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_PRISMARINE_WALL.asItem());
                    output.accept(CBlocks.PRISMARINE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_PRISMARINE.asItem());
                    output.accept(CBlocks.CHISELED_PRISMARINE_BRICKS.asItem());
                    output.accept(CBlocks.PRISMARINE_PILLAR.asItem());

                    output.accept(CBlocks.DARK_PRISMARINE_WALL.asItem());
                    output.accept(CBlocks.SMOOTH_DARK_PRISMARINE.asItem());
                    output.accept(CBlocks.SMOOTH_DARK_PRISMARINE_STAIRS.asItem());
                    output.accept(CBlocks.SMOOTH_DARK_PRISMARINE_SLAB.asItem());
                    output.accept(CBlocks.SMOOTH_DARK_PRISMARINE_WALL.asItem());
                    output.accept(CBlocks.POLISHED_DARK_PRISMARINE.asItem());
                    output.accept(CBlocks.POLISHED_DARK_PRISMARINE_STAIRS.asItem());
                    output.accept(CBlocks.POLISHED_DARK_PRISMARINE_SLAB.asItem());
                    output.accept(CBlocks.POLISHED_DARK_PRISMARINE_WALL.asItem());
                    output.accept(CBlocks.DARK_PRISMARINE_BRICKS.asItem());
                    output.accept(CBlocks.DARK_PRISMARINE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.DARK_PRISMARINE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.DARK_PRISMARINE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_DARK_PRISMARINE.asItem());
                    output.accept(CBlocks.CHISELED_DARK_PRISMARINE_BRICKS.asItem());
                    output.accept(CBlocks.DARK_PRISMARINE_PILLAR.asItem());

                    output.accept(CBlocks.CHISELED_PURPUR.asItem());

                    output.accept(CBlocks.OAK_MOSAIC.asItem());
                    output.accept(CBlocks.OAK_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.OAK_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.SPRUCE_MOSAIC.asItem());
                    output.accept(CBlocks.SPRUCE_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.SPRUCE_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.BIRCH_MOSAIC.asItem());
                    output.accept(CBlocks.BIRCH_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.BIRCH_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.JUNGLE_MOSAIC.asItem());
                    output.accept(CBlocks.JUNGLE_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.JUNGLE_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.ACACIA_MOSAIC.asItem());
                    output.accept(CBlocks.ACACIA_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.ACACIA_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.DARK_OAK_MOSAIC.asItem());
                    output.accept(CBlocks.DARK_OAK_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.DARK_OAK_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.MANGROVE_MOSAIC.asItem());
                    output.accept(CBlocks.MANGROVE_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.MANGROVE_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.CHERRY_MOSAIC.asItem());
                    output.accept(CBlocks.CHERRY_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.CHERRY_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.PALE_OAK_MOSAIC.asItem());
                    output.accept(CBlocks.PALE_OAK_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.PALE_OAK_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.CRIMSON_MOSAIC.asItem());
                    output.accept(CBlocks.CRIMSON_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.CRIMSON_MOSAIC_SLAB.asItem());
                    output.accept(CBlocks.WARPED_MOSAIC.asItem());
                    output.accept(CBlocks.WARPED_MOSAIC_STAIRS.asItem());
                    output.accept(CBlocks.WARPED_MOSAIC_SLAB.asItem());

                    output.accept(CBlocks.BLUEBONNET.asItem());


                })
                .build()

        );


    }




}
