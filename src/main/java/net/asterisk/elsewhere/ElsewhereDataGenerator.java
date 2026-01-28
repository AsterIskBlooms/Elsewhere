package net.asterisk.elsewhere;

import net.asterisk.elsewhere.datagen.*;
import net.asterisk.elsewhere.worldgen.EConfiguredFeatures;
import net.asterisk.elsewhere.worldgen.EDimensions;
import net.asterisk.elsewhere.worldgen.EPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.packs.VanillaPackResourcesBuilder;

public class ElsewhereDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(LangProviderEN::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(RegistryPackGenerator::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, EConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, EPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.DIMENSION_TYPE, EDimensions::bootstrapType);
	}
}