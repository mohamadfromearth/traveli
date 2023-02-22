package domain.usecase.tag

import data.remote.DataState
import domain.repository.MiscRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CreateTagUseCase(private val miscRepository: MiscRepository) {

    operator fun invoke(name: String) = flow {
        emit(DataState.Loading)
        emit(miscRepository.createTag(name))
    }.flowOn(Dispatchers.IO)
}