package data.remote.dto

import com.google.gson.Gson
import domain.model.TravelItem.Companion.VIEW_TYPE_DESCRIPTION
import domain.model.TravelItem.Companion.VIEW_TYPE_IMAGE
import domain.model.TravelItem.Companion.VIEW_TYPE_LINK
import domain.model.TravelItem.Companion.VIEW_TYPE_VIDEO
import kotlin.random.Random

data class TravelItemDto(
    val id: Long,
    val type: Int,
    val position: Int,
    val title: String?,
    val data: String
) {

    companion object {

        fun getFake(): TravelItemDto {
            val gson = Gson()
            return TravelItemDto(Random.nextLong(), VIEW_TYPE_VIDEO, 3, "", gson.toJson(VideoDto("", "https://persian5.cdn.asset.aparat.com/aparat-video/bdaea06a8c07f580a463d150bb9730af44790032-360p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImI5YzQ4MTY3NGM3ZGVlYWM4NGViYTQ3NjBkMWYyZmM1IiwiZXhwIjoxNjU5MzUzMTQ5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.swNGTFsvVXfi3qSfenlib0WTMXgKCQB0Vq4u3JwQ8-k", "https://png.pngtree.com/png-vector/20190828/ourmid/pngtree-flat-design-different-sea-views-png-image_1695410.jpg")))
        }


        fun getFakes(): List<TravelItemDto> {
            val gson = Gson()
            return mutableListOf(
                TravelItemDto(Random.nextLong(), VIEW_TYPE_IMAGE, 0, "", gson.toJson(ImageDto("", "https://www.konnecthq.com/wp-content/uploads/2019/07/Caribbean-Sea-31-12-1.jpg", ""))),
                TravelItemDto(Random.nextLong(), VIEW_TYPE_DESCRIPTION, 1, "", gson.toJson(DescriptionDto("", "I went to carabian sea alone. there was shark there and that shark wanted to eat me but fortunately somehow I ran away"))),
                TravelItemDto(Random.nextLong(), VIEW_TYPE_LINK, 2, "Fake title of link", gson.toJson(LinkDto("Fake title of link", "https://www.google.com"))),
                TravelItemDto(Random.nextLong(), VIEW_TYPE_VIDEO, 3, "", gson.toJson(VideoDto("", "https://persian5.cdn.asset.aparat.com/aparat-video/bdaea06a8c07f580a463d150bb9730af44790032-360p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImI5YzQ4MTY3NGM3ZGVlYWM4NGViYTQ3NjBkMWYyZmM1IiwiZXhwIjoxNjU5MzUzMTQ5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.swNGTFsvVXfi3qSfenlib0WTMXgKCQB0Vq4u3JwQ8-k", "https://png.pngtree.com/png-vector/20190828/ourmid/pngtree-flat-design-different-sea-views-png-image_1695410.jpg"))),
                TravelItemDto(Random.nextLong(), VIEW_TYPE_VIDEO, 4, "", gson.toJson(VideoDto("", "https://persian5.cdn.asset.aparat.com/aparat-video/bdaea06a8c07f580a463d150bb9730af44790032-360p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImI5YzQ4MTY3NGM3ZGVlYWM4NGViYTQ3NjBkMWYyZmM1IiwiZXhwIjoxNjU5MzUzMTQ5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.swNGTFsvVXfi3qSfenlib0WTMXgKCQB0Vq4u3JwQ8-k", "https://png.pngtree.com/png-vector/20190828/ourmid/pngtree-flat-design-different-sea-views-png-image_1695410.jpg"))),
            )
        }

        fun getFakeForCreate() = mutableListOf<TravelItemDto>()
    }


}


interface BaseData
data class CoverDto(val title: String, val image: String) : BaseData
data class ImageDto(val title: String, val image: String, val localImage: String) : BaseData
data class DescriptionDto(val title: String?, val description: String?) : BaseData
data class LinkDto(val title: String, val url: String) : BaseData
data class VideoDto(val title: String, val video: String, val frame: String) : BaseData


