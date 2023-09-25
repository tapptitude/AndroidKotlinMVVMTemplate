package com.tapptitude.template

import android.app.Application
import com.tapptitude.template.common.di.commonModule
import com.tapptitude.template.core.di.coreModule
import com.tapptitude.template.crashlytics.di.crashlyticsModule
import com.tapptitude.template.home.di.homeModules
import com.tapptitude.template.logger.di.loggerModule
import com.tapptitude.template.network.di.networkModule
import com.tapptitude.template.persistence.di.databaseModule
import com.tapptitude.template.session.di.sessionModule
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
                commonModule,
            )
        }
    }
}
