plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":config"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.bundles.okhttpBundle)
    implementation(appLibs.bundles.retrofitBundle)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.moshi)
    kapt(appLibs.moshiKapt)
}