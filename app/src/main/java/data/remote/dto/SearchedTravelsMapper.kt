package data.remote.dto

import domain.model.SearchedTravels
import util.EntityMapper
import javax.inject.Inject

class SearchedTravelsMapper @Inject constructor(
    private val travelPreviewMapper: TravelPreviewMapper
) : EntityMapper<SearchedTravelsDto, SearchedTravels> {
    override fun toDomainModel(dto: SearchedTravelsDto): SearchedTravels {
        return SearchedTravels(dto.has_next_page, travelPreviewMapper.fromEntityList(dto.travels))
    }

    override fun toEntity(model: SearchedTravels): SearchedTravelsDto {
        TODO("Not yet implemented")
    }
}