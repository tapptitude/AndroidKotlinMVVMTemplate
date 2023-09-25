plugins {
    id("android.library")
    id("koin")
}

android {
    namespace = "com.tapptitude.template.core"
}

dependencies {
    api(project(":network"))
    api(project(":persistence"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
}
