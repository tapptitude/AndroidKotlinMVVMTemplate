package com.tapptitude.session

import com.tapptitude.session.model.LoginState
import kotlinx.coroutines.flow.Flow

interface SessionManager {
    val currentLoginStateFlow: Flow<LoginState>

    fun onLoggedIn(accessToken: String, userId: String)
    fun onLoggedOut(lastUserId: String)
}