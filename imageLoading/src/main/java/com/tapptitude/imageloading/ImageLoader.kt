package com.tapptitude.imageloading

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface ImageLoader {
    fun loadImage(
        imageView: ImageView,
        urlToLoad: String,
        crossFadeAnimation: Boolean? = false,
        @DrawableRes placeholderResId: Int? = null,
        @DrawableRes errorResId: Int? = null
    )
}