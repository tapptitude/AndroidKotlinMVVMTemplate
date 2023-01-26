pluginManagement {
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

rootProject.name = "Tapptitude Template"

include(":app")
include(":network")
include(":config")
include(":core")
include(":foundation")
include(":foundation:ui")
include(":feature")
include(":feature:home")
include(":imageLoading")
include(":logger")
include(":session")
include(":crashlytics")
include(":persistence")
