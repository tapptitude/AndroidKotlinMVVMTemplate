package com.tapptitude.network.fake

import com.tapptitude.session.SessionManager
import com.tapptitude.session.model.LoggedIn
import com.tapptitude.session.model.LoggedOut
import com.tapptitude.session.model.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class FakeSessionManager : SessionManager {
    private val _currentLoginStateFlow: MutableStateFlow<LoginState> = MutableStateFlow(
        LoggedOut("")
    )

    override val currentLoginStateFlow: StateFlow<LoginState>
        get() = _currentLoginStateFlow

    override fun onLoggedIn(accessToken: String, userId: String) {
        _currentLoginStateFlow.value = LoggedIn(
            sessionToken = accessToken,
            userId = userId
        )
    }

    override fun onLoggedOut(lastUserId: String?) {
        _currentLoginStateFlow.value = LoggedOut(
            null
        )
    }
}