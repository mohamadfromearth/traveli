package domain.usecase.travel

import domain.model.TravelItem
import domain.repository.TraveliRepository

class CreateLocalTravelItemUseCase(private val traveliRepo: TraveliRepository) {
    suspend operator fun invoke(travelId: Long, travelItem: TravelItem) = traveliRepo.createLocalTravelItem(travelId, travelItem)
}