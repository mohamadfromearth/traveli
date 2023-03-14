package ui.destinations

import ui.base.BaseEvent

sealed class DestinationsEvent : BaseEvent() {
    data class NavToDestinations(val pageName: String) : DestinationsEvent()
}