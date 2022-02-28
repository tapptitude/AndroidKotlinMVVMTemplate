package com.tapptitude.imageloading.di

import com.tapptitude.imageloading.GlideImageLoader
import com.tapptitude.imageloading.ImageLoader
import org.koin.dsl.module

val imageLoaderModule = module {
    factory<ImageLoader> { GlideImageLoader() }
}