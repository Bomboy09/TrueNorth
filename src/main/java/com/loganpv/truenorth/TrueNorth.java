package com.loganpv.truenorth;

import com.loganpv.truenorth.item.RegisterItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(TrueNorth.MODID)
public class TrueNorth {

    public static final String MODID = "truenorth";

    public TrueNorth(IEventBus modEventBus, ModContainer modContainer)
    {
        RegisterItem.register(modEventBus);
    }
}
