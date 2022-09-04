package com.example.filmslist.model

import com.example.filmslist.BuildConfig
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface Top250MoviesApi {

    @GET("Top250Movies/{api_key}")
    fun get(@Path("api_key") key: String = BuildConfig.ImdbApiSecret): Deferred<Top250DataDTO>

}