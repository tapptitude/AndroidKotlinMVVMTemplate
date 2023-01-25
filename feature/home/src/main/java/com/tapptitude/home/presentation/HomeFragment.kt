package com.tapptitude.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.tapptitude.config.AppConfig
import com.tapptitude.core.util.viewBinding
import com.tapptitude.home.R
import com.tapptitude.home.databinding.FragmentHomeBinding
import com.tapptitude.imageloading.ImageLoader
import com.tapptitude.session.model.LoggedIn
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModel<HomeViewModel>()
    private val imageLoader by inject<ImageLoader>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpContent()
        setUpActions()
        setUpObservers()

        viewModel.loadRandomImage()
    }

    private fun setUpContent() {
        binding.titleTV.text = getString(R.string.title_including_flavor_format, AppConfig.FLAVOR)
    }

    private fun setUpActions() {
        binding.loginStateBtn.setOnClickListener {
            viewModel.toggleLoginMode()
        }
    }

    private fun setUpObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            binding.loadingPB.isVisible = loading
        }

        viewModel.imageData.observe(viewLifecycleOwner) { imageData ->
            imageLoader.loadImage(
                imageView = binding.photoIV,
                urlToLoad = imageData.imageUrl,
                crossFadeAnimation = true
            )
        }

        viewModel.loginState.observe(viewLifecycleOwner) { loginState ->
            if (loginState is LoggedIn) {
                binding.loginStateBtn.setText(R.string.action_logout)
                binding.loginStateLabelTV.text = getString(R.string.status_logged_in_x, loginState.userId)
            } else {
                binding.loginStateBtn.setText(R.string.action_login)
                binding.loginStateLabelTV.text = getString(R.string.status_logged_out)
            }
        }
    }
}
