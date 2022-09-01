package com.example.filmslist.repository

import com.example.filmslist.model.SearchResult

interface MoviesRepository {
    fun getListOfMovies(): List<SearchResult>
}