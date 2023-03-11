package ui.travels

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import main.ApplicationClass
import ui.base.BaseViewModel
import ui.travelsList.TravelsListType
import javax.inject.Inject

@HiltViewModel
class TravelsViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<TravelsEvent, TravelsAction>(app), TravelsAction {
    override fun onMostPopularSeeAllClick() {
        viewModelScope.launch {
            _event.send(TravelsEvent.NavToTravelsList(TravelsListType.MOST_POPULAR))
        }
    }

    override fun onJustArrivedSeeAllClick() {
        viewModelScope.launch {
            _event.send(TravelsEvent.NavToTravelsList(TravelsListType.NEWEST_TRAVELS))
        }
    }

    override fun onTopGuidesSeeAllClick() {
        viewModelScope.launch {
            _event.send(TravelsEvent.NavToGuidesList(app.m.topGuides))
        }
    }
}