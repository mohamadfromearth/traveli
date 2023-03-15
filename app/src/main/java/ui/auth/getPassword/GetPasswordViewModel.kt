package ui.auth.getPassword

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GetPasswordViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<GetPasswordEvent, GetPasswordAction>(app) {



}