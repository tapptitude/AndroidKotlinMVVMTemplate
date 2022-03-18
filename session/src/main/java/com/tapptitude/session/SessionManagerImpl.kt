package com.tapptitude.session

import com.tapptitude.session.model.LoggedIn
import com.tapptitude.session.model.LoggedOut
import com.tapptitude.session.model.LoginState
import com.tapptitude.session.storage.LocalSessionDataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SessionManagerImpl : SessionManager, KoinComponent {
    private val localSessionDataManager: LocalSessionDataManager by inject()
    private val localScope = CoroutineScope(Dispatchers.IO)

    override val currentLoginStateFlow = MutableStateFlow<LoginState>(LoggedOut(null))

    init {
        loadSavedLoginState()
    }

    override fun onLoggedIn(accessToken: String, userId: String) {
        val loggedInState = LoggedIn(accessToken, userId)
        currentLoginStateFlow.value = loggedInState

        localScope.launch(Dispatchers.IO) {
            localSessionDataManager.updateLoginState(loggedInState)
        }
    }

    override fun onLoggedOut(lastUserId: String) {
        val loggedOutState = LoggedOut(lastUserId)
        currentLoginStateFlow.value = loggedOutState

        localScope.launch(Dispatchers.IO) {
            localSessionDataManager.updateLoginState(loggedOutState)
        }
    }

    private fun loadSavedLoginState() {
        localScope.launch(Dispatchers.IO) {
            currentLoginStateFlow.value = localSessionDataManager.loadLoginState()
        }
    }
}