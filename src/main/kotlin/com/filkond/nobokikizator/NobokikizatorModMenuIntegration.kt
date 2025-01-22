package com.filkond.nobokikizator

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screen.Screen


class NobokikizatorModMenuIntegration : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { parent: Screen? ->
            AutoConfig.getConfigScreen(NobokikConfig::class.java, parent).get()
        }
    }
}