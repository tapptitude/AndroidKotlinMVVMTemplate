import library.extension.addAndroidAndTestDependencies

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
    api(project(":core"))
    api(project(":imageLoading"))

    implementation(library.Dependencies.ANDROIDX_CORE_KTX)
    implementation(library.Dependencies.ANDROIDX_APP_COMPAT)
    implementation(library.Dependencies.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(library.Dependencies.ANDROIDX_LIFECYCLE_VIEWMODEL)
    implementation(library.Dependencies.ANDROIDX_LIFECYCLE_LIVEDATA)
    implementation(library.Dependencies.ANDROIDX_LIFECYCLE_COMMON)

    implementation(library.Dependencies.KOIN_ANDROID)
    implementation(library.Dependencies.KOIN_CORE)

    addAndroidAndTestDependencies()
}