package ui.auth.guideLines

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GuideLinesViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<GuideLinesEvent,GuideLinesAction>(app) {



}