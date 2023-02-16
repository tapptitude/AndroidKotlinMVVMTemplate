package com.tapptitude.logger.di

import com.tapptitude.logger.Logger
import com.tapptitude.logger.timber.TimberLogger
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val loggerModule = module {
    singleOf(::TimberLogger) { bind<Logger>() }
}