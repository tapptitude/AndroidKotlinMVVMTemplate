package com.tapptitude.template

import android.app.Application
import com.tapptitude.core.di.coreModule
import com.tapptitude.featurehome.di.homeModules
import com.tapptitude.imageloading.di.imageLoaderModule
import com.tapptitude.network.di.networkModule
import org.koin.core.context.startKoin

class ApplicationImpl : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                networkModule,
                coreModule,
                homeModules,
                imageLoaderModule
            )
        }
    }
}