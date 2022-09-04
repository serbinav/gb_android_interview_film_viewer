package com.example.filmslist.model

import com.google.gson.annotations.SerializedName

class Top250DataDTO(
    @SerializedName("items")
    val items: List<Top250DataDetailDTO?>?,
    @SerializedName("errorMessage")
    val errorMessage: String?
) {
    fun mapToTop250Data(): Top250Data {
        val list = ArrayList<SearchResult>()

        if (!items.isNullOrEmpty()) {
            for (entity in items) {
                entity?.let { list.add(it.mapToSearchResult()) }
            }
        }
        return Top250Data(list, errorMessage ?: "")
    }
}