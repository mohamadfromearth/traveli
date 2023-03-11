package ui.travels

import domain.model.Travel
import ui.base.BaseEvent
import ui.travelsList.TravelsListType

sealed class TravelsEvent : BaseEvent() {
    // navigation
    data class NavToTravelsList(val travelsListType: TravelsListType) : TravelsEvent()
    data class NavToGuidesList(val title: String) : TravelsEvent()
}