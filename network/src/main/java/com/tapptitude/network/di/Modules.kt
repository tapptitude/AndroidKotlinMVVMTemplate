package com.tapptitude.network.di

import com.tapptitude.network.api.SampleApi
import com.tapptitude.network.factory.NetworkComponentsFactory
import org.koin.dsl.module

val networkModule = module {
    factory { NetworkComponentsFactory.provideMoshi() }
    factory { NetworkComponentsFactory.provideOkHttpClient() }
    factory { NetworkComponentsFactory.provideRetrofit(okHttpClient = get(), moshi = get()) }
    factory { NetworkComponentsFactory.provideApiImplementation(retrofit = get(), SampleApi::class.java) }
}