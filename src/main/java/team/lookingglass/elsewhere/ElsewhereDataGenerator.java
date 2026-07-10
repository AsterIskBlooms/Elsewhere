package team.lookingglass.elsewhere;

import net.minecraft.core.registries.Registries;
import team.lookingglass.elsewhere.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
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
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ItemRecipeProvider::new);
		pack.addProvider(ParticleProvider::new);
		pack.addProvider(EntityLootTableProvider::new);
		pack.addProvider(EntityTagProvider::new);
		pack.addProvider(BiomeTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, EConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, EPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.BIOME, EBiomes::bootstrap);
		registryBuilder.add(Registries.NOISE, ENoise::bootstrap);
	}
}