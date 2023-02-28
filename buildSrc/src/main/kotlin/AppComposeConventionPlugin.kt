import com.android.build.api.dsl.ApplicationExtension
import ext.addAndroidComposeConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AppComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.application")

        target.extensions.configure<ApplicationExtension> {
            target.addAndroidComposeConfig(this)
        }
    }
}
