package com.tapptitude.template.core.model.extension

import com.tapptitude.template.core.model.Image
import com.tapptitude.template.network.dto.ImageDto
import com.tapptitude.template.persistence.images.ImageEntity

internal fun ImageDto.toEntity() = ImageEntity(url = imageUrl.orEmpty())

internal fun ImageEntity.toImage() = Image(imageUrl = url)

internal fun Image.toImageDto() = ImageDto(imageUrl = imageUrl)
