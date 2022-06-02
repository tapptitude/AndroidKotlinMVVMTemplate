package com.tapptitude.imageloading

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class GlideImageLoader : ImageLoader {
    @SuppressLint("CheckResult")
    override fun loadImage(
        imageView: ImageView,
        urlToLoad: String,
        crossFadeAnimation: Boolean?,
        placeholderResId: Int?,
        errorResId: Int?
    ) {
        Glide.with(imageView)
            .load(urlToLoad)
            .apply {
                if (placeholderResId != null && placeholderResId != ResourcesCompat.ID_NULL) {
                    placeholder(placeholderResId)
                }

                if (errorResId != null && errorResId != ResourcesCompat.ID_NULL) {
                    error(errorResId)
                }

                if (crossFadeAnimation == true) {
                    transition(DrawableTransitionOptions.withCrossFade())
                }
            }
            .into(imageView)
    }
}