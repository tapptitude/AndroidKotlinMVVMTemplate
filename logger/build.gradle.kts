plugins {
    id("android.library")
    id("koin")
}

android {
    namespace = "com.tapptitude.template.logger"
}

dependencies {
    implementation(project(":config"))
    implementation(project(":crashlytics"))

    implementation(libs.timber)
}
