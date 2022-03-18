package com.tapptitude.session.di

import com.tapptitude.session.SessionManager
import com.tapptitude.session.SessionManagerImpl
import com.tapptitude.session.storage.LocalSessionDataManager
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.dsl.module

@DelicateCoroutinesApi
val sessionModule = module {
    single<SessionManager> { SessionManagerImpl() }

    factory { LocalSessionDataManager(appContext = get()) }
}