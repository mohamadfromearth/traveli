package ui.destinations

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationsViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<DestinationsEvent, DestinationsAction>(app), DestinationsAction {
    override fun onDestinationItemClick() {
        viewModelScope.launch {
            _event.send(DestinationsEvent.NavToDestinations(app.m.destinations))
        }
    }
}