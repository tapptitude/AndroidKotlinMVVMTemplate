import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
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

plugins {
    id("com.github.ben-manes.versions") version "0.43.0"
    id("nl.littlerobots.version-catalog-update") version "0.7.0"
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

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
    gradleReleaseChannel = "current"
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    outputFormatter = "html"
}

versionCatalogUpdate {
    versionCatalogs {
        create("appLibs") {
            catalogFile.set(file("gradle/dependencies.toml"))
        }
        create("testLibs") {
            catalogFile.set(file("gradle/testDependencies.toml"))
        }

        create("androidTestLibs") {
            catalogFile.set(file("gradle/androidTestDependencies.toml"))
        }
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
