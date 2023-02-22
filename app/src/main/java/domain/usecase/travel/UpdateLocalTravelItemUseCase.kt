package domain.usecase.travel

import domain.model.TravelItem
import domain.repository.TraveliRepository

class UpdateLocalTravelItemUseCase(private val traveliRepo: TraveliRepository) {
    suspend operator fun invoke(travelId: Long, travelItem: TravelItem) {
        traveliRepo.updateLocalTravelItem(travelId, travelItem)
    }
}