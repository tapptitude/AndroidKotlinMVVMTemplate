package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidTestDependencies {
    const val ANDROIDX_EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"

    fun DependencyHandler.addTestDependencies() {

    }
}