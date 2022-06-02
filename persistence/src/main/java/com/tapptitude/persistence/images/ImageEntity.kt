package com.tapptitude.persistence.images

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "url")
    val url: String
)