package domain.usecase.travel

import data.remote.DataState
import domain.model.TravelItem
import domain.model.TravelItem.Companion.DEFAULT_ID
import domain.repository.TraveliRepository
import domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetTravelDetailUseCase(private val traveliRepo: TraveliRepository, private val userRepository: UserRepository) {


    operator fun invoke(travelId: Long) = flow {
        emit(DataState.Loading)
        when (val result = traveliRepo.getTravelDetail(travelId)) {
            is DataState.Failure -> emit(DataState.Failure(result.code, result.message))
            DataState.Loading    -> emit(DataState.Loading)
            is DataState.Success -> {
                val details = result.data.details
                details.add(0, TravelItem.User(result.data.user.id, result.data.user))
                details.add(0, TravelItem.Cover(result.data.name, result.data.cover))
                if (result.data.cityList.isNotEmpty()) details.add(TravelItem.City(result.data.cityList))
                if (result.data.tagList.isNotEmpty()) details.add(TravelItem.Tag(result.data.tagList))
                if (result.data.isFree) {
                    details.add(TravelItem.BookMark(DEFAULT_ID, result.data.isBookmarked))
                } else {
                    if (result.data.user.id == userRepository.getMyUserId()) {
                        details.add(TravelItem.BookMark(DEFAULT_ID, result.data.isBookmarked))
                    } else {
                        details.add(TravelItem.BuyAndBookMark(result.data.price, result.data.isBookmarked))
                    }

                }
                emit(result)
            }
        }
    }.flowOn(Dispatchers.IO)


}