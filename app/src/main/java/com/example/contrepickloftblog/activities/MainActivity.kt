package com.example.contrepickloftblog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.contrepickloftblog.R
import com.example.contrepickloftblog.adapter.HeroAdapter
import com.example.contrepickloftblog.model.Hero
import com.example.contrepickloftblog.presenter.HeroListPresenter
import com.example.contrepickloftblog.views.HeroListView
import kotlinx.android.synthetic.main.fragment_hero_list.*

class MainActivity : MvpAppCompatActivity(), HeroListView {

    private val mAdapter = HeroAdapter()

    @InjectPresenter
    lateinit var heroListPresenter: HeroListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()

        heroListPresenter.fetchHero()
    }

    private fun setupAdapter() {
        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerHeroList.layoutManager = layoutManager
        recyclerHeroList.adapter = mAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostMain).navigateUp()
    }

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
