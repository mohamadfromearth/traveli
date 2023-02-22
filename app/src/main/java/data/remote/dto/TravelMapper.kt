package data.remote.dto

import domain.model.Travel
import main.ApplicationClass
import util.EntityMapper
import javax.inject.Inject

class TravelMapper @Inject constructor(
    private val travelDetailMapper: TravelDetailMapper,
    private val cityMapper: CityMapper,
    private val countryMapper: CountryMapper,
    private val userPreviewMapper: UserPreviewMapper,
    private val tagMapper: TagMapper,
    private val app: ApplicationClass,
) : EntityMapper<TravelDto, Travel> {

    override fun toDomainModel(dto: TravelDto): Travel {
        return Travel(
            dto.id,
            dto.name,
            app.getBaseUrl() + dto.cover,
            countryMapper.toDomainModel(dto.country),
            dto.isBookmarked,
            dto.price.toString(),
            dto.details.map { travelDetailMapper.toDomainModel(it) }.toMutableList(),
            dto.cityList.map { cityMapper.toDomainModel(it) },
            dto.tagList.map { tagMapper.toDomainModel(it) },
            userPreviewMapper.toDomainModel(dto.user),
            dto.isOwned,
            dto.price == 0L
        )
    }

    override fun toEntity(model: Travel): TravelDto {
        return TravelDto(
            model.id,
            model.name,
            model.cover,
            countryMapper.toEntity(model.country),
            model.price.toLong(),
            model.details.map { travelDetailMapper.toEntity(it) },
            model.cityList.map { cityMapper.toEntity(it) },
            model.tagList.map { tagMapper.toEntity(it) },
            userPreviewMapper.toEntity(model.user),
            model.isBookmarked,
            model.isOwned,
        )
    }

}