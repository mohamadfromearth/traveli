package data.remote.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ResponseCreateTravelDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("data") val travel: JsonObject,
)