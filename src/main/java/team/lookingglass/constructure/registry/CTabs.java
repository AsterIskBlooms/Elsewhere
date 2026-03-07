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

public class CTabs {
    private static final ResourceKey<CreativeModeTab> CONSTRUCTURE = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(team.lookingglass.constructure.Constructure.MODID, "constructure_tab"));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CONSTRUCTURE, FabricCreativeModeTab.builder()
                .title(Component.translatable("constructure.building_tab"))
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

                    output.accept(CBlocks.CHISELED_STONE_BRICKS.asItem());
                    output.accept(CBlocks.STONE_TILES.asItem());
                    output.accept(CBlocks.STONE_TILE_STAIRS.asItem());
                    output.accept(CBlocks.STONE_TILE_SLAB.asItem());
                    output.accept(CBlocks.STONE_TILE_WALL.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILES.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                    output.accept(CBlocks.MOSSY_STONE_TILE_WALL.asItem());
                    output.accept(CBlocks.STONE_PILLAR.asItem());

                    output.accept(CBlocks.CHISELED_DEEPSLATE_BRICKS.asItem());
                    output.accept(CBlocks.DEEPSLATE_PILLAR.asItem());

                    output.accept(CBlocks.TUFF_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_ANDESITE_WALL.asItem());
                    output.accept(CBlocks.ANDESITE_BRICKS.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.ANDESITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_ANDESITE.asItem());
                    output.accept(CBlocks.CHISELED_ANDESITE_BRICKS.asItem());
                    output.accept(CBlocks.ANDESITE_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_GRANITE_WALL.asItem());
                    output.accept(CBlocks.GRANITE_BRICKS.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_STAIRS.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_SLAB.asItem());
                    output.accept(CBlocks.GRANITE_BRICK_WALL.asItem());
                    output.accept(CBlocks.CHISELED_GRANITE.asItem());
                    output.accept(CBlocks.CHISELED_GRANITE_BRICKS.asItem());
                    output.accept(CBlocks.GRANITE_PILLAR.asItem());

                    output.accept(CBlocks.POLISHED_DIORITE_WALL.asItem());
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

                    output.accept(CBlocks.CUT_SANDSTONE_STAIRS.asItem());
                    output.accept(CBlocks.CUT_RED_SANDSTONE_STAIRS.asItem());
                })
                .build()

        );


    }




}
