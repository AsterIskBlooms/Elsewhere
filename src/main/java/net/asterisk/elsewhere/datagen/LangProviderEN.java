package net.asterisk.elsewhere.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LangProviderEN extends FabricLanguageProvider {
    public LangProviderEN(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
        // Tab Title
        translationBuilder.add("elsewhere.elsewhere_tab", "ELSEWHERE");

        // Gloam
        translationBuilder.add("block.elsewhere.gloam", "Gloam");
        translationBuilder.add("block.elsewhere.mossy_gloam", "Mossy Gloam");

        // Rootshale
        translationBuilder.add("block.elsewhere.rootshale", "Rootshale");
        translationBuilder.add("block.elsewhere.cobbled_rootshale", "Cobbled Rootshale");
        translationBuilder.add("block.elsewhere.rootshale_bricks", "Rootshale Bricks");
        translationBuilder.add("block.elsewhere.rootshale_brick_stairs", "Rootshale Brick Stairs");
        translationBuilder.add("block.elsewhere.rootshale_brick_slab", "Rootshale Brick Slab");
        translationBuilder.add("block.elsewhere.rootshale_brick_wall", "Rootshale Brick Wall");

        // Bitterack
        translationBuilder.add("block.elsewhere.bitterack", "Bitterack");

        // Ores
        translationBuilder.add("block.elsewhere.rootshale_xyloite_ore", "Rootshale Xyloite Ore");
        translationBuilder.add("block.elsewhere.rootshale_sylver_ore", "Rootshale Sylver Ore");
        translationBuilder.add("block.elsewhere.bitterack_sylver_ore", "Bitterack Sylver Ore");

        // Xyloite Items
        translationBuilder.add("item.elsewhere.raw_xyloite", "Raw Xyloite");
        translationBuilder.add("item.elsewhere.xyloite_ingot", "Xyloite Ingot");
        translationBuilder.add("item.elsewhere.xyloite_nugget", "Xyloite Nugget");
        translationBuilder.add("item.elsewhere.xyloite_sword", "Xyloite Sword");
        translationBuilder.add("item.elsewhere.xyloite_axe", "Xyloite Axe");
        translationBuilder.add("item.elsewhere.xyloite_spear", "Xyloite Spear");
        translationBuilder.add("item.elsewhere.xyloite_pickaxe", "Xyloite Pickaxe");
        translationBuilder.add("item.elsewhere.xyloite_shovel", "Xyloite Shovel");
        translationBuilder.add("item.elsewhere.xyloite_hoe", "Xyloite Hoe");
        translationBuilder.add("item.elsewhere.xyloite_helmet", "Xyloite Helmet");
        translationBuilder.add("item.elsewhere.xyloite_chestplate", "Xyloite Chestplate");
        translationBuilder.add("item.elsewhere.xyloite_leggings", "Xyloite Leggings");
        translationBuilder.add("item.elsewhere.xyloite_boots", "Xyloite Boots");

        // Xyloite Blocks
        translationBuilder.add("block.elsewhere.xyloite_block", "Block of Xyloite");
        translationBuilder.add("block.elsewhere.cut_xyloite", "Cut Xyloite");
        translationBuilder.add("block.elsewhere.cut_xyloite_stairs", "Cut Xyloite Stairs");
        translationBuilder.add("block.elsewhere.cut_xyloite_slab", "Cut Xyloite Slab");

        // Sylver Items
        translationBuilder.add("item.elsewhere.raw_sylver", "Raw Sylver");
        translationBuilder.add("item.elsewhere.sylver_ingot", "Sylver Ingot");
        translationBuilder.add("item.elsewhere.sylver_nugget", "Sylver Nugget");
        translationBuilder.add("item.elsewhere.sylver_sword", "Sylver Sword");
        translationBuilder.add("item.elsewhere.sylver_axe", "Sylver Axe");
        translationBuilder.add("item.elsewhere.sylver_spear", "Sylver Spear");
        translationBuilder.add("item.elsewhere.sylver_pickaxe", "Sylver Pickaxe");
        translationBuilder.add("item.elsewhere.sylver_shovel", "Sylver Shovel");
        translationBuilder.add("item.elsewhere.sylver_hoe", "Sylver Hoe");
        translationBuilder.add("item.elsewhere.sylver_helmet", "Sylver Helmet");
        translationBuilder.add("item.elsewhere.sylver_chestplate", "Sylver Chestplate");
        translationBuilder.add("item.elsewhere.sylver_leggings", "Sylver Leggings");
        translationBuilder.add("item.elsewhere.sylver_boots", "Sylver Boots");

        // Sylver Blocks
        translationBuilder.add("block.elsewhere.sylver_block", "Block of Sylver");

        // Tautolith Blocks
        translationBuilder.add("block.elsewhere.tautolith_sapling", "Tautolith Sapling");
        translationBuilder.add("block.elsewhere.tautolith_leaves", "Tautolith Leaves");
        translationBuilder.add("block.elsewhere.tautolith_log", "Tautolith Log");
        translationBuilder.add("block.elsewhere.tautolith_wood", "Tautolith Wood");
        translationBuilder.add("block.elsewhere.stripped_tautolith_log", "Stripped Tautolith Log");
        translationBuilder.add("block.elsewhere.stripped_tautolith_wood", "Stripped Tautolith Wood");
        translationBuilder.add("block.elsewhere.tautolith_planks", "Tautolith Planks");
        translationBuilder.add("block.elsewhere.tautolith_stairs", "Tautolith Stairs");
        translationBuilder.add("block.elsewhere.tautolith_slab", "Tautolith Slab");
        translationBuilder.add("block.elsewhere.tautolith_fence", "Tautolith Fence");
        translationBuilder.add("block.elsewhere.tautolith_fence_gate", "Tautolith Fence Gate");
        translationBuilder.add("item.elsewhere.tautolith_sign", "Tautolith Sign");
        translationBuilder.add("block.elsewhere.tautolith_sign", "Tautolith Sign");
        translationBuilder.add("block.elsewhere.tautolith_wall_sign", "Tautolith Sign");
        translationBuilder.add("item.elsewhere.tautolith_hanging_sign", "Tautolith Hanging Sign");
        translationBuilder.add("block.elsewhere.tautolith_hanging_sign", "Tautolith Hanging Sign");
        translationBuilder.add("block.elsewhere.tautolith_wall_hanging_sign", "Tautolith Hanging Sign");
        translationBuilder.add("block.elsewhere.tautolith_button", "Tautolith Button");
        translationBuilder.add("block.elsewhere.tautolith_pressure_plate", "Tautolith Pressure Plate");

        // Briar Blocks
        translationBuilder.add("block.elsewhere.briar_sapling", "Briar Sapling");
        translationBuilder.add("block.elsewhere.briar_leaves", "Briar Leaves");
        translationBuilder.add("block.elsewhere.briar_log", "Briar Log");
        translationBuilder.add("block.elsewhere.briar_wood", "Briar Wood");
        translationBuilder.add("block.elsewhere.stripped_briar_log", "Stripped Briar Log");
        translationBuilder.add("block.elsewhere.stripped_briar_wood", "Stripped Briar Wood");
        translationBuilder.add("block.elsewhere.briar_planks", "Briar Planks");
        translationBuilder.add("block.elsewhere.briar_stairs", "Briar Stairs");
        translationBuilder.add("block.elsewhere.briar_slab", "Briar Slab");
        translationBuilder.add("block.elsewhere.briar_fence", "Briar Fence");
        translationBuilder.add("block.elsewhere.briar_fence_gate", "Briar Fence Gate");
        translationBuilder.add("item.elsewhere.briar_sign", "Briar Sign");
        translationBuilder.add("block.elsewhere.briar_sign", "Briar Sign");
        translationBuilder.add("block.elsewhere.briar_wall_sign", "Briar Sign");
        translationBuilder.add("item.elsewhere.briar_hanging_sign", "Briar Hanging Sign");
        translationBuilder.add("block.elsewhere.briar_hanging_sign", "Briar Hanging Sign");
        translationBuilder.add("block.elsewhere.briar_wall_hanging_sign", "Briar Hanging Sign");
        translationBuilder.add("block.elsewhere.briar_button", "Briar Button");
        translationBuilder.add("block.elsewhere.briar_pressure_plate", "Briar Pressure Plate");









    }
}
