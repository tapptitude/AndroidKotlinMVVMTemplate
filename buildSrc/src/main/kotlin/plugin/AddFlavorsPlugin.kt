package plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class AddFlavorsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val appExtension = project.extensions.findByType(AppExtension::class.java)
        val libraryExtension = project.extensions.findByType(LibraryExtension::class.java)

        if (libraryExtension != null) {
            libraryExtension.setFlavorDimensions(listOf(DIMENSION_API))
            configureFlavors(libraryExtension.productFlavors)
        } else if (appExtension != null) {
            appExtension.flavorDimensions(DIMENSION_API)
            configureFlavors(appExtension.productFlavors)
        }
    }

    private fun configureFlavors(productFlavorsContainer: NamedDomainObjectContainer<ProductFlavor>) {
        FlavorsEnum.values().forEach {
            productFlavorsContainer.create(it.flavorName)
        }
    }
}

enum class FlavorsEnum(val flavorName: String, val baseUrl: String) {
    PRODUCTION(
        flavorName = "production",
        baseUrl = "https://www.tapptitude.com/"
    ),
    DEV(
        flavorName = "dev",
        baseUrl = "https://dev.tapptitude.com/"
    )
}

private const val DIMENSION_API = "api"