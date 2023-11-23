package com.tapptitude.template.crashlytics

import com.google.firebase.crashlytics.CustomKeysAndValues

interface Crashlytics {

    fun addLog(message: String)

    fun setKey(key: String, value: String)

    fun setKey(key: String, value: Float)

    fun setKey(key: String, value: Double)

    fun setKey(key: String, value: Boolean)

    fun setKey(key: String, value: Int)

    fun setKey(key: String, value: Long)

    fun setKeys(keyValuePairList: CustomKeysAndValues)

    fun submitCrash(throwable: Throwable)
}
