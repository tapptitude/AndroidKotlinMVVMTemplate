package com.tapptitude.template.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import com.tapptitude.template.R
import com.tapptitude.ui.theme.AppTheme

class HostActivity : AppCompatActivity() {
    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme {

            }
        }
        navigateHome()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController.handleDeepLink(intent)
    }

    private fun navigateHome() {
        val request = NavDeepLinkRequest.Builder
            .fromUri(DESTINATION_HOME.toUri())
            .build()

        navController.navigate(request)
    }

    private fun findNavController(): NavController {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentHostFCV) as? NavHostFragment

        return navHostFragment?.navController ?: throw RuntimeException("NavController not available")
    }

    companion object {
        private const val DESTINATION_HOME = "tapptitude-app://content/home"
    }
}
