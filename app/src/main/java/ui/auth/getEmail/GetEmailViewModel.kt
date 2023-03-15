package ui.auth.getEmail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GetEmailViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<GetEmailEvent, GetEmailAction>(app), GetEmailAction {
    override fun onContinueClick(email: String) {
        viewModelScope.launch {
            _event.send(GetEmailEvent.NavToGetPassword(email))
        }
    }
}