package com.tapptitude.template.network.api

import com.tapptitude.template.network.dto.ImageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("v1/image")
    suspend fun getRandomImage(@Query("format") format: String = "json"): ImageDto
}
