package team.lookingglass.constructure;

import team.lookingglass.constructure.registry.*;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constructure implements ModInitializer {
	public static final String MODID = "constructure";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		CWorldgen.initialize();
		CItems.initialize();
		CTabs.initialize();
		CBlocks.initialize();
		CSounds.initialize();
	}
}