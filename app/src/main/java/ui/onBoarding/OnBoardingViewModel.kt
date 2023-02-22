package ui.onBoarding

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<OnBoardingEvent,OnBoardingAction>(app) {
}