package com.tapptitude.template.session.di

import com.tapptitude.template.session.SessionManager
import com.tapptitude.template.session.SessionManagerImpl
import com.tapptitude.template.session.storage.LocalSessionDataManager
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sessionModule =
    module {
        singleOf(::SessionManagerImpl) { bind<SessionManager>() }
        factoryOf(::LocalSessionDataManager)
    }
