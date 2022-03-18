pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("appLibs") {
            from(files("gradle/dependencies.toml"))
        }

        create("testLibs") {
            from(files("gradle/testDependencies.toml"))
        }

        create("androidTestLibs") {
            from(files("gradle/androidTestDependencies.toml"))
        }
    }
}

rootProject.name = "Tapptitude Template"

include(":app")
include(":network")
include(":config")
include(":core")
include(":featureHome")
include(":imageLoading")
include(":logger")
include(":session")
