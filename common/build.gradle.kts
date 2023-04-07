plugins {
    id("android.library")
}

android {
    namespace = "com.tapptitude.template.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}
