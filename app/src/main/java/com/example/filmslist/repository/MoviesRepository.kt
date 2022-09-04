package com.example.filmslist.repository

import com.example.filmslist.model.Top250Data

interface MoviesRepository {
    suspend fun getTop250OfMovies(): Top250Data
}