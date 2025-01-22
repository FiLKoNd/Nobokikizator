package com.filkond.nobokikizator.mixin;

import com.filkond.nobokikizator.NobokikConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @Unique
    private static final Text NOBOKIK = Text.literal("NoboKik");

    @Unique
    private static final NobokikConfig NOBOKIK_CONFIG = AutoConfig.getConfigHolder(NobokikConfig.class).getConfig();

    @ModifyArg(method = "renderLabelIfPresent*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;renderLabelIfPresent(Lnet/minecraft/client/render/entity/state/EntityRenderState;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", ordinal = 1), index = 1)
    public Text nick(Text text) {
        return NOBOKIK_CONFIG.isNameReplaceEnabled() ? NOBOKIK : text;
    }
}
