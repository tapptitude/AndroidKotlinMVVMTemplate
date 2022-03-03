plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    version = JavaVersion.VERSION_11.toString()
}

dependencies {
    implementation(appLibs.androidToolsBuildGradle)
    implementation(appLibs.kotlinGradlePlugin)
}