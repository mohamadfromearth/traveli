package ui.guide

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<GuideEvent, GuideAction>(app), GuideAction {
    //bind
    val previousPageName = MutableStateFlow("")

    override fun onStart(previousPageName: String) {
        this.previousPageName.value = previousPageName
    }

    override fun onBackPress() {
        viewModelScope.launch {
            _event.send(GuideEvent.NavBack)
        }
    }
}