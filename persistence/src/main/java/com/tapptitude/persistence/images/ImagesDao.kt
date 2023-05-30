package com.tapptitude.persistence.images

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(image: ImageEntity)

    @Query("SELECT * FROM images")
    fun getAllImages(): List<ImageEntity>

    @Query("SELECT * FROM images WHERE url = :url")
    fun getImage(url: String): ImageEntity

    @Query("DELETE FROM images WHERE url = :url")
    fun deleteImage(url: String)

    @Transaction
    fun getRandomImage(): ImageEntity? = getAllImages().randomOrNull()

    @Transaction
    fun save(image: ImageEntity): ImageEntity {
        insert(image)
        return image
    }
}
