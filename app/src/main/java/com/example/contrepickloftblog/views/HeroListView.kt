package com.example.contrepickloftblog.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.contrepickloftblog.model.Hero

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface HeroListView: MvpView {
    fun presentHeroes(data: List<Hero>)
    fun presentLoading()
}