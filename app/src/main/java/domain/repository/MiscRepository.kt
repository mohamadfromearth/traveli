package domain.repository

import data.remote.DataState
import domain.model.City
import domain.model.Country
import domain.model.Tag

interface MiscRepository {
    suspend fun getCountries(): DataState<List<Country>>
    suspend fun getPopularCountries(): DataState<ArrayList<Country>>
    suspend fun searchCountries(query: String): DataState<ArrayList<Country>>
    suspend fun searchCity(query: String): DataState<List<City>>
    suspend fun getCitiesOfCountry(countryId: Long): DataState<List<City>>
    suspend fun createTag(name: String): DataState<Tag>
}