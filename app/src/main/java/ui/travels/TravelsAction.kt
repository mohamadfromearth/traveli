package ui.travels

import ui.base.BaseAction

interface TravelsAction : BaseAction {
    // click
    fun onMostPopularSeeAllClick()
    fun onJustArrivedSeeAllClick()

    fun onTopGuidesSeeAllClick()
}