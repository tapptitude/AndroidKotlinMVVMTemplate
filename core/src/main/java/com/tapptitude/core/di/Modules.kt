package com.tapptitude.core.di

import com.tapptitude.core.repository.ImageRepository
import com.tapptitude.core.repository.ImageRepositoryImpl
import com.tapptitude.core.usecase.LoadImageUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val coreModule = module {
    factoryOf(::ImageRepositoryImpl) { bind<ImageRepository>() }
    factoryOf(::LoadImageUseCase)
}
