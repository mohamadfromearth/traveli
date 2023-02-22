package domain.usecase.travel

import data.remote.DataState
import domain.model.TravelItem
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.flow

class UpdateTravelItemUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, travelItem: TravelItem) = flow {
        emit(DataState.Loading)
        emit(repo.updateTravelItem(travelId, travelItem))
    }
}