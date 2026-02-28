package net.asterisk.elsewhere;

import net.asterisk.elsewhere.registry.*;
import net.asterisk.elsewhere.worldgen.tree.ESaplingGenerators;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Elsewhere implements ModInitializer {
	public static final String MODID = "elsewhere";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		EItems.initialize();
		ETabs.initialize();
		EBlocks.initialize();
		ESounds.initialize();
		ESaplingGenerators.initialize();
		EEnchantments.initialize();
	}
}