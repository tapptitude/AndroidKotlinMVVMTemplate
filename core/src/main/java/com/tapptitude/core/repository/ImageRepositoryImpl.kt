package com.tapptitude.core.repository

import com.tapptitude.core.model.Image
import com.tapptitude.core.model.extension.toImage
import com.tapptitude.network.source.ImageRemoteDataSource

class ImageRepositoryImpl(private val imageRemoteDataSource: ImageRemoteDataSource) : ImageRepository {
    override suspend fun getRandomImage(): Image {
        return imageRemoteDataSource.getRandomImage()
            .toImage()
    }
}