plugins {
    id("android.library")
    id("koin")
}

android {
    namespace = "com.tapptitude.template.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
