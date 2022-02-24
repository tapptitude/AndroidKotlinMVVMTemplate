import library.extension.addAndroidAndTestDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    compileSdk = configuration.Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = configuration.Android.APPLICATION_ID
        minSdk = configuration.Android.MIN_SDK_VERSION
        targetSdk = configuration.Android.TARGET_SDK_VERSION
        versionCode = configuration.Android.VERSION_CODE
        versionName = configuration.Android.VERSION_NAME

        testInstrumentationRunner = configuration.Android.TEST_RUNNER
    }

    buildFeatures {
        viewBinding = configuration.Android.VIEW_BINDING_ENABLED
        dataBinding = configuration.Android.DATA_BINDING_ENABLED
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
        targetCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
    }

    kotlinOptions {
        jvmTarget = configuration.Android.KOTLIN_LANGUAGE_LEVEL
    }
}

dependencies {
    implementation(project(":network"))

    implementation(library.Dependencies.ANDROIDX_CORE_KTX)
    implementation(library.Dependencies.ANDROIDX_APP_COMPAT)
    implementation(library.Dependencies.GOOGLE_MATERIAL)
    implementation(library.Dependencies.KOIN_ANDROID)
    implementation(library.Dependencies.KOIN_CORE)

    addAndroidAndTestDependencies()
}