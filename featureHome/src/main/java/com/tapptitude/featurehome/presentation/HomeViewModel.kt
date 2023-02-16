package com.tapptitude.featurehome.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapptitude.common.dispatcherProvider.DispatcherProvider
import com.tapptitude.core.model.Image
import com.tapptitude.core.usecase.LoadImageUseCase
import com.tapptitude.session.SessionManager
import com.tapptitude.session.model.LoggedIn
import com.tapptitude.session.model.LoginState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dispatcherProvider: DispatcherProvider,
    private val loadImageUseCase: LoadImageUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _imageData = MutableLiveData<Image>()
    val imageData: LiveData<Image> = _imageData

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    init {
        observeSessionStateChanges()
    }

    fun loadRandomImage() {
        _isLoading.value = true

        viewModelScope.launch(dispatcherProvider.main) {
            _imageData.value = loadImageUseCase.invoke()
            _isLoading.value = false
        }
    }

    fun toggleLoginMode() {
        val currentLoginState = loginState.value

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
        viewModelScope.launch(dispatcherProvider.io) {
            sessionManager.currentLoginStateFlow.collect { loginState ->
                _loginState.postValue(loginState)
            }
        }
    }
}