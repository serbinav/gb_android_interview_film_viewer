package com.example.filmslist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmslist.model.SearchResult
import com.example.filmslist.repository.MoviesRepository
import kotlinx.coroutines.*

class FilmsViewModel(
    private val filmsRepository: MoviesRepository
) : ViewModel() {
    private val _data: MutableLiveData<List<SearchResult>> = MutableLiveData()
    val data: LiveData<List<SearchResult>> = _data

    private val coroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, _ ->
            _data.postValue(arrayListOf())
        })

    private var coroutineJob: Job? = null

    fun getData() {
        coroutineJob?.cancel()
        coroutineJob = coroutineScope.launch {
            _data.postValue(filmsRepository.getTop250OfMovies().results)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}