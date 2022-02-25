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

    implementation(library.Dependencies.ANDROIDX_CORE_KTX)
    implementation(library.Dependencies.OKHTTP_LIBRARY)
    implementation(library.Dependencies.OKHTTP_INTERCEPTOR)
    implementation(library.Dependencies.RETROFIT)
    implementation(library.Dependencies.RETROFIT_MOSHI_CONVERTER)
    implementation(library.Dependencies.KOIN_CORE)
    implementation(library.Dependencies.KOIN_ANDROID)
    implementation(library.Dependencies.MOSHI)
    implementation(library.Dependencies.KOTLINX_COROUTINES)
    kapt(library.Dependencies.MOSHI_KAPT)
}