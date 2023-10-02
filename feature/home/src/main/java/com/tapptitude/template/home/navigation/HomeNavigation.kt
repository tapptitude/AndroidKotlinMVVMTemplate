package com.tapptitude.template.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.tapptitude.template.home.presentation.HomeRoute

const val HomeRoute = "home"

fun NavController.navigateHome(navOptions: NavOptions? = null) {
    navigate(HomeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = HomeRoute) {
        HomeRoute()
    }
}
