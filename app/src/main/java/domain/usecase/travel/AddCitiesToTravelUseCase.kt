package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.flow

class AddCitiesToTravelUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, citiesId: List<Long>) = flow {
        emit(DataState.Loading)
        emit(repo.addCitiesToTravel(travelId, citiesId))

    }


}