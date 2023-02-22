package domain.usecase.travel

import data.remote.DataState
import domain.model.Travel
import domain.model.TravelItem
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UpdateTravelUseCase(private val repo: TraveliRepository) {


    operator fun invoke(travel: Travel) = flow {
        emit(DataState.Loading)

        when (val result = repo.updateTravel(travel)) {
            is DataState.Success -> {
                val cover = TravelItem.Cover(result.data.name, result.data.cover)
                result.data.details.add(0, cover)
                emit(result)
            }
            else                 -> emit(result)
        }

    }.flowOn(Dispatchers.IO)

}