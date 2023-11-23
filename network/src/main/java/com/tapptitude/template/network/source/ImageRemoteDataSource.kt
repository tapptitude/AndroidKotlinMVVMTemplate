package com.tapptitude.template.network.source

import com.tapptitude.template.common.dispatcherProvider.DispatcherProvider
import com.tapptitude.template.network.api.ImageApi
import com.tapptitude.template.network.dto.ImageDto
import kotlinx.coroutines.withContext

class ImageRemoteDataSource(
    private val dispatcherProvider: DispatcherProvider,
    private val imageApi: ImageApi,
) {

    suspend fun getRandomImage(): ImageDto = withContext(dispatcherProvider.io) {
        imageApi.getRandomImage()
    }
}
