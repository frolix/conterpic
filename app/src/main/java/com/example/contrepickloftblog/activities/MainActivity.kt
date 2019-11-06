package com.example.contrepickloftblog.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.contrepickloftblog.R
import com.example.contrepickloftblog.adapter.HeroAdapter
import com.example.domain.model.Hero
import com.example.contrepickloftblog.presenter.HeroListPresenter
import com.example.contrepickloftblog.views.HeroListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : MvpAppCompatActivity(), HeroListView,CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var mAdapter = HeroAdapter()

    @InjectPresenter
    lateinit var heroListPresenter: HeroListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        heroListCall()
    }

     fun heroListCall(){
        launch {
            heroListPresenter.fetchHero()
        }
    }

    private fun initRecyclerView() {
        recyclerHeroList.apply {
            val layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            recyclerHeroList.layoutManager = layoutManager
            recyclerHeroList.adapter = mAdapter
        }
    }


//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.navHostMain).navigateUp()
//    }

    //view implementation
    override fun presentHeroes(data: List<Hero>) {
        recyclerHeroList.visibility = View.VISIBLE
        txt_hero_list_loading.visibility = View.GONE

        mAdapter.setData(newHero = data)
    }

    override fun presentLoading() {
        recyclerHeroList.visibility = View.GONE
        txt_hero_list_loading.visibility = View.VISIBLE

    }


}
