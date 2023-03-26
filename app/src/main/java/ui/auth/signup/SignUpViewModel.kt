package ui.auth.signup

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<SignUpEvent,SignUpAction>(app),SignUpAction {
    override fun onContinueClick(email:String) {
        viewModelScope.launch {
            _event.send(SignUpEvent.NavToEmailSent(email))
        }
    }
}