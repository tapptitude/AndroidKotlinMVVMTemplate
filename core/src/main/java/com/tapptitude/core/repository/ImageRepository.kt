package com.tapptitude.core.repository

import com.tapptitude.core.model.Image
import com.tapptitude.core.model.extension.toImage
import com.tapptitude.network.source.ImageRemoteDataSource

class ImageRepository(val imageRemoteDataSource: ImageRemoteDataSource) {
    suspend fun getRandomImage(): Image {
        return imageRemoteDataSource.getRandomImage()
            .toImage()
    }
}