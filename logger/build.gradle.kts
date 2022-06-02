plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(project(":config"))
    implementation(project(":crashlytics"))

    implementation(appLibs.timber)
    implementation(appLibs.bundles.koinBundle)
}
