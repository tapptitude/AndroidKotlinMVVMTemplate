plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.template.logger"
}

dependencies {
    implementation(project(":config"))
    implementation(project(":crashlytics"))

    implementation(libs.timber)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}
