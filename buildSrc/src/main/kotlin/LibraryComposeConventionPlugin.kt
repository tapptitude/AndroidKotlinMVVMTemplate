import com.android.build.api.dsl.LibraryExtension
import ext.addAndroidComposeConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class LibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")

        target.extensions.configure<LibraryExtension> {
            target.addAndroidComposeConfig(this)
        }

        val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")

        target.dependencies {
            add("lintChecks", libs.findLibrary("compose.lintChecks").get())
        }
    }
}
