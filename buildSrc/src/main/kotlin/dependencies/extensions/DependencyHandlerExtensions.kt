package dependencies.extensions

import org.gradle.api.artifacts.dsl.DependencyHandler
import dependencies.TestDependencies
import dependencies.AndroidTestDependencies

private const val TYPE_TEST_IMPLEMENTATION = "testImplementation"
private const val TYPE_ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private const val TYPE_API = "api"
private const val TYPE_IMPLEMENTATION = "implementation"
private const val TYPE_KAPT = "kapt"

fun DependencyHandler.testImplementation(dependencyName: String) {
    add(TYPE_TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.androidTestImplementation(dependencyName: String) {
    add(TYPE_ANDROID_TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.api(dependencyName: String) {
    add(TYPE_API, dependencyName)
}

fun DependencyHandler.implementation(dependencyName: String) {
    add(TYPE_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.kapt(dependencyName: String) {
    add(TYPE_KAPT, dependencyName)
}

fun DependencyHandler.addAndroidAndTestDependencies() {
    androidTestImplementation(AndroidTestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(AndroidTestDependencies.ANDROIDX_EXT_JUNIT)
    testImplementation(TestDependencies.JUNIT)
}