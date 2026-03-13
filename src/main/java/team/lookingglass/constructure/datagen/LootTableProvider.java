package team.lookingglass.constructure.datagen;

import team.lookingglass.constructure.registry.CBlocks;
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
        dropSelf(CBlocks.QUARTZ_BRICK_STAIRS);
        add(CBlocks.QUARTZ_BRICK_SLAB, createSlabItemTable(CBlocks.QUARTZ_BRICK_SLAB));

        // Amethyst-Obsidian Set
        dropSelf(CBlocks.AMETHYST_STAIRS);
        add(CBlocks.AMETHYST_SLAB, createSlabItemTable(CBlocks.AMETHYST_SLAB));
        dropSelf(CBlocks.AMETHYST_BRICKS);
        dropSelf(CBlocks.AMETHYST_BRICK_STAIRS);
        add(CBlocks.AMETHYST_BRICK_SLAB, createSlabItemTable(CBlocks.AMETHYST_BRICK_SLAB));
        dropSelf(CBlocks.AMETHYST_PILLAR);
        dropSelf(CBlocks.CHISELED_AMETHYST);

        dropSelf(CBlocks.OBSIDIAN_STAIRS);
        add(CBlocks.OBSIDIAN_SLAB, createSlabItemTable(CBlocks.OBSIDIAN_SLAB));
        dropSelf(CBlocks.OBSIDIAN_BRICKS);
        dropSelf(CBlocks.OBSIDIAN_BRICK_STAIRS);
        add(CBlocks.OBSIDIAN_BRICK_SLAB, createSlabItemTable(CBlocks.OBSIDIAN_BRICK_SLAB));
        dropSelf(CBlocks.OBSIDIAN_PILLAR);
        dropSelf(CBlocks.CHISELED_OBSIDIAN);

        dropSelf(CBlocks.STONE_WALL);
        dropSelf(CBlocks.SMOOTH_STONE_STAIRS);
        dropSelf(CBlocks.SMOOTH_STONE_WALL);

        dropSelf(CBlocks.STONE_TILES);
        dropSelf(CBlocks.STONE_TILE_STAIRS);
        add(CBlocks.STONE_TILE_SLAB, createSlabItemTable(CBlocks.STONE_TILE_SLAB));
        dropSelf(CBlocks.STONE_TILE_WALL);
        dropSelf(CBlocks.MOSSY_STONE_TILES);
        dropSelf(CBlocks.MOSSY_STONE_TILE_STAIRS);
        add(CBlocks.MOSSY_STONE_TILE_SLAB, createSlabItemTable(CBlocks.MOSSY_STONE_TILE_SLAB));
        dropSelf(CBlocks.MOSSY_STONE_TILE_WALL);
        dropSelf(CBlocks.CHISELED_STONE);
        dropSelf(CBlocks.STONE_PILLAR);
        dropSelf(CBlocks.CHISELED_DEEPSLATE_BRICKS);
        dropSelf(CBlocks.DEEPSLATE_PILLAR);
        dropSelf(CBlocks.TUFF_PILLAR);

        dropSelf(CBlocks.POLISHED_ANDESITE_WALL);
        dropSelf(CBlocks.ANDESITE_BRICKS);
        dropSelf(CBlocks.ANDESITE_BRICK_STAIRS);
        add(CBlocks.ANDESITE_BRICK_SLAB, createSlabItemTable(CBlocks.ANDESITE_BRICK_SLAB));
        dropSelf(CBlocks.ANDESITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_ANDESITE);
        dropSelf(CBlocks.CHISELED_ANDESITE_BRICKS);
        dropSelf(CBlocks.ANDESITE_PILLAR);

        dropSelf(CBlocks.POLISHED_GRANITE_WALL);
        dropSelf(CBlocks.GRANITE_BRICKS);
        dropSelf(CBlocks.GRANITE_BRICK_STAIRS);
        add(CBlocks.GRANITE_BRICK_SLAB, createSlabItemTable(CBlocks.GRANITE_BRICK_SLAB));
        dropSelf(CBlocks.GRANITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_GRANITE);
        dropSelf(CBlocks.CHISELED_GRANITE_BRICKS);
        dropSelf(CBlocks.GRANITE_PILLAR);

        dropSelf(CBlocks.POLISHED_DIORITE_WALL);
        dropSelf(CBlocks.DIORITE_BRICKS);
        dropSelf(CBlocks.DIORITE_BRICK_STAIRS);
        add(CBlocks.DIORITE_BRICK_SLAB, createSlabItemTable(CBlocks.DIORITE_BRICK_SLAB));
        dropSelf(CBlocks.DIORITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_DIORITE);
        dropSelf(CBlocks.CHISELED_DIORITE_BRICKS);
        dropSelf(CBlocks.DIORITE_PILLAR);

        dropSelf(CBlocks.CALCITE_STAIRS);
        add(CBlocks.CALCITE_SLAB, createSlabItemTable(CBlocks.CALCITE_SLAB));
        dropSelf(CBlocks.CALCITE_WALL);
        dropSelf(CBlocks.POLISHED_CALCITE);
        dropSelf(CBlocks.POLISHED_CALCITE_STAIRS);
        add(CBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(CBlocks.POLISHED_CALCITE_SLAB));
        dropSelf(CBlocks.POLISHED_CALCITE_WALL);
        dropSelf(CBlocks.CALCITE_BRICKS);
        dropSelf(CBlocks.CALCITE_BRICK_STAIRS);
        add(CBlocks.CALCITE_BRICK_SLAB, createSlabItemTable(CBlocks.CALCITE_BRICK_SLAB));
        dropSelf(CBlocks.CALCITE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_CALCITE);
        dropSelf(CBlocks.CHISELED_CALCITE_BRICKS);
        dropSelf(CBlocks.CALCITE_PILLAR);

        dropSelf(CBlocks.DRIPSTONE_STAIRS);
        add(CBlocks.DRIPSTONE_SLAB, createSlabItemTable(CBlocks.DRIPSTONE_SLAB));
        dropSelf(CBlocks.DRIPSTONE_WALL);
        dropSelf(CBlocks.POLISHED_DRIPSTONE);
        dropSelf(CBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(CBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(CBlocks.POLISHED_DRIPSTONE_SLAB));
        dropSelf(CBlocks.POLISHED_DRIPSTONE_WALL);
        dropSelf(CBlocks.DRIPSTONE_BRICKS);
        dropSelf(CBlocks.DRIPSTONE_BRICK_STAIRS);
        add(CBlocks.DRIPSTONE_BRICK_SLAB, createSlabItemTable(CBlocks.DRIPSTONE_BRICK_SLAB));
        dropSelf(CBlocks.DRIPSTONE_BRICK_WALL);
        dropSelf(CBlocks.CHISELED_DRIPSTONE);
        dropSelf(CBlocks.CHISELED_DRIPSTONE_BRICKS);
        dropSelf(CBlocks.DRIPSTONE_PILLAR);

        dropSelf(CBlocks.CUT_SANDSTONE_STAIRS);
        dropSelf(CBlocks.CUT_RED_SANDSTONE_STAIRS);
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
