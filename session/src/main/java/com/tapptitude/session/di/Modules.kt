package com.tapptitude.session.di

import com.tapptitude.session.SessionManager
import com.tapptitude.session.SessionManagerImpl
import com.tapptitude.session.storage.LocalSessionDataManager
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sessionModule = module {
    singleOf(::SessionManagerImpl) { bind<SessionManager>() }
    factoryOf(::LocalSessionDataManager)
}
