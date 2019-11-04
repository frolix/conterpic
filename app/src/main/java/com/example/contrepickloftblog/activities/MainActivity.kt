package com.example.contrepickloftblog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.contrepickloftblog.R
import com.example.contrepickloftblog.adapter.HeroAdapter
import com.example.contrepickloftblog.model.Hero
import com.example.contrepickloftblog.views.HeroListView
import kotlinx.android.synthetic.main.fragment_hero_list.*

class MainActivity : MvpAppCompatActivity(), HeroListView {

    private val mAdapter = HeroAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupAdapter()
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun presentLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
