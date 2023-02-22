package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class DeleteTravelUseCase(private val travelRepo: TraveliRepository) {

    operator fun invoke(travelId: Long) = flow {
        emit(DataState.Loading)
        delay(500)
        emit(travelRepo.deleteTravel(travelId))
    }
}