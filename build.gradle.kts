import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.google.services)
        classpath(libs.firebase.gradle)
    }
}

plugins {
    alias(libs.plugins.versions)
    alias(libs.plugins.ktlint)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
    gradleReleaseChannel = "current"
    outputFormatter = "html"
}

/**
 * Identifies if the dependency version is stable or not by looking if the version contains
 * any of the RELEASE, FINAL or GA keywords or if the version has the following format:
 * - 1 or more of any char in the range "0" to "9" or ",", ".", "v", "-" characters
 *
 * followed by
 *
 * - at most 1 time any of the "-", "r" characters
 * @param version The version of the dependency.
 * @return True if the dependency version is not stable, false otherwise.
 */
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
