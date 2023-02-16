plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.common"
}

dependencies {
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.bundles.koinBundle)
}