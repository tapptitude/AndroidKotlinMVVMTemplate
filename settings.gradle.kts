pluginManagement {
    includeBuild("gradle/build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "AndroidMVVMKotlinTemplate"

include(":app")
include(":network")
include(":config")
include(":core")
include(":foundation")
include(":foundation:ui")
include(":feature")
include(":feature:home")
include(":logger")
include(":session")
include(":crashlytics")
include(":persistence")
include(":common")
