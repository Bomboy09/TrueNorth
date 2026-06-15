package com.loganpv;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MagneticCompass {
    public static float GetYRot(Entity entity){
        return (float) Mth.positiveModulo(((entity.getVisualRotationYInDegrees() + 180) / 360.0F), 1.0);
    }
}
