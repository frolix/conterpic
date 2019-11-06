package com.example.contrepickloftblog.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.contrepickloftblog.views.HeroListView
import com.example.domain.repositories.implementations.HeroRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@InjectViewState
class HeroListPresenter : MvpPresenter<HeroListView>() {

    private val heroesRepositoryImpl = HeroRepositoryImpl()


    suspend fun fetchHero() {
        viewState.presentLoading()
        GlobalScope.launch { Dispatchers.IO }
        try {
            val heroes = heroesRepositoryImpl.fetchHeroes().await()

            withContext(Dispatchers.Main){
                viewState.presentHeroes(data = heroes)
            }


        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}