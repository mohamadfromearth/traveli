package domain.model

import android.os.Parcelable
import com.google.gson.Gson
import data.local.entity.TravelEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Travel(
    val id: Long,
    var name: String,
    val cover: String,
    val country: Country,
    val isBookmarked: Boolean = false,
    var price: String = "0",
    val details: MutableList<TravelItem> = mutableListOf(),
    val cityList: List<City> = listOf(),
    val tagList: List<Tag> = listOf(),
    val user: UserPreview = UserPreview(0, "", ""),
    val isOwned: Boolean = false,
    val isFree: Boolean,
    var coverFile: String = ""
) : Parcelable {
    fun toTravelEntity(): TravelEntity {
        val gson = Gson()
        return TravelEntity(
            title = name,
            cover = cover,
            countryId = country.id,
            countryName = country.name,
            price = price.toDouble(),
            cityList = gson.toJson(cityList),
            tagList = gson.toJson(tagList)
        )
    }

}
