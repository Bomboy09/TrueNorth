package com.loganpv.truenorth;

import com.loganpv.truenorth.item.RegisterItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(TrueNorth.MODID)
@EventBusSubscriber(modid = TrueNorth.MODID, value = Dist.CLIENT)
public class TrueNorth {

    public static final String MODID = "truenorth";

    public TrueNorth(IEventBus modEventBus, ModContainer modContainer)
    {
        RegisterItem.register(modEventBus);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(RegisterItem.MAGNETICCOMPASS.get());
        }
    }
}
