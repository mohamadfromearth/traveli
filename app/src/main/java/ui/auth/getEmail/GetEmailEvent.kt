package ui.auth.getEmail

import ui.base.BaseEvent

sealed class GetEmailEvent : BaseEvent() {
    data class NavToGetPassword(val email: String) : GetEmailEvent()
}