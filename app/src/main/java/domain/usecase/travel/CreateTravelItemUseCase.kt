package domain.usecase.travel

import data.remote.DataState
import domain.model.TravelItem
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CreateTravelItemUseCase(private val travelRepo: TraveliRepository) {

    operator fun invoke(travelId: Long, travelItem: TravelItem, isSummary: Int) = flow {
        emit(DataState.Loading)
        emit(travelRepo.createTravelItem(travelId, travelItem, isSummary))
    }.flowOn(Dispatchers.IO)

}