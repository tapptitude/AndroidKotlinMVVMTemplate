package com.tapptitude.template.presentation

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tapptitude.template.home.navigation.HomeRoute
import com.tapptitude.template.home.navigation.homeScreen

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TemplateApp(modifier: Modifier = Modifier) {
    val appNavController = rememberNavController()
    Scaffold { padding ->
        Row(
            modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)),
        ) {
            NavHost(
                navController = appNavController,
                startDestination = HomeRoute,
            ) {
                homeScreen()
            }
        }
    }
}
