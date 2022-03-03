plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = configuration.Android.APPLICATION_ID
        versionCode = configuration.Android.VERSION_CODE
        versionName = configuration.Android.VERSION_NAME
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":featureHome"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXAppCompat)
    implementation(appLibs.googleMaterial)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.bundles.androidXNavigationBundle)

    implementation(testLibs.bundles.testBundle)
    implementation(androidTestLibs.bundles.androidTestBundle)
}