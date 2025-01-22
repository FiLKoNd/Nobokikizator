package com.filkond.nobokikizator.mixin;

import com.filkond.nobokikizator.NobokikConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.filkond.nobokikizator.NobokikizatorClient.MOD_ID;

@Mixin(SkinTextures.class)
public abstract class SkinTexturesMixin {
    @Unique
    private static final NobokikConfig NOBOKIK_CONFIG = AutoConfig.getConfigHolder(NobokikConfig.class).getConfig();
    @Unique
    private static final Identifier NOBOKIK_SKIN = Identifier.of(MOD_ID, "skins/nobokik.png");

    @Inject(method = "texture", at = {@At("HEAD")}, cancellable = true)
    public void texture(CallbackInfoReturnable<Identifier> cir) {
        if (NOBOKIK_CONFIG.isSkinReplaceEnabled()) {
            cir.setReturnValue(NOBOKIK_SKIN);
        }
    }

    @Inject(method = "model", at = {@At("HEAD")}, cancellable = true)
    public void model(CallbackInfoReturnable<SkinTextures.Model> cir) {
        if (NOBOKIK_CONFIG.isSkinReplaceEnabled()) {
            cir.setReturnValue(SkinTextures.Model.SLIM);
        }
    }
}
