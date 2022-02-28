package com.tapptitude.network.di

import com.tapptitude.network.api.ImageApi
import com.tapptitude.network.factory.NetworkComponentsFactory
import com.tapptitude.network.source.ImageRemoteDataSource
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkComponentsFactory.provideMoshi() }
    factory { NetworkComponentsFactory.provideOkHttpClient() }
    factory { NetworkComponentsFactory.provideRetrofit(okHttpClient = get(), moshi = get()) }
    factory { NetworkComponentsFactory.provideApiImplementation(retrofit = get(), ImageApi::class.java) }

    factory { ImageRemoteDataSource(imageApi = get()) }
}