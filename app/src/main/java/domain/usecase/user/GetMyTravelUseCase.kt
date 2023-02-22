package domain.usecase.user

import domain.repository.UserRepository
import kotlinx.coroutines.flow.flow

class GetMyTravelUseCase(private val repo: UserRepository) {


    operator fun invoke() = flow {
        emit(repo.getMyTravelList())
    }
}