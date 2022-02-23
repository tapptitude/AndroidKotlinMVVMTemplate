package library

object AndroidTestDependencies {
    const val ANDROIDX_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_EXT_JUNIT}"
    const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO_CORE}"

    object Versions {
        const val ANDROIDX_EXT_JUNIT = "1.1.3"
        const val ANDROIDX_ESPRESSO_CORE = "3.4.0"
    }
}