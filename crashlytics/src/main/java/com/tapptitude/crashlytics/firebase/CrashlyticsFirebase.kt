package com.tapptitude.crashlytics.firebase

import com.google.firebase.crashlytics.CustomKeysAndValues
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tapptitude.crashlytics.Crashlytics

class CrashlyticsFirebase : Crashlytics {

    override fun setLog(message: String) {
        FirebaseCrashlytics.getInstance().log(message)
    }

    override fun setKey(key: String, value: String) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKey(key: String, value: Float) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKey(key: String, value: Double) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKey(key: String, value: Boolean) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKey(key: String, value: Int) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKey(key: String, value: Long) {
        FirebaseCrashlytics.getInstance().setCustomKey(key, value)
    }

    override fun setKeys(keyValuePairList: CustomKeysAndValues) {
        FirebaseCrashlytics.getInstance().setCustomKeys(keyValuePairList)
    }

}