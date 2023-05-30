package com.tapptitude.session

import com.tapptitude.common.dispatcherProvider.DispatcherProvider
import com.tapptitude.session.model.LoggedIn
import com.tapptitude.session.model.LoggedOut
import com.tapptitude.session.model.LoginState
import com.tapptitude.session.storage.LocalSessionDataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class SessionManagerImpl(
    dispatcherProvider: DispatcherProvider,
    private val localSessionDataManager: LocalSessionDataManager
) : SessionManager {
    override val currentLoginStateFlow = MutableStateFlow<LoginState>(LoggedOut(null))

    private val localScope = CoroutineScope(dispatcherProvider.io)

    init {
        loadSavedLoginState()
    }

    override fun onLoggedIn(accessToken: String, userId: String) {
        val loggedInState = LoggedIn(accessToken, userId)
        currentLoginStateFlow.value = loggedInState

        localScope.launch {
            localSessionDataManager.updateLoginState(loggedInState)
        }
    }

    override fun onLoggedOut(lastUserId: String?) {
        val loggedOutState = LoggedOut(lastUserId)
        currentLoginStateFlow.value = loggedOutState

        localScope.launch {
            localSessionDataManager.updateLoginState(loggedOutState)
        }
    }

    private fun loadSavedLoginState() {
        localScope.launch {
            currentLoginStateFlow.value = localSessionDataManager.loadLoginState()
        }
    }
}
