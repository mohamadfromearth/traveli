package domain.model

class TravelImage(
    val imageUrl: String
) {
    companion object {
        fun getFake() = TravelImage("")
    }
}