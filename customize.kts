import java.io.File

println("Type in package name:")
val packageName = (readLine() ?: throw Exception("Missing package name")).lowercase()
println("Package name is $packageName")

println("Type in app name:")
val appName = readLine() ?: throw Exception("Missing app name")
println("App name is $appName")

val subDir = packageName.replace(".", "/")

println("Moving subdir to $subDir")

File(".").walkTopDown()
    .filter {
        it.isDirectory && (it.path.endsWith("/src/androidTest") || it.path.endsWith("/src/main") || it.path.endsWith("/src/test"))
    }
    .forEach { dir ->
        val templateDir = File("${dir.path}/java/com/tapptitude/template")
        templateDir.listFiles()?.forEach { file ->
            val javaDir = File("${dir.path}/java/$subDir")
            println("Creating directory: ${javaDir.path}")
            javaDir.mkdirs()
            println("Moving files to: ${javaDir.path}")
            file.renameTo(File(javaDir, file.name))
        }
        println("Removing old directory: ${templateDir.path}")
        templateDir.deleteRecursively()
    }

println("Renaming any occurances of com.tapptitude.template to $packageName")
File(".").walkTopDown()
    .filter { it.isFile && (it.name.endsWith(".kt") || it.name.endsWith(".kts") || it.name.endsWith(".json")) }
    .forEach {
        val tempFile = File.createTempFile(it.name, null)
        val writer = tempFile.bufferedWriter()
        it.bufferedReader().lines().forEach { line ->
            writer.write(
                line.replace("com.tapptitude.template", "$packageName"),
            )
            writer.newLine()
        }
        writer.close()
        it.delete()
        tempFile.renameTo(it)
    }

println("Renaming AndroidMVVMKotlinTemplate app to $appName")
File(".").walkTopDown()
    .filter { it.name == "settings.gradle.kts" || it.extension == "xml" }
    .forEach {
        val tempFile = File.createTempFile(it.name, null)
        val writer = tempFile.bufferedWriter()
        it.bufferedReader().lines().forEach { line ->
            writer.write(
                line.replace("AndroidMVVMKotlinTemplate", appName),
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
val deleteGit = readLine()
if (deleteGit?.contains("y", ignoreCase = true) == true) {
    File(".git").deleteRecursively()
}

println("Done!")
