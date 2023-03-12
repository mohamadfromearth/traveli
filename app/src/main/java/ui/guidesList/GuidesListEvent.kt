package ui.guidesList

import ui.base.BaseEvent

sealed class GuidesListEvent : BaseEvent() {
    object NavBack : GuidesListEvent()
    data class NavToGuide(val id: Long,val pageName:String) : GuidesListEvent()
}