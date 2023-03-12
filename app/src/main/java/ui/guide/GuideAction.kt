package ui.guide

import ui.base.BaseAction

interface GuideAction : BaseAction {
    fun onStart(previousPageName: String)

    fun onBackPress()
}