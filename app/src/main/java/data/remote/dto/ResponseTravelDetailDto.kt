package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseTravelDetailDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val travel: TravelDto,
) {


    companion object {
        fun getFake() = ResponseTravelDetailDto("success", MetaDto.getFake(), TravelDto.getFake())
        fun getFakeForCreate() = ResponseTravelDetailDto("success", MetaDto.getFake(), TravelDto.getFakeForCreate())
    }


}
