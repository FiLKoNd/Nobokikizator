package com.filkond.nobokikizator

import com.mojang.logging.LogUtils
import net.fabricmc.api.ClientModInitializer
import net.minecraft.util.Identifier

class NobokikizatorClient : ClientModInitializer {
    companion object {
        const val MOD_ID = "nobokikizator"

        @JvmStatic
        val theNoboKik: Identifier = Identifier.of(MOD_ID, "skins/nobokik.png")
    }
    override fun onInitializeClient() {
        LogUtils.getLogger().info("сосал?")
    }
}