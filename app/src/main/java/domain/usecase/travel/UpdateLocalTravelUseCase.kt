package domain.usecase.travel

import domain.model.Travel
import domain.repository.TraveliRepository

class UpdateLocalTravelUseCase(private val traveliRepo: TraveliRepository) {
    suspend operator fun invoke(travel: Travel) = traveliRepo.updateLocalTravel(travel)
}