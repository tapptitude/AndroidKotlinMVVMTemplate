plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.core"
}

dependencies {
    api(project(":network"))
    api(project(":persistence"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXLifecycleCommon)
    implementation(appLibs.kotlinXCoroutines)

    implementation(appLibs.bundles.koinBundle)
}
