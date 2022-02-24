package com.tapptitude.template

import android.app.Application
import com.tapptitude.network.di.networkModule
import org.koin.core.context.startKoin

class ApplicationImpl : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(networkModule)
        }
    }
}