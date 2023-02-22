package data.repository

import data.remote.ApiResponseHandler
import data.remote.DataState
import data.remote.UserApi
import data.remote.dto.*
import domain.model.*
import domain.repository.UserRepository
import main.ApplicationClass
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import util.PrefManager
import java.io.File

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val app: ApplicationClass,
    private val prefManager: PrefManager,
    private val networkErrorMapper: NetworkErrorMapper,
    private val userPreviewMapper: UserPreviewMapper,
    private val userMapper: UserMapper,
    private val statMapper: StatMapper,
    private val travelPreviewMapper: TravelPreviewMapper,
    private val searchedUsersMapper: SearchedUsersMapper,
) : UserRepository, ApiResponseHandler(app, networkErrorMapper) {


    override suspend fun searchUser(query: String, page: Int): DataState<SearchedUsers> {
        return when (val response = call { userApi.searchUser(query, page) }) {
            is DataState.Failure -> response
            is DataState.Success -> {

                DataState.Success(searchedUsersMapper.toDomainModel(response.data.data))
            }
            is DataState.Loading -> DataState.Loading
        }
    }

    override suspend fun getMe(): DataState<UserInfo> {
        return when (val response = call { userApi.getMe() }) {
            is DataState.Failure -> response
            is DataState.Success -> {
                DataState.Success(userMapper.toDomainModel(response.data.user))
            }
            is DataState.Loading -> DataState.Loading
        }
    }

    override suspend fun getUser(userId: Long): DataState<UserInfo> {
        return when (val response = call { userApi.getUser(userId) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseGetUserDto.getFake()
                DataState.Success(userMapper.toDomainModel(data.user))
            }
        }
    }

    override suspend fun getMyUserId() = app.userInfo?.id ?: -1L


    override suspend fun getUserStat(userId: Long): DataState<List<Stat>> {
        return when (val response = call { userApi.getUserStat(userId) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseStatDto.getFake()
                DataState.Success(statMapper.fromEntityList(data.statList))
            }
        }
    }

    override suspend fun getUserTravelList(userId: Long, page: Int): DataState<List<TravelPreview>> {
        return when (val response = call { userApi.getUserTravelList(userId, page) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseTravelListDto.getFake()
                DataState.Success(travelPreviewMapper.fromEntityList(data.travels))
            }
        }
    }

    override suspend fun getMyTravelList(): DataState<List<TravelPreview>> {
        return when (val respone = call { userApi.getMyTravels() }) {
            is DataState.Failure -> respone
            is DataState.Loading -> DataState.Loading
            is DataState.Success -> DataState.Success(travelPreviewMapper.fromEntityList(respone.data.travels))
        }
    }

    override suspend fun getDrafts(): DataState<List<TravelPreview>> {
        return when (val response = call { userApi.getDrafts() }) {
            is DataState.Failure -> response
            is DataState.Loading -> DataState.Loading
            is DataState.Success -> DataState.Success(travelPreviewMapper.fromEntityList(response.data.travels))
        }
    }

    override suspend fun updateCover(filePath: String): DataState<UserInfo> {
        val file = File(filePath)
        val requestFile = file.asRequestBody("image".toMediaTypeOrNull())
        val body = MultipartBody.Part.create(requestFile)
        return when (val response = call { userApi.updateCover(body) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseGetUserDto.getFake(1)
                DataState.Success(userMapper.toDomainModel(data.user))
            }
        }
    }

    override suspend fun updateAvatar(filePath: String): DataState<UserInfo> {
        val file = File(filePath)
        val requestFile = file.asRequestBody("image".toMediaTypeOrNull())
        val body = MultipartBody.Part.create(requestFile)
        return when (val response = call { userApi.updateAvatar(body) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseGetUserDto.getFake(1)
                DataState.Success(userMapper.toDomainModel(data.user))
            }
        }
    }

    override suspend fun updateUserInfo(userInfo: UserInfo): DataState<UserInfo> {

        val avatarFile = if (userInfo.avatar == null) null else File(userInfo.avatar)
        val avatarRequest = avatarFile?.asRequestBody("avatar".toMediaTypeOrNull())
        val avatarBody = if (avatarRequest == null) null else MultipartBody.Part.create(avatarRequest)

        val headerImageFile = if (userInfo.headerImage == null) null else File(userInfo.headerImage)
        val headerImageRequest = headerImageFile?.asRequestBody("header_image".toMediaTypeOrNull())
        val headerImageBody = if (headerImageRequest == null) null else MultipartBody.Part.create(headerImageRequest)

        val contact = userInfo.contact

        return when (val response = call {
            userApi.updateUserInfo(
                userInfo.name?.toRequestBody(),
                avatarBody,
                userInfo.bio?.toRequestBody(),
                headerImageBody,
                userInfo.balance.toDouble(),
                userInfo.country.id,
                userInfo.city.id,
                contact.phone.value?.toRequestBody(),
                contact.instagram.value?.toRequestBody(),
                contact.twitter.value?.toRequestBody(),
                contact.website.value?.toRequestBody()
            )
        }) {
            is DataState.Success -> DataState.Success(userMapper.toDomainModel(response.data.user))
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> response
        }
    }

    override suspend fun updateContact(contactItem: ContactItem): DataState<UserInfo> {
        return when (val response = call { userApi.updateContact(contactItem.type.name, contactItem.value) }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                val data = ResponseGetUserDto.getFake(1)
                DataState.Success(userMapper.toDomainModel(data.user))
            }
        }
    }

    override suspend fun deleteAccount(): DataState<Unit> {
        return when (val response = call { userApi.deleteAccount() }) {
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
            is DataState.Loading -> {
                DataState.Success(Unit)
            }
        }
    }
}