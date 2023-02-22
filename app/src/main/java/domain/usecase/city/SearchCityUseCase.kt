package domain.usecase.city

import data.remote.DataState
import domain.model.City
import domain.repository.MiscRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchCityUseCase(private val repo: MiscRepository) {

    operator fun invoke(query: String) = flow<DataState<List<City>>> {
        emit(DataState.Loading)
        delay(500)
        emit(repo.searchCity(query))
    }.flowOn(Dispatchers.IO)
}