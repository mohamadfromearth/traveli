package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseSearchTravelDto(

    @SerializedName("meta") val meta: Meta,
    @SerializedName("status") val status: String,
    @SerializedName("data") val searchedTravelsDto: SearchedTravelsDto,
)

