package com.example.domain.converters

import com.example.data.remote.model.HeroApi
import com.example.domain.model.Hero

class HeroConverterImpl {
    fun fromApiToUi(model: HeroApi): Hero {
        return Hero(
            id = model.id, title = model.name.replace("npc_dota_hero_","")//warning hardcode pls don`t hit

            , attackType = if (model.attack_type == "Melee") {
                0
            } else {
                1
            }, icon = ""
        )
    }
}