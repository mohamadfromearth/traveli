package ui.travelsList

import ui.base.BaseEvent

sealed class TravelsListEvent : BaseEvent() {
    object NavBack : TravelsListEvent()
}
