package data.remote.dto

import kotlin.random.Random

data class CityDto(
    val id: Long,
    val name: String,

) {
    companion object {
        fun getFake() = CityDto(Random.nextLong(100000), "Barcelona")
        fun getFakes(): ArrayList<CityDto> {
            val cityList = arrayListOf<CityDto>()
            repeat(10) {
                cityList.add(getFake())
            }
            return cityList
        }
    }

}