package com.tapptitude.template.core.repository

import com.tapptitude.template.core.model.Image

interface ImageRepository {
    suspend fun getRandomImage(): Image
}
