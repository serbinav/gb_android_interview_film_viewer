package com.example.filmslist.model

data class FilmsSearch constructor(
    //Movie = 2
    var searchType: String,
    var expression: String,
    var results: List<SearchResult>,
    var errorMessage: String
)

data class SearchResult constructor(
    var id: String,
    var resultType: String,
    var image: String,
    var title: String,
    var description: String
)