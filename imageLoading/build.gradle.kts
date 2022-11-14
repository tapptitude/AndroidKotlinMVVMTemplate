plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.glide)
}
