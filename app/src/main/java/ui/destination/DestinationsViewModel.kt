package ui.destination

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationsViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<DestinationsEvent, DestinationsAction>(app), DestinationsAction {
}