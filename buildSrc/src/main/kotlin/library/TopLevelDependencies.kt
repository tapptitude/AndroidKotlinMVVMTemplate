package library

object TopLevelDependencies {
    const val ANDROID_TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:${Versions.ANDROID_TOOLS_BUILD_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}"
    const val NAVIGATION_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.Versions.ANDROIDX_NAVIGATION}"

    object Versions {
        const val ANDROID_TOOLS_BUILD_GRADLE = "7.1.2"
        const val KOTLIN_GRADLE_PLUGIN = "1.6.10"
    }
}
