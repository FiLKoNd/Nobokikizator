package com.filkond.nobokikizator

import com.mojang.logging.LogUtils
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer
import net.fabricmc.api.ClientModInitializer

class NobokikizatorClient : ClientModInitializer {
    companion object {
        const val MOD_ID = "nobokikizator"
    }

    override fun onInitializeClient() {
        AutoConfig.register(
            NobokikConfig::class.java
        ) { definition, configClass ->
            GsonConfigSerializer(
                definition,
                configClass
            )
        }
        LogUtils.getLogger().info("сосал?")
    }
}