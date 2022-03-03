plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

dependencies {
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.glide)
    kapt(appLibs.glideKapt)
}