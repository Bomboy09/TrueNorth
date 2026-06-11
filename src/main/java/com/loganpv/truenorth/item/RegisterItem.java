package com.loganpv.truenorth.item;

import com.loganpv.truenorth.TrueNorth;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegisterItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TrueNorth.MODID);

    public static final DeferredItem<Item> MAGNETICCOMPASS = ITEMS.register("magnetic_compass", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
