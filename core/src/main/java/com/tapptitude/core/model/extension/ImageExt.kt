package com.tapptitude.core.model.extension

import com.tapptitude.core.model.Image
import com.tapptitude.network.dto.ImageDto
import com.tapptitude.persistence.images.ImageEntity

internal fun ImageDto.toEntity() = ImageEntity(url = imageUrl.orEmpty())

internal fun ImageEntity.toImage() = Image(imageUrl = url)

internal fun Image.toImageDto() = ImageDto(imageUrl = imageUrl)
