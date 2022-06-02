package configuration

enum class FlavorsEnum(
    val flavorName: String,
    val baseUrl: String,
    val flavorDimension: String
) {
    PRODUCTION(
        flavorName = "production",
        baseUrl = "https://foodish-api.herokuapp.com/",
        flavorDimension = DimensionsEnum.API.title
    ),
    DEV(
        flavorName = "dev",
        baseUrl = "https://foodish-api.herokuapp.com/",
        flavorDimension = DimensionsEnum.API.title
    )
}