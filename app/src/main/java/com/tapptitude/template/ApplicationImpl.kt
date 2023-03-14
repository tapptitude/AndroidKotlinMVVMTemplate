package com.tapptitude.template

import android.app.Application
import com.tapptitude.common.di.commonModule
import com.tapptitude.core.di.coreModule
import com.tapptitude.crashlytics.di.crashlyticsModule
import com.tapptitude.home.di.homeModules
import com.tapptitude.logger.di.loggerModule
import com.tapptitude.network.di.networkModule
import com.tapptitude.persistence.di.databaseModule
import com.tapptitude.session.di.sessionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationImpl : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@ApplicationImpl)

            modules(
                networkModule,
                coreModule,
                homeModules,
                loggerModule,
                sessionModule,
                crashlyticsModule,
                databaseModule,
                commonModule
            )
        }
    }
}
