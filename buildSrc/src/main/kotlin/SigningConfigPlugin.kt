import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.SigningConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.File
import java.io.FileInputStream
import java.util.Properties

class SigningConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.configure<ApplicationExtension> {
            createReleaseSigningConfig(project.rootDir.path)
        }
    }

    private fun ApplicationExtension.createReleaseSigningConfig(projectPath: String) {
        signingConfigs.create(SIGNATURE_RELEASE)
            .populateReleaseConfigIfAvailable(projectPath)
    }

    private fun SigningConfig.populateReleaseConfigIfAvailable(projectPath: String) {
        if (this !is com.android.build.gradle.internal.dsl.SigningConfig) return

        val fullPropertiesFilePath = "$projectPath${File.separator}$PROPERTIES_FILE_PATH"
        val propertiesFile = File(fullPropertiesFilePath)

        if (propertiesFile.exists()) {
            val fullKeystoreFilePath = "$projectPath${File.separator}$KEYSTORE_FILE_PATH"

            val properties = Properties()
            properties.load(FileInputStream(propertiesFile))

            storeFile(File(fullKeystoreFilePath))
            storePassword(properties.getProperty(KEY_KEYSTORE_PASSWORD))
            keyAlias(properties.getProperty(KEY_ALIAS))
            keyPassword(properties.getProperty(KEY_ALIAS_PASSWORD))
        }
    }

    companion object {
        const val SIGNATURE_RELEASE = "release"

        // Relative to project path
        private const val PROPERTIES_FILE_PATH = "../_signingConfigs/UPDATE_NAME.properties"
        private const val KEYSTORE_FILE_PATH = "../_signingConfigs/UPDATE_NAME.keystore"

        private const val KEY_KEYSTORE_PASSWORD = "keystore.password"
        private const val KEY_ALIAS = "key.alias"
        private const val KEY_ALIAS_PASSWORD = "key.password"
    }
}
