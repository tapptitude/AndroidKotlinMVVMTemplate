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
    implementation(project(":network"))

    implementation(library.Dependencies.ANDROIDX_CORE_KTX)
    implementation(library.Dependencies.KOIN_CORE)
    implementation(library.Dependencies.KOIN_ANDROID)
    implementation(library.Dependencies.KOTLINX_COROUTINES)
}