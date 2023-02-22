package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.flow

class ToggleBookmarkUseCase(private val repo: TraveliRepository) {


    operator fun invoke(travelId: Long) = flow {
        emit(DataState.Loading)
        emit(repo.toggleBookmark(travelId))
    }
}