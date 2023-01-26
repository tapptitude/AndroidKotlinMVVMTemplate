plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.logger"
}

dependencies {
    implementation(project(":config"))
    implementation(project(":crashlytics"))

    implementation(libs.timber)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}
