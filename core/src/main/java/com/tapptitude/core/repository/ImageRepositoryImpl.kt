package com.tapptitude.core.repository

import com.tapptitude.core.model.Image
import com.tapptitude.core.model.extension.toEntity
import com.tapptitude.core.model.extension.toImage
import com.tapptitude.network.source.ImageRemoteDataSource
import com.tapptitude.persistence.images.ImagesDao
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val imagesDao: ImagesDao
) : ImageRepository {

    override suspend fun getRandomImage(): Image = withContext(IO) {
        try {
            imagesDao.save(imageRemoteDataSource.getRandomImage().toEntity()).toImage()
        } catch (e: Exception) {
            imagesDao.getRandomImage()?.toImage() ?: throw e
        }
    }
}