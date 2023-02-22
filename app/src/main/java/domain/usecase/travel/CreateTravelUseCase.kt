package domain.usecase.travel

import data.remote.DataState
import domain.model.Country
import domain.model.TravelItem
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CreateTravelUseCase(private val repo: TraveliRepository) {


    operator fun invoke(cover: TravelItem.Cover, country: Country) = flow {
        emit(DataState.Loading)
        emit(repo.createTravel(cover, country))
    }.flowOn(Dispatchers.IO)
}