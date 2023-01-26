plugins {
    id("android.library")
    id(libs.plugins.firebase.crashlytics.get().pluginId)
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
