package plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import configuration.DimensionsEnum
import configuration.FlavorsEnum
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class AddFlavorsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val appExtension = project.extensions.findByType(AppExtension::class.java)
        val libraryExtension = project.extensions.findByType(LibraryExtension::class.java)

        val dimensionsList = DimensionsEnum.values().map { it.title }

        if (libraryExtension != null) {
            libraryExtension.setFlavorDimensions(dimensionsList)
            configureFlavors(libraryExtension.productFlavors)
        } else if (appExtension != null) {
            appExtension.flavorDimensions(*dimensionsList.toTypedArray())
            configureFlavors(appExtension.productFlavors)
        }
    }

    private fun configureFlavors(productFlavorsContainer: NamedDomainObjectContainer<ProductFlavor>) {
        FlavorsEnum.values().forEach { flavorData ->
            productFlavorsContainer.create(flavorData.flavorName) {
                dimension = flavorData.flavorDimension
            }
        }
    }
}
