package data.local.dao

import androidx.room.*
import data.local.entity.TravelEntity
import data.local.entity.TravelItemEntity
import data.local.relation.TravelWithTravelItem
import kotlinx.coroutines.flow.Flow


@Dao
interface TravelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTravelEntity(travelEntity: TravelEntity): Long


    @Update
    suspend fun updateTravelEntity(travelEntity: TravelEntity)


    @Query("SELECT * FROM TravelEntity")
    fun getTravelsEntity(): Flow<List<TravelEntity>>

    @Delete
    fun deleteTravelEntity(travelEntity: TravelEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTravelItem(travelItem: TravelItemEntity): Long

    @Update
    suspend fun updateTravelItem(travelItem: TravelItemEntity)

    @Delete
    suspend fun deleteTravelItem(travelItem: TravelItemEntity)

    @Transaction
    @Query("SELECT * FROM TravelEntity WHERE id =:travelId ")
    fun getTravelWithTravelItem(travelId: Long): TravelWithTravelItem


}