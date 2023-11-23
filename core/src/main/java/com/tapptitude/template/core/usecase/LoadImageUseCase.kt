package com.tapptitude.template.core.usecase

import com.tapptitude.template.core.model.Image
import com.tapptitude.template.core.repository.ImageRepository

class LoadImageUseCase internal constructor(private val imageRepository: ImageRepository) {
    suspend fun invoke(): Image = imageRepository.getRandomImage()
}
