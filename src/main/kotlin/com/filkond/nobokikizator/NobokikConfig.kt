package com.filkond.nobokikizator

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config

@Config(name = "nobokikizator")
class NobokikConfig : ConfigData {
    var isSkinReplaceEnabled = true
    var isNameReplaceEnabled = true
}