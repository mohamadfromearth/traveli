package ui.destination

import ui.base.BaseEvent

sealed class DestinationEvent : BaseEvent() {
    object NavBack : DestinationEvent()
}