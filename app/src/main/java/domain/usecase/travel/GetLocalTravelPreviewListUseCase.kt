package domain.usecase.travel

import domain.repository.TraveliRepository

class GetLocalTravelPreviewListUseCase(private val traveliRepo: TraveliRepository) {
    operator fun invoke() = traveliRepo.getLocalTravelPreviewList()
}