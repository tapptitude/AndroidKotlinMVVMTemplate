package com.tapptitude.network

import com.tapptitude.network.fake.FakeSessionManager
import com.tapptitude.network.interceptor.SessionInterceptor
import com.tapptitude.session.SessionManager
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Before
import org.junit.Test

internal class SessionInterceptorTest {
    private var interceptor: SessionInterceptor? = null
    private var sessionManager: SessionManager? = null
    private var okHttpClient: OkHttpClient? = null

    @Before
    fun `before each test, create a new instance of SessionInterceptor`() {
        sessionManager = FakeSessionManager()
        interceptor = SessionInterceptor(sessionManager!!)
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor!!)
            .build()
    }

    @Test
    fun `assert when logged out no authorization is set`() {
        val sessionManager = requireNotNull(this.sessionManager)
        val interceptor = requireNotNull(this.interceptor)
        val client = requireNotNull(okHttpClient)

        val mockUserId = "mocked_user_id"
        val mockedAccessToken = "mocked_access_token"
        sessionManager.onLoggedIn(accessToken = mockedAccessToken, userId = mockUserId)

        assert(client.interceptors.any { it is SessionInterceptor }) {
            "No SessionInterceptor present."
        }


        val request = Request.Builder()
            .url("https://localhost:1010/")
            .build()

        val response = client.newCall(request)
    }
}
