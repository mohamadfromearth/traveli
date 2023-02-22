package domain.usecase.tag

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class GetTagsUseCase(private val repo: TraveliRepository) {

    operator fun invoke() = flow {
        emit(DataState.Loading)
        emit(repo.getTags())

    }.flowOn(Dispatchers.IO)

}