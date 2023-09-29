package com.tapptitude.template.core.repository

import com.tapptitude.template.common.dispatcherProvider.DispatcherProvider
import com.tapptitude.template.core.model.Image
import com.tapptitude.template.core.model.extension.toEntity
import com.tapptitude.template.core.model.extension.toImage
import com.tapptitude.template.network.source.ImageRemoteDataSource
import com.tapptitude.template.persistence.images.ImagesDao
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val imagesDao: ImagesDao,
) : ImageRepository {

    @Suppress("TooGenericExceptionCaught")
    override suspend fun getRandomImage(): Image = withContext(dispatcherProvider.io) {
        try {
            imagesDao.save(imageRemoteDataSource.getRandomImage().toEntity()).toImage()
        } catch (e: Exception) {
            imagesDao.getRandomImage()?.toImage() ?: throw e
        }
    }
}
