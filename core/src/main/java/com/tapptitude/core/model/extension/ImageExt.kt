package com.tapptitude.core.model.extension

import com.tapptitude.core.model.Image
import com.tapptitude.network.dto.ImageDto
import com.tapptitude.persistence.images.ImageEntity

fun ImageDto.toEntity() = ImageEntity(url = imageUrl.orEmpty())

fun ImageEntity.toImage() = Image(imageUrl = url)

fun Image.toImageDto() = ImageDto(imageUrl = imageUrl)