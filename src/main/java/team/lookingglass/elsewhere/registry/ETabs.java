package team.lookingglass.elsewhere.registry;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import team.lookingglass.elsewhere.Elsewhere;

public class ETabs {
    private static final ResourceKey<CreativeModeTab> ECOLOGICAL = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "ecological_tab"));

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ECOLOGICAL, FabricCreativeModeTab.builder()
                .title(Component.translatable("ecological.tab"))
                .icon(() -> new ItemStack(EBlocks.STONE_TILES))
                .displayItems((context, output) -> {
                    // Quartz Brick Fill
                    output.accept(EBlocks.QUARTZ_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.QUARTZ_BRICK_SLAB.asItem());

                    // Amethyst-Obsidian Set
                    output.accept(EBlocks.AMETHYST_STAIRS.asItem());
                    output.accept(EBlocks.AMETHYST_SLAB.asItem());
                    output.accept(EBlocks.AMETHYST_BRICKS.asItem());
                    output.accept(EBlocks.AMETHYST_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.AMETHYST_BRICK_SLAB.asItem());
                    output.accept(EBlocks.AMETHYST_PILLAR.asItem());
                    output.accept(EBlocks.CHISELED_AMETHYST.asItem());

                    output.accept(EBlocks.OBSIDIAN_STAIRS.asItem());
                    output.accept(EBlocks.OBSIDIAN_SLAB.asItem());
                    output.accept(EBlocks.OBSIDIAN_BRICKS.asItem());
                    output.accept(EBlocks.OBSIDIAN_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.OBSIDIAN_BRICK_SLAB.asItem());
                    output.accept(EBlocks.OBSIDIAN_PILLAR.asItem());
                    output.accept(EBlocks.CHISELED_OBSIDIAN.asItem());

                    // Stone Set
                    output.accept(EBlocks.STONE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_STONE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_STONE_WALL.asItem());

                    output.accept(EBlocks.POLISHED_STONE.asItem());
                    output.accept(EBlocks.POLISHED_STONE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_STONE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_STONE_WALL.asItem());

                    output.accept(EBlocks.CHISELED_STONE.asItem());
                    output.accept(EBlocks.STONE_TILES.asItem());
                    output.accept(EBlocks.STONE_TILE_STAIRS.asItem());
                    output.accept(EBlocks.STONE_TILE_SLAB.asItem());
                    output.accept(EBlocks.STONE_TILE_WALL.asItem());
                    output.accept(EBlocks.MOSSY_STONE_TILES.asItem());
                    output.accept(EBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                    output.accept(EBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                    output.accept(EBlocks.MOSSY_STONE_TILE_WALL.asItem());
                    output.accept(EBlocks.STONE_PILLAR.asItem());

                    output.accept(EBlocks.SHALE.asItem());
                    output.accept(EBlocks.SHALE_STAIRS.asItem());
                    output.accept(EBlocks.SHALE_SLAB.asItem());
                    output.accept(EBlocks.SHALE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_SHALE.asItem());
                    output.accept(EBlocks.SMOOTH_SHALE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_SHALE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_SHALE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_SHALE.asItem());
                    output.accept(EBlocks.POLISHED_SHALE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_SHALE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_SHALE_WALL.asItem());
                    output.accept(EBlocks.SHALE_BRICKS.asItem());
                    output.accept(EBlocks.SHALE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.SHALE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.SHALE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_SHALE.asItem());
                    output.accept(EBlocks.CHISELED_SHALE_BRICKS.asItem());
                    output.accept(EBlocks.SHALE_PILLAR.asItem());
                    output.accept(EBlocks.COBBLESHALE.asItem());
                    output.accept(EBlocks.COBBLESHALE_STAIRS.asItem());
                    output.accept(EBlocks.COBBLESHALE_SLAB.asItem());
                    output.accept(EBlocks.COBBLESHALE_WALL.asItem());
                    output.accept(EBlocks.SHALE_TILES.asItem());
                    output.accept(EBlocks.SHALE_TILE_STAIRS.asItem());
                    output.accept(EBlocks.SHALE_TILE_SLAB.asItem());
                    output.accept(EBlocks.SHALE_TILE_WALL.asItem());

                    output.accept(EBlocks.SHALE_COAL_ORE.asItem());
                    output.accept(EBlocks.SHALE_COPPER_ORE.asItem());
                    output.accept(EBlocks.SHALE_IRON_ORE.asItem());
                    output.accept(EBlocks.SHALE_GOLD_ORE.asItem());
                    output.accept(EBlocks.SHALE_REDSTONE_ORE.asItem());
                    output.accept(EBlocks.SHALE_DIAMOND_ORE.asItem());
                    output.accept(EBlocks.SHALE_LAPIS_ORE.asItem());
                    output.accept(EBlocks.SHALE_EMERALD_ORE.asItem());

                    output.accept(EBlocks.DEEPSLATE_STAIRS.asItem());
                    output.accept(EBlocks.DEEPSLATE_SLAB.asItem());
                    output.accept(EBlocks.DEEPSLATE_WALL.asItem());

                    output.accept(EBlocks.SMOOTH_DEEPSLATE.asItem());
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_DEEPSLATE_WALL.asItem());

                    output.accept(EBlocks.CHISELED_DEEPSLATE_BRICKS.asItem());
                    output.accept(EBlocks.DEEPSLATE_PILLAR.asItem());

                    output.accept(EBlocks.SMOOTH_TUFF.asItem());
                    output.accept(EBlocks.SMOOTH_TUFF_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_TUFF_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_TUFF_WALL.asItem());
                    output.accept(EBlocks.TUFF_PILLAR.asItem());

                    output.accept(EBlocks.SMOOTH_BLACKSTONE.asItem());
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_BLACKSTONE_WALL.asItem());
                    output.accept(EBlocks.CHISELED_POLISHED_BLACKSTONE_BRICKS.asItem());
                    output.accept(EBlocks.POLISHED_BLACKSTONE_PILLAR.asItem());

                    output.accept(EBlocks.POLISHED_ANDESITE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_ANDESITE.asItem());
                    output.accept(EBlocks.SMOOTH_ANDESITE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_ANDESITE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_ANDESITE_WALL.asItem());
                    output.accept(EBlocks.ANDESITE_BRICKS.asItem());
                    output.accept(EBlocks.ANDESITE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.ANDESITE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.ANDESITE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_ANDESITE.asItem());
                    output.accept(EBlocks.CHISELED_ANDESITE_BRICKS.asItem());
                    output.accept(EBlocks.ANDESITE_PILLAR.asItem());

                    output.accept(EBlocks.POLISHED_GRANITE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_GRANITE.asItem());
                    output.accept(EBlocks.SMOOTH_GRANITE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_GRANITE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_GRANITE_WALL.asItem());
                    output.accept(EBlocks.GRANITE_BRICKS.asItem());
                    output.accept(EBlocks.GRANITE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.GRANITE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.GRANITE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_GRANITE.asItem());
                    output.accept(EBlocks.CHISELED_GRANITE_BRICKS.asItem());
                    output.accept(EBlocks.GRANITE_PILLAR.asItem());

                    output.accept(EBlocks.POLISHED_DIORITE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_DIORITE.asItem());
                    output.accept(EBlocks.SMOOTH_DIORITE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_DIORITE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_DIORITE_WALL.asItem());
                    output.accept(EBlocks.DIORITE_BRICKS.asItem());
                    output.accept(EBlocks.DIORITE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.DIORITE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.DIORITE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_DIORITE.asItem());
                    output.accept(EBlocks.CHISELED_DIORITE_BRICKS.asItem());
                    output.accept(EBlocks.DIORITE_PILLAR.asItem());

                    output.accept(EBlocks.CALCITE_STAIRS.asItem());
                    output.accept(EBlocks.CALCITE_SLAB.asItem());
                    output.accept(EBlocks.CALCITE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_CALCITE.asItem());
                    output.accept(EBlocks.SMOOTH_CALCITE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_CALCITE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_CALCITE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_CALCITE.asItem());
                    output.accept(EBlocks.POLISHED_CALCITE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_CALCITE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_CALCITE_WALL.asItem());
                    output.accept(EBlocks.CALCITE_BRICKS.asItem());
                    output.accept(EBlocks.CALCITE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.CALCITE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.CALCITE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_CALCITE.asItem());
                    output.accept(EBlocks.CHISELED_CALCITE_BRICKS.asItem());
                    output.accept(EBlocks.CALCITE_PILLAR.asItem());

                    output.accept(EBlocks.DRIPSTONE_STAIRS.asItem());
                    output.accept(EBlocks.DRIPSTONE_SLAB.asItem());
                    output.accept(EBlocks.DRIPSTONE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_DRIPSTONE.asItem());
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_DRIPSTONE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_DRIPSTONE.asItem());
                    output.accept(EBlocks.POLISHED_DRIPSTONE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_DRIPSTONE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_DRIPSTONE_WALL.asItem());
                    output.accept(EBlocks.DRIPSTONE_BRICKS.asItem());
                    output.accept(EBlocks.DRIPSTONE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.DRIPSTONE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.DRIPSTONE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_DRIPSTONE.asItem());
                    output.accept(EBlocks.CHISELED_DRIPSTONE_BRICKS.asItem());
                    output.accept(EBlocks.DRIPSTONE_PILLAR.asItem());

                    output.accept(EBlocks.BASALT_STAIRS.asItem());
                    output.accept(EBlocks.BASALT_SLAB.asItem());
                    output.accept(EBlocks.BASALT_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_BASALT_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_BASALT_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_BASALT_WALL.asItem());
                    output.accept(EBlocks.POLISHED_BASALT_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_BASALT_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_BASALT_WALL.asItem());
                    output.accept(EBlocks.BASALT_BRICKS.asItem());
                    output.accept(EBlocks.BASALT_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.BASALT_BRICK_SLAB.asItem());
                    output.accept(EBlocks.BASALT_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_BASALT.asItem());
                    output.accept(EBlocks.CHISELED_BASALT_BRICKS.asItem());
                    output.accept(EBlocks.BASALT_PILLAR.asItem());

                    output.accept(EBlocks.SODALITE.asItem());
                    output.accept(EBlocks.SODALITE_STAIRS.asItem());
                    output.accept(EBlocks.SODALITE_SLAB.asItem());
                    output.accept(EBlocks.SODALITE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_SODALITE.asItem());
                    output.accept(EBlocks.SMOOTH_SODALITE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_SODALITE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_SODALITE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_SODALITE.asItem());
                    output.accept(EBlocks.POLISHED_SODALITE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_SODALITE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_SODALITE_WALL.asItem());
                    output.accept(EBlocks.SODALITE_BRICKS.asItem());
                    output.accept(EBlocks.SODALITE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.SODALITE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.SODALITE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_SODALITE.asItem());
                    output.accept(EBlocks.CHISELED_SODALITE_BRICKS.asItem());
                    output.accept(EBlocks.SODALITE_PILLAR.asItem());

                    output.accept(EBlocks.SULFUR.asItem());
                    output.accept(EBlocks.SULFUR_STAIRS.asItem());
                    output.accept(EBlocks.SULFUR_SLAB.asItem());
                    output.accept(EBlocks.SULFUR_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_SULFUR.asItem());
                    output.accept(EBlocks.SMOOTH_SULFUR_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_SULFUR_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_SULFUR_WALL.asItem());
                    output.accept(EBlocks.POLISHED_SULFUR.asItem());
                    output.accept(EBlocks.POLISHED_SULFUR_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_SULFUR_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_SULFUR_WALL.asItem());
                    output.accept(EBlocks.SULFUR_BRICKS.asItem());
                    output.accept(EBlocks.SULFUR_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.SULFUR_BRICK_SLAB.asItem());
                    output.accept(EBlocks.SULFUR_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_SULFUR.asItem());
                    output.accept(EBlocks.CHISELED_SULFUR_BRICKS.asItem());
                    output.accept(EBlocks.SULFUR_PILLAR.asItem());
                    output.accept(EBlocks.SULFUR_SPIKE.asItem());
                    output.accept(EBlocks.POTENT_SULFUR.asItem());

                    output.accept(EBlocks.CINNABAR.asItem());
                    output.accept(EBlocks.CINNABAR_STAIRS.asItem());
                    output.accept(EBlocks.CINNABAR_SLAB.asItem());
                    output.accept(EBlocks.CINNABAR_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_CINNABAR.asItem());
                    output.accept(EBlocks.SMOOTH_CINNABAR_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_CINNABAR_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_CINNABAR_WALL.asItem());
                    output.accept(EBlocks.POLISHED_CINNABAR.asItem());
                    output.accept(EBlocks.POLISHED_CINNABAR_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_CINNABAR_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_CINNABAR_WALL.asItem());
                    output.accept(EBlocks.CINNABAR_BRICKS.asItem());
                    output.accept(EBlocks.CINNABAR_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.CINNABAR_BRICK_SLAB.asItem());
                    output.accept(EBlocks.CINNABAR_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_CINNABAR.asItem());
                    output.accept(EBlocks.CHISELED_CINNABAR_BRICKS.asItem());
                    output.accept(EBlocks.CINNABAR_PILLAR.asItem());

                    output.accept(EBlocks.CINNABAR_COAL_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_COPPER_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_IRON_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_GOLD_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_SILVER_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_REDSTONE_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_DIAMOND_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_LAPIS_ORE.asItem());
                    output.accept(EBlocks.CINNABAR_EMERALD_ORE.asItem());

                    output.accept(EBlocks.NETHERRACK_STAIRS.asItem());
                    output.accept(EBlocks.NETHERRACK_SLAB.asItem());
                    output.accept(EBlocks.NETHERRACK_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_NETHERRACK.asItem());
                    output.accept(EBlocks.SMOOTH_NETHERRACK_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_NETHERRACK_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_NETHERRACK_WALL.asItem());
                    output.accept(EBlocks.POLISHED_NETHERRACK.asItem());
                    output.accept(EBlocks.POLISHED_NETHERRACK_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_NETHERRACK_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_NETHERRACK_WALL.asItem());
                    output.accept(EBlocks.NETHERRACK_BRICKS.asItem());
                    output.accept(EBlocks.NETHERRACK_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.NETHERRACK_BRICK_SLAB.asItem());
                    output.accept(EBlocks.NETHERRACK_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_NETHERRACK.asItem());
                    output.accept(EBlocks.CHISELED_NETHERRACK_BRICKS.asItem());
                    output.accept(EBlocks.NETHERRACK_PILLAR.asItem());

                    output.accept(EBlocks.END_STONE_STAIRS.asItem());
                    output.accept(EBlocks.END_STONE_SLAB.asItem());
                    output.accept(EBlocks.END_STONE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_END_STONE.asItem());
                    output.accept(EBlocks.SMOOTH_END_STONE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_END_STONE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_END_STONE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_END_STONE.asItem());
                    output.accept(EBlocks.POLISHED_END_STONE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_END_STONE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_END_STONE_WALL.asItem());
                    output.accept(EBlocks.CHISELED_END_STONE.asItem());
                    output.accept(EBlocks.CHISELED_END_STONE_BRICKS.asItem());
                    output.accept(EBlocks.END_STONE_PILLAR.asItem());

                    output.accept(EBlocks.SMOOTH_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.CUT_SANDSTONE_STAIRS.asItem());
                    output.accept(EBlocks.CUT_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_SANDSTONE.asItem());
                    output.accept(EBlocks.POLISHED_SANDSTONE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_SANDSTONE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.SANDSTONE_BRICKS.asItem());
                    output.accept(EBlocks.SANDSTONE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.SANDSTONE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.SANDSTONE_BRICK_WALL.asItem());

                    output.accept(EBlocks.SMOOTH_RED_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.CUT_RED_SANDSTONE_STAIRS.asItem());
                    output.accept(EBlocks.CUT_RED_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE.asItem());
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_RED_SANDSTONE_WALL.asItem());
                    output.accept(EBlocks.RED_SANDSTONE_BRICKS.asItem());
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.RED_SANDSTONE_BRICK_WALL.asItem());

                    output.accept(EBlocks.SMOOTH_PRISMARINE.asItem());
                    output.accept(EBlocks.SMOOTH_PRISMARINE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_PRISMARINE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_PRISMARINE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_PRISMARINE.asItem());
                    output.accept(EBlocks.POLISHED_PRISMARINE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_PRISMARINE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_PRISMARINE_WALL.asItem());
                    output.accept(EBlocks.PRISMARINE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_PRISMARINE.asItem());
                    output.accept(EBlocks.CHISELED_PRISMARINE_BRICKS.asItem());
                    output.accept(EBlocks.PRISMARINE_PILLAR.asItem());

                    output.accept(EBlocks.DARK_PRISMARINE_WALL.asItem());
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE.asItem());
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_STAIRS.asItem());
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_SLAB.asItem());
                    output.accept(EBlocks.SMOOTH_DARK_PRISMARINE_WALL.asItem());
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE.asItem());
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_STAIRS.asItem());
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_SLAB.asItem());
                    output.accept(EBlocks.POLISHED_DARK_PRISMARINE_WALL.asItem());
                    output.accept(EBlocks.DARK_PRISMARINE_BRICKS.asItem());
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.DARK_PRISMARINE_BRICK_WALL.asItem());
                    output.accept(EBlocks.CHISELED_DARK_PRISMARINE.asItem());
                    output.accept(EBlocks.CHISELED_DARK_PRISMARINE_BRICKS.asItem());
                    output.accept(EBlocks.DARK_PRISMARINE_PILLAR.asItem());

                    output.accept(EBlocks.CHISELED_PURPUR.asItem());

                    output.accept(EBlocks.ICICLE.asItem());

                    output.accept(EBlocks.OAK_MOSAIC.asItem());
                    output.accept(EBlocks.OAK_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.OAK_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.SPRUCE_MOSAIC.asItem());
                    output.accept(EBlocks.SPRUCE_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.SPRUCE_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.BIRCH_MOSAIC.asItem());
                    output.accept(EBlocks.BIRCH_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.BIRCH_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.JUNGLE_MOSAIC.asItem());
                    output.accept(EBlocks.JUNGLE_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.JUNGLE_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.ACACIA_MOSAIC.asItem());
                    output.accept(EBlocks.ACACIA_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.ACACIA_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.DARK_OAK_MOSAIC.asItem());
                    output.accept(EBlocks.DARK_OAK_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.DARK_OAK_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.MANGROVE_MOSAIC.asItem());
                    output.accept(EBlocks.MANGROVE_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.MANGROVE_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.CHERRY_MOSAIC.asItem());
                    output.accept(EBlocks.CHERRY_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.CHERRY_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.PALE_OAK_MOSAIC.asItem());
                    output.accept(EBlocks.PALE_OAK_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.PALE_OAK_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.CRIMSON_MOSAIC.asItem());
                    output.accept(EBlocks.CRIMSON_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.CRIMSON_MOSAIC_SLAB.asItem());
                    output.accept(EBlocks.WARPED_MOSAIC.asItem());
                    output.accept(EBlocks.WARPED_MOSAIC_STAIRS.asItem());
                    output.accept(EBlocks.WARPED_MOSAIC_SLAB.asItem());

                    output.accept(EBlocks.BLUEBONNET.asItem());


                })
                .build()

        );


    }




}
