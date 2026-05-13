package team.lookingglass.elsewhere;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.entity.EEntityType;
import team.lookingglass.elsewhere.registry.*;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.lookingglass.elsewhere.worldgen.EFeatureTypes;
import team.lookingglass.elsewhere.worldgen.EWorldgen;
import team.lookingglass.elsewhere.worldgen.NoiseCondition3D;

public class Elsewhere implements ModInitializer {
	public static final String MODID = "elsewhere";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		EItems.initialize();
		ETabs.initialize();
		EBlocks.initialize();
		ESounds.initialize();
		EFeatureTypes.initialize();
		EWorldgen.initialize();
		EBlockEntityTypes.initialize();
		EParticles.initialize();
		EEntityType.initialize();

		Registry.register(BuiltInRegistries.MATERIAL_CONDITION,
				Identifier.fromNamespaceAndPath(Elsewhere.MODID, "noise_3d"),
				NoiseCondition3D.CODEC.codec());
	}
}