package com.example.filmslist.model

import com.google.gson.annotations.SerializedName

class Top250DataDetailDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("rank")
    val rank: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("fullTitle")
    val fullTitle: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("crew")
    val crew: String?,
    @SerializedName("imDbRating")
    val imDbRating: String?,
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String?,
) {
    fun mapToSearchResult() = SearchResult(
        id = id ?: "",
        rank = rank ?: "",
        title = title ?: "",
        fullTitle = fullTitle ?: "",
        year = year ?: "",
        image = image ?: "",
        crew = crew ?: "",
        imDbRating = imDbRating ?: "",
        imDbRatingCount = imDbRatingCount ?: ""
    )
}