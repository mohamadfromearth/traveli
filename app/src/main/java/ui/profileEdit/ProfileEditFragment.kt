package ui.profileEdit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import coil.size.Scale
import com.xodus.traveli.R
import com.xodus.traveli.databinding.FragmentProfileEditBinding
import dagger.hilt.android.AndroidEntryPoint
import ui.base.BaseFragment

@AndroidEntryPoint
class ProfileEditFragment : BaseFragment<FragmentProfileEditBinding, ProfileEditEvent, ProfileEditAction, ProfileEditViewModel>(R.layout.fragment_profile_edit) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ProfileEditViewModel by viewModels()
        initialize(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivProfile.load("https://static.wikia.nocookie.net/moviedatabase/images/8/8c/Tony_Stark.jpg/revision/latest?cb=20150430161420") {
            scale(Scale.FIT)
        }
    }
}