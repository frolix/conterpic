package com.example.data.remote.helpers

import com.example.data.remote.service.HeroService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
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

        @UnstableDefault
        private  fun gerRetrofitClient():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpInstance())
                .addConverterFactory("application/json".toMediaTypeOrNull()?.let {
                    Json.nonstrict.asConverterFactory(
                        it
                    )
                })
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        @UnstableDefault
        fun getHeroesService() = gerRetrofitClient().create(HeroService::class.java )


    }

}