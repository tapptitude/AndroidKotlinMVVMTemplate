package com.tapptitude.session.model

sealed class LoginState

class LoggedIn(
    val sessionToken: String,
    val userId: String
) : LoginState()

class LoggedOut(
    val lastUserId: String? = null
) : LoginState()
