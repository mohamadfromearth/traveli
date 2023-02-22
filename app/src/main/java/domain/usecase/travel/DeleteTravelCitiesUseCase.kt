package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DeleteTravelCitiesUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, cities: List<Long>) = flow {
        emit(DataState.Loading)
        emit(repo.deleteTravelCities(travelId, cities))
    }.flowOn(Dispatchers.IO)

}