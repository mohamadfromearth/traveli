package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseTagDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val data: List<TagDto>,
) {
    companion object {
        fun getFakes() = ResponseTagDto(
            "success",
            MetaDto.getFake(),
            TagDto.getFake()
        )
    }
}