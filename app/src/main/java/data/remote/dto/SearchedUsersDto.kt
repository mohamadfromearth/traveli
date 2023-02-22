package data.remote.dto

import com.google.gson.annotations.SerializedName

data class SearchedUsersDto(
    @SerializedName("users")
    val userPreviewList: List<UserPreviewDto>,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean,
)
