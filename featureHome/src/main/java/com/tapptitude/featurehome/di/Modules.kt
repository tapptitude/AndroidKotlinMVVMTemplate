package com.tapptitude.featurehome.di

import com.tapptitude.featurehome.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModules = module {
    viewModel { HomeViewModel(loadImageUseCase = get(), sessionManager = get()) }
}