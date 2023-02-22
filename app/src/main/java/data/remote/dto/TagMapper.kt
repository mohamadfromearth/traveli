package data.remote.dto

import domain.model.Tag
import util.EntityMapper
import javax.inject.Inject

class TagMapper @Inject constructor() : EntityMapper<TagDto, Tag> {
    override fun toEntity(model: Tag): TagDto {
        return TagDto(model.id, model.tag)
    }

    override fun toDomainModel(dto: TagDto): Tag {
        return Tag(dto.id, dto.name)
    }
}