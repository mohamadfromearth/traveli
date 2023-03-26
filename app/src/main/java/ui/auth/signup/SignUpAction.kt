package ui.auth.signup

import ui.base.BaseAction

interface SignUpAction : BaseAction {
    fun onContinueClick(email: String)
}