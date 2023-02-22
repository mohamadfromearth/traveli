package data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.model.TravelPreview

@Entity
data class TravelEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val title: String,
    val cover: String,
    val countryId: Long,
    val countryName: String,
    val price: Double,
    val cityList: String,
    val tagList: String,
) {
    fun toTravelPreview() = TravelPreview(id, title, cover, price > 0, price, "", 0)
}