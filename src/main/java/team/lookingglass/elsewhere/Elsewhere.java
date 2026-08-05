package team.lookingglass.elsewhere;

import team.lookingglass.elsewhere.datagen.tags.FlammableBlocks;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.entity.EEntitySpawns;
import team.lookingglass.elsewhere.registry.*;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.lookingglass.elsewhere.registry.EBlockEntityTypes;
import team.lookingglass.elsewhere.registry.events.EServerEvents;
import team.lookingglass.elsewhere.registry.util.EPoiTypes;
import team.lookingglass.elsewhere.registry.render.EParticles;
import team.lookingglass.elsewhere.registry.tags.*;
import team.lookingglass.elsewhere.registry.properties.EBlockInteractions;
import team.lookingglass.elsewhere.worldgen.EFeatures;
import team.lookingglass.elsewhere.worldgen.noise.ENoise;
import team.lookingglass.elsewhere.worldgen.EWorldgen;
import team.lookingglass.elsewhere.worldgen.features.placement.EPlacementModifiers;

public class Elsewhere implements ModInitializer {
	public static final String MODID = "elsewhere";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		EItems.initialize();
		ETabs.initialize();
		EBlocks.initialize();
		EBlockInteractions.initialize();
		ESounds.initialize();
		EFeatures.initialize();
		EWorldgen.initialize();
		EBlockEntityTypes.initialize();
		EParticles.initialize();
		EServerEvents.initialize();
		ENoise.initialize();
		EBlockTags.initialize();
		EItemTags.initialize();
		EEntities.initialize();
		EEntitySpawns.initialize();
		ETreeGrowers.initialize();
		EPoiTypes.initialize();
		EPlacementModifiers.initialize();
		FlammableBlocks.initialize();
	}
}