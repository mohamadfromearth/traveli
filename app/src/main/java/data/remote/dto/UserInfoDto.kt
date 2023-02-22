package data.remote.dto

import com.google.gson.annotations.SerializedName

import kotlin.random.Random

data class UserInfoDto(
    @SerializedName("id") var id: Long,
    @SerializedName("name") var name: String?,
    @SerializedName("avatar") var avatar: String?,
    @SerializedName("bio") var bio: String?,
    @SerializedName("header_image") var headerImage: String?,
    @SerializedName("balance") val balance: Double,
    @SerializedName("country") var country: CountryDto,
    @SerializedName("city") var city: CityDto,
    @SerializedName("contact") var contact: ContactDto,
) {

    companion object {

        fun getFake(userId: Long? = null): UserInfoDto {
            return UserInfoDto(
                userId ?: Random.nextLong(2, 10000),
                "Denis Trico",
                "https://upload.wikimedia.org/wikipedia/commons/2/23/Dennis_Ritchie_2011.jpg",
                "Travel opens you up to so many incredible experiences, and while there’s a whole lot more of the world I’d still like to see, and this is certainly not the definitive list of best travel experiences, I’d like to share with you some of my most amazing experiences and those I think deserve a spot on every traveler’s bucket list.",
                "https://www.thewanderinglens.com/wp-content/uploads/2016/11/MARSEILLE01.jpg",
                0.0,
                CountryDto.getFake(),
                CityDto.getFake(),
                ContactDto.getFake(),
            )
        }

        fun getFakeList(size: Int = 10): ArrayList<UserInfoDto> {
            val list = arrayListOf<UserInfoDto>()
            repeat(size) {
                list.add(getFake())
            }
            return list
        }
    }
}