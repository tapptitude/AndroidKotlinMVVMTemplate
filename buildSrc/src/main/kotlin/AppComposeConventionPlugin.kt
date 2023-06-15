import com.android.build.api.dsl.ApplicationExtension
import ext.addAndroidComposeConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class AppComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.application")

        target.extensions.configure<ApplicationExtension> {
            target.addAndroidComposeConfig(this)
        }

        val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")

        target.dependencies {
            add("lintChecks", libs.findLibrary("compose.lintChecks").get())
        }
    }
}
