package ui.auth.emailsent


import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class EmailSentViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<EmailSentEvent,EmailSentAction>(app) {



}