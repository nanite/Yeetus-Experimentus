package com.sunekaer.yeetusexperimentus.mixin;

import com.mojang.serialization.Dynamic;
import com.mojang.serialization.Lifecycle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixin {

    @Shadow protected abstract void loadLevel(LevelStorageSource.LevelStorageAccess arg, Dynamic<?> dynamic, boolean bl, boolean bl2, Runnable runnable);

    @Inject(
            method = "confirmWorldCreation",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", ordinal = 0),
            cancellable = true
    )
    private static void beGone(Minecraft client, CreateWorldScreen parent, Lifecycle lifecycle, Runnable loader, boolean bo, CallbackInfo ci) {
        loader.run();
        ci.cancel();
    }


    @Inject(method = "loadLevel", at = @At("HEAD"), cancellable = true)
    private void onLoadLevel(LevelStorageSource.LevelStorageAccess levelStorageAccess, Dynamic<?> dynamic, boolean bl, boolean bl2, Runnable runnable, CallbackInfo callbackInfo) {
        loadLevel(levelStorageAccess, dynamic, false, false, runnable);
        callbackInfo.cancel();
    }
}
