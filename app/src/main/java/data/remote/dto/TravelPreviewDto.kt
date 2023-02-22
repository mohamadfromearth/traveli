package data.remote.dto

import com.google.gson.annotations.SerializedName
import kotlin.random.Random

data class TravelPreviewDto(
    val id: Long,
    val name: String,
    val cover: String,
    val price: Double,
    val status: String?,
    val views: Long,
    @SerializedName("user_id")
    val userId: Long,
    @SerializedName("country_id")
    val countryId: Long
) {
    companion object {
        const val carabianSeeImage = "https://www.wildearth-travel.com/get-image-version/verybig/uploads/caribbean_sea_11_days_(fram)_picture.jpg"

        fun getFake(price: Double) = TravelPreviewDto(Random.nextLong(100000), "Caribbean Sea", carabianSeeImage, price, "", 0, 0, 0)
        fun getFake(size: Int = 20): ArrayList<TravelPreviewDto> {
            val list = arrayListOf<TravelPreviewDto>()
            repeat(size) {
                list.add(getFake(if (it % 2 == 0) 1.0 else 0.0))
            }
            return list
        }
    }
}