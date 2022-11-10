plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(appLibs.plugins.ksp)
}

dependencies {
    implementation(project(":config"))
    implementation(project(":session"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.bundles.okhttpBundle)
    implementation(appLibs.bundles.retrofitBundle)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.moshi)
    ksp(appLibs.moshiKsp)
}
