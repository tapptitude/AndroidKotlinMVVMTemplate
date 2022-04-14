package com.tapptitude.persistence.di

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tapptitude.persistence.LocalDatabase
import com.tapptitude.persistence.images.ImagesDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

const val DATABASE_NAME = "LocalStore.db"

val databaseModule = module {
    fun provideDatabase(application: Application): LocalDatabase =
        Room.databaseBuilder(application, LocalDatabase::class.java, DATABASE_NAME)
            .addMigrations(object : Migration(1, 2) {
                /* Example of migration */
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("DROP TABLE IF EXISTS images")
                    database.execSQL("CREATE TABLE images(url TEXT NOT NULL primary key)")
                }
            })
            .fallbackToDestructiveMigration()
            .build()

    fun provideImagesDao(database: LocalDatabase): ImagesDao = database.imagesDao

    single { provideDatabase(androidApplication()) }
    factory { provideImagesDao(database = get()) }
}