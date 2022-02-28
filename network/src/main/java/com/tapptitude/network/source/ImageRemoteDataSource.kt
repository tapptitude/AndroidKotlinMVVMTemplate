package com.tapptitude.network.source

import com.tapptitude.network.api.ImageApi
import com.tapptitude.network.dto.ImageDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRemoteDataSource(private val imageApi: ImageApi) {
    suspend fun getRandomImage(): ImageDto {
        return withContext(Dispatchers.IO) {
            imageApi.getRandomImage()
        }
    }
}