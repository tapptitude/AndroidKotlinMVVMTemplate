package ext

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

fun Project.configureSpotless() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val ktlintVersion = libs.findVersion("ktlint").get().requiredVersion

    pluginManager.apply("com.diffplug.spotless")

    spotless {

        kotlin {
            target("src/**/*.kt")
            ktlint(ktlintVersion)
        }

        kotlinGradle {
            target("*.kts")
            ktlint(ktlintVersion)
        }
    }
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) = extensions.configure<SpotlessExtension>(action)