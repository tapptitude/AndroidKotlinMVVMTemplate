import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("spotless")

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.versions)
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
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
