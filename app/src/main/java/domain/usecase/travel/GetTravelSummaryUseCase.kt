package domain.usecase.travel

import data.remote.DataState
import domain.model.TravelItem
import domain.repository.TraveliRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetTravelSummaryUseCase(private val traveliRepo: TraveliRepository) {
    operator fun invoke(travelId: Long) = flow<DataState<List<TravelItem>>> {
        emit(DataState.Loading)
        when (val result = traveliRepo.getTravelSummary(travelId)) {
            is DataState.Failure -> emit(DataState.Failure(result.code, result.message))
            DataState.Loading    -> emit(DataState.Loading)
            is DataState.Success -> {
                val details = result.data.details
                details.add(0, TravelItem.User(-1, result.data.user))
                details.add(0, TravelItem.Cover(result.data.name, result.data.cover))
                details.add(TravelItem.City(result.data.cityList))
                details.add(TravelItem.Tag(result.data.tagList))
                details.add(TravelItem.BuyAndBookMark(result.data.price, result.data.isBookmarked))

                emit(DataState.Success(details))
            }
        }
    }.flowOn(Dispatchers.IO)
}