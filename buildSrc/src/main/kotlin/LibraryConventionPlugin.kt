import com.android.build.api.dsl.LibraryExtension
import configuration.Android.KOTLIN_JVM_TOOLCHAIN_VERSION
import ext.addBaseCommonConfig
import ext.addFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.android.library")
        target.pluginManager.apply("org.jetbrains.kotlin.android")
        target.pluginManager.apply("org.jlleitschuh.gradle.ktlint")

        target.extensions.configure<LibraryExtension> {
            target.addBaseCommonConfig(this)
            addFlavors()
        }

        target.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(KOTLIN_JVM_TOOLCHAIN_VERSION)
        }
    }
}
