package com.example.data.remote.helpers

import com.example.data.remote.service.HeroService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitFactory {

    companion object {
        val baseUrl = "https://api.opendota.com/api/"

        private fun getOkHttpInstance(): OkHttpClient {
            val logginInterceptor = HttpLoggingInterceptor()
            logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return  OkHttpClient.Builder()
                .addInterceptor(logginInterceptor)
                .build()
        }

        private  fun gerRetrofitClient():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
//                .addConverterFactory(Json.nonstrict)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        fun getHeroesService() = gerRetrofitClient().create(HeroService::class.java )


    }

}