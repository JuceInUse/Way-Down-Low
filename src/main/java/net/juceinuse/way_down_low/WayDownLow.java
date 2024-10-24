package net.juceinuse.way_down_low;

import net.fabricmc.api.ModInitializer;

import net.juceinuse.way_down_low.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WayDownLow implements ModInitializer {
	public static final String MOD_ID = "way_down_low";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from "+MOD_ID);
		ModItems.registerModItems();
	}
}