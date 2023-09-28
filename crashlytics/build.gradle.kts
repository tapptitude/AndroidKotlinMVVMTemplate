plugins {
    id("android.library")
    id("koin")
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.tapptitude.template.crashlytics"
}

dependencies {
    implementation(project(":config"))

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
}
