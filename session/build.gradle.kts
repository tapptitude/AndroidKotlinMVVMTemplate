plugins {
    id("android.library")
    id("koin")
}

android {
    namespace = "com.tapptitude.template.session"
}

dependencies {
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.dataStore.preferences)
    implementation(libs.kotlinx.coroutines.android)
}
