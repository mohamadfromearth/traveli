package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseCreateTagDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val data: TagDto
)
