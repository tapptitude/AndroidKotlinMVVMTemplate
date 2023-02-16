plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    api(project(":network"))
    api(project(":persistence"))
    implementation(project(":common"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXLifecycleCommon)
    implementation(appLibs.kotlinXCoroutines)

    implementation(appLibs.bundles.koinBundle)
}