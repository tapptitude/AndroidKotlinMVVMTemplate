import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class DetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configureDetekt()
    }
}

private fun Project.configureDetekt() {
    pluginManager.apply("io.gitlab.arturbosch.detekt")

    detekt {
        config.from(file("${rootProject.projectDir}/config/detekt/detekt.yml"))
        basePath = rootProject.projectDir.absolutePath
        buildUponDefaultConfig = true
    }
}

private fun Project.detekt(action: DetektExtension.() -> Unit) = extensions.configure(action)
