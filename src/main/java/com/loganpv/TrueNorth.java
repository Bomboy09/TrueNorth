package com.loganpv;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueNorth implements ModInitializer {
	public static final String MOD_ID = "truenorth";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();

		LOGGER.info("True North: All Items Initialized Successfully");
	}
}