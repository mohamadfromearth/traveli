package ui.travels

import ui.base.BaseEvent
import ui.travelsList.TravelsListType

sealed class TravelsEvent : BaseEvent() {
    // navigation
    data class NavToTravelsList(val travelsListType: TravelsListType) : TravelsEvent()
}