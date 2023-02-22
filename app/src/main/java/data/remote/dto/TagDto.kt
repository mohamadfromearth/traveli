package data.remote.dto

data class TagDto(val id: Long, val name: String) {
    companion object {
        fun getFake() =
            listOf(
                TagDto(0L, "tehran"),
                TagDto(0L, "tehran"),
                TagDto(0L, "tehran"),
                TagDto(0L, "tehran"),
                TagDto(0L, "tehran")

            )
    }
}
