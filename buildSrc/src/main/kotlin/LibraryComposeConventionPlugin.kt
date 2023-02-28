import com.android.build.api.dsl.LibraryExtension
import ext.addAndroidComposeConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")

        target.extensions.configure<LibraryExtension> {
            target.addAndroidComposeConfig(this)
        }
    }
}
