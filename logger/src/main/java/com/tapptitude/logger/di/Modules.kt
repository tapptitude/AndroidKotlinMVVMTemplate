package com.tapptitude.logger.di

import com.tapptitude.logger.Logger
import com.tapptitude.logger.timber.TimberLogger
import org.koin.dsl.module

val loggerModule = module {
    single<Logger> { TimberLogger() }
}