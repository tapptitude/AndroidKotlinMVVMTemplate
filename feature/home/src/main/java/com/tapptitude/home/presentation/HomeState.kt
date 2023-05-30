package com.tapptitude.home.presentation

import com.tapptitude.core.model.Image
import com.tapptitude.session.model.LoginState

data class HomeState(
    val isLoading: Boolean,
    val loginState: LoginState,
    val image: Image?
)
