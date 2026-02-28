package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ETabs {
    private static final ResourceKey<CreativeModeTab> CREATIVE_MODE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "creativetab"));


    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_MODE_TAB, FabricCreativeModeTab.builder()
                .title(Component.translatable("elsewhere.elsewhere_tab"))
                .icon(() -> new ItemStack(EBlocks.AMETHYST_PILLAR))
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


                })
                .build()
        );
    }




}
