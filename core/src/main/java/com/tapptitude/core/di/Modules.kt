package com.tapptitude.core.di

import com.tapptitude.core.repository.ImageRepository
import com.tapptitude.core.usecase.LoadImageUseCase
import org.koin.dsl.module

val coreModule = module {
    factory { ImageRepository(imageRemoteDataSource = get()) }

    factory { LoadImageUseCase(imageRepository = get()) }
}