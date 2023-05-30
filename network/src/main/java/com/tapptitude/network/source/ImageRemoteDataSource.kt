package com.tapptitude.network.source

import com.tapptitude.common.dispatcherProvider.DispatcherProvider
import com.tapptitude.network.api.ImageApi
import com.tapptitude.network.dto.ImageDto
import kotlinx.coroutines.withContext

class ImageRemoteDataSource(
    private val dispatcherProvider: DispatcherProvider,
    private val imageApi: ImageApi
) {

    suspend fun getRandomImage(): ImageDto = withContext(dispatcherProvider.io) {
        imageApi.getRandomImage()
    }
}
