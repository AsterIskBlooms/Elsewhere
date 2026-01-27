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
                .icon(() -> new ItemStack(EItems.XYLOITE_INGOT))
                .displayItems((context, output) -> {
                    // Gloam Blocks
                    output.accept(EBlocks.GLOAM.asItem());
                    output.accept(EBlocks.MOSSY_GLOAM.asItem());
                    // Rootshale Blocks
                    output.accept(EBlocks.ROOTSHALE.asItem());
                    output.accept(EBlocks.COBBLED_ROOTSHALE.asItem());
                    output.accept(EBlocks.ROOTSHALE_XYLOITE_ORE.asItem());
                    output.accept(EBlocks.ROOTSHALE_SYLVER_ORE.asItem());
                    output.accept(EBlocks.ROOTSHALE_BRICKS.asItem());
                    output.accept(EBlocks.ROOTSHALE_BRICK_STAIRS.asItem());
                    output.accept(EBlocks.ROOTSHALE_BRICK_SLAB.asItem());
                    output.accept(EBlocks.ROOTSHALE_BRICK_WALL.asItem());
                    // Bitterack Blocks
                    output.accept(EBlocks.BITTERACK.asItem());
                    output.accept(EBlocks.BITTERACK_SYLVER_ORE.asItem());
                    // Tautwood Blocks
                    output.accept(EBlocks.TAUTWOOD_SAPLING.asItem());
                    output.accept(EBlocks.TAUTWOOD_LOG.asItem());
                    output.accept(EBlocks.STRIPPED_TAUTWOOD_LOG.asItem());
                    output.accept(EBlocks.TAUTWOOD_WOOD.asItem());
                    output.accept(EBlocks.STRIPPED_TAUTWOOD_WOOD.asItem());
                    output.accept(EBlocks.TAUTWOOD_LEAVES.asItem());
                    output.accept(EBlocks.TAUTWOOD_PLANKS.asItem());
                    output.accept(EBlocks.TAUTWOOD_STAIRS.asItem());
                    output.accept(EBlocks.TAUTWOOD_SLAB.asItem());
                    output.accept(EBlocks.TAUTWOOD_FENCE.asItem());
                    output.accept(EBlocks.TAUTWOOD_FENCE_GATE.asItem());
                    //output.accept(EBlocks.TAUTWOOD_SIGN.asItem());
                    output.accept(EItems.TAUTWOOD_HANGING_SIGN);
                    output.accept(EBlocks.TAUTWOOD_SHELF.asItem());
                    // Xyloite Items
                    output.accept(EItems.RAW_XYLOITE);
                    output.accept(EItems.XYLOITE_INGOT);
                    output.accept(EItems.XYLOITE_NUGGET);
                    output.accept(EItems.XYLOITE_SWORD);
                    output.accept(EItems.XYLOITE_AXE);
                    output.accept(EItems.XYLOITE_SPEAR);
                    output.accept(EItems.XYLOITE_PICKAXE);
                    output.accept(EItems.XYLOITE_SHOVEL);
                    output.accept(EItems.XYLOITE_HOE);
                    output.accept(EItems.XYLOITE_HELMET);
                    output.accept(EItems.XYLOITE_CHESTPLATE);
                    output.accept(EItems.XYLOITE_LEGGINGS);
                    output.accept(EItems.XYLOITE_BOOTS);
                    // Xyloite Blocks
                    output.accept(EBlocks.XYLOITE_BLOCK.asItem());
                    output.accept(EBlocks.CUT_XYLOITE.asItem());
                    output.accept(EBlocks.CUT_XYLOITE_SLAB.asItem());
                    output.accept(EBlocks.CUT_XYLOITE_STAIRS.asItem());
                    // Sylver Items
                    output.accept(EItems.RAW_SYLVER);
                    output.accept(EItems.SYLVER_INGOT);
                    output.accept(EItems.SYLVER_NUGGET);
                    output.accept(EItems.SYLVER_SWORD);
                    output.accept(EItems.SYLVER_AXE);
                    output.accept(EItems.SYLVER_SPEAR);
                    output.accept(EItems.SYLVER_PICKAXE);
                    output.accept(EItems.SYLVER_SHOVEL);
                    output.accept(EItems.SYLVER_HOE);
                    output.accept(EItems.SYLVER_HELMET);
                    output.accept(EItems.SYLVER_CHESTPLATE);
                    output.accept(EItems.SYLVER_LEGGINGS);
                    output.accept(EItems.SYLVER_BOOTS);
                    // Xyloite Blocks
                    output.accept(EBlocks.SYLVER_BLOCK.asItem());
                })
                .build()
        );
    }




}
