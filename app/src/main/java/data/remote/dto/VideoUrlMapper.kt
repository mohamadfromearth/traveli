package data.remote.dto

import domain.model.VideoUrl
import util.EntityMapper
import javax.inject.Inject

class VideoUrlMapper @Inject constructor() : EntityMapper<VideoUrlDto, VideoUrl> {
    override fun toDomainModel(dto: VideoUrlDto): VideoUrl {
        return VideoUrl(dto.videoUri)
    }

    override fun toEntity(model: VideoUrl): VideoUrlDto {
        return VideoUrlDto(model.videoUrl)
    }
}