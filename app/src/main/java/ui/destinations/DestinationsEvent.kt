package ui.destinations

import ui.base.BaseEvent

sealed class DestinationsEvent : BaseEvent() {
    object NavToDestinations : DestinationsEvent()
}