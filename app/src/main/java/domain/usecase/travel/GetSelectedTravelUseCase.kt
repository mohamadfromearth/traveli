package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetSelectedTravelUseCase(private val repo: TraveliRepository) {

    operator fun invoke(type: String? = null, country: String? = null, userId: Long? = null, page: Int) = flow {
        emit(DataState.Loading)
        emit(repo.getSelectedTravel(type, country, userId, page))
    }.flowOn(Dispatchers.IO)
}