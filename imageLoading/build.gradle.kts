plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.imageloading"
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}
