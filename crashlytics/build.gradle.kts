plugins {
    id("android.library")
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.tapptitude.crashlytics"
}

dependencies {
    implementation(project(":config"))

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
}
