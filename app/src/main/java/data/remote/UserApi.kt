package data.remote

import data.remote.dto.ResponseGetUserDto
import data.remote.dto.ResponseSearchUserDto
import data.remote.dto.ResponseStatDto
import data.remote.dto.ResponseTravelListDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @GET("users/search")
    suspend fun searchUser(@Query("query") query: String, @Query("page") page: Int): Response<ResponseSearchUserDto>

    @GET("users/me")
    suspend fun getMe(): Response<ResponseGetUserDto>

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Long): Response<ResponseGetUserDto>

    @GET("users/{userId}/stat")
    suspend fun getUserStat(@Path("userId") userId: Long): Response<ResponseStatDto>

    @GET("users/{userId}/travels")
    suspend fun getUserTravelList(@Path("userId") userId: Long, @Query("page") page: Int): Response<ResponseTravelListDto>

    @GET("users/myTravels")
    suspend fun getMyTravels(): Response<ResponseTravelListDto>

    @GET("travels/drafts")
    suspend fun getDrafts(): Response<ResponseTravelListDto>

    @DELETE("users/drafts")
    suspend fun deleteDrafts()

    @Multipart
    @POST("users/update/cover")
    suspend fun updateCover(@Part("cover") cover: MultipartBody.Part): Response<ResponseGetUserDto>

    @Multipart
    @POST("users/update/avatar")
    suspend fun updateAvatar(@Part("avatar") avatar: MultipartBody.Part): Response<ResponseGetUserDto>

    @Multipart
    @POST("users/update")
    suspend fun updateUserInfo(
        @Part("name") name: RequestBody?,
        @Part avatar: MultipartBody.Part?,
        @Part("bio") bio: RequestBody?,
        @Part headerImage: MultipartBody.Part?,
        @Part("balance") balance: Double?,
        @Part("country") countryId: Long?,
        @Part("city") cityId: Long?,
        @Part("phone") phone: RequestBody?,
        @Part("instagram") instagram: RequestBody?,
        @Part("twitter") twitter: RequestBody?,
        @Part("website") website: RequestBody?,
    ): Response<ResponseGetUserDto>

    @POST("users/update/contact")
    suspend fun updateContact(
        @Field("title") title: String,
        @Field("value") value: String?,
    ): Response<ResponseGetUserDto>

    @GET("users/delete")
    suspend fun deleteAccount(
    ): Response<Unit>
}