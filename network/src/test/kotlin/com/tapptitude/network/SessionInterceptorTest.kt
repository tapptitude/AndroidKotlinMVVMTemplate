package com.tapptitude.network

import com.tapptitude.network.fake.FakeSessionManager
import com.tapptitude.network.fake.IgnoredCallback
import com.tapptitude.network.interceptor.SessionInterceptor
import com.tapptitude.session.SessionManager
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Underneath, Retrofit2 uses OkHttp for requests.
 *
 * Thus, if we want to test an interceptor, it is enough to use a OkHttp object.
 * No need to create an instance of retrofit
 */
internal class SessionInterceptorTest {
    private lateinit var interceptor: SessionInterceptor
    private lateinit var sessionManager: SessionManager
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun `before each test, do a fresh set up`() {
        sessionManager = FakeSessionManager()
        interceptor = SessionInterceptor(sessionManager)
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @After
    fun `after each test, clean up the resource`() {
        mockWebServer.shutdown()
    }

    @Test
    fun `assert when logged in the authorization header is set`() {
        val mockUserId = "mocked_user_id"
        val mockedAccessToken = "mocked_access_token"

        // we logged in the user
        sessionManager.onLoggedIn(accessToken = mockedAccessToken, userId = mockUserId)

        val request = Request.Builder()
            .url(mockWebServer.url("test"))
            .get()
            .build()

        okHttpClient.newCall(request).enqueue(IgnoredCallback)

        val receivedRequest = mockWebServer.takeRequest()

        assertTrue(
            "The Authorization token is not present!",
            receivedRequest.headers.contains(
                SessionInterceptor.HEADER_AUTHORIZATION to mockedAccessToken
            )
        )
    }

    @Test
    fun `assert when logged out the authorization header is NOT set`() {
        sessionManager.onLoggedOut(null)

        val request = Request.Builder()
            .url(mockWebServer.url("test"))
            .get()
            .build()

        okHttpClient.newCall(request).enqueue(IgnoredCallback)

        val receivedRequest = mockWebServer.takeRequest()

        assertFalse(
            "The authorization token should not be set",
            receivedRequest.headers.any { it.first == SessionInterceptor.HEADER_AUTHORIZATION }
        )
    }
}
