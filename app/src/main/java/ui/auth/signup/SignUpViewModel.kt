package ui.auth.signup

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SignUpViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<SignUpEvent,SignUpAction>(app),SignUpAction {
    override fun onContinueClick(email:String) {
        viewModelScope.launch {
            val random = Random.nextInt(0,2)


            when(random){
                0 -> _event.send(SignUpEvent.NavToEmailSent(email))
                1 -> _event.send(SignUpEvent.NavToGuideLines(email))
            }


        }
    }
}