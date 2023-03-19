package ui.auth.getEmail

import ui.base.BaseEvent

sealed class GetEmailEvent : BaseEvent() {
    data class NavToGetPassword(val email: String) : GetEmailEvent()
    data class NavToSignUp(val email: String) : GetEmailEvent()
}