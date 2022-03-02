plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
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

    compileOptions {
        sourceCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
        targetCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
    }

    kotlinOptions {
        jvmTarget = configuration.Android.KOTLIN_LANGUAGE_LEVEL
    }
}

dependencies {
    implementation(project(":config"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.bundles.okhttpBundle)
    implementation(appLibs.bundles.retrofitBundle)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.kotlinXCoroutines)
    implementation(appLibs.moshi)
    kapt(appLibs.moshiKapt)
}