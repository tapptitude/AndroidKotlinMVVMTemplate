plugins {
    `kotlin-dsl`
    alias(libs.plugins.spotless)
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(11)) }
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktlint(libs.versions.ktlint.get())
    }

    kotlinGradle {
        target("*.kts")
        ktlint(libs.versions.ktlint.get())
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
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
        register("androidKotlin") {
            id = "android.kotlin"
            implementationClass = "KotlinAndroidConventionPlugin"
        }
        register("spotless") {
            id = "spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
        register("koin") {
            id = "koin"
            implementationClass = "KoinConventionPlugin"
        }
    }
}
