package net.asterisk.elsewhere.datagen;

import net.asterisk.elsewhere.registry.EBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootSubProvider {
    public LootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }



    @Override
    public void generate() {
        // Ore Changes
        add(Blocks.COPPER_ORE, createMultipleOreDrops(Blocks.COPPER_ORE, Items.RAW_COPPER, 1.0F, 2.0F));
        add(Blocks.DEEPSLATE_COPPER_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 1.0F, 3.0F));
        add(Blocks.DEEPSLATE_IRON_ORE, createMultipleOreDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 1.0F, 2.0F));

        // Quartz Brick Fill
        dropSelf(EBlocks.QUARTZ_BRICK_STAIRS);
        add(EBlocks.QUARTZ_BRICK_SLAB, createSlabItemTable(EBlocks.QUARTZ_BRICK_SLAB));

        // Amethyst-Obsidian Set
        dropSelf(EBlocks.AMETHYST_STAIRS);
        add(EBlocks.AMETHYST_SLAB, createSlabItemTable(EBlocks.AMETHYST_SLAB));
        dropSelf(EBlocks.AMETHYST_BRICKS);
        dropSelf(EBlocks.AMETHYST_BRICK_STAIRS);
        add(EBlocks.AMETHYST_BRICK_SLAB, createSlabItemTable(EBlocks.AMETHYST_BRICK_SLAB));
        dropSelf(EBlocks.AMETHYST_PILLAR);
        dropSelf(EBlocks.CHISELED_AMETHYST);

        dropSelf(EBlocks.OBSIDIAN_STAIRS);
        add(EBlocks.OBSIDIAN_SLAB, createSlabItemTable(EBlocks.OBSIDIAN_SLAB));
        dropSelf(EBlocks.OBSIDIAN_BRICKS);
        dropSelf(EBlocks.OBSIDIAN_BRICK_STAIRS);
        add(EBlocks.OBSIDIAN_BRICK_SLAB, createSlabItemTable(EBlocks.OBSIDIAN_BRICK_SLAB));
        dropSelf(EBlocks.OBSIDIAN_PILLAR);
        dropSelf(EBlocks.CHISELED_OBSIDIAN);
    }

    // Secondary Ore Method
    public LootTable.Builder createMultipleOreDrops(final Block block, final Item drop, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

}
