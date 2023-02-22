package data.remote.dto

import kotlin.random.Random

data class CountryDto(
    val id: Long,
    val name: String,
    val code: String?,
    val image: String?

) {

    companion object {

        val takhtJamshidImage = "https://images.kojaro.com/2017/8/f5ac7d22-060f-4426-a4fd-4adaae8bbc3d-840x560.jpg"

        fun getFake() = CountryDto(Random.nextLong(1, 10000), "Iran", "IR", takhtJamshidImage)

        private fun getPopularFake() = CountryDto(Random.nextLong(1, 10000), "Popular", "IR", takhtJamshidImage)

        fun getFakes(): ArrayList<CountryDto> {
            val countries = ArrayList<CountryDto>()
            repeat(10) {
                countries.add(getFake())
            }
            return countries
        }

        fun getPopularFakes(): ArrayList<CountryDto> {
            val countries = ArrayList<CountryDto>()
            repeat(10) {
                countries.add(getPopularFake())
            }
            return countries
        }

    }
}
