plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.foundation.ui"
}

dependencies {
    implementation(appLibs.googleMaterial)
}
