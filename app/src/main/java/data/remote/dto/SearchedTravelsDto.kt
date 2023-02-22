package data.remote.dto

data class SearchedTravelsDto(
    val has_next_page: Boolean,
    val travels: List<TravelPreviewDto>
)