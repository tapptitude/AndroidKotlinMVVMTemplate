plugins {
    id("android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tapptitude.config"

    productFlavors {
        configuration.FlavorsEnum.values().forEach { flavorData ->
            getByName(flavorData.flavorName) {
                buildConfigField("String", "BASE_URL", "\"${flavorData.baseUrl}\"")
            }
        }
    }

    buildTypes {
        buildTypes.forEach {
            it.buildConfigField("String", "APPLICATION_ID", "\"${configuration.Android.APPLICATION_ID}\"")
            it.buildConfigField("String", "VERSION_NAME", "\"${configuration.Android.VERSION_NAME}\"")
            it.buildConfigField("int", "VERSION_CODE", configuration.Android.VERSION_CODE.toString())
        }
    }

    buildFeatures {
        buildConfig = true
    }
}
