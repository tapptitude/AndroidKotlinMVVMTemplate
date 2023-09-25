import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("android.library")
        target.pluginManager.apply("android.library.compose")
        target.pluginManager.apply("koin")

        val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")

        target.dependencies {
            add("api", project(":core"))
            add("api", project(":logger"))
            add("api", project(":session"))
            add("api", project(":config"))
            add("api", project(":foundation:ui"))

            add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
            add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
            add("implementation", libs.findLibrary("androidx.navigation.compose").get())
            add("implementation", libs.findLibrary("coil.kt.compose").get())
            add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            add("implementation", libs.findLibrary("koin.androidx.compose").get())

            add("lintChecks", libs.findLibrary("compose.lintChecks").get())
        }
    }
}
