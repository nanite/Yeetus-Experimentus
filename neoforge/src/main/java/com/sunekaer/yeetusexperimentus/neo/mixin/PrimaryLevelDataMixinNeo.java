package com.sunekaer.yeetusexperimentus.neo.mixin;

import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PrimaryLevelData.class, remap = false)
public class PrimaryLevelDataMixinNeo {

    @Inject(method = "hasConfirmedExperimentalWarning", at =@At("HEAD"), cancellable = true)
    public void hasConfirmedExperimentalWarning(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
