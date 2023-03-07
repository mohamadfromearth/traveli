package ui.travelsList

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TravelsListViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<TravelsListEvent, TravelsListAction>(app) {


}