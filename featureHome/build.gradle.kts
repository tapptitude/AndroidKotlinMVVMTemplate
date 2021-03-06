plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    api(project(":core"))
    api(project(":imageLoading"))
    api(project(":logger"))
    api(project(":session"))
    api(project(":config"))
    implementation(project(":uiCommon"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXAppCompat)
    implementation(appLibs.androidXConstraintLayout)
    implementation(appLibs.androidXLifecycleViewModel)
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.bundles.androidXLifecycleBundle)
    implementation(appLibs.bundles.androidXNavigationBundle)
    implementation(appLibs.bundles.koinBundle)
}