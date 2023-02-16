package com.tapptitude.imageloading.di

import com.tapptitude.imageloading.GlideImageLoader
import com.tapptitude.imageloading.ImageLoader
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val imageLoaderModule = module {
    factoryOf(::GlideImageLoader) { bind<ImageLoader>() }
}