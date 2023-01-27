package com.tapptitude.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapptitude.core.model.Image
import com.tapptitude.core.usecase.LoadImageUseCase
import com.tapptitude.session.SessionManager
import com.tapptitude.session.model.LoggedIn
import com.tapptitude.session.model.LoggedOut
import com.tapptitude.session.model.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val loadImageUseCase: LoadImageUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isLoading = false, loginState = LoggedOut(), image = null))
    val state: StateFlow<HomeState>
        get() = _state

    init {
        loadRandomImage()
        observeSessionStateChanges()
    }

    private fun loadRandomImage() {
        _state.update { _state.value.copy(isLoading = true) }

        viewModelScope.launch {
            val image = loadImageUseCase.invoke()
            _state.update { _state.value.copy(isLoading = false, image = image) }
        }
    }

    fun toggleLoginMode() {
        val currentLoginState = _state.value.loginState

        if (currentLoginState is LoggedIn) {
            doLogout()
        } else {
            doLogin()
        }
    }

    private fun doLogin() {
        val randomId = (System.currentTimeMillis() % 10000).toString()
        sessionManager.onLoggedIn("SampleToken", "userId$randomId")
    }

    private fun doLogout() {
        val loggedInState = sessionManager.currentLoginStateFlow.value as? LoggedIn
        sessionManager.onLoggedOut(loggedInState?.userId)
    }

    private fun observeSessionStateChanges() {
        viewModelScope.launch(Dispatchers.IO) {
            sessionManager.currentLoginStateFlow.collect { loginState ->
                _state.update { _state.value.copy(loginState = loginState) }
            }
        }
    }
}
