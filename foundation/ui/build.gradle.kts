plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.foundation.ui"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    val composeBom = platform(appLibs.androidXComposeBom)
    implementation(composeBom)
    implementation(appLibs.androidXComposeAnimation)
    implementation(appLibs.androidXComposeFoundation)
    implementation(appLibs.androidXComposeMaterial3)
    implementation(appLibs.androidXComposeRuntime)
    implementation(appLibs.androidXComposeUi)
}
