import com.android.build.api.dsl.ApplicationExtension
import configuration.Android
import configuration.Android.KOTLIN_JVM_TOOLCHAIN_VERSION
import ext.addBaseCommonConfig
import ext.addFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.application")
        target.pluginManager.apply("android.kotlin")

        target.extensions.configure<ApplicationExtension> {
            addBaseCommonConfig(this)
            defaultConfig.targetSdk = Android.TARGET_SDK_VERSION
            addFlavors()
        }

        target.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(KOTLIN_JVM_TOOLCHAIN_VERSION)
        }
    }
}
