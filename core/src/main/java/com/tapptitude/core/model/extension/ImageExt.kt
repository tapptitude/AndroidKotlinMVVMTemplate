package com.tapptitude.core.model.extension

import com.tapptitude.core.model.Image
import com.tapptitude.network.dto.ImageDto

fun ImageDto.toImage() = Image(imageUrl = imageUrl ?: "")

fun Image.toImageDto() = ImageDto(imageUrl = imageUrl)