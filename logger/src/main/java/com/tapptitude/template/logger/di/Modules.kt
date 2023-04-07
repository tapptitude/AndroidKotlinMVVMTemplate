package com.tapptitude.template.logger.di

import com.tapptitude.template.logger.Logger
import com.tapptitude.template.logger.timber.TimberLogger
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val loggerModule = module {
    singleOf(::TimberLogger) { bind<Logger>() }
}
