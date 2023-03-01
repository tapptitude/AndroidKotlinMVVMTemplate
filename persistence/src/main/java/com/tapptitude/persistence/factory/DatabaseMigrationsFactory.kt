package com.tapptitude.persistence.factory

import androidx.room.RoomDatabase.Builder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tapptitude.persistence.LocalDatabase

internal object DatabaseMigrationsFactory {

    fun Builder<LocalDatabase>.performMigrations(): Builder<LocalDatabase> = addMigrations(
        object : Migration(1, 2) {
            /* Example of migration */
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DROP TABLE IF EXISTS images")
                database.execSQL("CREATE TABLE images(url TEXT NOT NULL primary key)")
            }
        }
    )
}
