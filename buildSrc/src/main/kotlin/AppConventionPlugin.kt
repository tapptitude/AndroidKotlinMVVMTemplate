import com.android.build.api.dsl.ApplicationExtension
import configuration.Android
import ext.addBaseCommonConfig
import ext.addFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.application")
        target.pluginManager.apply("org.jetbrains.kotlin.android")

        target.extensions.configure<ApplicationExtension> {
            target.addBaseCommonConfig(this)
            defaultConfig.targetSdk = Android.TARGET_SDK_VERSION
            addFlavors()
        }

        target.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(17)
        }
    }
}
