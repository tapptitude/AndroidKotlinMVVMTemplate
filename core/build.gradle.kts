plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    api(project(":config"))
    api(project(":network"))
    api(project(":imageLoading"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXLifecycleCommon)
    implementation(appLibs.kotlinXCoroutines)

    implementation(appLibs.bundles.koinBundle)
}