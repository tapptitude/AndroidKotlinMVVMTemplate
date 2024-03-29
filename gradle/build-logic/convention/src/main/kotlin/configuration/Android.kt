package configuration

import org.gradle.api.JavaVersion

object Android {
    const val APPLICATION_ID = "com.tapptitude.template"

    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 34
    const val COMPILE_SDK_VERSION = 34

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val KOTLIN_LANGUAGE_LEVEL = "17"
    const val KOTLIN_JVM_TOOLCHAIN_VERSION = 17
    val JAVA_LANGUAGE_LEVEL = JavaVersion.VERSION_17
}
