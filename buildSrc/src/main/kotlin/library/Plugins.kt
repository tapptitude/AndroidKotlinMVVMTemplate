package library

object Plugins {
    const val ANDROID_TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:${Versions.ANDROID_TOOLS_BUILD_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}"

    object Versions {
        const val ANDROID_TOOLS_BUILD_GRADLE = "7.1.2"
        const val KOTLIN_GRADLE_PLUGIN = "1.6.10"
    }
}
