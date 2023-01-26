plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.feature.home"
}

dependencies {
    api(project(":core"))
    api(project(":imageLoading"))
    api(project(":logger"))
    api(project(":session"))
    api(project(":config"))
    api(project(":foundation:ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.core)
    implementation(libs.koin.android)

//    implementation(appLibs.androidXCoreKtx)
//    implementation(appLibs.androidXAppCompat)
//    implementation(appLibs.androidXConstraintLayout)
//    implementation(appLibs.androidXLifecycleViewModel)
//    implementation(appLibs.kotlinXCoroutines)
//    implementation(appLibs.bundles.androidXLifecycleBundle)
//    implementation(appLibs.bundles.androidXNavigationBundle)
//    implementation(appLibs.bundles.koinBundle)
}
