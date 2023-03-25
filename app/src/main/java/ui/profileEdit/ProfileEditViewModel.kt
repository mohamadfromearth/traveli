package ui.profileEdit

import dagger.hilt.android.lifecycle.HiltViewModel
import main.ApplicationClass
import ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(app: ApplicationClass) : BaseViewModel<ProfileEditEvent, ProfileEditAction>(app) {



}