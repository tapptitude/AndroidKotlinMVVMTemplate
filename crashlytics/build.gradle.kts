plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.firebase.crashlytics")
}

dependencies {
    implementation(project(":config"))

    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.firebaseCrashlytics)
    implementation(appLibs.firebaseAnalytics)
}
