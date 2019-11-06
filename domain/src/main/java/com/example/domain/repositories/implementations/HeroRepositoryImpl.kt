package com.example.domain.repositories.implementations

import com.example.data.remote.providers.HeroProvaiderImpl
import com.example.domain.converters.HeroConverterImpl
import com.example.domain.model.Hero
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

//using for communication with db and backend
class HeroRepositoryImpl(private val heroConverter: HeroConverterImpl) {
    private val heroProvider: HeroProvaiderImpl = HeroProvaiderImpl()


    suspend fun fetchHeroes(): Deferred<List<Hero>> {
        return try {
            val heroes = heroProvider.getHeroesList().await()
            return GlobalScope.async {
                heroes.map { hero -> heroConverter.fromApiToUi(model = hero) }
            }
        } catch (e: Exception) {
            GlobalScope.async { error(e) }
        }
    }
}
