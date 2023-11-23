package com.tapptitude.template.logger.timber

import android.util.Log
import com.tapptitude.template.crashlytics.firebase.CrashlyticsFirebase
import timber.log.Timber

class ProductionTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?,
    ) {
        when (priority) {
            Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN -> return
            // Log to Crashlytics
            else -> CrashlyticsFirebase().addLog(message)
        }
    }
}
