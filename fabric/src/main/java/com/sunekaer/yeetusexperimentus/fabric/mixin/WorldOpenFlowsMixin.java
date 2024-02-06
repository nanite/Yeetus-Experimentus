package com.sunekaer.yeetusexperimentus.fabric.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixin {

    @Inject(
            method = "confirmWorldCreation",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", ordinal = 0),
            cancellable = true
    )
    private static void beGone(Minecraft client, CreateWorldScreen parent, Lifecycle lifecycle, Runnable loader, boolean bo, CallbackInfo ci) {
        loader.run();
        ci.cancel();
    }

    @ModifyVariable(
            method = "loadLevel(Lnet/minecraft/world/level/storage/LevelStorageSource$LevelStorageAccess;Lcom/mojang/serialization/Dynamic;ZZLjava/lang/Runnable;)V",
            at = @At("STORE"),
            ordinal = 3
    )
    public boolean no(boolean a) {
        return false;
    }
}
