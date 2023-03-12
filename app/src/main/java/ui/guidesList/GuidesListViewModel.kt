package ui.guidesList

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GuidesListViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<GuidesListEvent, GuidesListAction>(app), GuidesListAction {
    // bind
    val title = MutableStateFlow("")

    override fun onStart(title: String) {
        this.title.value = title
    }

    override fun onBackPress() {
        viewModelScope.launch {
            _event.send(GuidesListEvent.NavBack)
        }
    }

    override fun onItemClick(pos: Int) {
        viewModelScope.launch {
            _event.send(GuidesListEvent.NavToGuide(-1, app.m.guides))
        }
    }
}