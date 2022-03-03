plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(project(":config"))

    implementation(appLibs.timber)
    implementation(appLibs.bundles.koinBundle)
}
