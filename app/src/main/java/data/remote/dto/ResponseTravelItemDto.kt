package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseTravelItemDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val data: TravelItemDto
) {

    companion object {
        fun getFake() = ResponseTravelItemDto("", MetaDto.getFake(), TravelItemDto.getFake())
    }

}
