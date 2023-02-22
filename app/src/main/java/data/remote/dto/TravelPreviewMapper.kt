package data.remote.dto

import domain.model.TravelPreview
import util.EntityMapper
import javax.inject.Inject

class TravelPreviewMapper @Inject constructor() : EntityMapper<TravelPreviewDto, TravelPreview> {
    override fun toDomainModel(dto: TravelPreviewDto): TravelPreview {
        return TravelPreview(
            id = dto.id,
            name = dto.name,
            image = dto.cover,
            isFree = dto.price <= 0,
            price = dto.price,
            status = dto.status,
            views = dto.views

        )
    }

    override fun toEntity(model: TravelPreview): TravelPreviewDto {
        return TravelPreviewDto(
            id = model.id,
            name = model.name,
            cover = model.image,
            price = model.price,
            status = model.status,
            views = model.views,
            0,
            0

        )
    }

    fun fromEntityList(dtoList: List<TravelPreviewDto>): List<TravelPreview> =
        dtoList.map { toDomainModel(it) }
}