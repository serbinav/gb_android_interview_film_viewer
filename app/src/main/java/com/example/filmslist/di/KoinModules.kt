package com.example.filmslist.di

import com.example.filmslist.ui.home.FilmsViewModel
import com.example.filmslist.repository.MoviesRepository
import com.example.filmslist.repository.MoviesRepositoryFakeImpl
import com.example.filmslist.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repository
    single<MoviesRepository> { MoviesRepositoryFakeImpl() }

    // View model
    viewModel { FilmsViewModel(filmsRepository = get()) }
    viewModel { NotificationsViewModel() }

}