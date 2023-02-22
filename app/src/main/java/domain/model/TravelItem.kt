package domain.model

import android.os.Parcelable
import com.google.gson.Gson
import data.local.entity.TravelItemEntity
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
sealed class TravelItem(
    open var id: Long,
    val viewType: Int,
    var position: Int = 0,
    var status: TravelItemStatus = TravelItemStatus.Success,
    var tag: String = Random.nextLong().toString()
) : Parcelable {

    data class Cover(val title: String, val cover: String) : TravelItem(-1, VIEW_TYPE_COVER)
    data class Description(override var id: Long, var title: String?, var description: String?) : TravelItem(id, VIEW_TYPE_DESCRIPTION)
    data class Link(override var id: Long, var title: String, var url: String) : TravelItem(id, VIEW_TYPE_LINK)
    data class Image(override var id: Long, var title: String, var imageUrl: String, var localImagePath: String, var uploadStatus: UploadStatus = UploadStatus.Uploading, var fileId: Long = -1) : TravelItem(id, VIEW_TYPE_IMAGE)
    data class Video(override var id: Long, val title: String, var video: String, var localVideo: String, val image: String = "https://www.konnecthq.com/wp-content/uploads/2019/07/Caribbean-Sea-31-12-1.jpg") : TravelItem(id, VIEW_TYPE_VIDEO)
    data class BookMark(override var id: Long, var isBookMark: Boolean) : TravelItem(id, VIEW_TYPE_BOOKMARK)
    data class User(override var id: Long, val user: UserPreview) : TravelItem(id, VIEW_TYPE_USER)
    data class City(val cityList: List<domain.model.City>) : TravelItem(-1, VIEW_TYPE_CITIES)
    data class Tag(val tagList: List<domain.model.Tag>) : TravelItem(-1, VIEW_TYPE_TAG)
    object Add : TravelItem(-1, VIEW_TYPE_ADD)
    data class BuyAndBookMark(val price: String, var isBookMark: Boolean) : TravelItem(-1, VIEW_TYPE_BUY_AND_BOOKMARK)
    object ConfirmTravel : TravelItem(-1, VIEW_TYPE_CONFIRM_TRAVEL)
    object AddPreview : TravelItem(-1, VIEW_TYPE_ADD_PREVIEW)

    companion object {

        const val VIEW_TYPE_COVER = 0
        const val VIEW_TYPE_IMAGE = 1
        const val VIEW_TYPE_DESCRIPTION = 2
        const val VIEW_TYPE_LINK = 3
        const val VIEW_TYPE_VIDEO = 4
        const val VIEW_TYPE_BOOKMARK = 5
        const val VIEW_TYPE_USER = 6
        const val VIEW_TYPE_CITIES = 7
        const val VIEW_TYPE_TAG = 8
        const val VIEW_TYPE_ADD = 9
        const val VIEW_TYPE_BUY_AND_BOOKMARK = 9
        const val VIEW_TYPE_CONFIRM_TRAVEL = 10
        const val VIEW_TYPE_ADD_PREVIEW = 11

        const val DEFAULT_ID = -1L


    }

    fun toTravelItemEntity(travelId: Long): TravelItemEntity {
        val gson = Gson()
        return when (this) {
            is Description -> TravelItemEntity(travelId = travelId, type = VIEW_TYPE_DESCRIPTION, data = gson.toJson(this))
            is Image       -> TravelItemEntity(travelId = travelId, type = VIEW_TYPE_IMAGE, data = gson.toJson(this))
            is Link        -> TravelItemEntity(travelId = travelId, type = VIEW_TYPE_LINK, data = gson.toJson(this))
            is Video       -> TravelItemEntity(travelId = travelId, type = VIEW_TYPE_VIDEO, data = gson.toJson(this))
            else           -> {
                // Should not be called
                TravelItemEntity(travelId = travelId, type = VIEW_TYPE_DESCRIPTION, data = gson.toJson(this))
            }
        }
    }

    open class Test1 {
        val x = 0
    }

    class Test2 : Test1()

    fun <T> clone(): T {

        return when (this) {
            Add               -> Add as T
            AddPreview        -> AddPreview as T
            is BookMark       -> BookMark(this.id, this.isBookMark) as T
            is BuyAndBookMark -> BuyAndBookMark(this.price, this.isBookMark) as T
            is City           -> City(cityList) as T
            ConfirmTravel     -> ConfirmTravel as T
            is Cover          -> Cover(title, cover) as T
            is Description    -> Description(id, title, description) as T
            is Image          -> Image(id, title, imageUrl, localImagePath) as T
            is Link           -> Link(id, title, url) as T
            is Tag            -> Tag(tagList) as T
            is User           -> User(id, user) as T
            is Video          -> Video(id, title, video, localVideo) as T
        }
    }

    enum class TravelItemStatus {
        Loading,
        Failure,
        Success
    }

    enum class UploadStatus {
        Uploading,
        Failure,
        Success
    }
}





