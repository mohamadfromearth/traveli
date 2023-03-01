package ui.travels

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TravelsViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<TravelsEvent, TravelsAction>(app) {
}