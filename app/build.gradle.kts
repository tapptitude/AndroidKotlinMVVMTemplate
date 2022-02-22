import dependencies.Dependencies
import dependencies.extensions.addAndroidAndTestDependencies
import configuration.Android

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Android.APPLICATION_ID
        minSdk = Android.MIN_SDK_VERSION
        targetSdk = Android.TARGET_SDK_VERSION
        versionCode = Android.VERSION_CODE
        versionName = Android.VERSION_NAME

        testInstrumentationRunner = Android.TEST_RUNNER
    }

    buildFeatures {
        viewBinding = Android.VIEW_BINDING_ENABLED
        dataBinding = Android.DATA_BINDING_ENABLED
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.ANDROIDX_CORE_KTX)
    implementation(Dependencies.ANDROIDX_APP_COMPAT)
    implementation(Dependencies.GOOGLE_MATERIAL)

    addAndroidAndTestDependencies()
}