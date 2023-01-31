package com.tapptitude.featurehome.fake

import com.tapptitude.core.model.Image
import com.tapptitude.core.repository.ImageRepository
import kotlinx.coroutines.delay


internal class FakeImageRepository(
    var requestDelay: Long = 0,
    private val fakeImage: Image = Image("test_url"),
) : ImageRepository {

    override suspend fun getRandomImage(): Image {
        delay(requestDelay)
        return fakeImage
    }
}