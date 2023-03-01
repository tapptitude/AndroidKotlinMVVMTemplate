package com.tapptitude.session.di

import com.tapptitude.session.SessionManager
import com.tapptitude.session.SessionManagerImpl
import com.tapptitude.session.storage.LocalSessionDataManager
import org.koin.dsl.module

val sessionModule = module {
    single<SessionManager> { SessionManagerImpl(localSessionDataManager = get()) }

    factory { LocalSessionDataManager(appContext = get()) }
}
