package com.tapptitude.template.persistence.factory

import android.app.Application
import androidx.room.Room
import com.tapptitude.template.persistence.LocalDatabase
import com.tapptitude.template.persistence.factory.DatabaseMigrationsFactory.performMigrations
import com.tapptitude.template.persistence.images.ImagesDao

internal object PersistenceComponentsFactory {

    private const val DATABASE_NAME = "LocalStore.db"

    fun provideDatabase(application: Application): LocalDatabase =
        Room.databaseBuilder(application, LocalDatabase::class.java, DATABASE_NAME)
            .performMigrations()
            .fallbackToDestructiveMigration()
            .build()

    fun provideImagesDao(database: LocalDatabase): ImagesDao = database.imagesDao
}
