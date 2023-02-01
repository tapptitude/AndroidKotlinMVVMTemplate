package ext

import com.android.build.api.dsl.CommonExtension
import configuration.DimensionsEnum
import configuration.FlavorsEnum
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.addBaseCommonConfig(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        compileSdk = configuration.Android.COMPILE_SDK_VERSION

        defaultConfig {
            minSdk = configuration.Android.MIN_SDK_VERSION
        }

        compileOptions {
            sourceCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
            targetCompatibility = configuration.Android.JAVA_LANGUAGE_LEVEL
        }

        kotlinOptions {
            jvmTarget = configuration.Android.KOTLIN_LANGUAGE_LEVEL
        }
    }
}

internal fun Project.addAndroidComposeConfig(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
        }
    }
}

internal fun Project.addFlavors(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        flavorDimensions += DimensionsEnum.API.title

        productFlavors {
            FlavorsEnum.values().forEach { flavorData ->
                create(flavorData.flavorName) {
                    dimension = flavorData.flavorDimension
                }
            }
        }
    }
}

internal fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
