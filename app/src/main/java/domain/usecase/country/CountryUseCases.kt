package domain.usecase.country

data class CountryUseCases(
    val getCountry: GetCountryListUseCase,
    val getPopularCountries: GetPopularCountryListUseCase,
    val searchCountry: SearchCountryUseCase,

    )
