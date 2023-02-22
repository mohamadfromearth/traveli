package domain.model

data class SearchedUsers(
    val hasNextPage: Boolean,
    val users: List<UserPreview>
)
