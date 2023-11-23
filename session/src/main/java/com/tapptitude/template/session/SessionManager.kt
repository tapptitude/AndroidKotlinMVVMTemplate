package com.tapptitude.template.session

import com.tapptitude.template.session.model.LoginState
import kotlinx.coroutines.flow.StateFlow

interface SessionManager {
    val currentLoginStateFlow: StateFlow<LoginState>

    fun onLoggedIn(accessToken: String, userId: String)
    fun onLoggedOut(lastUserId: String?)
}
