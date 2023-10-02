package com.tapptitude.template.home.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.tapptitude.template.config.BuildConfig
import com.tapptitude.template.core.model.Image
import com.tapptitude.template.feature.home.R
import com.tapptitude.template.session.model.LoggedIn
import com.tapptitude.template.session.model.LoggedOut
import com.tapptitude.template.session.model.LoginState
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        isLoading = state.isLoading,
        image = state.image,
        loginState = state.loginState,
        onButtonClick = viewModel::toggleLoginMode,
        modifier = modifier,
    )
}

@Composable
internal fun HomeScreen(
    isLoading: Boolean,
    image: Image?,
    loginState: LoginState,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (!isLoading) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp),
        ) {
            Text(
                text = stringResource(R.string.title_including_flavor_format, BuildConfig.FLAVOR),
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.size(16.dp))
            AsyncImage(
                model = image?.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = onButtonClick,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                val btnStringId = when (loginState) {
                    is LoggedIn -> R.string.action_logout
                    is LoggedOut -> R.string.action_login
                }
                Text(text = stringResource(btnStringId))
            }
            Spacer(modifier = Modifier.size(16.dp))
            val loginStatus = when (loginState) {
                is LoggedIn -> stringResource(R.string.status_logged_in_x, loginState.userId)
                is LoggedOut -> stringResource(R.string.status_logged_out)
            }
            Text(
                text = loginStatus,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
    AnimatedVisibility(
        visible = isLoading,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> -fullHeight },
        ) + fadeIn(),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> -fullHeight },
        ) + fadeOut(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
