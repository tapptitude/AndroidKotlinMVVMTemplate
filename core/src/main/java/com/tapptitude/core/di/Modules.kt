package com.tapptitude.core.di

import com.tapptitude.core.repository.ImageRepository
import org.koin.dsl.module

val coreModules = module {
    factory { ImageRepository(imageRemoteDataSource = get()) }
}