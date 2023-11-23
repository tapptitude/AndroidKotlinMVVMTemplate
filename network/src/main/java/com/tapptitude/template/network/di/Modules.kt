package com.tapptitude.template.network.di

import com.tapptitude.template.network.api.ImageApi
import com.tapptitude.template.network.factory.NetworkComponentsFactory
import com.tapptitude.template.network.interceptor.SessionInterceptor
import com.tapptitude.template.network.source.ImageRemoteDataSource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkComponentsFactory.provideMoshi() }
    factory { NetworkComponentsFactory.provideOkHttpClient(sessionInterceptor = get()) }
    factory { NetworkComponentsFactory.provideRetrofit(okHttpClient = get(), moshi = get()) }
    factory { NetworkComponentsFactory.provideApiImplementation(retrofit = get(), ImageApi::class.java) }

    factoryOf(::SessionInterceptor)
    factoryOf(::ImageRemoteDataSource)
}
