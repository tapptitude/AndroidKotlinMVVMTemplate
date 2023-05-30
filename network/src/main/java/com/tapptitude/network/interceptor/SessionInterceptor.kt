package com.tapptitude.network.interceptor

import com.tapptitude.session.SessionManager
import com.tapptitude.session.model.LoggedIn
import okhttp3.Interceptor
import okhttp3.Response

internal class SessionInterceptor(private val sessionManager: SessionManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentLoginState = sessionManager.currentLoginStateFlow.value

        if (currentLoginState is LoggedIn) {
            val newRequest = chain.request().newBuilder()
                .addHeader(HEADER_AUTHORIZATION, currentLoginState.sessionToken)
                .build()

            return chain.proceed(newRequest)
        }

        return chain.proceed(chain.request())
    }

    companion object {
        private const val HEADER_AUTHORIZATION = "Authorization"
    }
}
