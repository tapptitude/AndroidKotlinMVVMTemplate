plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.core"
}

dependencies {
    api(project(":network"))
    api(project(":persistence"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}
