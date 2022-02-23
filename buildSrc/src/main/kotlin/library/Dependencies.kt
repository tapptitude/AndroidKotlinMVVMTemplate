package library

object Dependencies {
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX}"
    const val ANDROIDX_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APP_COMPAT}"

    const val GOOGLE_MATERIAL = "com.google.android.material:material:${Versions.GOOGLE_MATERIAL}"

    const val OKHTTP_LIBRARY = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"

    object Versions {
        const val ANDROIDX_CORE_KTX = "1.7.0"
        const val ANDROIDX_APP_COMPAT = "1.4.1"

        const val GOOGLE_MATERIAL = "1.5.0"

        const val OKHTTP = "4.9.3"
        const val KOIN = "3.1.5"
        const val RETROFIT = "2.9.0"
    }
}