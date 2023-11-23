package com.tapptitude.template.logger

@Suppress("TooManyFunctions")
interface Logger {
    fun logV(
        message: String,
        vararg params: Any?,
    )

    fun logV(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )

    fun logD(
        message: String,
        vararg params: Any?,
    )

    fun logD(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )

    fun logI(
        message: String,
        vararg params: Any?,
    )

    fun logI(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )

    fun logW(
        message: String,
        vararg params: Any?,
    )

    fun logW(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )

    fun logA(
        message: String,
        vararg params: Any?,
    )

    fun logA(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )

    fun logE(
        message: String,
        vararg params: Any?,
    )

    fun logE(
        throwable: Throwable,
        message: String,
        vararg params: Any?,
    )
}
