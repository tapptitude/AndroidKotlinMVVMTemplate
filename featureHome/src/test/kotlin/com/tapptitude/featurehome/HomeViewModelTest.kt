package com.tapptitude.featurehome

import com.tapptitude.core.usecase.LoadImageUseCase
import com.tapptitude.featurehome.fake.FAKE_IMAGE
import com.tapptitude.featurehome.fake.FakeImageRepository
import com.tapptitude.featurehome.fake.FakeSessionManager
import com.tapptitude.featurehome.presentation.HomeViewModel
import com.tapptitude.session.SessionManager
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class HomeViewModelTest {

    private val loadImageUsecase: LoadImageUseCase = LoadImageUseCase(
        imageRepository = FakeImageRepository(requestDelay = 0, fakeImage = FAKE_IMAGE)
    )
    private lateinit var fakeSessionManager: SessionManager
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        fakeSessionManager = FakeSessionManager()

        viewModel = HomeViewModel(
            loadImageUseCase = loadImageUsecase,
            sessionManager = fakeSessionManager,
        )
    }

    @After
    fun tearDown() = Unit

    @Test
    fun `initial state is not loading`() {
        assertEquals(
            false,
            viewModel.isLoading.value,
        )
    }

    @Test
    fun `assert no image is present at start`() {
        // We do not make any request. We shouldn't have any image
        assertEquals(
            null,
            viewModel.imageData.value,
        )
    }
}