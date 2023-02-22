package data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import domain.model.TravelItem
import domain.model.TravelItem.Companion.VIEW_TYPE_DESCRIPTION
import domain.model.TravelItem.Companion.VIEW_TYPE_IMAGE
import domain.model.TravelItem.Companion.VIEW_TYPE_LINK
import domain.model.TravelItem.Companion.VIEW_TYPE_VIDEO

@Entity
class TravelItemEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val travelId: Long,
    val type: Int,
    val data: String
) {

    fun toTravelItem(): TravelItem {
        val gson = Gson()
        return when (type) {
            VIEW_TYPE_LINK        -> {
                gson.fromJson(data, TravelItem.Link::class.java)
            }
            VIEW_TYPE_IMAGE       -> {
                gson.fromJson(data, TravelItem.Image::class.java)
            }
            VIEW_TYPE_DESCRIPTION -> {
                gson.fromJson(data, TravelItem.Description::class.java)
            }
            VIEW_TYPE_VIDEO       -> {
                gson.fromJson(data, TravelItem.Video::class.java)
            }
            else                  -> {
                //Should not be called
                gson.fromJson(data, TravelItem.Link::class.java)
            }
        }
    }
}