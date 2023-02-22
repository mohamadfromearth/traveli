package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DeleteTravelItemUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, travelItemId: Long) = flow<DataState<Unit>> {
        emit(DataState.Loading)
        emit(repo.deleteTravelItem(travelId, travelItemId))
    }.flowOn(Dispatchers.IO)

}