plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXDatastore)
    implementation(appLibs.bundles.koinBundle)
}