package com.example.filmslist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmslist.model.SearchResult
import com.example.filmslist.repository.MoviesRepository
import com.example.filmslist.repository.MoviesRepositoryFakeImpl

class FilmsViewModel(
    filmsRepository: MoviesRepository = MoviesRepositoryFakeImpl()
) : ViewModel() {

    private val _data = MutableLiveData(filmsRepository.getListOfMovies())
    val data: LiveData<List<SearchResult>> = _data
}