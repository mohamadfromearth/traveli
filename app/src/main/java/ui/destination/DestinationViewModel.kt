package ui.destination

import androidx.lifecycle.viewModelScope
import com.xodus.traveli.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<DestinationEvent, DestinationAction>(app), DestinationAction {
    val previousPageName = MutableStateFlow("")

    override fun onStart(previousPageName: String) {
        this.previousPageName.value = previousPageName
    }

    override fun onBackPress() {
        viewModelScope.launch {
            _event.send(DestinationEvent.NavBack)
        }
    }
}