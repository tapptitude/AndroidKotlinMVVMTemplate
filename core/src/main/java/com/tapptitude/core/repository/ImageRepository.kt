package com.tapptitude.core.repository

import com.tapptitude.core.model.Image

interface ImageRepository {
    suspend fun getRandomImage(): Image
}
