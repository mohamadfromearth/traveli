package domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class City(
    val id: Long,
    val name: String,
    var isSelected: Boolean = false

) : Parcelable {
    companion object {

        fun getFake() = City(Random.nextLong(100000), "Barcelona")
        fun getFakes(): List<City> {
            val cities = mutableListOf<City>()
            repeat(5) {
                cities.add(getFake())
            }
            return cities
        }

        const val ADD_ID = -1L

        fun List<City>.cloned() = ArrayList(this)

    }
}