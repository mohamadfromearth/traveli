package data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseUploadFileDto(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("status") val status: String,
    @SerializedName("data") val fileDto: FileDto,
)
