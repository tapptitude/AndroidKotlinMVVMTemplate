import ext.addBasicConfiguration

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(appLibs.androidToolsBuildGradle)
        classpath(appLibs.kotlinGradlePlugin)
        classpath(appLibs.navigationSafeArgs)
        classpath(appLibs.googleServices)
        classpath(appLibs.firebaseGradle)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    addBasicConfiguration()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}