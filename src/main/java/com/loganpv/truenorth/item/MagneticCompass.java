package com.loganpv.truenorth.item;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;

public class MagneticCompass extends Item {
    public MagneticCompass(Properties properties) {
        super(properties);
    }

    public static float GetYRot(Entity entity){
        return (float)Mth.positiveModulo(((entity.getVisualRotationYInDegrees() + 180) / 360.0F), 1.0);
    }
}