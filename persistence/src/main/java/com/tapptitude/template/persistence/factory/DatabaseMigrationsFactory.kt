package com.tapptitude.template.persistence.factory

import androidx.room.RoomDatabase.Builder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tapptitude.template.persistence.LocalDatabase

internal object DatabaseMigrationsFactory {
    fun Builder<LocalDatabase>.performMigrations(): Builder<LocalDatabase> =
        addMigrations(
            object : Migration(1, 2) {
                // Example of migration
                override fun migrate(db: SupportSQLiteDatabase) {
                    db.execSQL("DROP TABLE IF EXISTS images")
                    db.execSQL("CREATE TABLE images(url TEXT NOT NULL primary key)")
                }
            },
        )
}
