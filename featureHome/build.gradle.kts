plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

apply<plugin.AddFlavorsPlugin>()

android {
    compileSdk = configuration.Android.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = configuration.Android.MIN_SDK_VERSION
        targetSdk = configuration.Android.TARGET_SDK_VERSION

        testInstrumentationRunner = configuration.Android.TEST_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = configuration.Android.VIEW_BINDING_ENABLED
        dataBinding = configuration.Android.DATA_BINDING_ENABLED
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
    api(project(":core"))
    api(project(":imageLoading"))
    api(project(":logger"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXAppCompat)
    implementation(appLibs.androidXConstraintLayout)
    implementation(appLibs.androidXLifecycleViewModel)
    implementation(appLibs.bundles.androidXLifecycleBundle)
    implementation(appLibs.bundles.androidXNavigationBundle)
    implementation(appLibs.bundles.koinBundle)
}