package com.tapptitude.home.di

import com.tapptitude.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModules = module {
    viewModel { HomeViewModel(loadImageUseCase = get(), sessionManager = get(), dispatcherProvider = get()) }
}