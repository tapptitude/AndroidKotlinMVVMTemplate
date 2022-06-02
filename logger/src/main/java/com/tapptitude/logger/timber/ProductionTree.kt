package com.tapptitude.logger.timber

import android.util.Log
import com.tapptitude.crashlytics.firebase.CrashlyticsFirebase
import timber.log.Timber

class ProductionTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO || priority == Log.WARN) return

        // Log to Crashlytics
        CrashlyticsFirebase().addLog(message)
    }
}