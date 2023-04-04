plugins {
    `kotlin-dsl`
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(11)) }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "android.application"
            implementationClass = "AppConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "android.application.compose"
            implementationClass = "AppComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "android.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "android.library.compose"
            implementationClass = "LibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "android.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("signingConfig") {
            id = "android.signing.config"
            implementationClass = "SigningConfigPlugin"
        }
    }
}
