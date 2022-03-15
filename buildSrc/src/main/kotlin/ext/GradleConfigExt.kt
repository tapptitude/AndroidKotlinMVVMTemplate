package ext

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.internal.dsl.InternalLibraryExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import configuration.DimensionsEnum
import configuration.FlavorsEnum
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.addBasicConfiguration() {
    plugins.addBasicConfiguration(project)

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = configuration.Android.KOTLIN_LANGUAGE_LEVEL
    }
}

fun PluginContainer.addBasicConfiguration(project: Project) {
    whenPluginAdded {
        if (this is LibraryPlugin || this is AppPlugin) {
            val extensions = project.extensions

            if (extensions.findByType(BaseExtension::class.java) != null) {
                extensions
                    .getByType<BaseExtension>()
                    .addBaseCommonConfig()
            }

            if (extensions.findByType(BaseAppModuleExtension::class.java) != null) {
                extensions
                    .getByType<BaseAppModuleExtension>()
                    .addBaseCommonConfig()
            }

            if (extensions.findByType(InternalLibraryExtension::class.java) != null) {
                extensions
                    .getByType<InternalLibraryExtension>()
                    .addBaseCommonConfig()
            }
        }
    }
}

fun BaseExtension.addBaseCommonConfig() {
    setCompileSdkVersion(configuration.Android.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdk = configuration.Android.MIN_SDK_VERSION
        targetSdk = configuration.Android.TARGET_SDK_VERSION
    }

    compileOptions {
        sourceCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
        targetCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
    }

    productFlavors {
        FlavorsEnum.values().forEach { flavorData ->
            create(flavorData.flavorName) {
                dimension = flavorData.flavorDimension
            }
        }
    }

    flavorDimensions(*DimensionsEnum.values().map { it.title }.toTypedArray())
}

fun BaseAppModuleExtension.addBaseCommonConfig() {
    buildFeatures {
        viewBinding = configuration.Android.VIEW_BINDING_ENABLED
        dataBinding = configuration.Android.DATA_BINDING_ENABLED
    }
}

fun InternalLibraryExtension.addBaseCommonConfig() {
    buildFeatures {
        viewBinding = configuration.Android.VIEW_BINDING_ENABLED
        dataBinding = configuration.Android.DATA_BINDING_ENABLED
    }
}