package ui.auth.signup

import ui.base.BaseEvent

sealed class SignUpEvent : BaseEvent() {
    data class NavToEmailSent(val email: String) : SignUpEvent()
    data class NavToGuideLines(val email: String) : SignUpEvent()
}