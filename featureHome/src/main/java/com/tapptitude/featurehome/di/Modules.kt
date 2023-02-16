package com.tapptitude.featurehome.di

import com.tapptitude.featurehome.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeModules = module {
    viewModelOf(::HomeViewModel)
}