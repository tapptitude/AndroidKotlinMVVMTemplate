package com.tapptitude.logger.timber

import com.tapptitude.config.AppConfig
import com.tapptitude.logger.Logger
import timber.log.Timber

class TimberLogger : Logger {
    init {
        initTimberLogger()
    }

    override fun logV(message: String, vararg params: Any?) {
        Timber.v(message, params)
    }

    override fun logV(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.v(throwable, message, params)
    }

    override fun logD(message: String, vararg params: Any?) {
        Timber.d(message, params)
    }

    override fun logD(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.d(throwable, message, params)
    }

    override fun logI(message: String, vararg params: Any?) {
        Timber.i(message, params)
    }

    override fun logI(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.i(throwable, message, params)
    }

    override fun logW(message: String, vararg params: Any?) {
        Timber.w(message, params)
    }

    override fun logW(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.w(throwable, message, params)
    }

    override fun logA(message: String, vararg params: Any?) {
        Timber.e(message, params)
    }

    override fun logA(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.e(throwable, message, params)
    }

    override fun logE(message: String, vararg params: Any?) {
        Timber.e(message, params)
    }

    override fun logE(throwable: Throwable, message: String, vararg params: Any?) {
        Timber.e(throwable, message, params)
    }

    private fun initTimberLogger() {
        if (AppConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ProductionTree())
        }
    }
}