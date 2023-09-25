import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.dependencies {
            val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")
            val koinBom = libs.findLibrary("koin-bom").get()
            add("implementation", platform(koinBom))
            add("implementation", libs.findLibrary("koin.core").get())
            add("implementation", libs.findLibrary("koin.android").get())
        }
    }
}