package com.example.domain.repositories.implementations

import com.example.domain.model.Hero
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

//using for communication with db and backend
class HeroRepositoryImpl {

    suspend fun fetchHeroes(): Deferred<List<Hero>> {
        Thread.sleep(3000)

        val mockData = ArrayList<Hero>()
        mockData.add(
            Hero(
                id = 0,
                title = "Anti-mage",
                icon = "",
                attackType = 0
            )
        )
        mockData.add(
            Hero(
                id = 1,
                title = "Dark Willow",
                icon = "",
                attackType = 1
            )
        )
        mockData.add(
            Hero(
                id = 2,
                title = "Lion",
                icon = "",
                attackType = 1
            )
        )
        return GlobalScope.async { mockData }
    }
}