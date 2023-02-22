package domain.usecase.country

import data.remote.DataState
import domain.model.Country
import domain.repository.MiscRepository
import kotlinx.coroutines.flow.flow

class SearchCountryUseCase(private val repo: MiscRepository) {


    operator fun invoke(query: String) = flow<DataState<List<Country>>> {
        emit(DataState.Loading)
        emit(repo.searchCountries(query))
    }

}