package domain.usecase.travel

import domain.repository.TraveliRepository

class GetLocalTravelItemListUseCase(private val traveliRepo: TraveliRepository) {


    suspend operator fun invoke(travelId: Long) = traveliRepo.getLocalTravelItemList(travelId)
}