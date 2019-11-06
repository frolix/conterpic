package com.example.data.remote.providers

import com.example.data.remote.helpers.RetrofitFactory
import com.example.data.remote.model.HeroApi
import kotlinx.coroutines.Deferred

class HeroProvaiderImpl {
    fun getHeroesList(): Deferred<List<HeroApi>> {
        return RetrofitFactory.getHeroesService().getHeroes()
    }
}