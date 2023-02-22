package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PublicTravelUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long) = flow {
        emit(DataState.Loading)
        emit(repo.publishTravel(travelId))
    }.flowOn(Dispatchers.IO)


}