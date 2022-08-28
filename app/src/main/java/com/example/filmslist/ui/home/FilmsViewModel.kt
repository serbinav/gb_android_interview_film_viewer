package com.example.filmslist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilmsViewModel(
    filmsRepository: MoviesRepository = MoviesRepositoryFakeImpl()
) : ViewModel() {

    private val _data = MutableLiveData(filmsRepository.getListOfMovies())
    val data: LiveData<List<SearchResult>> = _data
}