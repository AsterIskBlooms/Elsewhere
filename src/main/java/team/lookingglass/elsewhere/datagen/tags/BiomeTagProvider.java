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
        this.builder(BiomeTags.IS_RIVER).add(EBiomes.LUKEWARM_RIVER, EBiomes.WARM_RIVER, EBiomes.COLD_RIVER);
        this.builder(EBiomeTags.IS_CAVE).add(
                Biomes.DRIPSTONE_CAVES, Biomes.LUSH_CAVES,
                EBiomes.SULFUR_CAVES, EBiomes.CRYSTAL_CAVERNS, EBiomes.ARID_CAVES, EBiomes.FRIGID_CAVES
        );

        this.builder(BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS).add(EBiomes.OUTBACK);
        this.builder(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(EBiomes.OUTBACK);
        this.builder(BiomeTags.SPAWNS_GOLD_RABBITS).add(EBiomes.OUTBACK);
        this.builder(BiomeTags.HAS_VILLAGE_DESERT).add(EBiomes.OUTBACK);

        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(EBiomes.DAPPLED_FOREST);
        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).add(EBiomes.DAPPLED_FOREST);

        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(EBiomes.TUNDRA);
        this.builder(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).add(EBiomes.TUNDRA);
        this.builder(BiomeTags.SPAWNS_SNOW_FOXES).add(EBiomes.TUNDRA);
        this.builder(BiomeTags.HAS_VILLAGE_TAIGA).add(EBiomes.TUNDRA);

        this.builder(BiomeTags.IS_OVERWORLD).addTag(BiomeTags.IS_RIVER).addTag(EBiomeTags.IS_CAVE)
                .add(EBiomes.OUTBACK, EBiomes.DAPPLED_FOREST, EBiomes.TUNDRA);
    }
}
