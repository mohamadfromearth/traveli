package domain.usecase.travel

import domain.model.TravelItem
import domain.repository.TraveliRepository

class DeleteLocalTravelItemUseCase(private val traveliRepo: TraveliRepository) {
    suspend operator fun invoke(travelId: Long, travelItem: TravelItem) {
        traveliRepo.deleteLocalTravelItem(travelId, travelItem)
    }

}