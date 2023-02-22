package domain.usecase.city

import data.remote.DataState
import domain.repository.MiscRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCitiesOfCountryUseCase(private val repo: MiscRepository) {

    operator fun invoke(countryId: Long) = flow {
        emit(DataState.Loading)
        emit(repo.getCitiesOfCountry(countryId))
    }.flowOn(Dispatchers.IO)

}