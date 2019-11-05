package com.example.contrepickloftblog.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.contrepickloftblog.model.Hero
import com.example.contrepickloftblog.views.HeroListView
import java.util.logging.Handler
import kotlin.concurrent.thread

@InjectViewState
class HeroListPresenter : MvpPresenter<HeroListView>() {
    fun fetchHero() {
        viewState.presentLoading()

        //in this case we can use Rx request in our database
        val handler = android.os.Handler()
        thread {

            Thread.sleep(3000)
            val mokcData = ArrayList<Hero>()
            mokcData.add(Hero(id = 0, title = "Anti-mage", icon = "", attackType = 0))
            mokcData.add(Hero(id = 1, title = "Dark Willow", icon = "", attackType = 1))
            mokcData.add(Hero(id = 2, title = "Lion", icon = "", attackType = 1))

            handler.post {
                viewState.presentHeroes(data = mokcData)
            }
        }
     }
}