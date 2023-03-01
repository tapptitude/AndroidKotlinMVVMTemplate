package com.tapptitude.crashlytics.di

import com.tapptitude.crashlytics.Crashlytics
import com.tapptitude.crashlytics.firebase.CrashlyticsFirebase
import org.koin.dsl.module

val crashlyticsModule = module {
    single<Crashlytics> { CrashlyticsFirebase() }
}
