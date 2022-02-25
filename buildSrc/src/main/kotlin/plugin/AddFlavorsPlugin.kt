package plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.ProductFlavor
import configuration.DIMENSIONS_LIST
import configuration.FlavorsEnum
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class AddFlavorsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val appExtension = project.extensions.findByType(AppExtension::class.java)
        val libraryExtension = project.extensions.findByType(LibraryExtension::class.java)

        if (libraryExtension != null) {
            libraryExtension.setFlavorDimensions(DIMENSIONS_LIST)
            configureFlavors(libraryExtension.productFlavors)
        } else if (appExtension != null) {
            appExtension.flavorDimensions(*DIMENSIONS_LIST.toTypedArray())
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
