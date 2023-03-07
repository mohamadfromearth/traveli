package ui.travelsList

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TravelsListViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<TravelsListEvent, TravelsListAction>(app), TravelsListAction {
    //local
    private lateinit var travelsListType: TravelsListType

    //bind
    val title = MutableStateFlow("")

    override fun onStart(travelsListType: TravelsListType) {
        this.travelsListType = travelsListType
        when (travelsListType) {
            TravelsListType.MOST_POPULAR   -> title.value = app.m.mostPopular
            TravelsListType.NEWEST_TRAVELS -> title.value = app.m.justArrived
        }
    }

    override fun onBackPress() {
        viewModelScope.launch {
            _event.send(TravelsListEvent.NavBack)
        }
    }
}