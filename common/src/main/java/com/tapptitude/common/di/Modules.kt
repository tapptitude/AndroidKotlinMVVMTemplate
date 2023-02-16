package com.tapptitude.common.di

import com.tapptitude.common.dispatcherProvider.AppDispatchers
import com.tapptitude.common.dispatcherProvider.DispatcherProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::AppDispatchers) { bind<DispatcherProvider>() }
}