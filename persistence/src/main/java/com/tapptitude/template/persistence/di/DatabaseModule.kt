package com.tapptitude.template.persistence.di

import com.tapptitude.template.persistence.factory.PersistenceComponentsFactory.provideDatabase
import com.tapptitude.template.persistence.factory.PersistenceComponentsFactory.provideImagesDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule =
    module {
        single { provideDatabase(application = androidApplication()) }
        factory { provideImagesDao(database = get()) }
    }
