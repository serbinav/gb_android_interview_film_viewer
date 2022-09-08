package com.example.filmslist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Top250Data constructor(
    var results: List<SearchResult>,
    var errorMessage: String
)

@Parcelize
data class SearchResult constructor(
    var id: String,
    var rank: String,
    var title: String,
    var fullTitle: String,
    var year: String,
    var image: String,
    var crew: String,
    var imDbRating: String,
    var imDbRatingCount: String
) : Parcelable