package com.tapptitude.network.di

import com.tapptitude.network.api.ImageApi
import com.tapptitude.network.factory.NetworkComponentsFactory
import com.tapptitude.network.interceptor.SessionInterceptor
import com.tapptitude.network.source.ImageRemoteDataSource
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkComponentsFactory.provideMoshi() }
    factory { NetworkComponentsFactory.provideOkHttpClient(sessionInterceptor = get()) }
    factory { NetworkComponentsFactory.provideRetrofit(okHttpClient = get(), moshi = get()) }
    factory { NetworkComponentsFactory.provideApiImplementation(retrofit = get(), ImageApi::class.java) }

    factory { SessionInterceptor(sessionManager = get()) }

    factory { ImageRemoteDataSource(imageApi = get()) }
}