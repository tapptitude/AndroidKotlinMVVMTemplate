plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(appLibs.plugins.ksp)
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.incremental", "true")
            }
        }

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    implementation(appLibs.bundles.koinBundle)
    implementation(appLibs.bundles.roomBundle)
    ksp(appLibs.roomKsp)
}
