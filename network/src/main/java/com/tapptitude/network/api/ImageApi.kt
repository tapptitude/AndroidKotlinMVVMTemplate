package com.tapptitude.network.api

import com.tapptitude.network.dto.ImageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("v1/image")
    suspend fun getRandomImage(@Query("format") format: String = "json"): ImageDto
}
