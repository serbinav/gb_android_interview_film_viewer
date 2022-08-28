package com.example.filmslist.ui.home

interface MoviesRepository {
    fun getListOfMovies(): List<SearchResult>
}