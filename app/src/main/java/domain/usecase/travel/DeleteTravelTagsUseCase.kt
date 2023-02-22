package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DeleteTravelTagsUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, tags: List<Long>) = flow {
        emit(DataState.Loading)
        emit(repo.deleteTravelTags(travelId, tags))
    }.flowOn(Dispatchers.IO)
}