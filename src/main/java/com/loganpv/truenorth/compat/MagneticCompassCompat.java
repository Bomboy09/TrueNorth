package com.loganpv.truenorth.compat;

import com.loganpv.truenorth.item.RegisterItem;
import dev.simulated_team.simulated.Simulated;
import dev.simulated_team.simulated.content.navigation_targets.MagnetNavigationTarget;
import dev.simulated_team.simulated.registrate.SimulatedRegistrate;

import java.util.function.Supplier;

public class MagneticCompassCompat {
    private static final SimulatedRegistrate REGISTRATE = Simulated.getRegistrate();

    public static final Supplier<MagnetNavigationTarget> MAG_COMPASS = Simulated.getRegistrate().navTarget("magnet_compass", MagnetNavigationTarget::new, RegisterItem.MAGNETIC_COMPASS);

    public static void register() {
    }
}
