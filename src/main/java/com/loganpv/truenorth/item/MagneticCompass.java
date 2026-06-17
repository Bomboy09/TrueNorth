package com.loganpv.truenorth.item;

import com.loganpv.truenorth.TrueNorth;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;

import javax.annotation.Nullable;

@EventBusSubscriber(modid = TrueNorth.MODID, value = Dist.CLIENT)
public class MagneticCompass {
    static float current;

    public record ApplyCompassRotation() implements RangeSelectItemModelProperty {

        public static final MapCodec<ApplyCompassRotation> MAP_CODEC = MapCodec.unit(new ApplyCompassRotation());

        @Override
        public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable ItemOwner owner, int seed) {
            if (owner.asLivingEntity() != null) {
                current = Mth.positiveModulo(Mth.rotLerp(0.05f, current, owner.asLivingEntity().getVisualRotationYInDegrees() + 180), 360);
                return current / 360;
            }
            else {
                return 0f;
            }
        }

        @Override
        public MapCodec<ApplyCompassRotation> type() {
            return MAP_CODEC;
        }
    }

    // In some event handler class
    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerRangeProperties(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(
                // The name to reference as the type
                Identifier.fromNamespaceAndPath(TrueNorth.MODID, "angle"),
                // The map codec
                ApplyCompassRotation.MAP_CODEC
        );
    }
}