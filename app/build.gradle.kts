plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

apply<plugin.AddFlavorsPlugin>()

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
    implementation(project(":featureHome"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXAppCompat)
    implementation(appLibs.googleMaterial)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.bundles.androidXNavigationBundle)

    implementation(testLibs.bundles.testBundle)
    implementation(androidTestLibs.bundles.androidTestBundle)
}