// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(library.TopLevelDependencies.ANDROID_TOOLS_BUILD_GRADLE)
        classpath(library.TopLevelDependencies.KOTLIN_GRADLE_PLUGIN)
        classpath(library.TopLevelDependencies.NAVIGATION_SAFE_ARGS)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}