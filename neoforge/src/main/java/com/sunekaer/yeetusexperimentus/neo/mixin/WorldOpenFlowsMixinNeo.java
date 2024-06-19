package com.sunekaer.yeetusexperimentus.neo.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Debug(export = true)
@Mixin(value = WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixinNeo {
    @ModifyVariable(
            method = "loadLevel(Lnet/minecraft/world/level/storage/LevelStorageSource$LevelStorageAccess;Lcom/mojang/serialization/Dynamic;ZZLjava/lang/Runnable;Z)V",
            at = @At("STORE"),
            ordinal = 3
    )
    private boolean no(boolean original) {
        return false;
    }
}
