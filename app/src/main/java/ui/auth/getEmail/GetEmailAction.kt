package ui.auth.getEmail

import ui.base.BaseAction

interface GetEmailAction : BaseAction {
    fun onContinueClick(email: String)
}