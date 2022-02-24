package com.tapptitude.network.api

import retrofit2.http.GET

interface SampleApi {
    @GET("/some/really/cool/api")
    fun getThisCoolStuff()
}