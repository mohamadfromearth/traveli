package ui.destination

import ui.base.BaseAction

interface DestinationAction : BaseAction {
    fun onStart(previousPageName: String)
    fun onBackPress()
}