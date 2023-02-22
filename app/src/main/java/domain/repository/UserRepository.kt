package domain.repository

import data.remote.DataState
import domain.model.*

interface UserRepository {

    suspend fun searchUser(query: String, page: Int): DataState<SearchedUsers>
    suspend fun getMe(): DataState<UserInfo>
    suspend fun getUser(userId: Long): DataState<UserInfo>
    suspend fun getMyUserId(): Long
    suspend fun getUserStat(userId: Long): DataState<List<Stat>>
    suspend fun getUserTravelList(userId: Long, page: Int): DataState<List<TravelPreview>>
    suspend fun getMyTravelList(): DataState<List<TravelPreview>>
    suspend fun updateCover(filePath: String): DataState<UserInfo>
    suspend fun updateAvatar(filePath: String): DataState<UserInfo>
    suspend fun updateUserInfo(userInfo: UserInfo): DataState<UserInfo>
    suspend fun updateContact(contactItem: ContactItem): DataState<UserInfo>
    suspend fun deleteAccount(): DataState<Unit>
    suspend fun getDrafts(): DataState<List<TravelPreview>>
}