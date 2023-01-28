dependencyResolutionManagement {
    versionCatalogs {
        create("appLibs") {
            from(files("../gradle/dependencies.toml"))
        }
        create("testLibs") {
            from(files("../gradle/testDependencies.toml"))
        }
    }
}