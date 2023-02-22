package domain.repository

import data.remote.DataState
import domain.model.*
import kotlinx.coroutines.flow.Flow

interface TraveliRepository {

    // TODO: Replace it with "getTravelByType"
    suspend fun getTrending(page: Int): DataState<List<TravelPreview>>

    // TODO: Replace it with "getTravelByType"
    suspend fun getNewTravels(page: Int): DataState<List<TravelPreview>>

    suspend fun getSelectedTravel(type: String?, country: String?, userId: Long?, page: Int): DataState<List<TravelPreview>>

    suspend fun searchTravel(query: String, page: Int): DataState<SearchedTravels>

    suspend fun getTravelDetail(travelId: Long): DataState<Travel>

    suspend fun createTravel(cover: TravelItem.Cover, country: Country): DataState<Long>

    suspend fun updateTravel(travel: Travel): DataState<Travel>


    suspend fun deleteTravel(travelId: Long): DataState<Unit>

    suspend fun publishTravel(travelId: Long): DataState<Unit>

    suspend fun createTravelItem(travelId: Long, travelItem: TravelItem, isSummary: Int): DataState<TravelItem>


    suspend fun updateTravelItem(travelId: Long, travelItem: TravelItem): DataState<TravelItem>

    suspend fun deleteTravelItem(travelId: Long, travelItemId: Long): DataState<Unit>

    suspend fun addCitiesToTravel(travelId: Long, cities: List<Long>): DataState<Unit>

    suspend fun deleteTravelCities(travelId: Long, cities: List<Long>): DataState<Unit>

    suspend fun deleteTravelTags(travelId: Long, tags: List<Long>): DataState<Unit>

    suspend fun addTagsToTravel(travelId: Long, tags: List<Long>): DataState<Unit>

    suspend fun createLocalTravel(cover: TravelItem.Cover, country: Country): Long

    fun getLocalTravelPreviewList(): Flow<List<TravelPreview>>

    suspend fun updateLocalTravel(travel: Travel): Travel

    suspend fun deleteLocalTravel(travel: Travel)

    suspend fun createLocalTravelItem(travelId: Long, travelItem: TravelItem): Long

    suspend fun getLocalTravelItemList(travelId: Long): List<TravelItem>

    suspend fun updateLocalTravelItem(travelId: Long, travelItem: TravelItem)

    suspend fun deleteLocalTravelItem(travelId: Long, travelItem: TravelItem)

    suspend fun uploadFile(filePath: String, travelId: Long): DataState<String>

    suspend fun getTravelSummary(travelId: Long): DataState<Travel>

    suspend fun getBanner(): DataState<Banner>

    suspend fun toggleBookmark(travelId: Long): DataState<Boolean>

    suspend fun getTags(): DataState<List<Tag>>

}