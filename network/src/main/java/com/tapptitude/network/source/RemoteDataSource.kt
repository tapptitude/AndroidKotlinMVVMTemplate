package com.tapptitude.network.source

import com.tapptitude.network.api.SampleApi
import com.tapptitude.network.dto.ImageDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource(private val sampleApi: SampleApi) {
    suspend fun getRandomImage(): ImageDto {
        return withContext(Dispatchers.IO) {
            sampleApi.getRandomImage()
        }
    }
}