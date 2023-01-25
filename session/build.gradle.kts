plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.session"
}

dependencies {
    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXDatastore)
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.bundles.koinBundle)
}
