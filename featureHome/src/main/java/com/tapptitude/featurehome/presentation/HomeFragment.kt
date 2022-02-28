package com.tapptitude.featurehome.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.tapptitude.config.AppConfig
import com.tapptitude.core.util.viewBinding
import com.tapptitude.featurehome.R
import com.tapptitude.featurehome.databinding.FragmentHomeBinding
import com.tapptitude.imageloading.ImageLoader
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
        setUpObservers()

        viewModel.loadRandomImage()
    }

    private fun setUpContent() {
        binding.titleTV.text = getString(R.string.title_including_flavor_format, AppConfig.FLAVOR)
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
    }
}