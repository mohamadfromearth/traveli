package ui.guide

import ui.base.BaseEvent

sealed class GuideEvent : BaseEvent() {
    object NavBack : GuideEvent()
}