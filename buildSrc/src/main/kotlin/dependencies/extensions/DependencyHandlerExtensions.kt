package dependencies.extensions

import org.gradle.api.artifacts.dsl.DependencyHandler
import dependencies.TestDependencies
import dependencies.AndroidTestDependencies

private const val TEST_IMPLEMENTATION = "testImplementation"
private const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"

fun DependencyHandler.testImplementation(dependencyName: String) {
    add(TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.androidTestImplementation(dependencyName: String) {
    add(ANDROID_TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.addAndroidAndTestDependencies() {
    androidTestImplementation(AndroidTestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(AndroidTestDependencies.ANDROIDX_EXT_JUNIT)
    testImplementation(TestDependencies.JUNIT)
}