plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.logger"
}

dependencies {
    implementation(project(":config"))
    implementation(project(":crashlytics"))

    implementation(appLibs.timber)
    implementation(appLibs.bundles.koinBundle)
}
