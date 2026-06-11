package com.loganpv.truenorth;

import com.loganpv.truenorth.item.MagneticCompass;
import com.loganpv.truenorth.item.RegisterItem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = TrueNorth.MODID, value = Dist.CLIENT)
public class TrueNorthClient {

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemProperties.register(RegisterItem.MAGNETICCOMPASS.get(), ResourceLocation.fromNamespaceAndPath(TrueNorth.MODID, "angle"), new ClampedItemPropertyFunction() {
                @OnlyIn(Dist.CLIENT)
                private double rotation;
                @OnlyIn(Dist.CLIENT)
                private double rota;
                @OnlyIn(Dist.CLIENT)
                private long lastUpdateTick;

                @OnlyIn(Dist.CLIENT)
                @Override
                public float unclampedCall(ItemStack stack, ClientLevel world, LivingEntity entityLiving, int seed) {
                    return MagneticCompass.GetYRot(entityLiving);
                }
            }
            );
        });
    }
}