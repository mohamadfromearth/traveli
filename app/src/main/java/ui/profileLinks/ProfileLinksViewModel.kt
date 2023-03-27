package ui.profileLinks

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject


@HiltViewModel
class ProfileLinksViewModel @Inject constructor(app:ApplicationClass):BaseViewModel<ProfileLinksEvent,ProfileLinksAction>(app),ProfileLinksAction {
}