package com.tapptitude.core.usecase

import com.tapptitude.core.model.Image
import com.tapptitude.core.repository.ImageRepositoryImpl

class LoadImageUseCase(private val imageRepository: ImageRepositoryImpl) {
    suspend fun invoke(): Image {
        return imageRepository.getRandomImage()
    }
}