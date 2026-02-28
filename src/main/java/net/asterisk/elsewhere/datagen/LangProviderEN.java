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

        // Quartz Brick Fill
        translationBuilder.add("block.elsewhere.quartz_brick_stairs", "Quartz Brick Stairs");
        translationBuilder.add("block.elsewhere.quartz_brick_slab", "Quartz Brick Slab");

        // Amethyst-Obsidian Set
        translationBuilder.add("block.elsewhere.amethyst_stairs", "Amethyst Stairs");
        translationBuilder.add("block.elsewhere.amethyst_slab", "Amethyst Slab");
        translationBuilder.add("block.elsewhere.amethyst_bricks", "Amethyst Bricks");
        translationBuilder.add("block.elsewhere.amethyst_brick_stairs", "Amethyst Brick Stairs");
        translationBuilder.add("block.elsewhere.amethyst_brick_slab", "Amethyst Brick Slab");
        translationBuilder.add("block.elsewhere.amethyst_pillar", "Amethyst Pillar");
        translationBuilder.add("block.elsewhere.chiseled_amethyst", "Chiseled Amethyst");

        translationBuilder.add("block.elsewhere.obsidian_stairs", "Obsidian Stairs");
        translationBuilder.add("block.elsewhere.obsidian_slab", "Obsidian Slab");
        translationBuilder.add("block.elsewhere.obsidian_bricks", "Obsidian Bricks");
        translationBuilder.add("block.elsewhere.obsidian_brick_stairs", "Obsidian Brick Stairs");
        translationBuilder.add("block.elsewhere.obsidian_brick_slab", "Obsidian Brick Slab");
        translationBuilder.add("block.elsewhere.obsidian_pillar", "Obsidian Pillar");
        translationBuilder.add("block.elsewhere.chiseled_obsidian", "Chiseled Obsidian");

        // Enchantments!!
        translationBuilder.add("enchantment.elsewhere.sharpness", "Sharpness");
        translationBuilder.add("enchantment.elsewhere.protection", "Protection");









    }
}
