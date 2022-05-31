package com.tapptitude.core.usecase

import com.tapptitude.core.model.Image
import com.tapptitude.core.repository.ImageRepository

class LoadImageUseCase internal constructor(private val imageRepository: ImageRepository) {

    suspend fun invoke(): Image = imageRepository.getRandomImage()
}