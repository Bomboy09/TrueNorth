package com.loganpv.client;

import com.loganpv.ModItems;
import com.loganpv.TrueNorth;
import com.loganpv.MagneticCompass;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class TrueNorthClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemProperties.register(ModItems.MAGNETICCOMPASS, ResourceLocation.fromNamespaceAndPath(TrueNorth.MOD_ID, "angle"), (stack, world, player, seed) -> {
			if (player != null) {
				return MagneticCompass.GetYRot(player);
			}
			else {
				return 0f;
			}
		});
	}
}