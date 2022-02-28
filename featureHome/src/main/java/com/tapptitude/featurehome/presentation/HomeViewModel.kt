package com.tapptitude.featurehome.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapptitude.core.model.Image
import com.tapptitude.core.usecase.LoadImageUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val loadImageUseCase: LoadImageUseCase) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _imageData = MutableLiveData<Image>()
    val imageData: LiveData<Image> = _imageData

    fun loadRandomImage() {
        _isLoading.value = true

        viewModelScope.launch {
            _imageData.value = loadImageUseCase.invoke()
            _isLoading.value = false
        }
    }
}