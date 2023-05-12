plugins {
    id("android.application")
    id("android.application.compose")
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.google.services)
    id("android.signing.config")
}

android {
    namespace = "com.tapptitude.template"

    defaultConfig {
        applicationId = configuration.Android.APPLICATION_ID
        versionCode = configuration.Android.VERSION_CODE
        versionName = configuration.Android.VERSION_NAME
    }

    buildTypes {

        getByName("debug") {
            manifestPlaceholders["crashlyticsCollectionEnabled"] = false
            applicationIdSuffix = ".debug"
        }

        getByName("release") {
            isMinifyEnabled = false
            manifestPlaceholders["crashlyticsCollectionEnabled"] = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName(SigningConfigPlugin.SIGNATURE_RELEASE)
        }
    }
}

dependencies {
    implementation(project(":crashlytics"))
    implementation(project(":feature:home"))
    implementation(project(":common"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.ext)
}
