package ui.auth.signup

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<SignUpEvent,SignUpAction>(app) {
}