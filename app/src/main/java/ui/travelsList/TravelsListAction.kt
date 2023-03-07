package ui.travelsList

import ui.base.BaseAction

interface TravelsListAction : BaseAction {
    fun onStart(travelsListType: TravelsListType)
    fun onBackPress()
}