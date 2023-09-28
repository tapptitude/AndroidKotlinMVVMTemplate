package com.tapptitude.template.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tapptitude.template.persistence.images.ImageEntity
import com.tapptitude.template.persistence.images.ImagesDao

@Database(
    entities = [ImageEntity::class],
    version = 2,
)
internal abstract class LocalDatabase : RoomDatabase() {

    abstract val imagesDao: ImagesDao
}
