plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.imageloading"
}

dependencies {
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.glide)
}
