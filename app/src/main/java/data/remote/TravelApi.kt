package data.remote

import data.remote.dto.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface TravelApi {

    // TODO: Replace it with "getTravelByType"
    @GET("travels/trending")
    suspend fun getTrending(): Response<ResponseTravelListDto>

    // TODO: Replace it with "getTravelByType"
    @GET("travels/new/{page}")
    suspend fun getNewTravels(@Path("page") page: Int): Response<ResponseTravelListDto>

    @GET("travels/search/{page}") // Type = { trending, new, owned, marked }
    suspend fun getSelectedTravel(
        @Query("type") type: String? = null,
        @Query("country") country: String? = null,
        @Query("user_id") userId: Long? = null,
        page: Int
    ): Response<ResponseTravelListDto>

    @GET("travels/search")
    suspend fun searchTravel(@Query("query") travel: String, @Query("page") page: Int): Response<ResponseSearchTravelDto>

    @Multipart
    @POST("travels/create")
    suspend fun createTravel(
        @Part("name") name: RequestBody,
        @Part("country_id") countryId: Long,
        @Part("price") price: Long,
    ): Response<ResponseCreateTravelDto>


    @Multipart
    @POST("travels/{travelId}/update")
    suspend fun updateTravel(
        @Path("travelId") travelId: Long,
        @Part file: MultipartBody.Part?,
        @Part("name") name: RequestBody,
        @Part("country_id") countryId: Long,
        @Part("price") price: Long
    ): Response<ResponseCreateTravelDto>

    @DELETE("travels")
    suspend fun deleteTravel(
        @Field("id") travelId: Long
    ): Response<Unit>

    @FormUrlEncoded
    @POST("travels/{travelId}/contents")
    suspend fun createTravelItem(
        @Path("travelId") travelId: Long,
        @Field("type") type: Int,
        @Field("title") title: String,
        @Field("data") data: String,
        @Field("position") position: Int,
        @Field("is_summary") isSummary: Int
    ): Response<ResponseTravelItemDto>

    @FormUrlEncoded
    @POST("travels/{travelId}/contents/{travelItemId}/update")
    suspend fun updateTravelItem(
        @Path("travelId") travelId: Long,
        @Path("travelItemId") travelItemId: Long,
        @Field("title") title: String,
        @Field("type") type: Int,
        @Field("data") data: String,
        @Field("position") position: Int
    ): Response<ResponseTravelItemDto>


    @GET("travels/{travel_id}/contents/{content_id}/delete")
    suspend fun deleteTravelItem(
        @Path("travel_id") travelId: Long,
        @Path("content_id") travelItemId: Long
    ): Response<Unit>


    @FormUrlEncoded
    @POST("travels/{travel_id}/addCities")
    suspend fun addCitiesToTravel(
        @Path("travel_id") travelId: Long,
        @Field("cities") cities: List<Long>
    ): Response<Unit>

    @FormUrlEncoded
    @POST("travels/{travel_id}/deleteCity")
    suspend fun deleteTravelCities(
        @Path("travel_id") travelId: Long,
        @Field("cities") cities: List<Long>
    ): Response<Unit>

    @FormUrlEncoded
    @POST("travels/{travel_id}/addTags")
    suspend fun addTagsToTravel(
        @Path("travel_id") travelId: Long,
        @Field("tags") tags: List<Long>
    ): Response<Unit>


    @FormUrlEncoded
    @POST("travels/{travel_id}/deleteTag")
    suspend fun deleteTravelTags(
        @Path("travel_id") travelId: Long,
        @Field("tags") tags: List<Long>
    ): Response<Unit>


    @GET("travels/{travelId}/publish")
    suspend fun publishTravel(
        @Path("travelId") travelId: Long
    ): Response<Unit>


    @Multipart
    @POST("https://traveli2.gcoapps.com/api/files/upload")
    suspend fun uploadFile(
        @Part file: MultipartBody.Part,
        @Part("travel_id") travelId: Long,
    ): Response<ResponseUploadFileDto>


    @GET("travels/banner")
    suspend fun getBanner(): Response<Unit>

    @GET("travels/{travelId}")
    suspend fun getTravelDetail(@Path("travelId") travelId: Long): Response<ResponseTravelDetailDto>

    @GET("travels_summary/{travelId}")
    suspend fun getTravelSummary(@Path("travelId") travelId: Long): Response<ResponseTravelDetailDto>


    @GET("travels/{travelId}/toggleBookmark")
    suspend fun toggleBookmark(@Path("travelId") travelId: Long): Response<ResponseToggleBookmarkDto>


    @GET("tags")
    suspend fun getTags(): Response<ResponseTagDto>

}