package com.example.data.remote.service

import com.example.data.remote.model.HeroApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HeroService {

    @GET("./heroes")
    fun getHeroes(): Deferred<List<HeroApi>>


}