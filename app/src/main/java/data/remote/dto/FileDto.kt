package data.remote.dto

data class FileDto(
    val created_at: String,
    val id: Int,
    val path: String,
    val travel_id: String,
    val type: String,
    val updated_at: String
)