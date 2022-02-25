package configuration

enum class FlavorsEnum(val flavorName: String, val baseUrl: String, val flavorDimension: String) {
    PRODUCTION(
        flavorName = "production",
        baseUrl = "https://foodish-api.herokuapp.com/",
        flavorDimension = DIMENSION_API
    ),
    DEV(
        flavorName = "dev",
        baseUrl = "https://foodish-api.herokuapp.com/",
        flavorDimension = DIMENSION_API
    )
}