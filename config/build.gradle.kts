plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    productFlavors {
        configuration.FlavorsEnum.values().forEach { flavorData ->
            getByName(flavorData.flavorName) {
                buildConfigField("String", "BASE_URL", "\"${flavorData.baseUrl}\"")
            }
        }
    }
}