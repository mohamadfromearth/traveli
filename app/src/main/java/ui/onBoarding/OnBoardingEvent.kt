package ui.onBoarding

import ui.base.BaseEvent

sealed class OnBoardingEvent:BaseEvent(){

    data class UpdatePage(val sideBarColor:Int):OnBoardingEvent()

}
