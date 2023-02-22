package domain.usecase.travel

import data.remote.DataState
import domain.repository.TraveliRepository
import kotlinx.coroutines.flow.flow

class UploadFileUseCase(private val traveliRepository: TraveliRepository) {


    operator fun invoke(filePath: String, travelId: Long) = flow {
        emit(DataState.Loading)
        emit(traveliRepository.uploadFile(filePath, travelId))
    }

}