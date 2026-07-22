package team.lookingglass.elsewhere;

import net.minecraft.core.registries.Registries;
import team.lookingglass.elsewhere.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import team.lookingglass.elsewhere.datagen.loot.EntityLootTableProvider;
import team.lookingglass.elsewhere.datagen.loot.BlockLootTableProvider;
import team.lookingglass.elsewhere.datagen.render.ModelProvider;
import team.lookingglass.elsewhere.datagen.render.ParticleProvider;
import team.lookingglass.elsewhere.datagen.tags.BiomeTagProvider;
import team.lookingglass.elsewhere.datagen.tags.BlockTagProvider;
import team.lookingglass.elsewhere.datagen.tags.EntityTagProvider;
import team.lookingglass.elsewhere.datagen.tags.ItemTagProvider;
import team.lookingglass.elsewhere.dimension.DimensionDataGenerator;
import team.lookingglass.elsewhere.dimension.EDimensions;
import team.lookingglass.elsewhere.worldgen.EBiomes;
import team.lookingglass.elsewhere.worldgen.EConfiguredFeatures;
import team.lookingglass.elsewhere.worldgen.ENoise;
import team.lookingglass.elsewhere.worldgen.EPlacedFeatures;

public class ElsewhereDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(RegistryDataGenerator::new);
		pack.addProvider(LangProviderEN::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(ItemRecipeProvider::new);
		pack.addProvider(ParticleProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(EntityTagProvider::new);
		pack.addProvider(BiomeTagProvider::new);
		pack.addProvider(DimensionDataGenerator::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, EConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, EPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.BIOME, EBiomes::bootstrap);
		registryBuilder.add(Registries.NOISE, ENoise::bootstrap);
		registryBuilder.add(Registries.DIMENSION_TYPE, EDimensions::bootstrapType);
		registryBuilder.add(Registries.LEVEL_STEM, EDimensions::bootstrapStem);
	}
}