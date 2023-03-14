package com.tapptitude.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tapptitude.home.presentation.HomeRoute

const val homeRoute = "home"

fun NavController.navigateHome(navOptions: NavOptions? = null) {
    navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = homeRoute) {
        HomeRoute()
    }
}
