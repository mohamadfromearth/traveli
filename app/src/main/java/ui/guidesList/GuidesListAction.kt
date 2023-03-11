package ui.guidesList

import ui.base.BaseAction

interface GuidesListAction : BaseAction {
    fun onStart(title: String)
    fun onBackPress()
}