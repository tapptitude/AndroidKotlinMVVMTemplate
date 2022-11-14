plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
}

apply<plugin.SigningConfigPlugin>()

android {
    defaultConfig {
        applicationId = configuration.Android.APPLICATION_ID
        versionCode = configuration.Android.VERSION_CODE
        versionName = configuration.Android.VERSION_NAME
    }

    buildTypes {

        getByName("debug") {
            this.manifestPlaceholders["crashlyticsCollectionEnabled"] = false
        }

        getByName("release") {
            isMinifyEnabled = false
            this.manifestPlaceholders["crashlyticsCollectionEnabled"] = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName(plugin.SigningConfigPlugin.SIGNATURE_RELEASE)
        }
    }
}

dependencies {
    api(project(":featureHome"))
    api(project(":crashlytics"))

    implementation(appLibs.androidXCoreKtx)
    implementation(appLibs.androidXAppCompat)
    implementation(appLibs.googleMaterial)
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.bundles.androidXNavigationBundle)

    testImplementation(testLibs.bundles.testBundle)
    androidTestImplementation(androidTestLibs.bundles.androidTestBundle)
}
