package ui.profile

import ui.base.BaseEvent

sealed class ProfileEvent : BaseEvent() {
    object NavToEditProfile : ProfileEvent()
}