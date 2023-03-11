package ui.guidesList

import ui.base.BaseEvent

sealed class GuidesListEvent : BaseEvent() {

    object NavBack : GuidesListEvent()
}