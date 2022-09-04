package com.example.filmslist.repository

import com.example.filmslist.model.ApiFactory
import com.example.filmslist.model.Top250Data

class MoviesRepositoryRemoteImpl : MoviesRepository {
    private val imdbApi = ApiFactory.create()

    override suspend fun getTop250OfMovies(): Top250Data {
        return imdbApi.get().await().mapToTop250Data()
    }
}