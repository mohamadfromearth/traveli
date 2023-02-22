package data.remote.dto

data class VideoUrlDto(val videoUri: String) {
    companion object {
        fun getFake() = VideoUrlDto("")
    }
}
