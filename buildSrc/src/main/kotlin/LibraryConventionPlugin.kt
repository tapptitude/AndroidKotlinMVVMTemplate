import com.android.build.api.dsl.LibraryExtension
import configuration.Android
import ext.addBaseCommonConfig
import ext.addFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")
        target.pluginManager.apply("org.jetbrains.kotlin.android")

        target.extensions.configure<LibraryExtension> {
            target.addBaseCommonConfig(this)
            defaultConfig.targetSdk = Android.TARGET_SDK_VERSION
            target.addFlavors(this)
        }
    }
}
