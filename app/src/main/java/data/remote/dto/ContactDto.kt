package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ContactDto(
    @SerializedName("phone") var phone: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("twitter") var twitter: String?,
    @SerializedName("instagram") var instagram: String?,
    @SerializedName("website") var website: String?,
) {
    companion object {
        fun getFake(): ContactDto {
            return ContactDto(
                "0123456789",
                "test@gmail.com",
                null,
                null,
                null,
            )
        }

        fun getFakeList(size: Int = 10): ArrayList<ContactDto> {
            val list = arrayListOf<ContactDto>()
            repeat(size) {
                list.add(getFake())
            }
            return list
        }
    }
}