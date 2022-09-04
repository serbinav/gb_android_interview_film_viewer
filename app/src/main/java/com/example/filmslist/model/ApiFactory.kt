package com.example.filmslist.model

import com.example.filmslist.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val gson: Gson =
        GsonBuilder()
            .create()

    private val imdbApi: Top250MoviesApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_LOCATIONS)
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Top250MoviesApi::class.java)
    }

    fun create(): Top250MoviesApi = imdbApi
}