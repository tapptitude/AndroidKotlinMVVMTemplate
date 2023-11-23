package com.tapptitude.template.core.di

import com.tapptitude.template.core.repository.ImageRepository
import com.tapptitude.template.core.repository.ImageRepositoryImpl
import com.tapptitude.template.core.usecase.LoadImageUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val coreModule =
    module {
        factoryOf(::ImageRepositoryImpl) { bind<ImageRepository>() }
        factoryOf(::LoadImageUseCase)
    }
