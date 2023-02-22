package data.remote.dto

import domain.model.SearchedUsers
import util.EntityMapper
import javax.inject.Inject

class SearchedUsersMapper @Inject constructor(
    private val userPreviewMapper: UserPreviewMapper
) : EntityMapper<SearchedUsersDto, SearchedUsers> {
    override fun toDomainModel(dto: SearchedUsersDto): SearchedUsers {
        return SearchedUsers(dto.hasNextPage, dto.userPreviewList.map { userPreviewMapper.toDomainModel(it) })
    }

    override fun toEntity(model: SearchedUsers): SearchedUsersDto {
        return SearchedUsersDto(model.users.map { userPreviewMapper.toEntity(it) }, model.hasNextPage)
    }


}