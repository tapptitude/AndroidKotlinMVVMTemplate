package com.tapptitude.template.crashlytics.di

import com.tapptitude.template.crashlytics.Crashlytics
import com.tapptitude.template.crashlytics.firebase.CrashlyticsFirebase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val crashlyticsModule =
    module {
        singleOf(::CrashlyticsFirebase) { bind<Crashlytics>() }
    }
