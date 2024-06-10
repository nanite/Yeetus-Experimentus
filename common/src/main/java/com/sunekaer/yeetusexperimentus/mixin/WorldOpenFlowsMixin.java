package com.sunekaer.yeetusexperimentus.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Debug(export = true)
@Mixin(WorldOpenFlows.class)
public class WorldOpenFlowsMixin {
    @ModifyVariable(method = "confirmWorldCreation", at = @At("HEAD"), argsOnly = true)
    private static Lifecycle alwaysStable(Lifecycle cycle) {
        return Lifecycle.stable();
    }

    @ModifyVariable(
            method = "openWorldCheckWorldStemCompatibility",
            at = @At("STORE"),
            ordinal = 1
    )
    public boolean no(boolean a) {
        return false;
    }
}
