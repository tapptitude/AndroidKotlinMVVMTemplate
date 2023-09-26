package ext

import com.android.build.api.dsl.CommonExtension
import configuration.Android.COMPILE_SDK_VERSION
import configuration.Android.JAVA_LANGUAGE_LEVEL
import configuration.Android.KOTLIN_LANGUAGE_LEVEL
import configuration.Android.MIN_SDK_VERSION
import configuration.DimensionsEnum.API
import configuration.FlavorsEnum
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun addBaseCommonConfig(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK_VERSION

        defaultConfig {
            minSdk = MIN_SDK_VERSION
        }

        compileOptions {
            sourceCompatibility = JAVA_LANGUAGE_LEVEL
            targetCompatibility = JAVA_LANGUAGE_LEVEL
        }

        kotlinOptions {
            jvmTarget = KOTLIN_LANGUAGE_LEVEL
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

internal fun CommonExtension<*, *, *, *>.addFlavors(): CommonExtension<*, *, *, *> = apply {
    flavorDimensions += API.title

    productFlavors {
        FlavorsEnum.values().forEach { flavorData ->
            create(flavorData.flavorName) {
                dimension = flavorData.flavorDimension
            }
        }
    }
}

internal fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
