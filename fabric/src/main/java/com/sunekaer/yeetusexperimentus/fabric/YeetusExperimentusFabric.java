package com.sunekaer.yeetusexperimentus.fabric;

import com.sunekaer.yeetusexperimentus.YeetusExperimentus;
import net.fabricmc.api.ModInitializer;

public class YeetusExperimentusFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        YeetusExperimentus.init();
    }
}
