import java.io.File
import kotlin.system.exitProcess

println("Type in package name:")
val packageName = readLine()
println("Package name is $packageName")

println("Type in app name:")
val appName = readLine()
println("App name is $appName")

if (packageName == null || appName == null) {
    println("Missing arguments. Please specify both packageName and appName. Package name introduced $packageName. App name introduced $appName")
    exitProcess(0)
}

val subDir = packageName.replace(".", "/")

println("Moving subdir to $subDir")

File(".").walkTopDown()
    .filter {
        it.isDirectory && (it.path.endsWith("/src/androidTest") || it.path.endsWith("/src/main") || it.path.endsWith("/src/test") ||
                // move the BuildConfig files too so that the app can run
                it.path.endsWith("/build/generated/source/buildConfig/dev/debug") ||
                it.path.endsWith("/build/generated/source/buildConfig/androidTest/dev/debug"))
    }
    .forEach {
        val templateDir = File("${it.path}/java/com/tapp")
        templateDir.listFiles()?.forEach {
            val javaDir = File("${it.path}/java/$subDir")
            println("Creating directory: ${javaDir.path}")
            javaDir.mkdirs()
            println("Moving files to: ${javaDir.path}")
            it.renameTo(File(javaDir, it.name))
        }
        println("Removing old directory: ${templateDir.path}")
        templateDir.deleteRecursively()
    }

println("Remaming packages and imports to $packageName")
File(".").walkTopDown()
    .filter { it.isFile && (it.name.endsWith(".kt") || it.name.endsWith(".kts")) }
    .forEach {
        val tempFile = File.createTempFile(it.name, null)
        val writer = tempFile.bufferedWriter()
        it.bufferedReader().lines().forEach { line ->
            writer.write(
                line.replace("package com.tapptitude", "package $packageName")
                    .replace("import com.tapptitude", "import $packageName")
                    .replace("com.tapptitude.template", "$packageName.app")
            )
            writer.newLine()
        }
        writer.close()
        it.delete()
        tempFile.renameTo(it)
    }


println("Remaming app to $appName")
File(".").walkTopDown().filter { it.name == "settings.gradle.kts" || it.extension == "xml" }
    .forEach {
        val tempFile = File.createTempFile(it.name, null)
        val writer = tempFile.bufferedWriter()
        it.bufferedReader().lines().forEach { line ->
            writer.write(
                line.replace("Tapptitude Template", appName)
                    .replace("Android MVVM Kotlin Template", appName)
            )
            writer.newLine()
        }
        writer.close()
        it.delete()
        tempFile.renameTo(it)
    }

println("Removing LICENSE, README and the customize script")
listOf("LICENSE", "README.md", "customize.kts").forEach {
    val file = File(it)
    if (file.exists()) {
        file.delete()
        println("Removed file: ${file.absolutePath}")
    }
}

println("Do you also want to delete the .git folder? (This will delete all git history / configuration): [y/n]")
val deleteGit = readline()
if (deleteGit = "y") {
    File(".git").deleteRecursively()
}

println("Done!")
