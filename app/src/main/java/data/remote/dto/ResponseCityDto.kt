package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseCityDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val data: List<CityDto>,
) {

    companion object {
        suspend fun getFake() = ResponseCityDto("success", MetaDto.getFake(), CityDto.getFakes())
    }
}