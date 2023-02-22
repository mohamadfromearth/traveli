package data.remote

import data.remote.dto.ResponseCityDto
import data.remote.dto.ResponseCountryDto
import data.remote.dto.ResponseCreateTagDto
import retrofit2.Response
import retrofit2.http.*

interface MiscApi {

    @GET("countries")
    suspend fun getCountries(): Response<ResponseCountryDto>

    @GET("popularcountries")
    suspend fun getPopularCountries(): Response<ResponseCountryDto>

    @GET("countries")
    suspend fun searchCountry(
        @Query("query") countryName: String
    ): Response<ResponseCountryDto>

    @GET("cities")
    suspend fun searchCity(
        @Query("query") cityName: String
    ): Response<ResponseCityDto>


    @GET("countries/{countryId}")
    suspend fun getCitiesOfCountry(
        @Path("countryId") countryId: Long
    ): Response<ResponseCityDto>

    @FormUrlEncoded
    @POST("tags/create")
    suspend fun createTag(
        @Field("name") name: String
    ): Response<ResponseCreateTagDto>
}