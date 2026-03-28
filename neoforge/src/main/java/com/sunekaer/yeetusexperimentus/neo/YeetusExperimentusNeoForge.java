package com.sunekaer.yeetusexperimentus.neo;

import com.sunekaer.yeetusexperimentus.YeetusExperimentus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(YeetusExperimentus.MOD_ID)
public class YeetusExperimentusNeoForge {
    public YeetusExperimentusNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        YeetusExperimentus.init();
    }
}
