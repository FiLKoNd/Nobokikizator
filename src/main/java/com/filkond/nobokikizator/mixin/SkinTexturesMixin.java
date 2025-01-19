package com.filkond.nobokikizator.mixin;

import com.filkond.nobokikizator.NobokikizatorClient;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkinTextures.class)
public abstract class SkinTexturesMixin {
    @Inject(method = "texture", at = {@At("HEAD")}, cancellable = true)
    public void texture(CallbackInfoReturnable<Identifier> cir) {
        cir.setReturnValue(NobokikizatorClient.getTheNoboKik());
    }

    @Inject(method = "model", at = {@At("HEAD")}, cancellable = true)
    public void model(CallbackInfoReturnable<SkinTextures.Model> cir) {
        cir.setReturnValue(SkinTextures.Model.SLIM);
    }
}
