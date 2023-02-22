package data.remote.dto

import domain.model.UserInfo
import util.EntityMapper
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val contactMapper: ContactMapper,
    private val countryMapper: CountryMapper,
    private val cityMapper: CityMapper,
) : EntityMapper<UserInfoDto, UserInfo> {

    override fun toDomainModel(dto: UserInfoDto): UserInfo {
        return UserInfo(
            dto.id,
            dto.name,
            dto.avatar,
            dto.bio,
            dto.headerImage,
            dto.balance.toString(),
            countryMapper.toDomainModel(dto.country),
            cityMapper.toDomainModel(dto.city),
            "${dto.city.name}, ${dto.country.name}",
            contactMapper.toDomainModel(dto.contact)
        )
    }

    override fun toEntity(model: UserInfo): UserInfoDto =
        UserInfoDto(
            model.id,
            model.name,
            model.avatar,
            model.bio,
            model.headerImage,
            model.balance.toDouble(),
            countryMapper.toEntity(model.country),
            cityMapper.toEntity(model.city),
            contactMapper.toEntity(model.contact)
        )

    fun fromEntityList(dtoList: ArrayList<UserInfoDto>): ArrayList<UserInfo> =
        ArrayList(dtoList.map { toDomainModel(it) })
}