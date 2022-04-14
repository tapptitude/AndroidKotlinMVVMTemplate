plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
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