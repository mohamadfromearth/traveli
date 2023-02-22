package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.dao.TravelDao
import data.local.entity.TravelEntity
import data.local.entity.TravelItemEntity

@Database(
    entities = [TravelEntity::class, TravelItemEntity::class],
    version = 1
)
abstract class TraveliDataBase : RoomDatabase() {

    abstract fun getTravelDao(): TravelDao
}