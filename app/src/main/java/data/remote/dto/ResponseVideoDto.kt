package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseVideoDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val VideoUrlDto: VideoUrlDto,
) {
    companion object {
        fun getFake() = ResponseVideoDto("success", MetaDto.getFake(), VideoUrlDto.getFake())
    }
}