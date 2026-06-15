package com.loganpv;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(TrueNorth.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item MAGNETICCOMPASS = register(
            new Item(new Item.Properties()),
            "magnetic_compass"
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModItems.MAGNETICCOMPASS));
    }
}
