package team.lookingglass.constructure;

import net.minecraft.data.recipes.RecipeProvider;
import team.lookingglass.constructure.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class ConstructureDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(LangProviderEN::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ConRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {

	}
}