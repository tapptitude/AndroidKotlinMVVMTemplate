package configuration

import org.gradle.api.JavaVersion

object Android {
    const val APPLICATION_ID = "com.tapptitude.template"

    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val VIEW_BINDING_ENABLED = true
    const val DATA_BINDING_ENABLED = false

    const val KOTLIN_LANGUAGE_LEVEL = "11"
    val JAVA_LANGUAGE_LEVEL = JavaVersion.VERSION_11
}
