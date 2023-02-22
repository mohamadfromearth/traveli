package domain.usecase.country

import data.remote.DataState
import domain.repository.MiscRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPopularCountryListUseCase(private val repo: MiscRepository) {

    operator fun invoke() = flow {
        emit(DataState.Loading)
        val result = repo.getPopularCountries()
        emit(result)
    }.flowOn(Dispatchers.IO)
}