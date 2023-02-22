package data.repository

import com.google.gson.Gson
import data.local.dao.TravelDao
import data.local.entity.TravelEntity
import data.remote.ApiResponseHandler
import data.remote.DataState
import data.remote.TravelApi
import data.remote.dto.*
import domain.model.*
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import main.ApplicationClass
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import util.extension.log
import java.io.File

class TravelRepositoryImpl(
    private val travelApi: TravelApi,
    private val app: ApplicationClass,
    private val networkErrorMapper: NetworkErrorMapper,
    private val travelPreviewMapper: TravelPreviewMapper,
    private val travelMapper: TravelMapper,
    private val travelItemMapper: TravelDetailMapper,
    private val searchedTravelsMapper: SearchedTravelsMapper,
    private val videoUrlMapper: VideoUrlMapper,
    private val tagMapper: TagMapper,
    private val travelDao: TravelDao,
    private val gson: Gson
) : TraveliRepository, ApiResponseHandler(app, networkErrorMapper) {

    private val trending = arrayListOf<TravelPreview>()
    private var newTravelPreview: List<TravelPreview>? = null
    private var banner: Banner? = null

    // TODO: Replace it with "getTravelByType"
    override suspend fun getTrending(page: Int): DataState<List<TravelPreview>> {
        return if (trending.isEmpty()) {
            return when (val response = call { travelApi.getTrending() }) {
                is DataState.Failure -> response
                is DataState.Loading -> {
                    trending.addAll(ResponseTravelListDto.getFake().travels.map { travelPreviewMapper.toDomainModel(it) })
                    DataState.Success(trending)
                }
                is DataState.Success -> DataState.Loading
            }
        } else {
            DataState.Success(trending)
        }
    }

    // TODO: Replace it with "getTravelByType"
    override suspend fun getNewTravels(page: Int): DataState<List<TravelPreview>> {
        newTravelPreview?.let { return DataState.Success(it) }
        return when (val response = call { travelApi.getNewTravels(page) }) {
            is DataState.Failure -> response
            is DataState.Loading -> {
                newTravelPreview = ResponseTravelListDto.getFake().travels.map { travelPreviewMapper.toDomainModel(it) }
                DataState.Success(newTravelPreview!!)
            }
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun getSelectedTravel(type: String?, country: String?, userId: Long?, page: Int): DataState<List<TravelPreview>> {
        return when (val response = call { travelApi.getSelectedTravel(type, country, userId, page) }) {
            is DataState.Failure -> response
            is DataState.Loading -> DataState.Success(ResponseTravelListDto.getFake().travels.map { travelPreviewMapper.toDomainModel(it) })
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun searchTravel(query: String, page: Int): DataState<SearchedTravels> {
        return when (val response = call { travelApi.searchTravel(query, page) }) {
            is DataState.Failure -> response
            is DataState.Loading -> {
                //   DataState.Success(ResponseTravelListDto.getFake().travels.map { travelPreviewMapper.toDomainModel(it) })
                response
            }
            is DataState.Success -> DataState.Success(searchedTravelsMapper.toDomainModel(response.data.searchedTravelsDto))
        }
    }

    override suspend fun getTravelDetail(travelId: Long): DataState<Travel> {
        return when (val response = call { travelApi.getTravelDetail(travelId) }) {
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
            is DataState.Success -> {
                val data = response.data.travel
                data.details = data.details.sortedBy { it.position }
                DataState.Success(travelMapper.toDomainModel(response.data.travel))
            }
        }
    }

    override suspend fun getTravelSummary(travelId: Long): DataState<Travel> {
        return when (val response = call { travelApi.getTravelSummary(travelId) }) {
            DataState.Loading    -> DataState.Success(travelMapper.toDomainModel(ResponseTravelDetailDto.getFake().travel))
            is DataState.Failure -> response
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun createTravel(cover: TravelItem.Cover, country: Country): DataState<Long> {
        val file = File(cover.cover)
        val requestFile = file.asRequestBody("image".toMediaTypeOrNull())
        val body = MultipartBody.Part.create(requestFile)
        //RequestBody usernameBody = RequestBody.create(MediaType.parse("text/plain"), usernameStr);
        log("TravelRepo:createTravel:title:${cover.title}")

        return when (val response = call { travelApi.createTravel(cover.title.toRequestBody(), country.id, 0) }) {
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
            is DataState.Success -> {
                val travelId = response.data.travel.get("id").asLong
                DataState.Success(travelId)
            }
        }
    }


    override suspend fun updateTravel(travel: Travel): DataState<Travel> {
        val file = if (travel.coverFile.isNotEmpty()) File(travel.coverFile) else null
        val requestFile = file?.asRequestBody("image".toMediaTypeOrNull())
        val body = if (requestFile == null) null else MultipartBody.Part.createFormData("cover", file.name, requestFile)

        return when (val response = call {
            travelApi.updateTravel(
                travel.id,
                body,
                travel.name.toRequestBody(),
                travel.country.id,
                travel.price.toLong(),
            )
        }) {
            is DataState.Success -> {
                val travelJson = response.data.travel
                val travelDto = TravelDto(
                    travelJson.get("id").asLong,
                    travelJson.get("name").asString,
                    travelJson.get("cover").asString,
                    CountryDto(travelJson.get("country_id").asLong, travel.country.name, travel.country.code, travel.country.image),
                    travelJson.get("price").asLong,
                    emptyList(),
                    emptyList(),
                    emptyList(),
                    UserPreviewDto(travelJson.get("user_id").asLong, travel.user.name, ""),
                    travel.isBookmarked,
                    travel.isOwned
                )
                DataState.Success(travelMapper.toDomainModel(travelDto))
            }
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> DataState.Failure(response.code, response.message)


        }
    }

    override suspend fun deleteTravel(travelId: Long): DataState<Unit> {
        return when (val response = call { travelApi.deleteTravel(travelId) }) {
            is DataState.Success -> DataState.Loading
            is DataState.Failure -> DataState.Failure(response.code, response.message)
            is DataState.Loading -> DataState.Success(Unit)

        }
    }

    override suspend fun publishTravel(travelId: Long): DataState<Unit> {
        return when (val response = call { travelApi.publishTravel(travelId) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Failure -> DataState.Failure(response.code, response.message)
            is DataState.Loading -> DataState.Loading
        }
    }

    override suspend fun createTravelItem(travelId: Long, travelItem: TravelItem, isSummary: Int): DataState<TravelItem> {
        val travelItemDto = travelItemMapper.toEntity(travelItem)
        val viewType = travelItemDto.type
        log("description:${travelItemDto.data}")
        return when (val response = call { travelApi.createTravelItem(travelId, travelItemDto.type, travelItemDto.title ?: "", travelItemDto.data, travelItemDto.position, isSummary) }) {
            is DataState.Loading -> DataState.Loading
            is DataState.Success -> DataState.Success(travelItemMapper.toDomainModel(response.data.data))
            is DataState.Failure -> {
                DataState.Failure(response.code, response.message)
            }
        }
    }


    override suspend fun updateTravelItem(travelId: Long, travelItem: TravelItem): DataState<TravelItem> {

        val travelItemDto = travelItemMapper.toEntity(travelItem)
        log("TravelRepo:TravelItem->Pos-> ${travelItem.position} type -> ${travelItemDto.data}")

        return when (val respone = call { travelApi.updateTravelItem(travelId, travelItemDto.id, travelItemDto.title ?: "", travelItemDto.type, travelItemDto.data, travelItemDto.position) }) {
            is DataState.Failure -> DataState.Failure(respone.code, respone.message)
            is DataState.Success -> DataState.Success(travelItemMapper.toDomainModel(respone.data.data))
            is DataState.Loading -> DataState.Loading

        }
    }

    override suspend fun deleteTravelItem(travelId: Long, travelItemId: Long): DataState<Unit> {
        return when (val response = call { travelApi.deleteTravelItem(travelId, travelItemId) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
        }
    }

    override suspend fun addCitiesToTravel(travelId: Long, cities: List<Long>): DataState<Unit> {
        return when (val response = call { travelApi.addCitiesToTravel(travelId, cities) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> DataState.Failure(response.code, response.message)


        }
    }

    override suspend fun deleteTravelCities(travelId: Long, cities: List<Long>): DataState<Unit> {
        return when (val response = call { travelApi.deleteTravelCities(travelId, cities) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> response

        }
    }

    override suspend fun deleteTravelTags(travelId: Long, tags: List<Long>): DataState<Unit> {
        return when (val response = call { travelApi.deleteTravelTags(travelId, tags) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> response
        }
    }

    override suspend fun addTagsToTravel(travelId: Long, tags: List<Long>): DataState<Unit> {
        return when (val response = call { travelApi.addTagsToTravel(travelId, tags) }) {
            is DataState.Success -> DataState.Success(Unit)
            is DataState.Failure -> DataState.Failure(response.code, response.message)
            is DataState.Loading -> DataState.Loading
        }
    }

    override suspend fun createLocalTravel(cover: TravelItem.Cover, country: Country): Long {
        val travelEntity = TravelEntity(
            title = cover.title,
            cover = cover.cover,
            countryId = country.id,
            countryName = country.name,
            price = 0.0,
            cityList = "",
            tagList = ""
        )
        return travelDao.insertTravelEntity(travelEntity)
    }

    override fun getLocalTravelPreviewList(): Flow<List<TravelPreview>> {
        return travelDao.getTravelsEntity().map { travelEntityList -> travelEntityList.map { it.toTravelPreview() } }
    }

    override suspend fun updateLocalTravel(travel: Travel): Travel {
        travelDao.updateTravelEntity(travel.toTravelEntity())
        return travel
    }

    override suspend fun deleteLocalTravel(travel: Travel) {
        travelDao.deleteTravelEntity(travel.toTravelEntity())
    }

    override suspend fun createLocalTravelItem(travelId: Long, travelItem: TravelItem): Long {
        return travelDao.insertTravelItem(travelItem.toTravelItemEntity(travelId))
    }

    override suspend fun getLocalTravelItemList(travelId: Long): List<TravelItem> {
        val travelWithTravelItem = travelDao.getTravelWithTravelItem(travelId)
        val travelEntity = travelWithTravelItem.travelEntity
        val travelItemList = ArrayList(travelWithTravelItem.travelItemList.map { it.toTravelItem() })
        travelItemList.add(0, TravelItem.Cover(travelEntity.title, travelEntity.cover))
        return travelItemList
    }

    override suspend fun updateLocalTravelItem(travelId: Long, travelItem: TravelItem) {
        travelDao.updateTravelItem(travelItem.toTravelItemEntity(travelId))
    }

    override suspend fun deleteLocalTravelItem(travelId: Long, travelItem: TravelItem) {
        travelDao.deleteTravelItem(travelItem.toTravelItemEntity(travelId))
    }


    override suspend fun uploadFile(filePath: String, travelId: Long): DataState<String> {
        val file = File(filePath)
        val requestFile = file.asRequestBody("image".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
        return when (val response = call { travelApi.uploadFile(body, travelId) }) {
            is DataState.Failure -> response
            DataState.Loading    -> DataState.Loading
            is DataState.Success -> DataState.Success(app.getBaseUrl() + response.data.fileDto.path)
        }
    }

    override suspend fun getBanner(): DataState<Banner> {
        banner?.let { return DataState.Success(it) }
        return when (val response = call { travelApi.getBanner() }) {
            is DataState.Failure -> response
            DataState.Loading    -> {
                banner = Banner.getFake()
                DataState.Success(Banner.getFake())
            }
            is DataState.Success -> DataState.Loading
        }
    }

    override suspend fun toggleBookmark(travelId: Long): DataState<Boolean> {
        return when (val response = call { travelApi.toggleBookmark(travelId) }) {
            is DataState.Success -> DataState.Success(response.data.data.get("bookmarked").asBoolean)
            is DataState.Loading -> DataState.Loading
            is DataState.Failure -> response
        }
    }

    override suspend fun getTags(): DataState<List<Tag>> {
        return when (val response = call { travelApi.getTags() }) {
            is DataState.Failure -> response
            is DataState.Loading -> DataState.Loading
            is DataState.Success -> DataState.Success(response.data.data.map { tagMapper.toDomainModel(it) })
        }
    }
}