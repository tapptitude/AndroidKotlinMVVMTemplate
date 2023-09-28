plugins {
    id("android.library")
    id("koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.tapptitude.template.network"
}

dependencies {
    implementation(project(":config"))
    implementation(project(":session"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi.converter)
    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.kotlin.codegen)
}
