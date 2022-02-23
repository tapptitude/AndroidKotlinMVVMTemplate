package library.extension

import org.gradle.api.artifacts.dsl.DependencyHandler
import library.TestDependencies
import library.AndroidTestDependencies

private const val TYPE_TEST_IMPLEMENTATION = "testImplementation"
private const val TYPE_ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private const val TYPE_API = "api"
private const val TYPE_IMPLEMENTATION = "implementation"
private const val TYPE_KAPT = "kapt"

fun DependencyHandler.addTestImplementation(dependencyName: String) {
    add(TYPE_TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.addAndroidTestImplementation(dependencyName: String) {
    add(TYPE_ANDROID_TEST_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.addApi(dependencyName: String) {
    add(TYPE_API, dependencyName)
}

fun DependencyHandler.addImplementation(dependencyName: String) {
    add(TYPE_IMPLEMENTATION, dependencyName)
}

fun DependencyHandler.addKapt(dependencyName: String) {
    add(TYPE_KAPT, dependencyName)
}

fun DependencyHandler.addAndroidAndTestDependencies() {
    addAndroidTestImplementation(AndroidTestDependencies.ANDROIDX_ESPRESSO_CORE)
    addAndroidTestImplementation(AndroidTestDependencies.ANDROIDX_EXT_JUNIT)
    addTestImplementation(TestDependencies.JUNIT)
}