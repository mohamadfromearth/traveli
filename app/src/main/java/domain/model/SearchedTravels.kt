package domain.model

data class SearchedTravels(
    val hasNextPage: Boolean,
    val travelPreviewList: List<TravelPreview>
)
