package domain.usecase.travel

import domain.model.Country
import domain.model.TravelItem
import domain.repository.TraveliRepository

class CreateLocalTravelUseCase(private val repository: TraveliRepository) {

    suspend operator fun invoke(cover: TravelItem.Cover, country: Country) = repository.createLocalTravel(cover, country)

}