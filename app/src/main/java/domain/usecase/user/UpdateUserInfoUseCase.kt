package domain.usecase.user

import data.remote.DataState
import domain.model.UserInfo
import domain.repository.UserRepository
import kotlinx.coroutines.flow.flow
import main.ApplicationClass
import util.PrefManager
import util.extension.authorize

class UpdateUserInfoUseCase(private val app: ApplicationClass, private val repo: UserRepository, private val prefManager: PrefManager) {

    operator fun invoke(userInfo: UserInfo) = flow {
        emit(DataState.Loading)
        prefManager.authorize({
            //check for length and empty values
            when (val response = repo.updateUserInfo(userInfo)) {
                is DataState.Loading -> emit(response)
                is DataState.Failure -> emit(response)
                is DataState.Success -> {
                    app.userInfo = response.data
                    emit(response)
                }
            }
        }, {
            emit(DataState.Failure(DataState.Failure.CODE_NOT_FOUND, app.m.pleaseLoginToDoThisAction))
        })
    }
}