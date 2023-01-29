package com.tapptitude.network.fake

import java.io.IOException
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

/**
 * An empty [Callback] to be used in testing.
 * Does nothing.
 */
internal object IgnoredCallback : Callback {
    override fun onFailure(call: Call, e: IOException) = Unit
    override fun onResponse(call: Call, response: Response) = Unit
}