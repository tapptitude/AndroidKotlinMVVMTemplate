package com.tapptitude.template.home.presentation

import com.tapptitude.template.core.model.Image
import com.tapptitude.template.session.model.LoginState

data class HomeState(
    val isLoading: Boolean,
    val loginState: LoginState,
    val image: Image?
)
