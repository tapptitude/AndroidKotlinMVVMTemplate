package com.tapptitude.network.api

import com.tapptitude.network.dto.ImageDto
import retrofit2.http.GET

interface SampleApi {
    @GET("api/")
    fun getRandomImage(): ImageDto
}