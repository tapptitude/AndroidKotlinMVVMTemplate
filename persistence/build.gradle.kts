plugins {
    id("android.library")
    id("koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.tapptitude.template.persistence"

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
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
}
