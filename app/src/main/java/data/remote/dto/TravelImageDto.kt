package data.remote.dto

data class TravelImageDto(
    val imageUrl: String
) {
    companion object {
        fun getFake() = TravelImageDto("")
    }
}
