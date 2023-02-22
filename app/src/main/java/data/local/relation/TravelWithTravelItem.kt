package data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import data.local.entity.TravelEntity
import data.local.entity.TravelItemEntity

data class TravelWithTravelItem(
    @Embedded val travelEntity: TravelEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "travelId",
    )
    val travelItemList: List<TravelItemEntity>
)
