package com.sunekaer.yeetusexperimentus.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldOpenFlows.class)
public abstract class WPFMixin {
    @Inject(
            method = "confirmWorldCreation",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", ordinal = 0),
            cancellable = true
    )
    private static void beGone(Minecraft client, CreateWorldScreen parent, Lifecycle lifecycle, Runnable loader, CallbackInfo ci) {
        loader.run();
        ci.cancel();
    }
}
