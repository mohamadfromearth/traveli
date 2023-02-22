package domain.usecase.user

import data.remote.DataState
import domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetDraftUseCase(private val repo: UserRepository) {


    operator fun invoke() = flow {
        emit(DataState.Loading)
        delay(500)
        emit(repo.getDrafts())
    }


}