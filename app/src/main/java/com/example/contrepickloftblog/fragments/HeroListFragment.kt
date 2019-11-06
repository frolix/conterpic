package com.example.contrepickloftblog.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.contrepickloftblog.R
import kotlinx.android.synthetic.main.fragment_hero_list.*

/**
 * A simple [Fragment] subclass.
 */
class HeroListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

}
