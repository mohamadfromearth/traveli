package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.flow

class AddTagsToTravelUseCase(private val repo: TraveliRepository) {

    operator fun invoke(travelId: Long, tags: List<Long>) = flow {
        emit(DataState.Loading)
        emit(repo.addTagsToTravel(travelId, tags))
    }
}