package com.loganpv.truenorth;

import com.loganpv.truenorth.item.MagneticCompass;
import com.loganpv.truenorth.item.RegisterItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = TrueNorth.MODID, value = Dist.CLIENT)
public class TrueNorthClient {
    static float current;

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(RegisterItem.MAGNETIC_COMPASS.get(), ResourceLocation.fromNamespaceAndPath(TrueNorth.MODID, "angle"), (stack, world, player, seed) -> {
                if (player != null) {
                    current = Mth.positiveModulo(Mth.rotLerp(0.05f, current, player.getVisualRotationYInDegrees() + 180), 360);
                    return current / 360;
                }
                else {
                    return 0f;
                }
            });
        });
    }
}