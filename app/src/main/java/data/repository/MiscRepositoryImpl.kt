package data.repository

import data.remote.ApiResponseHandler
import data.remote.DataState
import data.remote.MiscApi
import data.remote.dto.*
import domain.model.City
import domain.model.Country
import domain.model.Tag
import domain.repository.MiscRepository
import main.ApplicationClass

class MiscRepositoryImpl(
    private val miscApi: MiscApi,
    private val app: ApplicationClass,
    private val networkErrorMapper: NetworkErrorMapper,
    private val countryMapper: CountryMapper,
    private val cityMapper: CityMapper,
    private val tagMapper: TagMapper
) : MiscRepository, ApiResponseHandler(app, networkErrorMapper) {

    private val popularCountryList = arrayListOf<Country>()
    private val countryList = arrayListOf<Country>()

    override suspend fun getCountries(): DataState<List<Country>> {
        if (countryList.isNotEmpty()) return DataState.Success(countryList)
        return when (val response = call { miscApi.getCountries() }) {
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
            is DataState.Success -> DataState.Success(response.data.countries.map { countryMapper.toDomainModel(it) })
        }
    }

    override suspend fun getPopularCountries(): DataState<ArrayList<Country>> {
        if (popularCountryList.isNotEmpty()) return DataState.Success(popularCountryList)
        return when (val response = call { miscApi.getPopularCountries() }) {
            is DataState.Failure -> response
            DataState.Loading    -> {
                popularCountryList.addAll(countryMapper.fromEntityList(ResponseCountryDto.getPopularFake().countries))
                DataState.Success(popularCountryList)
            }
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun searchCountries(query: String): DataState<ArrayList<Country>> {
        return when (val response = call { miscApi.searchCountry(query) }) {
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
            is DataState.Success -> DataState.Success(countryMapper.fromEntityList(response.data.countries))
        }
    }

    override suspend fun searchCity(query: String): DataState<List<City>> {
        return when (val response = call { miscApi.searchCity(query) }) {
            is DataState.Failure -> response
            is DataState.Loading -> {
                DataState.Success(ResponseCityDto.getFake().data.map { cityMapper.toDomainModel(it) })
            }
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun getCitiesOfCountry(countryId: Long): DataState<List<City>> {
        return when (val response = call { miscApi.getCitiesOfCountry(countryId) }) {
            is DataState.Success -> DataState.Success(response.data.data.map { cityMapper.toDomainModel(it) })
            is DataState.Failure -> response
            is DataState.Loading -> DataState.Loading
        }
    }

    override suspend fun createTag(name: String): DataState<Tag> {
        return when (val response = call { miscApi.createTag(name) }) {
            is DataState.Failure -> DataState.Failure(response.code, response.message)
            is DataState.Loading -> DataState.Loading
            is DataState.Success -> DataState.Success(tagMapper.toDomainModel(response.data.data))
        }
    }

}