dependencyResolutionManagement {
    versionCatalogs {
        create("appLibs") {
            from(files("../gradle/dependencies.toml"))
        }
    }
}