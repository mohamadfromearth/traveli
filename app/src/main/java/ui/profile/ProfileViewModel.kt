package ui.profile

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import ui.travels.TravelsEvent
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<ProfileEvent, ProfileAction>(app), ProfileAction {
    override fun onEditClick() {
        viewModelScope.launch {
            _event.send(ProfileEvent.NavToEditProfile)
        }
    }
}