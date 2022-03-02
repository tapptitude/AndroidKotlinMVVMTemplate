plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
    api(project(":config"))
    api(project(":network"))
    api(project(":imageLoading"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXLifecycleCommon)
    implementation(appLibs.kotlinXCoroutines)

    implementation(appLibs.bundles.koinBundle)
}