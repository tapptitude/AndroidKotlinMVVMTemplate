plugins {
    id("android.feature")
}

android {
    namespace = "com.tapptitude.feature.home"
}

dependencies {
    implementation(project(":common"))
}
