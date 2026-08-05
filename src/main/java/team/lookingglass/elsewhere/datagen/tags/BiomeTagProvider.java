package team.lookingglass.elsewhere.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import team.lookingglass.elsewhere.registry.tags.EBiomeTags;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.concurrent.CompletableFuture;

public class BiomeTagProvider extends FabricTagsProvider<Biome> {
    public BiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.BIOME, registryLookupFuture);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.builder(BiomeTags.IS_BEACH).add(EBiomes.TIDEPOOLS, EBiomes.COLD_BEACH, EBiomes.FROZEN_BEACH);
        this.builder(BiomeTags.IS_RIVER).add(EBiomes.LUKEWARM_RIVER, EBiomes.WARM_RIVER, EBiomes.COLD_RIVER);
        this.builder(EBiomeTags.IS_CAVE).add(
                Biomes.DRIPSTONE_CAVES, Biomes.LUSH_CAVES,
                EBiomes.SULFUR_CAVES, EBiomes.CRYSTAL_CAVERNS, EBiomes.ARID_CAVES, EBiomes.FRIGID_CAVES
        );


        this.builder(BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS).add(
                EBiomes.OUTBACK, EBiomes.LUSH_DESERT, EBiomes.TIDEPOOLS,
                EBiomes.RAINFOREST, EBiomes.SHRUBLAND, EBiomes.CEDAR_FOREST, EBiomes.GLASS_DESERT
        );
        this.builder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(
                EBiomes.OUTBACK, EBiomes.LUSH_DESERT, EBiomes.TIDEPOOLS,
                EBiomes.RAINFOREST, EBiomes.SHRUBLAND, EBiomes.CEDAR_FOREST, EBiomes.GLASS_DESERT
        );

        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(
                EBiomes.DAPPLED_FOREST, EBiomes.TUNDRA,
                EBiomes.COLD_BEACH, EBiomes.FROZEN_BEACH
        );
        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).add(
                EBiomes.DAPPLED_FOREST, EBiomes.TUNDRA,
                EBiomes.COLD_BEACH, EBiomes.FROZEN_BEACH
        );

        this.builder(BiomeTags.SPAWNS_GOLD_RABBITS).add(EBiomes.LUSH_DESERT);
        this.builder(BiomeTags.SPAWNS_SNOW_FOXES).add(EBiomes.TUNDRA, EBiomes.FROZEN_BEACH);

        this.builder(BiomeTags.HAS_VILLAGE_DESERT).add(EBiomes.LUSH_DESERT);
        this.builder(BiomeTags.HAS_VILLAGE_SAVANNA).add(EBiomes.OUTBACK, EBiomes.SHRUBLAND);
        this.builder(BiomeTags.HAS_VILLAGE_TAIGA).add(EBiomes.TUNDRA);

        this.builder(BiomeTags.IS_OVERWORLD).addTag(BiomeTags.IS_BEACH).addTag(BiomeTags.IS_RIVER).addTag(EBiomeTags.IS_CAVE).add(
                EBiomes.DAPPLED_FOREST, EBiomes.TUNDRA,
                EBiomes.LUSH_DESERT, EBiomes.GLASS_DESERT,
                EBiomes.OUTBACK, EBiomes.SHRUBLAND, EBiomes.CEDAR_FOREST, EBiomes.RAINFOREST
        );
    }
}
