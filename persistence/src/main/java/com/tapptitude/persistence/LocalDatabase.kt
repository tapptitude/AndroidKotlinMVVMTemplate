package com.tapptitude.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tapptitude.persistence.images.ImageEntity
import com.tapptitude.persistence.images.ImagesDao

@Database(
    entities = [ImageEntity::class],
    version = 2
)

internal abstract class LocalDatabase : RoomDatabase() {

    abstract val imagesDao: ImagesDao
}
